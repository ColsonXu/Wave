package com.tutorial.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		// Escape key to exit the game.
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
		
		// Debugging line: System.out.println(key);
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.Player) {
				
				// Key events for Player1
				if (key == KeyEvent.VK_W) tempObject.setVY(-8);
				if (key == KeyEvent.VK_S) tempObject.setVY(8);
				if (key == KeyEvent.VK_A) tempObject.setVX(-8);
				if (key == KeyEvent.VK_D) tempObject.setVX(8);
				
			}
		}
	}
	
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.Player) {
				
				// Key events for Player1
				if (key == KeyEvent.VK_W) tempObject.setVY(0);
				if (key == KeyEvent.VK_S) tempObject.setVY(0);
				if (key == KeyEvent.VK_A) tempObject.setVX(0);
				if (key == KeyEvent.VK_D) tempObject.setVX(0);
				
			}
		}
	}

}
