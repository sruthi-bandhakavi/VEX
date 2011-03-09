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
 * The Heap data-structure that holds the JavaScript heap. Our implementation can have multiple heaps per 
 * program point.
 */
public class ObjectValue{
	
	// value could be a String, location, function value(String), or a security type
	String objValue;
	
	// value could also be a boolean
	boolean boolObjVal = false;
	
	// value could be a number
	int numObjVal;
	
	public ObjectValue(){
		super();
	}

	public ObjectValue(String objValue) {
		super();
		this.objValue = objValue;
	}
	
	public ObjectValue(boolean objValue) {
		super();
		this.boolObjVal = objValue;
	}
	
	public ObjectValue(int objValue) {
		super();
		this.numObjVal = objValue;
	}

	/**
	 * @return the objValue
	 */
	public String getObjValue() {
		return objValue;
	}

	/**
	 * @param objValue the objValue to set
	 */
	public void setObjValue(String objValue) {
		this.objValue = objValue;
	}
	
	

	/**
	 * @return the boolObjVal
	 */
	public boolean isBoolObjVal() {
		return boolObjVal;
	}

	/**
	 * @param boolObjVal the boolObjVal to set
	 */
	public void setBoolObjVal(boolean boolObjVal) {
		this.boolObjVal = boolObjVal;
	}

	/**
	 * @return the numObjVal
	 */
	public int getNumObjVal() {
		return numObjVal;
	}

	/**
	 * @param numObjVal the numObjVal to set
	 */
	public void setNumObjVal(int numObjVal) {
		this.numObjVal = numObjVal;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((objValue == null) ? 0 : objValue.hashCode());
		return result;
	}

	/**
	 * To check the truth value quickly
	 * @return
	 */
	public boolean isTrue(){	
		return boolObjVal;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjectValue other = (ObjectValue) obj;
		if (objValue == null) {
			if (other.objValue != null)
				return false;
		} else if (!objValue.equals(other.objValue))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ObjectValue [objValue=" + objValue + ":" + boolObjVal + "]";
	}
	
	/**
	 * A deepclone method for the object value. 
	 * The subclasses override this method.
	 * @return
	 */
	public ObjectValue deepClone(){
		if(this instanceof Location){
			return ((Location)this).deepClone();
		}
		if(this instanceof SecurityType){
			return ((SecurityType)this).deepClone();
		}
		if(this instanceof FunctionValue){
			return ((FunctionValue)this).deepClone();
		}
		
		ObjectValue ov = new ObjectValue();
		if(objValue != null){
			ov.setObjValue(objValue);
		}
		ov.setBoolObjVal(this.isBoolObjVal());
		ov.setNumObjVal(this.getNumObjVal());
		return ov;
	}
}
