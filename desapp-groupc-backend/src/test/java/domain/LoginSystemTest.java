package domain;

import org.junit.Assert;
import org.junit.Test;

import builders.UserBuilder;
import exceptions.InvalidPasswordException;
import exceptions.UserNameAlreadyExistException;
import model.User;

public class LoginSystemTest {
	
	@Test
    public void registerNewUserCorrectly() throws Exception{
		User user = UserBuilder.aUser().build();
		user.getSistem().registerNewUser("franciolucio", "1234", "franciolucio@gmail.com");
		Assert.assertEquals("franciolucio", user.getSistem().users.get(0).userName);
	}
	
	@Test
    public void registerNewUserIncorrectlyBecauseThereIsAlreadyAUserWithTheUsername() throws Exception{
		User user = UserBuilder.aUser().build();
		User userBis = UserBuilder.aUser().withUserName("franciolucio").build();
		user.getSistem().logSistem.users.put(userBis.userName, userBis.password);
		try {
			user.getSistem().registerNewUser("franciolucio", "1234", "franciolucio@gmail.com");
		}catch (UserNameAlreadyExistException e) {
			 System.out.println(e);
		}
	}
	
	@Test
    public void registerNewUserIncorrectlybecauseNoRegardPassword01() throws Exception{
		User user = UserBuilder.aUser().withPassword("123").build();
		try {
			user.getSistem().registerNewUser("franciolucio", "1234", "franciolucio@gmail.com");
			Assert.assertEquals("franciolucio", user.getSistem().users.get(0).userName);
		}catch (InvalidPasswordException e) {
			 System.out.println(e);
		}
	}
}
