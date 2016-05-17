package it.unibz.inf.ontop.executor.join;

import java.util.Optional;
import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.executor.NodeCentricInternalExecutor;
import it.unibz.inf.ontop.model.ImmutableExpression;
import it.unibz.inf.ontop.pivotalrepr.impl.InnerJoinNodeImpl;
import it.unibz.inf.ontop.pivotalrepr.proposal.impl.NodeCentricOptimizationResultsImpl;
import it.unibz.inf.ontop.pivotalrepr.impl.QueryTreeComponent;
import it.unibz.inf.ontop.pivotalrepr.proposal.impl.ReactToChildDeletionProposalImpl;
import it.unibz.inf.ontop.pivotalrepr.*;
import it.unibz.inf.ontop.pivotalrepr.proposal.*;

import static it.unibz.inf.ontop.executor.join.JoinExtractionUtils.*;

/**
* TODO: explain
*/
public class JoinBooleanExpressionExecutor implements NodeCentricInternalExecutor<InnerJoinNode, InnerJoinOptimizationProposal> {

    /**
     * Standard method (InternalProposalExecutor)
     */
    @Override
    public NodeCentricOptimizationResults<InnerJoinNode> apply(InnerJoinOptimizationProposal proposal, IntermediateQuery query,
                                              QueryTreeComponent treeComponent)
            throws InvalidQueryOptimizationProposalException, EmptyQueryException {

        InnerJoinNode originalTopJoinNode = proposal.getFocusNode();

        /**
         * Will remain the sames, whatever happens
         */
        Optional<QueryNode> optionalParent = query.getParent(originalTopJoinNode);
        Optional<QueryNode> optionalNextSibling = query.getNextSibling(originalTopJoinNode);

        /**
         * Optimizes
         */
        Optional<InnerJoinNode> optionalNewJoinNode = transformJoin(originalTopJoinNode, query, treeComponent);

        if (optionalNewJoinNode.isPresent()) {
            return new NodeCentricOptimizationResultsImpl<>(query, optionalNewJoinNode.get());
        }
        else {
            ReactToChildDeletionProposal reactionProposal = new ReactToChildDeletionProposalImpl(originalTopJoinNode,
                    optionalParent.get(), optionalNextSibling);

            ReactToChildDeletionResults deletionResults = query.applyProposal(reactionProposal);

            return new NodeCentricOptimizationResultsImpl<>(deletionResults.getResultingQuery(),
                    deletionResults.getOptionalNextSibling(), java.util.Optional.of(deletionResults.getClosestRemainingAncestor()));
        }
    }

    /**
     * TODO: explain
     */
    private Optional<InnerJoinNode> transformJoin(InnerJoinNode topJoinNode, IntermediateQuery query,
                                          QueryTreeComponent treeComponent) {


        ImmutableList<JoinOrFilterNode> filterOrJoinNodes = extractFilterAndInnerJoinNodes(topJoinNode, query);

        Optional<ImmutableExpression> optionalAggregatedFilterCondition;
        try {
            optionalAggregatedFilterCondition = extractFoldAndOptimizeBooleanExpressions(filterOrJoinNodes,
                    query.getMetadata());
        }
        /**
         * The filter condition can be satisfied --> the join node and its sub-tree is thus removed from the tree.
         * Returns no join node.
         */
        catch (UnsatisfiableExpressionException e) {
            treeComponent.removeSubTree(topJoinNode);
            return Optional.empty();
        }

        InnerJoinNode newJoinNode = new InnerJoinNodeImpl(optionalAggregatedFilterCondition);

        QueryNode parentNode = treeComponent.getParent(topJoinNode).get();
        Optional<NonCommutativeOperatorNode.ArgumentPosition> optionalPosition = treeComponent.getOptionalPosition(parentNode, topJoinNode);
        treeComponent.replaceNodesByOneNode(ImmutableList.<QueryNode>copyOf(filterOrJoinNodes), newJoinNode, parentNode, optionalPosition);

        return Optional.of(newJoinNode);
    }



}
