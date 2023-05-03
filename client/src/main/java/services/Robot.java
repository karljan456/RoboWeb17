package services;

import data.Param;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/robot")
public class Robot {

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
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getcommand")
	public int getCommand() {
		return Param.command;
	}
	

	
//	@GET
//	@Path("/robodata")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String newKid(
//			@QueryParam("start_time") Timestamp start_time,
//			@QueryParam("end_time") Timestamp end_time,
//			@QueryParam("speed") int speed,
//			@QueryParam("obstacle_detection") int obstacle_detection,
//			@QueryParam("laps_count") int laps_count
//			) {
//		  RoboData robo=new RoboData(start_time,end_time,speed,obstacle_detection,laps_count);
//		    EntityManager em=emf.createEntityManager();
//		    em.getTransaction().begin();
//		    em.persist(robo);
//		    em.getTransaction().commit();		
//		return "Data "+ speed +" added";
//	}
}

