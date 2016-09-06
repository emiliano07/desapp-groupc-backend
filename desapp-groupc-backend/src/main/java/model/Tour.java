package model;

import java.util.ArrayList;
import java.util.Date;

public class Tour {
	
	public TypeOfTour type;
	public Event event1;
	public Event event2;
	public int amount;
	public TypeOfTransport transport;
	public ArrayList<User> friends;
	public Date date;
	public int radio;
	public TypeOfScheduler scheduler;
	public ArrayList<Event> eventOptions1;
	public ArrayList<Event> eventOptions2;
	public int limitAmount;
	
	public Tour(TypeOfTour type, TypeOfTransport transport, ArrayList<User> friends, Date date, int radio, TypeOfScheduler scheduler, int limitAmoint){
		this.type = type;
		this.event1 = null;
		this.event2 = null;
		this.amount = 0;
		this.transport = transport;
		this.friends = friends;
		this.date = date;
		this.radio = radio;
		this.scheduler = scheduler;
		this.eventOptions1 = new ArrayList<Event>();
		this.eventOptions2 = new ArrayList<Event>();
		this.limitAmount = limitAmoint;
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
	
	public TypeOfTour getTipe(){
		return this.type;
	}

	public TypeOfTour getType() {
		return type;
	}

	public void setType(TypeOfTour type) {
		this.type = type;
	}

	public Event getEvent2() {
		return event2;
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

	public TypeOfTransport getTransport() {
		return transport;
	}

	public void setTransport(TypeOfTransport transport) {
		this.transport = transport;
	}

	public ArrayList<User> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<User> friends) {
		this.friends = friends;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public TypeOfScheduler getScheduler() {
		return scheduler;
	}

	public void setScheduler(TypeOfScheduler scheduler) {
		this.scheduler = scheduler;
	}

	public ArrayList<Event> getEventOptions1() {
		return eventOptions1;
	}

	public void setEvent1(Event event1) {
		this.event1 = event1;
	}

	public void setLimitAmount(int limitAmount) {
		this.limitAmount = limitAmount;
	}
}
