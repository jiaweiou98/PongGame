/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pong;

/**
 *
 * @author Jiawei Ou
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pong {

	//declare and initialize the frame
    static JFrame f = new JFrame("Pong");

    public static void main(String[] args) {

	//make it so program exits on close button click
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	//the size of the game will be 480x640, the size of the JFrame needs to be slightly larger
        f.setSize(650,495);
        //make the new PongGame
        PongGame game = new PongGame();

        //add the game to the JFrame
        f.add(game);


		//show the window
        f.setVisible(true);
         //make a new Timer
        Timer timer = new Timer(33, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 //game logic
                game.gameLogic();

                //repaint the screen
                game.repaint();

            }
        });

        //start the timer after it's been created
        timer.start();
	}
}
