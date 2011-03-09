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

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

/**
 * Stack to keep the return location and scope that needs to be reached after 
 * function return 
 * @author sruthi
 *
 */
public class CallStack {

	Location retScope; // Return Scope
	CommonTree retNode; // Return Node
	
	public CallStack(Location retScope, CommonTree retNode) {
		super();
		this.retScope = retScope;
		this.retNode = retNode;
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
	
	public int retNodeLineNumber(){
		return this.retNode.getLine();
	}

	
}
