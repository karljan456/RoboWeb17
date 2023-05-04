package app;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;
public class Motor extends Thread {
	private DataExchange dataExchange;
	private static EV3LargeRegulatedMotor leftWheel;
	private static EV3LargeRegulatedMotor rightWheel;
	private static int counter = 0;
	private static Celebration celeb;
	private float accelerator;
	public Motor(DataExchange dataExchange) {
		this.dataExchange = dataExchange;
		leftWheel = new EV3LargeRegulatedMotor(MotorPort.A);
		rightWheel = new EV3LargeRegulatedMotor(MotorPort.D);
		celeb = new Celebration();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (dataExchange.getCommand() > 0) {
			System.out.println(dataExchange.getCommand_name());
			if (dataExchange.getCommand() == 1) {
				// Obstacle detection check
				if (dataExchange.getObstaclesDetected() == false) {
					// speed of the wheels is set according to amount of light, turning by giving
					// slower speed to wheel in which side robot turns
					// accelerator variable is used to make robot go faster on darker segments of
					// pathway
					int userSpeed = dataExchange.getUserSpeedSetting();
//				Speed from the user
					if (dataExchange.getAmountOfLight() > 0.09) {
						accelerator = 1;
					} else {
						accelerator = 4;
					}
					userSpeed = dataExchange.getUserSpeedSetting();
					if (dataExchange.getAmountOfLight() > 0.33) {
						userSpeed = userSpeed * 2 / 5;
					} else if (dataExchange.getAmountOfLight() > 0.3) {
						userSpeed = userSpeed * 3 / 5;
					} else if (dataExchange.getAmountOfLight() > 0.25) {
						userSpeed = userSpeed * 4 / 5;
					} else if (dataExchange.getAmountOfLight() > 0.20) {
						userSpeed = userSpeed * 5 / 6;
					}
					rightWheel.setSpeed(40 + dataExchange.getAmountOfLight() * userSpeed * accelerator);
					userSpeed = dataExchange.getUserSpeedSetting();
					if (dataExchange.getAmountOfLight() < 0.07) {
						userSpeed = userSpeed / 6;
					} else if (dataExchange.getAmountOfLight() < 0.1) {
						userSpeed = userSpeed / 3;
					} else if (dataExchange.getAmountOfLight() < 0.12) {
						userSpeed = userSpeed * 3 / 5;
					}
					leftWheel.setSpeed(40 + dataExchange.getAmountOfLight() * userSpeed * accelerator);
				}
				else {
					counter++;
					dataExchange.setCounter(counter);
//				Obstacle Avoidance	
//				Taking the first turn after detecting the obstacle
					rightWheel.setSpeed(300);
					leftWheel.setSpeed(128);
					try {
						Thread.sleep(1200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
//              Taking another turn to avoid obstacle
					rightWheel.setSpeed(150);
					leftWheel.setSpeed(270);
					try {
						Thread.sleep(3200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					rightWheel.setSpeed(270);
					leftWheel.setSpeed(150);
					try {
						Thread.sleep(1700);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// Moving the robot forward
				rightWheel.forward();
				leftWheel.forward();
				// end of main routine
			}
			else if (dataExchange.getCommand() == 2) {
				leftWheel.stop();
				rightWheel.stop();
				rightWheel.rotate(200, true);
				leftWheel.rotate(-200, true);
			} else if (dataExchange.getCommand() == 3) {
				leftWheel.stop();
				rightWheel.stop();
				rightWheel.rotate(200, true);
				leftWheel.rotate(200, true);
			} else if (dataExchange.getCommand() == 4) {
				leftWheel.stop();
				rightWheel.stop();
				rightWheel.rotate(-200, true);
				leftWheel.rotate(200, true);
			} else if (dataExchange.getCommand() == 5) {
				leftWheel.stop();
				rightWheel.stop();
				rightWheel.rotate(-200, true);
				leftWheel.rotate(-200, true);
			} else if (dataExchange.getCommand() == 6) {
				leftWheel.stop();
				rightWheel.stop();
			} else if (dataExchange.getCommand() == 7) {
				celeb.start();
			} else if (dataExchange.getCommand() == 8) {
				leftWheel.stop();
				rightWheel.stop();
				leftWheel.setSpeed(200);
				rightWheel.setSpeed(200);
				leftWheel.backward();
				rightWheel.backward();
				Delay.msDelay(1100);
				leftWheel.stop();
				rightWheel.stop();
				rightWheel.rotateTo(180);
				Delay.msDelay(300);
			} else if (dataExchange.getCommand() == 9) {
				celeb.start();
			}
		}
		// Stop the motors
		leftWheel.stop(true);
		rightWheel.stop(true);
	}
}
