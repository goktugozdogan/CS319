package headBall;

import javax.swing.JFrame;

public class Main {
	public static JFrame frame;
	public static Game game;
	public static void main(String[] args) {
		  frame = new GameWindow ();
		  game = new Game();
	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	      //frame.dispose();
	      //  frame.add( new Game());
	      //frame.getContentPane().add (new MainPanel());
	      //frame.getContentPane().add (new FieldPanel());
	      //SoundManage sm = new SoundManage();
	      //sm.playSound();
	      //frame.pack();
	      //frame.setVisible(true);
	      //frame.setResizable(false);
	}
}