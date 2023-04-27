package app;

import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;

public class FollowLine extends Thread{

	private DataExchange dataExchange;

	private static EV3ColorSensor sensor;
	private static SampleProvider color;
	private static float[] sample;

	public FollowLine(DataExchange dataExchange) {

		this.dataExchange = dataExchange;

		sensor = new EV3ColorSensor(SensorPort.S2);
		color = sensor.getRedMode();
		sample = new float[color.sampleSize()];
		


	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (!Button.ESCAPE.isDown()) {
			// Reading the color sensor and getting the color value
			color.fetchSample(sample, 0);
			float checkColor = sample[0];

				dataExchange.setAmountOfLight(checkColor);

		}
		// Close the color sensor
		sensor.close();

	}
}
