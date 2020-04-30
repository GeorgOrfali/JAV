package de.gexcode.api;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Button {
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;
	private String text = "";
	private Font textstyle;
	private int textsize = 0;
	private double textprozent = 0;
	private int id;
	
	public Button(int x, int y, int width, int height,String text,int id) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
		this.id = id;
		setFont("Arial", 0.5);
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
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Font getFont() {
		return textstyle;
	}
	
	public void setFont(String style,double sizeinprozent) {
		textprozent = sizeinprozent;
		textsize = (int) (((width+height)*0.13)*sizeinprozent);
		textstyle = new Font(style, textsize, textsize);
	}
	
	public int getTextX() {
		return (int) (x+(textsize*(1-textprozent)));
	}
	
	public int getTextY() {
		return (int) ((y+height)+(textsize*( -1.5)));
	}
	
	public int getID() {
		return id;
	}
	
	public void renderMainScreen(Graphics2D g) {
		g.setColor(Color.decode("#ffffff"));
		g.fillRect(x, y, width, height);
		g.setColor(Color.decode("#000000"));
		g.setFont(getFont());
		g.drawString(getText(), getTextX(), getTextY());
	}
}
