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

import java.util.HashSet;
/**
 * 
 * @author sruthi
 *
 */
public class StateSet {
	
	HashSet<State> states;
	
		
	/**
	 * Constructors
	 */
	public StateSet() {
		super();
		this.states = new HashSet<State>();
	}
	
	public StateSet(HashSet<State> states) {
		super();
		this.states = states;
	}

	/**
	 * @return the state
	 */
	public HashSet<State> getStates() {
		return states;
	}

	/**
	 * @param state the state to set
	 */
	public void setStates(HashSet<State> state) {
		this.states = states;
	}

	/**
	 * Add a state to the StateSet
	 * @param s
	 */
	public void addState(State s){
		if(states == null){
			states = new HashSet<State>();
		}
		states.add(s);
	}
	
	public boolean isEmpty(){
		if(states == null)
			return true;
		return states.isEmpty();
	}
	
	/**
	 * Add all elements of the StateSet s to the current StateSet
	 * @param s
	 */
	public void addAll(StateSet s){
		if(s == null || s.isEmpty()) // if the rhs state set is empty or null
			return;
		if(states == null){ // if the current state set is null 
			this.setStates(s.getStates()); // set the current stateset to be the rhs state set
			return;
		}
		states.addAll(s.getStates()); // otherwise, add the rhs elements to the current set
		return;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StateSet [states=" + states + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
