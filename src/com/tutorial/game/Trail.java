package com.tutorial.game;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{

	public float alpha = 1;
	private Handler handler;
	private Color trailColor;
	private int width, height;
	private float life;
	
	public Trail(int x, int y, int width, int height, Color color, float life, ID id, Handler handler) {
		super(x, y, id);
		this.width = width;
		this.height = height;
		trailColor = color;
		this.life = life;
		this.handler = handler;
	}
	
	public void tick() {
		if (alpha > life) {
			alpha -= life - 0.001;
		} else {
			handler.removeObject(this);
		}
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(trailColor);
		g.fillRect((int)x, (int)y, width, height);
		g2d.setComposite(makeTransparent(1));
	}
	
	public AlphaComposite makeTransparent(float Alpha) {
		int type = AlphaComposite.SRC_OVER;
		return AlphaComposite.getInstance(type, Alpha);
	}
	
	public Rectangle getBounds() {
		return null;
	}
	
}
