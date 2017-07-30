package com.tutorial.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Boss1_Enemy extends GameObject {

	private Handler handler;
	private Random r = new Random();
	
	public Boss1_Enemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		vX = r.nextInt(20);
		vY = 3;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	public void tick() {
		x += vX;
		y += vY;
		
		// move these two lines of code up to remove
		// the "bouncy" effect the player has when reaches
		// the border
		
		// remove the enemy if it reaches the bottom and then set the vY of Boss1 to 3
		if (y <= 0 || y >= Game.HEIGHT - 56) {
		    GameObject boss1_enemy_temp = null;
		    GameObject boss1_temp = null;
		    for (int i = 0; i < handler.object.size(); i++) {
				if (handler.object.get(i).getID() == ID.Boss1_Enemy) boss1_enemy_temp = handler.object.get(i);
				if (handler.object.get(i).getID() == ID.Boss1) boss1_temp = handler.object.get(i);
			}
		    handler.removeObject(boss1_enemy_temp);
		    boss1_temp.setVY(3);
		}
		
		if (x <= 0 || x >= Game.WIDTH - 20) vX *= -1;
		
		// Add trail object
		handler.addObject(new Trail((int)x, (int)y, 16, 16, Color.red, (float) 0.04, ID.Trail, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}
	
}
