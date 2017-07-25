package headBall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.Timer;



public class Ball {
	private ImageIcon ball;
	private int speedX, speedY; // speed of ball
	private Timer timer;
	private int ballX, ballY;
//	private final int DELAY = 20; //BALL_SIZE = 45;
//	private final int WIDTH = 1200, HEIGHT = 800; // size of screen
	
	//constructor
	public Ball() {
		
		timer = new Timer(65, new GravityListener());
		timer.start();
	//    ball = new ImageIcon ("images/ball.png");
	//    ballX = 465; //465;
	//    ballY = 265; //265;
	//    speedX = -10;
	//    speedY = 10;
	 //   timer.start();
	}
	
	//getters
	public int getBallX() {
		return this.ballX;
	}
	
	public int getBallY() {
		return this.ballY;
	}
	
	public void setBallX(int x) {
		this.ballX = x;
	//	speedY = 20;
	}
	
	public void setBallY(int y) {
		//speedY = 20;
		this.ballY = y;
	}
	
	public int getSpeedX() {
		return this.speedX;
	}
	
	public int getSpeedY() {
		return this.speedY;
	}
	
	public void setSpeedX(int sx) {
		this.speedX = sx;
	}
	
	public void setSpeedY(int sy) {
		this.speedY =sy;
	}
	
	
	private class GravityListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(speedY <= 10 && ballY < 570)
				speedY += 2;
		}
	}
/*	private class BallListener2 implements ActionListener{
		public void actionPerformed(ActionEvent event){
			ballX += speedX;
			ballY += speedY;
			//gravity
			if(speedY<0)
				speedY += 1;
			if(speedY>0)
				speedY += 1;
			if(speedY == 0)
				speedY += 1;
			
			
			// check goal 1
	        if ( ballX <= 100 && ballY >= 550 ){
	        	speedX = 1;
	        	speedY = 1;
//	        	score1 += 1;
	        	if ( ballX <= 23 )
	    			speedX = 0;
		        if ( ballY >= 660)
		        	speedY = 0;
	        }
	        
	        // check goal 2
	        if ( ballX >= 1055 && ballY >= 550 ){
	        	speedX = -1;
	        	speedY = 1;
	  //      	score2 += 1;
	        	if ( ballX >= 1132 )
	    			speedX = 0;
		        if ( ballY >= 660)
		        	speedY = 0;
	        }

	       
	      
	        
			// check sides
	        else if (ballX <= 100 || ballX >= WIDTH-145){
				speedX *= -1;
				
			}
	        else if (ballY <= 100 || ballY >= HEIGHT-145){
	        	speedY *= -1;
	        	//friction
	        	if(speedY < 0)
	        		speedY += 2;
	        } 
	        
		}
	}//BallListener
	*/
	
}
