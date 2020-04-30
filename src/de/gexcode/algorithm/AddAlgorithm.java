package de.gexcode.algorithm;

import de.gexcode.api.JVArray;

public class AddAlgorithm {
	
	public AddAlgorithm() {
		JVArray data = new JVArray(100);
		data.generateValue(10, 100);
		new BubbleSort("BubbleSort", data);
	}

}
