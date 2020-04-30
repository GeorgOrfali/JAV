package de.gexcode.api;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener,MouseMotionListener{
    private static int mouseX = -1;
    private static int mouseY = -1;
    public static int mouseB = -1;

    public static int getX() {
        return mouseX;
    }

    public static int getY() {
        return mouseY;
    }

    public static int getButton() {
        return mouseB;
    }
    
    public static int isButtonClicked(Button b) {
    	int ergebnis = -1;
    	if(Mouse.getButton() == 1) {
    		if(getX() >= b.getX() && getX() <= (b.getX()+b.getWidth()) && getY() >= b.getY() && getY() <= (b.getY()+b.getHeight())) {
    			ergebnis = b.getID();
    			Mouse.mouseB = -1;
    		}else {
    			
    		}
    	}else {
    		
    	}
    	Mouse.mouseB = -1;
    	return ergebnis;
    }
    public static boolean isButtonClickedB(Button b) {
    	boolean ergebnis = false;
    	if(Mouse.getButton() == 1) {
    		if(getX() >= b.getX() && getX() <= (b.getX()+b.getWidth()) && getY() >= b.getY() && getY() <= (b.getY()+b.getHeight())) {
    			ergebnis = true;
    			Mouse.mouseB = -1;
    			return true;
    		}else {
    			
    		}
    	}else {
    		
    	}
    	return ergebnis;
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseB = -1;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseB = e.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseB = -1;
    }

}
