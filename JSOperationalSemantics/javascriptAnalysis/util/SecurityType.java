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
import java.util.Arrays;
import java.util.HashSet;

/**
 * The SecurityType Class holds the security type of an object. The object could represent a primitive value 
 * or an object in the JavaScript program.
 * @author sruthi
 *
 */
public class SecurityType extends ObjectValue{
	public static final int high = 1;
	public static final int low = 0;
	
	int securityType;
	
	static HashMap<String,SecurityType> typeStore = new HashMap<String,SecurityType>();
	/**
	 *  Constructors
	 */
	
	public SecurityType(int type, String objValue) {
		super(objValue);
		securityType = type;
	}
	
	public static SecurityType createSecurityType(int type, String objValue){
		if(objValue == null){
			SecurityType st = SecurityType.typeStore.get("@high");
			if(st == null){
				st = new SecurityType(type,objValue);
				SecurityType.typeStore.put("@high", st);
			}
			return st;
		}else{
			SecurityType st = SecurityType.typeStore.get(objValue);
			if(st == null){
				st = new SecurityType(type,objValue);
				SecurityType.typeStore.put(objValue, st);
			}
			return st;
		}
	}
	
	/*public SecurityType(int type, String objValue, HashSet<String> typeList) {
		super(objValue);
		sourceNames = typeList;
		securityType = type;
	}*/
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[SecurityType : " + securityType + " from : " + objValue +"]";
	}
	
	
	
	
	/**
	 * @return the sourceNames
	 */
	/*private HashSet<String> getSourceNames() {
		return sourceNames;
	}*/

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + securityType;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SecurityType other = (SecurityType) obj;
		// Compare security types
		if (securityType != other.securityType)
			return false;
		// Finally compare the comma separated object values
		return compareObjVals(other);
	}

	/**
	 * @param sourceNames the sourceNames to set
	 */
	/*private void setSourceNames(HashSet<String> sourceNames) {
		this.sourceNames = sourceNames;
	}*/

	/*
	 * (non-Javadoc)
	 * @see javascriptAnalysis.util.ObjectValue#deepClone()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public SecurityType deepClone(){
		SecurityType st;
		if(this.getObjValue() != null){
			st = createSecurityType(this.getSecurityType(),this.getObjValue());
		}else{
			st = createSecurityType(this.getSecurityType(),"Unknown obj");
		}
		return st;
	}
	
	
	
	/**
	 * @return the securityType
	 */
	private int getSecurityType() {
		return securityType;
	}

	/**
	 * @param securityType the securityType to set
	 */
	private void setSecurityType(int securityType) {
		this.securityType = securityType;
	}

	/**
	 * The security lattice defined as low \leq high
	 * Join relation
	 * @param rhs
	 * @return
	 */
	public SecurityType join(SecurityType rhs){
		SecurityType newType = SecurityType.createSecurityType(SecurityType.high,null);
		if(!rhs.isTainted() && !this.isTainted()){
			return newType;
		}else{
			if(this.getObjValue() != null){
				if(rhs.getObjValue() != null){
					// Lhs source names
					HashSet<String> this_sourceNames = new HashSet<String>();
					String[] names = this.getObjValue().split(",");
					this_sourceNames.addAll(Arrays.asList(names));
					
					// Rhs source names
					HashSet<String> rhs_sourceNames = new HashSet<String>();
					names = rhs.getObjValue().split(",");
					rhs_sourceNames.addAll(Arrays.asList(names));
					
					
					if(this_sourceNames.containsAll(rhs_sourceNames))
						return this;
					else{
						if(rhs_sourceNames.containsAll(this_sourceNames)){
							return rhs;
						}else{
							this_sourceNames.addAll(rhs_sourceNames);
							String obj_val = new String();
							for(String st : this_sourceNames){
								obj_val = obj_val + "," + st;
							}
							return SecurityType.createSecurityType(SecurityType.low, obj_val);
						}
					}
				}else{
					return this;
				}
			}else{
				return rhs;
			}
			
		}
		
		/*if(!rhs.isTainted() && !this.isTainted()){
			this.setSecurityType(SecurityType.high);
			this.setObjValue(null);
		}else{
			if(this.getObjValue() != null){
				if(rhs.getObjValue() != null){
					this.setObjValue(new String(this.objValue +"," + rhs.getObjValue()));
				}
			}else{
				this.setObjValue(new String(rhs.getObjValue()));
			}
			this.setSecurityType(SecurityType.low);
		}*/
		
	}
	
	public boolean compareObjVals(SecurityType rhs){
		
		if(this.getObjValue() == null && rhs.getObjValue() == null)
			return true;
		
		if((this.getObjValue() == null && rhs.getObjValue() != null) || (this.getObjValue() != null && rhs.getObjValue() == null))
			return false;
		
		
		// Lhs source names
		HashSet<String> this_sourceNames = new HashSet<String>();
		String[] names = this.getObjValue().split(",");
		this_sourceNames.addAll(Arrays.asList(names));
		
		// Rhs source names
		HashSet<String> rhs_sourceNames = new HashSet<String>();
		names = rhs.getObjValue().split(",");
		rhs_sourceNames.addAll(Arrays.asList(names));
		
		return (this_sourceNames.containsAll(rhs_sourceNames) && rhs_sourceNames.containsAll(this_sourceNames));
	}
	
	
	public boolean isTainted(){
		if(securityType == SecurityType.low)
			return true;
		else
			return false;
	}

}
