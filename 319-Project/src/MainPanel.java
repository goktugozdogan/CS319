import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainPanel extends JPanel{
	private final int WIDTH = 1200, HEIGHT = 800; // size of screen
	private ImageIcon goal1, goal2, stadium;
	
	// neymar
	private final int JUMP_DELAY = 40;
	private ImageIcon neymar;
	private Timer timerNeymar, timerJumpNeymar;
	private int neymarX, neymarY; // location of neymar
	private int neymarSpeedX; // speed on x-axis
	private int jump;// speed on y-axis
	private boolean directionX, directionY; // for keyboard keys
	
	
	// ball
	private final int DELAY = 20; //BALL_SIZE = 45;
	private ImageIcon ball;
	private Timer timer;
	private int ballX, ballY; // location of ball
	private int speedX, speedY; // speed of ball
	
	
	
	public MainPanel(){
		// neymar
		addKeyListener(new NeymarListener());
		neymarX = 120;
		neymarY = 617;
		neymarSpeedX = 4;
		jump = 14;
	    neymar = new ImageIcon("images/neymar.png");
	    timerNeymar = new Timer(DELAY, new NeymarSmoothMovement());
	    timerJumpNeymar = new Timer(JUMP_DELAY, new NeymarSmoothJump());
	    
	    // goal 1
	    goal1  = new ImageIcon("images/goal11.png");
	    
	    // goal 2
	    goal2  = new ImageIcon("images/goal22.png");
	    
	    // stadium
	 	stadium = new ImageIcon("images/stadium.png");
	    
	    // ball
	    timer = new Timer(DELAY, new BallListener());
	    ball = new ImageIcon ("images/ball.png");
	    ballX = 800; //465;
	    ballY = 600; //265;
	    speedX = -2;
	    speedY = -10;
	    timer.start();
	    
	    setBackground (Color.green);
	    setPreferredSize (new Dimension(WIDTH, HEIGHT));
	    setFocusable(true);  
	}
	
	public void paintComponent (Graphics page){
		super.paintComponent (page);
		//stadium.paintIcon(this, page, -50, -100);
		
		// draw sides
	    Graphics2D g1 = (Graphics2D) page;
	    g1.setStroke(new BasicStroke(10));
	    g1.setColor(Color.white);
	    g1.drawRect(100, 100, WIDTH - 200, HEIGHT - 200);
	    
	    // add images
	    goal1.paintIcon(this, page, -4, 550);
	    goal2.paintIcon(this, page, 1095, 550);
	    neymar.paintIcon (this, page, neymarX, neymarY);
	    ball.paintIcon (this, page, ballX, ballY);   
	}
	
	public void runNeymar(){
		timerNeymar.start();
	}
	
	public void stopNeymar(){
		timerNeymar.stop();
	}
	public void jumpNeymar(){
		timerJumpNeymar.start();
	}
	
	private class NeymarSmoothJump implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if ( directionY ){
				neymarY -= jump;
				if ( jump >= -11)
					jump -= 1;
			}
			if ( neymarY >= 614 ){
				directionY = false;
				jump = 14;
			}		
		}
	}
	
	private class NeymarSmoothMovement implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if ( directionX )
				neymarX += neymarSpeedX;
			else if ( !directionX )
				neymarX -= neymarSpeedX;
			/*
			// check sides
	        if (neymarX <= 100 || neymarX >= WIDTH-145){
				neymarSpeedX = 0;
			}	
	        if (neymarY <= 100 || neymarY >= HEIGHT-145){
	        	neymarSpeedX = 0;
	        }
	        */
		}
	}
	
	private class NeymarListener implements KeyListener{
		public void keyPressed(KeyEvent event){
			switch (event.getKeyCode()){
	            case KeyEvent.VK_UP:
	            	directionY = true;
	            	//neymarY -= JUMP;
	            	jumpNeymar();
	            	break;
	            /*
	            case KeyEvent.VK_DOWN:
	            	directionY = true;
	            	//neymarY += JUMP;
	            	runNeymar();
	            	break;
	            */
	            case KeyEvent.VK_LEFT:
	            	directionX = false;
	            	runNeymar();
	            	break;
	            case KeyEvent.VK_RIGHT:
	            	directionX = true;
	            	runNeymar();
	            	break;
	         }
	         repaint();
		}
		public void keyTyped (KeyEvent event) {}
	    public void keyReleased (KeyEvent event) {
	    	switch (event.getKeyCode()){
            case KeyEvent.VK_UP:
            	neymarY -= neymarSpeedX;
            	stopNeymar();
            	break;
            /*
            case KeyEvent.VK_DOWN:
            	neymarY += neymarSpeedX;
            	stopNeymar();
            	break;
            */
            case KeyEvent.VK_LEFT:
            	neymarX -= neymarSpeedX;
            	stopNeymar();
            	break;
            case KeyEvent.VK_RIGHT:
            	neymarX += neymarSpeedX;
            	stopNeymar();
            	break;
         }
         repaint();
	    }
	}//ImageListener
	
	private class BallListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			ballX += speedX;
			ballY += speedY;
			
			// check goal 1
	        if ( ballX <= 100 && ballY >= 550 ){
	        	speedX = 1;
	        	speedY = 1;
	        	if ( ballX <= 23 )
	    			speedX = 0;
		        if ( ballY >= 660)
		        	speedY = 0;
	        }
	        
	        // check goal 2
	        if ( ballX >= 1055 && ballY >= 550 ){
	        	speedX = 1;
	        	speedY = 1;
	        	if ( ballX >= 1132 )
	    			speedX = 0;
		        if ( ballY >= 660)
		        	speedY = 0;
	        }
	        
	        // neymar collide
	        if ( (neymarY+78 >= ballY+22 && neymarY <= ballY+22) && (neymarX +34 >= ballX+22 && neymarX <= ballX+22 ))
	        {
	        	speedX *= -1;
	        	speedY *= -1;
	        	
	        }
			// check sides
	        else if (ballX <= 100 || ballX >= WIDTH-145){
				speedX *= -1;
			}	
	        else if (ballY <= 100 || ballY >= HEIGHT-145){
	        	speedY *= -1;
	        }
	        
	        repaint();	
		}
	}//BallListener
}//class