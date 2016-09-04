package builders;

import java.util.ArrayList;

import model.Event;
import model.Profile;
import model.Sistem;
import model.Tour;
import model.Type;
import model.TypeOfTransport;
import model.User;

public class UserBuilder {
	
	private Profile profile;
	private ArrayList<Tour> tours;
	private ArrayList<Event> events;
	private ArrayList<User> friends;
	private Sistem sistem;
	private ArrayList<User> friendsRequests;
	
	public UserBuilder(){
        this.profile = new Profile(Type.NO_FILM, Type.NO_MUSIC, Type.NO_FOOD, 500, TypeOfTransport.NO_TRANSPORT);
        this.tours = new ArrayList<Tour>();
        this.events = new ArrayList<Event>();
        this.friends = new ArrayList<User>();
        this.sistem = new Sistem();
        this.friendsRequests = new ArrayList<User>();
    }
    
	public static UserBuilder aUser(){
        return new UserBuilder();
    }
	
	 public User build(){
		 User user =  new User(sistem);
		 user.setProfile(this.profile);
		 user.setTours(tours);
		 user.setEvents(events);
		 user.setFriends(friends);
		 user.setFriendsRequests(friendsRequests);
	     return user;
	 }
	 
	 public UserBuilder withProfile(Profile profile){
		 this.profile = profile;
	     return this; 
	 }
	 
	 public UserBuilder withTours(ArrayList<Tour> tours){
		 this.tours = tours;
	     return this;
	 }
	 
	 public UserBuilder withEvents(ArrayList<Event> events){
		 this.events = events;
	     return this;
	 }
	 
	 public UserBuilder withFriends(ArrayList<User> friends){
		 this.friends = friends;
	     return this;
	 }
	 
	 public UserBuilder withFriendsRequests(ArrayList<User> friendsRequests){
		 this.friendsRequests = friendsRequests;
	     return this;
	 }
}
