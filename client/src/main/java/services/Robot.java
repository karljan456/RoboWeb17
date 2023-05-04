package services;

import data.ControlSettings;
import data.Param;
import data.RoboData;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

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
	
	String data;

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

		List<ControlSettings> commando = em.createQuery("select a.command_string from ControlSettings a WHERE a.id = " + cmd).getResultList();
		
		Param.command_name = commando.toString();
		
		if (cmd > 1) {
			try {
				TimeUnit.SECONDS.sleep(3);
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
	@Path("/setcommandname")
	public void setCommandName() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("robot_project");
		
		EntityManager em = emf.createEntityManager();

		List<ControlSettings> command = em.createQuery("select a.command_string from ControlSettings a WHERE a.id = 5").getResultList();
		
		Param.command_name = command.toString();
		
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

		RobotChart chart = new RobotChart(new String[][] { { "1 lap", "3" }, {"2 lap", "6" }, 
			{"3 lap", "1"}, {"4 lap", "4"}, {"5 lap", "7"}
		});

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
