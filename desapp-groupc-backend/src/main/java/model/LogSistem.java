package model;

import java.util.HashMap;
import java.util.Map;

import exceptions.InvalidPasswordException;
import exceptions.PasswordNotmatchException;
import exceptions.UserNameAlreadyExistException;
import exceptions.UserNameNotmatchException;

public class LogSistem {

	public Map<String,String> users;
	
	public LogSistem(){
		this.users = new HashMap<String, String>();
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Methods
	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void newUser(String userName, String password) throws Exception{
		this.validateNewUser(userName);
		this.validatePassword(password);
	}
		
	public void validateNewUser(String userName) throws Exception{
		if(this.users.containsKey(userName)){
			throw new UserNameAlreadyExistException();
		}
	}
	
	public void validatePassword(String password) throws Exception{
		if(password.length() < 4 || password.length() > 12){
			throw new InvalidPasswordException();
		}
	}
	
	public void logIn(String userName, String password) throws Exception{
		this.validateLog(userName, password);
	}
	
	public void validateLog(String userName, String password) throws Exception{
		if(!this.users.containsKey(userName)){
			throw new UserNameNotmatchException();
		}
		else{
			if(this.users.get(userName) != password){
				throw new PasswordNotmatchException();
			}
		}
	}
	
	public void changePassword(String userName, String oldPassword, String newPassword)throws Exception{
		this.validateLog(userName, oldPassword);
		this.validatePassword(newPassword);
	}
}