package model;

import java.util.ArrayList;
import java.util.Date;

public class Tour {
	
	public TypeOfTour type;
	public ArrayList<Event> events;
	public int amount;
	public TypeOfTransport transport;
	public ArrayList<User> friends;
	public Date date;
	
	public Tour(TypeOfTour type, TypeOfTransport transport, ArrayList<User> friends, Date date){
		this.type = type;
		this.events = new ArrayList<Event>();
		this.amount = 0;
		this.transport = transport;
		this.friends = new ArrayList<User>();
		this.date = date;
	}
	
	public void addEvent(Event event){
		this.events.add(event);
		this.amount += event.getAMount();
	}
	
	public TypeOfTour getTourType(){
		return this.type;
	}
}
