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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

import org.antlr.runtime.tree.CommonTree;

/**
 * Keeps track of the state during the operational semantics. Each expression or
 * statement takes in the heap and the current scope and returns a result value.
 * 
 * @author sruthi
 * 
 */
public class State {

	Heap heap; // The program heap
	Location scope; // Current Scope

	Location resultParent; // Location of the parent object of the returned
							// ObjectValue
	ObjectValue resultValue; // Could be a location, a value or an ObjectSet
	String resultType; // Could be "Normal" or "Return"
	String namedValueLhs; // lhs of the NAMEDVALUE
	LinkedList<ObjectValue> arrayVals; // array item values or call argument
										// item values
	boolean isInnerHTML = false; // Variable to test whether the LHS is an
									// innerHTML object

	Stack<LHSStackObject> lhsStk = new Stack<LHSStackObject>();
	// Stack<LHSStackObject> recLhsStk = new Stack<LHSStackObject>();
	Stack<CallStack> callStk = new Stack<CallStack>();
	Stack<CallStack> fieldStk = new Stack<CallStack>();
	Stack<CallStack> recursionStk = new Stack<CallStack>();
	Stack<ConditionalStkElem> conditionalStk = new Stack<ConditionalStkElem>();

	public State() {
		super();
		this.heap = new Heap();
		this.scope = new Location();
		this.resultParent = null;
		this.resultValue = null;
		this.resultType = "Normal";
		this.namedValueLhs = null;
		this.arrayVals = null;
		this.isInnerHTML = false;

		this.lhsStk = new Stack<LHSStackObject>();
		this.callStk = new Stack<CallStack>();
		this.recursionStk = new Stack<CallStack>();

	}

	public State(Heap heap, Location scope, Location global) {
		super();
		this.heap = heap;
		this.heap.setGlobal(global);
		this.scope = scope;
		this.resultParent = null;
		this.resultValue = null;
		this.resultType = "Normal";
		this.namedValueLhs = null;
		this.arrayVals = null;
		this.isInnerHTML = false;

		this.lhsStk = new Stack<LHSStackObject>();
		this.callStk = new Stack<CallStack>();
		this.recursionStk = new Stack<CallStack>();
	}

	public State(Heap heap, Location scope, Location resultParent,
			ObjectValue resultValue, String resultType, String namedValueLhs,
			LinkedList<ObjectValue> arrayVals, Stack<LHSStackObject> lhsStk,
			Stack<CallStack> callStk, Stack<CallStack> recursionStk,
			boolean isInner) {
		super();
		this.heap = heap;
		this.scope = scope;
		this.resultParent = resultParent;
		this.resultValue = resultValue;
		this.resultType = resultType;
		this.namedValueLhs = namedValueLhs;
		this.arrayVals = arrayVals;
		this.isInnerHTML = isInner;

		this.lhsStk = lhsStk;
		this.callStk = callStk;
		this.recursionStk = recursionStk;

	}

	/**
	 * Used to create a shallow_copy of the objects in the state
	 */
	public State clone() {
		State clone_state = new State(this.heap, this.scope, this.resultParent,
				this.resultValue, this.resultType, this.namedValueLhs,
				this.arrayVals, this.lhsStk, this.callStk, this.recursionStk,
				this.isInnerHTML);
		return clone_state;
	}

