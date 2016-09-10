package model;

import java.util.ArrayList;
import java.util.Date;

public class Tour {
	
	public TypeOfTour type;
	public Date date;
	public TypeOfScheduler scheduler;
	public int amount;
	public int limitAmount;
	public ArrayList<User> friends;
	public ArrayList<Event> eventOptions1;
	public ArrayList<Event> eventOptions2;
	public Event event1;
	public Event event2;
	
	public Tour(TypeOfTour typeOfTour, Date date, TypeOfScheduler scheduler, int limitAmount, ArrayList<User> friends){
		this.type = typeOfTour;
		this.date = date;
		this.scheduler = scheduler;
		this.amount = 0;
		this.limitAmount = limitAmount;
		this.friends = friends;
		this.eventOptions1 = new ArrayList<Event>();
		this.eventOptions2 = new ArrayList<Event>();
		this.event1 = null;
		this.event2 = null;
	}
	
	public Event getEvent1(){
		return this.event1;
	}
	
	public int getLimitAmount(){
		return this.limitAmount;
	}
	
	public void setEventOptions1(ArrayList<Event> events){
		this.eventOptions1 = events;
	}
	
	public ArrayList<Event> getEventOptions2(){
		return this.eventOptions2;
	}
	
	public void setEventOptions2(ArrayList<Event> events){
		this.eventOptions2 = events;
	}

	public void addEvent1(int eventNumber, Event event){
		if(eventNumber == 1){
			this.event1 = event;
		}else{
			this.event2 = event;
		}
		this.amount += event.getAmount();
	}


	public void setEvent2(Event event2) {
		this.event2 = event2;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public ArrayList<User> getFriends() {
		return friends;
	}

	public Date getDate() {
		return date;
	}

	public TypeOfScheduler getScheduler() {
		return scheduler;
	}

	public ArrayList<Event> getEventOptions1() {
		return eventOptions1;
	}

	public void setEvent1(Event event1) {
		this.event1 = event1;
	}

}
