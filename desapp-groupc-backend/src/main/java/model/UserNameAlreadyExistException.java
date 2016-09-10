package model;

public class UserNameAlreadyExistException extends Exception {

	public UserNameAlreadyExistException(){
		super("The user name already exist. Please choise another user name");
	}
}