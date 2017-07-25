package headBall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainPanel extends JPanel{
	private final int WIDTH = 1200, HEIGHT = 800; // size of screen
	private ImageIcon goal1, goal2, stadium;
	private JButton reset;
	private Goal goalLeft, goalRigth;
	private Ball ball;
	private GamePhysic gp;
	
	// ronaldo
	private ImageIcon ronaldo;
	private Timer timerRonaldo, timerJumpRonaldo;
	private Player r;
	private JPanel scorePanel;
	
	// neymar
	private final int JUMP_DELAY = 40;
	private ImageIcon neymar;
	private Timer timerNeymar, timerJumpNeymar;
	private Player l;
	private int score1, score2;

	
	
	// ball
//	private final int DELAY = 20; //BALL_SIZE = 45;
	private ImageIcon ballimg;
	private Timer timer;
	private JLabel scoreLabel1,scoreLabel2;
	
	
	public MainPanel(){
		goalLeft = new Goal();
		goalRigth = new Goal();
		gp = new GamePhysic();
		
		ball = new Ball();
		r= new Player();
		l = new Player();
		scoreLabel1 = new JLabel( " score 1 " + score1);
		scoreLabel1.setText(" score 1 " + score1);
		scoreLabel1.setVisible(true);
		scoreLabel1.setBackground(Color.RED);
		scoreLabel2 = new JLabel( " score 2 " + score2);
		this.add(scoreLabel1);
		reset = new JButton("Press 'R' to reset");
		reset.setEnabled(false);
		
		//seting delay
		gp.setDelay(20);
		
		
		goalLeft.setSize(550);
		goalRigth.setSize(550);
		
		add(reset);
		score1 = 0;
		score2 = 0;
		addKeyListener(new ButtonListener());
		
		// ronaldo
		addKeyListener(new RonaldoListener());
		r.setX(120);
		r.setY(611);
		r.setSpeed(3);
		r.setJump(18);
		ronaldo = new ImageIcon("images/ronaldo.png");
		timerRonaldo = new Timer(gp.getDelay(), new RonaldoSmoothMovement());
		timerJumpRonaldo = new Timer(JUMP_DELAY, new RonaldoSmoothJump());
		
		// neymar
		addKeyListener(new NeymarListener());
		l.setX(800);
		l.setY(617);
		l.setSpeed(4);
		l.setJump(14);
	    neymar = new ImageIcon("images/neymar.png");
	    timerNeymar = new Timer(gp.getDelay(), new NeymarSmoothMovement());
	    timerJumpNeymar = new Timer(JUMP_DELAY, new NeymarSmoothJump());
	    
	    // goal 1
	    goal1  = new ImageIcon("images/goal11.png");
	    
	    // goal 2
	    goal2  = new ImageIcon("images/goal22.png");
	    
	    // stadium
	 	stadium = new ImageIcon("images/stadium.png");
	 	
	    
	    // ball
	    timer = new Timer(gp.getDelay(), new BallListener());
	    ballimg = new ImageIcon ("images/ball.png");
	  //  ballX = 800; //465;
	   // ballY = 600; //265;
	    ball.setBallX(125);
	    ball.setBallY(600);
	    ball.setSpeedY(10);
	    ball.setSpeedX(-10);
	   
	    timer.start();
	    
	    setBackground (Color.green);
	    setPreferredSize (new Dimension(WIDTH, HEIGHT));
	    setFocusable(true);  
	}
	
	public void paintComponent (Graphics page){
		super.paintComponent (page);
		stadium.paintIcon(this, page, -50, -100);
		
		// draw sides
	    Graphics2D g1 = (Graphics2D) page;
	    g1.setStroke(new BasicStroke(10));
	    g1.setColor(Color.white);
	    g1.drawRect(100, 100, WIDTH - 200, HEIGHT - 200);
	    
	    // add images
	    goal1.paintIcon(this, page, -4, goalRigth.getSize());
	    goal2.paintIcon(this, page, 1095, goalLeft.getSize());
	    neymar.paintIcon (this, page, l.getX(), l.getY());
	    ronaldo.paintIcon(this, page, r.getX(), r.getY());
	    ballimg.paintIcon (this, page, ball.getBallX(), ball.getBallY());   
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
	
	public void runRonaldo(){
		timerRonaldo.start();
	}
	
	public void stopRonaldo(){
		timerRonaldo.stop();
	}
	public void jumpRonaldo(){
		timerJumpRonaldo.start();
	}
	
	private class ButtonListener implements KeyListener{
		public void keyPressed(KeyEvent event){
			switch (event.getKeyCode()){
            case KeyEvent.VK_R:
				ball.setBallX(325);
				ball.setBallY(200);
				ball.setSpeedX(-2);
				ball.setBallY(7);
			    
			}
		}
		public void keyTyped (KeyEvent event) {}
	    public void keyReleased (KeyEvent event) {}
	}
	private class NeymarSmoothJump implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if ( l.getDirY() ){
				l.setY(l.getY()-l.getJump());
				
				if ( l.getJump()>= -11)
					l.setJump(l.getJump()-1);
			}
			if ( l.getY() >= 614 ){
				l.setDirY(false);
				l.setJump(14);
			}
		}
	}
	
	private class RonaldoSmoothJump implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if ( r.getDirY()){
				r.setY(r.getY()-r.getJump());
				if ( r.getJump() >= -14)
					r.setJump(r.getJump()-1);
			}
			if ( r.getY() >= 614 ){
				r.setDirY(false);
				r.setJump(18);
			}
		}
	}
	
	private class RonaldoListener implements KeyListener{
		public void keyPressed(KeyEvent event){
			switch (event.getKeyCode()){
	            case KeyEvent.VK_W:
	            	r.setDirY(true);
	            	//neymarY -= JUMP;
	            	jumpRonaldo();
	            	break;
	            /*
	            case KeyEvent.VK_DOWN:
	            	directionY = true;
	            	//neymarY += JUMP;
	            	runNeymar();
	            	break;
	            */
	            case KeyEvent.VK_A:
	            	r.setDirX(false);
	            	runRonaldo();
	            	break;
	            case KeyEvent.VK_D:
	            	r.setDirX(true);
	            	runRonaldo();
	            	break;
	         }
	         repaint();
		}
		public void keyTyped (KeyEvent event) {}
	    public void keyReleased (KeyEvent event) {
	    	switch (event.getKeyCode()){
            case KeyEvent.VK_W:
            	r.setY(r.getY()-r.getSpeed());
            	stopRonaldo();
            	break;
            /*
            case KeyEvent.VK_DOWN:
            	neymarY += neymarSpeedX;
            	stopNeymar();
            	break;
            */
            case KeyEvent.VK_A:
            	r.setX(r.getX()-r.getSpeed());
            	stopRonaldo();
            	break;
            case KeyEvent.VK_D:
            	r.setX(r.getX()-r.getSpeed());
            	stopRonaldo();
            	break;
         }
         repaint();
	    }
	}//ImageListener
	
	private class NeymarSmoothMovement implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if ( l.getDirX() )
				l.setX(l.getX()+l.getSpeed());
			else if ( !l.getDirX() )
				l.setX(l.getX()-l.getSpeed());
		}
	}
	private class RonaldoSmoothMovement implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if ( r.getDirX() )
				r.setX(r.getX()+r.getSpeed());
			else if ( !r.getDirX() )
				r.setX(r.getX()-r.getSpeed());

		}
	}
	
	private class NeymarListener implements KeyListener{
		public void keyPressed(KeyEvent event){
			switch (event.getKeyCode()){
	            case KeyEvent.VK_UP:
	            	l.setDirY(true);
	            	
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
	            	l.setDirX(false);
	            	runNeymar();
	            	break;
	            case KeyEvent.VK_RIGHT:
	            	l.setDirX(true);
	            	runNeymar();
	            	break;
	         }
	         repaint();
		}
		public void keyTyped (KeyEvent event) {}
	    public void keyReleased (KeyEvent event) {
	    	switch (event.getKeyCode()){
            case KeyEvent.VK_UP:
            	l.setY(l.getY()-l.getSpeed());
            	stopNeymar();
            	break;
            /*
            case KeyEvent.VK_DOWN:
            	neymarY += neymarSpeedX;
            	stopNeymar();
            	break;
            */
            case KeyEvent.VK_LEFT:
            	l.setX(l.getX()-l.getSpeed());
            	stopNeymar();
            	break;
            case KeyEvent.VK_RIGHT:
            	l.setX(l.getX()-l.getSpeed());
            	stopNeymar();
            	break;
         }
         repaint();
	    }
	}//ImageListener
	
	private class BallListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			ball.setBallX(ball.getBallX()+ ball.getSpeedX());
			ball.setBallY(ball.getBallY()+ ball.getSpeedY());
			
			//gravity
		//	while(ball.getSpeedY() <= 300 || ball.getSpeedY() >=-300) {
			//	if(ball.getSpeedY()<7 || ball.getSpeedY()>0)
			//		ball.setSpeedY(ball.getBallY()+1);
				
		//	}
	
			
			if(ball.getBallY() <0) {
			//	ball.setBallY(100);
				ball.setSpeedY(-ball.getSpeedY());
			}
			
			// check goal 1
	        if ( ball.getBallX() <= 100 && ball.getBallY() >= goalRigth.getSize() ){
	        	ball.setSpeedX(1);
	        	ball.setSpeedY(1);
	        	
	        	score1 += 1;
	        	if ( ball.getBallX() <= 23 )
	    			ball.setSpeedX(0);
		        if ( ball.getBallY() >= 660)
		        	ball.setSpeedY(0);
	        }
	        
	        // check goal 2
	        if ( ball.getBallX() >= 1055 && ball.getBallY() >= goalLeft.getSize() ){
	        	ball.setSpeedX(-1);
	        	ball.setSpeedY(1);
	        	score2 += 1;
	        	if ( ball.getBallX() >= 1132 )
	        		ball.setSpeedX(0);
		        if ( ball.getBallY() >= 660)
		        	ball.setSpeedY(0);
	        }
	        
	        // neymar & ball collision
	        if ( (l.getY()+78 >= ball.getBallY()+22 && l.getY()<= ball.getBallY()+22)
	        		&& (l.getX() + 34 >= ball.getBallX() + 22 && l.getX()<= ball.getBallX() + 22 ))
	        {
	        	ball.setBallX(ball.getBallX()-7);
	        	ball.setBallY(ball.getBallY()-7);
	        	ball.setSpeedX(-(ball.getSpeedX()));
	        	ball.setSpeedY(-(ball.getSpeedY()));
	        	if(ball.getSpeedY() < 0)
	        		ball.setSpeedY(-7 +(ball.getSpeedX()));
	        	if(ball.getSpeedY() > 0)
	        		ball.setSpeedY(+7 +(ball.getSpeedY()));
	        	ball.setSpeedX(ball.getSpeedX()-4);
	        }
	        
	        // ronaldo & ball collision
	        if ( (r.getY() + 84 >= ball.getBallY() + 22 && r.getY() <= ball.getBallY() + 22) 
	        		&& (r.getX() + 34 >= ball.getBallX()+ 22 && r.getX() <= ball.getBallX() + 22 ))
	        {
	        	ball.setBallX(ball.getBallX()+7);
	        	ball.setBallY(ball.getBallY()+7);
	        	ball.setSpeedX(-(ball.getSpeedX()));
	        	ball.setSpeedY(-(ball.getSpeedY()));
	        	if(ball.getSpeedY() < 0) 
	        		ball.setSpeedY(-7 +(ball.getSpeedY()));
	        	if(ball.getSpeedY() > 0) 
	        		ball.setSpeedY(+7 +(ball.getSpeedY()));
	        	ball.setSpeedX(ball.getSpeedX()+4);
	        	
	        }
	      
	        
			// check sides
	        else if (ball.getBallX() <= 100 || ball.getBallX() >= WIDTH-145){
	        	ball.setSpeedX(-ball.getSpeedX());
				
			}
	        else if (ball.getBallY() <= 100 || ball.getBallY() >= HEIGHT-145){
	        	ball.setSpeedY(-ball.getSpeedY());
	        	//friction
	        	if(ball.getBallY() < 0)
	        		ball.setSpeedY(2+ball.getSpeedY());
	        }
	        
	        
	        
	        repaint();	
		}
	}//BallListener
	
    
    
}//class		