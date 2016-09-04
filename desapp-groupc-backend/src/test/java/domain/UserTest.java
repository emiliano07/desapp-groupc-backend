package domain;

import org.junit.Test;

import builders.ProfileBuilder;
import builders.UserBuilder;
import junit.framework.Assert;
import model.Profile;
import model.Type;
import model.TypeOfTransport;
import model.User;

public class UserTest {

	@Test
    public void test_addFriend(){
		User user01 = UserBuilder.aUser().build();
		User user02 = UserBuilder.aUser()
				.withProfile(new Profile(Type.ACTION,Type.REGGAETON,Type.PIZZA,250,TypeOfTransport.CAR))
				.build();
		user01.addFriend(user02);
		Assert.assertEquals(1,user01.getFriends().size());
    }
	
	@Test
    public void test_deleteFriend(){
		User user01 = UserBuilder.aUser().build();
		User user02 = UserBuilder.aUser().build();
		user01.addFriend(user02);
		user01.deleteFriend(user02);
		Assert.assertEquals(0,user01.getFriends().size());
    }
	
//	@Test
//    public void test_searchFriend() throws Exception{
//		User user01 = UserBuilder.aUser().build();
//		User user02 = UserBuilder.aUser()
//				.withProfile(new Profile(Type.ACTION,Type.REGGAETON,Type.PIZZA,250,TypeOfTransport.CAR))
//				.build();
//	try {
//		user01.addFriend(user02);
//		user01.getSistem().users.add(user02);
//        User u = user01.searchFriend(user02);
//        Assert.assertEquals(Type.PIZZA,u.getProfile().getTypeOfFood());
//	}catch (NoFriendException e) {
//        Assert.fail("There is no friend with the name you are looking for");
//     }
//  }
	
	@Test
    public void test_sendFriendRequest(){
		User user = UserBuilder.aUser().build();
		User friend = UserBuilder.aUser()
				.withProfile(new Profile(Type.ACTION,Type.REGGAETON,Type.PIZZA,250,TypeOfTransport.CAR))
				.build();
		user.sendFriendRequest(friend);
		Assert.assertEquals(Type.PIZZA,user.getFriendsRequests().get(0).getProfile().getTypeOfFood());
	}
	
	@Test
    public void test_loadProfile() {
		User user = UserBuilder.aUser().build();
		Profile profile = ProfileBuilder.aProfile()
				.withTypeOfMusic(Type.ELECTRONIC)
				.withTypeOfFilm(Type.ADVENTURE)
				.withTypeOfFood(Type.GRILL)
				.withTypeOfTransport(TypeOfTransport.CAR)
				.withLimitAmount(700)
				.build();
		user.loadProfile(profile);
		Assert.assertEquals(Type.ADVENTURE,user.getProfile().getTypeOfFilm());
	}
}	