	public State deepClone() {
		State clone_state = new State();

		// First clone the heap
		Heap heapcl = this.heap.deepClone(); // The program heap
		clone_state.setHeap(heapcl);

		// Next get the new key set
		Set<Location> heapKeys = heapcl.getKeySet();

		// Set the current scope and global scope from the locations in the heap
		for (Location key : heapKeys) {
			if (this.scope.equals(key)) { // scope
				clone_state.setScope(key);
			}
			if (this.resultParent != null) { // result parent
				if (this.resultParent.equals(key)) {
					clone_state.setResultParent(key);
				}
			}
		}

		/*
		 * //////////////System.out.println("Containment test: " +
		 * heapKeys.contains(this.global));
		 * //////////////System.out.println("Old State == NewState: \n" +
		 * (this.global == clone_state.global));
		 * //////////////System.out.println("OldState.equals(New State): \n" +
		 * this.global.equals(clone_state.getGlobal()));
		 * 
		 * //////////////System.out.println("Old State: \n" + this.toString());
		 * //////////////System.out.println("New State: \n" +
		 * clone_state.toString());
		 */

		/*
		 * Location scopecl = this.scope.deepClone(); // Current Scope Location
		 * globalcl = this.global.deepClone(); // Global Object Location
		 * 
		 * Location resultParentcl = null; // Location of the parent object of
		 * the returned ObjectValue ObjectValue resultValuecl = null; // Could
		 * be a location, a value or an ObjectSet String resultTypecl = null; //
		 * Could be "Normal" or "Return" String namedValueLhscl = null; // lhs
		 * of the NAMEDVALUE LinkedList<ObjectValue> arrayValscl =
		 * arrayValscl.deepClone(); // array item values or call argument item
		 * values
		 * 
		 * Stack<LHSStackObject> lhsStkcl = new Stack<LHSStackObject>();
		 * Stack<CallStack> callStkcl = new Stack<CallStack>(); State
		 * clone_state = new
		 * State(this.heap.deepClone(),this.scope.deepClone(),this
		 * .global.deepClone
		 * (),this.resultParent.deepClone(),this.resultValue.deepClone
		 * (),this.resultType, this.namedValueLhs, this.arrayVals, this.lhsStk ,
		 * this.callStk);
		 */

		// //////////////System.out.println("Old State: \n" + this.toString());
		// //////////////System.out.println("New State: \n" +
		// clone_state.toString());

		return clone_state;
	}

	public State freezeState() {

		State clone_state = new State();

		// First clone the heap
		Heap heapcl = this.heap.deepClone(); // The program heap
		clone_state.setHeap(heapcl);

		// Next get the new key set
		// Set<Location> heapKeys = heapcl.getKeySet();

		// Set the current scope and global scope from the locations in the heap
		/*
		 * for(Location key : heapKeys){ if(this.scope.equals(key)){ // scope
		 * //////System.out.println("this.scope:" + this.scope + " key: "+ key);
		 * clone_state.setScope(key);
		 * //////System.out.println("clone state scope: " +
		 * clone_state.getScope()); } if(this.global.equals(key)){ // global
		 * clone_state.setGlobal(key); } if(this.resultParent != null){ //
		 * result parent if(this.resultParent.equals(key)){
		 * clone_state.setResultParent(key); } } }
		 */

		clone_state.setGlobal(this.getGlobal());
		clone_state.setScope(this.getScope());
		clone_state.setResultParent(this.getResultParent());
		clone_state.setResultValue(this.getResultValue());

		/*
		 * clone_state.setConditionalStk((Stack<CallStack>)this.getConditionalStk
		 * ().clone());
		 * clone_state.setLhsStk((Stack<LHSStackObject>)this.getLhsStk
		 * ().clone());
		 * clone_state.setCallStk((Stack<CallStack>)this.getCallStk().clone());
		 * clone_state
		 * .setRecursionStk((Stack<CallStack>)this.getRecursionStk().clone());
		 */

		clone_state.setConditionalStk(this.getConditionalStk());
		clone_state.setLhsStk(this.getLhsStk());
		clone_state.setCallStk(this.getCallStk());
		clone_state.setRecursionStk(this.getRecursionStk());
		/*
		 * //////////////System.out.println("Old State == NewState: \n" +
		 * (this.global == clone_state.global));
		 * //////////////System.out.println("OldState.equals(New State): \n" +
		 * this.global.equals(clone_state.getGlobal()));
		 * 
		 * //////////////System.out.println("Old State: \n" + this.toString());
		 * //////////////System.out.println("New State: \n" +
		 * clone_state.toString());
		 */
		return clone_state;
	}

