package de.gexcode.api;

public class JVArray {
	
	private JVInt[] array;
	private int to = 0;
	private int max;

	public JVArray(int max) {
		array = new JVInt[max];
		this.max = max;
		System.out.println("Max: "+max);
	}
	
	public void generateValue(int from,int to) {
		this.to = to;
		int height = Screen.Height/(to*2);
		int width = Screen.Width/(max);
			if(from > 0) {
				for(int i = 0; i < array.length; i++) {
					array[i] = new JVInt( (int) ((Math.random() * ((to - from) + 1)) + from),i , width, height );
				}
				
			}else {
				System.out.println("from value must be greater than 0");
			}
	}
	
	public int getTo() {
		return to;
	}
	
	public JVInt[] getArray() {
		return array;
	}
	public void swap(int i1 , int i2) {
		JVInt a1 = array[i1];
		JVInt a2 = array[i2];
		int a1ID = array[i1].getID();
		int a2ID = array[i2].getID();
		int a1Value = array[i1].getValue();
		int a2Value = array[i2].getValue();
		array[i1].setID(a2ID);
		array[i2].setID(a1ID);
		array[i1] = a2;
		array[i2] = a1;
		//array[i1].setValue(a2Value);
		//array[i2].setValue(a1Value);
	}

}
