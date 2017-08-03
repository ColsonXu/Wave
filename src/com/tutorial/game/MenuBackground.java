package com.tutorial.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuBackground extends GameObject {

	private Handler handler;
	private Random r = new Random();
	
	private Color color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	
	
	public MenuBackground(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		int dir = r.nextInt(4);
		
		if (dir == 0) {
			vX = 10;
			vY = 10;
		} else if (dir == 1) {
			vX = -10;
			vY = -10;
		} else if (dir == 2) {
			vX = 10;
			vY = -10;
		} else if (dir == 3) {
			vX = -10;
			vY = 10;
		}
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
		handler.addObject(new Trail((int)x, (int)y, 8, 8, color, (float) 0.04, ID.Trail, handler));
	}
	
	
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect((int)x, (int)y, 8, 8);
	}
	
}
