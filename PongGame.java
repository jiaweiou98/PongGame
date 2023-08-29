/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pong;

/**
 *
 * @author Jiawei Ou
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PongGame extends JPanel implements MouseMotionListener {


    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private Ball gameBall;
    private Paddle userPaddle, pcPaddle;
    private int userScore, pcScore;
    private int userMouseY;
    private int bounceCount;
    

    /**
     * Updates and draws all the graphics on the screen
     */
    public void paintComponent(Graphics g){

        //draw the background, set color to BLACK and fill in a rectangle
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        //update score
        g.setColor(Color.WHITE);
        //the drawString method needs a String to print, and a location to print it at.
        g.drawString("Score - User [ " + userScore + " ]   PC [ " + pcScore + " ]", 250, 20   );
        
        // draw the ball
        gameBall.paint(g);
        //draw the paddles
        userPaddle.paint(g);
        pcPaddle.paint(g);

    }
       


    public PongGame(){

    gameBall = new Ball(300, 200, 3, 3, 3, Color.YELLOW, 10);
    userPaddle = new Paddle(10, 200, 75, 3, Color.BLUE);
    pcPaddle = new Paddle(610, 200, 75, 3, Color.RED);
    userScore = 0; pcScore = 0;
    userMouseY = 0;
    bounceCount = 0;

    //listen for motion events on this object
    addMouseMotionListener(this);

    }
    /**
 * Called once each frame to handle essential game operations
 */
    public void gameLogic(){
        
        //move the ball one frame
        gameBall.moveBall();
        //edge check/bounce
        gameBall.bounceOffEdges(0, WINDOW_HEIGHT);
        userPaddle.moveTowards(userMouseY);
        pcPaddle.moveTowards(gameBall.getY());
        if(gameBall.getX() < 0){
            //player has lost
            pcScore++;
                reset();
        }
        else if(gameBall.getX() > WINDOW_WIDTH){
            //pc has lost
            userScore++;
                reset();
        }
        if(pcPaddle.checkCollision(gameBall) || userPaddle.checkCollision(gameBall)){
            //reverse ball if they collide
            gameBall.reverseX();
            //increase the bounce count
            bounceCount++;
        }

        //after 5 bounces
        if (bounceCount == 5){
            //reset counter
            bounceCount = 0;
            //increase speed will go here
             gameBall.increaseSpeed();
        }

    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
         userMouseY = e.getY();

    }
    public void reset(){
        //pause for a second
     try{
         Thread.sleep(1000);
     }
     catch(Exception e){
         e.printStackTrace();
     } 
        //reset ball
        gameBall.setX(300);
        gameBall.setY(200);
        gameBall.setCx(3);
        gameBall.setCy(3);
        gameBall.setSpeed(6);
        bounceCount = 0;
    }
 

}
