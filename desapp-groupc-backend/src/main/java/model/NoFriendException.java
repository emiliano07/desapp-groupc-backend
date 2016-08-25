package model;

@SuppressWarnings("serial")
public class NoFriendException extends Exception {

	public NoFriendException(){
		super("There is no friend with the name you are looking for");
	}
}