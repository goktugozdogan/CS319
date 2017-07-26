import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

    // End of variables declaration  
public class GamePanel extends javax.swing.JPanel {
	
	// Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private ImageIcon stadiumIcon;
    private SoundManage sm;
    private Player p1, p2;
    private Timer timer;
    // End of variables declaration 

    private final int WIDTH = 1200, HEIGHT = 800; // size of screen
	private Goal goalLeft, goalRigth;
	private Ball ball;
	//private GamePhysic gp;
	
	
	// ronaldo
	private ImageIcon ronaldo;
	private Timer timerRonaldo, timerJumpRonaldo;
	private Player r;
	
	// neymar
	private final int JUMP_DELAY = 40;
	private ImageIcon neymar;
	private Timer timerNeymar, timerJumpNeymar;
	private Player l;
	// ball
	//	private final int DELAY = 20; //BALL_SIZE = 45;
	private ImageIcon ballimg;
	
	
	
	
	
	
    public GamePanel() {
        initComponents();
    }
                        
    private void initComponents() {
    	Game g = new Game();
    	try {
           FileInputStream fileIn = new FileInputStream("data.ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           g = (Game) in.readObject();
           in.close();
           fileIn.close();
        }catch(IOException i) {
           i.printStackTrace();
           return;
        }catch(ClassNotFoundException c) {
           System.out.println("Game class not found");
           c.printStackTrace();
           return;
        }
    	
    	try {
            FileOutputStream fileOut =
            new FileOutputStream("data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(g);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in data.ser");
         }catch(IOException i) {
            i.printStackTrace();
         }
    	
    	
    	
    	sm = new SoundManage();
		goalLeft = new Goal();
		goalRigth = new Goal();
		//gp = new GamePhysic();
		//seting delay
		//gp.setDelay(20);
		goalLeft.setSize(550);
		goalRigth.setSize(550);
		
		ball = new Ball();
		r= new Player();
		l = new Player();
		
		r.setPlayerImage(g.getPlayer1Image());
    	l.setPlayerImage(g.getPlayer2Image());
    	
    	neymar = new ImageIcon ("images/players/1P2.png");//r.getPlayerImage();
    	ronaldo = new ImageIcon ("images/players/4P1.png");//l.getPlayerImage();
    	
		addKeyListener(new ButtonListener());
		
		// ronaldo
		addKeyListener(new RonaldoListener());
		
		r.setX(500);
		r.setY(500);
		r.setSpeed(3);
		r.setJump(18);
		
		timerRonaldo = new Timer(JUMP_DELAY, new RonaldoSmoothMovement());
		timerJumpRonaldo = new Timer(JUMP_DELAY, new RonaldoSmoothJump());
		
		// neymar
		addKeyListener(new NeymarListener());
		l.setX(400);
		l.setY(400);
		l.setSpeed(4);
		l.setJump(14);
	    
	    timerNeymar = new Timer(JUMP_DELAY, new NeymarSmoothMovement());
	    timerJumpNeymar = new Timer(JUMP_DELAY, new NeymarSmoothJump());

	    // ball
	    timer = new Timer(JUMP_DELAY, new BallListener());
	    ballimg = new ImageIcon ("images/balls/b6.png");
	  //  ballX = 800; //465;
	   // ballY = 600; //265;
	    ball.setBallX(600);
	    ball.setBallY(600);
	    ball.setSpeedY(10);
	    ball.setSpeedX(-10);
	   
	    timer.start();
		//*************************************************************************

        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        
        stadiumIcon = new javax.swing.ImageIcon("images/stadium1.png");

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setText("MENU");
        jButton1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if ( jButton1.isEnabled() ){
					JFrame f = new PausePanel();
				    f.setVisible(true);
				}
			}  	
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TEAM1   1 : 0  TEAM2");
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        
        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("BEST OF SEVEN");
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 394, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 690, Short.MAX_VALUE))
        );
    }
    
    public void paintComponent(Graphics page){
		super.paintComponent (page);
		stadiumIcon.paintIcon(this, page, 0, 0);
		
		/*
		// draw sides
	    Graphics2D g1 = (Graphics2D) page;
	    g1.setStroke(new BasicStroke(10));
	    g1.setColor(Color.white);
	    g1.drawRect(100, 100, WIDTH - 200, HEIGHT - 200);
	    */
		
	    // add images
	    //goal1.paintIcon(this, page, -4, goalRigth.getSize());
	    //goal2.paintIcon(this, page, 1095, goalLeft.getSize());
	    neymar.paintIcon (this, page, l.getX(), l.getY());
	    ronaldo.paintIcon(this, page, r.getX(), r.getY());
	    ballimg.paintIcon (this, page, ball.getBallX(), ball.getBallY()); 
	    
	    repaint();
    	
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
			repaint();
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
			repaint();
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

	        	if ( ball.getBallX() <= 23 )
	    			ball.setSpeedX(0);
		        if ( ball.getBallY() >= 660)
		        	ball.setSpeedY(0);
		        repaint();
	        }
	        
	        // check goal 2
	        if ( ball.getBallX() >= 1055 && ball.getBallY() >= goalLeft.getSize() ){
	        	ball.setSpeedX(-1);
	        	ball.setSpeedY(1);

	        	if ( ball.getBallX() >= 1132 )
	        		ball.setSpeedX(0);
		        if ( ball.getBallY() >= 660)
		        	ball.setSpeedY(0);
	        }
	        
	        // neymar & ball collision
	        if ( (l.getY()+78 >= ball.getBallY()+22 && l.getY()<= ball.getBallY()+22)
	        		&& (l.getX() + 34 >= ball.getBallX() + 22 && l.getX()<= ball.getBallX() + 22 ))
	        {
	        	sm.playKickSound();
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
	        	sm.playKickSound();
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
	        //	if(ball.getBallY() > -3 && ball.getSpeedY()>1)
	        //		ball.setSpeedY(1 + ball.getSpeedY());
	        	 if(ball.getBallY() < 0)
	        		ball.setSpeedY(2 + ball.getSpeedY());
	        	
	        }
	        
	        
	        
	        repaint();	
		}
	}//BallListener
                 
}
