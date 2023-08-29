/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pong;

/**
 *
 * @author Jiawei Ou
 */
import java.awt.*;
public class Ball {
    //declare instance variables
    private  int x, y, cx, cy, speed, size;
    private  Color color;
    static final int MAX_SPEED = 10;

	//ball constructor assigns values to instance variables
    public Ball(int x, int y, int cx, int cy, int speed, Color color, int size) {
        this.x = x;
        this.y = y;
        this.cx = cx;
        this.cy = cy;
        this.speed = speed;
        this.color = color;
        this.size = size;
    }
    public void setX(int  newx){
        this.x = newx;
    }
    public void setY(int  newy){
        this.y = newy;
    }
    public void setCx(int  newcx){
        this.cx = newcx;
    }
    public void setCy(int  newcy){
        this.cy = newcy;
    }
    public void setSpeed(int  newspeed){
        this.speed = newspeed;
    }
    public void paint(Graphics g){

        //set the brush color to the ball color
        g.setColor(color);

        //paint the ball at x, y with a width and height of the ball size
        g.fillOval(x, y, size, size);

    }
    public void moveBall(){
        x += cx;
        y += cy;
    }
    public void bounceOffEdges(int top, int bottom){

        //if the y value is at the bottom of the screen
        if (y > bottom- size){
        reverseY();
        }
        //if y value is at top of screen
        else if(y < top){
        reverseY();
        }
    }

/**
 * Reverse's the ball's change in x value
 */
    public void reverseX(){
    cx *= -1;
    }

/**
 * Reverse's the ball's change in y value
 */
    public void reverseY(){
    cy *= -1;
    }
    public int getY(){
        return y;
    }
    public int getX(){
    return x;
    }
    public int getSize(){
    return size;
    }
    public void increaseSpeed(){
        //make sure current speed is less than max speed before incrementing
        if(speed < MAX_SPEED){
            //increase the speed by one
            speed ++;

            //update cy and cx with the new speed
            cx = (cx / Math.abs(cx)*speed);
            cy = (cy / Math.abs(cy)*speed);

        }

    }
    
}

