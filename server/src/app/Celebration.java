package app;

import lejos.hardware.Button;
import lejos.utility.Delay;

import java.io.File;

import lejos.hardware.Sound;

public class Celebration{
	
	public void disco () {
		
		int i = 0;
		while (i < 8) {

			Button.LEDPattern(1); // 1 - green
			Delay.msDelay(300);
			Button.LEDPattern(0); // 0 - nothing
			Delay.msDelay(100);
			Button.LEDPattern(2); // 2 - red
			Delay.msDelay(300);
			Button.LEDPattern(0); // 0 - nothing
			Delay.msDelay(100);
			Button.LEDPattern(3); // 3 - orange
			Delay.msDelay(300);
			Button.LEDPattern(0); // 0 - nothing
				i++;
		}
	}

	public void music () {
		
		
		int min = 1;

		int max = 7;

		int output = (int) (Math.random() * max + min);
		
		switch (output) {
		case 1:
			System.out.println("Rick Roll");
			Sound.playSample(new File("celebration_music.wav"), Sound.VOL_MAX);
			break;


		case 2:
			System.out.println("Giga Chad");
			Sound.playSample(new File("celebration_music3.wav"), Sound.VOL_MAX);
			break;


		case 3:
			System.out.println("Calm Down");
			Sound.playSample(new File("celebration_music4.wav"), Sound.VOL_MAX);
			break;


		case 4:
			System.out.println("Tunak Tunak Tun");
			Sound.playSample(new File("celebration_music5.wav"), Sound.VOL_MAX);
			break;

		case 5:
			System.out.println("Kala Chashma");
			Sound.playSample(new File("celebration_music7.wav"), Sound.VOL_MAX);
			break;

		case 6:
			System.out.println("The Humma Song");
			Sound.playSample(new File("celebration_music8.wav"), Sound.VOL_MAX);
			break;

		case 7:
			System.out.println("All Star");
			Sound.playSample(new File("celebration_music9.wav"), Sound.VOL_MAX);
			break;
		}

		
	}
}


