package app;

public class DataExchange {

	private boolean obstaclesDetected = false;
	private float amountOfLight = 0;
	private int counter = 0;
	private int userSpeedSetting;
	private int command = 1;
	private String command_name ="init";
	
	public int getCommand() {
		return command;
	}

	public void setCommand(int command) {
		this.command = command;
	}

	public String getCommand_name() {
		return command_name;
	}

	public void setCommand_name(String command_name) {
		this.command_name = command_name;
	}


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
	
	public int getUserSpeedSetting() {
		
		return userSpeedSetting;
		
	}
	
	public void setUserSpeedSetting(int userSpeedSetting) {
		
		this.userSpeedSetting = userSpeedSetting;
		
	}


}
