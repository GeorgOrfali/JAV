package de.gexcode.api;

import java.util.ArrayList;

public class JVArray {
	
	private ArrayList<JVInt> array;
	private int to = 0;
	public int length;

	public JVArray(int max) {
		this.length = max;
		array = new ArrayList<JVInt>();
	}
	
	public void clearArray() {
		array = new ArrayList<JVInt>();
	}
	
	public void setArray(JVArray neu) {
		clearArray();
		array = neu.getArray();
	}
	
	public ArrayList<JVInt> getArray(){
		return array;
	}
	
	public void generateValue(int from,int to) {
		this.to = to;
		int height = Screen.Height/(to*2);
		int width = Screen.Width/(length);
			if(from > 0) {
				for(int i = 0; i < length; i++) {
					array.add(new JVInt( (int) ((Math.random() * ((to - from) + 1)) + from),i , width, height ));
				}
				
			}else {
				System.out.println("from value must be greater than 0");
			}
	}
	
	public int getTo() {
		return to;
	}
	
	public int getValue(int index) {
		return array.get(index).getValue();
	}
	
	public int size() {
		return array.size();
	}
	
	public JVInt get(int index) {
		return array.get(index);
	}
	
	public void add(int index,JVInt number) {
		number.setID(index);
		array.add(index, number);
	}
	
	public void add(JVInt number) {
		number.setID(size());
		array.add(number);
	}
	
	public void swap(int i1 , int i2) {
		JVInt a1 = array.get(i1);
		JVInt a2 = array.get(i2);
		array.remove(i1);
		add(i1, a2);
		array.remove(i2);
		add(i2, a1);
	}
	
	public JVArray[] split(int index){
		JVArray[] ergebnis = new JVArray[2];
		JVArray left = new JVArray(index);
		JVArray right = new JVArray(array.size()-index);
		for(int i = 0; i < array.size(); i++) {
			if(i < index) {
				left.add(i, array.get(i));
			}else {
				right.add((i-index), array.get(i));
			}
		}
		ergebnis[0] = left;
		ergebnis[1] = right;
		return ergebnis;
	}
	
	@Override
	public String toString() {
		String ergebnis = "[";
		for(int i = 0; i < array.size(); i++) {
			if(i == 0) {
				ergebnis += getValue(i);
			}else {
				ergebnis += ","+getValue(i);
			}
		}
		ergebnis += "]";
		return ergebnis;
	}
}
