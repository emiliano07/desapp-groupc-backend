package model;

import java.util.ArrayList;
import java.util.Date;

public class Sistem {
	
	public ArrayList<User> users;
	public ArrayList<Event> allEvents;
	
	public Sistem(){
		this.users = new ArrayList<User>();
		this.allEvents = new ArrayList<Event>();
	}
	
	public void addEvent(Event event){
		this.allEvents.add(event);
	}

	public User searchFriend(User user) throws Exception{
		this.existsUser(user);
		User usuario = null;
		for (User u  : users){
			if(users.contains(u))
				usuario = u;
		}
		return usuario;
	}
	
	public void existsUser(User user) throws Exception{
		if(! this.users.contains(user)){
			new NoFriendException();
		}
	}
	
	public Tour newTour(TypeOfTour typeOfTour, Date date, TypeOfScheduler scheduler, int limitAmount, ArrayList<User> friends){
		Tour tour = new Tour(typeOfTour, date, scheduler, limitAmount, friends);
		this.generateEventOptions(tour);
		return tour;
	}

	public void generateEventOptions(Tour tour){
		//Deberia hacer una query que traiga los eventos para una fecha, horario, limite de personas y monto indicados
		ArrayList<Event> events = new ArrayList<Event>();
		for(Event event: this.allEvents){
			if(this.conditionA(event, tour) && this.conditionB(event, tour) && this.conditionC(event, tour) && this.conditionD(event, tour)){
				events.add(event);
			}
		}
		tour.setEventOptions1(events);
		tour.setEventOptions2(events);
	}
	
	private Boolean conditionA(Event event, Tour tour){
		return event.getDate() == tour.getDate();
	}
	
	private Boolean conditionB(Event event, Tour tour){
		return event.getScheduler() == tour.getScheduler();
	}
	
	private Boolean conditionC(Event event, Tour tour){
		return event.getLimitOfPersons() <= tour.getFriends().size();
	}
	
	private Boolean conditionD(Event event, Tour tour){
		return event.getAmount() <= tour.getLimitAmount();
	}
	 
	public void selectEvent1ForATour(Event event, Tour tour){
		tour.addEvent1(1, event);
		this.refreshEvents2(tour);
	}

	public void selectEvent2ForATour(Event event, Tour tour){
		tour.addEvent1(2, event);
	}
	
	private void refreshEvents2(Tour tour) {
		ArrayList<Event> result = new ArrayList<Event>();
		for(Event event: tour.getEventOptions2()){
			if(this.conditionE(event, tour)){
				result.add(event);
			}
		}
		tour.setEventOptions2(result);
	}
	
	private Boolean conditionE(Event event, Tour tour){
		return event.getAmount() <= (tour.getLimitAmount() - tour.getEvent1().getAmount());
	}
}