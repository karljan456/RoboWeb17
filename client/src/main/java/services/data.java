package services;

import java.sql.Time;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import data.RoboData;

@Path("/robotdata")
public class data {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("robot_project");	
	
	@GET
	@Path("/robo")
	@Produces(MediaType.TEXT_PLAIN)
	public String newKid(
			@QueryParam("obstacle_detection") int obstacle_detection
			) {
		

		
		  RoboData robo=new RoboData(obstacle_detection);
		    EntityManager em=emf.createEntityManager();
		    em.getTransaction().begin();
		    em.persist(robo);
		    em.getTransaction().commit();		
		return "Data "+ obstacle_detection +" added";
	}
	@GET
	@Path("/robo2")
	@Produces(MediaType.TEXT_PLAIN)
	public String newKid2() {
		return "Data " +" added";
	}

}
