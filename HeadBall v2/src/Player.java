import java.io.*;

import javax.swing.ImageIcon;

public class Player implements Serializable{
	private int keyNumber;
	private ImageIcon image;
	private int x, y;
	private int speed;
	private int jump;
	private boolean directionx, directionY;
	
	public Player(){
		image = new ImageIcon();
	}
	
	public int getKey(){
		return keyNumber;
	}
	public void setKey(int keyNumber){
		this.keyNumber = keyNumber;
	}
	
	public ImageIcon getPlayerImage(){
		return image;
	}
	public void setPlayerImage(ImageIcon image){
		this.image = image;
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
