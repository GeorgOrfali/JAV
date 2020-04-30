package de.gexcode.api;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import de.gexcode.algorithm.AddAlgorithm;

public class Screen extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	private Thread mainThread;
	private boolean running = false;
	private JFrame window;
	public static int Height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static int Width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private MainScreen mainScreen;
	private Mouse m;
	
	public Screen() {
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		InitializeWindow();
		//Initializing MainScreen
		mainScreen = new MainScreen();
		new AddAlgorithm();
        m = new Mouse();
        addMouseListener(m);
        addMouseMotionListener(m);
	}

	@Override
	public void run() {
        long lastTime = System.nanoTime();
        final double amountOfTicks = 120.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();

        while (running) {
           long now = System.nanoTime();
           delta += (now - lastTime) / ns;
           lastTime = now;
           if (delta >= 1) {
              update();
              delta--;
           }
           render();

           if (System.currentTimeMillis() - timer > 1000) {
              timer += 1000;
           }
        }
	}
	
	public synchronized void start() {
		mainThread = new Thread(this);
		mainThread.start();
		running = true;
	}
	
    public synchronized void stop() {
        running = false;
        try {
            this.mainThread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.decode("#4a4a4a"));
        g2d.fillRect(0, 0, Width, Height);
		if(MainScreen.main > -1) {
			MainScreen.algorithmlist.get(MainScreen.main).render(g2d);
			
		}else {
        mainScreen.render(g2d);
		}
        g2d.dispose();
        bs.show();
	}
	
	public void update() {
		if(MainScreen.main > -1) {
			MainScreen.algorithmlist.get(MainScreen.main).update();
			
		}else {
		mainScreen.update();
		}
	}
	
	public void InitializeWindow() {
		window = new JFrame("Algorithm Visualizer");
		window.setResizable(false);
		window.add(this);
		window.pack();
        window.createBufferStrategy(2);
		window.setDefaultCloseOperation(3);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}
