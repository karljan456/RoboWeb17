package app;

public class DataExchange {

	private boolean obstaclesDetected = false;
	private float amountOfLight = 0;
	private int counter = 0;
	private int speed = 550;
	
	private int userSpeedSetting;
	
	private int stopButton;
	private int danceButton;
	private int lightsButton;
	private int musicButton;

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

	public int getStopButton() {
		return stopButton;
	}
	
	public void setStopButton(int stopButton) {
		this.stopButton = stopButton;
	}
	
	public int getDanceButton() {
		return danceButton;
	}
	
	public void setDanceButton(int danceButton) {
		this.danceButton = danceButton;
	}
	
	public int getLightsButton() {
		return lightsButton;
	}
	
	public void setLightsButton(int lightsButton) {
		this.lightsButton = lightsButton;
	}
	
	public int getMusicButton() {
		return musicButton;
	}
	
	public void setMusicButton(int musicButton) {
		this.musicButton = musicButton;
	}


}
