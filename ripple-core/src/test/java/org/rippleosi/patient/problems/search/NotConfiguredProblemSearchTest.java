package org.rippleosi.patient.problems.search;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.rippleosi.common.exception.ConfigurationException;

/**
 */
public class NotConfiguredProblemSearchTest {

    private NotConfiguredProblemSearch problemSearch;

    @Before
    public void setUp() throws Exception {
        problemSearch = new NotConfiguredProblemSearch();
    }

    @Test
    public void shouldReportAsNotConfiguredImplementation() {
        assertEquals("not configured", problemSearch.getSource());
    }

    @Test(expected = ConfigurationException.class)
    public void shouldThrowExceptionWhenTryingToFindProblemHeadlines() {
        problemSearch.findProblemHeadlines(null);
    }

    @Test(expected = ConfigurationException.class)
    public void shouldThrowExceptionWhenTryingToFindAllProblems() {
        problemSearch.findAllProblems(null);
    }

    @Test(expected = ConfigurationException.class)
    public void shouldThrowExceptionWhenTryingToFindProblemDetails() {
        problemSearch.findProblem(null, null);
    }
}
