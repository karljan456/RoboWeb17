package app;

import lejos.hardware.Button;

public class Main {

	private static DataExchange dataExchange;
	private static FollowLine follower;
	private static AvoidObstacles avoider;
	private static Motor motor;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Starting the program 
		
		dataExchange = new DataExchange();
		follower = new FollowLine(dataExchange);
		avoider = new AvoidObstacles(dataExchange);
		motor = new Motor(dataExchange);
		
		
		avoider.start();

		follower.start();

		motor.start();


		while(dataExchange.getCounter() != 2) {

		
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
