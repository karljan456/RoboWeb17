package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RobotChart {
	
	String[][] data;
	
	public RobotChart(String[][] data) {
		
		this.data = data; 
		
	}
	
	
	public List<Map<String, Object>> getDataPoints() {
	    List<Map<String, Object>> dataPoints = new ArrayList<Map<String, Object>>();
	    for (String[] row : data) {
	        Map<String, Object> dataPoint = new HashMap<String, Object>();
	        dataPoint.put("x", row[0]);
	        dataPoint.put("y", Integer.parseInt(row[1]));
	        dataPoints.add(dataPoint);
	    }
	    return dataPoints;
	}


}

