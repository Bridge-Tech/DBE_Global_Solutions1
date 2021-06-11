package br.com.fiap.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.dao.UserDAO;
import br.com.fiap.model.User;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class SetupEndpoint {
	
	UserDAO dao = new UserDAO();
	
	@GET
	
	public List<User> index() {
		return dao.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response create(User user) {
		if(user == null) {
			return Response.status(400).build();
		}
		try {
			dao.save(user);
		} catch (Exception e) {
			return Response.status(500).build();
		}
		return Response.status(201).entity(user).build();
	}
	
	@GET
	@Path("{id}")
	public Response show(@PathParam("id") Long id) {
		User user = dao.findById(id);
		return Response.status(200).entity(user).build();
	}
	

}
