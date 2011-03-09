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
/**
 * Test Suite for testing the programs without branching.
 */
package javascriptAnalysis.junit_tests;

import java.io.IOException;

import java.util.HashSet;
import java.util.Iterator;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import javascriptAnalysis.parser.ES3Lexer;
import javascriptAnalysis.parser.ES3Parser;
import javascriptAnalysis.parser.ProgramAnalyzerC;
import javascriptAnalysis.util.Heap;
import javascriptAnalysis.util.JSObject;
import javascriptAnalysis.util.Location;
import javascriptAnalysis.util.SecurityType;
import javascriptAnalysis.util.State;
import javascriptAnalysis.util.StateSet;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ProgramAnalyzerCTest extends TestCase {
	ES3Lexer lex;
	
	public ProgramAnalyzerCTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		lex=new ES3Lexer();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/*public void testEquals(){
		try{
			String fn1 = "str1";
			String fn2 = "str2";
			String str1 = "var x = \"str\"";
			String str2 = "var y = \"str\"";
			StateSet resultStateSet1a = walkProgram(fn1, str1);
			StateSet resultStateSet1b = walkProgram(fn2, str1);
			StateSet resultStateSet2 = walkProgram(fn2,str2);
			
			
			
			Iterator<State> it1 = resultStateSet1a.getStates().iterator();
			State rs1 = it1.next();
			System.out.println("Heap 1: " + rs1.getHeap().toString());
			System.out.println("Heap 1: " + rs1.getHeap().deepClone().toString());
			
			
			Iterator<State> it2 = resultStateSet1b.getStates().iterator();
			State rs2 = it2.next();
			System.out.println("Heap 1: " + rs2.getHeap().toString());
			
			
			Iterator<State> it3 = resultStateSet2.getStates().iterator();
			State rs3 = it3.next();
			System.out.println("Heap 1: " + rs3.getHeap().toString());
			
			
			
			assertTrue(rs1.getHeap().equals(rs1.getHeap().clone()));
			assertTrue(rs1.getHeap().equals(rs1.getHeap().deepClone()));
			assertFalse(rs1.getHeap().equals(rs2.getHeap()));
			assertFalse(rs1.getHeap().equals(rs3.getHeap()));
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/

	public void testNewCommand(){
		try{
			//new ANTLRFileStream("/Users/sruthi81/Documents/Research/BrowserProject/ExtensionSecurity/javascriptAnalysis/TestInputs/__Test___input.txt"));
		    String filename = "/Users/sruthi/Documents/EclipseWorkspace2010/Experiments/SmallExamples/new_tests";
		    Location global;
		    
		    State resultStateSet = walkProgram(filename);
			
			global = resultStateSet.getGlobal();
			
			assertTrue(resultStateSet.getPropertyValue(global, "zlow").equals(resultStateSet.getPropertyValue(global, "z")));
			assertTrue(resultStateSet.getPropertyValue(global, "u").equals(resultStateSet.getPropertyValue(global, "v")));
			assertTrue(resultStateSet.getPropertyValue(global, "u").equals(resultStateSet.getPropertyValue(global, "y")));
			assertTrue(resultStateSet.getPropertyValue(global, "u").equals(resultStateSet.getPropertyValue(global, "testval")));
			assertFalse(resultStateSet.getPropertyValue(global, "a").equals(resultStateSet.getPropertyValue(global, "x")));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void testCallCommand(){
		try{
			/*new ANTLRFileStream("/Users/sruthi81/Documents/Research/BrowserProject/ExtensionSecurity/javascriptAnalysis/TestInputs/__Test___input.txt"));*/
		    String filename = "/Users/sruthi/Documents/EclipseWorkspace2010/Experiments/SmallExamples/call_tests";
		    Location global;
		    
		    State resultStateSet = walkProgram(filename);
			
			global = resultStateSet.getGlobal();
			
			assertFalse(resultStateSet.getPropertyValue(global, "jlow").equals(resultStateSet.getPropertyValue(global, "ylow")));
			assertTrue(resultStateSet.getPropertyValue(global, "jhigh").equals(resultStateSet.getPropertyValue(global, "yhigh")));
			//assertTrue(resultStateSet.getPropertyValue(global, "u").equals(resultStateSet.getPropertyValue(global, "y")));
			//assertTrue(resultStateSet.getPropertyValue(global, "u").equals(resultStateSet.getPropertyValue(global, "testval")));
			//assertFalse(resultStateSet.getPropertyValue(global, "a").equals(resultStateSet.getPropertyValue(global, "x")));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void testThisExpression(){
		try{
			/*new ANTLRFileStream("/Users/sruthi81/Documents/Research/BrowserProject/ExtensionSecurity/javascriptAnalysis/TestInputs/__Test___input.txt"));*/
		    String filename = "/Users/sruthi/Documents/EclipseWorkspace2010/Experiments/SmallExamples/this_test";
		    Location global;
		    
		    State resultStateSet = walkProgram(filename);
			
			global = resultStateSet.getGlobal();
			
			assertTrue(resultStateSet.getPropertyValue(global, "k").equals(resultStateSet.getPropertyValue(global, "n2")));
			assertTrue(resultStateSet.getPropertyValue(global, "l").equals(resultStateSet.getPropertyValue(global, "n3")));
			assertTrue(resultStateSet.getPropertyValue(global, "l").equals(resultStateSet.getPropertyValue(global, "j3")));
			assertTrue(resultStateSet.getPropertyValue(global, "m").equals(resultStateSet.getPropertyValue(global, "n1")));
			assertTrue(resultStateSet.getPropertyValue(global, "j").equals(resultStateSet.getPropertyValue(global, "j1")));
			assertTrue(resultStateSet.getPropertyValue(global, "m").equals(resultStateSet.getPropertyValue(global, "j")));
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	

	/**
	 * 
	 * Common path to follow for any given file, so made it into a method
	 * @param filename
	 * @return
	 * @throws IOException
	 * @throws RecognitionException
	 */
	private State walkProgram(String filename) throws IOException,
			RecognitionException {
		ES3Lexer lex=new ES3Lexer();
		lex = new ES3Lexer(new ANTLRFileStream(filename));
			
		CommonTokenStream tokens = new CommonTokenStream(lex);

		ES3Parser parser = new ES3Parser(tokens);
		ES3Parser.program_return r = parser.program(); 
      
		// Create a root AST node with id 0, and its child is the AST produced by the parser:
		CommonToken tok = new CommonToken(ES3Lexer.ROOT_ID);
		CommonTree root = new CommonTree(tok);
		//root.setType(DependencyTracker.ROOT_ID);
		root.addChild((CommonTree)r.getTree());
		
		// Create the initial heap and the global object
		Location global = new Location("Global");
		Heap initialHeap = new Heap();
		JSObject globalObj = new JSObject();
		globalObj.put("at_Taint", new SecurityType(SecurityType.high, null));
		initialHeap.put(global, globalObj);
		
		// Create the initial State and stateset
		State initState = new State(initialHeap, global, global);
		StateSet initStSet = new StateSet();
		initStSet.addState(initState);		
		System.out.println("Init State Set:" + initStSet.toString());
		
		// Create the tree walker 
		ProgramAnalyzerC vt = new ProgramAnalyzerC(filename,initState);
		
		// Pre-process the program to create the global object
		StateSet preProcessedState = vt.preWalk(root, initStSet);
		System.out.println("Pre State Set:" + preProcessedState.toString());
		
		//TODO: To be removed when computations for StateSet can be done
		
		Iterator<State> initsts = preProcessedState.getStates().iterator();
		State post_preWalk = initsts.next();
		// Process the program now
		State resultStateSet = vt.walkExpression(root,post_preWalk);
		System.out.println("Post State Set:" + resultStateSet.toString());
		return resultStateSet;
	}
	
	/**
	 * @param fn
	 * @param str1
	 * @return
	 * @throws RecognitionException
	 */
	private StateSet walkProgram(String fn, String str1)
			throws RecognitionException {
		lex = new ES3Lexer(new ANTLRStringStream(str1));
		CommonTokenStream tokens = new CommonTokenStream(lex);

		ES3Parser parser = new ES3Parser(tokens);
		ES3Parser.program_return r = parser.program(); 
		
		// Create a root AST node with id 0, and its child is the AST produced by the parser:
		CommonToken tok = new CommonToken(ES3Lexer.ROOT_ID);
		CommonTree root = new CommonTree(tok);
		//root.setType(DependencyTracker.ROOT_ID);
		root.addChild((CommonTree)r.getTree());
		
		// Create the initial heap and the global object
		Location global = new Location("@Global");
		Heap initialHeap = new Heap();
		JSObject globalObj = new JSObject();
		initialHeap.put(global, globalObj);
		
		// Create the initial State and stateset
		State initState = new State(initialHeap, global, global);
		StateSet initStSet = new StateSet();
		initStSet.addState(initState);		
		
		// Create the tree walker 
		ProgramAnalyzerC vt = new ProgramAnalyzerC(fn,initState);
		
		// Pre-process the program to create the global object
		StateSet preProcessedState = vt.preWalk(root, initStSet);
		
		// Process the program now
		//TODO: To be removed when computations for StateSet can be done
		
		Iterator<State> initsts = preProcessedState.getStates().iterator();
		State post_preWalk = initsts.next();
		// Process the program now
		State resultState = vt.walkExpression(root,post_preWalk);
		StateSet resultStateSet = new StateSet();
		resultStateSet.addState(resultState);
		return resultStateSet;
	}

	
	public static TestSuite suite(){
		TestSuite suite = new TestSuite(ProgramAnalyzerCTest.class);
		return suite;
	}

}
