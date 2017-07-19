package headBall;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel{
	private final int WIDTH = 1500, HEIGHT = 800;
	private final int DELAY = 10, IMAGE_SIZE = 300;
	
	public Panel(){
		setBackground (Color.green);
	    setPreferredSize (new Dimension(WIDTH, HEIGHT));
	    setFocusable(true);
	}
	
	public void paintComponent(Graphics page){
		super.paintComponent (page);
		
		// field
	    page.drawRect (20, 20, WIDTH - IMAGE_SIZE, HEIGHT - IMAGE_SIZE);
	}

}