package domain.servicesRest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import domain.Event;
import domain.User;
import domain.builders.UserBuilder;
import domain.servicesRest.daos.UserDAO;

@Path("user")
@Service
public class UserRest {

	private UserDAO userDAO = new UserDAO();

	@POST
	@Path("/newUser")
	@Produces("application/json")
	public User user() {
		User user = UserBuilder.aUser().build();
		return user;
	}

	@GET
	@Path("/allUsers")
	@Produces("application/json")
	public List<User> allUsers() {
		return userDAO.getUsers();
	}
	
	@GET
	@Path("/allTheFriendsFromTheUser/{userId}")
	@Produces("application/json")
	public List<User> allTheFriendsFromTheUser(@PathParam("userId") final Integer id) {
		return userDAO.getUsers().get(id).getFriends();
	}
	
	@POST
	@Path("/addEvent/{userId}")
	@Consumes("application/json")
	public Response addEvent(@PathParam("userId") final Integer id, Event event) {
		Response response;
		User user = userDAO.getUsers().get(id);
		user.addEvent(event);
        response = Response.ok().tag("El evento fue agregado correctamente").build();
        return response;
    }

	@POST
	@Path("updateUser")
	@Consumes("application/json")
	public Response updateUser() {
		//try {
			userDAO.getUsers().get(0).setLogged(false);
			return Response.ok().tag("Se actualizo el usuario correctamente")
					.build();
		//} catch (SubiQueTeLlevoException e) {
		//	return Response.serverError().tag("Error al actualizar el usuario")
		//			.build();
		//}
	}
}
