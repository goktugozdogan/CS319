import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

public class GameWindow extends JFrame{
	Game game;
	MainMenuPanel mmp;
	MultipalyerPanel mp;
	SinglePlayerPanel sp;
	StadiumBallPanel sbp;
	KeyboardPanel kp;
	GamePanel gp;
	ContinuePanel cp;
	SoundPanel soundp;
	SoundManage sm;
	
	public GameWindow(){
		super ();
		sm = new SoundManage();
	    sm.playSound();
		setTitle ("Head Ball");
		setVisible(true);
		setResizable(false); 
		//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//setLocation(dim.width/2-640/2, dim.height/2-412/2);
		pack ();
		
		game = new Game();
		mmp = new MainMenuPanel();
		mp = new MultipalyerPanel();
		sp= new SinglePlayerPanel();
		sbp = new StadiumBallPanel();
		kp = new KeyboardPanel();
		gp = new GamePanel();
		cp = new ContinuePanel();
		soundp = new SoundPanel();
		
		// opening panel is MainMenuPanel
		add(mmp);
	
		try {
            FileOutputStream fileOut = new FileOutputStream("data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(game);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in data.ser");
         }catch(IOException i) {
            i.printStackTrace();
         }
		
		this.addMouseMotionListener(new MouseMotionListener(){
			@Override
			public void mouseDragged(MouseEvent arg0) {}
			@Override
			public void mouseMoved(MouseEvent event) {
				asd(event);
				
			}
		});
		this.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent event) {
            	asd(event);
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
        
	}
	
	// New frame
	public void asd (MouseEvent event) {
		try {
	        FileInputStream fileIn = new FileInputStream("data.ser");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        game = (Game) in.readObject();
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
		
		if ( game.isMainMenuPanel() ){
			setPreferredSize(new Dimension(640,412));
			//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			//setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			pack();
			add(mmp);	
			mmp.setVisible(true);
			mp.setVisible(false);
			sp.setVisible(false);
			sbp.setVisible(false);
			kp.setVisible(false);
			gp.setVisible(false);
			cp.setVisible(false);
			soundp.setVisible(false);
		}
			
		if ( game.isMultiplayer() ){
			setPreferredSize(new Dimension(640,428));
			//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			//setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			pack();
			add(mp);			
			mmp.setVisible(false);
			mp.setVisible(true);
			sp.setVisible(false);
			sbp.setVisible(false);
			kp.setVisible(false);
			gp.setVisible(false);
			cp.setVisible(false);
			soundp.setVisible(false);
		}
			
		if ( game.isChampions() ){
			setPreferredSize(new Dimension(640,428));
			//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			//setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			pack();
			add(sp);
			mmp.setVisible(false);
			mp.setVisible(false);
			sp.setVisible(true);
			sbp.setVisible(false);
			kp.setVisible(false);
			gp.setVisible(false);
			cp.setVisible(false);
			soundp.setVisible(false);
		}
		
		if ( game.isTraining() ){
			setPreferredSize(new Dimension(640,428));
			//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			//setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			pack();
			add(sp);
			mmp.setVisible(false);
			mp.setVisible(false);
			sp.setVisible(true);
			sbp.setVisible(false);
			kp.setVisible(false);
			gp.setVisible(false);
			cp.setVisible(false);
			soundp.setVisible(false);
		}
			
		if ( game.isBallStadium() ){
			setPreferredSize(new Dimension(640,428));
			//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			//setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			pack();
			add(sbp);
			mmp.setVisible(false);
			mp.setVisible(false);
			sp.setVisible(false);
			sbp.setVisible(true);
			kp.setVisible(false);
			gp.setVisible(false);
			cp.setVisible(false);
			soundp.setVisible(false);
		}
			
		if ( game.isKeyboard() ){
			setPreferredSize(new Dimension(640,428));
			//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			//setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			pack();
			add(kp);
			mmp.setVisible(false);
			mp.setVisible(false);
			sp.setVisible(false);
			sbp.setVisible(false);
			kp.setVisible(true);
			gp.setVisible(false);
			cp.setVisible(false);
			soundp.setVisible(false);
		}
			
		if ( game.isGamePanel() ){
			setPreferredSize(new Dimension(1304,813));
			//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			//setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			pack();
			add(gp);
			mmp.setVisible(false);
			mp.setVisible(false);
			sp.setVisible(false);
			sbp.setVisible(false);
			kp.setVisible(false);
			gp.setVisible(true);
			cp.setVisible(false);
			soundp.setVisible(false);
		}
			
		if ( game.isConti() ){
			setPreferredSize(new Dimension(789, 526));
			//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			//setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			pack();
			add(cp);
			mmp.setVisible(false);
			mp.setVisible(false);
			sp.setVisible(false);
			sbp.setVisible(false);
			kp.setVisible(false);
			gp.setVisible(false);
			cp.setVisible(true);
			soundp.setVisible(false);
		}
			
		if ( game.isSound() ){
			setPreferredSize(new Dimension(619, 450));
			//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			//setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			pack();
			add(soundp);
			mmp.setVisible(false);
			mp.setVisible(false);
			sp.setVisible(false);
			sbp.setVisible(false);
			kp.setVisible(false);
			gp.setVisible(false);
			cp.setVisible(false);
			soundp.setVisible(true);
		}
		
		if ( game.isSettings() ){
			setPreferredSize(new Dimension(619, 450));
			//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			//setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			pack();
			add(soundp);
			mmp.setVisible(false);
			mp.setVisible(false);
			sp.setVisible(false);
			sbp.setVisible(false);
			kp.setVisible(false);
			gp.setVisible(false);
			cp.setVisible(false);
			soundp.setVisible(true);
		}
				
		/*
		if ( game.isInst() )
			//add(soundp);
		if ( game.isCredits() )
			//add(soundp);
		*/
		repaint ();
	}	
}