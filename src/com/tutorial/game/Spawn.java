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
		scoreKeep += 0.9;
		
		if (scoreKeep >= 200.0) {
			hud.setLevel(hud.getLevel() + 1);
			scoreKeep = 0;
			
			if (hud.getLevel() == 2) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 60), r.nextInt(Game.HEIGHT - 60), ID.basicEnemy, handler));
			} else if (hud.getLevel() == 3) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 60), r.nextInt(Game.HEIGHT - 60), ID.basicEnemy, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 60), r.nextInt(Game.HEIGHT - 60), ID.basicEnemy, handler));
			} else if (hud.getLevel() == 4) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 60), r.nextInt(Game.HEIGHT - 60), ID.fastEnemy, handler));
			} else if (hud.getLevel() == 5) {
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 60), r.nextInt(Game.HEIGHT - 60), ID.smartEnemy, handler));
			} else if (hud.getLevel() == 6) {
				handler.addObject(new Boss1(r.nextInt(Game.WIDTH - 120), 100, ID.Boss1, handler));
			}
		}
	}
	
}
