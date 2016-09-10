package domain;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import builders.EventBuilder;
import builders.ProfileBuilder;
import builders.TourBuilder;
import builders.UserBuilder;
import model.Event;
import model.NoFriendException;
import model.Profile;
import model.Tour;
import model.Type;
import model.User;

public class UserTest {

	@Test
    public void test_addFriend(){
		User user01 = UserBuilder.aUser().build();
		User user02 = UserBuilder.aUser()
				.withProfile(new Profile(Type.ACTION,Type.REGGAETON,Type.PIZZA,250))
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
	
	@Test
    public void test_searchFriendCorrectly() throws Exception{
		User user01 = UserBuilder.aUser().build();
		User user02 = UserBuilder.aUser()
				.withProfile(new Profile(Type.ACTION,Type.REGGAETON,Type.PIZZA,250))
				.build();
		try {
			user01.addFriend(user02);
			user01.getSistem().users.add(user02);
			User u = user01.searchFriend(user02);
			Assert.assertEquals(Type.PIZZA,u.getProfile().getTypeOfFood());
		}catch (NoFriendException e) {
			fail(e.toString());
		}
	}
	
	@Test
    public void test_searchFriendIncorrectly() throws Exception{
		User user01 = UserBuilder.aUser().build();
		User user02 = UserBuilder.aUser()
				.withProfile(new Profile(Type.ACTION,Type.REGGAETON,Type.PIZZA,250))
				.build();
		try {
			user01.searchFriend(user02);
		}catch (NoFriendException e) {
			fail(e.toString());
		}
	} 
	
	@Test
    public void test_sendFriendRequest(){
		User user = UserBuilder.aUser().build();
		User friend = UserBuilder.aUser()
				.withProfile(new Profile(Type.ACTION,Type.REGGAETON,Type.PIZZA,250))
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
				.withLimitAmount(700)
				.build();
		user.loadProfile(profile);
		Assert.assertEquals(Type.ADVENTURE,user.getProfile().getTypeOfFilm());
	}
	
	@Test
    public void test_acceptFriend() {
		User user = UserBuilder.aUser().build();
		User friend = UserBuilder.aUser()
				.withProfile(new Profile(Type.ACTION,Type.ROCK,Type.PIZZA,250))
				.build();
		user.acceptFriend(friend);
		Assert.assertEquals(Type.ROCK,user.getFriends().get(0).getProfile().getTypeOfMusic());
	}
	
	@Test
    public void test_cancelFriend() {
		User user = UserBuilder.aUser().build();
		User friend = UserBuilder.aUser()
				.withProfile(new Profile(Type.ACTION,Type.ROCK,Type.PIZZA,250))
				.build();
		user.sendFriendRequest(friend);
		Assert.assertEquals(1,user.getFriendsRequests().size());
		user.cancelFriend(friend);
		Assert.assertEquals(0,user.getFriendsRequests().size());
	}
	
	@Test
    public void test_acceptTour() {
		User user = UserBuilder.aUser().build();
		Tour tour = TourBuilder.aTour()
					.withAmount(450)
					.build();
		user.acceptTour(tour);
		Assert.assertEquals(450, user.getTours().get(0).getAmount());
	}
	
	@Test
    public void test_AddEvent() {
		User user = UserBuilder.aUser().build();
		Event event = EventBuilder.aEvent()
					  .withLimitOfPersons(4)
					  .build();
		user.addEvent(event);
		Assert.assertEquals(4, user.getEvents().get(0).limitOfPersons);
	}
}	
