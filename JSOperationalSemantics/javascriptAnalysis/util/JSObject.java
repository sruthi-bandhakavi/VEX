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

import java.util.*;

/** 
 * The JSObject data-structure holds an Object description. 
 * It is <Property, Object Value> pair.
 *  o := "{" [(i:ov)~] "}"  - object
 *  i := m | *id			    - object properties
 *  m := "foo" | "bar" | ...- string literals
 *  id := foo | bar | ...   - identifiers
 *  ov := String | location | taint | fun "(" [x~] ")" "{" [P] "}"  
 *     - object value is a heap location or a string representing 
 *       a security type or a function declaration or a string 
 *       representing the type or value of the object. 
 *   
 */
public class JSObject{
	// Set containing <Property,Object Value> pairs
	TreeMap<String, ObjectValue> object;
	
	public JSObject(){
		this.object = new TreeMap<String,ObjectValue>();
	}
	
	public JSObject(TreeMap<String, ObjectValue> object) {
		super();
		this.object = object;
	}
	
	/**
	 * @return the object
	 */
	public TreeMap<String, ObjectValue> getObject() {
		return object;
	}

	/**
	 * @param object the object to set
	 */
	public void setObject(TreeMap<String, ObjectValue> object) {
		this.object = object;
	}

	/**
	 * Adds a property to the object
	 * @param i
	 * @param ov
	 */
	public void put(String i, ObjectValue ov){
		if(object == null){
			object = new TreeMap<String, ObjectValue>();
		}
		object.put(i,ov);
	}
	
	/**
	 * Reads the object value of an object property
	 * @param i
	 * @return
	 */
	public ObjectValue get(String i){
		return object.get(i);
	}
	
	/**
	 * Removes the property with property name i
	 * @param i : location to be removed
	 * @return the removed value
	 */
	public ObjectValue remove(String i){
		return object.remove(i);
	}
	
	/**
	 * Checks if a particular property is in the object
	 * @param i
	 * @return
	 */
	public boolean isin(String i){
		if(object == null)
			return false;
		return object.containsKey(i);
	}
	
	/** 
	 * Checks if the particular property is not in the object
	 * @param i
	 * @return
	 */
	public boolean isnotin(String i){
		if(object == null)
			return false;
		return !object.containsKey(i);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JSObject [object=" + object + "]";
	}
	
	public int getSize(){
		if(object == null)
			return 0;
		return object.size();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((object == null) ? 0 : object.hashCode());
		return result;
	}
	
