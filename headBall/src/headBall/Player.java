package headBall;

public class Player {
	private int x, y;
	private int speed;
	private int jump;
	private boolean directionx, directionY;
	
	public Player() {
	/*	x= 0;
		y = 0;
		speed = 0;
		jump = 0;
		directionx = false;
		directionY = false;*/
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y= y;
	}
	public int getJump() {
		return jump;
	}
	public void setJump(int jump) {
		this.jump = jump;
	}
	
	public boolean getDirX() {
		return directionx;
		
	}
	public boolean getDirY() {
		return directionY;
	}
	
	public void setDirX(boolean d) {
		this.directionx=d;
		
	}
	public void setDirY(boolean d) {
		this.directionY = d;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getSpeed() {
		return speed;
	}
}
