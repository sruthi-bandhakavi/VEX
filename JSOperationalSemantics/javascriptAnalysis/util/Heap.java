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

import org.antlr.runtime.tree.CommonTree;

import javascriptAnalysis.parser.ProgramAnalyzerC;

/** 
 * The Heap data-structure that holds the JavaScript heap. Our implementation keeps track of a single 
 * abstract heap at each program point. The the heap contents are rolled back when the program 
 * backtracks. It is represented as a pair of <location, Object>
 *  H ::= (l : o)~
 */
public class Heap{
	TreeMap<Location,JSObject> heap;
	
	// To keep only a single object value for a String
	HashMap<String,Location> strValueMap;
	
	// Keep track of the pivot global location along with the heap
	Location global;
	
	// Keep track of the dummy objects with the same taint values
	HashMap<String,Location> dummyObjectMap;
	
	/**
	 * @return the strValueMap
	 */
	private HashMap<String, Location> getStrValueMap() {
		return strValueMap;
	}

	/**
	 * @param strValueMap the strValueMap to set
	 */
	private void setStrValueMap(HashMap<String, Location> strValueMap) {
		this.strValueMap = strValueMap;
	}

	public void addToStrValueMap(String var, Location ov){
		this.strValueMap.put(var,ov);
	}
	
	public Location getStrObjectValue(String var){
		return this.strValueMap.get(var);
	}
	
	public Heap(){
		this.heap = new TreeMap<Location,JSObject>();
		this.strValueMap = new HashMap<String, Location>(); 
		this.dummyObjectMap = new HashMap<String, Location>();
		this.global = null;
	}
	
	public Heap(TreeMap<Location, JSObject> heap, HashMap<String, Location> strValueMap, HashMap<String, Location> dummyMap, Location global){
		super();
		this.heap = heap;
		this.strValueMap = strValueMap;
		this.dummyObjectMap = dummyMap;
		this.global = global;
	}
	
	/**
	 * @return the heap
	 */
	public TreeMap<Location, JSObject> getHeap() {
		return heap;
	}


	/**
	 * @param heap the heap to set
	 */
	public void setHeap(TreeMap<Location, JSObject> heap) {
		this.heap = heap;
	}

	

	/**
	 * @return the global
	 */
	public Location getGlobal() {
		return global;
	}

	/**
	 * @param global the global to set
	 */
	public void setGlobal(Location global) {
		this.global = global;
	}

	/**
	 * If the heap is not null, get the object associated 
	 * with a particular location and return it. 
	 * @param l
	 * @return value is either an object set or null 
	 */
	public JSObject get(Location l){
		if(heap != null){
			return heap.get(l); // return value could be null
		}
		return null;
	}
	
	/**
	 * Assign an object to a particular heap location.
	 * @param l
	 * @param os
	 */
	public void put(Location l, JSObject os){
		if(heap == null)
			heap = new TreeMap<Location,JSObject>();
		heap.put(l, os);
	}
	
	/**
	 * Remove an object associated with a particular location
	 */
	public JSObject remove(Location l){
		if(heap == null)
			return null;
		JSObject ov = heap.remove(l);
		return ov;
	}
	
	
	
	/**
	 * @return the dummyObjectMap
	 */
	private HashMap<String, Location> getDummyObjectMap() {
		return dummyObjectMap;
	}

	/**
	 * @param dummyObjectMap the dummyObjectMap to set
	 */
	private void setDummyObjectMap(HashMap<String, Location> dummyObjectMap) {
		this.dummyObjectMap = dummyObjectMap;
	}

	/**
	 * Return the keyset of the heap
	 * @return
	 */
	public Set<Location> getKeySet(){
		return heap.keySet();
	}
	
	
	public Heap clone(){
		if(heap != null)
			return new Heap((TreeMap<Location,JSObject>)heap.clone(), (HashMap<String, Location>)this.strValueMap.clone(), (HashMap<String, Location>)this.dummyObjectMap.clone(), this.getGlobal());
		else
			return null;
	}
	
