package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ControlSettings {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int command;
	
	public ControlSettings() {
		super();
	}

	public ControlSettings(int speed, int command, String song) {
		super();
		this.command = command;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getCommand() {
		return command;
	}

	public void setCommand(int command) {
		this.command = command;
	}

	
	

}
