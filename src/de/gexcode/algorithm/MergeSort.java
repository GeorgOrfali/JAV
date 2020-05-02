package de.gexcode.algorithm;

import de.gexcode.api.Algorithm;
import de.gexcode.api.JVArray;

public class MergeSort extends Algorithm<JVArray> {
	
	JVArray data;

	public MergeSort(String name, JVArray data) {
		super(name, data);
		this.data = data;
	}

	@Override
	public void algorithm() {
		data.setArray(mergesort(data));
		
	}
	
	public JVArray mergesort(JVArray array) {
		if(array.size() > 1) {
			JVArray[] split = array.split( (array.size()/2 ));
			JVArray left = split[0];
			JVArray right = split[1];
			left = mergesort(left);
			right = mergesort(right);
			return merge(left,right);
		}else {
			return array;
		}
	}

	public JVArray merge(JVArray left, JVArray right) {
		JVArray array = new JVArray(left.size()+right.size());
		int indexLeft = 0;
		int indexRight = 0;
		
		while(indexLeft < left.size() && indexRight < right.size()) {
			if(left.getValue(indexLeft) <= right.getValue(indexRight)) {
				array.add(left.get(indexLeft));
				indexLeft++;
			}else {
				array.add(right.get(indexRight));
				indexRight++;
			}
		}
		
		while(indexLeft < left.size()) {
			array.add(left.get(indexLeft));
			indexLeft++;
		}
		
		while(indexRight < right.size()) {
			array.add(right.get(indexRight));
			indexRight++;
		}
		
		return array;
	}

}
