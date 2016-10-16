package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import domain.exceptions.UserNotLoggedException;
import domain.types.TypeOfScheduler;
import domain.types.TypeOfTour;

@XmlRootElement(name="user")
public class User extends Entity{
	
	private static final long serialVersionUID = -8201505803898337489L;
	public String userName;
	public String password;
	public String mail;
	public Profile profile;
	public List<Tour> tours;
	public List<Event> events;
	public List<User> friends;
	public Sistem sistem; 
	public List<User> friendsRequests;
	public Boolean logged;
	
	public User() {}
	public User(String userName, String password, String mail) {
		this.userName = userName;
		this.password = password;
		this.mail = mail;
	}
	public User(Sistem sistem, String userName, String password, String mail){
		this.userName = userName;
		this.password = password;
		this.mail = mail;
		this.profile = null;
		this.tours = new ArrayList<Tour>();
		this.events = new ArrayList<Event>();
		this.friends = new ArrayList<User>();
		this.sistem = sistem;
		this.friendsRequests = new ArrayList<User>();
		this.logged = false;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Methods
	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void loadProfile(Profile profile){
		this.profile = profile;
	}
	
	public void addEvent(Event event){
		this.events.add(event);
	}

	public void newTour(TypeOfTour typeOfTour, Date date, TypeOfScheduler scheduler, int limitAmount, ArrayList<User> friends){
		this.tours.add(this.sistem.newTour(typeOfTour, date, scheduler, limitAmount, friends));
	}

	public void acceptTour(Tour tour){
		this.tours.add(tour);
		tour.makeSuggestions();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Friendship Methods
	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void addFriend(User friend){
		this.friends.add(friend);
	}
	
	public User searchFriend(User user) throws Exception{
		return this.sistem.searchFriend(user);
	}
	
	public void sendFriendRequest(User friend){
		this.friendsRequests.add(friend);
	}
	
	public void deleteFriend(User friend){
		this.friends.remove(friend);
		friend.getFriends().remove(this);
	}
	
	public void acceptFriend(User friend){
		this.friends.add(friend);
		friend.getFriends().add(this);
	}
	
	public void cancelFriend(User friend){
		this.friendsRequests.remove(friend);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Login Methods
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void logIn(String userName, String password) throws Exception{
		this.sistem.logIn(userName, password);
	}

	public void logOut(String userName) throws Exception{
		this.sistem.logOut(userName);
	}
	
	public void isLogged() throws Exception{
		if(!this.logged){
			throw new UserNotLoggedException();
		}
	}
	
	public void changePassword(String userName, String oldPassword, String newPassword)throws Exception{
		this.sistem.changePassword(userName, oldPassword, newPassword);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getters & Setters
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Profile getProfile() {
		return profile;
	}

	public String getName(){
		return this.userName;
	}
	
	public List<Tour> getTours() {
		return tours;
	}
	
	public List<Event> getEvents() {
		return events;
	}

	public Sistem getSistem() {
		return sistem;
	}
	
	public List<User> getFriends(){
		return this.friends;
	}

	public List<User> getFriendsRequests() {
		return friendsRequests;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	public void setTours(ArrayList<Tour> tours) {
		this.tours = tours;
	}
	
	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}

	public void setFriendsRequests(ArrayList<User> friendsRequests) {
		this.friendsRequests = friendsRequests;
	}

	public void setFriends(ArrayList<User> friends) {
		this.friends = friends;
	}
	
	public void setLogged(Boolean logged){
		this.logged = logged;
	}
}