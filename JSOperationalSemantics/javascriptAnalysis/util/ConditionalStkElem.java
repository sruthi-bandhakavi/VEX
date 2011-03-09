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
package javascriptAnalysis.util;

import java.util.HashMap;
import java.util.Stack;

import org.antlr.runtime.tree.CommonTree;

public class ConditionalStkElem {
	
	Location retScope; // Return Scope
	CommonTree retNode; // Return Node
	
	// Keeps track of the number of times the loop is run
	HashMap<String,Integer> loopTracker;
	// Keeps tracks of number of recursive calls
	HashMap<String,Integer> recursionTracker;
	
	// Keeps a clone of the state for the conditional
	// Could be null in case of while
	//State state_clone;
	
	// Keep a clone of the lhsStack at conditionals
	Stack<LHSStackObject> lhsStk = new Stack<LHSStackObject>();
	Stack<CallStack> callStk = new Stack<CallStack>();
	
	public ConditionalStkElem(Location retScope, CommonTree retNode, HashMap<String,Integer> recursionTracker, HashMap<String,Integer> loopTracker, Stack<LHSStackObject> lhsStk, Stack<CallStack> callStk) {
		super();
		this.retScope = retScope;
		this.retNode = retNode;
		this.loopTracker = loopTracker;
		this.recursionTracker = recursionTracker;
		this.lhsStk = lhsStk;
		this.callStk = callStk;
	}

	/**
	 * @return the retScope
	 */
	public Location getRetScope() {
		return retScope;
	}
	/**
	 * @param retScope the retScope to set
	 */
	public void setRetScope(Location retScope) {
		this.retScope = retScope;
	}
	/**
	 * @return the retNode
	 */
	public CommonTree getRetNode() {
		return retNode;
	}
	/**
	 * @param retNode the retNode to set
	 */
	public void setRetNode(CommonTree retNode) {
		this.retNode = retNode;
	}

	/**
	 * @return the loopTracker
	 */
	public HashMap<String, Integer> getLoopTracker() {
		return loopTracker;
	}

	/**
	 * @param loopTracker the loopTracker to set
	 */
	public void setLoopTracker(HashMap<String, Integer> loopTracker) {
		this.loopTracker = loopTracker;
	}

	
	/**
	 * @return the recursionTracker
	 */
	public HashMap<String, Integer> getRecursionTracker() {
		return recursionTracker;
	}

	/**
	 * @param recursionTracker the recursionTracker to set
	 */
	public void setRecursionTracker(HashMap<String, Integer> recursionTracker) {
		this.recursionTracker = recursionTracker;
	}

	/**
	 * @return the lhsStk
	 */
	public Stack<LHSStackObject> getLhsStk() {
		return lhsStk;
	}

	/**
	 * @param lhsStk the lhsStk to set
	 */
	public void setLhsStk(Stack<LHSStackObject> lhsStk) {
		this.lhsStk = lhsStk;
	}

	/**
	 * @return the callStk
	 */
	public Stack<CallStack> getCallStk() {
		return callStk;
	}

	/**
	 * @param callStk the callStk to set
	 */
	public void setCallStk(Stack<CallStack> callStk) {
		this.callStk = callStk;
	}
	
}
