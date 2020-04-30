package de.gexcode.api;

import java.awt.Color;
import java.awt.Graphics2D;

public class MainScreen {
	
	public MainScreen() {
		
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.decode("#4a4a4a"));
		g.fillRect(0, 0, Screen.Width, Screen.Height);
	}
}
