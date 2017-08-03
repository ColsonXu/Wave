package com.tutorial.game;


import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Created by found on 10-Jul-17.
 */
public class Handler {

    ArrayList<GameObject> object = new ArrayList<GameObject>();

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }
    
    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
    
    public void clearEnemy() {
    	GameObject tmp = null;
    	for (int i = 0; i <= this.object.size() - 1; i++) {
    		if (this.object.get(i).getID() != ID.Player) tmp = this.object.get(i);
    		this.removeObject(tmp);
    	}
    }

}
