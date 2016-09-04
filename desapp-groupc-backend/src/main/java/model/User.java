package model;

import java.util.ArrayList;
import java.util.Date;

public class User {
	
	public Profile profile;
	public ArrayList<Tour> tours;
	public ArrayList<Event> events;
	public ArrayList<User> friends;
	public Sistem sistem;
	public ArrayList<User> friendsRequests;
	
	public User(Sistem sistem){
		this.profile = null;
		this.tours = new ArrayList<Tour>();
		this.events = new ArrayList<Event>();
		this.friends = new ArrayList<User>();
		this.sistem = sistem;
		this.friendsRequests = new ArrayList<User>();
	}
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public ArrayList<Tour> getTours() {
		return tours;
	}

	public void setTours(ArrayList<Tour> tours) {
		this.tours = tours;
	}

	public ArrayList<Event> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}

	public Sistem getSistem() {
		return sistem;
	}

	public void setSistem(Sistem sistem) {
		this.sistem = sistem;
	}

	public ArrayList<User> getFriendsRequests() {
		return friendsRequests;
	}

	public void setFriendsRequests(ArrayList<User> friendsRequests) {
		this.friendsRequests = friendsRequests;
	}

	public void setFriends(ArrayList<User> friends) {
		this.friends = friends;
	}

	public void loadProfile(Profile profile){
	//Ver si es necesario otro metodo para modificar
		this.profile = profile;
	}
	
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
	
	public ArrayList<User> getFriends(){
		return this.friends;
	}
	
	public void acceptFriend(User friend){
	//Agrega la amistad de los dos usuarios
		this.friends.add(friend);
		friend.getFriends().add(this);
	}
	
	public void cancelFriend(User friend){
		this.friendsRequests.remove(friend);
	}
	
	public void newTour(TypeOfTour typeOfTour, TypeOfTransport typeOfTransport, ArrayList<User> friends, int amount, Date date){
	//Este amount es el que quiere gastar el usuario
	//En el listado de friends el usuario que lo creo esta incluido => friends = user + friend + friend ...
		this.sistem.newTour(typeOfTour, typeOfTransport, friends, amount, date);
	}
	
	public void acceptTour(Tour tour){
		this.tours.add(tour);
	}
	
	public void addEvent(Event event){
		this.events.add(event);
	}
	
	public void signIn(){
		//Ver lo de autenticar
	}
	
	public void signOut(){
		//Ver lo de autenticar
	}
}