	public Set<String> getKeySet(){
		if(object == null)
			return null;
		return object.keySet();
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) // return true if object addresses match
			return true;
		if (obj == null) // return false if obj is null, while this is not
			return false;
		if (getClass() != obj.getClass()) // return false if class types don't match
			return false;
		JSObject other = (JSObject) obj; 
		if (object == null) { // proceed if check if both the treemaps are null
			if (other.object != null) // otherwise return false
				return false;
		} else{ 
			if (object.size() != other.getSize()){ // if the size of both the maps is not the same, then return false
				return false;
			} else { // keyset sizes match
				Set<String> this_keyset = this.getKeySet();
				Set<String> other_keyset = other.getKeySet();
				if(this_keyset != null && other_keyset != null){ // If the key sets are not empty
					if(this_keyset.containsAll(other_keyset) && other_keyset.containsAll(this_keyset)){ // check if both the keysets have the same keys
						// If true, compare value sets
						boolean retval = true;
						for(String key:this_keyset){
							ObjectValue this_value = this.get(key);
							ObjectValue other_value = other.get(key);
							// if either values is null and the other is not, return false
							if((this_value == null && other_value != null) || (this_value != null && other_value == null)){
								retval = false;
								break;
							}
							// Otherwise, check if both are null or their values are equal
							if(this_value == null && other_value == null){
								retval = retval && true;
							}else{
								retval = retval && (this_value.equals(other_value));
							}
						}
						return retval;
					}else{ 
						// If false, the maps don't have the same keys
						return false;
					}
				}else{ // The JSObject does not have any keys yet
					if(this_keyset == null && other_keyset == null)
						return true;
					else
						return false;
				}
			}
		}	
		return true;
	}
	
	
	public boolean isomorphic(JSObject other) {
		if (this == other) // return true if object addresses match
			return true;
		if (other == null) // return false if obj is null, while this is not
			return false;
		if (getClass() != other.getClass()) // return false if class types don't match
			return false;
		if (object == null) { // proceed if check if both the treemaps are null
			if (other.object != null) // otherwise return false
				return false;
		} else{ 
			if (object.size() != other.getSize()){ // if the size of both the maps is not the same, then return false
				return false;
			} else { // keyset sizes match
				Set<String> this_keyset = this.getKeySet();
				Set<String> other_keyset = other.getKeySet();
				if(this_keyset != null && other_keyset != null){ // If the key sets are not empty
					if(this_keyset.containsAll(other_keyset) && other_keyset.containsAll(this_keyset)){ // check if both the keysets have the same keys
						// If true, compare value sets
						boolean retval = true;
						for(String key:this_keyset){
							ObjectValue this_value = this.get(key);
							ObjectValue other_value = other.get(key);
							// if either values is null and the other is not, return false
							if((this_value == null && other_value != null) || (this_value != null && other_value == null)){
								retval = false;
								break;
							}
							// Otherwise, check if both are null or their values are equal
							if(this_value == null && other_value == null){
								retval = retval && true; 
							}else{ // check if the object value addresses match
								retval = retval && (this_value == other_value);
							}
						}
						return retval;
					}else{ 
						// If false, the maps don't have the same keys
						return false;
					}
				}else{ // The JSObject does not have any keys yet
					if(this_keyset == null && other_keyset == null)
						return true;
					else
						return false;
				}
			}
		}	
		return true;
	}
	/**
	 * Create a deep clone of the current object
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public JSObject deepClone(){
		
		JSObject obj = new JSObject((TreeMap<String, ObjectValue>)object.clone());
		
		/*JSObject obj = new JSObject();
		
		if(object == null){
			obj.setObject(null);
			return obj;
		}
		
		Set<String> keys = this.getKeySet();
		for(String key : keys){
			// create a new key
			// String key_new = new String(key);
			String key_new = key;
			
			ObjectValue old_ov = this.get(key);
			ObjectValue new_ov = null;
			// create a deep clone of the old object value
			if(old_ov != null)
				new_ov = old_ov.deepClone();
			obj.put(key_new, new_ov);	
		}*/
		
		return obj;
	}
	
	public SecurityType computeTaint(State pre, Set<String> predefProps){
		SecurityType ret = (SecurityType) this.get("at_Taint");
		if(ret == null)
			ret = SecurityType.createSecurityType(SecurityType.high,null);
		if(ret.isTainted()) // If the current value is tainted already, no need to go to its properties
			return ret;
		Set<String> keys = this.getKeySet();
		for(String key : keys){
			if(!predefProps.contains(key)){
				//System.out.println("computeTaint Key:" + key);
				ObjectValue key_val = this.get(key);
				if(key_val instanceof Location){
					JSObject argobj = pre.getHeap().get((Location)key_val);
					SecurityType propTaint = argobj.computeTaint(pre, predefProps);
					ret = ret.join(propTaint);
				}
			}
		}
		return ret;
	}

	public static void main(String[] args){
		JSObject obj = new JSObject();
		for(int i=0;i<10; i++){
			obj.put(new String("x"), new Location("Y"));
			obj.put(new String("a"), new SecurityType(SecurityType.high, null));
			obj.put(new String("u"), new ObjectValue("fun t(){}"));
		}
		// Testing comparison of locations
		Location l1 = new Location("x");
		Location l2 = new Location("y");
		System.out.println("l1 = l2: "+ l1.equals(l2));
		
		JSObject obj0 = new JSObject();
		for(int i=0;i<10; i++){
			obj0.put(new String("x"), new Location("Y"));
			obj0.put(new String("a"), new SecurityType(SecurityType.high, null));
			obj0.put(new String("u"), new ObjectValue("fun t(){}"));
		}
		
		JSObject obj1 = new JSObject();
		for(int i=0;i<10; i++){
			obj1.put(new String("x"), new Location("K"));
			obj1.put(new String("a"), new SecurityType(SecurityType.high,null));
			obj1.put(new String("u"), new ObjectValue("fun t(){}"));
		}
		
		JSObject obj2 = null;
		
		JSObject obj3 = new JSObject();
		for(int i=0;i<10; i++){
			//obj3.put(new String("x"), new Location("K"));
			obj3.put(new String("a"), new SecurityType(SecurityType.high, null));
			obj3.put(new String("u"), new ObjectValue("fun t(){}"));
		}
		
		JSObject obj4 = new JSObject();
		for(int i=0;i<10; i++){
			obj4.put(new String("x"), new Location("K"));
			//obj3.put(new String("a"), new SecurityType(SecurityType.high));
			obj4.put(new String("u"), new ObjectValue("fun t(){}"));
		}
		
		JSObject obj5 = new JSObject();
		
		JSObject obj6 = new JSObject(); // out of order insertions
		for(int i=0;i<10; i++){
			obj6.put(new String("u"), new ObjectValue("fun t(){}"));
			obj6.put(new String("x"), new Location("Y"));
			obj6.put(new String("a"), new SecurityType(SecurityType.high,null));
		}
		
		JSObject obj7 = obj.deepClone(); 
		obj7.put(new String("b"), new ObjectValue("T"));
		
		JSObject obj8 = obj7.deepClone();
		obj7.put(new String("c"), new ObjectValue("T"));
		
		
		System.out.println("obj: " +obj + " obj0: "+ obj0 + " \n\t\t comparing two JSObjects: " + obj.equals(obj0));
		System.out.println("obj: " +obj + " obj1: "+ obj1 + " \n\t\t comparing two JSObjects: " + obj.equals(obj1));
		System.out.println("obj: " +obj + " obj2: "+ obj2 + " \n\t\t comparing two JSObjects: " + obj.equals(obj2));
		System.out.println("obj: " +obj + " obj3: "+ obj3 + " \n\t\t comparing two JSObjects: " + obj.equals(obj3));
		System.out.println("obj: " +obj + " obj4: "+ obj4 + " \n\t\t comparing two JSObjects: " + obj.equals(obj4));
		System.out.println("obj: " +obj + " obj5: "+ obj5 + " \n\t\t comparing two JSObjects: " + obj.equals(obj5));
		System.out.println("obj: " +obj + " obj6: "+ obj6 + " \n\t\t comparing two JSObjects: " + obj.equals(obj6));
		System.out.println("obj: " +obj + " obj7: "+ obj7 + " \n\t\t comparing two JSObjects: " + obj.equals(obj7));
		System.out.println("obj: " +obj7 + " obj7: "+ obj8 + " \n\t\t comparing two JSObjects: " + obj7.equals(obj8));		
		
	}
}
