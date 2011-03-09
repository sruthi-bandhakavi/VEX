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

import java.util.LinkedList;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

/**
 * Object that generates the predefined objects based on object templates.
 * This corresponds to the section Predefined Object Templates from http://jssec.net
 * at_author sruthi
 *
 */
public class PredefinedObjectTemplates {
	
	/**
	 * template to create a new Object
	 * @param m - Name of the new object class
	 * @param l - Object __proto__
	 * @return
	 */
	public static JSObject new_object(ObjectValue ob, Location l, SecurityType s){
		JSObject obj = new JSObject();
		obj.put("at_Class", ob);
		obj.put("__proto__", l);
		obj.put("at_Taint", s);
		return obj;
	}
	
	public static JSObject new_object(String m, Location l,SecurityType s){
		JSObject obj = new JSObject();
		obj.put("at_Class", new ObjectValue(m));
		obj.put("__proto__", l);
		obj.put("at_Taint", s);
		return obj;
	}
	
	
	public static JSObject new_primitive_object(String m, Location l, SecurityType s, ObjectValue val){
		JSObject obj = new JSObject();
		obj.put("at_Class", new ObjectValue(m));
		obj.put("__proto__", l);
		obj.put("at_Taint", s);
		if(val != null)
			obj.put("at_PrimitiveValue", val);
		return obj;
	}
	
	/**
	 * __proto__
	 * @param m
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static JSObject new_proto(String m, Location l1, Location l2, SecurityType s){
		JSObject obj = new JSObject();
		obj.put("at_Class", new ObjectValue(m));
		obj.put("__proto__", l1);
		obj.put("__constructor__", l2);
		obj.put("at_Taint", s);
		return obj;
	}
	
	public static JSObject new_function(int arg_size, CommonTree body, Location l1, Location l2, SecurityType s){
		JSObject obj = new JSObject();
		obj.put("prototype", l2);
		obj.put("__proto__", NativeObjects.FunctionProt);
		obj.put("at_Class", new ObjectValue("__Function__"));
		obj.put("at_Call",new ObjectValue(true));
		obj.put("at_Construct",new ObjectValue(true));
		obj.put("at_FScope", l1);
		obj.put("at_Body", new FunctionValue(body));
		obj.put("__length__", new ObjectValue(arg_size));
		obj.put("at_Taint", s);
		return obj;
	}
	

	public static JSObject new_arguments(int n, LinkedList<ObjectValue> argList, Location l, SecurityType s){
		JSObject obj = new JSObject();
		for(int i = 0; i < n; i++){
			obj.put("__" + String.valueOf(i+1) + "__", argList.get(i));
		}
		obj.put("at_argumentsFlag", new ObjectValue("true"));
		
		obj.put("__proto__", NativeObjects.ObjectProt);
		
		obj.put("__callee__", l);
		obj.put("__length__", new ObjectValue(n));
		obj.put("at_Taint", s);
		return obj;
	}
	
	/**
	 * The callee location should be set later, when it is known
	 * @param n
	 * @param argList
	 * @return
	 */
	public static JSObject new_arguments(int n, LinkedList<ObjectValue> argList, SecurityType taint){
		JSObject obj = new JSObject();
		for(int i = 0; i < n; i++){
			obj.put("__" + String.valueOf(i+1) + "__", argList.get(i));
		}
		obj.put("at_argumentsFlag", new ObjectValue("true"));
		
		obj.put("__proto__", NativeObjects.ObjectProt);
		
		obj.put("__callee__", null);
		obj.put("__length__", new ObjectValue(n));
		obj.put("at_Taint", taint);
		return obj;
	}
	
	public static JSObject new_activation(Location l1, Location l2, Location l3, SecurityType s){
		JSObject obj = new JSObject();
		obj.put("at_Scope", l3);
		obj.put("__proto__", null);
		obj.put("at_IsActivation",new ObjectValue(true));
		obj.put("at_this", l2);
		obj.put("__arguments__", l1);
		obj.put("at_Taint",s);
		return obj;
	}
	
	/**
	 * new_Array(n[,va~]) = {
     * ["0":          va1{},
	 *	    ...
     * "n-1":          van{},]		       
     * at_Class:        "Array",
     * __proto__:    #ArrayProt,
     * "length":	    n{DontEnum,DontDelete}
     * }
	 */
	public static JSObject new_array(int n, LinkedList<ObjectValue> arrList, SecurityType s){
		JSObject obj = new JSObject();
		for(int i=0; i<n; i++){
			obj.put(String.valueOf(i), arrList.get(i));
		}
		obj.put("at_Class", new ObjectValue("Array"));
		obj.put("__proto__", NativeObjects.ArrayProt);
		obj.put("__length__", new ObjectValue(n));
		obj.put("at_Taint", s);
		return obj;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JSObject js1 = PredefinedObjectTemplates.new_object("obj", new Location("a"), new SecurityType(SecurityType.high, null));
		JSObject js2 = PredefinedObjectTemplates.new_proto("obj", new Location("a"), new Location("b"), new SecurityType(SecurityType.high, null));
		JSObject js3 = PredefinedObjectTemplates.new_function(2, null , new Location("a"),  new Location("b"), new SecurityType(SecurityType.high, null));
		JSObject js4 = PredefinedObjectTemplates.new_arguments(0, new LinkedList<ObjectValue>(),new Location("a"), new SecurityType(SecurityType.high, null));
		JSObject js5 = PredefinedObjectTemplates.new_activation(new Location("a"), new Location("b"),new Location("c"), new SecurityType(SecurityType.high, null));
		
		System.out.println("js1: " + js1.toString());
		System.out.println("js2: " + js2.toString());
		System.out.println("js3: " + js3.toString());
		System.out.println("js4: " + js4.toString());
		System.out.println("js5: " + js5.toString());
	}

}
