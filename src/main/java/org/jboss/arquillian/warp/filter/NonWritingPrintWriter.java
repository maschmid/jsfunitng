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
package org.jboss.arquillian.warp.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;

/**
 * The implementation {@link PrintWriter} which caches all the written input and writes only when
 * {@link #finallyWriteAndClose(ServletOutputStream)} method is called.
 * 
 * @author Lukas Fryc
 * 
 */
public class NonWritingPrintWriter extends PrintWriter {

    private ByteArrayOutputStream baos;
    private boolean wasClosed = false;

    private NonWritingPrintWriter(ByteArrayOutputStream baos) {
        super(baos);
        this.baos = baos;
    }

    public static NonWritingPrintWriter newInstance() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        return new NonWritingPrintWriter(baos);
    }

    @Override
    public void close() {
        wasClosed = true;
    }

    void finallyWriteAndClose(ServletOutputStream delegateStream) throws IOException {
        this.flush();
        baos.flush();
        
        byte[] byteArray = baos.toByteArray();

        delegateStream.write(byteArray);
        
        if (wasClosed) {
            super.close();
        }
    }
}