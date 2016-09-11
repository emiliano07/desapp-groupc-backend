package model;

import java.util.ArrayList;
import java.util.Date;

import types.TypeOfScheduler;
import types.TypeOfTour;

public class User {
	
	public String userName;
	public String password;
	public String mail;
	public Profile profile;
	public ArrayList<Tour> tours;
	public ArrayList<Event> events;
	public ArrayList<User> friends;
	public Sistem sistem; 
	public ArrayList<User> friendsRequests;
	
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
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Methods
	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void loadProfile(Profile profile){
		//Ver si es necesario otro metodo para modificar
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
	//ver por que parametro hacemos la busqueda
		return this.sistem.searchFriend(user);
	}
	
	public void sendFriendRequest(User friend){
		this.friendsRequests.add(friend);
	}
	
	public void deleteFriend(User friend){
	//Elimina la amistad de los dos usuarios
		this.friends.remove(friend);
		friend.getFriends().remove(this);
	}
	
	public void acceptFriend(User friend){
	//Agrega la amistad de los dos usuarios
		this.friends.add(friend);
		friend.getFriends().add(this);
	}
	
	public void cancelFriend(User friend){
		this.friendsRequests.remove(friend);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Login Methods
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void signIn(){
		//Ver lo de autenticar
	}
	
	public void signOut(){
		//Ver lo de autenticar
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
	
	public ArrayList<Tour> getTours() {
		return tours;
	}
	
	public ArrayList<Event> getEvents() {
		return events;
	}

	public Sistem getSistem() {
		return sistem;
	}
	
	public ArrayList<User> getFriends(){
		return this.friends;
	}

	public ArrayList<User> getFriendsRequests() {
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
}