package com.tutorial.game;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private double scoreKeep = 0;
	private Random r = new Random();
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		scoreKeep += 0.2;
		
		if (scoreKeep >= 200.0) {
			hud.setLevel(hud.getLevel() + 1);
			scoreKeep = 0;
			
			if (hud.getLevel() == 2) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 30), r.nextInt(Game.HEIGHT - 30), ID.basicEnemy, handler));
			}
		}
	}
	
}
