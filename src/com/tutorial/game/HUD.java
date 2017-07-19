package com.tutorial.game;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static float HEALTH = 100;
	private int greenValue = 255;
	
	private double score = 0.0;
	private int level = 1;
	
	public void tick() {
		HEALTH = Game.clamp((float)HEALTH, 0, 100);
		greenValue = (int) Game.clamp((float)greenValue, 0, 255);
		greenValue = (int) (HEALTH * 2);
		score += 0.4;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(30, 30, 300, 16);
		g.setColor(new Color(100, greenValue, 0));
		g.fillRect(30, 30, (int)HEALTH * 3, 16);
		g.setColor(Color.white);
		g.drawRect(30, 30, 300, 16);
		
		g.drawString("Score: " + (int)score, 30, 60);
		g.drawString("level: " + level, 30, 70);
	}
	
	public void setScore(double score) {
		this.score = score;
	}
	
	public double getScore() {
		return score;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
	
}
