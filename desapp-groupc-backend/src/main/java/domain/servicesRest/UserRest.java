package domain.servicesRest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import domain.User;
import domain.builders.UserBuilder;
import domain.servicesRest.daos.UserDAO;

@Path("/user")
public class UserRest {

	private UserDAO userDAO = new UserDAO();

	@GET
	@Path("")
	@Produces("application/json")
	public User user() {
		User user = UserBuilder.aUser()
				.withLogged(true)
				.withUserName("IloveBenjamin")
				.withPassword("NILAMASPUTAIDEA").build();
		return user;
	}

	@GET
	@Path("/allUsers")
	@Produces("application/json")
	public List<User> allUsers() {
		return userDAO.getUsers();
	}
}
