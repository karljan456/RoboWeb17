package services;

import data.Param;
import data.RoboData;

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
	public void writeSpeed(@FormParam("speed") int data) {
		Param.speed = data;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getspeed")
	public int getspeed() {
		return Param.speed;
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

