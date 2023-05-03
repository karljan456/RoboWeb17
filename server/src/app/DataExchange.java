package app;

public class DataExchange {

	private boolean obstaclesDetected = false;
	private float amountOfLight = 0;
	private int counter = 0;
	private int speed = 550;
	
	private int userSpeedSetting;

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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
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
	
	public int getUserSpeedSetting() {
		
		return userSpeedSetting;
		
	}
	
	public void setUserSpeedSetting(int userSpeedSetting) {
		
		this.userSpeedSetting = userSpeedSetting;
		
	}


}
