package services;

import data.ControlSettings;
import data.Param;
import data.RoboData;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.google.appengine.repackaged.com.google.gson.Gson;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import data.RobotChart;

@Path("/robot")
public class Robot {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("robot_project");

	@POST
	@Path("/writespeed")
	@Consumes("application/x-www-form-urlencoded")
	public void writeSpeed(@FormParam("speed") String data) {
		int speed = Integer.valueOf(data);
		Param.speed = speed;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getspeed")
	public int getspeed() {
		return Param.speed;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/writecommand")
	public void writeCommand(@FormParam("command") String command) {
		int cmd = Integer.valueOf(command);
		Param.command = cmd;
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("robot_project");
		
		EntityManager em = emf.createEntityManager();

		List<ControlSettings> commando = em.createQuery("select a.command_string from ControlSettings a WHERE a.command = " + cmd).getResultList();
		
		Param.command_name = commando.toString();
		
		if (cmd > 1) {
			try {
				TimeUnit.SECONDS.sleep(2);
				Param.command = 99;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getcommand")
	public int getCommand() {
		return Param.command;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getcommandname")
	public String getCommandName() {
		
		return Param.command_name;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getchartdata")
	public List<Map<String, Object>> getChartData() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("robot_project");
	    EntityManager em = emf.createEntityManager();

	    List<Object[]> data = em.createQuery("select a.obstacle_detection, a.id from RoboData a order by a.id asc")
	                            .getResultList();

	    String[][] chartData = new String[data.size()][2];
	    int i = 0;
	    for (Object[] row : data) {
	        chartData[i][0] = row[1].toString(); 
	        chartData[i][1] = row[0].toString(); 
	        i++;
	    }

	    RobotChart chart = new RobotChart(chartData);


	    return chart.getDataPoints();
	}

	
	
	@GET
	@Path("/putdata/{par}")
	public void putData(@PathParam("par") int ob) {
		
		RoboData robo = new RoboData(ob);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(robo);
		em.getTransaction().commit();
		
	}
	
	@GET
	@Path("/getobstacles")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RoboData> getObstacles() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("robot_project");
		
		EntityManager em = emf.createEntityManager();

		List<RoboData> obstacle = em.createQuery("select a.obstacle_detection from RoboData a").getResultList();
		
		return obstacle;
		
	}
	

	
}
