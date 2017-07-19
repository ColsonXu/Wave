package com.tutorial.game;

import java.awt.*;

/**
 * Created by found on 10-Jul-17.
 */
public class Player extends GameObject {

	Handler handler;
	
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        
        vX = 0;
        vY = 0;
    }
    
    public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
    }

    public void tick() {
    	x = Game.clamp(x, 8, Game.WIDTH - 47);
    	y = Game.clamp(y, 8, Game.HEIGHT - 80);
    	
    	x += vX;
        y += vY;
        
        collision();
        
        handler.addObject(new Trail((int)x, (int)y, 32, 32, Color.white, (float) 0.09, ID.Trail, handler));
        
        GameObject player_temp = null;
        
        for (int i = 0; i < handler.object.size(); i++) {
            if (handler.object.get(i).getID() == ID.Player) player_temp = handler.object.get(i);
        }
        if (HUD.HEALTH <= 0) handler.removeObject(player_temp);
        
    }
    
    public void collision() {
    	
    	for (int i = 0; i < handler.object.size(); i++) {
    		GameObject tempObject = handler.object.get(i);
    		if (tempObject.getID() == ID.basicEnemy || tempObject.getID() == ID.fastEnemy || tempObject.getID() == ID.smartEnemy) {
    			// collision detection
    			if (getBounds().intersects(tempObject.getBounds())) {
    				HUD.HEALTH -= 2;
    			}
    		}
    	}
    	
    }

    public void render(Graphics g) {
    	if(id == ID.Player) g.setColor(Color.white);
    	g.fillRect((int)x, (int)y, 32, 32);
    }

}
