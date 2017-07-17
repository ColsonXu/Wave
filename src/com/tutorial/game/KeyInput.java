package com.tutorial.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	// private Boolean[] keyDown = new Boolean[4];
	private int xp, xm, yp, ym; // xm stands for x minus and xp stands for x plus etc.
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
		// keyDown[0] = false;
		// keyDown[1] = false;
		// keyDown[2] = false;
		// keyDown[3] = false;
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
				if (key == KeyEvent.VK_W) ym = 10; // { tempObject.setVY(-8); keyDown[1] = true; }
				if (key == KeyEvent.VK_S) yp = 10; // { tempObject.setVY(8); keyDown[1] = true; }
				if (key == KeyEvent.VK_A) xm = 10; // { tempObject.setVX(-8); keyDown[2] = true; }
				if (key == KeyEvent.VK_D) xp = 10; // { tempOdbject.setVX(8); keyDown[3] = true; }
				
				tempObject.setVX(xp - xm);
                tempObject.setVY(yp - ym);
				
			}
		}
	}
	
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.Player) {
				
				
				// Key events for Player1
				if (key == KeyEvent.VK_W) ym = 0; // keyDown[0] = false; // tempObject.setVY(0);
				if (key == KeyEvent.VK_S) yp = 0; // keyDown[1] = false; // tempObject.setVY(0);
				if (key == KeyEvent.VK_A) xm = 0; // keyDown[2] = false; // tempObject.setVX(0);
				if (key == KeyEvent.VK_D) xp = 0; // keyDown[3] = false; // tempObject.setVX(0);
				
				tempObject.setVX(xp - xm);
                tempObject.setVY(yp - ym);
				
				/* 
				 * If we only control the movement by setting the velocity to 0 once a key is released,
				 * the player is going to stop responding to a key corresponding to the movement in the
				 * same axis. i.e. press left and right the same time and then release the right button.
				 * The player is not going to move to the left because the horizontal velocity is already
				 * been set to 0.
				 * 
				 * Instead, we use an array of boolean values to determine if the keys have been pressed.
				 * If both keys in the same axis is not pressed, then we set the velocity to 0.
				 */
				
				
				// Vertical movement	
				// if (!keyDown[0] && !keyDown[1]) tempObject.setVY(0);
				// Horizontal movement
				// if (!keyDown[2] && !keyDown[3]) tempObject.setVX(0);
				
				
				/*
				 * After adopting the new method to resolve the "Sticky Keys" problem.
				 * I found out that this new method has its own issue. If the player pressed
				 * one key in a certain axis, and then pressed another key in the same axis.
				 * The player is going to move to the direction corresponding to the key
				 * pressed last. However, if the player releases the second button and still
				 * hold down the first, the player will still move along the same direction.
				 */
				
				/*
				 * The third method is to store the velocity value in a variable and then
				 * assign it to the player. This eliminates the problem with the other two
				 * methods but the player will stay still is both keys in the same axis are
				 * pressed.
				 */
			}
		}
	}

}
