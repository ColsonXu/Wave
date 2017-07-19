package com.tutorial.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject {

	private Handler handler;
	
	public FastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		vX = 10;
		vY = 10;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 8, 8);
	}
	
	public void tick() {
		x += vX;
		y += vY;
		
		// move these two lines of code up to remove
		// the "bouncy" effect the player has when reaches
		// the border
		if (y <= 0 || y >= Game.HEIGHT - 56) vY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 20) vX *= -1;
		
		// Add trail object
		handler.addObject(new Trail((int)x, (int)y, 8, 8, Color.CYAN, (float) 0.04, ID.Trail, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect((int)x, (int)y, 8, 8);
	}
	
}
