package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import app.DataExchange;
import lejos.hardware.Button;

public class ServerDataExchange extends Thread{
	
	private String speed = "0";
	private URL urlSpeed = null;
	private HttpURLConnection conn;
	private InputStream inputStream;
	private InputStreamReader inputReader;
	private BufferedReader reader;
	private String speedSettings;
	private DataExchange dataExchange;
	
	
	
	public ServerDataExchange(DataExchange dataExchange) {
		
		this.dataExchange = dataExchange;
		
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		sendServerSpeedData("http://192.168.1.160:8080/rest/robot/getspeed");
		
	}
	
	
	public void sendServerSpeedData(String url) {
		
		while(true) {
			
			try {
				
				urlSpeed = new URL(url);
				
				conn = (HttpURLConnection) urlSpeed.openConnection();
				
				if (conn==null) {
					break;
					}
				
				inputStream = conn.getInputStream();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			inputReader = new InputStreamReader(inputStream);
			
			reader = new BufferedReader(inputReader);
			
			
			try {
				
				while ((speed = reader.readLine()) != null) {
					
					System.out.println(speed);
					
					speedSettings = speed;
				
				}	
				int userSpeedSetting = Integer.parseInt(speedSettings);
				
				if(userSpeedSetting > 200) {
					
					dataExchange.setUserSpeedSetting(userSpeedSetting);
					
				}

				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
