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
package org.jboss.arquillian.warp;

import org.jboss.arquillian.warp.proxy.AssertionExecution;

/**
 * Utility class for invoking client action followed by server request, enriched with assertion.
 * 
 * @author Lukas Fryc
 */
public class Warp {

    /**
     * Takes client action which should be fired in order to cause server request.
     * 
     * @param action the client action to execute
     * @return {@link AssertionExecution} instance
     */
    public static AssertionExecution execute(ClientAction action) {
        return new AssertionExecution(action);
    }
}
