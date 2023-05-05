package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoboData {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int obstacle_detection;


	public RoboData() {
		super();
	}

	public RoboData( int obstacle_detection) {
		super();
		this.obstacle_detection = obstacle_detection;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getObstacle_detection() {
		return obstacle_detection;
	}

	public void setObstacle_detection(int obstacle_detection) {
		this.obstacle_detection = obstacle_detection;
	}


	
}

