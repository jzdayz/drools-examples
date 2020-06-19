/*
 * Copyright 2010 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.examples.helloworld;

import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a sample file to launch a rule package from a rule source file.
 */
public class Ex {

    public static final void main(final String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        execute( kc );
    }

    public static void execute( KieContainer kc ) {
        KieSession ksession = kc.newKieSession("HelloWorldKS");
        ksession.addEventListener( new DebugAgendaEventListener() );
        ksession.addEventListener( new DebugRuleRuntimeEventListener() );
        Map<String,Object> map  = new HashMap<>();
        map.put("type",ParamType.NONE_PROJECT_PROCUREMENT.getCode());
        map.put("money",100_0000);
        map.put("open",true);
        ksession.insert( map );


        ksession.getAgenda().getAgendaGroup(RuleType.PACT_ADD_UPDATE_BACK.getVal()).setFocus();
        ksession.fireAllRules();
        System.out.println(map);
        ksession.dispose();
    }

}
