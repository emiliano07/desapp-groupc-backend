package domain;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import builders.EventBuilder;
import builders.TourBuilder;
import builders.UserBuilder;
import model.Event;
import model.Tour;
import model.User;
import types.TypeOfScheduler;
import types.TypeOfTour;

public class SystemTest {
	
	@Test
    public void newTour() {
		ArrayList<User> friends = new ArrayList<User>();
		friends.add(UserBuilder.aUser().build());
		friends.add(UserBuilder.aUser().build());
		User user = UserBuilder.aUser()
					.withFriends(friends)
					.build();
		Event event = EventBuilder.aEvent()
					  .withAddress("Quilmes")
					  .withDate(new Date())
					  .withScheduler(TypeOfScheduler.NIGHT)
					  .withAmount(200)
					  .withLimitOfPersons(1)
					  .build();
		user.getSistem().addEvent(event);
		user.newTour(TypeOfTour.GASOLERA, new Date(), TypeOfScheduler.NIGHT, 300, friends);
		Assert.assertEquals("Quilmes",user.tours.get(0).getEventOptions1().get(0).address);
	}
	
	@Test
    public void selectEvent1ForATour() {
		User user = UserBuilder.aUser().build();
		Event event = EventBuilder.aEvent()
					  .withAddress("Bernal")
					  .build();
		Tour tour = TourBuilder.aTour().build();
		user.getSistem().selectEvent1ForATour(event, tour);
		Assert.assertEquals("Bernal",tour.event1.address);
	}
	
	@Test
    public void selectEvent2ForATour() {
		User user = UserBuilder.aUser().build();
		Event event01 = EventBuilder.aEvent()
					  .withAddress("Berazategui")
					  .withAmount(300)
					  .build();
		Tour tour = TourBuilder.aTour().build();
		user.getSistem().selectEvent2ForATour(event01, tour);
		Assert.assertEquals("Berazategui",tour.event2.address);
	}
	
	@Test
    public void refreshEvents2() {
		ArrayList<User> friends = new ArrayList<User>();
		friends.add(UserBuilder.aUser().build());
		friends.add(UserBuilder.aUser().build());
		User user = UserBuilder.aUser()
				.withFriends(friends)
				.build();
		Event event01 = EventBuilder.aEvent()
				  .withAddress("Quilmes")
				  .withDate(new Date())
				  .withScheduler(TypeOfScheduler.NIGHT)
				  .withAmount(200)
				  .withLimitOfPersons(1) 
				  .build();
		Event event02 = EventBuilder.aEvent()
				  .withAddress("Wilde")
				  .withDate(new Date())
				  .withScheduler(TypeOfScheduler.NIGHT)
				  .withAmount(150)
				  .withLimitOfPersons(1) 
				  .build();
		Event event03 = EventBuilder.aEvent()
				  .withAddress("Bernal")
				  .withDate(new Date())
				  .withScheduler(TypeOfScheduler.NIGHT)
				  .withAmount(150)
				  .withLimitOfPersons(1) 
				  .build();
		user.getSistem().addEvent(event01);
		user.getSistem().addEvent(event02);
		user.getSistem().addEvent(event03);
		user.newTour(TypeOfTour.GASOLERA, new Date(), TypeOfScheduler.NIGHT, 300, friends);
		user.getSistem().selectEvent1ForATour(event02, user.getTours().get(0));
		Assert.assertEquals(1, user.getTours().get(0).eventOptions2.size());
		Assert.assertEquals("Bernal",user.getTours().get(0).eventOptions2.get(0).address);
	}

}
