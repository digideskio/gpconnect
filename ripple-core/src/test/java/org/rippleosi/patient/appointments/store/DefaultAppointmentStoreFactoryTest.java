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
package org.rippleosi.patient.appointments.store;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.rippleosi.common.repo.AbstractRepositoryFactoryTest;

/**
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultAppointmentStoreFactoryTest extends AbstractRepositoryFactoryTest<AppointmentStoreFactory, AppointmentStore> {

    @Override
    protected AppointmentStoreFactory createRepositoryFactory() {
        return new DefaultAppointmentStoreFactory();
    }

    @Override
    protected Class<AppointmentStore> getRepositoryClass() {
        return AppointmentStore.class;
    }
}
