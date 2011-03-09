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
package javascriptAnalysis.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

import javascriptAnalysis.util.CallStack;
import javascriptAnalysis.util.ConditionalStkElem;
import javascriptAnalysis.util.FunctionValue;
import javascriptAnalysis.util.Heap;
import javascriptAnalysis.util.HeapSet;
import javascriptAnalysis.util.HelperFunctions;
import javascriptAnalysis.util.JSObject;
import javascriptAnalysis.util.LHSStackObject;
import javascriptAnalysis.util.Location;
import javascriptAnalysis.util.NativeObjects;
import javascriptAnalysis.util.ObjectValue;
import javascriptAnalysis.util.PredefinedObjectTemplates;
import javascriptAnalysis.util.SecurityType;
import javascriptAnalysis.util.State;
import javascriptAnalysis.util.StateSet;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

public class ProgramAnalyzerC {

	// Move this to another class so that it is accessible from all tree
	// visitors -- Done : moved to ES3Lexer
	// public final static int ROOT_ID = 0;
	public static long start_time = 0;

	String currentfilename = "";
	ArrayList<String> accessErrorList = new ArrayList<String>();
	StateSet resultStates = new StateSet();
	// HashSet<HeapSet> heapSet = new HashSet<HeapSet>();
	public static Set<String> libraryProperties = new HashSet<String>();
	static int filenumber = 0;
	static int lineNumber = 0;
	int maxLines = 0;
	String resultFolderName = "";
	int numberOfBranches = 0;
	int currentNumberOfBranches = 0;
	Location untainted_obj_loc;
	int stopTime = -1;
	boolean branchOptimization = true; // optimize by default
	boolean conditionalOrder = false; // true: then branch first, false: else
	// branch first
	boolean whileOrder = true; // true: while body evaluated first, false: while
	// body evaluated later

	Stack<String> forkBracketStack;
	Stack<String> joinBracketStack;

	/**
	 * @return the whileOrder
	 */
	public boolean isWhileOrder() {
		return whileOrder;
	}

	/**
	 * @param whileOrder
	 *            the whileOrder to set
	 */
	public void setWhileOrder(boolean whileOrder) {
		this.whileOrder = whileOrder;
	}

	/**
	 * @return the conditionalOrder
	 */
	private boolean isConditionalOrder() {
		return conditionalOrder;
	}

	/**
	 * @param conditionalOrder
	 *            the conditionalOrder to set
	 */
	private void setConditionalOrder(boolean conditionalOrder) {
		this.conditionalOrder = conditionalOrder;
	}

	/**
	 * @return the stopTime
	 */
	private int getStopTime() {
		return stopTime;
	}

	/**
	 * @param stopTime
	 *            the stopTime to set
	 */
	private void setStopTime(int stopTime) {
		this.stopTime = stopTime;
	}

	/**
	 * @return the branchOptimization
	 */
	private boolean isBranchOptimization() {
		return branchOptimization;
	}

	/**
	 * @param branchOptimization
	 *            the branchOptimization to set
	 */
	private void setBranchOptimization(boolean branchOptimization) {
		this.branchOptimization = branchOptimization;
	}

	/**
	 * @return the start_time
	 */
	private static long getStart_time() {
		return start_time;
	}

	/**
	 * @param startTime
	 *            the start_time to set
	 */
	private static void setStart_time(long startTime) {
		start_time = startTime;
	}

	/**
	 * @return the numberOfBranches
	 */
	private int getNumberOfBranches() {
		return numberOfBranches;
	}

	/**
	 * @param numberOfBranches
	 *            the numberOfBranches to set
	 */
	private void setNumberOfBranches(int numberOfBranches) {
		this.numberOfBranches = numberOfBranches;
	}

	/**
	 * @return the resultFolderName
	 */
	private String getResultFolderName() {
		return resultFolderName;
	}

	/**
	 * @param resultFolderName
	 *            the resultFolderName to set
	 */
	private void setResultFolderName(String resultFolderName) {
		this.resultFolderName = resultFolderName;
	}

	// Set of heaps at a join point
	HashMap<String, HeapSet> joinTracker = new HashMap<String, HeapSet>();
	// This keeps track of the order in which the join points occur. If the
	// parent is removed, all the elements that come after it should be removed
	// too.
	Vector<String> joinTrackerElementOrder = new Vector<String>();

	/**
	 * Add one heap element to the set of heaps at a particular join point
	 * 
	 * @param var
	 * @param hp
	 */
	public void addElementToHeapSet(String var, Heap hp) {
		HeapSet hset = joinTracker.get(var);
		if (hset == null) {
			hset = new HeapSet();
			joinTracker.put(var, hset);
			this.joinTrackerElementOrder.add(var); // add a new element to the
			// element order; add only
			// if this element is not
			// already present in the
			// heapset
			// //System.out.println("Added element to joinTrackerElementOrder: "
			// + var);
		}
		hset.addElement(hp); // add a new heap element to the join tracker
	}

	public void removeElementFromHeapSet(String var) {
		// System.out.println("Removed element: " + var);
		joinTracker.remove(var);
	}

	public void removeElementsStartingFrom(String var) {
		int size = this.joinTrackerElementOrder.size();
		int startSize = -1;
		for (int i = size - 1; i >= 0; i--) {
			if (this.joinTrackerElementOrder.get(i).equals(var)) {
				startSize = i;
				break;
			}
		}
		if (startSize != -1) {
			for (int j = startSize; j < size; j++) {
				this.removeElementFromHeapSet(this.joinTrackerElementOrder
						.get(j));
			}
			for (int k = size - 1; k >= startSize; k--) {
				this.joinTrackerElementOrder.remove(k);
			}
		}
	}

	public int getHeapSetSize(String var) {
		HeapSet hset = joinTracker.get(var);
		if (hset == null) {
			return 0;
		} else {
			return hset.size();
		}
	}

	public Heap getMatchingHeap(String var, Heap currentHeap) {
		if (this.getHeapSetSize(var) == 0) {
			return null;
		} else {
			HeapSet hset = joinTracker.get(var);
			return hset.getMatchingHeap(currentHeap);
		}
	}

	// Maximum loop iterations
	int maxLoopIter = 1;

	// Keeps track of the number of times the loop is run
	HashMap<String, Integer> loopTracker;

	public int addOneToLoopCounter(String loopid) {
		String hashcode = String.valueOf(loopid.hashCode());
		Integer lc = loopTracker.remove(hashcode);
		// //////////////////System.out.println("Add to the loop counter: " +
		// loopid + " : number: " + lc);
		if (lc == null) {
			lc = 1;
			loopTracker.put(hashcode, lc);
		} else {
			lc = lc + 1;
			loopTracker.put(hashcode, lc);
		}
		return lc;
	}

	public void removeFromLoopCounter(String loopid) {
		// //////////////////System.out.println("Remove from the loop counter: "
		// + loopid);
		String hashcode = String.valueOf(loopid.hashCode());
		loopTracker.remove(hashcode);
	}

	public int getCurrentLoopCounter(String loopid) {
		String hashcode = String.valueOf(loopid.hashCode());
		return loopTracker.get(hashcode);
	}

	public void setLoopTracker(HashMap<String, Integer> lpTracker) {
		loopTracker = lpTracker;
	}

	// Maximum call iterations
	int maxCallIter = 1;

	// Keeps track of the number of times a particular method is called
	HashMap<String, Integer> callTracker = new HashMap<String, Integer>();

	public int addOneToCallCounter(String loopid) {
		String hashcode = String.valueOf(loopid.hashCode());
		Integer lc = callTracker.remove(hashcode);
		if (lc == null) {
			lc = 1;
			callTracker.put(hashcode, lc);
		} else {
			lc = lc + 1;
			callTracker.put(hashcode, lc);
		}
		return lc;
	}

	public void removeOneFromCallCounter(String loopid) {
		String hashcode = String.valueOf(loopid.hashCode());
		Integer lc1 = callTracker.get(hashcode);
		if (lc1 != null) {
			int lc = lc1 - 1;
			if (lc < 0)
				callTracker.put(hashcode, 0);
			else
				callTracker.put(hashcode, new Integer(lc));
		} else {
			// //////////////////System.out.println("call counter is null for: "
			// + loopid);
			callTracker.put(hashcode, 0);
		}
	}

	public void removeFromCallCounter(String loopid) {
		String hashcode = String.valueOf(loopid.hashCode());
		callTracker.remove(hashcode);
	}

	/**
	 * @return the callTracker
	 */
	public HashMap<String, Integer> getCallTracker() {
		return callTracker;
	}

	/**
	 * @param callTracker
	 *            the callTracker to set
	 */
	public void setCallTracker(HashMap<String, Integer> callTracker) {
		this.callTracker = callTracker;
	}

	/**
	 * @return the currentfilename
	 */
	public String getCurrentfilename() {
		return currentfilename;
	}

	/**
	 * @param currentfilename
	 *            the currentfilename to set
	 */
	public void setCurrentfilename(String currentfilename) {
		this.currentfilename = currentfilename;
	}

	/**
	 * @return the accessErrorList
	 */
	public ArrayList<String> getAccessErrorList() {
		return accessErrorList;
	}

	/**
	 * @param accessErrorList
	 *            the accessErrorList to set
	 */
	public void setAccessErrorList(ArrayList<String> accessErrorList) {
		this.accessErrorList = accessErrorList;
	}

	/**
	 * @return the resultStates
	 */
	public StateSet getResultStates() {
		return resultStates;
	}

	/**
	 * @param resultStates
	 *            the resultStates to set
	 */
	public void setResultStates(StateSet resultStates) {
		this.resultStates = resultStates;
	}

	private void populateLibraryProperties() {
		libraryProperties.add("at_Call");
		libraryProperties.add("at_Scope");
		libraryProperties.add("at_FScope");
		libraryProperties.add("__proto__");
		libraryProperties.add("prototype");
		libraryProperties.add("__arguments__");
		libraryProperties.add("at_this");
		libraryProperties.add("__callee__");
		libraryProperties.add("__constructor__");
		libraryProperties.add("__length__");
		libraryProperties.add("at_Body");
		libraryProperties.add("at_Class");
		libraryProperties.add("at_Construct");
		libraryProperties.add("at_Taint");
		libraryProperties.add("at_Dummy");
	}

	public int getRoundBracketNumber(Stack<String> stk) {
		int bracketSize = 0;
		for (int i = 0; i < stk.size(); i++) {
			if (stk.get(i).equals(")"))
				bracketSize++;
		}
		return bracketSize;
	}

	/**
	 * ) - Entering the left branch(fork) or leaving the left branch(join) ] -
	 * Entering the right branch(fork) or leaving the right branch(join) [ -
	 * Returning after getting to the end of the path
	 * 
	 * @param type
	 * @param bracket
	 */
	public void addToBracketStack(String type, String bracket, String branchCode) {
		// //System.out.println("BranchCode: " + branchCode);
		// //////System.out.println("Begin: joinStack: " +
		// this.joinBracketStack.toString());
		// //////System.out.println("Begin: forkStack: " +
		// this.forkBracketStack.toString());

		// join
		if (type.equals("join")) {
			if (!bracket.equals("[")) {
				this.joinBracketStack.add(bracket);
			} else {
				String top = this.joinBracketStack.peek();
				if (top != null) {
					if (top.equals(")"))
						this.joinBracketStack.pop();
					else {
						if (top.equals("]")) {
							if (this.joinBracketStack.contains(")")) {
								this.joinBracketStack.pop();
							} else {
								this.joinBracketStack.pop();
								if (!this.forkBracketStack.contains(")")) {
									this.removeElementsStartingFrom(branchCode);
								} else {
									this.removeElementFromHeapSet(branchCode);
								}
							}
						}
					}
				}
			}
		}

		// fork
		if (type.equals("fork")) {
			if (!bracket.equals("[")) {
				this.forkBracketStack.add(bracket);
			} else {
				String top = this.forkBracketStack.peek();
				if (top != null) {
					if (top.equals(")")) {
						this.forkBracketStack.pop();
					} else {
						String joinBranchCode = branchCode.substring(0,
								branchCode.length() - 4)
								+ "join";
						// //System.out.println("join code: " + joinBranchCode);
						if (top.equals("]")) {
							if (this.forkBracketStack.contains(")")) {
								this.forkBracketStack.pop();
								if (!this.joinBracketStack.contains(")")) { // this.getRoundBracketNumber(this.forkBracketStack)
									// <=
									// 1
									// &&
									this.removeElementFromHeapSet(branchCode);
									this
											.removeElementFromHeapSet(joinBranchCode);
								}
							} else {
								this.forkBracketStack.pop();
								if (!this.joinBracketStack.contains(")")) {
									this.removeElementsStartingFrom(branchCode);
								} else {
									this.removeElementFromHeapSet(branchCode);
									this
											.removeElementFromHeapSet(joinBranchCode);
								}
							}
						}
					}
				}
			}
		}

		// //System.out.println("End: BranchID:" + branchCode + " joinStack: " +
		// this.joinBracketStack.toString());
		// //System.out.println("End: BranchID:" + branchCode + " forkStack: " +
		// this.forkBracketStack.toString());
		// //System.out.println("End: BranchCode: " + branchCode);

	}

	// public boolean stackContainsUnmatched
	/**
	 * @return the forkBracketStack
	 */
	public Stack<String> getForkBracketStack() {
		return forkBracketStack;
	}

	/**
	 * @param forkBracketStack
	 *            the forkBracketStack to set
	 */
	public void setForkBracketStack(Stack<String> forkBracketStack) {
		this.forkBracketStack = forkBracketStack;
	}

	/**
	 * @return the joinBracketStack
	 */
	public Stack<String> getJoinBracketStack() {
		return joinBracketStack;
	}

	/**
	 * @param joinBracketStack
	 *            the joinBracketStack to set
	 */
	public void setJoinBracketStack(Stack<String> joinBracketStack) {
		this.joinBracketStack = joinBracketStack;
	}

	/**
	 * @return the untainted_obj_loc
	 */
	private Location getUntainted_obj_loc() {
		return untainted_obj_loc;
	}

	/**
	 * @param untaintedObjLoc
	 *            the untainted_obj_loc to set
	 */
	private void setUntainted_obj_loc(Location untaintedObjLoc) {
		untainted_obj_loc = untaintedObjLoc;
	}

	private SecurityType highTaint = SecurityType.createSecurityType(
			SecurityType.high, null);

	/**
	 * @return the highTaint
	 */
	private SecurityType getHighTaint() {
		return highTaint;
	}

	/**
	 * @param highTaint
	 *            the highTaint to set
	 */
	private void setHighTaint(SecurityType highTaint) {
		this.highTaint = highTaint;
	}

	// innerHTML dependencies
	public HashSet<LinkedList> innerHTMLSet = new HashSet();
	public HashSet<LinkedList> final_innerHTMLList = new HashSet();

	/**
	 * methods for innerHTMLSet
	 * 
	 * @return
	 */
	public HashSet<LinkedList> getInnerHTMLSet() {
		return innerHTMLSet;
	}

	public void setInnerHTMLSet(HashSet<LinkedList> es) {
		innerHTMLSet = es;
	}

	public void addToInnerHTMLSet(LinkedList ls) {
		// //////////////////////////////System.out.println("ls: " +
		// ls.toString());
		innerHTMLSet.add(ls);
	}

	public void printInnerHTMLSet() {
		for (LinkedList l : getInnerHTMLSet()) {
			printString("High value is sent to innerHTML at method call: "
					+ l.get(0) + " tainted by:" + l.get(1) + " at line: "
					+ l.get(2) + " of: " + l.get(3));
		}
	}

	public void printFinalInnerHTMLSet() {
		for (LinkedList l : final_innerHTMLList) {
			printString("High value is sent to innerHTML at method call: "
					+ l.get(0) + " tainted by:" + l.get(1) + " at line: "
					+ l.get(2) + " of: " + l.get(3));
		}
	}

	public void clearInnerHTMLSet() {
		final_innerHTMLList.addAll(innerHTMLSet);
		innerHTMLSet.clear();
	}

	public void addToFinalInnerHTMLSet() {
		final_innerHTMLList.addAll(innerHTMLSet);
	}

	// eval dependencies
	public HashSet<LinkedList> evalSet = new HashSet();
	public HashSet<LinkedList> final_evalList = new HashSet();

	/**
	 * methods for evalSet
	 * 
	 * @return
	 */
	public HashSet<LinkedList> getEvalSet() {
		return evalSet;
	}

	public void setEvalSet(HashSet<LinkedList> es) {
		evalSet = es;
	}

	public void addToEvalSet(LinkedList ls) {
		// //////////////////////////////System.out.println("ls: " +
		// ls.toString());
		evalSet.add(ls);
	}

	public void printEvalSet() {
		for (LinkedList l : getEvalSet()) {
			printString("High value is sent to eval at method call: "
					+ l.get(0) + " at line: " + l.get(1) + " of: " + l.get(2));
		}
	}

	public void printFinalEvalSet() {
		for (LinkedList l : final_evalList) {
			printString("High value is sent to eval at method call: "
					+ l.get(0) + " at line: " + l.get(1) + " of: " + l.get(2));
		}
	}

	public void clearEvalSet() {
		final_evalList.addAll(evalSet);
		evalSet.clear();
	}

	public void addToFinalEvalSet() {
		final_evalList.addAll(evalSet);
	}

	// eval dependencies
	public HashSet<LinkedList> appendChildSet = new HashSet();
	public HashSet<LinkedList> final_appendChildList = new HashSet();

	/**
	 * methods for appendChild
	 * 
	 * @return
	 */
	public HashSet<LinkedList> getAppendChildSet() {
		return appendChildSet;
	}

	public void setAppendChildSet(HashSet<LinkedList> es) {
		appendChildSet = es;
	}

	public void addToAppendChildSet(LinkedList ls) {
		// //////////////////////////////System.out.println("ls: " +
		// ls.toString());
		appendChildSet.add(ls);
	}

	public void printAppendChildSet() {
		for (LinkedList l : getAppendChildSet()) {
			printString("High value is sent to appendChild at method call: "
					+ l.get(0) + " at line: " + l.get(1) + " of: " + l.get(2));
		}
	}

	public void printFinalAppendChildSet() {
		for (LinkedList l : final_appendChildList) {
			printString("High value is sent to appendChild at method call: "
					+ l.get(0) + " at line: " + l.get(1) + " of: " + l.get(2));
		}
	}

	public void clearAppendChildSet() {
		final_appendChildList.addAll(appendChildSet);
		appendChildSet.clear();
	}

	public void addToFinalAppendChildSet() {
		final_appendChildList.addAll(appendChildSet);
	}

	// writing a high value to a local file
	public HashSet<LinkedList> wrtToLocalFileSet = new HashSet();
	public HashSet<LinkedList> final_wrtToLocalFileList = new HashSet();

	/**
	 * methods for wrtToLocalFile
	 * 
	 * @return
	 */
	public HashSet<LinkedList> getWrtToLocalFileSet() {
		return wrtToLocalFileSet;
	}

	public void setWrtToLocalFileSet(HashSet<LinkedList> es) {
		wrtToLocalFileSet = es;
	}

	public void addToWrtToLocalFileSet(LinkedList ls) {
		// //////////////////////////////System.out.println("ls: " +
		// ls.toString());
		wrtToLocalFileSet.add(ls);
	}

	public void printWrtToLocalFileSet() {
		for (LinkedList l : getWrtToLocalFileSet()) {
			printString("High value is sent to wrtToLocalFile at method call: "
					+ l.get(0) + " tainted by:" + l.get(1) + " at line: "
					+ l.get(2) + " of: " + l.get(3));
		}
	}

	public void printFinalWrtToLocalFileSet() {
		for (LinkedList l : final_wrtToLocalFileList) {
			printString("High value is sent to wrtToLocalFile at method call: "
					+ l.get(0) + " tainted by:" + l.get(1) + " at line: "
					+ l.get(2) + " of: " + l.get(3));
		}
	}

	public void clearWrtToLocalFileSet() {
		final_wrtToLocalFileList.addAll(wrtToLocalFileSet);
		wrtToLocalFileSet.clear();
	}

	public void addToFinalWrtToLocalFileSet() {
		final_wrtToLocalFileList.addAll(wrtToLocalFileSet);
	}

	public void printString(String ps) {
		System.out.print(ps + "\n");
	}

	public ProgramAnalyzerC(String cf, State initState) {
		super();
		this.currentfilename = cf;
		populateLibraryProperties();
		this.loopTracker = new HashMap<String, Integer>();
		this.currentNumberOfBranches = 0;
		this.untainted_obj_loc = this.createHighDummyObjectInHeap(initState);
		this.highTaint = SecurityType.createSecurityType(SecurityType.high,
				null);
		this.filenumber = 0;
		this.lineNumber = 0;
		this.forkBracketStack = new Stack<String>();
		this.joinBracketStack = new Stack<String>();
	}

	/**
	 * Calculate the posts state after a block of statements are executed. The
	 * analysis is flow sensitive, and so the post-state of one statement would
	 * be the pre state of the following statement
	 * 
	 * @param ast
	 *            Current Statement, which could include a set of statements
	 * @param pre
	 *            Input Context
	 * @return Post context after analyzing each of the statements
	 */
	private State walkStatements(CommonTree ast, State pre, int type) {
		State post = pre;
		if (ast.getChildCount() > 0) {
			List<CommonTree> children = ast.getChildren();

			for (CommonTree child : children) { // for all the children of the
				// current ast node
				// calculate the post-context of the child statement, given the
				// input context grSet
				switch (type) {
				case 1:
					post = walkVAR(child, pre);
					break;
				case 2:
					post = walkFD(child, pre);
					break;
				}
				pre = post;
			}
		}
		return post;
	}

