package model;

public class UserNotExistException extends Exception {

	public UserNotExistException(){
		super("The user not exist. Please put another user");
	}
}