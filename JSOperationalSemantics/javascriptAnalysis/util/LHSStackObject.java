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

public class LHSStackObject {
	Location lhsParent; // Location of the parent object of the lhs
	ObjectValue lhsValue; // Could be a location, a value or an ObjectSet
	String lhsType; // Could be "Normal" or "Return" 
	
	LinkedList<ObjectValue> arrayVals; // Could have array values or actual function parameters
	
	boolean isInnerHTML = false;
	
	String description; //TODO: For debugging purposes
	
	public LHSStackObject() {
		super();
		this.lhsParent = null;
		this.lhsValue = null;
		this.lhsType = "Normal";
		this.arrayVals = null;
		this.isInnerHTML = false;
		this.description = "empty";
	}
	
	public LHSStackObject(Location lhsParent, ObjectValue lhsValue, String lhsType, LinkedList<ObjectValue> arrayVals, boolean isInner, String description) {
		super();
		this.lhsParent = lhsParent;
		this.lhsValue = lhsValue;
		this.lhsType = lhsType;
		this.arrayVals = arrayVals;
		this.isInnerHTML = isInner;
		this.description = description;
	}
	
	// Deep clone of an object in the lhs stack
	public LHSStackObject deepClone(){
		LHSStackObject newob = new LHSStackObject();
		if(lhsParent != null)
			newob.setLhsParent(lhsParent.deepClone());
		if(lhsValue != null)
			newob.setLhsValue(lhsValue.deepClone());
		newob.setDescription(description);
		if(arrayVals != null)
			newob.setArrayVals((LinkedList<ObjectValue>)arrayVals.clone());
			
		newob.setLhsType(lhsType);
		newob.setInnerHTML(isInnerHTML);
		return newob;
	}

	/**
	 * @return the lhsParent
	 */
	public Location getLhsParent() {
		return lhsParent;
	}

	/**
	 * @param lhsParent the lhsParent to set
	 */
	public void setLhsParent(Location lhsParent) {
		this.lhsParent = lhsParent;
	}

	/**
	 * @return the lhsValue
	 */
	public ObjectValue getLhsValue() {
		return lhsValue;
	}

	/**
	 * @param lhsValue the lhsValue to set
	 */
	public void setLhsValue(ObjectValue lhsValue) {
		this.lhsValue = lhsValue;
	}

	/**
	 * @return the lhsType
	 */
	public String getLhsType() {
		return lhsType;
	}

	/**
	 * @param lhsType the lhsType to set
	 */
	public void setLhsType(String lhsType) {
		this.lhsType = lhsType;
	}

	/**
	 * @return the arrayVals
	 */
	public LinkedList<ObjectValue> getArrayVals() {
		return arrayVals;
	}

	/**
	 * @param arrayVals the arrayVals to set
	 */
	public void setArrayVals(LinkedList<ObjectValue> arrayVals) {
		this.arrayVals = arrayVals;
	}
	
	

	/**
	 * @return the isInnerHTML
	 */
	public boolean isInnerHTML() {
		return isInnerHTML;
	}

	/**
	 * @param isInnerHTML the isInnerHTML to set
	 */
	public void setInnerHTML(boolean isInnerHTML) {
		this.isInnerHTML = isInnerHTML;
	}
	
	

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
