package domain.servicesRest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Event;
import domain.Sistem;
import domain.User;
import domain.types.Type;
import domain.types.TypeOfScheduler;

public class Fixture {
	
	public static List<Event> createEvents() {
		List<Event> posts = new ArrayList<Event>();
		posts.add(Fixture.createEvent(null,null,TypeOfScheduler.AFTERNOON,"Quilmes",300,1));
		posts.add(Fixture.createEvent(null,null,TypeOfScheduler.MORNING,"Bernal",300,2));
		posts.add(Fixture.createEvent(null,null,TypeOfScheduler.NIGHT,"Berazategui",300,3));
		return posts;
	}
	
	public static List<User> createUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User(new Sistem(null), "franciolucio", "1234", "franciolucio@gmail.com"));
		users.add(new User(new Sistem(null), "emimancu", "12345", "emimancu@gmail.com"));
		users.add(new User(new Sistem(null), "alanmarino", "123456", "alanmarino@gmail.com"));
		return users;
	}
	
	public static Event createEvent(ArrayList<Type> types, Date date, TypeOfScheduler scheduler, String address, int amount, int limitOfPersons) {
		Event post = new Event(types, date, scheduler,address, amount, limitOfPersons);
		return post;
	}

}