	/**
	 * Create a deep clone of the heap and return it
	 * @return
	 */
	public Heap deepClone(){
		Heap hp = new Heap();
		if(this.heap == null){
			hp.setHeap(null);
			return hp;
		}
		

		//set the clone global element
		hp.setGlobal(this.getGlobal());
		
		Set<Location> keys = this.getKeySet();
		for(Location key : keys){
			JSObject old_ov = this.get(key);
			// create a deep clone of the old object value
			JSObject new_ov = old_ov.deepClone();
			hp.put(key, new_ov);	
		}
		
		hp.setStrValueMap((HashMap<String, Location>)this.strValueMap.clone());
		hp.setDummyObjectMap((HashMap<String, Location>)this.dummyObjectMap.clone());
		
		return hp;
	}
	
	/**
	 * alloc is used to create a new location for an object at a particular line number(pc). 
	 * An entry could already exist for that particular pc, in which case the new object 
	 * replaces the previous object 
	 * @param location_id - unique location name
	 * @param o
	 * @return the newly created or the already existing location
	 */
	public Location alloc(String location_id, JSObject o){
		if(heap == null)
			heap = new TreeMap<Location,JSObject>();
		
		// Generate a new location for a given location id
		Location loc = new Location(location_id);
		
		if(heap.containsKey(loc)){ // if the particular location already exists
			// then remove that previous entry
			JSObject os = this.remove(loc);	
		}
		
		// put the new object set into the location
		heap.put(loc,o);
		
		return loc;
	}
	
	public int getSize(){
		if(heap == null){
			return 0;
		}
		return heap.size();
	}
	
	/**
	 * add a (property, value) pair to an object at a given location 
	 * @param l
	 * @param property
	 * @param ov
	 */
	public void add(Location l, String property, ObjectValue ov){
		JSObject os;
		
		if(heap == null){ // if the heap is null
			heap = new TreeMap<Location,JSObject>();
		}
		
		// if there are no entries in the heap or if there are no entries for the particular location
		if(heap.isEmpty()  || !heap.containsKey(l)){ 
			// create a new object for the location
			os = new JSObject(); 
			
			// add the newly created object to the heap
			this.put(l, os);
		}
		
		// get the object for the heap location
		os = this.get(l);
		
		// add the current object value to every object in the ObjectSet
		os.put(property,ov);		
	}
	
	/**
	 * Removes the property with property name i
	 * @param l : location in the heap
	 * @param property : property name
	 */
	public void delete(Location l, String property){
		if(heap == null)
			return;
		
		// get the object set for the location l
		JSObject os = this.get(l);
		
		// if the object exists, then delete the property from each object in the ObjectSet
		if(os != null)
			os.remove(property);
		return;
	}
	
	/**
	 * Method used to create dummy objects
	 * 
	 * The Object name contains the filename and line number at which the undefined variable is being accessed
	 * 
	 * A new property at_Dummy is introduced to mark this node
	 * 
	 * TODO: Should the dummy object be marked tainted??
	 * 
	 * @param pre
	 * @return
	 */
	public Location createDummyObjectInHeap(CommonTree ast, SecurityType dummy_type) {
		String taint_val = dummy_type.getObjValue();
		if(taint_val == null){
			taint_val = "@High";
		}
		Location dummy_loc = this.dummyObjectMap.get(taint_val);
		if(dummy_loc == null){
			Location second_result;
			// Add the low security type to the dummy object
			JSObject dummy_obj = PredefinedObjectTemplates.new_object("Object", NativeObjects.ObjectProt,dummy_type);
			dummy_obj.put("at_Dummy", new ObjectValue(true));
			// current filename sans the path
			//String[] fn = currentfilename.split("/");
			second_result = new Location("dummy_" + ast.getLine() );
			this.put(second_result, dummy_obj);
			this.dummyObjectMap.put(taint_val, second_result);
			return second_result;
		}else{
			return dummy_loc;
		}
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((heap == null) ? 0 : heap.hashCode());
		return result;
	}
	

	public boolean isomorphic(Heap other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (getClass() != other.getClass())
			return false;
		
		if (heap == null) {
			if (other.heap != null)
				return false;
		} else{
			if (heap.size() != other.getSize()){ // if the size of both the maps is not the same, then return false
				return false;
			} else { // keyset sizes match
				// less optimization
				//return checkHeapObjectEquality(other);
				
				// max optimization
				return checkContentEquality(other,this.getGlobal(),other.getGlobal());
			}
		}
		return true;
	}