	public void unfreezeState(State freezedState) {
		this.setHeap(freezedState.getHeap());
		if (!(freezedState.getGlobal().getObjValue() == null))
			this.setGlobal(freezedState.getGlobal());
		if (!(freezedState.getScope().getObjValue() == null))
			this.setScope(freezedState.getScope());

		/*
		 * this.setCallStk(freezedState.getCallStk());
		 * this.setLhsStk(freezedState.getLhsStk());
		 * this.setConditionalStk(freezedState.getConditionalStk());
		 * this.setRecursionStk(freezedState.getRecursionStk());
		 */
	}

	/**
	 * @return the arrayVals
	 */
	public LinkedList<ObjectValue> getArrayVals() {
		return arrayVals;
	}

	/**
	 * @param arrayVals
	 *            the arrayVals to set
	 */
	public void setArrayVals(LinkedList<ObjectValue> arrayVals) {
		this.arrayVals = arrayVals;
	}

	/**
	 * @return the namedValueLhs
	 */
	public String getNamedValueLhs() {
		return namedValueLhs;
	}

	/**
	 * @param namedValueLhs
	 *            the namedValueLhs to set
	 */
	public void setNamedValueLhs(String namedValueLhs) {
		this.namedValueLhs = namedValueLhs;
	}

	/**
	 * @return the lhsStk
	 */
	public Stack<LHSStackObject> getLhsStk() {
		return lhsStk;
	}

	/**
	 * @param lhsStk
	 *            the lhsStk to set
	 */
	public void setLhsStk(Stack<LHSStackObject> lhsStk) {
		this.lhsStk = lhsStk;
	}

	/**
	 * @return the heap
	 */
	public Heap getHeap() {
		return heap;
	}

	/**
	 * @param heap
	 *            the heap to set
	 */
	public void setHeap(Heap heap) {
		this.heap = heap;
	}

	/**
	 * @return the scope
	 */
	public Location getScope() {
		return scope;
	}

	/**
	 * @param scope
	 *            the scope to set
	 */
	public void setScope(Location scope) {
		if (scope.getObjValue() == null)
			throw new NullPointerException();
		this.scope = scope;
	}

	/**
	 * @return the resultValue
	 */
	public ObjectValue getResultValue() {
		return resultValue;
	}

	/**
	 * @param resultValue
	 *            the resultValue to set
	 */
	public void setResultValue(ObjectValue resultValue) {
		this.resultValue = resultValue;
	}

	/**
	 * @return the resultType
	 */
	public String getResultType() {
		return resultType;
	}

	/**
	 * @param resultType
	 *            the resultType to set
	 */
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	/**
	 * @return the resultParent
	 */
	public Location getResultParent() {
		return resultParent;
	}

	/**
	 * @param resultParent
	 *            the resultParent to set
	 */
	public void setResultParent(Location resultParent) {
		this.resultParent = resultParent;
	}

	/**
	 * @return the global
	 */
	public Location getGlobal() {
		return heap.getGlobal();
	}

	/**
	 * @param global
	 *            the global to set
	 */
	public void setGlobal(Location global) {
		heap.setGlobal(global);
	}

	/**
	 * Add a property to the current scope object
	 * 
	 * @param lhs
	 * @param ov
	 */
	public void addToScope(String lhs, ObjectValue ov) {
		heap.add(scope, lhs, ov);
	}

	/**
	 * Return the enclosing scope of a particular property
	 * 
	 * @param property
	 * @return
	 */
	public Location Scope(String property) {
		return heap.Scope(scope, property);
	}

	/**
	 * Return the enclosing scope of a particular property
	 * 
	 * @param property
	 * @return
	 */
	public Location Scope(Location scp, String property) {
		return heap.Scope(scp, property);
	}

	/**
	 * Return the location in which a particular property is located
	 * 
	 * @param property
	 * @return
	 */
	public Location Prototype(Location l, String property) {
		return heap.Prototype(l, property);
	}

