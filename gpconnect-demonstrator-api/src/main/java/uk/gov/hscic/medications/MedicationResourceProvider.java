package uk.gov.hscic.medications;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.resource.Medication;
import ca.uhn.fhir.model.dstu2.resource.OperationOutcome;
import ca.uhn.fhir.model.dstu2.valueset.IssueSeverityEnum;
import ca.uhn.fhir.model.primitive.IdDt;
import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.server.IResourceProvider;
import ca.uhn.fhir.rest.server.exceptions.InternalErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.gov.hscic.medication.model.MedicationDetails;
import uk.gov.hscic.medication.search.MedicationSearch;

@Component
public class MedicationResourceProvider implements IResourceProvider {

    @Autowired
    MedicationSearch medicationSearch;
    
    @Override
    public Class<Medication> getResourceType() {
        return Medication.class;
    }

    @Read()
    public Medication getMedicationById(@IdParam IdDt medicationId) {
        
        MedicationDetails medicationDetails = medicationSearch.findMedicationByID(medicationId.getIdPartAsLong());
        
        if (medicationDetails == null) {
            OperationOutcome operationalOutcome = new OperationOutcome();
            operationalOutcome.addIssue().setSeverity(IssueSeverityEnum.ERROR).setDetails("No medication details found for ID: " + medicationId.getIdPart());
            throw new InternalErrorException("No medication details found for ID: " + medicationId.getIdPart(), operationalOutcome);
        }
        
        Medication medication = new Medication();
        CodingDt coding = new CodingDt();
        coding.setSystem("http://snomed.info/sct");
        coding.setCode(medicationDetails.getId());
        coding.setDisplay(medicationDetails.getName());
        CodeableConceptDt codableConcept = new CodeableConceptDt();
        codableConcept.addCoding(coding);
        medication.setCode(codableConcept);
        medication.setId(medicationDetails.getId());
        medication.getMeta().setLastUpdated(medicationDetails.getLastUpdated());
        medication.getMeta().setVersionId(String.valueOf(medicationDetails.getLastUpdated().getTime()));
        return medication;
    }
}
