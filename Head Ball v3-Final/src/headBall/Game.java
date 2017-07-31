package headBall;

import java.io.Serializable;
import javax.swing.ImageIcon;

public class Game implements Serializable{
	
	private static final long serialVersionUID = 1L;
	boolean mainMenuPanel, gamePanel;
	// MainMenu Play
	boolean champions, conti, multiplayer, training;
	// MainMenu Customize
	boolean settings, sound, ballStadium, keyboard;
	// MainMenu Extras
	boolean credits, inst;
	
	// Players
	Player player1, player2;
	int Player1, Player2;
	// Time & Score Limit
	int timeLimit, scoreLimit;
	
	boolean isTime, isPlay;
	// Team
	int team;
	// Difficulty
	int diff;
	// Ball & Stadium
	int ballImage, stadiumImage;
	// Season
	boolean seasonCreated;
	int[] arr8, arr4, arr2;
	int stage;
	
	boolean mainMenuPressed;
	boolean AI;
	int ball;
	
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
		 
		 isPlay = false;
		 
		 // Players
		 player1 = new Player();
		 player2 = new Player();
		 
		 // Time & Score Limit
		 timeLimit = 30;
		 scoreLimit = 7;
		 isTime = false;
		 
		 AI = true;
		 mainMenuPressed = false;
		 ball = 6;
		 Player1 = 1;
		 Player2 = 5;
		 
		 // Team
		 team = 15;
		 
		 // Difficulty
		 diff = 1;
		 
		// Ball & Stadium
		ballImage = 6;
		stadiumImage = 1;
		
		// Season
		seasonCreated = false;
		arr8 = new int[8];
		arr4 = new int[4];
		arr2 = new int[2];
		stage = 8;
	}
	
	public boolean isMainMenuPressed() {
		return mainMenuPressed;
	}

	public void setMainMenuPressed(boolean mainMenuPressed) {
		this.mainMenuPressed = mainMenuPressed;
	}

	public int getBall() {
		return ball;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}

	public int getPlayer1() {
		return Player1;
	}

	public void setPlayer1(int player1) {
		Player1 = player1;
	}

	public int getPlayer2() {
		return Player2;
	}

	public void setPlayer2(int player2) {
		Player2 = player2;
	}

	public boolean isAI() {
		return AI;
	}

	public void setAI(boolean aI) {
		AI = aI;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public boolean isSeasonCreated() {
		return seasonCreated;
	}

	public void setSeasonCreated(boolean seasonCreated) {
		this.seasonCreated = seasonCreated;
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
	
	// TIME OR SCORE LIMIT
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
	public boolean isPlaying(){
		return isPlay;
	}
	
	public boolean isPlay() {
		return isPlay;
	}

	public void setPlay(boolean isPlay) {
		this.isPlay = isPlay;
	}
	
	public int[] generateStage8(){
		for ( int i = 0; i < 8; i++ ){
			if(Math.random() < 0.5)
				arr8[i] = 1;
			else
				arr8[i] = 2;
		}
		return arr8;
	}
	
	public int[] generateStage4(){
		for ( int i = 0; i < 8; i++ ){
			if(Math.random() < 0.5)
				arr4[i] = 1;
			else
				arr4[i] = 2;
		}
		return arr4;
	}
	
	public int[] generateStage2(){
		for ( int i = 0; i < 8; i++ ){
			if(Math.random() < 0.5)
				arr2[i] = 1;
			else
				arr2[i] = 2;
		}
		return arr2;
	}

	// TEAM
	public int getTeam(){
		return team;
	}
	public void setTeam(int team){
		this.team = team;
	}
	
	// DIFFICULTY
	public int getDifficulty(){
		return diff;
	}
	public void setDifficulty(int diff){
		this.diff = diff;
	}
	
	// BALL & STADIUM
	public int getBallImage(){
		return ballImage;
	}
	public int getStadiumImage(){
		return stadiumImage;
	}
	public void setBallImage(int ballImage){
		this.ballImage = ballImage;
	}
	public void setStadiumImage(int stadiumImage){
		this.stadiumImage = stadiumImage;
	}
}
