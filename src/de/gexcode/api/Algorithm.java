package de.gexcode.api;

import java.awt.Graphics2D;

public abstract class Algorithm<T> {
	
	private String name = "";
	private int spacingX = 0;
	private int spacingY = 0;
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;
	private Button b;
	private T data;
	private Button start;
	
	public Algorithm(String name, T data) {
		this.name = name;
		spacingX = (int) (Screen.Width*0.01);
		spacingY = (int) (Screen.Height*0.01);
		width = (int) ((Screen.Width*0.2)-spacingX);
		height = (int) ((Screen.Height*0.25)-spacingY);
		x = spacingX +((spacingX+width)*(MainScreen.id%5));
		y = spacingY +((spacingY+height)*(MainScreen.id/5));
		b = new Button(x,y,width,height,name,MainScreen.id);
		MainScreen.algorithmlist.add(this);
		MainScreen.id++;
		this.data = data;
		start = new Button(0,0,(int) (Screen.Width*0.1),(int) (Screen.Height*0.05), "Start",-1 );
	}
	
	public String getName() {
		return name;
	}
	
	public Button getButton() {
		return b;
	}

	public void render(Graphics2D g2d) {
		start.renderMainScreen(g2d);
		if(data instanceof JVArray) {
			for(int i = 0; i < ((JVArray) data).size(); i++) {
				((JVArray) data).get(i).render(g2d);
				//System.out.println("Index: "+i+" Value: "+ ((JVArray) data).getArray()[i].getValue());
			}
		}
	}

	public void update() {
		//algorithm();
		if(Mouse.isButtonClickedB(start)) {
			algorithm();
		}
	}
	
	public abstract void algorithm();
	
}
