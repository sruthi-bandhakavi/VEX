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

import java.lang.NullPointerException;


/**
 * Location object keeps track of the location name. It also has a function that generates unique 
 * location names
 * @author sruthi
 *
 */
public class Location extends ObjectValue implements Comparable<Location>{
	// a static integer used to create unique location names
	private static int locval = 0;
	
	/**
	 * @return a unique location value whenever needed
	 */
	public static String generateLocString(){
		String locStr = locval+"__";
		locval++;
		return locStr;
	}
	
	/**
	 * A method to generate new location objects with a unique location name
	 * @return
	 */
	public static Location generateLocation(){
		String locStr = "loc__" + Location.generateLocString();
		Location loc = new Location(locStr);
		return loc;
	}
	
	/**
	 * Function to generate a unique location for a particular program point (pc)
	 * @param locVal
	 * @return
	 */
	public static Location generateLocation(String locVal){
		String locStr = "loc__" + locVal;
		Location loc = new Location(locStr);
		return loc;
	}
	
	public static String generateLocationString(String locVal){
		String locStr = "loc__" + locVal;
		return locStr;
	}
	
	/**
	 * Constructors
	 */
	public Location(){
		super();
	}
	
	public Location(String location) {
		super(Location.generateLocationString(location+Location.locval));
		//super(Location.generateLocationString(location));
		Location.locval++;
	}
	
	public Location clone(){
		Location l = new Location();
		l.setLocval(this.locval);
		l.setObjValue(new String(this.getObjValue()));
		return l;
	}
	

	/**
	 * @return the locval
	 */
	public static int getLocval() {
		return locval;
	}

	/**
	 * @param locval the locval to set
	 */
	public static void setLocval(int locval) {
		Location.locval = locval;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return super.getObjValue();
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		super.setObjValue(location);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[Location : " + objValue + "]";
	}
	
	/*
	 * (non-Javadoc)
	 * @see javascriptAnalysis.util.ObjectValue#deepClone()
	 */
	@Override
	public Location deepClone(){
		Location clone = new Location();
		//create a clone location value
		clone.setLocation(this.getLocation());
		// make sure the static object number gets the current value
		clone.locval = this.locval;
		return clone;
	}

	/**
	 * The compare function defined to be able to implement 
	 * the methods of the comparator interface
	 * @return
	 */
	public int compare(Location l1,Location l2){
		if (l1 == l2)
			return 0;
		if (l1 == null | l2 == null)
			throw new NullPointerException();
		String l1_val = l1.getObjValue();
		String l2_val = l2.getObjValue();
		if (l1_val == null | l2_val == null) {
			throw new NullPointerException();
		} else 
			return l1_val.compareTo(l2_val);
	}
	
	public int compareTo(Location l1){
		return compare(this,l1);
	}
	
	/**
	 * Testing if the location generator works properly
	 * @param args
	 */
	public static void main(String[] args){
		Location l = new Location();
		for(int i=0;i<10;i++){
			System.out.println(Location.generateLocString());
		}
		System.out.println("loc2" + l.locval);
		
		//Location l2 = new Location();
		for(int i=0;i<10;i++){
			System.out.println(Location.generateLocationString("loc" + i));
		}
		
		Location new_loc1 = new Location("loc"+3);
		Location new_loc2 = new Location("loc"+3);
		System.out.println("newlocation: " + new_loc1 + " \n comparison: " + new_loc1.equals(new_loc2));
		
		Location new_loc3 = new_loc1.clone();
		Location new_loc4 = new_loc1.deepClone();
		//System.out.println("newlocation hash comparisons: " + new_loc1.getObjValue().hashCode() + new_loc3.getObjValue().hashCode() + " \n comparison: " + new_loc1.equals(new_loc3));
		System.out.println(new_loc1 + "deep clone: "  + new_loc4 + " : " + new_loc4.equals(new_loc1) + " : " + (new_loc1 == new_loc4));
	}
}