	/**
	 * Function that walks over a program for each state in the StateSet and
	 * returns the union of state sets returned by the walks
	 * 
	 * @param ast
	 * @param pre
	 * @return
	 */
	public StateSet preWalk(CommonTree ast, StateSet pre) {
		if (pre == null) // If the input state set is null
			return null; // we cannot analyze the AST

		if (ast == null) // If the tree to be analyzed is null
			return pre; // return the pre set

		StateSet returnSet = new StateSet();
		for (State st : pre.getStates()) {
			walkVAR(ast, st);
			// //////////////System.out.println("end of walkVAR");
			walkFD(ast, st);
			// //////////////System.out.println("end of walkFD");
			returnSet.addState(st);
		}
		return returnSet;
	}

	public State preWalk(CommonTree ast, State pre) {
		if (pre == null) // If the input state set is null
			return null; // we cannot analyze the AST

		if (ast == null) // If the tree to be analyzed is null
			return pre; // return the pre set

		walkVAR(ast, pre);
		walkFD(ast, pre);
		return pre;
	}

	public State walkVAR(CommonTree ast, State pre) {

		State post = pre;
		if (ast == null) { // If the tree to be analyzed is null
			post = pre;
			return pre;
		}
		try {
			switch (ast.getType()) {
			// The top of the tree looks like this:
			// ROOT_ID "Whatever.js"
			case ES3Lexer.ROOT_ID:
				post = walkStatements(ast, pre, 1);
				break;

			case ES3Lexer.FUNBODY:
			case ES3Lexer.BLOCK:
			case ES3Lexer.CASE:
			case ES3Lexer.DO:
			case ES3Lexer.FOR:
			case ES3Lexer.IF:
			case ES3Lexer.SWITCH:
			case ES3Lexer.TRY:
			case ES3Lexer.CATCH:
			case ES3Lexer.DEFAULT:
			case ES3Lexer.FINALLY:
			case ES3Lexer.WHILE:
			case ES3Lexer.WITH:
			case ES3Lexer.LABELLED:

				/*
				 * Walk all the statements in the block. The post state should
				 * be the pre state for the next statement
				 */
				post = walkStatements(ast, pre, 1);
				break;

			case ES3Lexer.VAR:
				/*
				 * VAR could be of the form var x; or var x,y; or var x = .., y
				 * = ..; etc.
				 */
				if (ast.getChildCount() > 0) {
					List<CommonTree> children = ast.getChildren(); // get all
					// the
					// variables
					// declared
					// in this
					// "var"
					// statement
					String varName = "";
					for (CommonTree child : children) {

						// For each child get the identifier
						if (((CommonTree) child).getType() == ES3Lexer.Identifier) { // if
							// the
							// child
							// is
							// just
							// an
							// identifier
							// i.e.
							// "var x;"
							varName = child.getText();
						} else { // if the child contains an assignment
							varName = child.getChild(0).getText();
						}

						// add the identifier to the current scope
						pre.addToScope(varName, null);
					}
				}
				post = pre;
				break;

			case ES3Lexer.ASSIGN:
				// get the lhs of the assignment
				// String varName = ast.getChild(0).getText();

				// add it to the current scope
				// pre.addToScope(varName,null);

				post = pre;
				break;
			case ES3Lexer.NAMEDVALUE:
				String lhs = ((CommonTree) ast.getChild(0)).getText();
				pre.addToScope(lhs, null);
				break;

			case ES3Lexer.FUNCTION:
				post = pre;
				break;

			default:
				post = pre;
				// post.addState(pre);
				break;
			}
		} catch (Exception body_exc) {
			body_exc.printStackTrace();
			// printString(body_exc.toString());
		}

		return post;
	}

