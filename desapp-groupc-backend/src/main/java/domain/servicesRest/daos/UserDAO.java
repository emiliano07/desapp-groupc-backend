package domain.servicesRest.daos;

import java.util.ArrayList;
import java.util.List;

import domain.User;
import domain.servicesRest.Fixture;

public class UserDAO {

		private List<User> users= new ArrayList<User>();

		public UserDAO() {
			this.users = Fixture.createUsers();
		}

		public List<User> getUsers() {
			return users;
		}
}
