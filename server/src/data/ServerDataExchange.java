package data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import app.DataExchange;
public class ServerDataExchange extends Thread {
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
		getData();

	}
	public void getData() {
		while (dataExchange.getCommand() > 0) {
			try {
				urlSpeed = new URL("http://192.168.1.160:8080/rest/robot/getspeed");
				conn = (HttpURLConnection) urlSpeed.openConnection();
				if (conn == null) {
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
//					System.out.println(speed);
					speedSettings = speed;
				}
				int userSpeedSetting = Integer.parseInt(speedSettings);
				dataExchange.setUserSpeedSetting(userSpeedSetting);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// command read
			try {
				urlSpeed = new URL("http://192.168.1.160:8080/rest/robot/getcommand");
				conn = (HttpURLConnection) urlSpeed.openConnection();
				if (conn == null) {
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
//					System.out.println(speed);
					speedSettings = speed;
				}
				int userSpeedSetting = Integer.parseInt(speedSettings);
				dataExchange.setCommand(userSpeedSetting);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//commandname read
			try {
				urlSpeed = new URL("http://192.168.1.160:8080/rest/robot/getcommandname");
				conn = (HttpURLConnection) urlSpeed.openConnection();
				if (conn == null) {
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
//					System.out.println(speed);
					speedSettings = speed;
				}
				dataExchange.setCommand_name(speedSettings);;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//finalizing routine
//sending counter of obstacle detection
		try {
			urlSpeed = new URL("http://192.168.1.160:8080/rest/robot/putdata/" + dataExchange.getCounter());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = (HttpURLConnection) urlSpeed.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	

	

}