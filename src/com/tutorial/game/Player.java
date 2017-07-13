package com.tutorial.game;

import java.awt.*;
import java.util.Random;

/**
 * Created by found on 10-Jul-17.
 */
public class Player extends GameObject {

    Random r = new Random();

    public Player(int x, int y, ID id) {
        super(x, y, id);

        vX = 0;
        vY = 0;

    }

    public void tick() {
        x += vX;
        y += vY;
    }

    public void render(Graphics g) {
    	if(id == ID.Player) g.setColor(Color.white);
    	else if(id == ID.Player2) g.setColor(Color.blue);
    	g.fillRect(x, y, 32, 32);
    }

}
