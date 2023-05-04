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
	private float multiplier;
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
					multiplier = dataExchange.getUserSpeedSetting();

					if (dataExchange.getAmountOfLight() > 0.09) {
						accelerator = 1;
					} else {
						accelerator = 4;
					}

					if (dataExchange.getAmountOfLight() > 0.33) {
						multiplier = multiplier * 2 / 5;
					} else if (dataExchange.getAmountOfLight() > 0.3) {
						multiplier = multiplier * 3 / 5;
					} else if (dataExchange.getAmountOfLight() > 0.25) {
						multiplier = multiplier * 4 / 5;
					} else if (dataExchange.getAmountOfLight() > 0.20) {
						multiplier = multiplier * 5 / 6;
					}
					rightWheel.setSpeed(40 + dataExchange.getAmountOfLight() * multiplier * accelerator);

					multiplier = dataExchange.getUserSpeedSetting();
					
					if (dataExchange.getAmountOfLight() < 0.07) {
						multiplier = multiplier / 6;
					} else if (dataExchange.getAmountOfLight() < 0.1) {
						multiplier = multiplier / 3;
					} else if (dataExchange.getAmountOfLight() < 0.12) {
						multiplier = multiplier * 3 / 5;
					}
					leftWheel.setSpeed(40 + dataExchange.getAmountOfLight() * multiplier * accelerator);
					
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
				leftWheel.setSpeed(100);
				leftWheel.backward();
				Delay.msDelay(300);
				leftWheel.stop();
			} else if (dataExchange.getCommand() == 3) {
				leftWheel.stop();
				rightWheel.stop();
				rightWheel.setSpeed(100);
				leftWheel.setSpeed(100);
				leftWheel.forward();
				rightWheel.forward();
				Delay.msDelay(300);
				leftWheel.stop();
				rightWheel.stop();
			} else if (dataExchange.getCommand() == 4) {
				leftWheel.stop();
				rightWheel.stop();
				rightWheel.setSpeed(100);
				leftWheel.setSpeed(100);
				rightWheel.backward();
				Delay.msDelay(300);
				rightWheel.stop();
			} else if (dataExchange.getCommand() == 5) {
				leftWheel.stop();
				rightWheel.stop();
				rightWheel.setSpeed(100);
				leftWheel.setSpeed(100);
				leftWheel.backward();
				rightWheel.backward();
				Delay.msDelay(300);
				leftWheel.stop();
				rightWheel.stop();
			} else if (dataExchange.getCommand() == 6) {
				leftWheel.stop();
				rightWheel.stop();
			} else if (dataExchange.getCommand() == 7) {
				leftWheel.stop();
				rightWheel.stop();
				celeb.music();
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
				rightWheel.stop();
			} else if (dataExchange.getCommand() == 9) {
				leftWheel.stop();
				rightWheel.stop();
				celeb.disco();
			}
		}
		// Stop the motors
		leftWheel.stop(true);
		rightWheel.stop(true);
		//send data to restful service with PathParam
	}
}
