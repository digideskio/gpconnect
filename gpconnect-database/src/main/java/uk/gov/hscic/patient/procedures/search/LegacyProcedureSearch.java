package uk.gov.hscic.patient.procedures.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gov.hscic.common.service.AbstractLegacyService;
import uk.gov.hscic.patient.procedures.model.ProcedureListHTML;
import uk.gov.hscic.patient.procedures.model.ProcedureEntity;
import uk.gov.hscic.patient.procedures.repo.ProcedureRepository;

import java.util.Collections;
import java.util.List;

@Service
public class LegacyProcedureSearch extends AbstractLegacyService implements ProcedureSearch {

    @Autowired
    private ProcedureRepository procedureRepository;

    private final ProcedureEntityToListTransformer transformer = new ProcedureEntityToListTransformer();

    @Override
    public List<ProcedureListHTML> findAllProceduresHTMLTables(final String patientId) {

        final ProcedureEntity item = procedureRepository.findOne(Long.parseLong(patientId));

        if(item == null){
            return null;
        } else {
            return Collections.singletonList(transformer.transform(item));
        }
    }
}
