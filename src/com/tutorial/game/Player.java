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

        vX = r.nextInt(5) + 1;
        vY = r.nextInt(5) + 1;

    }

    public void tick() {
        x += vX;
        y += vY;
    }

    public void render(Graphics g) {
       g.setColor(Color.white);
       g.fillRect(x, y, 32, 32);
    }

}
