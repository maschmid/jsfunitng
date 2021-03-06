/*
 * JBoss, Home of Professional Open Source
 * Copyright 2009, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.arquillian.warp.assertion;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.jboss.arquillian.core.spi.Validate;

/**
 * The registry for registered assertions registered for current requests.
 * 
 * @author Lukas Fryc
 */
public class AssertionRegistry {

    private Set<Object> assertions = new LinkedHashSet<Object>(1);

    public void registerAssertion(Object assertion) {
        Validate.notNull(assertion, "assertion must not be null");
        assertions.add(assertion);
    }

    public void unregisterAssertion(Object assertion) {
        Validate.notNull(assertion, "assertion must not be null");
        assertions.remove(assertion);
    }

    public Collection<Object> getAssertions() {
        return assertions;
    }
}
