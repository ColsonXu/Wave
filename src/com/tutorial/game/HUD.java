package com.tutorial.game;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	public static int HEALTH = 100;
	private int greenValue = 255;
	
	public void tick() {
		HEALTH = Game.clamp(HEALTH, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);
		greenValue = HEALTH * 2;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(30, 30, 300, 16);
		g.setColor(new Color(100, greenValue, 0));
		g.fillRect(30, 30, HEALTH * 3, 16);
		g.setColor(Color.white);
		g.drawRect(30, 30, 300, 16);
	}
	
}
