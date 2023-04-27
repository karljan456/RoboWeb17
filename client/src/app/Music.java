package app;

import java.io.File;
import java.util.Random;
import lejos.hardware.Sound;

public class Music extends Thread {

	Random random = new Random();

	int min = 1;

	int max = 7;

	int output = (int) (Math.random() * max + min);

	@Override
	public void run() {
		//Generating a random song for celebration 
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
