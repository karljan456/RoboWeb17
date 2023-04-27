package app;

public class DataExchange {

	private boolean obstaclesDetected = false;
	private float amountOfLight = 0;
	private int counter = 0;

	public DataExchange() {

	}

	public void setObstaclesDetected(boolean obstaclesDetected) {

		this.obstaclesDetected = obstaclesDetected;

	}
	public boolean getObstaclesDetected() {

		return obstaclesDetected;

	}

	public void setAmountOfLight(float amountOfLight) {
		this.amountOfLight = amountOfLight;
	}

	public float getAmountOfLight() {
		return amountOfLight;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}




}
