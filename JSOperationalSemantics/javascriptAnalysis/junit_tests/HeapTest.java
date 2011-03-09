/*******************************************************************************
 * Copyright 2011 Sruthi Bandhakavi
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package javascriptAnalysis.junit_tests;

import javascriptAnalysis.util.Heap;
import javascriptAnalysis.util.JSObject;
import javascriptAnalysis.util.Location;
import javascriptAnalysis.util.ObjectValue;
import javascriptAnalysis.util.SecurityType;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class HeapTest extends TestCase {

	private Heap h, h0, h1;
	public HeapTest(String name) {
		super(name);
		
	}

	protected void setUp() throws Exception {
		super.setUp();
		
		// Heap test
		JSObject js1 = new JSObject();
		JSObject js2 = new JSObject();
		JSObject js3 = new JSObject();
		
		js1.put("x", new ObjectValue("Y"));

		js2.put(new String("a"), new SecurityType(SecurityType.high, null));
		js2.put(new String("u"), null);
		
		js3.put(new String("b"), null);
		

		// Testing the alloc function
		h = new Heap();
		Location l0 = h.alloc(Location.generateLocString(), js1);
		Location l1 = h.alloc("0", js1);
		Location l2 = h.alloc("10", js2);
		System.out.println("loc 1: " + l1);
		System.out.println("loc 2: " + l2);
		System.out.println("Heap : " + h);
		
		h0 = h.deepClone();
		h1 = h.clone();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testEquals(){
		assertTrue(h.equals(h0));
		assertTrue(h.equals(h1));
	}
	
	public static TestSuite suite(){
		TestSuite suite = new TestSuite(HeapTest.class);
		return suite;
	}

}
