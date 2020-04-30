package de.gexcode.api;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class MainScreen {
	
	public static ArrayList<Algorithm> algorithmlist = new ArrayList<Algorithm>();
	public static int id = 0;
	public static int main = -1;
	public MainScreen() {
		
	}
	
	public void render(Graphics2D g2d) {
		//draw List of Algorithm
		for(int i = 0; i < algorithmlist.size(); i++) {
			algorithmlist.get(i).getButton().renderMainScreen(g2d);	
		}
	}

	public void update() {
		for(int i = 0; i < algorithmlist.size(); i++) {
			if(Mouse.isButtonClicked(algorithmlist.get(i).getButton()) != -1 ) {
				System.out.println("ID: "+ algorithmlist.get(i).getButton().getID());
				main = algorithmlist.get(i).getButton().getID();
				break;
			}
		}
	}
}
