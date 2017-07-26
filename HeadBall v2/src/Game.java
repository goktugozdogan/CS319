import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Game implements Serializable{
	
	boolean mainMenuPanel, gamePanel;
	// MainMenu Play
	boolean champions, conti, multiplayer, training;
	// MainMenu Customize
	boolean settings, sound, ballStadium, keyboard;
	// MainMenu Extras
	boolean credits, inst;
	
	// Players
	Player player1, player2;
	// Time & Score Limit
	int timeLimit, scoreLimit;
	boolean isTime;
	// Team
	ImageIcon team;
	// Difficulty
	int diff;
	
	public Game(){
		 mainMenuPanel = true;
		 gamePanel = false;
		 // MainMenu Play
		 champions = false;
		 conti = false;
		 multiplayer = false;
		 training = false;
		 // MainMenu Customize
		 settings = false;
		 sound = false;
		 ballStadium = false;
		 keyboard = false;
		 // MainMenu Extras
		 credits = false;
		 inst = false;
		 
		 // Players
		 player1 = new Player();
		 player2 = new Player();
		 
		 // Time & Score Limit
		 timeLimit = 30;
		 scoreLimit = 7;
		 isTime = false;
		 
		 // Team
		 team = new ImageIcon();
		 
		 // Difficulty
		 diff = 1;
	}

	public boolean isMainMenuPanel() {
		return mainMenuPanel;
	}

	public void setMainMenuPanel(boolean mainMenuPanel) {
		this.mainMenuPanel = mainMenuPanel;
	}

	public boolean isGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(boolean gamePanel) {
		this.gamePanel = gamePanel;
	}

	public boolean isChampions() {
		return champions;
	}

	public void setChampions(boolean champions) {
		this.champions = champions;
	}

	public boolean isConti() {
		return conti;
	}

	public void setConti(boolean conti) {
		this.conti = conti;
	}

	public boolean isMultiplayer() {
		return multiplayer;
	}

	public void setMultiplayer(boolean multiplayer) {
		this.multiplayer = multiplayer;
	}

	public boolean isTraining() {
		return training;
	}

	public void setTraining(boolean training) {
		this.training = training;
	}

	public boolean isSettings() {
		return settings;
	}

	public void setSettings(boolean settings) {
		this.settings = settings;
	}

	public boolean isSound() {
		return sound;
	}

	public void setSound(boolean sound) {
		this.sound = sound;
	}

	public boolean isBallStadium() {
		return ballStadium;
	}

	public void setBallStadium(boolean ballStadium) {
		this.ballStadium = ballStadium;
	}

	public boolean isKeyboard() {
		return keyboard;
	}

	public void setKeyboard(boolean keyboard) {
		this.keyboard = keyboard;
	}

	public boolean isCredits() {
		return credits;
	}

	public void setCredits(boolean credits) {
		this.credits = credits;
	}

	public boolean isInst() {
		return inst;
	}

	public void setInst(boolean inst) {
		this.inst = inst;
	}
	
	// KEYBOARD
	public void setP1Keyboard(int i){
		if ( i == 1 )
			player1.setKey(1);
		if ( i == 2 )
			player1.setKey(2);
		if ( i == 3 )
			player1.setKey(3);
	}
	public void setP2Keyboard(int i){
		if ( i == 1 )
			player2.setKey(1);
		if ( i == 2 )
			player2.setKey(2);
		if ( i == 3 )
			player2.setKey(3);
	}
	
	// PLAYER IMAGE
	public void setPlayer1Image(ImageIcon image){
		player1.setPlayerImage(image);
	}
	public void setPlayer2Image(ImageIcon image){
		player2.setPlayerImage(image);
	}
	public ImageIcon getPlayer1Image(){
		return player1.getPlayerImage();
	}
	public ImageIcon getPlayer2Image(){
		return player2.getPlayerImage();
	}
	
	// TIME OR SCORE LÝMÝT
	public int getTime(){
		return timeLimit;
	}
	public void setTime(int timeLimit){
		this.timeLimit = timeLimit;
	}
	
	public int getScoreLimit(){
		return scoreLimit;
	}
	public void setScoreLimit(int scoreLimit){
		this.scoreLimit = scoreLimit;
	}
	public boolean getIsTime(){
		return isTime;
	}
	public void setIsTime(boolean isTime){
		this.isTime = isTime;
	}
	
	// IN-GAME ACTIONS
	public void start(){
		
	}
	public void pause(){
		
	}
	public void continueGame(){
		
	}
	public void end(){
		
	}
	public void createSeason(){
		
	}
	
	// TEAM
	public ImageIcon getTeam(){
		return team;
	}
	public void setTeam(ImageIcon team){
		this.team = team;
	}
	
	// DIFFICULTY
	public int getDifficulty(){
		return diff;
	}
	public void setDifficulty(int diff){
		this.diff = diff;
	}
}
