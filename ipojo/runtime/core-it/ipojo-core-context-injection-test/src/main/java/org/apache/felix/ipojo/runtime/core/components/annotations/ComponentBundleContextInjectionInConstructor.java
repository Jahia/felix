/*
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements.  See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership.  The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.apache.felix.ipojo.runtime.core.components.annotations;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Context;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.runtime.core.services.CheckService;
import org.osgi.framework.BundleContext;

import java.util.HashMap;
import java.util.Map;

/**
 * A component using constructor injection to retrieve the bundle context.
 */
@Component
@Provides
public class ComponentBundleContextInjectionInConstructor implements CheckService {


    private BundleContext context;

    /**
     * @param context no parameter, as component is the default.
     */
    public ComponentBundleContextInjectionInConstructor(@Context BundleContext context) {
        this.context = context;
    }

    @Override
    public boolean check() {
        return context != null;
    }

    @Override
    public Map map() {
        Map<String, BundleContext> map = new HashMap<String, BundleContext>();
        if (context != null) {
            map.put("context", context);
        }
        return map;
    }
}