	/**
	 * Recursive function to check if the JSObjects in both the heaps match
	 * @param other
	 * @param this_global
	 * @param other_global
	 * @return
	 */
	private boolean checkContentEquality(Heap other, Location this_obj, Location other_obj) {
		JSObject curr_obj = this.get(this_obj);
		JSObject test_obj = other.get(other_obj);
		
		if(curr_obj == null && test_obj == null)
			return true;
		
		if((curr_obj != null && test_obj == null) || (curr_obj == null && test_obj != null))
			return false;
		
		SecurityType curr_taint = (SecurityType)curr_obj.get("at_Taint");
		SecurityType test_taint = (SecurityType)test_obj.get("at_Taint");
		
		// Proceed further only if the JSObject taints match
		if(curr_taint.equals(test_taint)){
			// If the location is a dummy object, it suffices to just check the taints
			if(other.isDummy(other_obj) && this.isDummy(this_obj)){
				return true;
			}
			 
			Set<String> this_keyset = curr_obj.getKeySet();
			Set<String> other_keyset = test_obj.getKeySet();
			// Proceed further only if the keys in both the JSObjects match
			if(this_keyset.containsAll(other_keyset) && other_keyset.containsAll(this_keyset)){
			    // For each key compare the object values
				boolean retval = true;
				for(String key: this_keyset){
					// we don't want to go into libraryProperties as they will lead to the parents
					// creating a circular check and infinite recursion
					if(ProgramAnalyzerC.libraryProperties.contains(key))
						continue;
					if(key.equals("at_Taint")) // we already compared taints
						continue;
					ObjectValue this_val = curr_obj.get(key);
					ObjectValue other_val = test_obj.get(key);
					
					if(this_val == null && other_val == null){
						continue;
					}
					
					if((this_val == null && other_val != null) || (this_val != null && other_val == null)){
						retval = false;
						return retval;
					}
					
					if(this_val.getClass() != other_val.getClass()){
						retval = false; // If the class types don't match
						return retval;
					}
					
					if(this_val instanceof Location)
						retval = retval && checkContentEquality(other, (Location)this_val, (Location)other_val);
					if(this_val instanceof FunctionValue)
						retval = retval && ((FunctionValue)this_val).equals((FunctionValue)other_val);
					if(this_val instanceof ObjectValue)
						retval = retval && this_val.equals(other_val);
					
					if(retval == false)
						return false;
					
				}
				return retval;
			}
		}
		
		return false;
	}
	
	private boolean isDummy(Location obj){
		JSObject heapObj = this.get(obj);
		if(heapObj == null)
			return false;
		ObjectValue val = heapObj.get("at_Dummy");
		if(val != null)
			return true;
		else
			return false;
	}
	
	/**
	 * @param other
	 * @return
	 */
	private boolean checkHeapObjectEquality(Heap other) {
		Set<Location> this_keyset = this.getKeySet();
		Set<Location> other_keyset = other.getKeySet();
		if(this_keyset != null && other_keyset != null){
			if(this_keyset.containsAll(other_keyset) && other_keyset.containsAll(this_keyset)){ // check if both the keysets have the same keys
				// If true, compare value sets
				boolean retval = true;
				for(Location key:this_keyset){
					JSObject this_value = this.get(key);
					JSObject other_value = other.get(key);
					retval = retval && (this_value.isomorphic(other_value));
				}
				return retval;
			}else{ 
				// If false, the maps don't match
				return false;
			}
		}else{
			if(this_keyset == null && other_keyset == null)
				return true;
			else
				return false;
		}
	}

	
	/**
	 * Prototype Lookup
	 * @param currentLoc
	 * @param property_name
	 * @return null if the prototype chain leads to null when looking for the property
	 * 	       or a location if the object at that location contains the property
	 */
	public Location Prototype(Location currentLoc, String property_name){
		if(currentLoc != null){
			JSObject obj = this.get(currentLoc);
			if(obj != null){
				if(obj.isin(property_name))
					return currentLoc;
				else{
					Location proto = (Location)obj.get("__proto__");
					return Prototype(proto, property_name);
				}
			}		
		}
		return null;
	}
	
