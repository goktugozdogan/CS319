import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame ("Direction");
	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	      frame.getContentPane().add (new MainPanel());
	      //frame.getContentPane().add (new FieldPanel());

	      frame.pack();
	      frame.setVisible(true);
	      frame.setResizable(false);

	}

}
