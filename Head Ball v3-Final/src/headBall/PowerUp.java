package headBall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;



public class PowerUp {
	private int x, y;
	private int randomGen;
	int timeRemaning;
	int timeLimit;
	
	
	
	public PowerUp(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String getRandomPowerUpIcon() {
		randomGen = (int) (Math.random() *2);
		if(randomGen == 1)
			return "images/speedUp.png";
		else return "";
	}
	
	public void speedDown (Player p) {
		p.setSpeed(2);
	}
	
	public void jumpUp(Player p) {
		p.setJump(35);
	}
	
	
	public void freezePlayer(Player p,Timer t) {
	
		p.setSpeed(0);
		try {
			t.wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setSpeed(4);
		
	}
	

	
	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	public void speedUp(Player player) {
		player.setSpeed(9);
		
	}


}
