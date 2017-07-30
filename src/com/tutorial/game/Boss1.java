package com.tutorial.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Boss1 extends GameObject {

	private Handler handler;
	int spawn = 20;
	
	public Boss1(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		vX = 5;
		vY = 0;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 128, 128);
	}
	
	public void tick() {
		x += vX;
		y += vY;
		
		// move these two lines of code up to remove
		// the "bouncy" effect the player has when reaches
		// the border
		if (y <= 0 || y >= Game.HEIGHT - 56) {
		    GameObject boss1_temp = null;
		    for (int i = 0; i < handler.object.size(); i++) {
		    	if (handler.object.get(i).getID() == ID.Boss1) boss1_temp = handler.object.get(i);
			}
		    handler.removeObject(boss1_temp);
		}
		if (x <= 0 || x >= Game.WIDTH - 120) vX *= -1;
		
		// Add trail object
		handler.addObject(new Trail((int)x, (int)y, 128, 128, Color.magenta, (float) 0.08, ID.Trail, handler));
		
		// Spawn enemies
		GameObject boss1_temp = null;
		
		for (int i = 0; i < handler.object.size(); i++) {
			if (handler.object.get(i).getID() == ID.Boss1) boss1_temp = handler.object.get(i);
		}
		
		if (spawn >= 0) {
			handler.addObject(new Boss1_Enemy((int) boss1_temp.getX(), 100, ID.Boss1_Enemy, handler));
			spawn--;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.magenta);
		g.fillRect((int)x, (int)y, 128, 128);
	}
	
}
