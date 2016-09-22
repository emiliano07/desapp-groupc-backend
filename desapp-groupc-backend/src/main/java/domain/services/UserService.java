package domain.services;

import domain.repositories.UserRepository;

public class UserService {

	private UserRepository userRepository;

	public UserService() {
	}

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

}
