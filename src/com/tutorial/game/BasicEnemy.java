package com.tutorial.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {

	private Handler handler;
	
	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		vX = 5;
		vY = 5;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
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
		handler.addObject(new Trail(x, y, 16, 16, Color.red, (float) 0.04, ID.Trail, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}
	
}
