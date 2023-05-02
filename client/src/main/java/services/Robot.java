package services;

import data.Param;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

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
}

