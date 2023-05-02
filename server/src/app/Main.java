package app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.lang.*;

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

		URL url = null;
		HttpURLConnection conn = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String s = null;

		while (dataExchange.getCounter() != 2) {

			try {

				url = new URL("http://192.168.0.116:8080/rest/robot/getspeed");

				conn = (HttpURLConnection) url.openConnection();
				InputStream is = null;
				
				try {
					is = conn.getInputStream();
				} catch (Exception e) {
					System.out.println("Exception conn.getInputSteam()");
					e.printStackTrace();
					System.out.println("Cannot get InputStream!");
				}
				isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
				String symb ="0";
				while ((s = br.readLine()) != null) {
					System.out.println(s);
					symb = symb + s ;
				}
				int spd = Integer.parseInt(symb);
				dataExchange.setSpeed(spd);
						
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Some problem!");
			}
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
