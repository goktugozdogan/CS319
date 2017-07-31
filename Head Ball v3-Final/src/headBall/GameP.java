package headBall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;



public class GameP extends JPanel{
	ArtificialInteligence ai;
	Obstacle obst;
	Rectangle rect;
	Ellipse2D.Double elipse;
	Rectangle2D.Double rectR, rectL, rectObs, rectObs1, rectObs2;
	private final int WIDTH = 1200, HEIGHT = 800; // size of screen
	private ImageIcon goal1, goal2, stadium;
	private Goal goalLeft, goalRigth;
	private Ball ball;
	private GamePhysic gp;
	private SoundManage sm;
	private Gravity gra;
	private int rndDirBall;
	private int gravity = 3;
	private  int maxVelocity = 30;
	private boolean lastHit;
	MouseEvent ms;
	// ronaldo
	private ImageIcon ronaldo;
	private Timer timerRonaldo, timerJumpRonaldo,aiTimer;
	private Player r;

	// neymar
	//private final int JUMP_DELAY = 40;
	private ImageIcon neymar;
	private Timer timerNeymar, timerJumpNeymar;
	private Player l;
	private int score1, score2;
	private PowerUp powerUp;
	private Point pt;


	// ball
	//	private final int DELAY = 20; //BALL_SIZE = 45;
	private ImageIcon speedUpIcon, power;
	private ImageIcon ballimg;
	private Timer timer;

	JLabel jLabel5, jLabel6;
	JButton jButton1;

	int teamscore1, teamscore2;
	int timeRemaning;
	int timeLimit;
	private final ClockListener clock = new ClockListener();
	private final Timer timerR = new Timer(53, clock);
	private final SimpleDateFormat date = new SimpleDateFormat("ss");
	private long startTime;
	boolean endOfGame;
	int powerOne;

