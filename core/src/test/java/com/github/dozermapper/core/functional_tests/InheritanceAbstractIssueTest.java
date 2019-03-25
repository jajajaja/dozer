/*
 * Copyright 2005-2019 Dozer Project
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
package com.github.dozermapper.core.functional_tests;

import com.github.dozermapper.core.vo.inheritance.abstractissue.A;
import com.github.dozermapper.core.vo.inheritance.abstractissue.B;
import com.github.dozermapper.core.vo.inheritance.abstractissue.C;
import com.github.dozermapper.core.vo.inheritance.abstractissue.S;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InheritanceAbstractIssueTest extends AbstractFunctionalTest {

    @Override
    @Before
    public void setUp() throws Exception {
        mapper = getMapper("mappings/inheritanceAbstractIssue.xml");
    }

    @Test
    public void testMapping_ABC() {
        S source = newInstance(S.class);
        source.setA("A");
        source.setB("B");
        source.setC("C");

        A destinationA = mapper.map(source, A.class);
        B destinationB = mapper.map(source, B.class);
        C destinationC = mapper.map(source, C.class);

        assertEquals("A", destinationA.getA());
        assertEquals("B", destinationB.getB());
        assertEquals("C", destinationC.getC());
    }

    @Test
    public void testMapping_CBA() {
        S source = newInstance(S.class);
        source.setA("A");
        source.setB("B");
        source.setC("C");

        C destinationC = mapper.map(source, C.class);
        B destinationB = mapper.map(source, B.class);
        A destinationA = mapper.map(source, A.class);

        assertEquals("A", destinationA.getA());
        assertEquals("B", destinationB.getB());
        assertEquals("C", destinationC.getC());
    }

    @Test
    public void testMapping_CAB() {
        S source = newInstance(S.class);
        source.setA("A");
        source.setB("B");
        source.setC("C");

        C destinationC = mapper.map(source, C.class);
        A destinationA = mapper.map(source, A.class);
        B destinationB = mapper.map(source, B.class);

        assertEquals("A", destinationA.getA());
        assertEquals("B", destinationB.getB());
        assertEquals("C", destinationC.getC());
    }

}
