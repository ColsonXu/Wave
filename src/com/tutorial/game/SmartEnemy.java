package com.tutorial.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {

	private Handler handler;
	private GameObject player;
	
	public SmartEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		for (int i = 0; i < handler.object.size(); i++) {
			if (handler.object.get(i).getID() == ID.Player) player = handler.object.get(i);
		}
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	public void tick() {
		x += vX;
		y += vY;
		
		// Calculate the distance between the SmartEnemy and the player
		float diffX = x - player.getX() - 16;
		float diffY = y - player.getY() - 16;
		float distance = (float)Math.sqrt(Math.pow(x - player.getX(), 2) + Math.pow(y - player.getY(), 2));
		
		vX = (float)(-3*diffX / distance);
		vY = (float)(-3*diffY / distance);
		
		// move these two lines of code up to remove
		// the "bouncy" effect the player has when reaches
		// the border
		if (y <= 0 || y >= Game.HEIGHT - 56) vY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 20) vX *= -1;
		
		// Add trail object
		handler.addObject(new Trail((int)x, (int)y, 16, 16, Color.green, (float) 0.04, ID.Trail, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int)x, (int)y, 16, 16);
	}
	
}
