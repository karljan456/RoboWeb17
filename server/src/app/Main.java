package app;

import data.ServerDataExchange;

public class Main {

	private static DataExchange dataExchange;
	private static FollowLine follower;
	private static AvoidObstacles avoider;
	private static Motor motor;
	private static ServerDataExchange serverData;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Starting the program 

		dataExchange = new DataExchange();
		follower = new FollowLine(dataExchange);
		avoider = new AvoidObstacles(dataExchange);
		motor = new Motor(dataExchange);
		
		serverData = new ServerDataExchange(dataExchange);

		avoider.start();

		follower.start();
		
		serverData.start();

		motor.start();
		

		while (dataExchange.getCommand() > 0) {

		}

//		Giving some time for the celebration

		try {

			Thread.sleep(6000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.exit(0);

	}

}
