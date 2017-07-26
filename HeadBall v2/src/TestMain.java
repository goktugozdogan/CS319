import javax.swing.JFrame;

public class TestMain {
	public static JFrame frame;
	public static void main(String[] args){
		MainMenuPanel mmp = new MainMenuPanel();
		MultipalyerPanel mp = new MultipalyerPanel();
		SinglePlayerPanel sp= new SinglePlayerPanel();
		StadiumBallPanel sbp = new StadiumBallPanel();
		KeyboardPanel kp = new KeyboardPanel();
		GamePanel gp = new GamePanel();
		ContinuePanel cp = new ContinuePanel();
		SoundPanel soundp = new SoundPanel();
		
		
		frame = new GameWindow();	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.add(mmp);	
		//frame.setVisible(true);
		frame.pack();
	}

}
