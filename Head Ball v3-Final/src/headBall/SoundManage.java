package headBall;

import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//sound manager that opens sound from ws
public class SoundManage{
	Clip clipMusic, clipKick;
	public void playSound() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("soundtract/sd.wav").getAbsoluteFile());
	        clipMusic = AudioSystem.getClip();
	        clipMusic.open(audioInputStream);
	        clipMusic.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public void stopSound() {
		clipMusic.stop();
	}
	
	public void playKickSound() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("soundtract/kick.wav").getAbsoluteFile());
	        clipKick = AudioSystem.getClip();
	        clipKick.open(audioInputStream);
	        clipKick.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public void stopKickSound() {
		clipKick.stop();
	}
	

}
