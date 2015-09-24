/*
 * Copyright 2015 Ripple OSI
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.rippleosi.patient.careplans.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.rippleosi.common.service.AbstractListQueryStrategy;
import org.rippleosi.patient.careplans.model.CarePlanSummary;

/**
 */
public class CarePlanSummaryQueryStrategy extends AbstractListQueryStrategy<CarePlanSummary> {

    CarePlanSummaryQueryStrategy(String patientId) {
        super(patientId);
    }

    @Override
    public String getQuery(String ehrId) {
        return "select a/uid/value as uid, " +
                "a/context/start_time/value as date_created " +
                "from EHR e[ehr_id/value='" + ehrId + "'] " +
                "contains COMPOSITION a[openEHR-EHR-COMPOSITION.care_plan.v1] " +
                "contains SECTION b_a[openEHR-EHR-SECTION.legal_information_rcp.v1] " +
                "where a/name/value='End of Life Patient Preferences'";
    }

    @Override
    public List<CarePlanSummary> transform(List<Map<String, Object>> resultSet) {
        return CollectionUtils.collect(resultSet, new CarePlanSummaryTransformer(), new ArrayList<>());
    }
}
