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

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class HelperFunctions {
	
	public static int computeFunctionArgumentSize(CommonTree fun_ast){
		int args = 0;
		if(fun_ast.getChildCount() == 2)
			args = 0;
		else
			args = 1;
		return ((CommonTree)fun_ast.getChild(args)).getChildCount();
	}
	
	/**
	 * Function object creation
	 * 
	 * p = new_object("Object",#ObjectProt)
	 * H1,l1 = alloc(H,p)
	 * o = new_function(fun([x~]){P},l,l1)
	 * H2,l2 = Alloc(H1,o)
	 * H3 = H2(l1."constructor"=l2{DontEnum})  
	 * --------------------------------------  [H-Function]    
	 *	H,Function(fun([x~]){P},l) = H3,l2   
	 *
	 * @param fun_ast
	 * @param l
	 * @return
	 */
	public static Location Function(CommonTree fun_ast, Heap h1, Location fscope, String currentFileName, SecurityType s){
		JSObject p = PredefinedObjectTemplates.new_object("Object",NativeObjects.ObjectProt,s);
		
		// l1 will be assigned to the function prototype
		Location l1 = h1.alloc( fun_ast.getLine() + "_Prot", p);
		
		JSObject o = PredefinedObjectTemplates.new_function(HelperFunctions.computeFunctionArgumentSize(fun_ast), fun_ast, fscope, l1, s);
		
		Location l2 = h1.alloc(String.valueOf(fun_ast.getLine()), o);
		
		// The prototype's constructor is the current function object
		h1.add(l1, "__constructor__", l2);
		//System.out.println("Function object: " + o);
		//currentState.setResultValue(l2);
		return l2;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
