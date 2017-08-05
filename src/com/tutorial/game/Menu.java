package com.tutorial.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.game.Game.STATE;

public class Menu extends MouseAdapter {
	
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}
	
	public void mousePressed(MouseEvent e) {
		int mX = e.getX();
		int mY = e.getY();
		
		if (game.gameState == STATE.Menu) {

			// Play Button
			if (mouseOver(mX, mY, 455, 340, 400, 130)) {
				game.gameState = STATE.Game;
				// Remove MenuBackground
				handler.clearEnemy();
				handler.clearEnemy();
				handler.clearEnemy();
				handler.clearEnemy();
				handler.clearEnemy();
				handler.clearEnemy();
				
				// Add Player and the first basicEnemy
				handler.addObject(new Player(630, 463, ID.Player, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 100), r.nextInt(Game.HEIGHT - 100), ID.basicEnemy, handler));
				
			}
			
			// Help Button
			
			if (mouseOver(mX, mY, 455, 500, 400, 130)) {
				game.gameState = STATE.Help;
			}
			
			// Quit Button
			if (mouseOver(mX, mY, 455, 660, 400, 130)) {
				System.exit(1);
			}
		}
		
		// Back button for Help menu
		if (game.gameState == STATE.Help) {
			if (mouseOver(mX, mY, 455, 660, 400, 130)) {
				game.gameState = STATE.Menu;
			}
		}
		
		if (game.gameState == STATE.End) {
			// Reset Button
			if (mouseOver(mX, mY, 455, 660, 400, 130)) {
				handler.object.clear();
				HUD.HEALTH = 100;
				hud.setLevel(1);
				hud.setScore(0);
				game.gameState = STATE.Menu;
				for (int i = 0; i <= 55; i++) {
	        		handler.addObject(new MenuBackground(r.nextInt(Game.WIDTH - 100), r.nextInt(Game.HEIGHT - 100), ID.MenuBackground, handler));
	        	}
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mX, int mY, int x, int y, int width, int height) {
		if (mX >= x && mX <= x + width && mY >= y && mY <= y + height) {
			return true;
		} else return false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		// Setup Font
		Font fnt = new Font("arial", 1, 100);
		Font fnt2 = new Font("arial", 1, 70);
		Font fnt_help = new Font("arial", 1, 40);
		
		if (game.gameState == STATE.Menu) {
			// Menu Title
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("W A V E", 465, 240);
			
			// Play Button
			g.setColor(Color.white);
			g.drawRect(455, 340, 400, 130);
			g.setFont(fnt2);
			g.setColor(Color.green);
			g.drawString("Play", 575, 422);
			
			// Help Button
			g.setColor(Color.white);
			g.drawRect(455, 500, 400, 130);
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Help", 575, 582);
			
			// Quit Button
			g.setColor(Color.white);
			g.drawRect(455, 660, 400, 130);
			g.setFont(fnt2);
			g.setColor(Color.red);
			g.drawString("Quit", 575, 742);
		} else if (game.gameState == STATE.Help) {
			// Help Menu Title
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 550, 240);
			
			// Help
			g.setFont(fnt_help);
			g.drawString("Use WASD to move the enemy and dodge enemies.", 170, 430);
			
			// Back Button
			g.setColor(Color.white);
			g.drawRect(455, 660, 400, 130);
			g.setFont(fnt2);
			g.setColor(Color.red);
			g.drawString("Back", 575, 742);
		} else if (game.gameState == STATE.End) {
			// Game Over Title
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("GAME OVER", 360, 300);
			
			// Final Score
			g.setFont(fnt_help);
			g.drawString("You lost with a score of: " + (int)hud.getScore(), 400, 430);
			
			// Reset Button
			g.setColor(Color.red);
			g.drawRect(455, 660, 400, 130);
			g.setFont(fnt2);
			g.setColor(Color.red);
			g.drawString("Back", 570, 746);
		}
	}
	
}
