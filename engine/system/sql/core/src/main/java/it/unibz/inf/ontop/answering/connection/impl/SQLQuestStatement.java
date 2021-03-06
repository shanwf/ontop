package it.unibz.inf.ontop.answering.connection.impl;

import java.util.Optional;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedSet;
import it.unibz.inf.ontop.answering.reformulation.input.*;
import it.unibz.inf.ontop.answering.resultset.impl.*;
import it.unibz.inf.ontop.answering.resultset.BooleanResultSet;
import it.unibz.inf.ontop.answering.resultset.SimpleGraphResultSet;
import it.unibz.inf.ontop.answering.resultset.TupleResultSet;
import it.unibz.inf.ontop.exception.*;
import it.unibz.inf.ontop.injection.OntopSystemSQLSettings;
import it.unibz.inf.ontop.answering.resultset.impl.PredefinedBooleanResultSet;

import it.unibz.inf.ontop.answering.reformulation.QueryReformulator;
import it.unibz.inf.ontop.iq.IQ;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.iq.UnaryIQTree;
import it.unibz.inf.ontop.iq.exception.EmptyQueryException;
import it.unibz.inf.ontop.iq.node.ConstructionNode;
import it.unibz.inf.ontop.iq.node.NativeNode;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.term.Variable;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.TypeFactory;
import it.unibz.inf.ontop.substitution.SubstitutionFactory;
import org.apache.commons.rdf.api.RDF;

import java.sql.*;
import java.sql.ResultSet;

/**
 * SQL-specific implementation of OBDAStatement.
 * Derived from QuestStatement.
 */
public class SQLQuestStatement extends QuestStatement {

    private final Statement sqlStatement;
    private final TermFactory termFactory;
    private final TypeFactory typeFactory;
    private final RDF rdfFactory;
    private final SubstitutionFactory substitutionFactory;
    private final OntopSystemSQLSettings settings;

    public SQLQuestStatement(QueryReformulator queryProcessor, Statement sqlStatement,
                             InputQueryFactory inputQueryFactory,
                             TermFactory termFactory, TypeFactory typeFactory,
                             RDF rdfFactory, SubstitutionFactory substitutionFactory,
                             OntopSystemSQLSettings settings) {
        super(queryProcessor, inputQueryFactory);
        this.sqlStatement = sqlStatement;
        this.termFactory = termFactory;
        this.typeFactory = typeFactory;
        this.rdfFactory = rdfFactory;
        this.substitutionFactory = substitutionFactory;
        this.settings = settings;
    }

    @Override
    public int getFetchSize() throws OntopConnectionException {
        try {
            return sqlStatement.getFetchSize();
        } catch (SQLException e) {
            throw new OntopConnectionException(e);
        }

    }

    @Override
    public int getMaxRows() throws OntopConnectionException {
        try {
            return sqlStatement.getMaxRows();
        } catch (SQLException e) {
            throw new OntopConnectionException(e);
        }

    }

    @Override
    public void getMoreResults() throws OntopConnectionException {
        try {
            sqlStatement.getMoreResults();
        } catch (SQLException e) {
            throw new OntopConnectionException(e);
        }

    }

    @Override
    public void setFetchSize(int rows) throws OntopConnectionException {
        try {
            sqlStatement.setFetchSize(rows);
        } catch (SQLException e) {
            throw new OntopConnectionException(e);
        }

    }

    @Override
    public void setMaxRows(int max) throws OntopConnectionException {
        try {
            sqlStatement.setMaxRows(max);
        } catch (SQLException e) {
            throw new OntopConnectionException(e);
        }

    }

    @Override
    public void setQueryTimeout(int seconds) throws OntopConnectionException {
        try {
            sqlStatement.setQueryTimeout(seconds);
        } catch (SQLException e) {
            throw new OntopConnectionException(e);
        }
    }

    @Override
    public int getQueryTimeout() throws OntopConnectionException {
        try {
            return sqlStatement.getQueryTimeout();
        } catch (SQLException e) {
            throw new OntopConnectionException(e);
        }
    }

    @Override
    public boolean isClosed() throws OntopConnectionException {
        try {
            return sqlStatement.isClosed();
        } catch (SQLException e) {
            throw new OntopConnectionException(e);
        }
    }

    /**
     * Returns the number of tuples returned by the query
     */
    @Override
    public int getTupleCount(InputQuery inputQuery) throws OntopReformulationException, OntopQueryEvaluationException {
        IQ targetQuery = getExecutableQuery(inputQuery);
        try {
            String sql = extractSQLQuery(targetQuery);
            String newsql = "SELECT count(*) FROM (" + sql + ") t1";
            if (!isCanceled()) {
                try {

                    java.sql.ResultSet set = sqlStatement.executeQuery(newsql);
                    if (set.next()) {
                        return set.getInt(1);
                    } else {
                        //throw new OBDAException("Tuple count failed due to empty result set.");
                        return 0;
                    }
                } catch (SQLException e) {
                    throw new OntopQueryEvaluationException(e);
                }
            } else {
                throw new OntopQueryEvaluationException("Action canceled.");
            }
        } catch (EmptyQueryException e) {
            return 0;
        }
    }

    @Override
    public void close() throws OntopConnectionException {
        try {
            if (sqlStatement != null)
                sqlStatement.close();
        } catch (SQLException e) {
            throw new OntopConnectionException(e);
        }
    }

