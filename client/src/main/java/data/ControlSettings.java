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
	private String command_string;
	
	public ControlSettings() {
		super();
	}

	
	public ControlSettings(int command, String command_string) {
		super();
		this.command = command;
		this.command_string = command_string;
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

	public String getCommand_string() {
		return command_string;
	}


	public void setCommand_string(String command_string) {
		this.command_string = command_string;
	}
	

}
