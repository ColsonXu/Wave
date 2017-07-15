package com.tutorial.game;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by found on 10-Jul-17.
 */

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -1679878377156176010L;
	
	// Defining window's dimensions
    public static final int WIDTH = 1324, HEIGHT = WIDTH / 12 * 9;
    // Create a new thread
    private Thread thread;
    // An indicator of if the game is currently running.
    private boolean running = false;
    // Create a handler
    private Handler handler;
    // Create a HUD object;
    private HUD hud;
    


    public Game() {
        // Initialize the handler
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        
        // Create the window
        new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);
        
        hud = new HUD();
        
        handler.addObject(new Player(200, 200, ID.Player, handler));
        handler.addObject(new BasicEnemy(200, 200, ID.basicEnemy));
        
    }


    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // Game loop
    public void run() {
    	this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) /ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
        hud.tick();
    }


    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        handler.render(g);
        // hud.render() has to be below the handler.render()
        // Otherwise the HUD will be under GameObjects
        hud.render(g);
        
        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max) {
    	if (var <= min) {
    		return var = min;
    	} else if (var >= max) {
    		return var = max;
    	} else {
    		return var;
    	}
    }

    public static void main(String args[]) {
        new Game();
    }

}