    protected void cancelExecution() throws OntopQueryEvaluationException {
        try {
            sqlStatement.cancel();
        } catch (SQLException e) {
            throw new OntopQueryEvaluationException(e);
        }
    }

    @Override
    protected BooleanResultSet executeBooleanQuery(IQ executableQuery)
            throws OntopQueryEvaluationException {
        try {
            String sqlQuery = extractSQLQuery(executableQuery);
            try {
                java.sql.ResultSet set = sqlStatement.executeQuery(sqlQuery);
                return new SQLBooleanResultSet(set);
            } catch (SQLException e) {
                throw new OntopQueryEvaluationException(e.getMessage());
            }
        } catch (EmptyQueryException e) {
            return new PredefinedBooleanResultSet(false);
        }
    }

    @Override
    protected TupleResultSet executeSelectQuery(IQ executableQuery)
            throws OntopQueryEvaluationException {
        try {
            String sqlQuery = extractSQLQuery(executableQuery);
            ConstructionNode constructionNode = extractRootConstructionNode(executableQuery);
            NativeNode nativeNode = extractNativeNode(executableQuery);
            ImmutableSortedSet<Variable> signature = nativeNode.getVariables();
            ImmutableMap<Variable, DBTermType> typeMap = nativeNode.getTypeMap();
            try {
                java.sql.ResultSet set = sqlStatement.executeQuery(sqlQuery);
                return settings.isDistinctPostProcessingEnabled()
                        ? new DistinctJDBCTupleResultSet(set, signature, typeMap, constructionNode, executableQuery.getProjectionAtom(), termFactory, substitutionFactory)
                        : new JDBCTupleResultSet(set, signature, typeMap, constructionNode, executableQuery.getProjectionAtom(), termFactory, substitutionFactory);
            } catch (SQLException e) {
                throw new OntopQueryEvaluationException(e);
            }
        } catch (EmptyQueryException e) {
            return new EmptyTupleResultSet(executableQuery.getProjectionAtom().getArguments());
        }
    }

    @Override
    protected SimpleGraphResultSet executeGraphQuery(ConstructQuery inputQuery, IQ executableQuery, boolean collectResults)
            throws OntopQueryEvaluationException, OntopResultConversionException, OntopConnectionException {
        TupleResultSet tuples;
        try {
            String sqlQuery = extractSQLQuery(executableQuery);
            ConstructionNode constructionNode = extractRootConstructionNode(executableQuery);
            NativeNode nativeNode = extractNativeNode(executableQuery);
            ImmutableSortedSet<Variable> SQLSignature = nativeNode.getVariables();
            ImmutableMap<Variable, DBTermType> SQLTypeMap = nativeNode.getTypeMap();
            try {
                ResultSet rs = sqlStatement.executeQuery(sqlQuery);
                tuples = new JDBCTupleResultSet(rs, SQLSignature, SQLTypeMap, constructionNode,
                        executableQuery.getProjectionAtom(), termFactory, substitutionFactory);
            } catch (SQLException e) {
                throw new OntopQueryEvaluationException(e.getMessage());
            }
        } catch (EmptyQueryException e) {
            tuples = new EmptyTupleResultSet(executableQuery.getProjectionAtom().getArguments());
        }
        return new DefaultSimpleGraphResultSet(tuples, inputQuery.getConstructTemplate(), collectResults, termFactory, rdfFactory);
    }

    private NativeNode extractNativeNode(IQ executableQuery) throws EmptyQueryException {
        IQTree tree = executableQuery.getTree();
        if (tree.isDeclaredAsEmpty()) {
            throw new EmptyQueryException();
        }
        return Optional.of(tree)
                .filter(t -> t instanceof UnaryIQTree)
                .map(t -> ((UnaryIQTree)t).getChild().getRootNode())
                .filter(n -> n instanceof NativeNode)
                .map(n -> (NativeNode) n)
                .orElseThrow(() -> new MinorOntopInternalBugException("The query does not have the expected structure " +
                        "for an executable query\n" + executableQuery));
    }

    private String extractSQLQuery(IQ executableQuery) throws EmptyQueryException, OntopInternalBugException {
        IQTree tree = executableQuery.getTree();
        if  (tree.isDeclaredAsEmpty())
            throw new EmptyQueryException();

        String queryString = Optional.of(tree)
                .filter(t -> t instanceof UnaryIQTree)
                .map(t -> ((UnaryIQTree)t).getChild().getRootNode())
                .filter(n -> n instanceof NativeNode)
                .map(n -> (NativeNode) n)
                .map(NativeNode::getNativeQueryString)
                .orElseThrow(() -> new MinorOntopInternalBugException("The query does not have the expected structure " +
                        "of an executable query\n" + executableQuery));

        if (queryString.equals(""))
            throw new EmptyQueryException();

        return queryString;
    }

    private ConstructionNode extractRootConstructionNode(IQ executableQuery) throws EmptyQueryException, OntopInternalBugException {
        IQTree tree = executableQuery.getTree();
        if  (tree.isDeclaredAsEmpty())
            throw new EmptyQueryException();

        return Optional.of(tree.getRootNode())
                .filter(n -> n instanceof ConstructionNode)
                .map(n -> (ConstructionNode)n)
                .orElseThrow(() -> new MinorOntopInternalBugException(
                        "The \"executable\" query is not starting with a construction node\n" + executableQuery));
    }
}
