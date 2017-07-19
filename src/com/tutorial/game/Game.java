package com.tutorial.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

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
    // Create a HUD object
    private HUD hud;
    // Create spawn object
    private Spawn spawnSystem;
    private Random r = new Random();


    public Game() {
        // Initialize the handler
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        // Create the window
        new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);
        
        hud = new HUD();
        spawnSystem = new Spawn(handler, hud);
        Player: handler.addObject(new Player(630, 463, ID.Player, handler));
        // Basic Enemy: 
        handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 30), r.nextInt(Game.HEIGHT - 30), ID.basicEnemy, handler));
        // Fast Enemy: 
        // handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 20), ID.fastEnemy, handler));
        // Smart Enemy: 
        // handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 20), r.nextInt(Game.HEIGHT - 20), ID.smartEnemy, handler));

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
        spawnSystem.tick();
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

    public static float clamp(float x, float min, float max) {
    	if (x <= min) {
    		return x = min;
    	} else if (x >= max) {
    		return x = max;
    	} else {
    		return x;
    	}
    }

    public static void main(String args[]) {
        new Game();
    }

}
