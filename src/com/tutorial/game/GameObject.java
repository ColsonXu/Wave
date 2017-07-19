package com.tutorial.game;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Created by found on 10-Jul-17.
 */
public abstract class GameObject {

    protected float x, y;
    protected ID id;
    protected float vX, vY;

    public GameObject(float x, float y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public void setID(ID id) {
        this.id = id;
    }
    public ID getID() {
        return id;
    }
    public void setVX(float vX) {
        this.vX = vX;
    }
    public float getVX() {
        return vX;
    }
    public void setVY(float vY) {
        this.vY = vY;
    }
    public float getVY() {
        return vY;
    }

}