	public boolean hasPrototypeProperty(Location l) {
		ObjectValue proto = this.getPropertyValue(l, "prototype");
		if (proto != null) {
			if (proto instanceof Location)
				return true;
			else
				return false;
		} else
			return false;
	}

	public Location walkPrototype(Location l, String id) {
		Location proto = (Location) this.getPropertyValue(l, "prototype");
		// get the scope in which the property is located
		// start checking from the prototype scope
		Location scope = this.Scope(proto, id);
		// parent_id gets the exact location in which the property is located
		Location parent_id = this.Prototype(scope, id);
		if (parent_id != null)
			return parent_id;

		// If we can't find the id in the prototype's scope or __proto__
		// Try checking the prototype's prototype
		if (this.hasPrototypeProperty(proto)) {
			return walkPrototype(proto, id);
		}

		return null;

	}

	/**
	 * Returns an object value associated with a property of a particular
	 * location
	 * 
	 * @param l
	 * @param prop
	 * @return
	 */
	public ObjectValue getPropertyValue(Location l, String prop) {
		if (l == null)
			return null;
		JSObject parent = heap.get(l);
		if (parent != null) {
			ObjectValue property = parent.get(prop);
			return property;
		} else {
			return null;
		}
	}

	/**
	 * Assign an Object value to a particular property of the JSObject
	 * associated with the location l
	 * 
	 * @param l
	 * @param prop
	 * @param val
	 */
	public void setProperty(Location l, String prop, ObjectValue val) {
		heap.add(l, prop, val);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\n State \n [heap=" + heap + ", \n resultParent="
				+ resultParent + ", \n global: " + heap.getGlobal()
				+ ", \n resultType=" + resultType + ", \n resultValue="
				+ resultValue + ", \n scope=" + scope + "\n" + arrayVals + "]";
	}

	/**
	 * add a location, object pair to the heap
	 * 
	 * @param loc
	 * @param o
	 * @return
	 */
	public Location addToHeap(String loc, JSObject o) {
		return heap.alloc(loc, o);
	}

	/**
	 * add a location, object pair to the heap
	 * 
	 * @param loc
	 * @param o
	 * @return
	 */
	public void addToHeap(Location loc, JSObject o) {
		heap.put(loc, o);
	}

	/**
	 * add a new property to a location in the heap
	 * 
	 * @param loc
	 * @param m
	 * @param val
	 */
	public void addProperty(Location loc, String m, ObjectValue val) {
		/*
		 * if(val == null){
		 * //////////////System.out.println("add property -- location: " + loc +
		 * " property: " + m); }
		 */
		heap.add(loc, m, val);
	}

	/**
	 * Clears the old result values so that they don't affect the next
	 * expression
	 */
	public void clearOldResults() {
		this.resultParent = null;
		this.resultValue = null;
		this.isInnerHTML = false;
	}

	/*
	 * Operations on the expression stack
	 */

	/**
	 * Push the current result value onto the lhs stack
	 */
	public void pushOntoLhsStack(String description) {
		LHSStackObject l = new LHSStackObject(this.resultParent,
				this.resultValue, this.resultType, this.arrayVals,
				this.isInnerHTML, description);
		// //////System.out.println("push onto LHS Stack: <<<<<<<< " +
		// description);
		lhsStk.push(l);
	}

	public void pushOntoLhsStack(LHSStackObject l) {
		// //////System.out.println("push onto LHS Stack: <<<<<<<< " +
		// l.getDescription());
		lhsStk.push(l);
	}

	/**
	 * Pop the last element from the stack
	 * 
	 * @return
	 */
	public LHSStackObject popFromLhsStack() {
		LHSStackObject lo = lhsStk.pop();
		// recLhsStk.push(lo);
		// //////System.out.println("pop from LHS Stack: -------- " +
		// lo.getDescription());
		return lo;
	}

	public void setResultValueFromStack() {
		LHSStackObject top = this.popFromLhsStack();
		if (top != null) {
			this.resultParent = top.getLhsParent();
			this.resultValue = top.getLhsValue();
			this.resultType = top.getLhsType();
			this.arrayVals = top.getArrayVals();
			this.isInnerHTML = top.isInnerHTML();
		} else {
			clearOldResults();
		}
	}

	public LHSStackObject peekLhsStack() {
		if (lhsStk == null)
			return null;
		if (lhsStk.isEmpty())
			return null;
		return lhsStk.peek();
	}

	public void setFromStackObject(LHSStackObject top) {
		if (top != null) {
			this.resultParent = top.getLhsParent();
			this.resultValue = top.getLhsValue();
			this.resultType = top.getLhsType();
			this.arrayVals = top.getArrayVals();
			this.isInnerHTML = top.isInnerHTML();
		} else {
			clearOldResults();
		}
	}

	public void addToArrayVals(ObjectValue av) {
		if (arrayVals == null)
			arrayVals = new LinkedList<ObjectValue>();
		arrayVals.add(av);
	}

	/*
	 * Operations on the Field Stack
	 */

	/**
	 * @return the fieldStk
	 */
	public Stack<CallStack> getFieldStk() {
		return fieldStk;
	}

	/**
	 * @param fieldStk
	 *            the fieldStk to set
	 */
	public void setFieldStk(Stack<CallStack> fieldStk) {
		this.fieldStk = fieldStk;
	}

	public void pushOntoFieldStack(CallStack cstk) {
		// //System.out.println("Push onto Call Stack: <! " +
		// cstk.getRetNode().toStringTree());
		if (this.fieldStk == null)
			this.fieldStk = new Stack<CallStack>();
		this.fieldStk.push(cstk);
	}

	public void pushOntoFieldStack(Location scope, CommonTree ast) {
		if (this.fieldStk == null)
			this.fieldStk = new Stack<CallStack>();
		this.fieldStk.push(new CallStack(scope, ast));
	}

	public CallStack popFromFieldStack() {
		CallStack cs = fieldStk.pop();
		return cs;
	}

	public void setScopeFromFieldStack() {
		CallStack cs = popFromFieldStack();
		this.scope = cs.getRetScope();
	}

	/*
	 * Operations on the Call Stack
	 */

	/**
	 * @return the callStk
	 */
	public Stack<CallStack> getCallStk() {
		return callStk;
	}

	/**
	 * @param callStk
	 *            the callStk to set
	 */
	public void setCallStk(Stack<CallStack> callStk) {
		this.callStk = callStk;
	}

	public void pushOntoCallStack(CallStack cstk) {
		// //System.out.println("Push onto Call Stack: <! " +
		// cstk.getRetNode().toStringTree());
		if (this.callStk == null)
			this.callStk = new Stack<CallStack>();
		this.callStk.push(cstk);
	}

	public void pushOntoCallStack(Location scope, CommonTree ast) {
		if (this.callStk == null)
			this.callStk = new Stack<CallStack>();
		this.callStk.push(new CallStack(scope, ast));
	}

	/* Return hashcode value of the call stack */
	public int getCallHashCode() {
		// System.out.println("CallStack: " + this.callStk.toString());
		// int hash = this.callStk.hashCode();
		int hash = 0;
		for (CallStack cls : this.callStk) {
			hash += cls.getRetNode().hashCode() + cls.getRetScope().hashCode();
		}
		return hash;
	}

	/**
	 * When popping from the call stack, we push the value into the
	 * recursionStack. This will ensure that the conditionals inside a recursive
	 * function behave properly.
	 * 
	 * @return
	 */
	public CallStack popFromCallStack() {

		CallStack cs = callStk.pop();
		// //System.out.println("Pop from Call Stack: >> " +
		// cs.getRetNode().toStringTree());
		// Removed support for recursion stack
		// recursionStk.push(cs);
		return cs;
	}

	public CallStack popFromCallStackWithoutAddingToRecursion() {
		CallStack cs = callStk.pop();
		return cs;
	}

	public void setScopeFromCallStack() {
		CallStack cs = popFromCallStackWithoutAddingToRecursion();
		this.scope = cs.getRetScope();
	}

	public CallStack peekCallStack() {
		if (callStk == null)
			return null;
		if (callStk.isEmpty())
			return null;
		return callStk.peek();
	}

	/**
	 * @return the recursionStk
	 */
	public Stack<CallStack> getRecursionStk() {
		return recursionStk;
	}

	/**
	 * @param recursionStk
	 *            the recursionStk to set
	 */
	public void setRecursionStk(Stack<CallStack> recursionStk) {
		this.recursionStk = recursionStk;
	}

	public void pushOntoRecursionStack(CallStack cstk) {
		if (this.recursionStk == null)
			this.recursionStk = new Stack<CallStack>();
		this.recursionStk.push(cstk);
	}

	public CallStack popFromRecursionStack() {
		CallStack cstk = recursionStk.pop();
		return cstk;
	}

	/**
	 * @return the recLhsStk
	 */
	/*
	 * public Stack<LHSStackObject> getRecLhsStk() { return recLhsStk; }
	 * 
	 * 
	 * public void setRecLhsStk(Stack<LHSStackObject> recLhsStk) {
	 * this.recLhsStk = recLhsStk; }
	 * 
	 * public void pushOntoRecLhsStack(LHSStackObject cstk){ if(this.recLhsStk
	 * == null) this.recLhsStk = new Stack<LHSStackObject>();
	 * this.recLhsStk.push(cstk); }
	 * 
	 * public LHSStackObject popFromRecLhsStack(){ LHSStackObject cstk =
	 * recLhsStk.pop(); return cstk; }
	 */

	/**
	 * prints the current graph in a file
	 * 
	 * @param filename
	 */
	public void printInFile(String filename) {
		String graph = heap.toGraphRep();
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filename));
			out.write(graph);
			out.close();
		} catch (IOException e) {
		}

	}

	/**
	 * @return the conditionalStk
	 */
	public Stack<ConditionalStkElem> getConditionalStk() {
		return conditionalStk;
	}

	/**
	 * @param conditionalStk
	 *            the conditionalStk to set
	 */
	public void setConditionalStk(Stack<ConditionalStkElem> conditionalStk) {
		this.conditionalStk = conditionalStk;
	}

	public void pushOntoConditionalStk(ConditionalStkElem entry) {
		if (this.conditionalStk == null) {
			this.conditionalStk = new Stack<ConditionalStkElem>();
		}
		this.conditionalStk.push(entry);
	}

	public ConditionalStkElem popFromConditionalStk() {
		return this.conditionalStk.pop();
	}

	// Removed support for recursion stack
	public void popFromRecursionOrCallStack(CommonTree parent) {
		boolean removed = false;
		if (!callStk.empty()) {
			CallStack cll = callStk.peek();
			if (cll.getRetNode().toStringTree().equals(parent.toStringTree())) {
				callStk.pop();
				// ////System.out.println("Removed element from call stack: " +
				// cll.getRetNode().toStringTree());
				removed = true;
			}
		}
		if (!removed) {
			if (!recursionStk.empty()) {
				int stksize = recursionStk.size();
				for (int i = stksize - 1; i >= 0; i--) {
					CallStack rec = recursionStk.get(i);
					if (rec.getRetNode().toStringTree().equals(
							parent.toStringTree())) {
						recursionStk.remove(i);
						// ////System.out.println("Removed element from recursion stk: "
						// + rec.getRetNode().toStringTree());
						break;
					}
				}
			}
		}
	}

	/**
	 * @return the isInnerHTML
	 */
	public boolean isInnerHTML() {
		return isInnerHTML;
	}

	/**
	 * @param isInnerHTML
	 *            the isInnerHTML to set
	 */
	public void setInnerHTML(boolean isInnerHTML) {
		this.isInnerHTML = isInnerHTML;
	}

	/**
	 * @param isInnerHTML
	 *            the isInnerHTML to set
	 */
	public void reSetInnerHTML() {
		this.isInnerHTML = false;
	}

}
