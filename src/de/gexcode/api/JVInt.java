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
				ergebnis += array[i].getValue()+ " id: "+array[i].getID() +" x: "+array[i].getX()+" y: "+array[i].getX() + " width: "+ array[i].getWidth() + " height: "+ array[i].getHeight();
			}else {
				ergebnis += ","+array[i].getValue()+ " id: "+array[i].getID() +" x: "+array[i].getX()+" y: "+array[i].getX() + " width: "+ array[i].getWidth() + " height: "+ array[i].getHeight();
			}
		}
		ergebnis += "]";
		return ergebnis;
	}
}
