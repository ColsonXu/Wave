package com.tutorial.game;

import java.awt.*;

/**
 * Created by found on 10-Jul-17.
 */
public abstract class GameObject {

    protected int x, y;
    protected ID id;
    protected int vX, vY;

    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setID(ID id) {
        this.id = id;
    }
    public ID getID() {
        return id;
    }
    public void setVX(int vX) {
        this.vX = vX;
    }
    public int getVX() {
        return vX;
    }
    public void setVY(int vY) {
        this.vY = vY;
    }
    public int getVY() {
        return vY;
    }

}
