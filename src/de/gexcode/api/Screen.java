package de.gexcode.api;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Screen extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	private Thread mainThread;
	private boolean running = false;
	private JFrame window;
	public static int Height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static int Width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private MainScreen mainScreen;
	
	public Screen() {
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		InitializeWindow();
		//Initializing MainScreen
		mainScreen = new MainScreen();
	}

	@Override
	public void run() {
		while(running) {
			Graphics2D g = (Graphics2D) getGraphics();
			render(g);
			g.dispose();
		}
	}
	
	public synchronized void start() {
		mainThread = new Thread(this);
		mainThread.start();
		running = true;
	}
	
	public void render(Graphics2D g) {
		mainScreen.render(g);
	}
	
	public void update() {
		
	}
	
	public void InitializeWindow() {
		window = new JFrame("Algorithm Visualizer");
		window.setResizable(false);
		window.add(this);
		window.pack();
		window.setDefaultCloseOperation(3);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}
