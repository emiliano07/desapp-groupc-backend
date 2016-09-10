package model;

public class InvalidPasswordException extends Exception {

	public InvalidPasswordException(){
		super("The password is invalid. Please choise one between 4 to 12 characters");
	}
}