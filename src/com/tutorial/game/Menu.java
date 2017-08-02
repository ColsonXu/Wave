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
	private Random r = new Random();
	
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mX = e.getX();
		int mY = e.getY();
		
		if (game.gameState == STATE.Menu) {
			// Play Button
			if (mouseOver(mX, mY, 455, 340, 400, 130)) {
				game.gameState = STATE.Game;
				Player: handler.addObject(new Player(630, 463, ID.Player, handler));
		        // Boss1:
		        // handler.addObject(new Boss1(r.nextInt(Game.WIDTH - 120), 100, ID.Boss1, handler));
		        // Basic Enemy: 
		        handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 100), r.nextInt(Game.HEIGHT - 100), ID.basicEnemy, handler));
		        // Fast Enemy: 
		        // handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 20), ID.fastEnemy, handler));
		        // Smart Enemy: 
		        // handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 20), ID.smartEnemy, handler));
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
			g.drawString("Menu", 526, 280);
			
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
			g.drawString("Help", 526, 280);
			
			// Help
			g.setFont(fnt_help);
			g.drawString("Use WASD to move the enemy and dodge enemies.", 170, 430);
			
			// Back Button
			g.setColor(Color.white);
			g.drawRect(455, 660, 400, 130);
			g.setFont(fnt2);
			g.setColor(Color.red);
			g.drawString("Back", 575, 742);
		}
	}
	
}
