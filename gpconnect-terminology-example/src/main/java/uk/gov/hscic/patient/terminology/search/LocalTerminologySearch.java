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
package uk.gov.hscic.patient.terminology.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import uk.gov.hscic.common.types.RepoSourceType;
import uk.gov.hscic.patient.terminology.model.Terminology;
import uk.gov.hscic.patient.terminology.search.TerminologySearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@PropertySource("classpath:terminology.properties")
public class LocalTerminologySearch implements TerminologySearch {

    @Value("${local.terminology.priority:1000}")
    private int priority;

    @Autowired
    private Environment localTerminologyResources;

    @Override
    public RepoSourceType getSource() {
        return RepoSourceType.TERMINOLOGY;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public List<Terminology> findTerms(final String type) {
        final String[] keyList = StringUtils.split(localTerminologyResources.getProperty(type + ".type"), ",");

        final List<Terminology> terminologyList = new ArrayList<>();

        for (final String key : keyList) {
            final String code = localTerminologyResources.getProperty(key + ".code");
            final String text = localTerminologyResources.getProperty(key + ".text");

            terminologyList.add(new Terminology(code, text));
        }

        return terminologyList;
    }
}
