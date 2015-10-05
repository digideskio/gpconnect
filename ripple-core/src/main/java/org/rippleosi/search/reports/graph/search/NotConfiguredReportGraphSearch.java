package org.rippleosi.search.reports.graph.search;

import java.util.List;

import org.rippleosi.common.exception.ConfigurationException;
import org.rippleosi.search.reports.graph.model.ReportGraphPatientSummary;
import org.rippleosi.search.reports.graph.model.ReportGraphQuery;

public class NotConfiguredReportGraphSearch implements ReportGraphSearch {

    @Override
    public String getSource() {
        return "not configured";
    }

    @Override
    public int getPriority() {
        return Integer.MAX_VALUE;
    }

    @Override
    public List<ReportGraphPatientSummary> findAllPatientsByQuery(ReportGraphQuery query) {
        throw ConfigurationException.unimplementedTransaction(ReportGraphSearch.class);
    }
}