	/**
	 * This method creates a function object for all the function declarations
	 * in the current scope. This corresponds to the helper function FD from
	 * jssec.net. FD only creates function declaration object, it does not
	 * create entries for labels and Vars. TODO: Might need to remove my own
	 * interpretation for labels and vars
	 * 
	 * @param ast
	 * @param pre
	 * @return
	 */
	public State walkFD(CommonTree ast, State pre) {
		State post = pre;
		if (ast == null)
			return pre;
		try {
			switch (ast.getType()) {
			// The top of the tree looks like this:
			// ROOT_ID "Whatever.js"
			case ES3Lexer.ROOT_ID:
				post = walkStatements(ast, pre, 2);
				break;

			case ES3Lexer.FUNBODY:
			case ES3Lexer.BLOCK:
			case ES3Lexer.CASE:
			case ES3Lexer.DEFAULT:
			case ES3Lexer.DO:
			case ES3Lexer.FOR:
			case ES3Lexer.IF:
			case ES3Lexer.SWITCH:
			case ES3Lexer.TRY:
			case ES3Lexer.CATCH:
			case ES3Lexer.FINALLY:
			case ES3Lexer.WHILE:
			case ES3Lexer.WITH:

				/*
				 * Walk all the statements in the block. The post state should
				 * be the pre state for the next statement
				 */
				post = walkStatements(ast, pre, 2);
				break;

			case ES3Lexer.VAR:
				if (ast.getChildCount() > 0) {
					List<CommonTree> children = ast.getChildren(); // get all
					// the
					// variables
					// declared
					// in this
					// "var"
					// statement
					String varName = "";
					for (CommonTree child : children) {
						// For each child, analyze it further if it is an
						// assignment
						if (((CommonTree) child).getType() == ES3Lexer.ASSIGN) { // if
							// the
							// child
							// is
							// an
							// assignment
							// Check if the rhs is a function declaration
							State varFD = walkFD(child, pre);

							if (varFD.getResultValue() != null) {
								// get the name of the lhs variable
								String lhs = ((CommonTree) child).getChild(0)
										.getText();
								pre.addToScope(lhs, varFD.getResultValue());
								varFD.setResultValue(null);
							}

						}
					}
				}
				post = pre;
				break;

			case ES3Lexer.ASSIGN:
				State ass_decl = walkFD((CommonTree) ast.getChild(1), pre);

				// TODO: Create a new entry/ replace an entry in the location
				// represented by LHS
				/*
				 * This can only be done if we know how to retrieve an object
				 * from an expression, that could be a field access, variable
				 * access, etc. This requires program evaluation.
				 */
				post = ass_decl;
				break;
			case ES3Lexer.LABELLED:
				// The ResultValue of the state lb contains the new
				// function object
				State lb = walkFD((CommonTree) ast.getChild(1), pre);

				// A new property corresponding to the label is created
				// in the current scope
				String label = ast.getChild(0).getText();
				pre.addToScope(label, lb.getResultValue());

				// The result value is then cleared so that it is not propagated
				// to
				// a wrong variable
				lb.setResultValue(null);

				post = pre;
				break;

			case ES3Lexer.FUNCTION:

				// create the function object and get it's location
				ObjectValue fd = walkFunctionDeclaration(ast, pre);

				// The return value is the location representing the new
				// function
				pre.setResultValue(fd);

				// Return this to post
				post = pre;
				break;
			default:
				// ////////////////System.out.println("type: " + ast.getType());
				post = pre;
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// printString(e.toString());
		}
		return post;
	}

	/**
	 * Creates a new function object and then creates an entry for the function
	 * in the current scope if the function is named.
	 * 
	 * @param ast
	 * @param pre
	 * @return
	 */
	private Location walkFunctionDeclaration(CommonTree ast, State pre) {
		// HelperFunction.Function creates a new function object and returns
		// it in the resultValue of the State
		Location fd = HelperFunctions.Function(ast, pre.getHeap(), pre
				.getScope(), currentfilename, this.getHighTaint());

		// If the function has a name, insert the function property into the
		// current scope
		if (ast.getChildCount() == 3) { // The function has three children :
			// name, arguments and body
			String fun_name = ast.getChild(0).getText();
			pre.addProperty(pre.getScope(), fun_name, fd);
		}
		return fd;
	}

	/**
	 * Creates a new string primitive object, inserts it into the heap and
	 * returns the new location that was created in the heap for inserting the
	 * object
	 * 
	 * @param pre
	 * @param ast
	 * @return
	 */
	public State createStringPrimitive(State pre, CommonTree ast) {

		// create a name for the new object's location
		String primitiveValue = ast.getText();
		if (primitiveValue.endsWith("\"")) {
			primitiveValue = primitiveValue.substring(1, primitiveValue
					.length() - 1);
		}

		Location sv = pre.getHeap().getStrObjectValue(ast.getText());
		if (sv == null) {
			ObjectValue strv = new ObjectValue(ast.getText());
			// Create a ObjValue for "Object"
			ObjectValue obj = new ObjectValue("Object");
			// All the primitive values are safe to use -- hence the high taint
			SecurityType taint = this.getHighTaint();
			// Create a new object representing the primitive value
			JSObject newObject = PredefinedObjectTemplates.new_object(obj,
					NativeObjects.ObjectProt, taint);
			// Keep track of the exact string value
			newObject.put("at_StrValue", strv);
			// Compute a new location name
			String location_name = computeLocationString("PrimitiveValue", ast);
			// add the new object to the heap
			sv = pre.addToHeap(location_name, newObject);

			// add this to the string value map for future accesses
			pre.getHeap().addToStrValueMap(ast.getText(), sv);
		}

		// add this new location to the resultValue
		pre.setResultValue(sv);

		/*
		 * if(Boolean.parseBoolean(primitiveValue)){ newObject. }
		 */

		return pre;
	}

	/*
	 * Do nothing and clear the result if it is any other primitive value
	 */
	public State createPrimitive(State pre, CommonTree ast) {

		pre.clearOldResults();
		// All the primitive values are safe to use -- hence the high taint
		/*
		 * SecurityType taint =
		 * SecurityType.createSecurityType(SecurityType.high, null);
		 * 
		 * 
		 * // create a name for the new object's location String primitiveValue
		 * = ast.getText(); if(primitiveValue.endsWith("\"")){ primitiveValue =
		 * primitiveValue.substring(1, primitiveValue.length()-1); } String
		 * location_name = computeLocationString("PrimitiveValue", ast);
		 * 
		 * 
		 * // Create a new object representing the primitive value JSObject
		 * newObject = PredefinedObjectTemplates.new_primitive_object("Object",
		 * NativeObjects.ObjectProt, taint, null);
		 * 
		 * 
		 * // add the new object to the heap Location newLoc =
		 * pre.addToHeap(location_name, newObject);
		 * 
		 * // add this new location to the resultValue
		 * pre.setResultValue(newLoc);
		 */

		return pre;
	}

	/**
	 * Computes the next child of the node in the tree -- The next child could
	 * be a sibling of the parent, if the current node does not have any next
	 * siblings.
	 * 
	 * @param ast
	 * @return
	 */
	private CommonTree computeNextChild(CommonTree ast) {
		if (ast.getChildIndex() == -1) { // if we reached the root
			// no more next statements, return null
			// ////////////////System.out.println("this is the root");
			return null;
		} else { // we did not reach the root yet
			CommonTree nextChild = (CommonTree) ast.getParent().getChild(
					ast.getChildIndex() + 1);
			if (nextChild != null) { // if nextChild is not null
				return nextChild;
			} else { // nextChild is null
				// compute the next child of the parent
				return computeNextChild((CommonTree) ast.getParent());
			}
		}
	}

	/**
	 * Computes the previous sibling of the node in the tree
	 * 
	 * @param ast
	 * @return
	 */
	private CommonTree computePreviousSibling(CommonTree ast) {
		if (ast.getChildIndex() == -1) { // if we reached the root
			// no more next statements, return null
			// ////////////////System.out.println("this is the root");
			return null;
		} else { // we did not reach the root yet
			CommonTree prevChild = (CommonTree) ast.getParent().getChild(
					ast.getChildIndex() - 1);
			return prevChild;
		}
	}

	/**
	 * Computes the next sibling of the current node. Returns null if none
	 * exist.
	 * 
	 * @param ast
	 * @return
	 */
	private CommonTree computeNextSibling(CommonTree ast) {
		if (ast.getChildIndex() == -1) { // if we reached the root
			// no more next statements, return null
			// ////////////////System.out.println("this is the root");
			return null;
		} else { // we did not reach the root yet
			CommonTree nextChild = (CommonTree) ast.getParent().getChild(
					ast.getChildIndex() + 1);
			return nextChild;
		}
	}

	public String getBranchName(CommonTree parent, State pre, String type) {
		String ifvar = parent.getChild(0).toStringTree() + parent.getLine();
		String if_hashcode = String.valueOf(ifvar.hashCode());
		CallStack latestCallElement = pre.peekCallStack();
		int retnode = 0;
		if (latestCallElement != null) {
			retnode = latestCallElement.retNodeLineNumber();
		}
		String currentBranch = if_hashcode + pre.getCallHashCode() + retnode
				+ type;
		// //System.out.println("if var : " + ifvar +" current branch: " +
		// currentBranch);
		return currentBranch;
		// return if_hashcode;
	}

	/**
	 * This method is used to compute the next node to be analyzed -- useful for
	 * the continuation passing style programming.
	 * 
	 * @param ast
	 * @return
	 */
	private State trampoline(CommonTree ast, State pre) {
		State post;
		CommonTree parent = (CommonTree) ast.getParent();
		if (parent == null) { // ROOT_ID's parent is null
			post = pre;
			return post;
		}
		CommonTree parent_sibling = computeNextSibling(parent);
		CommonTree next_sibling = computeNextSibling(ast);
		/*
		 * ////////////////System.out.println("parent type: " +
		 * ast.getParent().toStringTree()); if(next_sibling !=null){
		 * ////////////////System.out.println("nextSibling " +
		 * next_sibling.toStringTree()); }
		 */

		switch (parent.getType()) {
		case ES3Lexer.ROOT_ID:
			if (next_sibling != null)
				post = walkExpression(next_sibling, pre);
			else {
				// Heap newHeap = pre.getHeap().deepClone();
				// heapSet.add(new HeapSet(newHeap,this.innerHTMLSet));
				// heapSet.add(new HeapSet(null,this.innerHTMLSet));
				// ////////System.out.println("FileNumber first:" +
				// this.filenumber);
				this.filenumber++;
				if (this.lineNumber > this.maxLines)
					this.maxLines = this.lineNumber;
				// ////////////////System.out.println("heap: " +
				// newHeap.toString() + "innerHTMLSet: " +
				// this.innerHTMLSet.toString()) ;
				/*
				 * String graphRep = newHeap.toGraphRep(pre.getGlobal());
				 * //////////////////System.out.println(graphRep); try {
				 * BufferedWriter out = new BufferedWriter(new
				 * FileWriter(this.resultFolderName+"example.dot"));
				 * out.write(graphRep); out.close(); } catch (IOException e) { }
				 */

				post = pre;
			}
			break;

		case ES3Lexer.VAR:
			if (next_sibling != null) {
				post = walkExpression(next_sibling, pre);
			} else {
				post = trampoline(parent, pre);
			}
			break;

		case ES3Lexer.ASSIGN:
			if (next_sibling != null) {
				pre.pushOntoLhsStack("LHS: " + ast.toStringTree()
						+ " of assign at: " + ast.getLine() + " at scope: "
						+ pre.getScope());
				pre.clearOldResults();
				post = walkExpression(next_sibling, pre);
			} else {
				pre = walkAssign(parent, pre, false);
				if (pre.isInnerHTML()) {
					// //////////////System.out.println("InnerHTML object");
					ObjectValue rhsobject = pre.getResultValue();
					if (rhsobject != null) {
						checkInnerHTMLTaint(ast, pre, rhsobject);
					}
				}
				pre.reSetInnerHTML();
				post = trampoline(parent, pre);
			}
			break;

		case ES3Lexer.ADDASS: // = '+=' ;
		case ES3Lexer.SUBASS: // = '-=' ;
		case ES3Lexer.MULASS: // = '*=' ;
		case ES3Lexer.MODASS: // = '%=' ;
		case ES3Lexer.SHLASS: // = '<<=' ;
		case ES3Lexer.SHRASS: // = '>>=' ;
		case ES3Lexer.SHUASS: // = '>>>=' ;
		case ES3Lexer.ANDASS: // = '&=' ;
		case ES3Lexer.ORASS: // = '|=' ;
		case ES3Lexer.XORASS: // = '^=' ;
		case ES3Lexer.DIVASS: // = '/=' ;
			if (next_sibling != null) {
				pre.pushOntoLhsStack("LHS: " + ast.toStringTree()
						+ " of operator assign at: " + ast.getLine()
						+ " at scope: " + pre.getScope());
				pre.clearOldResults();
				post = walkExpression(next_sibling, pre);
			} else {
				pre = walkAssign(parent, pre, true);
				if (pre.isInnerHTML()) {
					// //////////////System.out.println("InnerHTML object");
					ObjectValue rhsobject = pre.getResultValue();
					if (rhsobject != null) {
						checkInnerHTMLTaint(ast, pre, rhsobject);
					}
				}
				pre.reSetInnerHTML();
				post = trampoline(parent, pre);
			}
			break;

		case ES3Lexer.IF:
			// Reached here after the statements in the then block or else block
			// have finished executing
			String currentBranch = getBranchName(parent, pre, "join");

			// Add to the bracket stacks
			if (this.branchOptimization) {
				if (this.isConditionalOrder()) {
					// Reached join point
					if (ast.getChildIndex() == 1) {
						this.addToBracketStack("join", ")", currentBranch);
					} else {
						this.addToBracketStack("join", "]", currentBranch);
					}
				} else {
					if (ast.getChildIndex() == 1) {
						this.addToBracketStack("join", "]", currentBranch);
					} else {
						this.addToBracketStack("join", ")", currentBranch);
					}
				}
			}

			boolean optimize = performOptimization(currentBranch, pre, parent,
					"join");
			// //////System.out.println("branch number: " + currentBranch +
			// " at line:" + ast.getLine());

			if (optimize) {
				printString("Matched at: " + ast.getLine() + " join: "
						+ currentBranch);
				this.addToBracketStack("join", "[", currentBranch);
				return pre;
			}

			// So call trampoline on the parent, so that the next sibling will
			// be executed.
			post = trampoline(parent, pre);

			// Returning to the join point after the end of the path is reached
			if (this.branchOptimization)
				this.addToBracketStack("join", "[", currentBranch);

			break;

		case ES3Lexer.WHILE:

			if (!this.whileOrder) {
				post = walkExpression(parent, pre);
			} else {
				int callStackSize1;

				callStackSize1 = pre.getCallStk().size();
				int current_codesize_w = this.maxLines;

				State pre_while = pre;
				pre = pre.freezeState();
				printString(" !(" + parent.getChild(0).toStringTree() + ")"
						+ "at line no. : " + parent.getLine()
						+ " callstacksize: " + callStackSize1);

				beforeConditional(parent, pre);
				// ////////System.out.println("Before Cond: " +
				// this.callTracker.toString() + " : " +
				// ast.getChild(0).toStringTree());
				HashMap<String, Integer> recTracker1 = (HashMap<String, Integer>) this.callTracker
						.clone();
				HashMap<String, Integer> lpTracker1 = (HashMap<String, Integer>) this.loopTracker
						.clone();

				// To execute the loop zero times
				post = trampoline(parent, pre);

				printString("end of !(" + parent.getChild(0).toStringTree()
						+ ")" + "at line no. : " + parent.getLine()
						+ " callstacksize: " + callStackSize1);
				afterConditional(parent, post);
				this.setLoopTracker(lpTracker1);
				this.setCallTracker(recTracker1);
				// ////////System.out.println("After Cond: " +
				// this.callTracker.toString() + " : " +
				// ast.getChild(0).toStringTree());
				post.unfreezeState(pre_while);

				// heapSet.add(post.getHeap().deepClone());
				// post.printInFile(this.resultFolderName + this.filenumber+
				// "example.dot" );
				boolean exit_path1 = endPath(current_codesize_w);
				if (exit_path1) {
					return post;
				}

				/* Execute the loop more than one time */

				int loopcounter = addOneToLoopCounter(parent.getLine()
						+ this.currentfilename);
				if (loopcounter <= this.maxLoopIter) {
					callStackSize1 = pre.getCallStk().size();

					printString(" loop iteration ("
							+ parent.getChild(0).toStringTree() + ")"
							+ "at line no. : " + parent.getLine()
							+ " callstacksize: " + callStackSize1);

					beforeConditional(parent, pre);
					// ////////System.out.println("Before Cond: " +
					// this.callTracker.toString() + " : " +
					// ast.getChild(0).toStringTree());
					HashMap<String, Integer> recTracker2 = (HashMap<String, Integer>) this.callTracker
							.clone();
					HashMap<String, Integer> lpTracker2 = (HashMap<String, Integer>) this.loopTracker
							.clone();

					post = walkExpression((CommonTree) parent.getChild(1), post);

					printString(" end of loop iteration ("
							+ parent.getChild(0).toStringTree() + ")"
							+ "at line no. : " + parent.getLine()
							+ " callstacksize: " + callStackSize1);

					afterConditional(parent, post);
					this.setLoopTracker(lpTracker2);
					this.setCallTracker(recTracker2);
					// ////////System.out.println("After Cond: " +
					// this.callTracker.toString() + " : " +
					// ast.getChild(0).toStringTree());

					boolean exit_path3 = endPath(-1);
					if (exit_path3) {
						return post;
					}
				}
			}
			break;

		case ES3Lexer.SWITCH:
			post = trampoline(parent, pre);
			break;

		case ES3Lexer.CASE:
		case ES3Lexer.DEFAULT:
			if (next_sibling != null) {
				post = walkExpression(next_sibling, pre);
			} else {
				post = trampoline(parent, pre);
			}
			break;

		case ES3Lexer.BLOCK:
		case ES3Lexer.DO:
		case ES3Lexer.FOR:
		case ES3Lexer.WITH:
			if (next_sibling != null) {
				this.lineNumber++;
				post = walkExpression(next_sibling, pre);
			} else {
				post = trampoline(parent, pre);
			}
			break;

		case ES3Lexer.TRY:
			post = trampoline(parent, pre);
			break;

		case ES3Lexer.CATCH:
		case ES3Lexer.FINALLY:
			post = pre;
			break;

		case ES3Lexer.RETURN:

			CommonTree retParent = (CommonTree) parent.getParent();
			int childIndex = parent.getChildIndex();
			if (retParent.getType() == ES3Lexer.BLOCK) {
				childIndex = retParent.getChildIndex();
				retParent = (CommonTree) retParent.getParent();
			}
			String retBranch = "";
			if (retParent.getType() == ES3Lexer.IF) {
				// Reached here after the statements in the then block or else
				// block have finished executing
				retBranch = getBranchName(retParent, pre, "join");
			}

			CommonTree par;
			try {
				// Reset the scope and next location
				CallStack cst = pre.popFromCallStack();
				pre.setScope(cst.getRetScope());

				par = cst.getRetNode();

				// Decrease the call counter
				// String loopid =
				// ast.getParent().getParent().getParent().toString() +
				// "call line:" + par.getLine() + "+ parent line: " +
				// par.getParent().getLine() + ":" +
				// par.getParent().getParent().getLine();

				String loopid = ast.getParent().getParent().getParent()
						.toStringTree()
						+ par.getLine()
						+ par.getParent().getLine()
						+ par.getParent().getParent().getLine();
				removeOneFromCallCounter(loopid);
			} catch (EmptyStackException e) {
				// If the return is not inside a function declaration, as
				// sometimes is the case
				// when xul is converted to js, we get an EmptyStackException
				// when the function
				// call location is unknown. We just continue to the next
				// statement
				// e.printStackTrace();
				par = parent;
			}

			printString("  ------ Reached end of function call: "
					+ par.getChild(0).toStringTree() + " at line:"
					+ parent.getLine());

			if (retParent.getType() == ES3Lexer.IF) {
				// Add to the bracket stacks
				if (this.branchOptimization) {
					if (this.isConditionalOrder()) {
						// Reached join point
						if (childIndex == 1) {
							this.addToBracketStack("join", ")", retBranch);
						} else {
							this.addToBracketStack("join", "]", retBranch);
						}
					} else {
						if (childIndex == 1) {
							this.addToBracketStack("join", "]", retBranch);
						} else {
							this.addToBracketStack("join", ")", retBranch);
						}
					}
				}
			}

			// Call the trampoline to reach the parent object
			post = trampoline(par, pre);

			if (retParent.getType() == ES3Lexer.IF) {
				// Returning to the join point after the end of the path is
				// reached
				if (this.branchOptimization)
					this.addToBracketStack("join", "[", retBranch);
			}
			break;

		case ES3Lexer.PAREXPR:
			// Check where the parenthesized expression is nested and call its
			// trampoline
			post = trampoline(parent, pre);
			break;

		case ES3Lexer.OBJECT:
			if (next_sibling != null) {
				post = walkExpression(next_sibling, pre);
			} else {
				// Pop out the object's resultValue from the lhs stack
				LHSStackObject object_val = pre.popFromLhsStack();

				// Add the result value to the current result value
				pre.setFromStackObject(object_val);

				// Proceed based on the ObjectLiteral's parent
				post = trampoline(parent, pre);
			}
			break;

		case ES3Lexer.NAMEDVALUE:
			if (next_sibling != null) { // current node is the lhs
				post = walkExpression(next_sibling, pre);
			} else {

				// Get the lhs name
				String lhs = parent.getChild(0).getText();

				// Get the parent location
				LHSStackObject parentobj = pre.peekLhsStack();
				Location parentLoc = (Location) parentobj.getLhsValue();

				// Add the current result value to the heap
				ObjectValue rhs = pre.getResultValue();
				pre.addProperty(parentLoc, lhs, rhs);

				// TODO: Hack to make an object low -- TO BE REMOVED
				if (rhs != null) {
					if (lhs.endsWith("low")) {
						if (rhs instanceof Location) {
							pre.addProperty((Location) rhs, "at_Taint",
									SecurityType.createSecurityType(
											SecurityType.low, lhs));
						}
					}
				}

				pre.clearOldResults();

				// go to the trampoline of the Object literal
				post = trampoline(parent, pre);
			}
			break;

		case ES3Lexer.ARRAY:
			if (next_sibling != null) { // There are more items in the array
				post = walkExpression(next_sibling, pre);
			} else { // we reached the end of the array

				LinkedList<ObjectValue> arrVals = pre.getArrayVals();
				// Reset the arrvals array in pre
				pre.setResultValueFromStack();
				// Create the array object and add the value list to it
				pre = walkArrayLiteral(ast, pre, arrVals);
				post = trampoline(parent, pre);
			}
			break;

		case ES3Lexer.ITEM:
			ObjectValue item_val = pre.getResultValue();
			/*
			 * LinkedList<ObjectValue> itemvals = pre.getArrayVals(); int
			 * item_no = itemvals.size();
			 */
			pre.addToArrayVals(item_val);
			pre.clearOldResults();
			post = trampoline(parent, pre);
			break;

		case ES3Lexer.CALL:
			if (ast.getType() == ES3Lexer.ARGS) { // we reached here from the
				// arguments
				// Push the argument return location onto the stack.
				pre.pushOntoLhsStack("Argument Location: " + ast.toStringTree()
						+ " of function call at: " + ast.getLine()
						+ " at scope: " + pre.getScope());

				// Walk the function name to get the function reference
				CommonTree function_reference = (CommonTree) parent.getChild(0);
				post = walkExpression(function_reference, pre);
			} else { // we reached here after we got the reference to the
				// function being called
				if (parent.getParent().getType() == ES3Lexer.NEW) {
					post = walkNewCall(ast, pre, parent);
				} else {
					post = walkFunctionCall(ast, pre, parent);
				}

			}
			break;

		case ES3Lexer.ARGS:
			ObjectValue args_val = pre.getResultValue();
			/*
			 * LinkedList<ObjectValue> itemvals = pre.getArrayVals(); int
			 * item_no = itemvals.size();
			 */
			pre.addToArrayVals(args_val);
			pre.clearOldResults();
			if (next_sibling != null) {
				post = walkExpression(next_sibling, pre);
			} else {
				LinkedList<ObjectValue> argsvals = pre.getArrayVals();

				// Reset the args array in pre
				pre.setResultValueFromStack();

				// Create a new location arguments and return the location in
				// the result value
				// Create an entry for the actual function parameters and place
				// them into the function heap
				JSObject args = PredefinedObjectTemplates.new_arguments(
						argsvals.size(), argsvals, this.getHighTaint());
				String argsStr = computeLocationString("CallArgs", ast);
				Location argsLoc = pre.addToHeap(argsStr, args);

				// Return the arguments location in the result value
				pre.setResultValue(argsLoc);

				// Call the trampoline on the parent object
				post = trampoline(parent, pre);
			}
			break;

		case ES3Lexer.FUNBODY:
			// Push the previous array values list onto the stack
			// pre.pushOntoCallStack(pre.getScope(),(CommonTree)ast.getParent());

			if (next_sibling != null) {
				post = walkExpression(next_sibling, pre);
			} else {
				CommonTree cstpar;
				try {
					// Reset the scope and next location
					CallStack cstfun = pre.popFromCallStack();
					pre.setScope(cstfun.getRetScope());

					cstpar = cstfun.getRetNode();
					// Decrease the call counter
					// String lpid =
					// ast.getParent().getParent().getParent().toString() +
					// "call line:" + cstpar.getLine() + "+ parent line: " +
					// cstpar.getParent().getLine() + ":" +
					// cstpar.getParent().getParent().getLine();

					String lpid = ast.getParent().getParent().toStringTree()
							+ cstpar.getLine() + cstpar.getParent().getLine()
							+ cstpar.getParent().getParent().getLine();
					removeOneFromCallCounter(lpid);
					printString("  ------ Reached end of function call: "
							+ cstfun.getRetNode().getChild(0).toStringTree()
							+ " at line:" + parent.getLine());

				} catch (EmptyStackException e) {
					// TODO: Strange hack.. need to investigate
					// If for some reason a function body is not inside a
					// function!!
					// //////System.out.println("Erroneous body!: " +
					// parent.toStringTree() + " at line: " + parent.getLine());
					// printString(e.toString());
					e.printStackTrace();
					cstpar = parent;
				}
				// If we reached the end of the function body, then we did not
				// reach a return statement
				// So the result value and result parent should be null
				pre.clearOldResults();
				// Call the trampoline to reach the parent object
				post = trampoline(cstpar, pre);
			}
			break;

		case ES3Lexer.NEW:
			ObjectValue callResult = pre.getResultValue();

			if (ast.getType() == ES3Lexer.CALL) {
				LHSStackObject lhn = pre.popFromLhsStack();
				Location newob_loc = lhn.getLhsParent();
				if (isObject(pre, callResult)) {
					pre.setResultValue(callResult);
				} else {
					pre.setResultValue(newob_loc);
				}
			} else {
				pre.setResultValue(callResult);
			}

			post = trampoline(parent, pre);
			break;

		case ES3Lexer.BYFIELD:
			if (next_sibling != null) { // current node is the lhs of the index
				// We have the value of the lhs in the result value
				// push it onto the lhs stack
				pre.pushOntoLhsStack("LHS of byField: " + ast.toStringTree()
						+ " of field access at: " + ast.getLine()
						+ " at scope: " + pre.getScope());

				// continue using the trampoline
				post = trampoline(next_sibling, pre);
			} else { // current node is the rhs of the index
				String second_child = ast.getText();
				// ////////////////System.out.println("Second child:" +
				// second_child);
				pre.pushOntoFieldStack(pre.getScope(), ast);
				pre = walkByFieldorIndex(ast, pre, second_child);
				pre.setScopeFromFieldStack();
				// pre.popFromLhsStack();
				post = trampoline(parent, pre);
			}
			break;

		case ES3Lexer.BYINDEX:
			if (next_sibling != null) { // current node is the lhs of the index

				// We have the value of the lhs in the result value
				// push it onto the lhs stack
				pre.pushOntoLhsStack("LHS of byIndex: " + ast.toStringTree()
						+ " of field access at: " + ast.getLine()
						+ " at scope: " + pre.getScope());

				// continue using the trampoline
				post = walkExpression(next_sibling, pre);
			} else { // current node is the rhs of the index
				String index_string = null; // object property variable
				index_string = findIndexString(ast, pre);

				// 2. If the index string is found, then walk the first child to
				// find an object
				// containing the index_string and then pulling out the value of
				// the index_string
				if (index_string != null) {
					// For XPCOMAPI
					if (index_string.startsWith("@")) {
						index_string = "\"" + index_string + "\"";
					}
					// ////////////System.out.println("index_string: " +
					// index_string);

					pre.pushOntoFieldStack(pre.getScope(), ast);
					post = walkByFieldorIndex(ast, pre, index_string);
					pre.setScopeFromFieldStack();
				} else {
					LHSStackObject lhs = pre.popFromLhsStack();

					SecurityType newType = SecurityType.createSecurityType(
							SecurityType.low, "Dummy object: "
									+ ast.toStringTree());

					if (lhs.getLhsValue() != null) {
						ObjectValue result = lhs.getLhsValue();
						if (result instanceof Location) {
							// TODO: Change this to get the join of the taints
							// of all the children of the current object
							// //////////////System.out.println("Lhs taint: " +
							// pre.getPropertyValue((Location)result,
							// "at_Taint"));
							// pre.setProperty(dummy, "at_Taint", );
							newType = (SecurityType) pre.getPropertyValue(
									(Location) result, "at_Taint");
						}
					}
					// We create a dummy object with the taint value of the
					// parent
					Location dummy = pre.getHeap().createDummyObjectInHeap(ast,
							newType);

					pre.setResultValue(dummy);
				}

				post = trampoline(parent, pre);
			}
			break;

		case ES3Lexer.ADD:
			if (next_sibling != null) { // lhs
				pre.pushOntoLhsStack("Lhs of binary operators: "
						+ ast.toStringTree() + " at line: " + ast.getLine()
						+ " at scope: " + pre.getScope());
				pre.clearOldResults();
				post = walkExpression(next_sibling, pre);
			} else { // rhs
				LHSStackObject lhs = pre.popFromLhsStack();

				// To be conservative, if we don't know the security type then
				// we default to low
				SecurityType lhs_type = null;
				CommonTree prev = computePreviousSibling(ast);
				if (prev != null)
					lhs_type = SecurityType.createSecurityType(
							SecurityType.low, "Unknown var: "
									+ prev.toStringTree());
				else
					lhs_type = SecurityType.createSecurityType(
							SecurityType.low, "Unknown var");

				SecurityType rhs_type = SecurityType.createSecurityType(
						SecurityType.low, "Unknown var: " + ast.toStringTree());

				// 1. Get the taint value of the lhs
				if (lhs.getLhsValue() != null) {
					ObjectValue lhso = lhs.getLhsValue();
					if (lhso instanceof Location) {
						lhs_type = (SecurityType) pre.getPropertyValue(
								(Location) lhso, "at_Taint");
						// //////////////System.out.println("string value: " +
						// pre.getPropertyValue((Location)lhso,"at_StrValue").getObjValue());
					}
					if (lhso instanceof SecurityType) {
						lhs_type = (SecurityType) lhso;
					}
				}
				// //////////////System.out.println("in ES3Lexer.ADD rhs text: "
				// + ast.toStringTree() + "  parent:" + parent.getText() +
				// " nextSibling:" + parent.toStringTree());

				// 2. Get the taint of the rhs
				if (pre.getResultValue() != null) {
					ObjectValue rhso = pre.getResultValue();
					if (rhso instanceof Location) {
						rhs_type = (SecurityType) pre.getPropertyValue(
								(Location) rhso, "at_Taint");
						// //////////////System.out.println("string value: " +
						// pre.getPropertyValue((Location)rhso,"at_StrValue").getObjValue());

					}
					if (rhso instanceof SecurityType) {
						rhs_type = (SecurityType) rhso;
					}
				}

				// 3. Create the join of the two types
				SecurityType result_type = lhs_type;
				if (lhs_type != null)
					result_type = lhs_type.join(rhs_type);
				else
					result_type = rhs_type;

				// 4. Add this new taint to a newly created result object
				pre = operatorReturn(ast, pre, result_type);

				post = trampoline(parent, pre);
			}
			break;

		case ES3Lexer.QUE:
		case ES3Lexer.EQ:
		case ES3Lexer.NEQ:

			// Logical operators, Binary bitwise operators, Equality operators,
			// Relational operator,
			// Bitwise shift operator, Additive operators, Multiplicative
			// operators
		case ES3Lexer.LOR:
		case ES3Lexer.LAND:
		case ES3Lexer.AND:
		case ES3Lexer.OR:
		case ES3Lexer.XOR:
		case ES3Lexer.SAME:
		case ES3Lexer.NSAME:
		case ES3Lexer.LT:
		case ES3Lexer.GT:
		case ES3Lexer.LTE:
		case ES3Lexer.GTE:
		case ES3Lexer.IN:
		case ES3Lexer.SHL:
		case ES3Lexer.SHR:
		case ES3Lexer.SHU:
		case ES3Lexer.SUB:
		case ES3Lexer.MUL:
		case ES3Lexer.DIV:
		case ES3Lexer.MOD:
			if (next_sibling != null) { // lhs
				pre.pushOntoLhsStack("Lhs of binary operators: "
						+ ast.toStringTree() + " at line: " + ast.getLine()
						+ " at scope: " + pre.getScope());
				pre.clearOldResults();
				post = walkExpression(next_sibling, pre);
			} else { // rhs
				LHSStackObject lhs = pre.popFromLhsStack();

				// To be conservative, if we don't know the security type then
				// we default to low
				SecurityType lhs_type = null;
				CommonTree prev = computePreviousSibling(ast);
				if (prev != null)
					lhs_type = SecurityType.createSecurityType(
							SecurityType.low, "Unknown var: "
									+ prev.toStringTree());
				else
					lhs_type = SecurityType.createSecurityType(
							SecurityType.low, "Unknown var");

				SecurityType rhs_type = SecurityType.createSecurityType(
						SecurityType.low, "Unknown var: " + ast.toStringTree());

				// 1. Get the taint value of the lhs
				if (lhs.getLhsValue() != null) {
					ObjectValue lhso = lhs.getLhsValue();
					if (lhso instanceof Location) {
						lhs_type = (SecurityType) pre.getPropertyValue(
								(Location) lhso, "at_Taint");
						// //////////////System.out.println("string value: " +
						// pre.getPropertyValue((Location)lhso,"at_StrValue").getObjValue());
					}
					if (lhso instanceof SecurityType) {
						lhs_type = (SecurityType) lhso;
					}
				}
				// //////////////System.out.println("in ES3Lexer.ADD rhs text: "
				// + ast.toStringTree() + "  parent:" + parent.getText() +
				// " nextSibling:" + parent.toStringTree());

				// 2. Get the taint of the rhs
				if (pre.getResultValue() != null) {
					ObjectValue rhso = pre.getResultValue();
					if (rhso instanceof Location) {
						rhs_type = (SecurityType) pre.getPropertyValue(
								(Location) rhso, "at_Taint");
						// //////////////System.out.println("string value: " +
						// pre.getPropertyValue((Location)rhso,"at_StrValue").getObjValue());

					}
					if (rhso instanceof SecurityType) {
						rhs_type = (SecurityType) rhso;
					}
				}

				// 3. Create the join of the two types
				SecurityType result_type = lhs_type;
				if (lhs_type != null)
					result_type = lhs_type.join(rhs_type);
				else
					result_type = rhs_type;

				// 4. Add this new taint to a newly created result object
				pre = operatorReturn(ast, pre, result_type);

				post = trampoline(parent, pre);
			}
			break;

		// Unary Operators, Postfix operators
		case ES3Lexer.DELETE:
		case ES3Lexer.VOID:
		case ES3Lexer.TYPEOF:
		case ES3Lexer.INC:
		case ES3Lexer.DEC:
		case ES3Lexer.POS:
		case ES3Lexer.NEG:
		case ES3Lexer.INV:
		case ES3Lexer.NOT:
		case ES3Lexer.PINC:
		case ES3Lexer.PDEC:
			ObjectValue result = pre.getResultValue();
			// 1. Get the taint of the result
			SecurityType res_type;
			if (result instanceof SecurityType) {
				res_type = (SecurityType) result;
			} else {
				if (result instanceof Location) {
					res_type = (SecurityType) pre.getPropertyValue(
							(Location) result, "at_Taint");
				} else {
					res_type = this.getHighTaint();
				}
			}

			// 2. Add this new taint to a newly created result object
			pre = operatorReturn(ast, pre, res_type);

			post = trampoline(parent, pre);
			break;

		default:
			post = pre;
			break;
		}
		return post;
	}

	/**
	 * 
	 * @param pre
	 * @param parent
	 * @param ast
	 */
	private boolean performOptimization(String currentBranch, State pre,
			CommonTree parent, String type) {
		if (this.branchOptimization) { // If the branch optimization switch is
			// on
			if (this.getHeapSetSize(currentBranch) == 0) { // If there are no
				// heaps in the set
				// for this
				// particular
				// conditional
				if (Math.random() > 0.5 && joinTracker.size() < 10000)
					this.addElementToHeapSet(currentBranch, pre.getHeap()
							.deepClone());
				return false;
			} else {
				// //////System.out.println("Heap size is: " +
				// this.getHeapSetSize(ifvar) + " at conditional:" + ifvar);
				Heap matching = this.getMatchingHeap(currentBranch, pre
						.getHeap());
				if (matching != null) {
					pre.setHeap(matching);
					this.filenumber++; // Increase the path count even if it is
					// not taken
					return true;
				} else {
					if (Math.random() > 0.5 && joinTracker.size() < 10000)
						this.addElementToHeapSet(currentBranch, pre.getHeap()
								.deepClone());
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * @param ast
	 * @param pre
	 * @param lhsobject
	 */
	private void checkInnerHTMLTaint(CommonTree ast, State pre,
			ObjectValue lhsobject) {
		if (pre.getPropertyValue((Location) lhsobject, "at_Taint") != null) {
			SecurityType lhsTaint = (SecurityType) pre.getPropertyValue(
					(Location) lhsobject, "at_Taint");
			if (lhsTaint.isTainted()) {
				// TODO: Break here?
				// //////////////System.out.println("InnerHTML is tainted!");

				// Add the taint information to innerHTMLSet
				printString("High value is sent to innerHTML at method call:  at line: "
						+ ast.getLine()
						+ " tainted by: "
						+ lhsTaint.getObjValue());
				LinkedList innerList = new LinkedList<String>();
				innerList.add(ast.getParent().toStringTree());
				innerList.add(lhsTaint.getObjValue());
				innerList.add(ast.getLine());
				innerList.add(currentfilename);
				addToInnerHTMLSet(innerList);
			}
		}
	}

	private State walkNewCall(CommonTree ast, State pre, CommonTree parent) {
		State post;
		ObjectValue fv = pre.getResultValue();
		// Get the arguments value from the stack
		LHSStackObject prev = pre.popFromLhsStack();
		Location argsloc = (Location) prev.getLhsValue();

		if (fv != null) {
			if (isObject(pre, fv)) { // if the returned value is an object
				if (pre.getPropertyValue((Location) fv, "at_Construct") != null) {

					pre.setProperty(argsloc, "__callee__", (Location) fv);

					// call the at_Construct method
					JSObject new_ob = null;
					Location newob_loc = null;
					Location prot_val = (Location) pre.getPropertyValue(
							(Location) fv, "prototype");
					if (isObject(pre, prot_val)) { // if the prototype is an
						// object
						new_ob = PredefinedObjectTemplates.new_object("Object",
								prot_val, this.getHighTaint());
					} else { // if the prototype is not an object
						new_ob = PredefinedObjectTemplates.new_object("Object",
								NativeObjects.ObjectProt, this.getHighTaint());
					}
					newob_loc = pre.addToHeap(ast.getLine() + "new_ob", new_ob);
					// ////////////////System.out.println("function call: " +
					// ast.getChild(0).toStringTree() + " inside: " +
					// ast.toStringTree() );

					// Push newob_loc into the stack in the parent object,
					// just in case we need it
					// Pop this value in the NEW
					LHSStackObject lh = new LHSStackObject();
					lh.setDescription("at walkNew: " + ast.getLine()
							+ " at scope: " + pre.getScope());
					lh.setLhsParent(newob_loc);
					pre.pushOntoLhsStack(lh);

					post = atCall(ast, pre, newob_loc, (Location) fv, argsloc);

				} else { // if the object does not have an "at_Construct" field

					// Create a new parent object in any case
					JSObject new_ob = PredefinedObjectTemplates.new_object(
							"Object", NativeObjects.ObjectProt, this
									.getHighTaint());
					Location newob_loc = pre.addToHeap(
							ast.getLine() + "new_ob", new_ob);

					// Push newob_loc into the stack in the parent object,
					// just in case we need it
					// Pop this value in the NEW
					LHSStackObject lh = new LHSStackObject();
					lh.setDescription("at walkNew: " + ast.getLine()
							+ " at scope: " + pre.getScope());
					lh.setLhsParent(newob_loc);
					pre.pushOntoLhsStack(lh);

					// Check if is a dummy object
					if (pre.getPropertyValue((Location) fv, "at_Dummy") != null) {
						// If it is, then add the taints of all the arguments to
						// the new object created
						// return this as a result
						// //////System.out.println(" addArgumentTaints at loc: "
						// + ast.getLine());
						SecurityType objTnt = addArgumentTaints(pre, newob_loc,
								argsloc);
						pre.setProperty(newob_loc, "at_Taint", objTnt);

						// Also add the taint of the dummy object if it is low
						SecurityType tnt = (SecurityType) pre.getPropertyValue(
								(Location) fv, "at_Taint");
						if (tnt.isTainted()) {
							pre.setProperty(newob_loc, "at_Taint", SecurityType
									.createSecurityType(SecurityType.low, tnt
											.getObjValue()));
						}

						pre.setResultValue(newob_loc);
					} else { // if it is not a dummy object
						// something is wrong -- a function was not declared
						// properly
						accessErrorList.add(ast.toStringTree() + "at line no: "
								+ ast.getLine() + " in file: "
								+ currentfilename);
						pre.clearOldResults();
					}
					post = trampoline(parent, pre);
				}
			} else { // If an object is not returned

				// Create a new parent object in any case
				JSObject new_ob1 = PredefinedObjectTemplates
						.new_object("Object", NativeObjects.ObjectProt, this
								.getHighTaint());
				Location newob_loc1 = pre.addToHeap(ast.getLine() + "new_ob",
						new_ob1);
				// Push newob_loc into the stack in the parent object,
				// just in case we need it
				// Pop this value in the NEW
				LHSStackObject lh1 = new LHSStackObject();
				lh1.setDescription("at walkNew: " + ast.getLine()
						+ " at scope: " + pre.getScope());
				lh1.setLhsParent(newob_loc1);
				pre.pushOntoLhsStack(lh1);

				// Create taint
				// //////System.out.println(" addArgumentTaints at loc: " +
				// ast.getLine());
				SecurityType taint = addArgumentTaints(pre, null, argsloc);
				// Create a dummy object
				Location dummy = pre.getHeap().createDummyObjectInHeap(ast,
						taint);

				// return this value as the result value
				pre.setResultValue(dummy);
				// add the current node to the list of error nodes
				accessErrorList.add(ast.toStringTree() + "at line no: "
						+ ast.getLine() + " in file: " + currentfilename);
				// Call the trampoline on the parent
				post = trampoline(parent, pre);
			}
		} else { // If the function does not return any object, then the return
			// value is null -- this should be an error
			// Create a new parent object in any case
			JSObject new_ob1 = PredefinedObjectTemplates.new_object("Object",
					NativeObjects.ObjectProt, this.getHighTaint());
			Location newob_loc1 = pre.addToHeap(ast.getLine() + "new_ob",
					new_ob1);
			// Push newob_loc into the stack in the parent object,
			// just in case we need it
			// Pop this value in the NEW
			LHSStackObject lh1 = new LHSStackObject();
			lh1.setDescription("at walkNew: " + ast.getLine() + " at scope: "
					+ pre.getScope());
			lh1.setLhsParent(newob_loc1);
			pre.pushOntoLhsStack(lh1);

			// add argument taints
			// //////System.out.println(" addArgumentTaints at loc: " +
			// ast.getLine());
			SecurityType tnt = addArgumentTaints(pre, null, argsloc);
			// Create a dummy object
			Location dummy = pre.getHeap().createDummyObjectInHeap(ast, tnt);

			// return this value as the result value
			pre.setResultValue(dummy);
			// add the current node to the list of error nodes
			accessErrorList.add(ast.toStringTree() + "at line no: "
					+ ast.getLine() + " in file: " + currentfilename);
			// Call the trampoline on the parent
			post = trampoline(parent, pre);
		}
		return post;
	}

	/**
	 * Recursively adds the taints of all the function arguments to the taint of
	 * the location fv
	 * 
	 * @param pre
	 * @param fv
	 * @param argsloc
	 */
	private SecurityType addArgumentTaints(State pre, Location fv,
			Location argsloc) {
		int arglen = pre.getPropertyValue(argsloc, "__length__").getNumObjVal();
		SecurityType function_taint = SecurityType.createSecurityType(
				SecurityType.low, "Dummy obj");
		if (fv != null)
			function_taint = (SecurityType) pre
					.getPropertyValue(fv, "at_Taint");

		for (int i = 1; i <= arglen; i++) {
			ObjectValue arg = pre.getPropertyValue(argsloc, "__"
					+ String.valueOf(i) + "__");
			// ////////System.out.println("argument length:" + arglen +
			// " : current arg number: " +"__" + String.valueOf(i) + "__");
			if (arg instanceof Location) {
				SecurityType taint = computeObjectTaint(pre, (Location) arg);
				function_taint = function_taint.join(taint);
			}
		}
		// pre.setProperty(fv, "at_Taint", function_taint);
		return function_taint;
	}

	/**
	 * @param pre
	 * @param arg
	 * @return
	 */
	private SecurityType computeObjectTaint(State pre, Location arg) {

		SecurityType taint = this.getHighTaint();
		try {
			JSObject obj = pre.getHeap().get(arg);
			if (obj != null) {
				taint = obj.computeTaint(pre, this.libraryProperties);
			}
		} catch (Exception ce) {
			ce.printStackTrace();
		}
		return taint;
	}

	private State walkFunctionCall(CommonTree ast, State pre, CommonTree parent) {

		// ////////////System.out.println("walk Function call: " +
		// ast.toStringTree());
		State post;
		ObjectValue result = pre.getResultValue();
		Location result_parent = pre.getResultParent();

		Location thisLocation = null;
		// Get the arguments value from the stack
		LHSStackObject prev = pre.popFromLhsStack();
		Location argsloc = (Location) prev.getLhsValue();

		// Call the function and return the ResultValue
		if (result != null) { // If we could find an object value of the
			// expression

			// Check if the result value is a location
			if (result instanceof Location) { // if result is a reference
				if (isActivation(pre, (Location) result)) { // Check if the
					// function object
					// has an
					// at_Activation
					// property
					thisLocation = pre.getGlobal();
				} else { // If the at_Activation property is missing
					thisLocation = result_parent;
				}
			} else { // if result is not a reference
				thisLocation = pre.getGlobal();
			}

			// Set the __callee__ property of the function object
			pre.setProperty(argsloc, "__callee__", result);

			// Check out if this a function with dynamic number of arguments ex:
			// push
			if (pre.getPropertyValue((Location) result, "at_Dynamic") != null) {
				// ////////////System.out.println("this loc and parent loc: " +
				// (thisLocation == result_parent));
				// //////System.out.println(" addArgumentTaints at loc: " +
				// ast.getLine());
				SecurityType arg_taint = addArgumentTaints(pre, thisLocation,
						argsloc);
				pre.addProperty(thisLocation, "at_Taint", arg_taint);
			}

			if (result_parent != null && result_parent instanceof Location) {
				// ////////////System.out.println("parent taint:  " +
				// pre.getPropertyValue(result_parent, "at_Taint"));
				// ////////////System.out.println("parent JSObject: " +
				// pre.getHeap().get(result_parent).toString());
				checkForWriteToLocalFile(ast, pre, result_parent);
			}

			// Call the at_Fun function
			post = atFun(ast, pre, result, thisLocation, argsloc);

		} else { // If we couldn't find the function object

			// ////////////System.out.println("Reached line 1457: Checking for appendChild first");
			checkForAppendChildCalls(ast, pre, argsloc, parent);

			// Get argument taints
			// //////System.out.println(" addArgumentTaints at loc: " +
			// ast.getLine());
			SecurityType argtnt = addArgumentTaints(pre, null, argsloc);
			// Create a dummy object
			Location dummy = pre.getHeap().createDummyObjectInHeap(ast, argtnt);

			// return this value as the result value
			pre.setResultValue(dummy);

			// add the current node to the list of error nodes
			accessErrorList.add(ast.toStringTree() + " at line no: "
					+ ast.getLine() + " in file: " + currentfilename);

			// Call trampoline on the parent
			post = trampoline(parent, pre);
		}
		return post;
	}

	/**
	 * @param ast
	 * @param pre
	 * @param result_parent
	 */
	private void checkForWriteToLocalFile(CommonTree ast, State pre,
			Location result_parent) {
		if (pre.getPropertyValue(result_parent, "interfaceName") != null) {
			Location interface_loc = (Location) pre.getPropertyValue(
					result_parent, "interfaceName");
			String interfaceName = pre.getPropertyValue(interface_loc,
					"at_StrValue").getObjValue();
			if (interfaceName.equals("\"nsIFileOutputStream\"")) {
				// ////////////System.out.println("parent taint: nsIFileOutputStream  "
				// + pre.getPropertyValue(result_parent, "at_Taint"));
				SecurityType parentTaint = (SecurityType) pre.getPropertyValue(
						result_parent, "at_Taint");
				if (parentTaint.isTainted()) {
					printString("High value is sent to local file at method call:  at line: "
							+ ast.getLine()
							+ " tainted by: "
							+ parentTaint.getObjValue());
					LinkedList<String> writeToFileList = new LinkedList<String>();
					writeToFileList.add(ast.toStringTree());
					writeToFileList.add(parentTaint.getObjValue());
					writeToFileList.add(String.valueOf(ast.getLine()));
					writeToFileList.add(currentfilename);
					addToWrtToLocalFileSet(writeToFileList);
				}
			}
		}
	}

	/**
	 * This function is called after we finish evaluating the expression in the
	 * rhs of the assignment. The lhs value is already on the stack.
	 * 
	 * @param ast
	 *            -- assignment commontree
	 * @param pre
	 */
	private State walkAssign(CommonTree ast, State pre, boolean isOpAssign) {
		// 1. Walk the LHS Expression and get it's object value
		LHSStackObject lso = pre.popFromLhsStack();
		CommonTree lhs = (CommonTree) ast.getChild(0);

		// The lhs_val is either initialized to a null or the value of the lhs
		ObjectValue lhs_val = lso.getLhsValue();
		// id_parent is the location corresponding to the parent of the lhs or
		// null(if var is not found)
		Location id_parent = lso.getLhsParent();
		// Is lhs an innerHTML object?
		boolean isInner = lso.isInnerHTML();

		// 2. Walk the RHS Expression and get it's object value
		// The rhs_val should be associated with the lhs_val location in the
		// current heap and scope
		// The rhs_val could be null if the rhs is a primitive value
		ObjectValue rhs_val = pre.getResultValue();
		Location rhs_parent = pre.getResultParent();

		// The assignment operator is of the form += -= etc..
		if (isOpAssign) {
			SecurityType lhsTaint = null;
			if (lhs_val != null) {
				if (lhs_val instanceof Location) {
					lhsTaint = (SecurityType) pre.getPropertyValue(
							(Location) lhs_val, "at_Taint");
				}
			}
			if (rhs_val != null) {
				if (rhs_val instanceof Location) {
					// SecurityType lhsTaint =
					// (SecurityType)pre.getPropertyValue(new_lhs_obj,
					// "at_Taint");
					SecurityType rhsTaint = (SecurityType) pre
							.getPropertyValue((Location) rhs_val, "at_Taint");
					if (lhsTaint != null)
						lhsTaint = lhsTaint.join(rhsTaint);
					else
						lhsTaint = rhsTaint;
				}
			}
			rhs_val = pre.getHeap().createDummyObjectInHeap(lhs, lhsTaint);
		}

		switch (lhs.getType()) {
		case ES3Lexer.Identifier:
			// //////////////////System.out.println("lhs parent: " + id_parent +
			// " lhs text:"+ lhs.getText());
			// TODO: Remove: Hack to add a low security type
			/*
			 * if(rhs_val != null){ if(lhs.getText().endsWith("low")){
			 * if(rhs_val instanceof Location){
			 * pre.addProperty((Location)rhs_val, "at_Taint",
			 * SecurityType.createSecurityType(SecurityType.low)); } } }
			 */
			if (id_parent != null) { // if the variable is already in the scope
				// Add the new rhs value to the lhs variable
				pre.addProperty(id_parent, lhs.getText(), rhs_val);
				pre.setResultValue(null);
				// //////////////////System.out.println("new post: " +
				// rhs_post);
			} else {
				// When the parent is null
				// Add the (lhs,rhs) pair in the global object
				pre.addProperty(pre.getGlobal(), lhs.getText(), rhs_val);
				pre.setResultValue(null);
			}
			break;

		case ES3Lexer.BYFIELD:
			String lhs_var = lhs.getChild(1).getText();
			// lhs_post =
			// walkExpression((CommonTree)lhs.getChild(0),pre.clone());

			// TODO: we are assuming that the result value is a location, is it
			// always correct?
			// id_parent = (Location)lhs_post.getResultValue();
			// ////////////////System.out.println("id_parent: " + id_parent +
			// " result value: "+ lhs_val + " lhsvar: " + lhs.toStringTree());

			// can we get a reference to the parent object
			if (id_parent != null) {
				// Add the new value or replace old value into the parent object
				pre.addProperty(id_parent, lhs_var, rhs_val);
			} else {
				// TODO: Do something if the parent is null
				// For now record the name of the object and
				// see if it is a library stub that we need to create
				accessErrorList.add(lhs.toStringTree() + "at line no: "
						+ ast.getLine() + " in file: " + currentfilename);
			}
			break;

		case ES3Lexer.BYINDEX:

			// First find the exact string value of the index
			String byindex_var = findIndexString((CommonTree) lhs.getChild(1),
					pre);

			// lhs_post =
			// walkExpression((CommonTree)lhs.getChild(0),pre.clone());

			// TODO: we are assuming that the result value is a location, is it
			// always correct?
			// id_parent = (Location)lhs_post.getResultValue();
			// ////////////////System.out.println("id_parent: " + id_parent +
			// " lhs string: "+ byindex_var );

			if (id_parent != null) {
				// Add the new value or replace old value into the parent object
				if (byindex_var != null) { // if we can find the index string
					// value statically
					pre.addProperty(id_parent, byindex_var, rhs_val);
				} else {
					// Take the security type of the RHS and join it with the
					// security
					// type of all the properties of the lhs parent
					if (rhs_val != null) {
						// Get the taint value of the rhs
						SecurityType taint_val = (SecurityType) pre
								.getPropertyValue((Location) rhs_val,
										"at_Taint");
						// Get the JSObject of the parent location from the heap
						JSObject parentObject = pre.getHeap().get(id_parent);
						// Get the properties of the parent object
						Set<String> parent_properties = parentObject
								.getKeySet();
						for (String key : parent_properties) {

							if (parentObject.get(key) instanceof Location) {
								// If the property is a location, then change
								// the taint field of the object to the rhs
								// taint field
								Location property_loc = (Location) parentObject
										.get(key);
								pre.setProperty(property_loc, "at_Taint",
										taint_val);
							}
						}
					}
				}
			} else {
				// TODO: Do something if the parent is null
				accessErrorList.add(lhs.toStringTree() + "at line no: "
						+ ast.getLine() + " in file: " + currentfilename);
			}

			break;

		default:
			break;
		}
		// Reset the result value list
		pre.clearOldResults();
		pre.setResultParent(id_parent);
		pre.setResultValue(rhs_val);
		pre.setInnerHTML(isInner);

		// TODO to be removed later - for debugging purposes
		if (rhs_val != null) {
			if (rhs_val instanceof Location) {
				SecurityType taint = (SecurityType) pre.getPropertyValue(
						(Location) rhs_val, "at_Taint");
				if (taint != null) {
					// //////////////System.out.println("assign taint: " +
					// taint.isTainted());
				}
			}
		}
		return pre;
	}

	/**
	 * To walk expressions which produce only one State in return. Each case
	 * will end in a call to the trampoline() function in order to run the
	 * program in CPS
	 * 
	 * @param ast
	 * @param pre
	 * @return
	 */
	public State walkExpression(CommonTree ast, State pre) {
		State post = pre;
		if (pre == null) // If the input state is null
			return null; // we cannot analyze the AST

		if (ast == null) // If the tree to be analyzed is null
			return pre; // return the pre

		try {
			switch (ast.getType()) {
			/*
			 * 
			 * Statements (Copied over from the walk() method)
			 */

			case ES3Lexer.ROOT_ID:
				CommonTree firstChild = (CommonTree) ast.getChild(0);

				if (firstChild != null) {
					post = walkExpression(firstChild, pre);
				} else {
					post = pre;
				}
				break;

			case ES3Lexer.VAR:
				if (ast.getChildCount() > 0) {
					post = walkExpression((CommonTree) ast.getChild(0), pre);
				} else {
					post = trampoline(ast, pre);
				}
				break;

			case ES3Lexer.ASSIGN:
				post = walkExpression((CommonTree) ast.getChild(0), pre);
				break;

			case ES3Lexer.ADDASS: // = '+=' ;
			case ES3Lexer.SUBASS: // = '-=' ;
			case ES3Lexer.MULASS: // = '*=' ;
			case ES3Lexer.MODASS: // = '%=' ;
			case ES3Lexer.SHLASS: // = '<<=' ;
			case ES3Lexer.SHRASS: // = '>>=' ;
			case ES3Lexer.SHUASS: // = '>>>=' ;
			case ES3Lexer.ANDASS: // = '&=' ;
			case ES3Lexer.ORASS: // = '|=' ;
			case ES3Lexer.XORASS: // = '^=' ;
			case ES3Lexer.DIVASS: // = '/=' ;
				post = walkExpression((CommonTree) ast.getChild(0), pre);
				break;

			case ES3Lexer.IF:

				HashMap<String, Integer> recTracker;
				HashMap<String, Integer> lpTracker;

				String currentBranch = getBranchName(ast, pre, "fork");

				if (this.isConditionalOrder()) {
					CommonTree else_tree = null;
					int current_codesize = this.maxLines;

					// add to the branch stack
					if (this.branchOptimization)
						this.addToBracketStack("fork", ")", currentBranch);
					// Reached here after the statements in the then block or
					// else block have finished executing
					boolean optimize = performOptimization(currentBranch, pre,
							ast, "fork");
					// //////System.out.println("branch number: " +
					// currentBranch + " at line:" + ast.getLine());
					if (optimize) {
						printString("Matched at: " + ast.getLine() + " fork: "
								+ currentBranch);
						this.addToBracketStack("fork", "[", currentBranch);
						return pre;
					}

					State pre_else = pre;
					pre = pre.freezeState();

					// Record the current state
					int callStackSize = pre.getCallStk().size();

					printString(" (" + ast.getChild(0).toStringTree() + ")"
							+ "at line no. : " + ast.getLine()
							+ " callstacksize: " + callStackSize);

					beforeConditional(ast, pre);
					// ////////System.out.println("Before Cond: " +
					// this.callTracker.toString() + " : " +
					// ast.getChild(0).toStringTree());
					recTracker = (HashMap<String, Integer>) this.callTracker
							.clone();
					lpTracker = (HashMap<String, Integer>) this.loopTracker
							.clone();

					// Walk the then branch
					CommonTree then_tree = (CommonTree) ast.getChild(1);
					pre = walkExpression(then_tree, post);

					printString("end of if block ("
							+ ast.getChild(0).toStringTree() + ")"
							+ "at line no. : " + ast.getLine()
							+ " callstacksize: " + callStackSize);
					if (this.branchOptimization)
						this.addToBracketStack("fork", "[", currentBranch);
					// Restore the state as it was before the walk of the rest
					// of the program
					afterConditional(ast, pre);
					this.setLoopTracker(lpTracker);
					this.setCallTracker(recTracker);
					pre.unfreezeState(pre_else);

					// ////////System.out.println("After Cond: " +
					// this.callTracker.toString() + " : " +
					// ast.getChild(0).toStringTree());

					// ////////////////System.out.println("after if: " +
					// post.toString());
					// post.printInFile(this.resultFolderName + this.filenumber+
					// "example.dot" );
					boolean exit_path = endPath(-1);
					if (exit_path) {
						return post;
					}
					// resultStates.addState(post.deepClone());
					// heapSet.add(post.getHeap().deepClone());
					// restore state
					// //afterConditional(post);

					// add to branch stack
					if (this.branchOptimization)
						addToBracketStack("fork", "]", currentBranch);

					/*
					 * optimize = performOptimization(currentBranch, post,
					 * ast,"fork"); ////////System.out.println("branch number: "
					 * + currentBranch + " at line:" + ast.getLine());
					 * if(optimize){ printString("Matched at: " + ast.getLine()
					 * + " fork: " + currentBranch);
					 * this.addToBracketStack("fork", "[", currentBranch);
					 * return post; }
					 */

					if ((CommonTree) ast.getChild(2) != null) { // if there is
						// an else
						// branch
						printString(" !(" + ast.getChild(0).toStringTree()
								+ ")" + "at line no. : " + ast.getLine()
								+ " callstacksize: " + pre.getCallStk().size());
						beforeConditional(ast, pre);

						// ////////System.out.println("Before Cond: " +
						// this.callTracker.toString() + " : " +
						// ast.getChild(0).toStringTree());
						recTracker = (HashMap<String, Integer>) this.callTracker
								.clone();
						lpTracker = (HashMap<String, Integer>) this.loopTracker
								.clone();

						else_tree = (CommonTree) ast.getChild(2);
						post = walkExpression(else_tree, pre);

						printString("end of else block !("
								+ ast.getChild(0).toStringTree() + ")"
								+ "at line no. : " + ast.getLine()
								+ " callstacksize: " + pre.getCallStk().size());

						if (this.branchOptimization)
							addToBracketStack("fork", "[", currentBranch);

						afterConditional(ast, post);
						this.setLoopTracker(lpTracker);
						this.setCallTracker(recTracker);
						// ////////System.out.println("After Cond: " +
						// this.callTracker.toString() + " : " +
						// ast.getChild(0).toStringTree());

						// ////////////////System.out.println("after else 1: " +
						// post.getHeap().toString());

						// Print the graph representation of the heap
						// post.printInFile(this.resultFolderName +
						// this.filenumber + "example.dot");

						boolean exit_pathe1 = endPath(current_codesize);
						if (exit_pathe1) {
							return post;
						}

					} else { // no else branch, then skip "if" too for
						// simulating the path where the conditional is
						// false

						printString(" !(" + ast.getChild(0).toStringTree()
								+ ")" + "at line no. : " + ast.getLine()
								+ " callstacksize: " + pre.getCallStk().size());
						beforeConditional(ast, pre);
						// ////////System.out.println("Before Cond: " +
						// this.callTracker.toString() + " : " +
						// ast.getChild(0).toStringTree());
						recTracker = (HashMap<String, Integer>) this.callTracker
								.clone();
						lpTracker = (HashMap<String, Integer>) this.loopTracker
								.clone();

						post = trampoline(ast, pre);

						printString("end of !("
								+ ast.getChild(0).toStringTree() + ")"
								+ "at line no. : " + ast.getLine()
								+ " callstacksize: " + pre.getCallStk().size());

						if (this.branchOptimization)
							addToBracketStack("fork", "[", currentBranch);
						afterConditional(ast, post);
						this.setLoopTracker(lpTracker);
						this.setCallTracker(recTracker);
						// ////////System.out.println("After Cond: " +
						// this.callTracker.toString() + " : " +
						// ast.getChild(0).toStringTree());

						// ////////////////System.out.println("after else 2: " +
						// post.toString());
						// Print a graph representation of the heap
						// post.printInFile(this.resultFolderName +
						// this.filenumber + "example.dot");
						boolean exit_pathe2 = endPath(current_codesize);
						if (exit_pathe2) {
							return post;
						}
					}

				} else {

					if (this.branchOptimization)
						this.addToBracketStack("fork", ")", currentBranch);

					boolean optimize = performOptimization(currentBranch, pre,
							ast, "fork");
					// //////System.out.println("branch number: " +
					// currentBranch + " at line:" + ast.getLine());
					if (optimize) {
						printString("Matched at: " + ast.getLine() + " fork: "
								+ currentBranch);
						this.addToBracketStack("fork", "[", currentBranch);
						return pre;
					}

					CommonTree else_tree = null;
					int current_codesize = this.maxLines;
					State pre_else = pre;
					pre = pre.freezeState();

					if ((CommonTree) ast.getChild(2) != null) { // if there is
						// an else
						// branch
						printString(" !(" + ast.getChild(0).toStringTree()
								+ ")" + "at line no. : " + ast.getLine()
								+ " callstacksize: " + pre.getCallStk().size());
						beforeConditional(ast, pre);

						// ////////System.out.println("Before Cond: " +
						// this.callTracker.toString() + " : " +
						// ast.getChild(0).toStringTree());
						recTracker = (HashMap<String, Integer>) this.callTracker
								.clone();
						lpTracker = (HashMap<String, Integer>) this.loopTracker
								.clone();

						else_tree = (CommonTree) ast.getChild(2);
						post = walkExpression(else_tree, pre);

						printString("end of else block !("
								+ ast.getChild(0).toStringTree() + ")"
								+ "at line no. : " + ast.getLine()
								+ " callstacksize: " + pre.getCallStk().size());

						if (this.branchOptimization)
							this.addToBracketStack("fork", "[", currentBranch);
						afterConditional(ast, post);
						this.setLoopTracker(lpTracker);
						this.setCallTracker(recTracker);
						// ////////System.out.println("After Cond: " +
						// this.callTracker.toString() + " : " +
						// ast.getChild(0).toStringTree());

						// ////////////////System.out.println("after else 1: " +
						// post.getHeap().toString());

						// Print the graph representation of the heap
						// post.printInFile(this.resultFolderName +
						// this.filenumber + "example.dot");

						boolean exit_pathe1 = endPath(current_codesize);
						if (exit_pathe1) {
							return post;
						}

					} else { // no else branch, then skip "if" too for
						// simulating the path where the conditional is
						// false

						printString(" !(" + ast.getChild(0).toStringTree()
								+ ")" + "at line no. : " + ast.getLine()
								+ " callstacksize: " + pre.getCallStk().size());
						beforeConditional(ast, pre);
						// ////////System.out.println("Before Cond: " +
						// this.callTracker.toString() + " : " +
						// ast.getChild(0).toStringTree());
						recTracker = (HashMap<String, Integer>) this.callTracker
								.clone();
						lpTracker = (HashMap<String, Integer>) this.loopTracker
								.clone();

						post = trampoline(ast, pre);

						printString("end of !("
								+ ast.getChild(0).toStringTree() + ")"
								+ "at line no. : " + ast.getLine()
								+ " callstacksize: " + pre.getCallStk().size());

						if (this.branchOptimization)
							this.addToBracketStack("fork", "[", currentBranch);
						afterConditional(ast, post);
						this.setLoopTracker(lpTracker);
						this.setCallTracker(recTracker);
						// ////////System.out.println("After Cond: " +
						// this.callTracker.toString() + " : " +
						// ast.getChild(0).toStringTree());

						// ////////////////System.out.println("after else 2: " +
						// post.toString());
						// Print a graph representation of the heap
						// post.printInFile(this.resultFolderName +
						// this.this.filenumber + "example.dot");
						boolean exit_pathe2 = endPath(current_codesize);
						if (exit_pathe2) {
							return post;
						}
					}

					post.unfreezeState(pre_else);

					// add to branch stack
					if (this.branchOptimization)
						this.addToBracketStack("fork", "]", currentBranch);

					/*
					 * optimize = performOptimization(currentBranch,post,
					 * ast,"fork"); ////////System.out.println("branch number: "
					 * + currentBranch + " at line:" + ast.getLine());
					 * if(optimize){ printString("Matched at: " + ast.getLine()
					 * + " fork: " + currentBranch);
					 * this.addToBracketStack("fork", "[", currentBranch);
					 * return post; }
					 */
					// Record the current state
					int callStackSize = pre.getCallStk().size();

					printString(" (" + ast.getChild(0).toStringTree() + ")"
							+ "at line no. : " + ast.getLine()
							+ " callstacksize: " + callStackSize);

					beforeConditional(ast, post);
					// ////////System.out.println("Before Cond: " +
					// this.callTracker.toString() + " : " +
					// ast.getChild(0).toStringTree());
					recTracker = (HashMap<String, Integer>) this.callTracker
							.clone();
					lpTracker = (HashMap<String, Integer>) this.loopTracker
							.clone();

					// Walk the then branch
					CommonTree then_tree = (CommonTree) ast.getChild(1);
					post = walkExpression(then_tree, post);

					printString("end of if block ("
							+ ast.getChild(0).toStringTree() + ")"
							+ "at line no. : " + ast.getLine()
							+ " callstacksize: " + callStackSize);

					if (this.branchOptimization)
						this.addToBracketStack("fork", "[", currentBranch);
					// Restore the state as it was before the walk of the rest
					// of the program
					afterConditional(ast, post);
					this.setLoopTracker(lpTracker);
					this.setCallTracker(recTracker);

					// ////////////////System.out.println("after if: " +
					// post.toString());
					// post.printInFile(this.resultFolderName + this.filenumber+
					// "example.dot" );
					boolean exit_path = endPath(-1);
					if (exit_path) {
						return post;
					}
					// resultStates.addState(post.deepClone());
					// heapSet.add(post.getHeap().deepClone());
					// restore state
					// //afterConditional(post);

				}

				// Retrieved the stored pre_else state
				// //afterConditional(post);
				// ////////////////System.out.println("pre scope: " +
				// pre_else1.getScope() + "  :Scope before if: " +
				// pre_else.getScope());
				break;

			case ES3Lexer.WHILE:
				int callStackSize1;
				if (!this.whileOrder) {
					callStackSize1 = pre.getCallStk().size();
					int current_codesize_w = this.maxLines;

					State pre_while = pre;
					pre = pre.freezeState();
					printString(" !(" + ast.getChild(0).toStringTree() + ")"
							+ "at line no. : " + ast.getLine()
							+ " callstacksize: " + callStackSize1);

					beforeConditional(ast, pre);
					// ////System.out.println("Before Cond: " +
					// this.callTracker.toString() + " : " +
					// ast.getChild(0).toStringTree());
					HashMap<String, Integer> recTracker1 = (HashMap<String, Integer>) this.callTracker
							.clone();
					HashMap<String, Integer> lpTracker1 = (HashMap<String, Integer>) this.loopTracker
							.clone();

					// To execute the loop zero times
					post = trampoline(ast, pre);

					printString("end of !(" + ast.getChild(0).toStringTree()
							+ ")" + "at line no. : " + ast.getLine()
							+ " callstacksize: " + callStackSize1);
					afterConditional(ast, post);
					this.setLoopTracker(lpTracker1);
					this.setCallTracker(recTracker1);
					// ////System.out.println("After Cond: " +
					// this.callTracker.toString() + " : " +
					// ast.getChild(0).toStringTree());
					post.unfreezeState(pre_while);

					// heapSet.add(post.getHeap().deepClone());
					// post.printInFile(this.resultFolderName + this.filenumber+
					// "example.dot" );
					boolean exit_path1 = endPath(current_codesize_w);
					if (exit_path1) {
						return post;
					}

					/* Execute the loop more than one time */

					int loopcounter = addOneToLoopCounter(ast.getLine()
							+ this.currentfilename);
					if (loopcounter <= this.maxLoopIter) {
						callStackSize1 = pre.getCallStk().size();

						printString(" loop iteration ("
								+ ast.getChild(0).toStringTree() + ")"
								+ "at line no. : " + ast.getLine()
								+ " callstacksize: " + callStackSize1);

						beforeConditional(ast, pre);
						// ////System.out.println("Before Cond: " +
						// this.callTracker.toString() + " : " +
						// ast.getChild(0).toStringTree());
						HashMap<String, Integer> recTracker2 = (HashMap<String, Integer>) this.callTracker
								.clone();
						HashMap<String, Integer> lpTracker2 = (HashMap<String, Integer>) this.loopTracker
								.clone();

						post = walkExpression((CommonTree) ast.getChild(1),
								post);

						printString(" end of loop iteration ("
								+ ast.getChild(0).toStringTree() + ")"
								+ "at line no. : " + ast.getLine()
								+ " callstacksize: " + callStackSize1);

						afterConditional(ast, post);
						this.setLoopTracker(lpTracker2);
						this.setCallTracker(recTracker2);
						// ////System.out.println("After Cond: " +
						// this.callTracker.toString() + " : " +
						// ast.getChild(0).toStringTree());

						boolean exit_path3 = endPath(-1);
						if (exit_path3) {
							return post;
						}
					}

				} else {

					/* Execute the loop more than one time */

					int loopcounter = addOneToLoopCounter(ast.getLine()
							+ this.currentfilename);
					if (loopcounter <= this.maxLoopIter) {
						callStackSize1 = pre.getCallStk().size();

						printString(" loop iteration ("
								+ ast.getChild(0).toStringTree() + ")"
								+ "at line no. : " + ast.getLine()
								+ " callstacksize: " + callStackSize1);
						State pre_while = pre;
						pre = pre.freezeState();
						beforeConditional(ast, pre);
						// ////////System.out.println("Before Cond: " +
						// this.callTracker.toString() + " : " +
						// ast.getChild(0).toStringTree());
						HashMap<String, Integer> recTracker2 = (HashMap<String, Integer>) this.callTracker
								.clone();
						HashMap<String, Integer> lpTracker2 = (HashMap<String, Integer>) this.loopTracker
								.clone();

						post = walkExpression((CommonTree) ast.getChild(1), pre);

						printString(" end of loop iteration ("
								+ ast.getChild(0).toStringTree() + ")"
								+ "at line no. : " + ast.getLine()
								+ " callstacksize: " + callStackSize1);

						afterConditional(ast, post);
						this.setLoopTracker(lpTracker2);
						this.setCallTracker(recTracker2);
						// ////////System.out.println("After Cond: " +
						// this.callTracker.toString() + " : " +
						// ast.getChild(0).toStringTree());
						post.unfreezeState(pre_while);

						boolean exit_path3 = endPath(-1);
						if (exit_path3) {
							return post;
						}
					}

					callStackSize1 = pre.getCallStk().size();
					int current_codesize_w = this.maxLines;
					printString(" !(" + ast.getChild(0).toStringTree() + ")"
							+ "at line no. : " + ast.getLine()
							+ " callstacksize: " + callStackSize1);

					beforeConditional(ast, pre);
					// ////////System.out.println("Before Cond: " +
					// this.callTracker.toString() + " : " +
					// ast.getChild(0).toStringTree());
					HashMap<String, Integer> recTracker1 = (HashMap<String, Integer>) this.callTracker
							.clone();
					HashMap<String, Integer> lpTracker1 = (HashMap<String, Integer>) this.loopTracker
							.clone();

					// To execute the loop zero times
					post = trampoline(ast, pre);

					printString("end of !(" + ast.getChild(0).toStringTree()
							+ ")" + "at line no. : " + ast.getLine()
							+ " callstacksize: " + callStackSize1);
					afterConditional(ast, post);
					this.setLoopTracker(lpTracker1);
					this.setCallTracker(recTracker1);
					// ////////System.out.println("After Cond: " +
					// this.callTracker.toString() + " : " +
					// ast.getChild(0).toStringTree());
					// heapSet.add(post.getHeap().deepClone());
					// post.printInFile(this.resultFolderName + this.filenumber+
					// "example.dot" );
					boolean exit_path1 = endPath(current_codesize_w);
					if (exit_path1) {
						return post;
					}
				}
				break;

			case ES3Lexer.SWITCH:
				for (int i = 1; i < ast.getChildCount(); i++) {
					CommonTree child = (CommonTree) ast.getChild(i);
					if (child != null) {
						int callStackSize2 = pre.getCallStk().size();
						State pre_case = pre.freezeState();

						beforeConditional(ast, pre);
						// ////////System.out.println("Before Cond: " +
						// this.callTracker.toString() + " : " +
						// ast.getChild(0).toStringTree());
						HashMap<String, Integer> recTracker2 = (HashMap<String, Integer>) this.callTracker
								.clone();
						HashMap<String, Integer> lpTracker2 = (HashMap<String, Integer>) this.loopTracker
								.clone();

						if (child.getType() == ES3Lexer.DEFAULT) {
							printString(" ( Switch: "
									+ ast.getChild(0).toStringTree() + ")"
									+ " case: DEFAULT. At line no. : "
									+ child.getLine() + " callstacksize: "
									+ callStackSize2);
							post = walkExpression(child, pre);
							printString("end of ( Switch: "
									+ ast.getChild(0).toStringTree() + ")"
									+ " case: DEFAULT. At line no. : "
									+ child.getLine() + " callstacksize: "
									+ callStackSize2);
						} else {
							printString(" ( Switch: "
									+ ast.getChild(0).toStringTree() + ")"
									+ " case:"
									+ child.getChild(0).toStringTree()
									+ "  At line no. : " + child.getLine()
									+ " callstacksize: " + callStackSize2);
							post = walkExpression(child, pre);
							printString("end of ( Switch: "
									+ ast.getChild(0).toStringTree() + ")"
									+ " case:"
									+ child.getChild(0).toStringTree()
									+ "  At line no. : " + child.getLine()
									+ " callstacksize: " + callStackSize2);
						}

						afterConditional(ast, post);
						this.setLoopTracker(lpTracker2);
						this.setCallTracker(recTracker2);
						// ////////System.out.println("After Cond: " +
						// this.callTracker.toString() + " : " +
						// ast.getChild(0).toStringTree());

						post.unfreezeState(pre_case);
						pre = post;

						boolean exit_path2 = endPath(-1);
						if (exit_path2) {
							return post;
						}
					}
				}
				break;

			case ES3Lexer.DEFAULT:
				post = walkExpression((CommonTree) ast.getChild(0), pre);
				break;

			case ES3Lexer.CASE:
				post = walkExpression((CommonTree) ast.getChild(1), pre);
				break;

			case ES3Lexer.BLOCK:
			case ES3Lexer.DO:
			case ES3Lexer.FOR:
			case ES3Lexer.TRY:
			case ES3Lexer.CATCH:
			case ES3Lexer.FINALLY:
			case ES3Lexer.WITH:

				/*
				 * Walk all the statements in the block. The post state should
				 * be the pre state for the next statement
				 */
				this.lineNumber++;
				post = walkExpression((CommonTree) ast.getChild(0), pre);
				break;

			case ES3Lexer.RETURN:
				if ((CommonTree) ast.getChild(0) != null) {
					pre = walkExpression((CommonTree) ast.getChild(0), pre);
				} else {
					CommonTree par;
					try {
						// This is a return statment without any value, an empty
						// return
						// return from the current method
						CallStack cst = pre.popFromCallStack();
						pre.setScope(cst.getRetScope());

						par = cst.getRetNode();

						// Decrease the call counter
						// String loopid =
						// ast.getParent().getParent().getParent().toString() +
						// "call line:" + par.getLine() + "+ parent line: " +
						// par.getParent().getLine() + ":" +
						// par.getParent().getParent().getLine();
						String loopid = ast.getParent().getParent().getParent()
								.toStringTree()
								+ par.getLine()
								+ par.getParent().getLine()
								+ par.getParent().getParent().getLine();
						removeOneFromCallCounter(loopid);
					} catch (EmptyStackException es) {
						es.printStackTrace();
						printString("Null Return does not have parent: "
								+ ast.getLine());
						par = (CommonTree) ast.getParent();
					}

					// Call the trampoline to reach the parent object
					post = trampoline(par, pre);
				}

				break;

			case ES3Lexer.FUNBODY:
				// Push the previous array values list onto the stack
				// pre.pushOntoCallStack(pre.getScope(),(CommonTree)ast.getParent());

				if (ast.getChildCount() != 0) {
					post = walkExpression((CommonTree) ast.getChild(0), pre);
				} else {
					// Reset the scope and next location
					CallStack cst = pre.popFromCallStack();
					pre.setScope(cst.getRetScope());

					// Call the trampoline to reach the parent object
					post = trampoline(cst.getRetNode(), pre);
				}
				break;
			/*
			 * 
			 * Expressions
			 */

			// primaryExpression

			case ES3Lexer.THIS:
				ObjectValue this_object = null;
				Location parent = null;
				// Get the object_value(location) associated with the "at_this"
				// property
				if (pre.Scope("at_this") != null) { // if the variable "at_this"
					// exists in the scope
					Location parent_scope = pre.Scope("at_this");
					parent = pre.Prototype(parent_scope, "at_this");
					this_object = pre.getPropertyValue(parent, "at_this"); // return
					// the
					// object
					// value
					// associated
					// with
					// it
				} else {
					// returns the global object when the "at_this" variable is
					// not found
					this_object = pre.getGlobal();
				}

				// Set the result value of pre to the newly obtained object
				pre.setResultParent(parent);
				pre.setResultValue(this_object);

				// Call the walk to the next expression and return when it
				// returns
				post = trampoline(ast, pre);

				break;

			/*
			 * Returns the parent location in the result value of the return
			 * state
			 */
			case ES3Lexer.Identifier:
				String id = ast.toString();

				pre = walkIdentifier(pre, id, ast);

				// Print the current identifiers taint (if it is an object)
				if (pre.getResultValue() != null) {
					if (pre.getResultValue() instanceof Location) {
						SecurityType taint = (SecurityType) pre
								.getPropertyValue((Location) pre
										.getResultValue(), "at_Taint");
						if (taint != null) {
							printString(id + " taint: " + taint.isTainted()
									+ " Taint value: " + taint.getObjValue()
									+ " at line: " + ast.getLine());
						}
					}
				}
				// Add this state to the return state
				post = trampoline(ast, pre);
				break;

			case ES3Lexer.NULL:

				pre.clearOldResults();
				post = trampoline(ast, pre);
				break;

			case ES3Lexer.PAREXPR:
				// Assuming that every expression would call the trampoline
				// after the
				// completion of its evaluation
				post = walkExpression((CommonTree) ast.getChild(0), pre);
				break;

			case ES3Lexer.RegularExpressionLiteral:
			case ES3Lexer.OctalIntegerLiteral:
			case ES3Lexer.HexIntegerLiteral:
			case ES3Lexer.DecimalLiteral:
			case ES3Lexer.TRUE:
			case ES3Lexer.FALSE:
				pre = createPrimitive(pre, ast);
				// Add this state to the return state
				post = trampoline(ast, pre);
				break;

			case ES3Lexer.StringLiteral:
				pre = createStringPrimitive(pre, ast);
				post = trampoline(ast, pre);
				break;

			case ES3Lexer.OBJECT:
				// ////////////////////System.out.println("Entered object literal: "
				// + ast.toStringTree());
				post = walkObjectLiteral(ast, pre);
				break;

			case ES3Lexer.NAMEDVALUE:

				// Assuming that every expression would call the trampoline
				// after the
				// completion of its evaluation
				post = walkExpression((CommonTree) ast.getChild(1), pre);
				break;

			case ES3Lexer.FUNCTION:

				// create the function object and get it's location
				ObjectValue fd = walkFunctionExpression(ast, pre);

				// The return value is the location representing the new
				// function
				pre.setResultValue(fd);

				// Return this to post
				post = trampoline(ast, pre);
				break;

			/*
			 * Array Literal, initialized
			 */
			case ES3Lexer.ARRAY:

				// Push the previous array values list onto the stack
				pre.pushOntoLhsStack("Previour array values list if any at: "
						+ ast.getLine() + " at scope: " + pre.getScope());

				// create a new linked list to hold the array values
				LinkedList<ObjectValue> arrvals = new LinkedList<ObjectValue>();
				// Set the arrvals variable in the state with the newly created
				// linked list
				pre.setArrayVals(arrvals);

				if (ast.getChildCount() != 0) {
					post = walkExpression((CommonTree) ast.getChild(0), pre);
				} else {
					// Reset the arrvals array in pre
					pre.setResultValueFromStack();

					// Create a new location for the array linked list,
					// insert the array literal location into the heap and
					// return the location
					// in the result value
					pre = walkArrayLiteral(ast, pre, arrvals);

					// Call the trampoline to reach the parent object;
					post = trampoline(ast, pre);
				}
				break;

			/*
			 * The array literal consists of items. Each item has one child,
			 * i.e. the value
			 */
			case ES3Lexer.ITEM:
				// //////////////////System.out.println("Array: Item" +
				// ast.toStringTree() + ":" + ast.getChild(0).toStringTree());
				post = walkExpression((CommonTree) ast.getChild(0), pre);
				// post = pre;
				break;

			// leftHandSideExpression
			case ES3Lexer.CALL:
				printString(" --------- Reached Beginning of ES3Lexer.CALL: "
						+ ast.getChild(0).toStringTree() + " at line:"
						+ ast.getLine());

				// 1. Walk the function arguments. We will only walk the first
				// function argument here,
				// the rest of the functions are done in the trampoline
				// function!
				CommonTree argsBranch = (CommonTree) ast.getChild(1);
				post = walkExpression(argsBranch, pre);

				/*
				 * // 2. Walk the function name and find the function body
				 * associated with it. // 3. Walk the function body and get the
				 * result value
				 * 
				 * //////////////////System.out.println("Call: " +
				 * ast.toStringTree()); State call_return = pre; Location
				 * previous_scope = call_return.getScope();
				 * 
				 * // Find the reference to the function location by analyzing
				 * the function call pre =
				 * walkExpression((CommonTree)ast.getChild(0),pre); ObjectValue
				 * result = pre.getResultValue(); Location result_parent =
				 * pre.getResultParent();
				 * 
				 * //////////////////System.out.println("Function object: " +
				 * result);
				 * 
				 * Location thisLocation = null; // Call the function and return
				 * the ResultValue if(result != null){ // If we could find an
				 * object value of the expression // Check if the result value
				 * is a location if(result instanceof Location){ // if result is
				 * a reference if(isActivation(pre, (Location) result)){ //
				 * Check if the function object has an at_Activation property
				 * thisLocation = pre.getGlobal(); }else{ // If the
				 * at_Activation property is missing thisLocation =
				 * result_parent; } }else{ // if result is not a reference
				 * thisLocation = pre.getGlobal(); }
				 * 
				 * call_return = call_atFun(ast, pre, result, thisLocation);
				 * call_return.setScope(previous_scope);
				 * call_return.setResultType("Normal"); // reset the return type
				 * to normal post = call_return; }else{ // If we couldn't find
				 * the function object // TODO: What do we do if we can't find
				 * the function declaration object
				 * accessErrorList.add(ast.getChild(0).toStringTree() +
				 * "at line no: " + ast.getLine() + " in file: " +
				 * currentfilename); pre.clearOldResults(); post =
				 * trampoline(ast,pre); }
				 */
				break;

			case ES3Lexer.ARGS:

				// Push the previous array values list onto the stack
				pre
						.pushOntoLhsStack("Previous arguments list before new function arguments are computed at: "
								+ ast.getLine()
								+ " at scope: "
								+ pre.getScope());
				pre.clearOldResults();

				// create a new linked list to hold the array values
				LinkedList<ObjectValue> argsvals = new LinkedList<ObjectValue>();
				// Set the arrvals variable in the state with the newly created
				// linked list
				pre.setArrayVals(argsvals);

				if (ast.getChildCount() != 0) {
					post = walkExpression((CommonTree) ast.getChild(0), pre);
				} else {
					// Reset the arrvals array in pre
					pre.setResultValueFromStack();

					// Create a new location arguments and return the location
					// in the result value
					// Create an entry for the actual function parameters and
					// place
					// them into the function heap
					JSObject args = PredefinedObjectTemplates.new_arguments(0,
							argsvals, this.getHighTaint());
					String argsStr = computeLocationString("CallArgs", ast);
					Location argsLoc = pre.addToHeap(argsStr, args);

					// Return the arguments location in the result value
					pre.setResultValue(argsLoc);

					// Call the trampoline to reach the parent object;
					post = trampoline(ast, pre);
				}

				break;

			case ES3Lexer.BYFIELD:
				// ////////////////////System.out.println("ast children:" +
				// ast.getChildCount() + " + tree: " + ast.toStringTree());

				// Walk the LHS - notice that the input parameter is a cloned
				// version of the state
				// We clone the state, so that we don't affect the scope field
				// of the parent
				post = walkExpression((CommonTree) ast.getChild(0), pre);

				break;

			case ES3Lexer.BYINDEX:
				// //////////////////System.out.println("ast children:" +
				// ast.getChildCount() + " + tree: " + ast.toStringTree());
				/*
				 * Field access obj20.c1["x3"] is converted to the tree:
				 * (BYINDEX (BYFIELD obj20 c1) "x3") So this case is similar to
				 * the BYFIELD case.
				 */
				post = walkExpression((CommonTree) ast.getChild(0), pre);
				break;

			// newExpression
			case ES3Lexer.NEW:
				// Could get a set of states in return for the CALL to the
				// constructor
				// 1. Walk the name of the object to get the reference to the
				// object
				// CommonTree fun_name =
				// (CommonTree)ast.getChild(0).getChild(0);
				// Location pre_scope = pre.getScope();

				// pre = walkExpression(fun_name,pre);

				// Walk the call arguments first
				CommonTree new_argsBranch = (CommonTree) ast.getChild(0);

				// //////////////System.out.println("in New: " +
				// new_argsBranch.toStringTree());

				post = walkExpression(new_argsBranch, pre);

				/*
				 * ObjectValue fv = pre.getResultValue();
				 * 
				 * // 2. Walk the arguments and get their values into a linked
				 * list CommonTree argsTree_new =
				 * (CommonTree)ast.getChild(0).getChild(1); int noOfArgs_new =
				 * argsTree_new.getChildCount();
				 * //////////////////System.out.println("childcount: " +
				 * noOfArgs_new); LinkedList<ObjectValue> argsList_list =
				 * generateActualParameterList(pre, argsTree_new, noOfArgs_new);
				 * 
				 * if(fv != null){ if(isObject(pre,fv)){ // if the returned
				 * value is an object
				 * if(pre.getPropertyValue((Location)fv,"at_Construct") !=
				 * null){ // call the at_Construct method JSObject new_ob =
				 * null; Location newob_loc = null; Location prot_val =
				 * (Location)pre.getPropertyValue((Location)fv, "prototype");
				 * if(isObject(pre,prot_val)){ // if the prototype is an object
				 * new_ob = PredefinedObjectTemplates.new_object("Object",
				 * prot_val); }else{ // if the prototype is not an object new_ob
				 * =
				 * PredefinedObjectTemplates.new_object("Object",NativeObjects.
				 * ObjectProt); } newob_loc = pre.addToHeap(ast.getLine()+
				 * "prot", new_ob);
				 * //////////////////System.out.println("function call: " +
				 * ast.getChild(0).toStringTree() + " inside: " +
				 * ast.toStringTree() ); //pre =
				 * atCall((CommonTree)ast.getChild(
				 * 0),pre,newob_loc,noOfArgs_new,argsList_list,(Location)fv);
				 * ObjectValue callResult = pre.getResultValue();
				 * 
				 * if(isObject(pre,callResult)){ pre.setResultValue(callResult);
				 * }else{ pre.setResultValue(newob_loc); } }else{ // return null
				 * if the object does not have an "at_Construct" filed
				 * pre.clearOldResults(); } }else{ // If an object is not
				 * returned, return null. TODO: declare this to be an error
				 * pre.clearOldResults(); } }else{ // If the function does not
				 * return any object, then the return value is null -- this
				 * should be an error
				 * accessErrorList.add(ast.getChild(0).toStringTree() +
				 * "at line no: " + ast.getLine() + " in file: " +
				 * currentfilename); pre.clearOldResults(); }
				 * pre.setScope(pre_scope); post = trampoline(ast,pre);
				 */
				break;

			// conditional operator
			case ES3Lexer.QUE:
				// TODO: This will generate a split state, do something here
				// post = trampoline(ast,pre);

				// Walk all the children here for now and get the taints
				post = walkExpression((CommonTree) ast.getChild(1), pre);
				break;

			case ES3Lexer.EQ:
			case ES3Lexer.NEQ:

				// Logical operators, Binary bitwise operators, Equality
				// operators, Relational operator,
				// Bitwise shift operator, Additive operators, Multiplicative
				// operators
			case ES3Lexer.LOR:
			case ES3Lexer.LAND:
			case ES3Lexer.AND:
			case ES3Lexer.OR:
			case ES3Lexer.XOR:
			case ES3Lexer.SAME:
			case ES3Lexer.NSAME:
			case ES3Lexer.LT:
			case ES3Lexer.GT:
			case ES3Lexer.LTE:
			case ES3Lexer.GTE:
			case ES3Lexer.IN:
			case ES3Lexer.SHL:
			case ES3Lexer.SHR:
			case ES3Lexer.SHU:

			case ES3Lexer.SUB:
			case ES3Lexer.MUL:
			case ES3Lexer.DIV:
			case ES3Lexer.MOD:

				// TODO: If the results of lhs and rhs are string types, then we
				// want to compute the join of the at_StringValue properties
				// 1. Get the taint of the lhs and put it in the result value
				// 2. call the trampoline
				post = walkExpression((CommonTree) ast.getChild(0), pre);
				break;

			case ES3Lexer.ADD:
				// TODO: If the results of lhs and rhs are string types, then we
				// want to compute the join of the at_StringValue properties
				// 1. Get the taint of the lhs and put it in the result value
				// 2. call the trampoline
				post = walkExpression((CommonTree) ast.getChild(0), pre);
				break;

			case ES3Lexer.INSTANCEOF:
				post = trampoline(ast, pre);
				break;

			// Unary Operators, Postfix operators
			case ES3Lexer.DELETE:
			case ES3Lexer.VOID:
			case ES3Lexer.TYPEOF:
			case ES3Lexer.INC:
			case ES3Lexer.DEC:
			case ES3Lexer.POS:
			case ES3Lexer.NEG:
			case ES3Lexer.INV:
			case ES3Lexer.NOT:
			case ES3Lexer.PINC:
			case ES3Lexer.PDEC:
				// TODO: For all the above expressions, we return
				// an object with the taint value of the expressions
				// ////////////////System.out.println("unary operation: " +
				// ast.toStringTree() + ast.getChildCount());

				post = walkExpression((CommonTree) ast.getChild(0), pre);
				// pre = operatorReturn(ast, pre, child_type);
				// post = trampoline(ast,pre);
				break;

			case ES3Lexer.BREAK:
				/*
				 * break will take us out of the switch or the loop in which it
				 * is invoked
				 */

				CommonTree break_parent = (CommonTree) ast.getParent()
						.getParent();
				pre.clearOldResults();
				post = trampoline(break_parent, pre);
				break;

			case ES3Lexer.CONTINUE:
				/*
				 * continue will skip the rest of the statements in the loop and
				 * take us back to the beginning of the loop and re-execute it
				 */

				/*
				 * CommonTree cont_parent =
				 * (CommonTree)ast.getParent().getParent();
				 * pre.clearOldResults(); post =
				 * walkExpression(cont_parent,pre);
				 */
				post = trampoline(ast, pre);
				break;

			default:
				pre.clearOldResults();
				post = trampoline(ast, pre);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// printString(e.toString());
		}
		// ////////////////////////System.out.println("PostSet: Text --" +
		// ast.toStringTree() + "   line no.: ---" + ast.getLine() +
		// "\n Return Set: " + post);
		return post;
	}

	/**
	 * @return
	 */
	private boolean endPath(int old_size) {
		if (checkFlows()) {
			printResults();
			if (this.numberOfBranches == 0) { // do nothing, continue infinitely
				// till all the branches are
				// covered
				return false;
			} else {
				if (this.currentNumberOfBranches == this.numberOfBranches) {
					return true;
				} else {
					this.currentNumberOfBranches++;
					return false;
				}
			}
		}
		long endTime2 = System.currentTimeMillis();
		long elapsedTime2 = (endTime2 - this.start_time) / 1000;
		printString("FileNumber:" + this.filenumber + " Elapsed Time: "
				+ elapsedTime2 + " secs" + " :Number of branches: "
				+ this.joinTracker.size() + " : max no. of lines:"
				+ this.maxLines);
		if (old_size != -1) {
			this.maxLines = old_size;
		}
		if (this.stopTime != -1) {
			if (elapsedTime2 > this.stopTime) { // break if the tool takes more
				// than specified no. of mins
				printString("Taking a long time to finish, quitting the program now.");
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 */
	private void printResults() {
		printString("at file number:" + this.filenumber);
		printInnerHTMLSet();
		printEvalSet();
		printAppendChildSet();
		printWrtToLocalFileSet();
	}

	/**
	 * @return
	 */
	private boolean checkFlows() {
		// return !this.innerHTMLSet.isEmpty() || !this.evalSet.isEmpty() ||
		// !this.appendChildSet.isEmpty() || !this.wrtToLocalFileSet.isEmpty();
		// return !this.innerHTMLSet.isEmpty();
		return !this.evalSet.isEmpty() || !this.innerHTMLSet.isEmpty();
	}

	/**
	 * Pushes the current scope location and the call stack and lhs stack
	 * pointers onto the stack.
	 * 
	 * @param ast
	 * @param pre
	 * @param callStackSize
	 * @param lhsStackSize
	 */
	private void beforeConditional(CommonTree ast, State pre) {
		Location current_scope = pre.getScope();

		Stack<LHSStackObject> lhsStk;
		if (pre.getLhsStk().size() == 0) {
			lhsStk = pre.getLhsStk();
		} else {
			Stack<LHSStackObject> currentstk = pre.getLhsStk();
			lhsStk = (Stack<LHSStackObject>) currentstk.clone();
			/*
			 * for(int i = 0; i < lhsStackSize; i++){ LHSStackObject lhso =
			 * currentstk.get(i); lhsStk.add(lhso.deepClone()); }
			 */
		}

		Stack<CallStack> callStk;
		if (pre.getCallStk().size() == 0) {
			callStk = pre.getCallStk();
		} else {
			callStk = (Stack<CallStack>) pre.getCallStk().clone();
		}

		/*
		 * //////////System.out.println("Before Cond: Rescursion Tracker: " +
		 * this.getCallTracker().toString() + " " +
		 * ast.getChild(0).toStringTree()); HashMap<String,Integer> recTracker =
		 * (HashMap<String,Integer>)this.callTracker.clone();
		 * HashMap<String,Integer> lpTracker =
		 * (HashMap<String,Integer>)this.loopTracker.clone();
		 * //////////System.out
		 * .println("Before Cond: Rescursion Tracker Clone: " +
		 * recTracker.toString() + " " + ast.getChild(0).toStringTree());
		 * 
		 * pre.pushOntoConditionalStk(new
		 * CallStack(current_scope,ast,callStackSize
		 * ,lhsStackSize,lpTracker,recTracker,lhsStk));
		 */

		pre.pushOntoConditionalStk(new ConditionalStkElem(current_scope, ast,
				null, null, lhsStk, callStk));
	}

	/**
	 * @param pre
	 * @param post
	 * @param callStackSize
	 * @param lhsStackSize
	 */
	private void afterConditional(CommonTree ast, State pre) {
		ConditionalStkElem clst = pre.popFromConditionalStk();
		pre.setCallStk(clst.getCallStk());
		pre.setLhsStk(clst.getLhsStk());
		pre.setScope(clst.getRetScope());

		/*
		 * //TODO:Remove the following comment later..
		 * this.setLoopTracker(clst.getLoopTracker());
		 * this.setCallTracker(clst.getRecursionTracker());
		 * //////////System.out.println("After Cond: Rescursion Tracker: " +
		 * this.getCallTracker().toString());
		 */
		// post.setScope(current_scope);

		return;
	}

	/**
	 * 
	 * @param ast
	 * @param pre
	 * @param call_return
	 * @param previous_scope
	 * @param noOfArgs
	 * @param argsList
	 * @param result
	 * @param thisLocation
	 * @param resultLoc
	 * @return
	 */
	private State atFun(CommonTree ast, State pre, ObjectValue result,
			Location thisLocation, Location argsLoc) {

		// Parse the function body and get the result
		State call_return = pre;
		// CALL node is the parent of the current ast
		CommonTree parent = (CommonTree) ast.getParent();

		if (result instanceof Location) {
			Location resultLoc = (Location) result;
			if (isFunction(pre, resultLoc)) {
				// ////////////////System.out.println("isFunction: " +
				// isFunction(pre, resultLoc));

				// at_Call method
				call_return = atCall(ast, pre, thisLocation, resultLoc, argsLoc);

			} else { // If object is not a function
				// The jssec semantics produce an error object here

				// ////////////System.out.println("Reached line 2493: Checking for appendChild first");
				checkForAppendChildCalls(ast, pre, argsLoc, parent);

				Location dummy;
				if (pre.getPropertyValue(resultLoc, "at_Dummy") != null) { // if
					// the
					// function
					// node
					// is
					// a
					// dummy
					// node
					// //////System.out.println(" addArgumentTaints at loc: " +
					// ast.getLine());
					// add argument taints
					SecurityType taint = addArgumentTaints(pre, resultLoc,
							argsLoc);
					pre.setProperty(resultLoc, "at_Taint", taint);
					dummy = resultLoc;
				} else { // if the resultLoc is not a Dummy
					// //////System.out.println(" addArgumentTaints at loc: " +
					// ast.getLine());
					SecurityType taint = addArgumentTaints(pre, null, argsLoc);

					// Create a dummy object
					dummy = pre.getHeap().createDummyObjectInHeap(ast, taint);
				}
				// add argument taints
				// addArgumentTaints(pre, dummy, argsLoc);
				// return this value as the result value
				call_return.setResultValue(dummy);
				// add the current node to the list of error nodes
				accessErrorList.add(ast.toStringTree() + "at line no: "
						+ ast.getLine() + " in file: " + currentfilename);

				// Call the trampoline to reach the parent object
				call_return = trampoline(parent, pre);
			}
		} else { // If result is not a location

			// ////////////System.out.println("Reached line 2515: Checking for appendChild first");
			checkForAppendChildCalls(ast, pre, argsLoc, parent);

			// add argument taints
			// //////System.out.println(" addArgumentTaints at loc: " +
			// ast.getLine());
			SecurityType dt = addArgumentTaints(pre, null, argsLoc);

			// Create a dummy object
			Location dummy = pre.getHeap().createDummyObjectInHeap(ast, dt);

			// return this value as the result value
			call_return.setResultValue(dummy);
			// add the current node to the list of error nodes
			accessErrorList.add(ast.toStringTree() + "at line no: "
					+ ast.getLine() + " in file: " + currentfilename);
			// Call the trampoline to reach the parent object
			call_return = trampoline(parent, pre);
		}
		return call_return;
	}

	/**
	 * @param ast
	 * @param pre
	 * @param argsLoc
	 * @param parent
	 */
	private void checkForAppendChildCalls(CommonTree ast, State pre,
			Location argsLoc, CommonTree parent) {
		CommonTree functionName = (CommonTree) parent.getChild(0);
		if (functionName.getType() == ES3Lexer.BYFIELD
				|| functionName.getType() == ES3Lexer.BYINDEX) {
			String secondChild = functionName.getChild(1).toString();
			// ////////////System.out.println("SecondChild: " + secondChild);
			// Checking if the current function call is appendChild
			if (secondChild.equals("appendChild")) {
				Location eval_arg = (Location) pre.getPropertyValue(argsLoc,
						"__1__");
				SecurityType arg_taint = (SecurityType) pre.getPropertyValue(
						eval_arg, "at_Taint");
				// Check if the arguments are tainted
				if (arg_taint != null && arg_taint.isTainted()) {
					printString("High value is sent to appendChild:  at line: "
							+ ast.getLine() + " tainted by: "
							+ arg_taint.getObjValue());
					LinkedList<String> appendChildList = new LinkedList<String>();
					appendChildList.add(ast.toStringTree());
					appendChildList.add(arg_taint.getObjValue());
					appendChildList.add(String.valueOf(ast.getLine()));
					appendChildList.add(currentfilename);
					addToAppendChildSet(appendChildList);
				}
			}
		}
	}

	/**
	 * @Call method of the JavaScript semantics
	 * 
	 * @param ast
	 *            non null -- Reference to the function
	 * @param pre
	 * @param thisLocation
	 * @param noOfArgs
	 * @param argsList
	 * @param resultLoc
	 * @return -- The result of calling a function
	 */
	private State atCall(CommonTree ast, State pre, Location thisLocation,
			Location resultLoc, Location argsLoc) {
		State call_return;

		// CALL node is the parent of the current ast
		CommonTree parent = (CommonTree) ast.getParent();
		// ////////////////System.out.println("call ast: " + ast.toStringTree()
		// + "\n call parent:" + parent.toStringTree());
		// Handle native and non-native functions
		/*
		 * if(isNative(resultLoc)){ // Native function // check if the function
		 * can take variable number of arguments, ex:push
		 * if(isVariableLen(resultLoc)){ // TODO: handle native functions that
		 * take variable number of arguments }else{ // TODO: handle native
		 * functions that don't take variable number of arguments } }else{
		 */// Non-native function
		// Get the AST representing the function body
		FunctionValue functionBody = (FunctionValue) pre.getPropertyValue(
				resultLoc, "at_Body");
		CommonTree funcTree = functionBody.getFunctionAST();

		// Checking if the current function call is eval
		if (parent.getChild(0).toStringTree().equals("eval")) {
			// Check if there are any high flows to eval
			checkForEvalFlows(ast, pre, argsLoc);

			// If the argument of eval is a string, parse the arguments and add
			// the new
			// statements to the program
			addNewStatementsToEvalParent(pre, argsLoc, parent);
		} else {
			// ////////////System.out.println("Reached line 2603: Checking for appendChild first");
			checkForAppendChildCalls(ast, pre, argsLoc, parent);

		}

		// Checking if the current function call is to the __callFun__ function
		// that is invoked in setTimeout, etc.
		// //////////System.out.println("function name: " +
		// parent.getChild(0).toStringTree());
		if (parent.getChild(0).toStringTree().equals("__callFun__")) {
			// Get the string value of the first argument of the __callFun__
			// function
			Location body_val = (Location) pre.getPropertyValue(argsLoc,
					"__1__");
			ObjectValue string_obj = pre.getPropertyValue(body_val,
					"at_StrValue");
			if (string_obj != null) {
				// ////////System.out.println("callFun string_obj: " +
				// string_obj.getObjValue());

				String body_string1 = string_obj.getObjValue();
				String body_string = body_string1.substring(1, body_string1
						.length() - 1);

				// Parse the string
				try { // If there are not exceptions in parsing
					CommonTree body = parseString(body_string);

					CommonTree function_body1, function_body_parent1;
					/*
					 * function_body_parent1 = (CommonTree)funcTree.getChild(2);
					 * function_body1 =
					 * (CommonTree)function_body_parent1.getChild(0);
					 * function_body1.addChild(body.getChild(0));
					 */
					if (funcTree.getChildCount() == 3) {
						// function_args = (CommonTree)funcTree.getChild(1);
						function_body_parent1 = (CommonTree) funcTree
								.getChild(2);
						if (function_body_parent1.getChildCount() != 0) {
							changeFunctionBodyParent(body,
									function_body_parent1);
						} else {
							function_body_parent1.addChild(body.getChild(0));
						}
						// function_body_parent1.addChild(body.getChild(0));
						function_body1 = (CommonTree) function_body_parent1
								.getChild(0);

					} else {
						// function_args = (CommonTree)funcTree.getChild(0);
						function_body_parent1 = (CommonTree) funcTree
								.getChild(1);
						if (function_body_parent1.getChildCount() != 0) {
							changeFunctionBodyParent(body,
									function_body_parent1);
						} else {
							function_body_parent1.addChild(body.getChild(0));
						}
						// function_body_parent1.addChild(body.getChild(0));
						function_body1 = (CommonTree) function_body_parent1
								.getChild(0);

					}

					// ////////System.out.println("Function Body Parent in __callFun__: "
					// + function_body_parent1.toStringTree());
					// //////////////System.out.println("parent: " +
					// parent.toStringTree() + "\n\t functionbody body: " +
					// funcTree.getChild(1).toStringTree());
					// //////////////System.out.println("argument parsed: " +
					// body.getChild(0).toStringTree());

				} catch (Exception e) {
					e.printStackTrace();
					printString("The string " + body_string1
							+ " could not be parsed properly");
					// If there were exceptions in parsing:
					// Remove the preexisting __callFun__ body
					removePreviousFunctionBody(funcTree);
				}
			} else { // If we can't parse the function call name in setTimeout
				// etc.
				removePreviousFunctionBody(funcTree);
			}
		}

		// //////////////System.out.println("parent: " + parent.toStringTree() +
		// "\n\t functionbody: " + funcTree.toStringTree());

		// call_count is used to check if the function is being called from the
		// same location multiple time
		// i.e. it is recursive
		// check if the call_count exists for this function call
		// if it does, add 1 to it, otherwise create new mapping with the
		// initial value 1
		int call_count = 0;

		// HACK to ensure that the body of __callFun__ is always called.
		// Recursion is removed at the setTimeout level!
		// if(!parent.getChild(0).toStringTree().equals("__callFun__")){
		call_count = addOneToCallCounter(funcTree.toStringTree()
				+ parent.getLine() + parent.getParent().getLine()
				+ parent.getParent().getParent().getLine());
		// }

		if (call_count <= maxCallIter) { // If the calls to this function did
			// not reach the iteration limit
			// Get the function scope
			Location l4 = (Location) pre.getPropertyValue(resultLoc,
					"at_FScope");

			// Create a new activation
			JSObject act = PredefinedObjectTemplates.new_activation(argsLoc,
					thisLocation, l4, this.getHighTaint());
			String actStr = computeLocationString("Activation"
					+ parent.getLine(), parent);
			Location actLoc = pre.addToHeap(actStr, act);

			// Create a return location and push it on to the call stack
			pre.pushOntoCallStack(new CallStack(pre.getScope(), parent)); // return
			// will
			// call
			// the
			// trampoline
			// on
			// the
			// parent

			// Create a new state with the same heap but having the activation
			// object as it's scope
			State funState = pre;
			funState.setScope(actLoc);
			funState.clearOldResults();

			CommonTree function_args, function_body, function_body_parent;
			if (funcTree.getChildCount() == 3) {
				function_args = (CommonTree) funcTree.getChild(1);
				function_body_parent = (CommonTree) funcTree.getChild(2);
				function_body = (CommonTree) function_body_parent.getChild(0);
			} else {
				function_args = (CommonTree) funcTree.getChild(0);
				function_body_parent = (CommonTree) funcTree.getChild(1);
				function_body = (CommonTree) function_body_parent.getChild(0);
			}
			// Walk arguments
			funState = walkArguments(function_args, funState);

			// Walk body for variable declarations
			funState = walkVAR(function_body_parent, funState);

			// ////////////////System.out.println("functionbody: " +
			// funcTree.getChild(1).toStringTree());
			// Walk body for function declarations
			funState = walkFD(function_body_parent, funState);

			if (parent.getChild(0).toStringTree().equals("__callFun__")) {
				// ////////System.out.println("Function body size: " +
				// function_body_parent.getChildCount() + " stirng: " +
				// function_body_parent.toStringTree());
			}

			// Walk the function body
			if (function_body == null) {
				pre.popFromCallStack();
				printString(" ------- Reached end of function call: "
						+ parent.getChild(0).toStringTree() + " at line:"
						+ parent.getLine());
				call_return = trampoline(parent, pre);
			} else {
				call_return = walkExpression(function_body, funState);
			}

			// If we reach a CALL, the pop one element from recursion stack
			// This is to ensure that the while loop and conditional get to the
			// correct
			// position on the recursion stack to pop from
			// Removed support for recursion stack
			// pre.popFromRecursionOrCallStack(parent);
		} else { // If we are dealing with a recursive function and iteration
			// limit is reached
			// ////////System.out.println("recursion entered: " +
			// parent.getChild(0).toStringTree());

			JSObject js = PredefinedObjectTemplates.new_object("Object",
					NativeObjects.ObjectProt, this.getHighTaint());
			Location l = pre.addToHeap("RecFun", js);
			pre.setResultValue(l);

			// Call the trampoline to reach the parent object
			call_return = trampoline(parent, pre);
		}
		return call_return;
	}

	/**
	 * @param body
	 * @param function_body_parent1
	 */
	private void changeFunctionBodyParent(CommonTree body,
			CommonTree function_body_parent1) {
		int childIndex = function_body_parent1.getChildCount();
		function_body_parent1.replaceChildren(0, childIndex - 1, body
				.getChild(0));
		// ////////System.out.println("childcount before: " +
		// function_body_parent1.getChildCount());
		function_body_parent1.freshenParentAndChildIndexes();
		// ////////System.out.println("childcount after: " +
		// function_body_parent1.getChildCount());
	}

	/**
	 * @param funcTree
	 */
	private void removePreviousFunctionBody(CommonTree funcTree) {
		CommonTree function_body_parent2;
		if (funcTree.getChildCount() == 3) {
			// function_args = (CommonTree)funcTree.getChild(1);
			function_body_parent2 = (CommonTree) funcTree.getChild(2);
			if (function_body_parent2.getChildCount() != 0) {
				int childIndex = function_body_parent2.getChildCount();
				for (int i = 0; i < childIndex; i++)
					function_body_parent2.deleteChild(i);
				function_body_parent2.freshenParentAndChildIndexes();

			}
		} else {
			// function_args = (CommonTree)funcTree.getChild(0);
			function_body_parent2 = (CommonTree) funcTree.getChild(1);
			if (function_body_parent2.getChildCount() != 0) {
				int childIndex = function_body_parent2.getChildCount();
				// ////////System.out.println("childcount before: " +
				// function_body_parent2.getChildCount());
				for (int i = 0; i < childIndex; i++)
					function_body_parent2.deleteChild(i);
				function_body_parent2.freshenParentAndChildIndexes();
				// ////////System.out.println("childcount after: " +
				// function_body_parent2.getChildCount());

			}
		}
	}

	/**
	 * @param pre
	 * @param argsLoc
	 * @param parent
	 */
	private void addNewStatementsToEvalParent(State pre, Location argsLoc,
			CommonTree parent) {
		Location body_val = (Location) pre.getPropertyValue(argsLoc, "__1__");
		ObjectValue string_obj = pre.getPropertyValue(body_val, "at_StrValue");
		if (string_obj != null) {
			String body_string1 = string_obj.getObjValue();
			String body_string = body_string1.substring(1, body_string1
					.length() - 1);
			// ////////System.out.println("eval argument: " + body_string);
			try {
				CommonTree body = parseString(body_string);
				// ////////System.out.println("Parsed string " +
				// body.getChild(0).toStringTree() + " childcount:" +
				// body.getChildCount());
				List<CommonTree> children = body.getChildren();

				// Get the parent of eval
				CommonTree eval_parent = (CommonTree) parent.getParent();
				// ////////System.out.println("evalparent no. of children: " +
				// eval_parent.getChildCount());
				List<CommonTree> parent_children = eval_parent.getChildren();
				int eval_index = parent.getChildIndex();

				// Add the parsed children
				parent_children.addAll(eval_index + 1, children);

				// Remove the eval
				// parent_children.remove(eval_index);

				eval_parent.freshenParentAndChildIndexes();

				// eval_parent.addChildren(children);

				// ////////System.out.println("evalparent: " +
				// eval_parent.toStringTree() + "  child count: " +
				// eval_parent.getChildCount());
				// ////////System.out.println("new child first index: " +
				// children.get(0).childIndex);
				// ////////System.out.println("eval child index: " +
				// parent.getChildIndex());
				// Get the next sibling of eval
				CommonTree nextSibling = computeNextSibling(parent);
				if (nextSibling != null) {
					// ////////System.out.println("eval's sibling: " +
					// nextSibling.toStringTree() + " child index: " +
					// nextSibling.childIndex);
				}
			} catch (Exception e) {
				e.printStackTrace();
				printString("The string " + body_string
						+ " could not be parsed properly");
			}
		}
	}

	/**
	 * @param body_string
	 * @return
	 * @throws RecognitionException
	 */
	private CommonTree parseString(String body_string)
			throws RecognitionException {
		CharStream cs = new ANTLRStringStream(body_string);
		ES3Lexer lex = new ES3Lexer(cs);
		CommonTokenStream tokens = new CommonTokenStream(lex);
		ES3Parser parser = new ES3Parser(tokens);
		ES3Parser.program_return r = parser.program();

		CommonTree body = (CommonTree) r.getTree();
		return body;
	}

	/**
	 * @param ast
	 * @param pre
	 * @param argsLoc
	 */
	private void checkForEvalFlows(CommonTree ast, State pre, Location argsLoc) {
		Location eval_arg = (Location) pre.getPropertyValue(argsLoc, "__1__");
		SecurityType arg_taint = (SecurityType) pre.getPropertyValue(eval_arg,
				"at_Taint");
		// Check if the arguments are tainted
		if (arg_taint != null && arg_taint.isTainted()) {
			printString("High value is sent to eval at method call:  at line: "
					+ ast.getLine() + " tainted by: " + arg_taint.getObjValue());
			LinkedList evalList = new LinkedList<String>();
			evalList.add(ast.toStringTree());
			evalList.add(arg_taint.getObjValue());
			evalList.add(ast.getLine());
			evalList.add(currentfilename);
			addToEvalSet(evalList);
		}
	}

	/**
	 * @param pre
	 * @param argsTree
	 * @param noOfArgs
	 * @return
	 */
	private LinkedList<ObjectValue> generateActualParameterList(State pre,
			CommonTree argsTree, int noOfArgs) {
		LinkedList<ObjectValue> argsList = new LinkedList<ObjectValue>();
		for (int i = 0; i < noOfArgs; i++) {
			walkExpression((CommonTree) argsTree.getChild(i), pre);
			argsList.add(i, pre.getResultValue());
		}
		return argsList;
	}

	/**
	 * Walk the formal arguments list and assign the actual parameters to the
	 * formal parameters
	 * 
	 * @param child
	 * @param funState
	 * @return
	 */
	private State walkArguments(CommonTree child, State funState) {
		// get the reference to the object containing the actual parameters
		Location args_ref = (Location) funState.getPropertyValue(funState
				.getScope(), "__arguments__");

		// get the number of the formal parameters
		int noOfArgs = child.getChildCount();
		// ////////////////System.out.println("childcount: " + noOfArgs);

		for (int i = 0; i < noOfArgs; i++) {
			ObjectValue actual = funState.getPropertyValue(args_ref, "__"
					+ String.valueOf(i + 1) + "__");
			String formal = child.getChild(i).toString();
			funState.addToScope(formal, actual);
		}
		return funState;
	}

	/**
	 * Given a security type, this creates a new object and add the security
	 * type to it
	 * 
	 * @param ast
	 * @param pre
	 * @param result_type
	 *            - new object's security type
	 */
	private State operatorReturn(CommonTree ast, State pre,
			SecurityType result_type) {
		// Create a new location for the object
		Location result_loc = new Location(String.valueOf(ast.getLine()));

		// Create the object
		JSObject result_obj = PredefinedObjectTemplates.new_object("Object",
				NativeObjects.ObjectProt, this.getHighTaint());

		// Add the taint
		result_obj.put("at_Taint", result_type);

		// Add the new object to the heap
		pre.addToHeap(result_loc, result_obj);

		// Assign the newly created location to the result value
		pre.setResultValue(result_loc);

		return pre;
	}

	private State extractSecurityType(CommonTree ast, State pre) {
		State bin_lhs = walkExpression(ast, pre);
		/*
		 * SecurityType lhs_type = null; if(bin_lhs.getResultValue() != null){
		 * Location lhs_result = (Location)bin_lhs.getResultValue(); lhs_type =
		 * (SecurityType) bin_lhs.getPropertyValue(lhs_result,"at_Taint");
		 * bin_lhs.clearOldResults(); }else{ // TODO: if we don't know the type,
		 * should we be conservative and return low?? lhs_type =
		 * SecurityType.createSecurityType(SecurityType.low); }
		 * pre.setResultValue(lhs_type); pre = trampoline(ast,pre);
		 */
		return pre;
	}

	/**
	 * Create a new array object and put it in the return value
	 * 
	 * @param ast
	 * @param pre
	 * @param arrvals
	 * @return
	 */
	private State walkArrayLiteral(CommonTree ast, State pre,
			LinkedList<ObjectValue> arrvals) {
		int arrLen = arrvals.size(); // array length

		/*
		 * // Create a linked list of items in the array LinkedList<ObjectValue>
		 * arrvals = new LinkedList<ObjectValue>(); for(int i = 0; i < arrLen;
		 * i++){ State arrval =
		 * walkExpression((CommonTree)ast.getChild(i),pre.clone()); ObjectValue
		 * val = arrval.getResultValue(); arrvals.add(i,val); }
		 */

		// Create a new array object
		JSObject arrobj = PredefinedObjectTemplates.new_array(arrLen, arrvals,
				this.getHighTaint());

		// Create a location for the array object in the heap
		String arrlocStr = computeLocationString("ArrayLit", ast);
		Location arrloc = new Location(arrlocStr);

		// Insert the (location, array object) pair into the heap
		pre.addToHeap(arrloc, arrobj);

		// Return the array location in the result value
		pre.setResultValue(arrloc);

		return pre;
	}

	/**
	 * First find the exact string value of the index
	 * 
	 * @param ast
	 * @param pre
	 * @return the string value of the index when it can be statically
	 *         determined null, if the index value is not known statically
	 */
	private String findIndexString(CommonTree ast, State index) {
		String index_string = null;

		// State index =
		// walkExpression((CommonTree)ast.getChild(1),pre.clone());

		// Index is a stirng
		if (ast.getType() == ES3Lexer.StringLiteral) {
			String str_value = ast.getText();
			index_string = str_value.substring(1, str_value.length() - 1);
			// //////////////////System.out.println("index String string literal access: "
			// + index_string);
			return index_string;
		}

		// If the child is a number, then this object could be an array
		// The String literal is the number
		if (ast.getType() == ES3Lexer.DecimalLiteral) {
			String str_value = ast.getText();
			// //////////////////System.out.println("index String string literal access: "
			// + index_string);
			return index_string;
		}

		// If the index is neither a string or a number
		ObjectValue index_result = index.getResultValue();
		if (index_result != null) {
			if (index_result instanceof Location) {
				// JSObject index_val =
				// pre.getHeap().get((Location)index_result);
				// Check if the "@StrValue" property exists in the result
				// location
				ObjectValue index_val = index.getPropertyValue(
						(Location) index_result, "at_StrValue");
				if (index_val != null) { // The location points to a string
					// object
					// Get the string value and return it
					String str_value = index_val.getObjValue();
					index_string = str_value.substring(1,
							str_value.length() - 1);
					// //////////////////System.out.println("index String indirect access: "
					// + index_string);
				} else { // The location does not point to a string object, then
					// we don't know the value statically
					index_string = null;
				}
			} else { // Can not access the RHS parent location or the index
				// variable location
				index_string = null;
			}
		}
		return index_string;
	}

	/**
	 * Returns the child index of the field access if it is in an assignment
	 * statement. Otherwise return -1
	 * 
	 * @param ast
	 * @return
	 */
	public int getChildIndex_nonFieldParent(CommonTree ast) {
		// System.out.print("ast:" + ast.toStringTree());
		CommonTree par = (CommonTree) ast.getParent();
		if (par.getType() == ES3Lexer.ASSIGN) {
			// //System.out.println("index: " + ast.getChildIndex());
			return ast.getChildIndex();
		}
		if (par.getType() == ES3Lexer.BYFIELD
				|| par.getType() == ES3Lexer.BYINDEX) {
			int cldindx = getChildIndex_nonFieldParent(par);
			// //System.out.println("index: " + cldindx);
			return cldindx;
		}
		// //System.out.println("index: " + -1);
		return -1;
	}

	/**
	 * Field access obj20.c1.x3 is converted to the tree: (BYFIELD (BYFIELD
	 * obj20 c1) x3) So in this case, it is sufficient to get the location value
	 * from the first child, and find the second child in the object pointed to
	 * by that location
	 * 
	 * @param ast
	 * @param pre
	 * @param second_child
	 */
	private State walkByFieldorIndex(CommonTree ast, State pre,
			String second_child) {

		// //////////////System.out.println("SecondChild: " + second_child +
		// " at line: " + ast.getLine());
		ObjectValue first_result = null;
		Location first_parent = null;

		LHSStackObject lhso = pre.popFromLhsStack();
		// lhs should be a location that contains the rhs; walk the lhs
		first_result = lhso.getLhsValue();
		first_parent = lhso.getLhsParent();

		if (first_result != null) { // if the lhs finds and returns a location
			// or a value
			// Search for the rhs in the location returned by the lhs
			pre.setScope((Location) first_result);
			pre.clearOldResults();

			// Walk the rhs
			State second = walkIdentifier(pre, second_child, ast);

			// Get the results
			ObjectValue second_result = second.getResultValue();
			// Location second_parent = second.getResultParent();
			// TODO: Hack to set the right parent of the fields for methods
			// accessible by __proto__ fields. Ex: push
			Location second_parent = (Location) first_result;

			// Set the return value back to the original scope but with new
			// return values
			if (second_parent == null && (first_result instanceof Location)) {
				pre.setResultParent((Location) first_result);
			} else {
				pre.setResultParent(second_parent);
			}

			/*
			 * HACK to propagate an object taint when an object is not found
			 * First creating a dummy object
			 */
			if (second_result == null) {
				SecurityType dummy_tnt = SecurityType
						.createSecurityType(SecurityType.low, "Dummy object: "
								+ ast.toStringTree());
				second_result = pre.getHeap().createDummyObjectInHeap(ast,
						dummy_tnt);
				// Adding the taints of all the properties of the parent to the
				// current
				// index object if the index object cannot be found
				/*
				 * if(first_result instanceof Location){ SecurityType ftaint =
				 * computeObjectTaint(pre,(Location)first_result);
				 * pre.setProperty((Location)second_result, "at_Taint", ftaint);
				 * }
				 */
			}

			// To ensure taint is propagated to the children of tainted elements
			// set the taint of the second_result object as the join of the lhs
			// and second_result taint
			// This has to be done if the field access is in the rhs or in the
			// function call
			int chldindex = getChildIndex_nonFieldParent(ast);

			if (chldindex == -1 || chldindex == 1) {
				if (second_result instanceof Location) {
					SecurityType lhsTaint = (SecurityType) pre
							.getPropertyValue((Location) first_result,
									"at_Taint");
					SecurityType rhsTaint = (SecurityType) pre
							.getPropertyValue((Location) second_result,
									"at_Taint");
					if (lhsTaint != null) { // To avoid NullPointerExceptions
						// when the taints are not
						// initialized
						// TODO: Check where this happens and make sure that it
						// doesnt
						if (rhsTaint == null) {
							pre.setProperty((Location) second_result,
									"at_Taint", lhsTaint);
						} else {
							/*
							 * ////////////////System.out.println("second_result:"
							 * + second_result);
							 * ////////////////System.out.println("rhsTaint:" +
							 * rhsTaint);
							 * ////////////////System.out.println("lhsTaint:" +
							 * lhsTaint);
							 */
							pre.setProperty((Location) second_result,
									"at_Taint", rhsTaint.join(lhsTaint));
						}
					}
				}
			}

			pre.setResultValue(second_result);
		} else { // if the lhs location is not found
			// TODO: What do we do when we can't find the location (i.e.
			// location is not initialized)'
			accessErrorList.add(ast.toStringTree() + " at line no: "
					+ ast.getLine() + " in file: " + currentfilename);

		}
		if (second_child.equals("innerHTML")) {
			pre.setInnerHTML(true);
		} else {
			pre.reSetInnerHTML();
		}
		return pre;
	}

	private Location createHighDummyObjectInHeap(State pre) {
		JSObject dummy_obj = PredefinedObjectTemplates.new_object("Object",
				NativeObjects.ObjectProt, this.getHighTaint());
		Location second_result = new Location("Uninit");
		pre.addToHeap(second_result, dummy_obj);
		return second_result;
	}

	/**
	 * Check if the function object has an at_Activation property
	 * 
	 * @param pre
	 * @param fun_loc
	 * @return
	 */
	private boolean isActivation(State pre, Location fun_loc) {
		ObjectValue act_ob = pre.getPropertyValue(fun_loc, "at_Activation");
		if (act_ob != null) {
			return act_ob.isBoolObjVal();
		} else
			return false;
	}

	/**
	 * Check if the object pointed to by the location is a function object
	 * 
	 * @param pre
	 * @param loc
	 * @return
	 */
	private boolean isFunction(State pre, Location loc) {
		ObjectValue call_prop = pre.getPropertyValue(loc, "at_Call");
		if (call_prop != null && pre.getPropertyValue(loc, "at_Host") == null) { // TODO:
			// isNonNative(loc)
			// =
			// false
			return true;
		}
		return false;
	}

	/**
	 * Check if the return value is an object -- by checking if the return value
	 * is an instance of a Location
	 * 
	 * @param pre
	 * @param loc
	 * @return
	 */
	private boolean isObject(State pre, ObjectValue loc) {
		if (loc == null)
			return false;
		if (loc instanceof Location)
			return true;
		else
			return false;
	}

	/**
	 * Find the identifier "id" in the scope of the current state object
	 * 
	 * @param pre
	 * @param id
	 * @return
	 */
	private State walkIdentifier(State pre, String id, CommonTree current_ast) {
		Location parent_id = null;
		ObjectValue id_object = null;
		// //////////System.out.println(" id : " + id + "  \n Global: " +
		// pre.getHeap().get(pre.getGlobal()));
		// Get the object_value(location) associated with the identifier
		if (pre.Scope(id) != null) { // if the variable identifier exists in
			// some scope
			// get the scope in which the property is located
			// start checking from the current scope
			Location scope = pre.Scope(id);

			// parent_id gets the exact location in which the property is
			// located
			parent_id = pre.Prototype(scope, id);

			// //////////////////////System.out.println("Parent location: " +
			// parent_id.toString());
			id_object = pre.getPropertyValue(parent_id, id); // return the
			// object value
			// associated
			// with it

			// if the object is in scope but is not assigned a value
			if (id_object == null) {
				id_object = this.getUntainted_obj_loc();
			}
		} else {

			if (pre.getPropertyValue(pre.getGlobal(), id) != null) { // check if
				// the
				// variable
				// is in
				// the
				// global
				// scope
				parent_id = pre.getGlobal();
				id_object = pre.getPropertyValue(pre.getGlobal(), id);

				// if the object is in scope but is not assigned a value
				if (id_object == null) {
					id_object = this.getUntainted_obj_loc();
				}

			} else { // we can't find this variable anywhere
				// We create a new dummy object and location and insert it into
				// the heap in the current scope
				if (current_ast.getParent().getType() == ES3Lexer.ASSIGN
						|| ((current_ast.getParent().getType() == ES3Lexer.BYFIELD || current_ast
								.getParent().getType() == ES3Lexer.BYINDEX) && computeNextSibling(current_ast) != null)) {
					parent_id = pre.getGlobal();
				} else {
					parent_id = pre.getScope();
				}
				id_object = createDummyIdentifier(pre, id, parent_id);
			}

		}

		/**
		 * TODO: Hack to recognize a dynamic object
		 */
		if (id.equals("push") || id.equals("setAttribute")
				|| id.equals("write") || id.equals("open")) {
			if (id_object != null && id_object instanceof Location) {
				// ////////////System.out.println("dynamic id: " + id);
				pre.addProperty((Location) id_object, "at_Dynamic",
						new ObjectValue(true));
			}
		}
		// Set the location of the parent
		pre.setResultParent(parent_id);
		// Set the result value of pre to the newly obtained object
		pre.setResultValue(id_object);

		if (id.equals("innerHTML")) {
			pre.setInnerHTML(true);
		} else {
			pre.reSetInnerHTML();
		}

		return pre;
	}

	/**
	 * @param pre
	 * @param id
	 * @param parent_id
	 * @return
	 */
	private Location createDummyIdentifier(State pre, String id,
			Location parent_id) {
		JSObject dummy_obj = PredefinedObjectTemplates.new_object("Object",
				NativeObjects.ObjectProt, this.getHighTaint());
		// current filename sans the path
		String[] fn = currentfilename.split("/");
		Location second_result = new Location(id + "_"
				+ fn[fn.length - 1].replace('.', '_'));
		pre.addToHeap(second_result, dummy_obj);
		pre.addProperty(second_result, "at_Dummy", new ObjectValue(true));
		pre.addProperty(parent_id, id, second_result);
		return second_result;
	}

	/**
	 * Walk the object literal to generate a new JSObject
	 * 
	 * @param ast
	 * @param pre
	 */
	private State walkObjectLiteral(CommonTree ast, State pre) {
		// Create a new object from the predefined template for Objects
		JSObject obj_lit = PredefinedObjectTemplates.new_object("Object",
				NativeObjects.ObjectProt, this.getHighTaint());

		// Create a new location name
		String location_string = computeLocationString("ObjectLit", ast);
		Location obj_loc = new Location(location_string);

		// Add a new (location,object) pair to the heap
		pre.addToHeap(obj_loc, obj_lit);

		// Add the current scope to the Scope field of the new object literal
		// obj_lit.put("at_Scope", pre.getScope());

		// Set the result value as the newly created object location
		pre.setResultValue(obj_loc);

		// Push the result value onto the object stack
		pre
				.pushOntoLhsStack("Object Literal location computed at the beginning at line: "
						+ ast.getLine() + " at scope: " + pre.getScope());
		pre.clearOldResults();

		// Step through each of the children(named value pairs)
		// and add the values to the object literal
		List<CommonTree> obj_children = ast.getChildren();

		if (obj_children != null && !obj_children.isEmpty()) { // Walk the first
			// named value
			pre = walkExpression(obj_children.get(0), pre);
		} else { // the object has no children
			pre.setResultValueFromStack();
			pre = trampoline(ast, pre);
		}
		/*
		 * for(CommonTree nv : obj_children){ // Get the left child name String
		 * lhs = nv.getChild(0).getText();
		 * 
		 * // Get the rhs expression value State rhs_state =
		 * walkExpression((CommonTree)nv.getChild(1),pre); ObjectValue rhs =
		 * rhs_state.getResultValue(); rhs_state.clearOldResults();
		 * 
		 * // add the (name,value) pair to the object obj_lit.put(lhs, rhs); }
		 */

		return pre;
	}

	private String computeLocationString(String type, CommonTree ast) {
		String location_string = type + "_" + ast.getLine();
		return location_string;
	}

	/**
	 * Walk expressions -- rules [E-Fun] and [E-Fun-Named]
	 * 
	 * @param ast
	 * @param pre
	 * @return
	 */
	private Location walkFunctionExpression(CommonTree ast, State pre) {
		// HelperFunction.Function creates a new function object and returns
		// it in the resultValue of the State
		Location fd = null;
		// If the function has a name, insert the function property into the
		// current scope
		if (ast.getChildCount() == 3) { // The function has three children :
			// name, arguments and body
			String fun_name = ast.getChild(0).getText();
			JSObject o = PredefinedObjectTemplates.new_object("Object",
					NativeObjects.ObjectProt, this.getHighTaint());
			Heap h = pre.getHeap();
			Location l1 = h.alloc(ast.getLine() + "_named", o);
			pre.addProperty(l1, "at_Scope", pre.getScope());
			fd = HelperFunctions.Function(ast, h, l1, currentfilename, this
					.getHighTaint());
			pre.addProperty(l1, fun_name, fd);
		} else {
			fd = HelperFunctions.Function(ast, pre.getHeap(), pre.getScope(),
					currentfilename, this.getHighTaint());
		}
		return fd;
	}

	/**
	 * This example takes a single filename on the command line, creates the AST
	 * and then walks the tree to get the dependency sets.
	 */
	public static void main(String[] args) {
		try {
			long startTime = System.currentTimeMillis();

			// Create the initial State
			State initState = createInitialState();
			// Generate the state with the initial heap with global variables
			State globalState = generateGlobalState(initState, args);
			// Instantiate global low objects
			instantiateLowObjects(globalState);
			// walk the javascript programs to test their results
			walkJSFiles(globalState, args);
			// walkJSFiles(initState,args);
			long endTime = System.currentTimeMillis();
			// time
			// //////////////System.out.println("Elapsed Time: " + (endTime -
			// startTime)/1000 + " secs");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("\n" + e.toString() + "\n");
		}
	}

	private static void instantiateLowObjects(State globalState) {
		Location global = globalState.getGlobal();
		// makeLow(global,"Components.classes[\"@mozilla.org/rdf/rdf-service;1\"]");
		Location components = (Location) globalState.getPropertyValue(global,
				"Components");
		Location classes = (Location) globalState.getPropertyValue(components,
				"classes");
		Location interfaces = (Location) globalState.getPropertyValue(
				components, "interfaces");

		// gBrowser
		Location gbrowser = (Location) globalState.getPropertyValue(global,
				"gBrowser");
		globalState.setProperty(gbrowser, "at_Taint", SecurityType
				.createSecurityType(SecurityType.low, "gBrowser"));

		// RDFService
		Location rdfservice = (Location) globalState.getPropertyValue(classes,
				"\"@mozilla.org/rdf/rdf-service;1\"");
		globalState.setProperty(rdfservice, "at_Taint", SecurityType
				.createSecurityType(SecurityType.low,
						"\"@mozilla.org/rdf/rdf-service;1\""));

		Location nsirdfservice = (Location) globalState.getPropertyValue(
				interfaces, "nsIRDFService");
		globalState.setProperty(nsirdfservice, "at_Taint", SecurityType
				.createSecurityType(SecurityType.low, "nsIRDFService"));

		// Components.classes["@mozilla.org/preferences-service;1"].getService(Components.interfaces.nsIPrefBranch);
		Location prefservice = (Location) globalState.getPropertyValue(classes,
				"\"@mozilla.org/preferences-service;1\"");
		globalState.setProperty(prefservice, "at_Taint", SecurityType
				.createSecurityType(SecurityType.low,
						"\"@mozilla.org/preferences-service;1\""));

		Location nsIPrefBranch = (Location) globalState.getPropertyValue(
				interfaces, "nsIPrefBranch");
		globalState.setProperty(nsIPrefBranch, "at_Taint", SecurityType
				.createSecurityType(SecurityType.low, "nsIPrefBranch"));

		Location nsIPrefService = (Location) globalState.getPropertyValue(
				interfaces, "nsIPrefService");
		globalState.setProperty(nsIPrefBranch, "at_Taint", SecurityType
				.createSecurityType(SecurityType.low, "nsIPrefService"));

		// Components.classes["@mozilla.org/browser/livemark-service;2"].getService(Components.interfaces.nsILivemarkService);
		Location livemarksservice = (Location) globalState.getPropertyValue(
				classes, "\"@mozilla.org/browser/livemark-service;2\"");
		globalState.setProperty(livemarksservice, "at_Taint", SecurityType
				.createSecurityType(SecurityType.low,
						"\"@mozilla.org/browser/livemark-service;2\""));

		Location nsILivemarkService = (Location) globalState.getPropertyValue(
				interfaces, "nsILivemarkService");
		globalState.setProperty(nsILivemarkService, "at_Taint", SecurityType
				.createSecurityType(SecurityType.low, "nsILivemarkService"));

		// window.content.document & window._content.document
		Location window = (Location) globalState.getPropertyValue(global,
				"window");
		Location content = (Location) globalState.getPropertyValue(window,
				"content");
		Location document = (Location) globalState.getPropertyValue(content,
				"document");
		globalState.setProperty(document, "at_Taint",
				SecurityType.createSecurityType(SecurityType.low,
						"window.content.document"));

		// window.parent = global
		Location wparent = (Location) globalState.getPropertyValue(window,
				"parent");
		globalState.setProperty(wparent, "__proto__", global);

		// //////////////System.out.println("rdfservice object:" + rdfservice);
		// global document
		Location global_doc = (Location) globalState.getPropertyValue(global,
				"document");
		// set document.popupNode to Low.
		Location popupnode = (Location) globalState.getPropertyValue(
				global_doc, "popupNode");
		globalState.setProperty(popupnode, "at_Taint", SecurityType
				.createSecurityType(SecurityType.low, "document.popupNode"));

		// BookmarksUtils
		Location BookmarksUtils = (Location) globalState.getPropertyValue(
				global, "BookmarksUtils");
		globalState.setProperty(BookmarksUtils, "at_Taint", SecurityType
				.createSecurityType(SecurityType.low, "BookmarksUtils"));
	}

	/**
	 * Reads all the global files and returns their values
	 * 
	 * @return
	 * @throws IOException
	 * @throws RecognitionException
	 */
	private static State generateGlobalState(State initState, String[] args)
			throws IOException, RecognitionException {
		ES3Lexer lex;
		/*
		 * newANTLRFileStream(
		 * "/Users/sruthi81/Documents/Research/BrowserProject/ExtensionSecurity/javascriptAnalysis/TestInputs/__Test___input.txt"
		 * ));
		 */
		String filename = "";
		if (args.length > 2) {
			filename = args[2];
			// lex.setFilename(args[0]);
		} else {
			filename = "/Users/sruthi/Documents/EclipseWorkspace2010/JSOperationalSemantics/src/javascriptAnalysis/javascript_files/global.js";
		}
		lex = new ES3Lexer(new ANTLRFileStream(filename));

		CommonTokenStream tokens = new CommonTokenStream(lex);

		ES3Parser parser = new ES3Parser(tokens);
		ES3Parser.program_return r = parser.program();

		// Create a root AST node with id 0, and its child is the AST produced
		// by the parser:
		CommonToken tok = new CommonToken(ES3Lexer.ROOT_ID);
		CommonTree root = new CommonTree(tok);
		// root.setType(DependencyTracker.ROOT_ID);
		root.addChild((CommonTree) r.getTree());

		// StateSet initStSet = new StateSet();
		// initStSet.addState(initState);
		// ////////////////System.out.println("Init State Set:" +
		// initStSet.toString());

		// Create the tree walker
		ProgramAnalyzerC vt = new ProgramAnalyzerC(filename, initState);

		// Pre-process the program to create the global object
		State preProcessedState = vt.preWalk(root, initState);
		// ////////////////System.out.println("Pre State Set:" +
		// preProcessedState.toString());

		// TODO: To be removed when computations for StateSet can be done

		// Iterator<State> initsts = preProcessedState.getStates().iterator();
		// State post_preWalk = initsts.next();
		// Process the program now
		// State resultStateSet = vt.walk(root,post_preWalk,null);

		State resultStateSet = vt.walkExpression(root, preProcessedState);

		// State clone_state = resultStateSet.deepClone();

		// ////////////////System.out.println("Old State: \n" +
		// resultStateSet.toString());
		// ////////////////System.out.println("New State: \n" +
		// clone_state.toString());

		// ////////////////System.out.println("Post State Set:" +
		// vt.heapSet.toString());
		// //////////////System.out.println("HeapSet size: " +
		// vt.heapSet.size());
		vt.printString("Access errors: " + vt.accessErrorList);

		// String graphRep = resultStateSet.getHeap().toGraphRep();
		// System.out.println(graphRep);

		return resultStateSet;
	}

	/**
	 * @return
	 */
	private static State createInitialState() {
		// Initializing the heap with the global objects
		// Create the initial heap and the global object
		Location global = new Location("Global");
		Heap initialHeap = new Heap();
		JSObject globalObj = new JSObject();
		globalObj.put("at_Taint", SecurityType.createSecurityType(
				SecurityType.high, null));
		initialHeap.put(global, globalObj);
		initialHeap.setGlobal(global);

		// Create the initial State and stateset
		State initState = new State(initialHeap, global, global);
		return initState;
	}

	private static void walkJSFiles(State initState, String[] args)
			throws IOException, RecognitionException {
		ES3Lexer lex = new ES3Lexer();
		/*
		 * newANTLRFileStream(
		 * "/Users/sruthi81/Documents/Research/BrowserProject/ExtensionSecurity/javascriptAnalysis/TestInputs/__Test___input.txt"
		 * ));
		 */
		String filename = "";
		if (args.length > 0) {
			filename = args[0];
			lex = new ES3Lexer(new ANTLRFileStream(args[0]));
			// lex.setFilename(args[0]);
		}

		CommonTokenStream tokens = new CommonTokenStream(lex);

		ES3Parser parser = new ES3Parser(tokens);
		ES3Parser.program_return r = parser.program();

		// Create a root AST node with id 0, and its child is the AST produced
		// by the parser:
		CommonToken tok = new CommonToken(ES3Lexer.ROOT_ID);
		CommonTree root = new CommonTree(tok);
		// root.setType(DependencyTracker.ROOT_ID);
		root.addChild((CommonTree) r.getTree());

		// Create the tree walker
		ProgramAnalyzerC vt = new ProgramAnalyzerC(filename, initState);

		// Set a folder to store the results
		if (args.length > 3) {
			vt.setResultFolderName(args[3]);
		} else {
			vt
					.setResultFolderName("/Users/sruthi/Documents/EclipseWorkspace2010/Experiments/DotResults/");
		}

		if (args.length > 1) {
			vt.setNumberOfBranches(Integer.parseInt(args[1]));
		} else {
			vt.setNumberOfBranches(0);
		}

		// Set a folder to store the results
		if (args.length > 4) {
			// set stop time to either -1(no limit) or a number(indicating the
			// time)
			vt.setStopTime(Integer.parseInt(args[4]));
		} else {
			// 10 minutes is the default stop time
			vt.setStopTime(600);
		}

		// Is the branch optimization true or false?
		if (args.length > 5) {
			vt.setBranchOptimization(Boolean.parseBoolean(args[5]));
		} else {
			// Optimize by default
			vt.setBranchOptimization(true);
		}

		// Set the conditional order
		if (args.length > 6) {
			// if first or else first?
			vt.setConditionalOrder(Boolean.parseBoolean(args[6]));
		} else {
			// Optimize by default
			vt.setConditionalOrder(true);
		}

		// Set the while order
		if (args.length > 7) {
			// while body executed first or skipped
			vt.setWhileOrder(Boolean.parseBoolean(args[7]));
		} else {
			// While body by default
			vt.setWhileOrder(true);
		}

		// Set the startTime
		vt.setStart_time(System.currentTimeMillis());

		// Pre-process the program to create the global object
		State preProcessedState = vt.preWalk(root, initState);
		State resultStateSet = vt.walkExpression(root, preProcessedState);

	}
}
