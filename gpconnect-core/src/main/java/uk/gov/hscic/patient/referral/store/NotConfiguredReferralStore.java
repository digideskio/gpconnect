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
package uk.gov.hscic.patient.referral.store;

import uk.gov.hscic.common.exception.ConfigurationException;
import uk.gov.hscic.common.types.RepoSourceType;
import uk.gov.hscic.patient.referral.model.ReferralDetails;

/**
 */
public class NotConfiguredReferralStore implements ReferralStore {

    @Override
    public RepoSourceType getSource() {
        return RepoSourceType.NONE;
    }

    @Override
    public int getPriority() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void create(String patientId, ReferralDetails referral) {
        throw ConfigurationException.unimplementedTransaction(ReferralStore.class);
    }

    @Override
    public void update(String patientId, ReferralDetails referral) {
        throw ConfigurationException.unimplementedTransaction(ReferralStore.class);
    }

}
