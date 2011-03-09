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

public class NativeObjects {
	public static final String Undef = "&Undefined";
	public static final String Null = "&Null";
	
	// TODO: Initialize native objects and prototype
	public static Location ObjectProt = null;
	public static Location FunctionProt = null;
	public static Location ArrayProt = null;
	public static final Location Undefined = new Location(NativeObjects.Undef);
	
	
	
}
