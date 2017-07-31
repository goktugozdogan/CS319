package headBall;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GameWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	public static JFrame fra;
	MainMenuP mmp;
	MultipalyerP mp;
	SinglePlayerP sp;
	StadiumBallP sbp;
	KeyBoardP kp;
	ContinueP cp;
	SoundP soundp;
	SoundManage sm;
	
	public GameWindow(){
		super ();
		sm = new SoundManage();
	    sm.playSound();
		setTitle ("Head Ball");
		setVisible(true);
		setResizable(false); 
		
		mmp = new MainMenuP();
		mp = new MultipalyerP();
		sp= new SinglePlayerP();
		sbp = new StadiumBallP();
		kp = new KeyBoardP();
		cp = new ContinueP();
		soundp = new SoundP();
		/*
		fra = new JFrame();
		fra.setVisible(true);
		*/
		// opening panel is MainMenuPanel
		setPreferredSize(new Dimension(640,412));
		add(mmp);
		repaint();
		pack();
		
	} // end of constructor
	
	//*****************************************************************
	//		PRIVATE CLASSES		***************************************
	//*****************************************************************
	private class MainMenuP extends JPanel implements ActionListener{

		private static final long serialVersionUID = 1L;
		// Variables declaration - do not modify                     
	    private javax.swing.JButton jButton1;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JToggleButton jToggleButton1;
	    private javax.swing.JToggleButton jToggleButton2;
	    private javax.swing.JToggleButton jToggleButton3;
	    // End of variables declaration

	    public MainMenuP() {
	        initComponents();
	    }
                       
	    private void initComponents() {

	        jToggleButton1 = new javax.swing.JToggleButton();
	        jToggleButton2 = new javax.swing.JToggleButton();
	        jToggleButton3 = new javax.swing.JToggleButton();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jButton1 = new javax.swing.JButton();
	        ButtonGroup group = new ButtonGroup();
	        
	        group.add(jToggleButton1);
	        group.add(jToggleButton2);
	        group.add(jToggleButton3);

	        setBackground(new java.awt.Color(255, 255, 255));
	        setForeground(new java.awt.Color(255, 255, 255));
	        
	        jToggleButton1.setSelected(true);
	    	jToggleButton2.setBackground(Color.gray);
	    	jToggleButton3.setBackground(Color.gray);
	    	
	        jToggleButton1.setText("Play");
	        jToggleButton1.addActionListener(this);

	        jToggleButton2.setText("Customize");
	        jToggleButton2.addActionListener(this);

	        jToggleButton3.setText("Extras");
	        jToggleButton3.addActionListener(this);
	    	
	    	jLabel1.setIcon(new javax.swing.ImageIcon("images/champions.png")); // NOI18N
	    	jLabel1.addMouseListener(new MouseListener() {
	            public void mouseClicked(MouseEvent e) {
	            	jLabel1(e);
	            }
				@Override
				public void mouseEntered(MouseEvent arg0) {}
				@Override
				public void mouseExited(MouseEvent arg0) {}
				@Override
				public void mousePressed(MouseEvent arg0) {}
				@Override
				public void mouseReleased(MouseEvent arg0) {}
	        });
	        jLabel2.setIcon(new javax.swing.ImageIcon("images/continue.jpg")); // NOI18N
	        jLabel2.addMouseListener(new MouseListener() {
	            public void mouseClicked(MouseEvent e) {
	            	jLabel2(e);
	            }
				@Override
				public void mouseEntered(MouseEvent arg0) {}
				@Override
				public void mouseExited(MouseEvent arg0) {}
				@Override
				public void mousePressed(MouseEvent arg0) {}
				@Override
				public void mouseReleased(MouseEvent arg0) {}
	        });
	        jLabel3.setIcon(new javax.swing.ImageIcon("images/multiplayer.jpg")); // NOI18N
	        jLabel3.addMouseListener(new MouseListener() {
	            public void mouseClicked(MouseEvent e) {
	            	jLabel3(e);
	            }
				@Override
				public void mouseEntered(MouseEvent arg0) {}
				@Override
				public void mouseExited(MouseEvent arg0) {}
				@Override
				public void mousePressed(MouseEvent arg0) {}
				@Override
				public void mouseReleased(MouseEvent arg0) {}
	        });
	        jLabel4.setIcon(new javax.swing.ImageIcon("images/training.jpg")); // NOI18N
	        jLabel4.addMouseListener(new MouseListener() {
	            public void mouseClicked(MouseEvent e) {
	            	jLabel4(e);
	            }
				@Override
				public void mouseEntered(MouseEvent arg0) {}
				@Override
				public void mouseExited(MouseEvent arg0) {}
				@Override
				public void mousePressed(MouseEvent arg0) {}
				@Override
				public void mouseReleased(MouseEvent arg0) {}
	        });

	        jButton1.setText("Exit");
	        jButton1.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Main.frame.dispose();	
				}	
	        });

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(25, 25, 25)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                        .addGroup(layout.createSequentialGroup()
	                            .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGroup(layout.createSequentialGroup()
	                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGroup(layout.createSequentialGroup()
	                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                .addGap(0, 25, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(25, 25, 25)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jToggleButton1)
	                    .addComponent(jToggleButton2)
	                    .addComponent(jToggleButton3))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addComponent(jButton1)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	    }
	    
	    public void actionPerformed(ActionEvent ev){
	    	if ( jToggleButton1.isSelected() ) {
	        	jToggleButton1.setBackground(Color.yellow);
	        	jToggleButton2.setBackground(Color.gray);
	        	jToggleButton3.setBackground(Color.gray);
	        	
	        	jLabel1.setIcon(new javax.swing.ImageIcon("images/champions.png")); // NOI18N
	            jLabel2.setIcon(new javax.swing.ImageIcon("images/continue.jpg")); // NOI18N
	            jLabel3.setIcon(new javax.swing.ImageIcon("images/multiplayer.jpg")); // NOI18N
	            jLabel4.setIcon(new javax.swing.ImageIcon("images/training.jpg")); // NOI18N
	        }
	    	
	    	if ( jToggleButton2.isSelected() ) {
	    		jToggleButton1.setBackground(Color.gray);
	        	jToggleButton2.setBackground(Color.yellow);
	        	jToggleButton3.setBackground(Color.gray);
	        	
	        	jLabel1.setIcon(new javax.swing.ImageIcon("images/setting.jpg")); // NOI18N
	            jLabel2.setIcon(new javax.swing.ImageIcon("images/sound.jpg")); // NOI18N
	            jLabel3.setIcon(new javax.swing.ImageIcon("images/stadium.jpg")); // NOI18N
	            jLabel4.setIcon(new javax.swing.ImageIcon("images/keyboard.jpg")); // NOI18N
	        }
	    	
	    	if ( jToggleButton3.isSelected() ) {
	    		jToggleButton1.setBackground(Color.gray);
	        	jToggleButton2.setBackground(Color.gray);
	        	jToggleButton3.setBackground(Color.yellow);
	        	
	    		jLabel1.setIcon(new javax.swing.ImageIcon("images/cre1.png")); // NOI18N
	            jLabel2.setIcon(new javax.swing.ImageIcon("images/asd.jpg")); // NOI18N
	            jLabel3.setIcon(new javax.swing.ImageIcon("images/cre2.png")); // NOI18N
	            jLabel4.setIcon(new javax.swing.ImageIcon("images/inst.jpg")); // NOI18N
	        }
	    	
	    	repaint();
	    }
	    
	    // TOP LEFT
	    public void jLabel1(MouseEvent e){
	    	
	    	if ( jToggleButton1.isSelected()){
	    		Main.game.setChampions(true);
	    		Main.game.setMainMenuPanel(false);
	        	
				mmp.setVisible(false);
				mp.setVisible(false);
				sp.setVisible(true);
				sbp.setVisible(false);
				kp.setVisible(false);
				cp.setVisible(false);
				soundp.setVisible(false);
				
				Main.frame.setPreferredSize(new Dimension(640,428));
				Main.frame.add(sp);
	    		Main.frame.repaint();
	    		Main.frame.pack();
	    	}
	    	if ( jToggleButton2.isSelected()){
	    		Main.game.setSettings(true);
	    		Main.game.setMainMenuPanel(false);	
	        	
				mmp.setVisible(false);
				mp.setVisible(false);
				sp.setVisible(false);
				sbp.setVisible(false);
				kp.setVisible(false);
				 
				cp.setVisible(false);
				soundp.setVisible(true);
				
				Main.frame.setPreferredSize(new Dimension(619, 450));
				Main.frame.add(soundp);
	    		Main.frame.repaint();
	    		Main.frame.pack();
	    	}
	    	if ( jToggleButton3.isSelected()){
	    		Main.game.setCredits(true);
	    		Main.game.setMainMenuPanel(false);
	    	}
	    	
	    	repaint();
	    }
	    
	    // TOP RIGHT
	    public void jLabel2(MouseEvent e){	    	
	    	if ( jToggleButton1.isSelected()){
	    		if ( Main.game.seasonCreated ){
	    			Main.game.setConti(true);
	    			Main.game.setMainMenuPanel(false);

					mmp.setVisible(false);
					mp.setVisible(false);
					sp.setVisible(false);
					sbp.setVisible(false);
					kp.setVisible(false);
					 
					cp.setVisible(true);
					soundp.setVisible(false);
					
					Main.frame.setPreferredSize(new Dimension(789, 526));
					Main.frame.add(cp);
		    		Main.frame.repaint();
		    		Main.frame.pack();
	    		}
	    		else{
	    			JFrame frame = new JFrame();
	    			if ( Main.game.getStage() == -1 )
	    				JOptionPane.showMessageDialog(frame, "You are a looser! Start a new season.");
	    			else if ( Main.game.getStage() == 1 )
	    				JOptionPane.showMessageDialog(frame, "You are the CHAMPION!!!");
	    			else
	    				JOptionPane.showMessageDialog(frame, "There is no save game to continue!");
	    		}
	    		
	    	}
	    	if ( jToggleButton2.isSelected()){
	    		Main.game.setSound(true);
	    		Main.game.setMainMenuPanel(false);
	        	
	        	mmp.setVisible(false);
				mp.setVisible(false);
				sp.setVisible(false);
				sbp.setVisible(false);
				kp.setVisible(false);
				 
				cp.setVisible(false);
				soundp.setVisible(true);
				
				Main.frame.setPreferredSize(new Dimension(619, 450));
				Main.frame.add(soundp);
	    		Main.frame.repaint();
	    		Main.frame.pack();
	    	}
	    	if ( jToggleButton3.isSelected()){
	    		// do nothing
	    	}
	    	repaint();
	    }
	    
	    // BOTTOM LEFT
	    public void jLabel3(MouseEvent e){	    	
	    	if ( jToggleButton1.isSelected()){
	    		Main.game.setMultiplayer(true);
	        	Main.game.setMainMenuPanel(false);
	        	
				mmp.setVisible(false);
				mp.setVisible(true);
				sp.setVisible(false);
				sbp.setVisible(false);
				kp.setVisible(false);
				 
				cp.setVisible(false);
				soundp.setVisible(false);
				
				Main.frame.setPreferredSize(new Dimension(640,428));
				Main.frame.add(mp);
	    		Main.frame.repaint();
	    		Main.frame.pack();
	    	}
	    	if ( jToggleButton2.isSelected()){
	    		Main.game.setBallStadium(true);
	        	Main.game.setMainMenuPanel(false);

				mmp.setVisible(false);
				mp.setVisible(false);
				sp.setVisible(false);
				sbp.setVisible(true);
				kp.setVisible(false);
				 
				cp.setVisible(false);
				soundp.setVisible(false);
				
				Main.frame.setPreferredSize(new Dimension(640,428));
				Main.frame.add(sbp);
	    		Main.frame.repaint();
	    		Main.frame.pack();
	    	}
	    	if ( jToggleButton3.isSelected()){
	    		Main.game.setCredits(true);
	        	Main.game.setMainMenuPanel(false);
	    	}
	    	
	    	repaint();
	    }
	    
	    // BOTTOM RIGHT
	    public void jLabel4(MouseEvent e){	    	
	    	if ( jToggleButton1.isSelected()){
	    		Main.game.setTraining(true);
	        	Main.game.setMainMenuPanel(false);
	        	
				mmp.setVisible(false);
				mp.setVisible(false);
				sp.setVisible(true);
				sbp.setVisible(false);
				kp.setVisible(false);
				 
				cp.setVisible(false);
				soundp.setVisible(false);
				
				Main.frame.setPreferredSize(new Dimension(640,428));
				Main.frame.add(sp);
	    		Main.frame.repaint();
	    		Main.frame.pack();
	    	}
	    	if ( jToggleButton2.isSelected()){
	    		Main.game.setKeyboard(true);
	        	Main.game.setMainMenuPanel(false);
	        	
	        	mmp.setVisible(false);
				mp.setVisible(false);
				sp.setVisible(false);
				sbp.setVisible(false);
				kp.setVisible(true);
				 
				cp.setVisible(false);
				soundp.setVisible(false);
				
				Main.frame.setPreferredSize(new Dimension(640,428));
				Main.frame.add(kp);
	    		Main.frame.repaint();
	    		Main.frame.pack();
	    	}
	    	if ( jToggleButton3.isSelected()){
	    		Main.game.setInst(true);
	        	Main.game.setMainMenuPanel(false);
	    	}
	    	repaint();
	    }          
	}// end of MainMenuP

	private class ContinueP extends javax.swing.JPanel {

		private static final long serialVersionUID = 1L;
		public ContinueP() {
	        initComponents();
	    }                       
	    private void initComponents() {
	        jButton1 = new javax.swing.JButton();
	        jLabel4 = new javax.swing.JLabel();
	        jButton2 = new javax.swing.JButton();
	        jLabel5 = new javax.swing.JLabel();
	        jLabel6 = new javax.swing.JLabel();
	        jLabel7 = new javax.swing.JLabel();
	        jLabel8 = new javax.swing.JLabel();
	        jLabel9 = new javax.swing.JLabel();
	        jLabel10 = new javax.swing.JLabel();
	        jLabel11 = new javax.swing.JLabel();
	        jLabel12 = new javax.swing.JLabel();
	        jLabel13 = new javax.swing.JLabel();
	        jLabel14 = new javax.swing.JLabel();
	        jLabel15 = new javax.swing.JLabel();
	        jLabel16 = new javax.swing.JLabel();
	        jLabel17 = new javax.swing.JLabel();
	        jLabel18 = new javax.swing.JLabel();
	        jLabel19 = new javax.swing.JLabel();
	        jLabel20 = new javax.swing.JLabel();
	        jLabel21 = new javax.swing.JLabel();
	        jLabel22 = new javax.swing.JLabel();
	        jLabel23 = new javax.swing.JLabel();
	        jLabel24 = new javax.swing.JLabel();
	        jLabel25 = new javax.swing.JLabel();
	        jLabel26 = new javax.swing.JLabel();
	        jLabel27 = new javax.swing.JLabel();
	        jLabel28 = new javax.swing.JLabel();
	        jLabel29 = new javax.swing.JLabel();
	        jLabel30 = new javax.swing.JLabel();
	        jLabel31 = new javax.swing.JLabel();
	        jLabel32 = new javax.swing.JLabel();
	        jLabel33 = new javax.swing.JLabel();
	        jLabel34 = new javax.swing.JLabel();
	        jLabel35 = new javax.swing.JLabel();

	        setBackground(new java.awt.Color(255, 255, 255));
	        setForeground(new java.awt.Color(255, 255, 255));

	        jButton1.setText("Back");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jButton2.setText("CONTINUE");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });
	        
	        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel4.setIcon(new javax.swing.ImageIcon("images/smallteams/s1.jpg")); // NOI18N

	        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel5.setIcon(new javax.swing.ImageIcon("images/smallteams/s2.gif")); // NOI18N

	        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel6.setIcon(new javax.swing.ImageIcon("images/smallteams/s3.gif")); // NOI18N

	        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel7.setIcon(new javax.swing.ImageIcon("images/smallteams/s4.gif")); // NOI18N

	        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel8.setIcon(new javax.swing.ImageIcon("images/smallteams/s5.gif")); // NOI18N

	        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel9.setIcon(new javax.swing.ImageIcon("images/smallteams/s6.gif")); // NOI18N

	        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel10.setIcon(new javax.swing.ImageIcon("images/smallteams/s7.gif")); // NOI18N

	        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel11.setIcon(new javax.swing.ImageIcon("images/smallteams/s8.png")); // NOI18N

	        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel12.setIcon(new javax.swing.ImageIcon("images/smallteams/s9.png")); // NOI18N

	        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel13.setIcon(new javax.swing.ImageIcon("images/smallteams/s10.gif")); // NOI18N

	        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel14.setIcon(new javax.swing.ImageIcon("images/smallteams/s11.gif")); // NOI18N

	        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel15.setIcon(new javax.swing.ImageIcon("images/smallteams/s12.gif")); // NOI18N

	        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel16.setIcon(new javax.swing.ImageIcon("images/smallteams/s13.gif")); // NOI18N

	        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel17.setIcon(new javax.swing.ImageIcon("images/smallteams/s14.gif")); // NOI18N

	        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel18.setIcon(new javax.swing.ImageIcon("images/smallteams/s15.gif")); // NOI18N

	        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel19.setIcon(new javax.swing.ImageIcon("images/smallteams/s16.jpg")); // NOI18N

	        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel20.setIcon(new javax.swing.ImageIcon("images/smallteams/s17.jpg")); // NOI18N

	        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel21.setIcon(new javax.swing.ImageIcon("images/smallteams/s17.jpg")); // NOI18N

	        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel22.setIcon(new javax.swing.ImageIcon("images/smallteams/s17.jpg")); // NOI18N

	        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel23.setIcon(new javax.swing.ImageIcon("images/smallteams/s17.jpg")); // NOI18N

	        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel24.setIcon(new javax.swing.ImageIcon("images/smallteams/s17.jpg")); // NOI18N

	        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel25.setIcon(new javax.swing.ImageIcon("images/smallteams/s17.jpg")); // NOI18N

	        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel26.setIcon(new javax.swing.ImageIcon("images/smallteams/s17.jpg")); // NOI18N

	        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel27.setIcon(new javax.swing.ImageIcon("images/smallteams/s17.jpg")); // NOI18N

	        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel28.setIcon(new javax.swing.ImageIcon("images/smallteams/s17.jpg")); // NOI18N

	        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel29.setIcon(new javax.swing.ImageIcon("images/smallteams/s17.jpg")); // NOI18N

	        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel30.setIcon(new javax.swing.ImageIcon("images/smallteams/s17.jpg")); // NOI18N

	        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel31.setIcon(new javax.swing.ImageIcon("images/smallteams/s17.jpg")); // NOI18N

	        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel32.setIcon(new javax.swing.ImageIcon("images/smallteams/s17.jpg")); // NOI18N

	        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel33.setIcon(new javax.swing.ImageIcon("images/smallteams/s17.jpg")); // NOI18N

	        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel34.setIcon(new javax.swing.ImageIcon("images/cup.png")); // NOI18N

	        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel35.setIcon(new javax.swing.ImageIcon("images/smallteams/s17.jpg")); // NOI18N

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                        .addGap(119, 119, 119)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(81, 81, 81)
	                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
	                                        .addGap(30, 30, 30)
	                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                            .addGroup(layout.createSequentialGroup()
	                                                .addGap(18, 18, 18)
	                                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                                                .addGap(93, 93, 93)
	                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                                        .addGap(0, 0, Short.MAX_VALUE))
	                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                                        .addGap(93, 93, 93)
	                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                                        .addGap(93, 93, 93)
	                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(81, 81, 81))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap())
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(layout.createSequentialGroup()
	                    .addGap(182, 182, 182)
	                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addContainerGap(512, Short.MAX_VALUE)))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                .addGap(29, 29, 29)
	                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(18, 18, 18)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                        .addGap(174, 174, 174)
	                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                                                .addGroup(layout.createSequentialGroup()
	                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                                        .addGroup(layout.createSequentialGroup()
	                                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                                            .addGap(58, 58, 58))
	                                                        .addGroup(layout.createSequentialGroup()
	                                                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                                            .addGap(10, 10, 10)))
	                                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                                .addGroup(layout.createSequentialGroup()
	                                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                                            .addGroup(layout.createSequentialGroup()
	                                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                                .addGap(51, 51, 51)))
	                                        .addGap(61, 61, 61)
	                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                        .addGap(5, 5, 5)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jButton1))
	                        .addGap(55, 55, 55))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                    .addContainerGap(333, Short.MAX_VALUE)
	                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addGap(103, 103, 103)))
	        );
	    }// </editor-fold>                        
	           
	    // BACK BUTTON
	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	Main.game.setMainMenuPanel(true);
	        Main.game.setConti(false); 
        	
			mmp.setVisible(true);
			mp.setVisible(false);
			sp.setVisible(false);
			sbp.setVisible(false);
			kp.setVisible(false);
			 
			cp.setVisible(false);
			soundp.setVisible(false);
			
			Main.frame.setPreferredSize(new Dimension(640,412));
			Main.frame.add(mmp);
    		Main.frame.repaint();
    		Main.frame.pack();

	    	repaint();
	    }
	    
	    // CONTINUE BUTTON
	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        Main.game.setConti(true);
	        Main.game.setPlay(true);
	        Main.game.setMainMenuPanel(false);
	        
	        mmp.setVisible(true);	//false
			mp.setVisible(false);
			sp.setVisible(false);
			sbp.setVisible(false);
			kp.setVisible(false);
			 
			cp.setVisible(false);
			soundp.setVisible(false);
			
			fra = new JFrame();
			fra.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			fra.setPreferredSize(new Dimension(1303,809));
			fra.setVisible(true);
			fra.add(new GameP());
			fra.repaint();
    		fra.pack();
    		/*
			Main.frame.setPreferredSize(new Dimension(1300,781));
			Main.frame.add();
    		Main.frame.repaint();
    		Main.frame.pack();*/
    		Main.frame.add(mmp);
    		Main.frame.setVisible(false);
    		
    		ImageIcon[] arr8 = new ImageIcon[8];
    		ImageIcon[] arr4 = new ImageIcon[4];
    		ImageIcon[] arr2 = new ImageIcon[2];
    		
    		if (Main.game.getStage() == 8 ){
    			int[] arr = new int[8];
    			for ( int i = 0; i < 8; i++ ){
    				if(Math.random() < 0.5)
    					arr[i] = 1;
    				else
    					arr[i] = 2;
    			}

    			if ( arr[0] == 1 )	{
    				jLabel20.setIcon(new javax.swing.ImageIcon("images/smallteams/s1.jpg")); // NOI18N
    				arr8[0] = new ImageIcon("images/smallteams/s1.jpg");
    			}
    			else{
    				jLabel20.setIcon(new javax.swing.ImageIcon("images/smallteams/s2.gif")); // NOI18N
    				arr8[0] = new ImageIcon("images/smallteams/s2.gif");
    			}
    			
    			if ( arr[1] == 1 )	{
    				jLabel21.setIcon(new javax.swing.ImageIcon("images/smallteams/s3.gif"));
    				arr8[1] = new ImageIcon("images/smallteams/s3.gif");
    			}
    			else{
    				jLabel21.setIcon(new javax.swing.ImageIcon("images/smallteams/s4.gif"));
    				arr8[1] = new ImageIcon("images/smallteams/s4.gif");
    			}
    			
    			if ( arr[2] == 1 ){
    				jLabel22.setIcon(new javax.swing.ImageIcon("images/smallteams/s5.gif"));
    				arr8[2] = new ImageIcon("images/smallteams/s5.gif");
    			}
    			else{
    				jLabel22.setIcon(new javax.swing.ImageIcon("images/smallteams/s6.gif"));
    				arr8[2] = new ImageIcon("images/smallteams/s6.gif");
    			}
    			
    			if ( arr[3] == 1 ){
    				jLabel23.setIcon(new javax.swing.ImageIcon("images/smallteams/s7.gif"));
    				arr8[3] = new ImageIcon("images/smallteams/s7.gif");
    			}
    			else{
    				jLabel23.setIcon(new javax.swing.ImageIcon("images/smallteams/s8.png"));
    				arr8[3] = new ImageIcon("images/smallteams/s8.png");
    			}
    			
    			if ( arr[4] == 1 ){
    				jLabel25.setIcon(new javax.swing.ImageIcon("images/smallteams/s9.png"));
    				arr8[4] = new ImageIcon("images/smallteams/s9.png");
    			}
    			else{
    				jLabel25.setIcon(new javax.swing.ImageIcon("images/smallteams/s10.gif"));
    				arr8[4] = new ImageIcon("images/smallteams/s10.gif");
    			}
    			
    			if ( arr[5] == 1 ){
    				jLabel24.setIcon(new javax.swing.ImageIcon("images/smallteams/s11.gif"));
    				arr8[5] = new ImageIcon("images/smallteams/s11.gif");
    			}
    			else{
    				jLabel24.setIcon(new javax.swing.ImageIcon("images/smallteams/s12.gif"));
    				arr8[5] = new ImageIcon("images/smallteams/s12.gif");
    			}
    			
    			if ( arr[6] == 1 ){
    				jLabel31.setIcon(new javax.swing.ImageIcon("images/smallteams/s13.gif"));
    				arr8[6] = new ImageIcon("images/smallteams/s13.gif");
    			}
    			else{
    				jLabel31.setIcon(new javax.swing.ImageIcon("images/smallteams/s14.gif"));
    				arr8[6] = new ImageIcon("images/smallteams/s14.gif");
    			}
    			
    			if ( arr[7] == 1 ){
    				jLabel26.setIcon(new javax.swing.ImageIcon("images/smallteams/s15.gif"));
    				arr8[7] = new ImageIcon("images/smallteams/s15.gif");
    			}
    			else{
    				jLabel26.setIcon(new javax.swing.ImageIcon("images/smallteams/s16.jpg"));
    				arr8[7] = new ImageIcon("images/smallteams/s16.jpg");
    			}
    			
    		}
    		
    		if (Main.game.getStage() == 4 ){
    			System.out.println("stage4");
    			int[] arr = new int[4];
    			for ( int i = 0; i < 4; i++ ){
    				if(Math.random() < 0.5)
    					arr[i] = 1;
    				else
    					arr[i] = 2;
    			}
    			
    			
    			if ( arr[0] == 1 ){
    				jLabel28.setIcon(jLabel20.getIcon());
    				arr4[0] = arr8[0];
    			}
    			else{
    				jLabel28.setIcon(jLabel21.getIcon());
    				arr4[0] = arr8[1];
    			}
    			
    			if ( arr[1] == 1 ){
    				jLabel30.setIcon(jLabel22.getIcon());
    				arr4[1] = arr8[2];
    			}
    			else{
    				jLabel30.setIcon(jLabel23.getIcon());
    				arr4[1] = arr8[3];
    			}
    			
    			if ( arr[2] == 1 ){
    				jLabel29.setIcon(jLabel25.getIcon());
    				arr4[2] = arr8[4];
    			}
    			else{
    				jLabel29.setIcon(jLabel24.getIcon());
    				arr4[2] = arr8[5];
    			}
    			
    			if ( arr[3] == 1 ){
    				jLabel32.setIcon(jLabel31.getIcon());
    				arr4[3] = arr8[6];
    			}
    			else{
    				jLabel32.setIcon(jLabel26.getIcon());
    				arr4[3] = arr8[7];
    			}

    		}

    		if (Main.game.getStage() == 2 ){
    			int[] arr = new int[2];
    			for ( int i = 0; i < 2; i++ ){
    				if(Math.random() < 0.5)
    					arr[i] = 1;
    				else
    					arr[i] = 2;
    			}
    			
    			
    			if ( arr[0] == 1 )	jLabel33.setIcon(jLabel28.getIcon());
    			else			    jLabel33.setIcon(jLabel30.getIcon());
    			
    			if ( arr[1] == 1 )	jLabel35.setIcon(jLabel29.getIcon());
    			else			    jLabel35.setIcon(jLabel32.getIcon());
    		}
    		
    		if (Main.game.getStage() == 1 ){
    			JFrame frame = new JFrame();
	        	JOptionPane.showMessageDialog(frame, "You are daaamn good honey bunny! You are the CHAMPION!!");
    		}
    		
    		if (Main.game.getStage() == -1 ){
    			JFrame frame = new JFrame();
	        	JOptionPane.showMessageDialog(frame, "You are fucking looser! Start a new season.");
    		}
    		
	    	repaint();
	    }


	    // Variables declaration - do not modify                     
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JLabel jLabel10;
	    private javax.swing.JLabel jLabel11;
	    private javax.swing.JLabel jLabel12;
	    private javax.swing.JLabel jLabel13;
	    private javax.swing.JLabel jLabel14;
	    private javax.swing.JLabel jLabel15;
	    private javax.swing.JLabel jLabel16;
	    private javax.swing.JLabel jLabel17;
	    private javax.swing.JLabel jLabel18;
	    private javax.swing.JLabel jLabel19;
	    private javax.swing.JLabel jLabel20;
	    private javax.swing.JLabel jLabel21;
	    private javax.swing.JLabel jLabel22;
	    private javax.swing.JLabel jLabel23;
	    private javax.swing.JLabel jLabel24;
	    private javax.swing.JLabel jLabel25;
	    private javax.swing.JLabel jLabel26;
	    private javax.swing.JLabel jLabel27;
	    private javax.swing.JLabel jLabel28;
	    private javax.swing.JLabel jLabel29;
	    private javax.swing.JLabel jLabel30;
	    private javax.swing.JLabel jLabel31;
	    private javax.swing.JLabel jLabel32;
	    private javax.swing.JLabel jLabel33;
	    private javax.swing.JLabel jLabel34;
	    private javax.swing.JLabel jLabel35;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	    private javax.swing.JLabel jLabel6;
	    private javax.swing.JLabel jLabel7;
	    private javax.swing.JLabel jLabel8;
	    private javax.swing.JLabel jLabel9;
	    // End of variables declaration                   
	}
	
	private class KeyBoardP extends javax.swing.JPanel {
	
		private static final long serialVersionUID = 1L;
		// Variables declaration                    
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JSlider jSlider1;
	    private javax.swing.JSlider jSlider2;
	    private int p1, p2;
	    // End of variables declaration  
	    public KeyBoardP() {
	        initComponents();
	    }
	                         
	    private void initComponents() {
	    	p1 = 1; p2 = 3;
	        jButton1 = new javax.swing.JButton();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jSlider1 = new javax.swing.JSlider();
	        jSlider2 = new javax.swing.JSlider();
	        jButton2 = new javax.swing.JButton();
	        
	        jSlider1.setMinimum(1);
	        jSlider1.setValue(1);
	        jSlider1.setMaximum(3);
	        
	        jSlider2.setMinimum(1);
	        jSlider2.setValue(3);
	        jSlider2.setMaximum(3);
	        
	        //Turn on labels at major tick marks.
	        jSlider1.setMajorTickSpacing(2);
	        jSlider1.setMinorTickSpacing(1);
	        jSlider1.setPaintTicks(true);
	        jSlider1.setPaintLabels(true);
	        
	        //Turn on labels at major tick marks.
	        jSlider2.setMajorTickSpacing(2);
	        jSlider2.setMinorTickSpacing(1);
	        jSlider2.setPaintTicks(true);
	        jSlider2.setPaintLabels(true);
	        
	        jSlider1.addChangeListener(new ChangeListener() {
	        	public void stateChanged(ChangeEvent e) {
	                JSlider source = (JSlider)e.getSource();
	                if (source.getValueIsAdjusting()) {
	                    int value = (int)source.getValue();
	                    if (value == 1) {
	                        jLabel4.setIcon(new ImageIcon("images/wasd.png")); // NOI18N
	                        p1 = 1;
	                    }
	                    if ( value == 2) {
	                    	jLabel4.setIcon(new ImageIcon("images/numpad.jpg")); // NOI18N
	                    	p1 = 2;
	                    }
	                    if (value == 3) {
	                        jLabel4.setIcon(new ImageIcon("images/arrows.png")); // NOI18N
	                        p1 = 3;
	                    }
	                }
	                repaint();
	            }
	        });
	        jSlider2.addChangeListener(new ChangeListener() {
	        	public void stateChanged(ChangeEvent e) {
	                JSlider source = (JSlider)e.getSource();
	                if (source.getValueIsAdjusting()) {
	                    int value = (int)source.getValue();
	                    if (value == 1) {
	                        jLabel3.setIcon(new ImageIcon("images/wasd.png")); // NOI18N
	                        p2 = 1;
	                    }
	                    
	                    if ( value == 2) {
	                    	jLabel3.setIcon(new ImageIcon("images/numpad.jpg")); // NOI18N
	                    	p2 = 2;
	                    }
	                    
	                    if ( value == 3) {
	                    	jLabel3.setIcon(new ImageIcon("images/arrows.png")); // NOI18N
	                    	p2 = 3;
	                    }
	                }
	                repaint();
	            }
	        });

	        setBackground(new java.awt.Color(255, 255, 255));
	        setForeground(new java.awt.Color(255, 255, 255));

	        jButton1.setText("Back");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });
	        jButton2.setText("SAVE");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });

	        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel1.setText("Player 1 Key Bindings");

	        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel2.setText("Player 2 Key Bindings");

	        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel4.setIcon(new javax.swing.ImageIcon("images/wasd.png")); // NOI18N

	        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel3.setIcon(new javax.swing.ImageIcon("images/arrows.png")); // NOI18N

	        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

	        

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(27, 27, 27)
	                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                        .addGroup(layout.createSequentialGroup()
	                            .addGap(529, 529, 529)
	                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGroup(layout.createSequentialGroup()
	                            .addGap(25, 25, 25)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
	                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                .addGroup(layout.createSequentialGroup()
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                .addGroup(layout.createSequentialGroup()
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))))
	                .addGap(0, 25, Short.MAX_VALUE))
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(layout.createSequentialGroup()
	                    .addGap(35, 35, 35)
	                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addContainerGap(409, Short.MAX_VALUE)))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(25, 25, 25)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel1)
	                    .addComponent(jLabel2))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(24, 24, 24)
	                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
	                .addComponent(jButton1)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(layout.createSequentialGroup()
	                    .addGap(67, 67, 67)
	                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addContainerGap(168, Short.MAX_VALUE)))
	        );
	    }                        
	    
	    // BACK BUTTON
	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	Main.game.setMainMenuPanel(true);
	        Main.game.setKeyboard(false);
	                	
			mmp.setVisible(true);
			mp.setVisible(false);
			sp.setVisible(false);
			sbp.setVisible(false);
			kp.setVisible(false);
			 
			cp.setVisible(false);
			soundp.setVisible(false);
			
			Main.frame.setPreferredSize(new Dimension(640,412));
			Main.frame.add(mmp);
    		Main.frame.repaint();
    		Main.frame.pack();
	        
	    	repaint();
	    }                                        
	    
	    // SAVE BUTTON
	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        if ( p1 == p2){
	        	JFrame frame = new JFrame();
	        	JOptionPane.showMessageDialog(frame, "Player 1 and Player 2 keys are same!");
	        }
	        else{	        	
	        	// player1
	        	if ( p1 == 1)
	        		Main.game.setP1Keyboard(1);
	        	if ( p1 == 2)
	        		Main.game.setP1Keyboard(2);
	        	if ( p1 == 3)
	        		Main.game.setP1Keyboard(3);
	        	// player 2
	        	if ( p2 == 1)
	        		Main.game.setP2Keyboard(1);
	        	if ( p2 == 2)
	        		Main.game.setP2Keyboard(2);
	        	if ( p2 == 3)
	        		Main.game.setP2Keyboard(3);
	        	
	        	JFrame frame = new JFrame();
	        	JOptionPane.showMessageDialog(frame, "Key Bindings are saved!");
	            
	        	repaint();
	        }
	    }                                                         
	}
	
	private class MultipalyerP extends javax.swing.JPanel {
		
		private static final long serialVersionUID = 1L;
		// Variables declaration - do not modify                     
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JCheckBox jCheckBox1;
	    private javax.swing.JCheckBox jCheckBox3;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JSlider jSlider1;
	    private javax.swing.JSlider jSlider2;
	    private javax.swing.JSpinner jSpinner1;
	    private javax.swing.JSpinner jSpinner2; 
	    int valueP1, valueP2;
	    boolean isTime = false;
	    // End of variables declaration
	    public MultipalyerP() {
	        initComponents();
	    }
	                         
	    private void initComponents() {
	        jButton1 = new javax.swing.JButton();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jSlider1 = new javax.swing.JSlider();
	        jSlider2 = new javax.swing.JSlider();
	        jCheckBox1 = new javax.swing.JCheckBox();
	        jSpinner1 = new javax.swing.JSpinner();
	        jCheckBox3 = new javax.swing.JCheckBox();
	        jSpinner2 = new javax.swing.JSpinner();
	        jButton2 = new javax.swing.JButton();
	        
	        // PLAYER 1 SLIDER
	        jSlider1.addChangeListener(new ChangeListener() {
	        	public void stateChanged(ChangeEvent e) {
	                JSlider source = (JSlider)e.getSource();
	                if (source.getValueIsAdjusting()) {
	                    valueP1 = (int)source.getValue();
	                    if (valueP1 == 1) {
	                        jLabel4.setIcon(new ImageIcon("images/players/1P1.png")); // NOI18N
	                    }
	                    if (valueP1 == 2) {
	                        jLabel4.setIcon(new ImageIcon("images/players/2P1.png")); // NOI18N
	                    }
	                    if (valueP1 == 3) {
	                        jLabel4.setIcon(new ImageIcon("images/players/3P1.png")); // NOI18N
	                    }
	                    if (valueP1 == 4) {
	                        jLabel4.setIcon(new ImageIcon("images/players/4P1.png")); // NOI18N
	                    }
	                    if ( valueP1 == 5) {
	                    	jLabel4.setIcon(new ImageIcon("images/players/5P1.png")); // NOI18N
	                    }
	                }
	                repaint();
	            }
	        });
	        
	        // PLAYER 2 SLIDER
	        jSlider2.addChangeListener(new ChangeListener() {
	        	public void stateChanged(ChangeEvent e) {
	                JSlider source = (JSlider)e.getSource();
	                if (source.getValueIsAdjusting()) {
	                    valueP2 = (int)source.getValue();
	                    if (valueP2 == 1) {
	                        jLabel3.setIcon(new ImageIcon("images/players/1P2.png")); // NOI18N
	                    }
	                    if (valueP2 == 2) {
	                        jLabel3.setIcon(new ImageIcon("images/players/2P2.png")); // NOI18N
	                    }
	                    if (valueP2 == 3) {
	                        jLabel3.setIcon(new ImageIcon("images/players/3P2.png")); // NOI18N
	                    }
	                    if (valueP2 == 4) {
	                        jLabel3.setIcon(new ImageIcon("images/players/4P2.png")); // NOI18N
	                    }
	                    if ( valueP2 == 5) {
	                    	jLabel3.setIcon(new ImageIcon("images/players/5P2.png")); // NOI18N
	                    }
	                }
	                repaint();
	            }
	        });
	        
	        jSlider1.setMinimum(1);
	        jSlider1.setValue(1);
	        jSlider1.setMaximum(5);
	        
	        jSlider2.setMinimum(1);
	        jSlider2.setValue(5);
	        jSlider2.setMaximum(5);
	        
	        //Turn on labels at major tick marks.
	        jSlider1.setMajorTickSpacing(4);
	        jSlider1.setMinorTickSpacing(1);
	        jSlider1.setPaintTicks(true);
	        jSlider1.setPaintLabels(true);
	        
	        //Turn on labels at major tick marks.
	        jSlider2.setMajorTickSpacing(4);
	        jSlider2.setMinorTickSpacing(1);
	        jSlider2.setPaintTicks(true);
	        jSlider2.setPaintLabels(true);
	        
	        setBackground(new java.awt.Color(255, 255, 255));
	        setForeground(new java.awt.Color(255, 255, 255));
	        
	        jCheckBox1.setSelected(true);

	        
	        jSpinner1.setValue(7);
	        /*jSpinner1.addChangeListener(new ChangeListener(){
		        public void stateChanged(ChangeEvent e) {
		            scoreL = (int) jSpinner1.getValue();
		            repaint();
		        }
	        });*/
	        jSpinner2.setValue(30);
	        
	        jCheckBox1.setText("Score Limit");
	        jCheckBox3.setText("Time (seconds)");
	        
	        jButton1.setText("Back");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });
	        jButton2.setText("START");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });
	        jCheckBox1.addItemListener(new ItemListener(){
		        public void itemStateChanged(ItemEvent e) {
		            if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		            	jCheckBox3.setSelected(false);
		            	isTime = false;
		            } else {//checkbox has been deselected
		            	jCheckBox3.setSelected(true);
		            	isTime = true;
		            }
		            repaint();
		        }
	        });
	        jCheckBox3.addItemListener(new ItemListener(){
		        public void itemStateChanged(ItemEvent e) {
		            if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		            	jCheckBox1.setSelected(false);
		            	isTime = true;
		            } else {//checkbox has been deselected
		            	jCheckBox1.setSelected(true);
		            	isTime = false;
		            }
		            repaint();
		        }
	        });
	        
	        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel1.setText("Player 1");

	        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel2.setText("Player 2");

	        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel3.setIcon(new javax.swing.ImageIcon("images/players/3P2.png")); // NOI18N

	        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel4.setIcon(new javax.swing.ImageIcon("images/players/5P1.png")); // NOI18N

	        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

	        

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(27, 27, 27)
	                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                        .addGroup(layout.createSequentialGroup()
	                            .addGap(529, 529, 529)
	                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGroup(layout.createSequentialGroup()
	                            .addGap(25, 25, 25)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
	                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addComponent(jSlider2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
	                .addGap(0, 25, Short.MAX_VALUE))
	            .addGroup(layout.createSequentialGroup()
	                .addGap(226, 226, 226)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(layout.createSequentialGroup()
	                    .addGap(35, 35, 35)
	                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addContainerGap(409, Short.MAX_VALUE)))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(25, 25, 25)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel1)
	                    .addComponent(jLabel2))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(jButton1)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(layout.createSequentialGroup()
	                    .addGap(67, 67, 67)
	                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addContainerGap(168, Short.MAX_VALUE)))
	        );
	    }                      
	    
	    // BACK BUTTON
	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         	    	
	    	Main.game.setMainMenuPanel(true);
	        Main.game.setMultiplayer(false);
	        
	        mmp.setVisible(true);
			mp.setVisible(false);
			sp.setVisible(false);
			sbp.setVisible(false);
			kp.setVisible(false);
			 
			cp.setVisible(false);
			soundp.setVisible(false);
			
			Main.frame.setPreferredSize(new Dimension(640,412));
			Main.frame.add(mmp);
    		Main.frame.repaint();
    		Main.frame.pack();
	        
	    	repaint();
	    }
	    
	    // START BUTTON
	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        //PLAYER 1 
	        if ( valueP1 == 1 )
	        	Main.game.setPlayer1(1);
	        if ( valueP1 == 2 )
	        	Main.game.setPlayer1(2);
	        if ( valueP1 == 3 )
	        	Main.game.setPlayer1(3);
	        if ( valueP1 == 4 )
	        	Main.game.setPlayer1(4);
	        if ( valueP1 == 5 )
	        	Main.game.setPlayer1(5);
	        
	        // PLAYER 2
	        if ( valueP2 == 1 )
	        	Main.game.setPlayer2(1);
	        if ( valueP2 == 2 )
	        	Main.game.setPlayer2(2);
	        if ( valueP2 == 3 )
	        	Main.game.setPlayer2(3);
	        if ( valueP2 == 4 )
	        	Main.game.setPlayer2(4);
	        if ( valueP2 == 5 )
	        	Main.game.setPlayer2(5);
	        
	        if ( isTime ){
	        	Main.game.setTime((int) jSpinner2.getValue());
	        	Main.game.setIsTime(true);
	        }
	        else{
	        	System.out.println((int) jSpinner1.getValue());
	        	Main.game.setScoreLimit((int) jSpinner1.getValue());
	        	Main.game.setIsTime(false);
	        }
	        
	        Main.game.setMultiplayer(true);
	        Main.game.setPlay(true);
	        Main.game.setAI(false);
	        Main.game.setMainMenuPanel(false);
	        
	        mmp.setVisible(true);	//false
			mp.setVisible(false);
			sp.setVisible(false);
			sbp.setVisible(false);
			kp.setVisible(false);
			cp.setVisible(false);
			soundp.setVisible(false);
			
			fra = new JFrame();
			fra.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			fra.setPreferredSize(new Dimension(1303,809));
			fra.setVisible(true);
			fra.add(new GameP());
			fra.repaint();
    		fra.pack();
    		/*
			Main.frame.setPreferredSize(new Dimension(1300,781));
			Main.frame.add();
    		Main.frame.repaint();
    		Main.frame.pack();*/
    		Main.frame.add(mmp);
    		Main.frame.setVisible(false);
	        
	    	repaint();
	    }                  
	}// end of MultiplayerP
	
	private class SinglePlayerP extends javax.swing.JPanel {
	    // Variables declaration
		private static final long serialVersionUID = 1L;
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JCheckBox jCheckBox1;;
	    private javax.swing.JCheckBox jCheckBox3;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel6;
	    private javax.swing.JSlider jSlider1;
	    private javax.swing.JSlider jSlider2;
	    private javax.swing.JSlider jSlider4;
	    private javax.swing.JSpinner jSpinner1;
	    private javax.swing.JSpinner jSpinner2;
	    int valueP1, value, difficulty;
	    boolean isTime = false;
	    // End of variables declaration  
	    
	    public SinglePlayerP() {
	        initComponents();
	    }
	    
	    private void initComponents() {
	    	
	        jButton1 = new javax.swing.JButton();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jSlider1 = new javax.swing.JSlider();
	        jSlider2 = new javax.swing.JSlider();
	        jCheckBox1 = new javax.swing.JCheckBox();
	        jSpinner1 = new javax.swing.JSpinner();
	        jCheckBox3 = new javax.swing.JCheckBox();
	        jSpinner2 = new javax.swing.JSpinner();
	        jButton2 = new javax.swing.JButton();
	        jSlider4 = new javax.swing.JSlider();
	        jLabel6 = new javax.swing.JLabel();
	        
	        setBackground(new java.awt.Color(255, 255, 255));
	        setForeground(new java.awt.Color(255, 255, 255));

	        jSlider1.addChangeListener(new ChangeListener() {
	        	public void stateChanged(ChangeEvent e) {
	                JSlider source = (JSlider)e.getSource();
	                if (source.getValueIsAdjusting()) {
	                	valueP1 = (int)source.getValue();
	                    if (valueP1 == 1) {
	                        jLabel4.setIcon(new ImageIcon("images/players/1P1.png")); // NOI18N
	                    }
	                    if (valueP1 == 2) {
	                        jLabel4.setIcon(new ImageIcon("images/players/2P1.png")); // NOI18N
	                    }
	                    if (valueP1 == 3) {
	                        jLabel4.setIcon(new ImageIcon("images/players/3P1.png")); // NOI18N
	                    }
	                    if (valueP1 == 4) {
	                        jLabel4.setIcon(new ImageIcon("images/players/4P1.png")); // NOI18N
	                    }
	                    if ( valueP1 == 5) {
	                    	jLabel4.setIcon(new ImageIcon("images/players/5P1.png")); // NOI18N
	                    }
	                }
	                repaint();
	            }
	        });
	        jSlider2.addChangeListener(new ChangeListener() {
	        	public void stateChanged(ChangeEvent e) {
	                JSlider source = (JSlider)e.getSource();
	                if (source.getValueIsAdjusting()) {
	                    value = (int)source.getValue();
	                    if (value == 1)
	                        jLabel3.setIcon(new ImageIcon("images/teams/s1.jpg")); // NOI18N
	                    if (value == 2)
	                        jLabel3.setIcon(new ImageIcon("images/teams/atletico.gif")); // NOI18N
	                    if (value == 3)
	                        jLabel3.setIcon(new ImageIcon("images/teams/barcelona.gif")); // NOI18N
	                    if (value == 4)
	                        jLabel3.setIcon(new ImageIcon("images/teams/bayern.gif")); // NOI18N
	                    if (value == 5)
	                        jLabel3.setIcon(new ImageIcon("images/teams/benfica.gif")); // NOI18N
	                    if (value == 6)
	                        jLabel3.setIcon(new ImageIcon("images/teams/dourtmund.gif")); // NOI18N
	                    if (value == 7)
	                        jLabel3.setIcon(new ImageIcon("images/teams/juventus.gif")); // NOI18N
	                    if (value == 8)
	                        jLabel3.setIcon(new ImageIcon("images/teams/mancity.png")); // NOI18N
	                    if (value == 9)
	                        jLabel3.setIcon(new ImageIcon("images/teams/manunt.png")); // NOI18N
	                    if (value == 10)
	                        jLabel3.setIcon(new ImageIcon("images/teams/milan.gif")); // NOI18N
	                    if (value == 11)
	                        jLabel3.setIcon(new ImageIcon("images/teams/monaco.gif")); // NOI18N
	                    if (value == 12)
	                        jLabel3.setIcon(new ImageIcon("images/teams/napoli.gif")); // NOI18N
	                    if (value == 13)
	                        jLabel3.setIcon(new ImageIcon("images/teams/porto.gif")); // NOI18N
	                    if (value == 14)
	                        jLabel3.setIcon(new ImageIcon("images/teams/psg.gif")); // NOI18N
	                    if (value == 15)
	                        jLabel3.setIcon(new ImageIcon("images/teams/real.gif")); // NOI18N
	                    if (value == 16)
	                        jLabel3.setIcon(new ImageIcon("images/teams/tottenham.jpg")); // NOI18N
	                }
	                repaint();
	            }
	        });
	        jSlider4.addChangeListener(new ChangeListener() {
	        	public void stateChanged(ChangeEvent e) {
	                JSlider source = (JSlider)e.getSource();
	                if (source.getValueIsAdjusting()) {
	                    difficulty = (int)source.getValue();
	                    if (difficulty == 1) {
	                        // easy
	                    }
	                    if ( difficulty == 2) {
	                    	// medium
	                    }
	                    if ( difficulty == 3) {
	                    	// hard
	                    }
	                }
	                repaint();
	            }
	        });
	        
	        jSlider1.setMinimum(1);
	        jSlider1.setValue(1);
	        jSlider1.setMaximum(5);
	        
	        jSlider2.setMinimum(1);
	        jSlider2.setValue(15);
	        jSlider2.setMaximum(16);
	        
	        jSlider4.setMinimum(1);
	        jSlider4.setValue(1);
	        jSlider4.setMaximum(3);
	        
	        //Turn on labels at major tick marks.
	        jSlider1.setMajorTickSpacing(4);
	        jSlider1.setMinorTickSpacing(1);
	        jSlider1.setPaintTicks(true);
	        jSlider1.setPaintLabels(true);
	        
	        //Turn on labels at major tick marks.
	        jSlider2.setMajorTickSpacing(15);
	        jSlider2.setMinorTickSpacing(1);
	        jSlider2.setPaintTicks(true);
	        jSlider2.setPaintLabels(true);
	        
	        //Turn on labels at major tick marks.
	        jSlider4.setMajorTickSpacing(2);
	        jSlider4.setMinorTickSpacing(1);
	        jSlider4.setPaintTicks(true);
	        jSlider4.setPaintLabels(true);
	        
	        setBackground(new java.awt.Color(255, 255, 255));
	        setForeground(new java.awt.Color(255, 255, 255));
	        
	        jCheckBox1.setSelected(true);

	        
	        jSpinner1.setValue(7);
	        jSpinner2.setValue(30);
	        
	        jCheckBox1.setText("Score Limit");
	        jCheckBox3.setText("Time (seconds)");
	        
	        jButton1.setText("Back");
	        jButton2.setText("START");
	        
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });
	        
	        jCheckBox1.addItemListener(new ItemListener(){
		        public void itemStateChanged(ItemEvent e) {
		            if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		            	jCheckBox3.setSelected(false);
		            	isTime = false;
		            } else {//checkbox has been deselected
		            	jCheckBox3.setSelected(true);
		            	isTime = true;
		            }
		            repaint();
		        }
	        });
	        jCheckBox3.addItemListener(new ItemListener(){
		        public void itemStateChanged(ItemEvent e) {
		            if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		            	jCheckBox1.setSelected(false);
		            	isTime = true;
		            } else {//checkbox has been deselected
		            	jCheckBox1.setSelected(true);
		            	isTime = false;
		            }
		            repaint();
		        }
	        });
	        
	        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel1.setText("Choose Player");

	        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel2.setText("Choose Team");

	        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel3.setIcon(new javax.swing.ImageIcon("images/teams/real.gif")); // NOI18N

	        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel4.setIcon(new javax.swing.ImageIcon("images/players/5P1.png")); // NOI18N

	        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	        
	        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel6.setText("Difficulty");

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
	                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                        .addGap(27, 27, 27)
	                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                        .addGroup(layout.createSequentialGroup()
	                            .addGap(529, 529, 529)
	                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGroup(layout.createSequentialGroup()
	                            .addGap(25, 25, 25)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
	                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                .addGroup(layout.createSequentialGroup()
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                .addGroup(layout.createSequentialGroup()
	                                    .addGap(62, 62, 62)
	                                    .addComponent(jSlider4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))))
	                .addGap(0, 25, Short.MAX_VALUE))
	            .addGroup(layout.createSequentialGroup()
	                .addGap(226, 226, 226)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(layout.createSequentialGroup()
	                    .addGap(35, 35, 35)
	                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addContainerGap(409, Short.MAX_VALUE)))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(25, 25, 25)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel1)
	                    .addComponent(jLabel2))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(24, 24, 24)
	                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(30, 30, 30)
	                        .addComponent(jLabel6)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jSlider4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(jButton1)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(layout.createSequentialGroup()
	                    .addGap(67, 67, 67)
	                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addContainerGap(168, Short.MAX_VALUE)))
	        );
	    }// </editor-fold>                        

	 // BACK BUTTON
	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	if ( Main.game.isChampions() ){
		    	Main.game.setMainMenuPanel(true);
		        Main.game.setChampions(false);
		        
		        mmp.setVisible(true);
				mp.setVisible(false);
				sp.setVisible(false);
				sbp.setVisible(false);
				kp.setVisible(false);
				 
				cp.setVisible(false);
				soundp.setVisible(false);
				
				Main.frame.setPreferredSize(new Dimension(640,412));
				Main.frame.add(mmp);
	    		Main.frame.repaint();
	    		Main.frame.pack();
	    	}
	    	if( Main.game.isTraining() ){
	    		Main.game.setMainMenuPanel(true);
		        Main.game.setTraining(false);
		        
		        mmp.setVisible(true);
				mp.setVisible(false);
				sp.setVisible(false);
				sbp.setVisible(false);
				kp.setVisible(false);
				 
				cp.setVisible(false);
				soundp.setVisible(false);
				
				Main.frame.setPreferredSize(new Dimension(640,412));
				Main.frame.add(mmp);
	    		Main.frame.repaint();
	    		Main.frame.pack();
	    	}
	        
	    	repaint();
	    }
	    
	    // START BUTTON
	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	if ( Main.game.isChampions() ){
		    	Main.game.setConti(true);
		        Main.game.setChampions(false);
		        Main.game.setSeasonCreated(true);
		        Main.game.setAI(true);
		        Main.game.setMainMenuPanel(false);
		        
		        cp = new ContinueP();
		        
		        mmp.setVisible(false);	// false
				mp.setVisible(false);
				sp.setVisible(false);
				sbp.setVisible(false);
				kp.setVisible(false);
				cp.setVisible(true);
				soundp.setVisible(false);
				
				if ( isTime ){
		        	Main.game.setTime((int) jSpinner2.getValue());
		        	Main.game.setIsTime(true);
		        }
		        else{
		        	System.out.println((int) jSpinner1.getValue());
		        	Main.game.setScoreLimit((int) jSpinner1.getValue());
		        	Main.game.setIsTime(false);
		        }
				
				Main.frame.setPreferredSize(new Dimension(789, 526));
				Main.frame.add(cp);
	    		Main.frame.repaint();
	    		Main.frame.pack();	
	    	}
	    	if( Main.game.isTraining() ){
		        Main.game.setTraining(true);
		        Main.game.setPlay(true);
		        Main.game.setAI(true);
		        Main.game.setMainMenuPanel(false);
		        
		        mmp.setVisible(true);	// false
				mp.setVisible(false);
				sp.setVisible(false);
				sbp.setVisible(false);
				kp.setVisible(false);
				cp.setVisible(false);
				soundp.setVisible(false);
				
				if ( isTime ){
		        	Main.game.setTime((int) jSpinner2.getValue());
		        	Main.game.setIsTime(true);
		        }
		        else{
		        	System.out.println((int) jSpinner1.getValue());
		        	Main.game.setScoreLimit((int) jSpinner1.getValue());
		        	Main.game.setIsTime(false);
		        }
				
				fra = new JFrame();
				fra.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				fra.setPreferredSize(new Dimension(1303,809));
				fra.setVisible(true);
				fra.add(new GameP());
				fra.repaint();
	    		fra.pack();
	    		/*
				Main.frame.setPreferredSize(new Dimension(1300,781));
				Main.frame.add();
	    		Main.frame.repaint();
	    		Main.frame.pack();*/
	    		Main.frame.add(mmp);
	    		Main.frame.setVisible(false);
	    	}
	        
	        // PLAYER 1
	        if ( valueP1 == 1 )
	        	Main.game.setPlayer1(1);
	        if ( valueP1 == 2 )
	        	Main.game.setPlayer1(2);
	        if ( valueP1 == 3 )
	        	Main.game.setPlayer1(3);
	        if ( valueP1 == 4 )
	        	Main.game.setPlayer1(4);
	        if ( valueP1 == 5 )
	        	Main.game.setPlayer1(5);
	        
	        // TEAM
	        if (value == 1)
	           Main.game.setTeam(1); // NOI18N
	        if (value == 2)
	            Main.game.setTeam(2); // NOI18N
	        if (value == 3)
	        	Main.game.setTeam(3); // NOI18N
	        if (value == 4)
	        	Main.game.setTeam(4); // NOI18N
	        if (value == 5)
	        	Main.game.setTeam(5); // NOI18N
	        if (value == 6)
	        	Main.game.setTeam(6); // NOI18N
	        if (value == 7)
	        	Main.game.setTeam(7); // NOI18N
	        if (value == 8)
	        	Main.game.setTeam(8); // NOI18N
	        if (value == 9)
	        	Main.game.setTeam(9); // NOI18N
	        if (value == 10)
	        	Main.game.setTeam(10); // NOI18N
	        if (value == 11)
	        	Main.game.setTeam(11); // NOI18N
	        if (value == 12)
	        	Main.game.setTeam(12); // NOI18N
	        if (value == 13)
	        	Main.game.setTeam(13); // NOI18N
	        if (value == 14)
	        	Main.game.setTeam(14); // NOI18N
	        if (value == 15)
	            Main.game.setTeam(15); // NOI18N
	        if (value == 16)
	        	Main.game.setTeam(16); // NOI18N
	        /*
	        if ( isTime ){
	        	Main.game.setTime((int) jSpinner2.getValue());
	        	Main.game.setIsTime(true);
	        }
	        else{
	        	System.out.println((int) jSpinner1.getValue());
	        	Main.game.setScoreLimit((int) jSpinner1.getValue());
	        	Main.game.setIsTime(false);
	        }*/
	        
	        Main.game.setDifficulty(difficulty);
	        
	    	repaint();
	    }                                                        
	}// end of SingleplayerP
	
	
	private class SoundP extends javax.swing.JPanel {
		
		private static final long serialVersionUID = 1L;
		// Variables declaration - do not modify                     
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JCheckBox jCheckBox1;
	    private javax.swing.JCheckBox jCheckBox2;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JSlider jSlider1;
	    // End of variables declaration 

	    /**
	     * Creates new form SoundPanel
	     */
	    public SoundP() {
	        initComponents();
	    }
	                         
	    private void initComponents() {

	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jCheckBox1 = new javax.swing.JCheckBox();
	        jCheckBox2 = new javax.swing.JCheckBox();
	        jSlider1 = new javax.swing.JSlider();
	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();
	        jLabel3 = new javax.swing.JLabel();
	        jButton3 = new javax.swing.JButton();
	        
	        jSlider1.addChangeListener(new ChangeListener() {
	        	public void stateChanged(ChangeEvent e) {
	                JSlider source = (JSlider)e.getSource();
	                if (source.getValueIsAdjusting()) {
	                    int value = (int)source.getValue();
	                    if (value == -2) {
	                        // easy
	                    }
	                    if ( value == -1) {
	                    	// medium
	                    }
	                    if ( value == 0) {
	                    	// medium
	                    }
	                    if ( value == 1) {
	                    	// medium
	                    }
	                    if ( value == 2) {
	                    	// medium
	                    }
	                }
	                repaint();
	            }
	        });
	        
	        jSlider1.setMinimum(-2);
	        jSlider1.setValue(0);
	        jSlider1.setMaximum(2);

	        //Turn on labels at major tick marks.
	        jSlider1.setMajorTickSpacing(4);
	        jSlider1.setMinorTickSpacing(1);
	        jSlider1.setPaintTicks(true);
	        jSlider1.setPaintLabels(true);

	        jLabel1.setText("Game Speed");

	        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel2.setText("Sound Settings");

	        jCheckBox1.setText("Music");
	        jCheckBox1.setSelected(true);

	        jCheckBox2.setText("In Game Sound");
	        jCheckBox2.setSelected(true);

	        jButton1.setText("Back");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
	            }
	        });

	        jButton2.setText("SAVE");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton2ActionPerformed(evt);
	            }
	        });

	        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel3.setText("Delete all saved data");

	        jButton3.setText("Delete");
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton3ActionPerformed(evt);
	            }
	        });

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(25, 25, 25)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jButton3)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
	                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
	                                .addGap(55, 55, 55)
	                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                        .addGap(63, 63, 63)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
	                            .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addGap(0, 0, Short.MAX_VALUE)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                .addGap(25, 25, 25))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(25, 25, 25)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jCheckBox1)
	                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jCheckBox2)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addGap(30, 30, 30)))
	                .addComponent(jButton3)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
	                .addComponent(jButton1)
	                .addContainerGap())
	        );
	    }// </editor-fold>                        
	    
	    // BACK
	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                                 	
        	if ( Main.game.isSound() ){
				Main.game.setMainMenuPanel(true);
		        Main.game.setSound(false); 
	        	
				mmp.setVisible(true);
				mp.setVisible(false);
				sp.setVisible(false);
				sbp.setVisible(false);
				kp.setVisible(false);
				 
				cp.setVisible(false);
				soundp.setVisible(false);
				
				Main.frame.setPreferredSize(new Dimension(640,412));
				Main.frame.add(mmp);
	    		Main.frame.repaint();
	    		Main.frame.pack();
        	}
        	if ( Main.game.isSettings() ){
        		Main.game.setMainMenuPanel(true);
		        Main.game.setSettings(false); 
	        	
				mmp.setVisible(true);
				mp.setVisible(false);
				sp.setVisible(false);
				sbp.setVisible(false);
				kp.setVisible(false);
				 
				cp.setVisible(false);
				soundp.setVisible(false);
				
				Main.frame.setPreferredSize(new Dimension(640,412));
				Main.frame.add(mmp);
	    		Main.frame.repaint();
	    		Main.frame.pack();
        	}
            
        	repaint();
	    }
	    
	    // SAVE
	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                                   	
        	if ( jCheckBox1.isSelected() )
        		sm.playSound();
        	else
        		sm.stopSound();
        	
        	if ( jCheckBox2.isSelected() ){
        		// TO DO - in game sound
        	}
        	
        	JFrame frame = new JFrame();
        	JOptionPane.showMessageDialog(frame, "Ball & Stadium images are saved!");
            
        	repaint();
	    }
	    
	    // DELETE
	    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
	    	JFrame frame = new JFrame();
	    	JOptionPane.showMessageDialog(frame, "All saved data has been deleted!");    	
	    	
	    	// creates a new Game object and initialize to 'g'
	    	Main.game = new Game();
	    	
	    	repaint();
	    	
	    }
	}// end of SoundP
	
	private class StadiumBallP extends javax.swing.JPanel {

		private static final long serialVersionUID = 1L;

	    // Variables declaration - do not modify                     
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JSlider jSlider1;
	    private javax.swing.JSlider jSlider2;
	    int valueBall, valueSta;
	    // End of variables declaration 

	    public StadiumBallP() {
	        initComponents();
	    }
	    
	    private void initComponents() {
	        jButton1 = new javax.swing.JButton();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jSlider1 = new javax.swing.JSlider();
	        jSlider2 = new javax.swing.JSlider();
	        jButton2 = new javax.swing.JButton();
	        
	        jSlider1.setMinimum(1);
	        jSlider1.setValue(6);
	        jSlider1.setMaximum(6);
	        
	        jSlider2.setMinimum(1);
	        jSlider2.setValue(1);
	        jSlider2.setMaximum(3);
	        
	        //Turn on labels at major tick marks.
	        jSlider1.setMajorTickSpacing(5);
	        jSlider1.setMinorTickSpacing(1);
	        jSlider1.setPaintTicks(true);
	        jSlider1.setPaintLabels(true);
	        
	        //Turn on labels at major tick marks.
	        jSlider2.setMajorTickSpacing(2);
	        jSlider2.setMinorTickSpacing(1);
	        jSlider2.setPaintTicks(true);
	        jSlider2.setPaintLabels(true);
	        
	        jSlider1.addChangeListener(new ChangeListener() {
	        	public void stateChanged(ChangeEvent e) {
	                JSlider source = (JSlider)e.getSource();
	                if (source.getValueIsAdjusting()) {
	                    valueBall = (int)source.getValue();
	                    if (valueBall == 1) {
	                        jLabel4.setIcon(new ImageIcon("images/balls/b1.png")); // NOI18N
	                        Main.game.setBall(1);
	                    }
	                    if ( valueBall == 2) {
	                    	jLabel4.setIcon(new ImageIcon("images/balls/b2.png")); // NOI18N
	                    	Main.game.setBall(2);
	                    }
	                    if (valueBall == 3) {
	                        jLabel4.setIcon(new ImageIcon("images/balls/b3.png")); // NOI18N
	                        Main.game.setBall(3);
	                    }
	                    if ( valueBall == 4) {
	                    	jLabel4.setIcon(new ImageIcon("images/balls/b4.png")); // NOI18N
	                    	Main.game.setBall(4);
	                    }
	                    if (valueBall == 5) {
	                        jLabel4.setIcon(new ImageIcon("images/balls/b5.png")); // NOI18N
	                        Main.game.setBall(5);
	                    }
	                    if ( valueBall == 6) {
	                    	jLabel4.setIcon(new ImageIcon("images/balls/b6.png")); // NOI18N
	                    	Main.game.setBall(6);
	                    }
	                }
	                repaint();
	            }
	        });
	        jSlider2.addChangeListener(new ChangeListener() {
	        	public void stateChanged(ChangeEvent e) {
	                JSlider source = (JSlider)e.getSource();
	                if (source.getValueIsAdjusting()) {
	                	valueSta = (int)source.getValue();
	                    if (valueSta == 1) {
	                        jLabel3.setIcon(new ImageIcon("images/stadium1.png")); // NOI18N
	                    }
	                    
	                    if ( valueSta == 2) {
	                    	jLabel3.setIcon(new ImageIcon("images/stadium2.png")); // NOI18N
	                    }
	                    
	                    if ( valueSta == 3) {
	                    	jLabel3.setIcon(new ImageIcon("images/stadium.png")); // NOI18N
	                    }
	                }
	                repaint();
	            }
	        });

	        setBackground(new java.awt.Color(255, 255, 255));
	        setForeground(new java.awt.Color(255, 255, 255));

	        jButton1.setText("Back");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });
	        jButton2.setText("SAVE");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });

	        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel1.setText("Ball");

	        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel2.setText("Stadium");

	        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel4.setIcon(new javax.swing.ImageIcon("images/balls/b6.png")); // NOI18N

	        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel3.setIcon(new javax.swing.ImageIcon("images/stadium1.png")); // NOI18N

	        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

	        

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(27, 27, 27)
	                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                        .addGroup(layout.createSequentialGroup()
	                            .addGap(529, 529, 529)
	                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGroup(layout.createSequentialGroup()
	                            .addGap(25, 25, 25)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
	                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                .addGroup(layout.createSequentialGroup()
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                .addGroup(layout.createSequentialGroup()
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))))
	                .addGap(0, 25, Short.MAX_VALUE))
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(layout.createSequentialGroup()
	                    .addGap(35, 35, 35)
	                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addContainerGap(409, Short.MAX_VALUE)))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(25, 25, 25)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel1)
	                    .addComponent(jLabel2))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(24, 24, 24)
	                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
	                .addComponent(jButton1)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(layout.createSequentialGroup()
	                    .addGap(67, 67, 67)
	                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addContainerGap(168, Short.MAX_VALUE)))
	        );
	    }// </editor-fold>                        

	    // BACK
	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                                	
			Main.game.setMainMenuPanel(true);
	        Main.game.setKeyboard(false); 
        	
			mmp.setVisible(true);
			mp.setVisible(false);
			sp.setVisible(false);
			sbp.setVisible(false);
			kp.setVisible(false);
			 
			cp.setVisible(false);
			soundp.setVisible(false);
			
			Main.frame.setPreferredSize(new Dimension(640,412));
			Main.frame.add(mmp);
    		Main.frame.repaint();
    		Main.frame.pack();
            
        	repaint();
	    }                                        

	    // SAVE
	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {	        	
	        	Main.game.setBallImage(valueBall);
	        	Main.game.setStadiumImage(valueSta);
	        	
	        	JFrame frame = new JFrame();
	        	JOptionPane.showMessageDialog(frame, "Ball & Stadium images are saved!");
	            
	        	repaint();
	    }                                        
                  
	}// end of StadiumBallP

}// end of GameWindow

