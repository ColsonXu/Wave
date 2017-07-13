package com.tutorial.game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by found on 10-Jul-17.
 */
public class Window extends Canvas{

	private static final long serialVersionUID = 4178563373392080989L;

	public Window(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }

}
