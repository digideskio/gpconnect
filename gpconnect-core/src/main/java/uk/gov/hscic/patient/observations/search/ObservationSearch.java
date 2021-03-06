package uk.gov.hscic.patient.observations.search;

import java.util.List;

import uk.gov.hscic.common.repo.Repository;
import uk.gov.hscic.patient.observations.model.ObservationListHTML;

/**
 */
public interface ObservationSearch extends Repository {

    List<ObservationListHTML> findAllObservationHTMLTables(String patientId);

}