	public GameP(){
		rect = new Rectangle();
		obst = new Obstacle(90,150,450,600);
		rect.setBounds(00, 300, 50, 30);

		ai = new ArtificialInteligence();
		ms = new MouseEvent();
		addMouseListener(ms);
		pt = new Point();
		int px = (int)((Math.random()*894)+202);
		int py = (int)((Math.random()*90)+412);
		powerUp = new PowerUp(px,py);
		lastHit = false;
		sm = new SoundManage();
		goalLeft = new Goal();
		goalRigth = new Goal();
		gp = new GamePhysic();
		gra = new Gravity(ball);

		ball = new Ball();
		r= new Player();
		l = new Player();

		Main.game.setMainMenuPanel(false);


		//seting delay
		gp.setDelay(20);
		timer = new Timer(265, new GravityListener());
		timer.start();

		goalLeft.setSize(556);
		goalRigth.setSize(300);

		score1 = 0;
		score2 = 0;
		timeRemaning = Main.game.getTime();
		timerR.setInitialDelay(0);
		startTime = System.currentTimeMillis();
		timerR.start();
		timeLimit = Main.game.getTime();
		endOfGame = false;
		addKeyListener(new ButtonListener());

		// ronaldo
		addKeyListener(new RonaldoListener());
		r.setX(226);
		r.setY(651);
		r.setSpeed(4);
		r.setJump(14);
		//ronaldo = new ImageIcon("images/players/5P1.png");

		timerRonaldo = new Timer(gp.getDelay(), new RonaldoSmoothMovement());
		timerJumpRonaldo = new Timer(gp.getDelay(), new RonaldoSmoothJump());

		// neymar
		addKeyListener(new NeymarListener());
		l.setX(1064);
		l.setY(651);
		l.setSpeed(4);
		l.setJump(14);
		//neymar = new ImageIcon("images/players/3P2.png");
		timerNeymar = new Timer(gp.getDelay(), new NeymarSmoothMovement());
		timerJumpNeymar = new Timer(gp.getDelay(), new NeymarSmoothJump());


		if ( Main.game.getPlayer1() == 1 )
			ronaldo = new ImageIcon("images/players/1P1.png");
		if ( Main.game.getPlayer1() == 2 )
			ronaldo = new ImageIcon("images/players/2P1.png");
		if ( Main.game.getPlayer1() == 3 )
			ronaldo = new ImageIcon(("images/players/3P1.png"));
		if ( Main.game.getPlayer1() == 4 )
			ronaldo = new ImageIcon(("images/players/4P1.png"));
		if ( Main.game.getPlayer1() == 5 )
			ronaldo = new ImageIcon(("images/players/5P1.png"));

		// PLAYER 2
		if ( Main.game.getPlayer2() == 1 )
			neymar = new ImageIcon(("images/players/1P2.png"));
		if ( Main.game.getPlayer2() == 2 )
			neymar = new ImageIcon(("images/players/2P2.png"));
		if ( Main.game.getPlayer2() == 3 )
			neymar = new ImageIcon(("images/players/3P2.png"));
		if ( Main.game.getPlayer2() == 4 )
			neymar = new ImageIcon(("images/players/4P2.png"));
		if ( Main.game.getPlayer2() == 5 )
			neymar = new ImageIcon(("images/players/5P2.png"));

		double d = Math.random();
		if (  d < 0.33) {
			powerOne = 1;
			power = new ImageIcon("images/jumpUp.png");
		}

		else if ( d > 0.33  && d < 0.66) {
			power = new ImageIcon("images/speedUp.png");
			powerOne = 2;
		}

		else {
			power = new ImageIcon("images/pslowDown.png");;;;;;;;;;;;;;;;;;;;   ;;;;;;;
			powerOne = 3;
		}

		if ( Main.game.getBall() == 1) {
			ballimg = new ImageIcon (("images/balls/b1.png")); // NOI18N
		}
		else if ( Main.game.getBall() == 2) {
			ballimg = new ImageIcon (("images/balls/b2.png")); // NOI18N
		}
		else if (Main.game.getBall() == 3) {
			ballimg = new ImageIcon (("images/balls/b3.png")); // NOI18N
		}
		else if ( Main.game.getBall() == 4) {
			ballimg = new ImageIcon (("images/balls/b4.png")); // NOI18N
		}
		else if (Main.game.getBall() == 5) {
			ballimg = new ImageIcon (("images/balls/b5.png")); // NOI18N
		}
		else if ( Main.game.getBall() == 6) {
			ballimg = new ImageIcon (("images/balls/b6.png")); // NOI18N
		}


		// stadium
		stadium = new ImageIcon("images/stadium1.png");
		// ball
		timer = new Timer(gp.getDelay(), new BallListener());
		//ballimg = new ImageIcon ("images/ball.png");
		//  ballX = 800; //465;
		// ballY = 600; //265;
		ball.setBallX(650);
		ball.setBallY(240);
		ball.setSpeedY(10);
		ball.setSpeedX(0);
		elipse = new Ellipse2D.Double(ball.getBallX(),ball.getBallY(),45,45);
		rectL = new Rectangle.Double(l.getX(),l.getY(),80,80);
		rectR = new Rectangle.Double(r.getX(),r.getY(),80,80);
		rectObs = new Rectangle.Double(385,200, 10,200);
		rectObs1 = new Rectangle.Double(900,200, 10,200);

		if ( Main.game.isAI() ) {
			aiTimer = new Timer(50, new AIListener());
			aiTimer.start();
		}


		timer.start();

		//setBackground (Color.green);
		setPreferredSize (new Dimension(WIDTH, HEIGHT));
		setFocusable(true);  

		jLabel5 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jLabel6 = new javax.swing.JLabel();

		setBackground(new java.awt.Color(255, 255, 255));
		setForeground(new java.awt.Color(255, 255, 255));

		jButton1.setBackground(new java.awt.Color(255, 255, 0));
		jButton1.setText("MENU");
		jButton1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if ( jButton1.isEnabled() ){
					JFrame f = new PauseFrame();
					f.setVisible(true);
				}
			}  	
		});

		jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel5.setText("TEAM1   0 : 0  TEAM2");
		jLabel5.setForeground(new java.awt.Color(255, 255, 0));

		jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		if ( !Main.game.isTime )
			jLabel6.setText("BEST OF " + Main.game.getScoreLimit());
		else
			jLabel6.setText("Remaining Time: " + Main.game.getTime());
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

	public void paintComponent (Graphics page){
		super.paintComponent (page);
		stadium.paintIcon(this, page, 0, 0);


		// draw sides
		Graphics2D g1 = (Graphics2D) page;
		g1.setStroke(new BasicStroke(5));
		page.setColor(Color.BLACK);
		//page.drawRect((int)rectR.getX(), (int)rectR.getY(),(int) rectR.getWidth(), (int)rectR.getHeight());
		//page.drawOval((int)elipse.getX(), (int)elipse.getY(), (int)elipse.getWidth(), (int)elipse.getHeight());
		//page.drawRect((int)rectL.getX(), (int)rectL.getY(),(int) rectL.getWidth(), (int)rectL.getHeight());

		page.fillRoundRect(385,200, 10,200, 15, 15);
		page.fillRoundRect(900,200, 10,200, 15, 15);

		// add images
		//	rect
		power.paintIcon(this, page, powerUp.getX(), powerUp.getY());
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

				rndDirBall = 7-((int) (Math.random()*15));
				ball.setBallX(650);
				ball.setBallY(630);
				//if( rndDirBall == 0)
				ball.setSpeedX(rndDirBall);
				//	else
				//		ball.setSpeedX(7);
				ball.setBallY(0);


			}
		}
		public void keyTyped (KeyEvent event) {}
		public void keyReleased (KeyEvent event) {}
	}

	private class MouseEvent implements MouseListener{

		@Override
		public void mouseClicked(java.awt.event.MouseEvent arg0) {
			int x = arg0.getX();
			int y = arg0.getY();
			System.out.println(x + "  " + y);
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent arg0) {}

		@Override
		public void mouseExited(java.awt.event.MouseEvent arg0) {}

		@Override
		public void mousePressed(java.awt.event.MouseEvent arg0) {}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent arg0) {}

	}

	private class NeymarSmoothJump implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if ( l.getDirY() ){
				l.setY(l.getY()-l.getJump());

				if ( l.getJump()>= -11)
					l.setJump(l.getJump()-1);
			}
			if ( l.getY() >= 651 ){
				l.setDirY(false);
				l.setJump(14);
			}
		}
	}

	private class RonaldoSmoothJump implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if ( r.getDirY()){
				r.setY(r.getY()-r.getJump());
				if ( r.getJump() >= -11)
					r.setJump(r.getJump()-1);
			}
			if ( r.getY() >= 651 ){
				r.setDirY(false);
				r.setJump(14);
			}
		}
	}

	private class RonaldoListener implements KeyListener{
		public void keyPressed(KeyEvent event){
			switch (event.getKeyCode()){
			case KeyEvent.VK_W:
				if(!rectR.intersects(rectL)) 
					r.setDirY(true);
				//neymarY -= JUMP;
				jumpRonaldo();
				break;


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
	}//ImageListener*/

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

	private class AIListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(ai.timeToJump(ball, l)&&ai.timeToStop()){

				try {
					Robot robot = new Robot();

					// Simulate a mouse click
					//    robot.mousePress(InputEvent.BUTTON1_MASK);
					//   robot.mouseRelease(InputEvent.BUTTON1_MASK);

					// Simulate a key press
					robot.keyPress(KeyEvent.VK_UP);
					if(ai.timeToJump(ball, l)){

						while(ai.timeToLeft(ball, l))
						{

							robot.keyPress(KeyEvent.VK_LEFT);
							if(!ai.timeToLeft(ball, l)){
								robot.keyRelease(KeyEvent.VK_LEFT);
								ai.timeToRight(ball, l);
								break;
							}
							break;
						}
						while(ai.timeToRight(ball, l))
						{

							robot.keyPress(KeyEvent.VK_RIGHT);
							if(!ai.timeToRight(ball, l)){
								robot.keyRelease(KeyEvent.VK_RIGHT);
								ai.timeToLeft(ball, l);
								break;
							}
							break;
						}

					}
					robot.keyRelease(KeyEvent.VK_UP);

				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
			if(ai.timeToLeft(ball, l)&&ai.timeToStop()){
				try {
					Robot robot = new Robot();

					// Simulate a mouse click
					//    robot.mousePress(InputEvent.BUTTON1_MASK);
					//   robot.mouseRelease(InputEvent.BUTTON1_MASK);

					// Simulate a key press
					while(ai.timeToLeft(ball, l))
					{

						if(Math.abs(l.getX()-ball.getBallX())<5){
							ai.timeToRight(ball, l);
							break;
						}
						robot.keyPress(KeyEvent.VK_LEFT);
						if(!ai.timeToLeft(ball, l)){
							robot.keyRelease(KeyEvent.VK_LEFT);
							ai.timeToRight(ball, l);
							break;
						}
						break;
					}


				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
			if(ai.timeToRight(ball, l)&&ai.timeToStop()){
				try {
					Robot robot = new Robot();
					//robot.t
					// Simulate a mouse click
					//    robot.mousePress(InputEvent.BUTTON1_MASK);
					//   robot.mouseRelease(InputEvent.BUTTON1_MASK);

					// Simulate a key press
					while(ai.timeToRight(ball, l))
					{
						if(Math.abs(l.getX()-ball.getBallX())<5){
							ai.timeToLeft(ball, l);
							break;
						}
						robot.keyPress(KeyEvent.VK_RIGHT);
						if(!ai.timeToRight(ball, l)){
							robot.keyRelease(KeyEvent.VK_RIGHT);
							ai.timeToLeft(ball, l);
							break;
						}
						break;
					}

				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
		}
	}


	private class BallListener implements ActionListener{

		public void actionPerformed(ActionEvent event){
			gp.ballMotion(ball);
			elipse = new Ellipse2D.Double(ball.getBallX(),ball.getBallY(),45,45);
			rectR = new Rectangle.Double(r.getX(),r.getY(),80,80);
			rectL = new Rectangle.Double(l.getX(),l.getY(),80,80);

			if(gp.ballCollision(elipse, rectObs)){
				
				if(ball.getSpeedX() > 0){

					ball.setSpeedY(-ball.getSpeedY());
					ball.setSpeedX(-ball.getSpeedX());					
				}
				else if(ball.getSpeedX() < 0){
					ball.setSpeedY(-ball.getSpeedY());
					ball.setSpeedX(-ball.getSpeedX());					
				}

			}

			if(gp.ballCollision(elipse, rectObs1)){
			
				if(ball.getSpeedX() > 0){

					ball.setSpeedY(-ball.getSpeedY());
					ball.setSpeedX(-ball.getSpeedX());					
				}
				else if(ball.getSpeedX() < 0){
					ball.setSpeedY(-ball.getSpeedY());
					ball.setSpeedX(-ball.getSpeedX());					
				}

			}


			/*
			if ( Main.game.isMainMenuPressed() ) {
				//ball.setSpeedX(0);
				//ball.setSpeedY(0);
				//timer.stop();
				//timerNeymar.stop();
				//timerJumpNeymar.stop();
				//timerRonaldo.stop();
				//timerJumpRonaldo.stop();
			}*/


			if ( endOfGame ){
				ball.setSpeedX(0);
				ball.setSpeedY(0);
			}	
			else{
				if(gp.checkGoal1(ball, goalLeft)){
					ball.setSpeedX(2);
					ball.setSpeedY(2);
					if( ball.getBallX() > 1260 || ball.getBallY() > 730 ){
						ball.setSpeedX(0);
						ball.setSpeedY(0);
					}

					// UPTADE SCOREBOARD
					if (ball.getBallX() > 1192 && ball.getBallY() > 552 && ball.getBallY() < 745 ){
						teamscore1 += 1;
						System.out.println(teamscore1 +"  "+ Main.game.getScoreLimit());
						if ( !Main.game.isTime ){
							if ( Main.game.getScoreLimit() == teamscore1 || Main.game.getScoreLimit() == teamscore2 ){
								JFrame frame = new JFrame();
								if ( teamscore1 > teamscore2 ){
									JOptionPane.showMessageDialog(frame, "Team1 WON!");
									if ( Main.game.getStage() == 8 )
										Main.game.setStage(4);
									else if ( Main.game.getStage() == 4 )
										Main.game.setStage(2);
									else if ( Main.game.getStage() == 2 )
										Main.game.setStage(1);
								}
								else if ( teamscore1 < teamscore2 ){
									JOptionPane.showMessageDialog(frame, "Team2 WON!");
									Main.game.setStage(-1);
								}

								if ( Main.game.isConti() ){
									GameWindow.fra.dispose();
									GameWindow.fra.dispatchEvent(new WindowEvent(GameWindow.fra, WindowEvent.WINDOW_CLOSING));
									Main.frame.setVisible(true);
									ball.setSpeedX(0);
									ball.setSpeedY(0);
								}
								if ( Main.game.isMultiplayer() ){
									GameWindow.fra.dispose();
									GameWindow.fra.dispatchEvent(new WindowEvent(GameWindow.fra, WindowEvent.WINDOW_CLOSING));
									Main.frame.setVisible(true);
									ball.setSpeedX(0);
									ball.setSpeedY(0);
								}
								if ( Main.game.isTraining() ){
									GameWindow.fra.dispose();
									GameWindow.fra.dispatchEvent(new WindowEvent(GameWindow.fra, WindowEvent.WINDOW_CLOSING));
									Main.frame.setVisible(true);
									ball.setSpeedX(0);
									ball.setSpeedY(0);
								}
								endOfGame = true;
							}
						}
						r.setX(226);
						r.setY(651);
						l.setX(1064);
						l.setY(651);
						r.setSpeed(4);
						r.setJump(14);
						l.setSpeed(4);
						l.setJump(14);
						jLabel5.setText("TEAM1   " + teamscore1 +" : " + teamscore2 + "  TEAM2");
						int px = (int)((Math.random()*894)+202);
						int py = (int)((Math.random()*90)+412);
						double d = Math.random();
						if (  d < 0.33) {
							powerOne = 1;
							power = new ImageIcon("images/jumpUp.png");
							powerUp.setX(px);
							powerUp.setY(py);
						}

						else if ( d > 0.33  && d < 0.66) {
							power = new ImageIcon("images/speedUp.png");
							powerOne = 2;
							powerUp.setX(px);
							powerUp.setY(py);
						}

						else {
							power = new ImageIcon("images/pslowDown.png");;;;;;;;;;;;;;;;;;;;;;;;;;;
							powerOne = 3;
							powerUp.setX(px);
							powerUp.setY(py);
						}
						rndDirBall = 7-((int) (Math.random()*15));
						ball.setBallX(650);
						ball.setBallY(630);
						ball.setSpeedX(rndDirBall);
						ball.setBallY(0);
					}
				}

				if(gp.checkGoal2(ball, goalLeft)){
					ball.setSpeedX(-2);
					ball.setSpeedY(2);
					if( ball.getBallX()<10 || ball.getBallY() > 740 ){
						ball.setSpeedX(0);
						ball.setSpeedY(0);
					}

					// UPTADE SCOREBOARD
					if ( ball.getBallX() < 85 && ball.getBallY() > 552 && ball.getBallY() < 745 ){
						teamscore2 += 1;
						System.out.println(teamscore2 +"  "+ Main.game.getScoreLimit());
						if ( !Main.game.isTime ){
							if ( Main.game.getScoreLimit() == teamscore1 || Main.game.getScoreLimit() == teamscore2 ){
								JFrame frame = new JFrame();
								if ( teamscore1 > teamscore2 ){
									JOptionPane.showMessageDialog(frame, "Team1 WON!");
									if ( Main.game.getStage() == 8 )
										Main.game.setStage(4);
									else if ( Main.game.getStage() == 4 )
										Main.game.setStage(2);
									else if ( Main.game.getStage() == 2 )
										Main.game.setStage(1);
								}
								else if ( teamscore1 < teamscore2 ){
									JOptionPane.showMessageDialog(frame, "Team2 WON!");
									Main.game.setStage(-1);
								}


								GameWindow.fra.getContentPane().removeAll();
								if ( Main.game.isConti() ){
									GameWindow.fra.dispose();
									GameWindow.fra.dispatchEvent(new WindowEvent(GameWindow.fra, WindowEvent.WINDOW_CLOSING));
									Main.frame.setVisible(true);
									ball.setSpeedX(0);
									ball.setSpeedY(0);	
								}
								if ( Main.game.isMultiplayer() ){
									GameWindow.fra.dispose();
									Main.game.setMultiplayer(false);
									GameWindow.fra.dispatchEvent(new WindowEvent(GameWindow.fra, WindowEvent.WINDOW_CLOSING));
									Main.frame.setVisible(true);
									ball.setSpeedX(0);
									ball.setSpeedY(0);
								}
								if ( Main.game.isTraining() ){
									GameWindow.fra.dispose();
									Main.game.setTraining(false);
									GameWindow.fra.dispatchEvent(new WindowEvent(GameWindow.fra, WindowEvent.WINDOW_CLOSING));
									Main.frame.setVisible(true);
									ball.setSpeedX(0);
									ball.setSpeedY(0);	
								}

							}						
						}
						r.setX(226);
						r.setY(651);
						l.setX(1064);
						l.setY(651);
						r.setSpeed(4);
						r.setJump(14);
						l.setSpeed(4);
						l.setJump(14);
						jLabel5.setText("TEAM1   " + teamscore1 +" : " + teamscore2 + "  TEAM2");
						int px = (int)((Math.random()*894)+202);
						int py = (int)((Math.random()*90)+412);
						double d = Math.random();
						if (  d < 0.33) {
							powerOne = 1;
							power = new ImageIcon("images/jumpUp.png");
							powerUp.setX(px);
							powerUp.setY(py);
						}

						else if ( d > 0.33  && d < 0.66) {
							power = new ImageIcon("images/speedUp.png");
							powerOne = 2;
							powerUp.setX(px);
							powerUp.setY(py);
						}

						else {
							power = new ImageIcon("images/pslowDown.png");;;;;;;;;;;;;;;;;;;;   ;;;;;;;
							powerOne = 3;
							powerUp.setX(px);
							powerUp.setY(py);
						}
						rndDirBall = 7-((int) (Math.random()*15));
						ball.setBallX(650);
						ball.setBallY(630);
						ball.setSpeedX(rndDirBall);
						ball.setBallY(0);

					}// speedX speedY == 0
				}// check goal 2
			}// END OF GAME
			if ( Main.game.isTime && timeRemaning == timeLimit ){
				JFrame frame = new JFrame();
				if ( teamscore1 > teamscore2 ){
					JOptionPane.showMessageDialog(frame, "Team1 WON!");
					if ( Main.game.getStage() == 8 )
						Main.game.setStage(4);
					else if ( Main.game.getStage() == 4 )
						Main.game.setStage(2);
					else if ( Main.game.getStage() == 2 )
						Main.game.setStage(1);
				}
				else if ( teamscore1 < teamscore2 ){
					JOptionPane.showMessageDialog(frame, "Team2 WON!");
					Main.game.setStage(-1);
				}
				else{
					JOptionPane.showMessageDialog(frame, "DRAW!");
					Main.game.setStage(0);
				}

				if ( Main.game.isConti() ){
					GameWindow.fra.dispatchEvent(new WindowEvent(GameWindow.fra, WindowEvent.WINDOW_CLOSING));
					Main.frame.setVisible(true);
					ball.setSpeedX(0);
					ball.setSpeedY(0);
				}
				if ( Main.game.isMultiplayer() ){
					GameWindow.fra.dispatchEvent(new WindowEvent(GameWindow.fra, WindowEvent.WINDOW_CLOSING));
					Main.frame.setVisible(true);
					ball.setSpeedX(0);
					ball.setSpeedY(0);
				}
				if ( Main.game.isTraining() ){
					GameWindow.fra.dispatchEvent(new WindowEvent(GameWindow.fra, WindowEvent.WINDOW_CLOSING));
					Main.frame.setVisible(true);
					ball.setSpeedX(0);
					ball.setSpeedY(0);

				}
				endOfGame = true;
			}


			// neymar & ball collision
			if ( gp.playerLCollision(elipse, rectL))
			{
				lastHit = false;
				sm.playKickSound();

				if(!l.getDirX() && ball.getSpeedX() < 0 && elipse.getX() < rectR.getX()) {


					ball.setBallX(ball.getBallX());
					ball.setBallY(ball.getBallY());

					ball.setSpeedX((ball.getSpeedX()));
					ball.setSpeedY((ball.getSpeedY()));


					if(ball.getSpeedX() < 15 && ball.getSpeedX() > -15)
						ball.setSpeedX(ball.getSpeedX()-4);


					elipse = new Ellipse2D.Double(ball.getBallX(),ball.getBallY(),45,45);
					rectL = new Rectangle.Double(l.getX(),l.getY(),80,80);
				}

				else if(!l.getDirX() && ball.getSpeedX() > 0) {


					ball.setBallX(ball.getBallX()-7);
					ball.setBallY(ball.getBallY()-7);

					ball.setSpeedX(-(ball.getSpeedX()));
					ball.setSpeedY(-(ball.getSpeedY()));


					if(ball.getSpeedX() < 15 && ball.getSpeedX() > -15)
						ball.setSpeedX(ball.getSpeedX()-4);


					elipse = new Ellipse2D.Double(ball.getBallX(),ball.getBallY(),45,45);
					rectL = new Rectangle.Double(l.getX(),l.getY(),80,80);
				}

				else if(l.getDirX() && elipse.getX() > rectL.getX() && ball.getSpeedX() < 0)
				{
					/**buradayam yaddan cixmasin*/

					ball.setBallX(ball.getBallX()+7);
					ball.setBallY(ball.getBallY()+7);

					ball.setSpeedX(-(ball.getSpeedX()));
					ball.setSpeedY(-(ball.getSpeedY()));


					if(ball.getSpeedX() < 15 && ball.getSpeedX() > -15)
						ball.setSpeedX(ball.getSpeedX()-2);


					elipse = new Ellipse2D.Double(ball.getBallX(),ball.getBallY(),45,45);
					rectL = new Rectangle.Double(l.getX(),l.getY(),80,80);
				}

				else if(l.getDirX() && elipse.getX() > rectL.getX() && ball.getSpeedX() > 0)
				{

					ball.setBallX(ball.getBallX()+7);
					ball.setBallY(ball.getBallY()+7);

					ball.setSpeedX((ball.getSpeedX()));
					ball.setSpeedY((ball.getSpeedY()));


					if(ball.getSpeedX() < 15 && ball.getSpeedX() > -15)
						ball.setSpeedX(ball.getSpeedX()+2);


					elipse = new Ellipse2D.Double(ball.getBallX(),ball.getBallY(),45,45);
					rectL = new Rectangle.Double(l.getX(),l.getY(),80,80);

				}

				else if(l.getDirX() && elipse.getX() < rectL.getX() && ball.getSpeedX() > 0)
				{

					ball.setBallX(ball.getBallX()-7);
					ball.setBallY(ball.getBallY()-7);

					ball.setSpeedX(-(ball.getSpeedX()));
					ball.setSpeedY(-(ball.getSpeedY()));


					if(ball.getSpeedX() < 15 && ball.getSpeedX() > -15)
						ball.setSpeedX(ball.getSpeedX()-2);


					elipse = new Ellipse2D.Double(ball.getBallX(),ball.getBallY(),45,45);
					rectL = new Rectangle.Double(l.getX(),l.getY(),80,80);

				}

				else if(elipse.getY() < rectL.getY() && ball.getSpeedY() > 0)
				{
					ball.setBallX(ball.getBallX());//
					ball.setBallY(ball.getBallY()-7);//
					ball.setSpeedX(-(ball.getSpeedX()+5));
					ball.setSpeedY(-(ball.getSpeedY()));

					ball.setSpeedY(-7 +(ball.getSpeedY()));

					if(ball.getSpeedY() < 15 && ball.getSpeedY() > -15)
						ball.setSpeedY(ball.getSpeedY()-2);

				}

				else if(!l.getDirX() && elipse.getX() > rectL.getX() && ball.getSpeedX() < 0)
				{
					ball.setBallX(ball.getBallX());//
					ball.setBallY(ball.getBallY());//
					ball.setSpeedX(-(ball.getSpeedX()));
					ball.setSpeedY(-(ball.getSpeedY()));

					ball.setSpeedY(-7 +(ball.getSpeedY()));

					if(ball.getSpeedX() < 15 && ball.getSpeedX() > -15)
						ball.setSpeedX(ball.getSpeedX()+2);

				}

				else if (ball.getSpeedX() == 0 && !l.getDirX())
				{
					ball.setBallX(ball.getBallX()-5);//
					ball.setBallY(ball.getBallY());//
					ball.setSpeedX(-7);

					if(ball.getSpeedX() < 15 && ball.getSpeedX() > -15)
						ball.setSpeedX(ball.getSpeedX()+2);

				}

				else if (ball.getSpeedX() == 0 && l.getDirX())
				{
					ball.setBallX(ball.getBallX()+5);//
					ball.setBallY(ball.getBallY());//
					ball.setSpeedX(+7);

					if(ball.getSpeedX() < 15 && ball.getSpeedX() > -15)
						ball.setSpeedX(ball.getSpeedX()+2);

				}

			}



			if ( powerOne == 1) {
				if(powerUp.getX() <= ball.getBallX()+50
						&& powerUp.getY() <= ball.getBallY()+50&&
						powerUp.getX() >= ball.getBallX()-50
						&& powerUp.getY() >= ball.getBallY()-50
						){
					//ronaldo po
					if(lastHit) {
						powerUp.jumpUp(r);
					}
					else
						powerUp.jumpUp(l);
				}

			}
			else if ( powerOne == 2 ) {
				if(powerUp.getX() <= ball.getBallX()+50
						&& powerUp.getY() <= ball.getBallY()+50&&
						powerUp.getX() >= ball.getBallX()-50
						&& powerUp.getY() >= ball.getBallY()-50
						){
					//ronaldo po
					if(lastHit) {
						powerUp.speedUp(r);
					}
					else
						powerUp.speedUp(l);
				}

			}

			else if ( powerOne == 3 ) {
				if(powerUp.getX() <= ball.getBallX()+50
						&& powerUp.getY() <= ball.getBallY()+50&&
						powerUp.getX() >= ball.getBallX()-50
						&& powerUp.getY() >= ball.getBallY()-50
						){
					//ronaldo po
					if(lastHit) {
						powerUp.speedDown(l);
					}
					else
						powerUp.speedDown(r);
				}

			}

			if(ball.getBallY() < 0) {
				//	ball.setBallY(100);
				//ball.setSpeedY(-ball.getSpeedY());
			}

			if(gp.checkGoal1(ball, goalLeft)){
				ball.setSpeedX(2);
				ball.setSpeedY(2);
				if(ball.getBallX()>1200 && ball.getBallY() > 700 ){
					ball.setSpeedX(0);
					ball.setSpeedY(0);
				}
			}

			if(gp.checkGoal2(ball, goalLeft)){
				ball.setSpeedX(-2);
				ball.setSpeedY(2);
				if(ball.getBallX()<80 && ball.getBallY() > 700 ){
					ball.setSpeedX(0);
					ball.setSpeedY(0);
				}
			}




			// ronaldo & ball collision
			if ( gp.playerRCollision(elipse, rectR))
			{
				lastHit = true;
				sm.playKickSound();
				if(r.getDirX() && ball.getSpeedX() > 0 && elipse.getX() > rectR.getX())
				{
					ball.setBallX(ball.getBallX());
					ball.setBallY(ball.getBallY());
					ball.setSpeedX((ball.getSpeedX()));
					ball.setSpeedY((ball.getSpeedY()));
					

					if(ball.getSpeedX() < 15 && ball.getSpeedX() > -15)
						ball.setSpeedX(ball.getSpeedX()+4);

					elipse = new Ellipse2D.Double(ball.getBallX(),ball.getBallY(),45,45);
					rectR = new Rectangle.Double(r.getX(),r.getY(),80,80);
				}


				else if(r.getDirX() && ball.getSpeedX() < 0)
				{
					ball.setBallX(ball.getBallX()+7);//
					ball.setBallY(ball.getBallY()+7);//
					ball.setSpeedX(-(ball.getSpeedX()));
					ball.setSpeedY(-(ball.getSpeedY()));
					

					ball.setSpeedY(-7 +(ball.getSpeedY()));

					if(ball.getSpeedX() < 15 && ball.getSpeedX() > -15)
						ball.setSpeedX(ball.getSpeedX()+4);


					elipse = new Ellipse2D.Double(ball.getBallX(),ball.getBallY(),45,45);
					rectR = new Rectangle.Double(r.getX(),r.getY(),80,80);

				}

				else if(!r.getDirX() && elipse.getX() < rectR.getX() && ball.getSpeedX() > 0)
				{
					

					ball.setBallX(ball.getBallX());//
					ball.setBallY(ball.getBallY());//
					ball.setSpeedX(-(ball.getSpeedX()));
					ball.setSpeedY(-(ball.getSpeedY()));
					

					ball.setSpeedY(-7 +(ball.getSpeedY()));

					if(ball.getSpeedX() < 15 && ball.getSpeedX() > -15)
						ball.setSpeedX(ball.getSpeedX()+4);

					elipse = new Ellipse2D.Double(ball.getBallX(),ball.getBallY(),45,45);
					rectR = new Rectangle.Double(r.getX(),r.getY(),80,80);
				}

				else if(!r.getDirX() && elipse.getX() < rectR.getX() && ball.getSpeedX() < 0)
				{

					ball.setBallX(ball.getBallX());//
					ball.setBallY(ball.getBallY());//
					ball.setSpeedX((ball.getSpeedX()));
					ball.setSpeedY((ball.getSpeedY()));

					ball.setSpeedY(-7 +(ball.getSpeedY()));

					if(ball.getSpeedX() < 15 && ball.getSpeedX() > -15)
						ball.setSpeedX(ball.getSpeedX()-4);

				}

				else if(!r.getDirX() && elipse.getX() > rectR.getX() && ball.getSpeedX() < 0)
				{
					ball.setBallX(ball.getBallX());//
					ball.setBallY(ball.getBallY());//
					ball.setSpeedX(-(ball.getSpeedX()));
					ball.setSpeedY(-(ball.getSpeedY()));

					ball.setSpeedY(-7 +(ball.getSpeedY()));

					if(ball.getSpeedX() < 15 && ball.getSpeedX() > -15)
						ball.setSpeedX(ball.getSpeedX()+2);

				}

				else if(elipse.getY() < rectR.getY() && ball.getSpeedY() > 0)
				{
					ball.setBallX(ball.getBallX());//
					ball.setBallY(ball.getBallY()-7);//
					ball.setSpeedX(-(ball.getSpeedX()-5));
					ball.setSpeedY(-(ball.getSpeedY()));

					ball.setSpeedY(-7 +(ball.getSpeedY()));

					if(ball.getSpeedY() < 15 && ball.getSpeedY() > -15)
						ball.setSpeedY(ball.getSpeedY()-2);

				}

				else if(r.getDirX() && elipse.getX() < rectR.getX() && ball.getSpeedX() > 0)
				{
					ball.setBallX(ball.getBallX());//
					ball.setBallY(ball.getBallY());//
					ball.setSpeedX(-(ball.getSpeedX()));
					ball.setSpeedY(-(ball.getSpeedY()));

					ball.setSpeedY(-7 +(ball.getSpeedY()));

					if(ball.getSpeedX() < 15 && ball.getSpeedX() > -15)
						ball.setSpeedX(ball.getSpeedX()+2);

				}
				else if (ball.getSpeedX() == 0 && r.getDirX())
				{
					ball.setBallX(ball.getBallX());//
					ball.setBallY(ball.getBallY());//
					ball.setSpeedX(4);
					ball.setSpeedY(2);

					if(ball.getSpeedX() < 15 && ball.getSpeedX() > -15)
						ball.setSpeedX(ball.getSpeedX()+2);

				}

				else if (ball.getSpeedX() == 0 && !r.getDirX())
				{
					ball.setBallX(ball.getBallX()-5);//
					ball.setBallY(ball.getBallY());//
					ball.setSpeedX(-7);

					if(ball.getSpeedX() < 15 && ball.getSpeedX() > -15)
						ball.setSpeedX(ball.getSpeedX()+2);

				}


			}

			// check sides
			else if (gp.checkXSides(ball)){
				ball.setSpeedX(-ball.getSpeedX());


			}
			else if (gp.checkYSides(ball)){
				if(ball.getSpeedY()>8) {
					if(700<= ball.getBallY() && ball.getSpeedY() > 0 || 55>= ball.getBallY() && ball.getSpeedY()<0 )
						ball.setSpeedY(-ball.getSpeedY());
					if(ball.getBallY() <= 55)
						ball.setBallY(ball.getBallY()+90);
					if(ball.getBallY() >= 710 && ball.getSpeedY() != 0){
						ball.setBallY(ball.getBallY()-20);
						ball.setSpeedY(ball.getSpeedY()-1);
					}
				}
				else {
					if(700 <= ball.getBallY()&& ball.getSpeedY()>0 || 55>= ball.getBallY() && ball.getSpeedY()<0)
						ball.setSpeedY(0);
				}

			}



			repaint();	
		}
	}//BallListener
	private class GravityListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(ball.getBallY() <= 690){
				ball.setSpeedY(ball.getSpeedY()+gravity);
				if( ball.getSpeedY() > maxVelocity)
					ball.setSpeedY(maxVelocity);
				//	ball.setBallY(y);

				if(ball.getSpeedY() <= 4 )//&& ball.getBallY() < 570)
					ball.setSpeedY(ball.getSpeedY()+2); 
			}

		}
	}

	private void updateClock() {
		Date elapsed = new Date(System.currentTimeMillis() - startTime);
		timeRemaning = Integer.parseInt(date.format(elapsed));
		if ( Main.game.isTime )
			jLabel6.setText("Remaining Time: " + (timeLimit-timeRemaning) );
		repaint();
	}
	private class ClockListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			updateClock();
			repaint();
		}
	}

}//class	