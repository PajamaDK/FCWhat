package view;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

	
public class Sound {

	public void playSound(String Sound){

		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(Sound)));
			clip.start();
	
			}
		catch (Exception e) {}
	}		
}


