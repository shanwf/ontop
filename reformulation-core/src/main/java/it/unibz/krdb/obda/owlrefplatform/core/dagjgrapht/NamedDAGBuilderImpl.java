package it.unibz.krdb.obda.owlrefplatform.core.dagjgrapht;

import it.unibz.krdb.obda.ontology.Description;
import it.unibz.krdb.obda.ontology.OClass;
import it.unibz.krdb.obda.ontology.OntologyFactory;
import it.unibz.krdb.obda.ontology.Property;
import it.unibz.krdb.obda.ontology.impl.OntologyFactoryImpl;
import it.unibz.krdb.obda.owlrefplatform.core.dag.DAGNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.EdgeReversedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.GraphIterator;

/** Build a DAG with only the named descriptions */

public class NamedDAGBuilderImpl implements NamedDAGBuilder {

	private Set<OClass> namedClasses;
	private Set<Property> property;

	private Map<Description, Set<Description>> equivalencesMap = new HashMap<Description, Set<Description>>();

	private Map<Description, Description> replacements = new HashMap<Description, Description>();;
	DAGImpl namedDag;

	private TBoxReasonerImpl reasoner;
	private static final OntologyFactory descFactory = new OntologyFactoryImpl();

	public NamedDAGBuilderImpl(DAG dag) {

		namedDag = new DAGImpl(DefaultEdge.class);

		// clone all the vertexes and edges from dag

		for (Description v : ((DAGImpl) dag).vertexSet()) {
			namedDag.addVertex(v);
		}
		for (DefaultEdge e : ((DAGImpl) dag).edgeSet()) {
			Description s = ((DAGImpl) dag).getEdgeSource(e);
			Description t = ((DAGImpl) dag).getEdgeTarget(e);

			namedDag.addEdge(s, t, e);
		}

		reasoner = new TBoxReasonerImpl(dag);
		// take classes, roles, equivalences map and replacements from the DAG
		namedClasses = dag.getClasses();
		property = dag.getRoles();

		// clone the equivalences and replacements map
		Map<Description, Set<Description>> equivalencesDag = dag
				.getMapEquivalences();
		Map<Description, Description> replacementsDag = dag.getReplacements();
		for (Description vertex : equivalencesDag.keySet()) {
			

				HashSet<Description> equivalents = new HashSet<Description>();
				for (Description equivalent : equivalencesDag.get(vertex)) {
					equivalents.add(equivalent);
				}
				equivalencesMap.put(vertex, new HashSet<Description>(
						equivalents));
			

		}
		for (Description eliminateNode : replacementsDag.keySet()) {

			Description referent = replacementsDag.get(eliminateNode);
			replacements.put(eliminateNode, referent);

		}

		GraphIterator<Description, DefaultEdge> orderIterator;

		//test with a reversed graph so that the smallest index will be given to the higher ancestor
		DirectedGraph<Description, DefaultEdge> reversed =
				new EdgeReversedGraph<Description, DefaultEdge>((DAGImpl)dag);

		LinkedList<Description> roots = new LinkedList<Description>();
		for (Description n : reversed.vertexSet()) {
			if ((reversed.incomingEdgesOf(n)).isEmpty()) {
				roots.add(n);
			}
		}
		Set<Description >processedNodes= new HashSet<Description>();
		
		for (Description root: roots){
		//A depth first sort 
		orderIterator =
				new DepthFirstIterator<Description, DefaultEdge>(reversed, root);
		while (orderIterator.hasNext()) 
		{
			Description node= orderIterator.next();
			if(processedNodes.contains(node))
				continue;
			if (namedClasses.contains(node) | property.contains(node)) {
				
				processedNodes.add(node);
				continue;
			}
			
			if(node instanceof Property)
			{
				Property posNode = descFactory.createProperty(((Property)node).getPredicate(), false);
				if(processedNodes.contains(posNode))
				{
					Set<DefaultEdge> incomingEdges = new HashSet<DefaultEdge>(
							namedDag.incomingEdgesOf(node));

					// I do a copy of the dag not to remove edges that I still need to
					// consider in the loops
					DAGImpl copyDAG = (DAGImpl) namedDag.clone();
					Set<DefaultEdge> outgoingEdges = new HashSet<DefaultEdge>(
							copyDAG.outgoingEdgesOf(node));
					for (DefaultEdge incEdge : incomingEdges) {

						Description source = namedDag.getEdgeSource(incEdge);
						namedDag.removeAllEdges(source, node);

						for (DefaultEdge outEdge : outgoingEdges) {
							Description target = copyDAG.getEdgeTarget(outEdge);
							namedDag.removeAllEdges(node, target);

							if (source.equals(target))
								continue;
							namedDag.addEdge(source, target);
						}

					}

					namedDag.removeVertex(node);
					processedNodes.add(node);
					
					
				
					continue;
				}
			}
			
			Set<Description> namedEquivalences = reasoner.getEquivalences(node,true);
			if(!namedEquivalences.isEmpty())
			{
				Description newReference= namedEquivalences.iterator().next();
				 replacements.remove(newReference);
				 namedDag.addVertex(newReference);
				
				 Set<Description> allEquivalences = reasoner.getEquivalences(node,
							false);
				 Iterator<Description> e= allEquivalences.iterator();
				 while(e.hasNext()){
					 Description vertex =e.next();
				 
					 if(vertex.equals(newReference))
						 continue;
				 
				 replacements.put(vertex, newReference);
				 }
				 
				 /*
					 * Re-pointing all links to and from the eliminated node to the
					 new
					 * representative node
					 */
					
					 Set<DefaultEdge> edges = new
					 HashSet<DefaultEdge>(namedDag.incomingEdgesOf(node));
					 for (DefaultEdge incEdge : edges) {
					 Description source = namedDag.getEdgeSource(incEdge);
					 namedDag.removeAllEdges(source, node);
					
					 if (source.equals(newReference))
					 continue;
					
					 namedDag.addEdge(source, newReference);
					 }
					
					 edges = new
					 HashSet<DefaultEdge>(namedDag.outgoingEdgesOf(node));
					 for (DefaultEdge outEdge : edges) {
					 Description target = namedDag.getEdgeTarget(outEdge);
					 namedDag.removeAllEdges(node, target);
					
					 if (target.equals(newReference))
					 continue;
					 namedDag.addEdge(newReference, target);
					 }
					
					 namedDag.removeVertex(node);
					 processedNodes.add(node);
					 
					 /*remove the invertex*/
					 
					 if(node instanceof Property)
						{
							Property posNode = descFactory.createProperty(((Property)node).getPredicate(), false);
							
								Set<DefaultEdge> incomingEdges = new HashSet<DefaultEdge>(
										namedDag.incomingEdgesOf(posNode));

								// I do a copy of the dag not to remove edges that I still need to
								// consider in the loops
								DAGImpl copyDAG = (DAGImpl) namedDag.clone();
								Set<DefaultEdge> outgoingEdges = new HashSet<DefaultEdge>(
										copyDAG.outgoingEdgesOf(posNode));
								for (DefaultEdge incEdge : incomingEdges) {

									Description source = namedDag.getEdgeSource(incEdge);
									namedDag.removeAllEdges(source, posNode);

									for (DefaultEdge outEdge : outgoingEdges) {
										Description target = copyDAG.getEdgeTarget(outEdge);
										namedDag.removeAllEdges(posNode, target);

										if (source.equals(target))
											continue;
										namedDag.addEdge(source, target);
									}

								}

								namedDag.removeVertex(posNode);
								
								
							
								continue;
							}
					 
					 	
			}
			else{
				Set<DefaultEdge> incomingEdges = new HashSet<DefaultEdge>(
						namedDag.incomingEdgesOf(node));

				// I do a copy of the dag not to remove edges that I still need to
				// consider in the loops
				DAGImpl copyDAG = (DAGImpl) namedDag.clone();
				Set<DefaultEdge> outgoingEdges = new HashSet<DefaultEdge>(
						copyDAG.outgoingEdgesOf(node));
				for (DefaultEdge incEdge : incomingEdges) {

					Description source = namedDag.getEdgeSource(incEdge);
					namedDag.removeAllEdges(source, node);

					for (DefaultEdge outEdge : outgoingEdges) {
						Description target = copyDAG.getEdgeTarget(outEdge);
						namedDag.removeAllEdges(node, target);

						if (source.equals(target))
							continue;
						namedDag.addEdge(source, target);
					}

				}

				namedDag.removeVertex(node);
				processedNodes.add(node);
			}
			
		}
		
		}
		

		namedDag.setMapEquivalences(equivalencesMap);
		namedDag.setReplacements(replacements);
		namedDag.setIsaNamedDAG(true);

	}

	

	@Override
	public DAGImpl getDAG() {
		return namedDag;
	}

}
