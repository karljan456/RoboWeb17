package app;

import lejos.hardware.Button;
import lejos.utility.Delay;

public class Disco extends Thread {


	@Override
	public void run() {

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

		}

	}
}
