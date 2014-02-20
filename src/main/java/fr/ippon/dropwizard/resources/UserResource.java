package fr.ippon.dropwizard.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.yammer.dropwizard.hibernate.UnitOfWork;
import com.yammer.metrics.annotation.Timed;

import fr.ippon.dropwizard.core.User;
import fr.ippon.dropwizard.db.UserDao;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	@Context
	private UriInfo uriInfo;

	private UserDao userDao;

	public UserResource(UserDao userDao) {
		this.userDao = userDao;
	}

	@GET
	@Timed
	@UnitOfWork
	public List<User> getUsers() {
		return this.userDao.findAll();
	}

	@GET
	@Path("{userId}")
	@Timed
	@UnitOfWork
	public User getUser(@PathParam("userId") Long userId) {
		return this.userDao.findById(userId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Timed
	@UnitOfWork
	public Response postUser(User user) {
		User createdUser = this.userDao.persist(user);
		URI createdUri = this.uriInfo.getAbsolutePathBuilder().path(String.valueOf(createdUser.getId())).build();
		return Response.created(createdUri).build();
	}

}
