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

import java.util.HashSet;
import java.util.LinkedList;

public class HeapSet {
	
	 HashSet<Heap> heaps;
	 
	 
	public HeapSet() {
		this.heaps = new HashSet<Heap>();
	}
	
	/**
	 * @return the heap
	 */
	public HashSet<Heap> getHeaps() {
		return heaps;
	}
	/**
	 * @param heap the heap to set
	 */
	public void setHeaps(HashSet<Heap> heaps) {
		this.heaps = heaps;
	}
	
	public void addElement(Heap hp){
		if(this.heaps == null)
			this.heaps = new HashSet<Heap>();
		
		this.heaps.add(hp);
	}
	
	public int size(){
		if(this.heaps == null)
			return 0;
		return this.heaps.size();
	}
	
	public Heap getMatchingHeap(Heap currentHeap){
		for(Heap heap:this.heaps){
			if(heap.isomorphic(currentHeap)){
				return heap;
			}
		}
		return null;
	}
}
