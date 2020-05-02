package de.gexcode.algorithm;

import de.gexcode.api.JVArray;
import de.gexcode.api.JVInt;

public class AddAlgorithm {
	
	public AddAlgorithm() {
		JVArray data = new JVArray(1900);
		data.generateValue(10, 100);
		new BubbleSort("BubbleSort", data);
		new MergeSort("MergeSort", data);
	}

}
