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

import org.antlr.runtime.tree.CommonTree;

/**
 * @author sruthi
 * 
 */
public class FunctionValue extends ObjectValue {

	CommonTree functionAST;

	/**
	 * Takes the function AST and assigns its String representation to the
	 * ObjectValue string
	 * 
	 * @param fast
	 */
	public FunctionValue(CommonTree fast) {
		super();
		functionAST = fast;

		/*
		 * if(fast != null) super.setObjValue(fast.toStringTree());
		 */

	}

	/**
	 * @return the functionAST
	 */
	public CommonTree getFunctionAST() {
		return functionAST;
	}

	/**
	 * @param functionAST
	 *            the functionAST to set
	 */
	public void setFunctionAST(CommonTree functionAST) {
		this.functionAST = functionAST;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[FunctionValue : " + this.functionAST.toStringTree() + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javascriptAnalysis.util.ObjectValue#deepClone()
	 */
	@Override
	public FunctionValue deepClone() {
		FunctionValue fv = new FunctionValue(this.getFunctionAST());
		return fv;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
