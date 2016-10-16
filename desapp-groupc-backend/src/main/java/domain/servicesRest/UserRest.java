package domain.servicesRest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import domain.User;
import domain.builders.UserBuilder;
import domain.services.UserService;

@Path("/user")
public class UserRest {

	UserService userService;
	
	public UserRest() {}
	
	public UserRest(UserService userService) {
		this.userService = userService;
	}

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
		return userService.getUserRepository().findAll();
	}
	
	@GET
	@Path("/userFrom/{userId}")
	@Produces("application/json")
	public User allTheFriendsFromTheUser(@PathParam("userId") final int id) {
		return userService.getUserRepository().findById(id);
	}
	
//	@POST
//	@Path("/addEvent/{userId}")
//	@Consumes("application/json")
//	public Response addEvent(@PathParam("userId") final int id, Event event) {
//		Response response;
//		User user = userService.getUserRepository().findById(id);
//		user.addEvent(event);
//        response = Response.ok().tag("El evento fue agregado correctamente").build();
//        return response;
//    }

//	@POST
//	@Path("updateUser")
//	@Consumes("application/json")
//	public Response updateUser() {
//		//try {
//			userDAO.getUsers().get(0).setLogged(false);
//			return Response.ok().tag("Se actualizo el usuario correctamente")
//					.build();
//		//} catch (SubiQueTeLlevoException e) {
//		//	return Response.serverError().tag("Error al actualizar el usuario")
//		//			.build();
//		//}
//	}
}