	/**
	 * Checks if the current location or the prototype chain of the location 
	 * has a particular property
	 * @param currentLoc
	 * @param property_name
	 * @return
	 */
	public boolean hasProperty(Location currentLoc, String property_name){
		if(Prototype(currentLoc,property_name) != null)
			return true;
		else 
			return false;
	}
	
	/**
	 * Returns the scope object enclosing the desired property
	 * @param currentLoc
	 * @param property_name
	 * @return
	 */
	public Location Scope(Location currentLoc, String property_name){
		if(currentLoc == null)
			return null;
		if(this.hasProperty(currentLoc,property_name)) // Check if the prototype chain has the property
			return currentLoc;
		else{ // if not, then check if the scope chain has the property
			JSObject obj = this.get(currentLoc);
			if(obj != null){
				Location sc = (Location)obj.get("at_Scope");
				return Scope(sc,property_name);
			}else{
				return null;
			}
		}
			
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String returnString = "";
		Set<Location> locs = heap.keySet();
		for(Location l : locs){
			returnString += "\t (" + l + ":" + heap.get(l) + ")\n";
		}
		return "Heap [heap= \n" + returnString + "]";
	}

	/**
	 * Displays the heap so that it can be visualized as a graph
	 * @return
	 */
	public String toGraphRep(){
		Location global = this.getGlobal();
		String graphviz = "digraph G{";
		Set<Location> locs = heap.keySet();
		for(Location l : locs){
			JSObject lj = heap.get(l);
			if(l == global){
				graphviz += l.getObjValue() + "[ fillcolor = \"green\", style = \"filled\"];";
			}
			
			if(lj.isin("at_Taint")){
				if(lj.get("at_Taint") != null){
					if(((SecurityType)lj.get("at_Taint")).isTainted()){
						graphviz += l.getObjValue() + "[ fillcolor = \"red\", style = \"filled\"];";
					}
				}
			}
			Set<String> keys = lj.getKeySet();
			for(String key : keys){
			  ObjectValue ov = lj.get(key);
			  if(ov != null){
				  if(ov instanceof Location){
					  
					  if(key.equals("innerHTML")){
							graphviz += ov.getObjValue() + "[ fillcolor = \"blue\", style = \"filled\"];";
					  }
					  
					  JSObject jsov = heap.get(ov);
					  if(jsov != null){
						  if(jsov.isin("at_Taint")){
							  if(jsov.get("at_Taint") != null){
								if(((SecurityType)jsov.get("at_Taint")).isTainted()){
									graphviz += ov.getObjValue() + "[ fillcolor = \"red\", style = \"filled\"];";
								}
							  }
						  }
					  }
					 
					  
					  String key_new = key;
					  if(key.endsWith("\"")){
						  key_new = key.substring(1, key.length()-1);
						  key = key_new;
					  }
					 // if(!key_new.equals("at_Class") && !key_new.equals("__constructor__") && !key_new.equals("at_FScope") && !key_new.equals("at_Scope") ){
						  graphviz += "\n" + l.getObjValue() + " -> " + ov.getObjValue() + " [ label = \"" + key_new + "\" ];";
					 // }
				  }
			  }
			}
		}
		graphviz += "}";
		return graphviz;
	}
	
	public static void main(String[] args){
		try{
			JSObject js1 = new JSObject();
			JSObject js2 = new JSObject();
			JSObject js3 = new JSObject();
			
			js1.put("x", new ObjectValue("Y"));
	
			js2.put(new String("a"), new SecurityType(SecurityType.high,null));
			js2.put(new String("u"), null);
			
			js3.put(new String("b"), null);
			
	
			// Testing the alloc function
			Heap h = new Heap();
			Location l0 = h.alloc(Location.generateLocString(), js1);
			Location l1 = h.alloc("0", js1);
			Location l2 = h.alloc("10", js2);
			System.out.println("loc 1: " + l1);
			System.out.println("loc 2: " + l2);
			System.out.println("Heap : " + h);
			
			Heap h0 = h.deepClone();
			Heap h1 = h.clone();
			//Location l3 = h.alloc("5", js3);
			
			System.out.println("Heap comparison: " + h.equals(h0));
			System.out.println("Heap comparison: " + h.equals(h1));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
