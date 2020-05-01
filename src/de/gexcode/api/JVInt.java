package de.gexcode.api;

import java.awt.Color;
import java.awt.Graphics2D;

public class JVInt {
	
	private int value = 0;
	private int id = 0;
	private int width;
	private int height;
	private int x;
	private int y;
	
	public JVInt(int value,int id,int width, int height) {
		this.value = value;
		this.id = id;
		this.width = width;
		this.height = height*value;
		this.x = width*id;
		this.y = Screen.Height-(this.height);
	}
	
	public void render(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
		g2d.fillRect(x, y, width, height);
		
	}
	
	public void setValue(int value) {
		this.value = value;
		this.height = height*value;
		this.y = Screen.Height-(this.height);
		
	}
	
	public int getValue() {
		return value;
	}
	
	public int getID() {
		return id;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setID(int id) {
		this.id = id;
		this.x = width*id;
	}
	
	public static String toString(JVInt[] array) {
		String ergebnis = "[";
		for(int i = 0; i < array.length; i++) {
			if(i == 0) {
				try {
				ergebnis += array[i].getValue();
				}catch(NullPointerException e) {
					ergebnis += "null";
				}
			}else {
				try {
				ergebnis += ","+array[i].getValue();
				}catch(NullPointerException e) {
					ergebnis += ",null";
				}
			}
		}
		ergebnis += "]";
		return ergebnis;
	}
	
	public static JVInt[][] split(JVInt[] array,int index){
		JVInt[][] ergebnis = new JVInt[2][];
		JVInt[] left = new JVInt[index];
		JVInt[] right = new JVInt[array.length-index];
		for(int i = 0; i < array.length; i++) {
			if(i < index) {
				left[i] = array[i];
			}else {
				right[ (i-index) ] = array[i];
			}
		}
		ergebnis[0] = left;
		ergebnis[1] = right;
		return ergebnis;
	}
}
