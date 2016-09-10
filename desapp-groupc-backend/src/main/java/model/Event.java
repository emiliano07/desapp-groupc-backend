package model;

import java.util.ArrayList;
import java.util.Date;

public class Event {

	public ArrayList<Type> types;
	public Date date;
	public TypeOfScheduler scheduler;
	public String address;
	public int amount;
	public int limitOfPersons;
	public ArrayList<Event> suggestions; //Ver como lo hacemos “quienes optaron por esta opción, también optaron por”
	
	public Event(ArrayList<Type> types, Date date, TypeOfScheduler scheduler, String address, int amount, int limitOfPersons){
		this.types = types;
		this.date = date;
		this.scheduler = scheduler;
		this.address = address;
		this.amount = amount;
		this.limitOfPersons = limitOfPersons;
		this.suggestions = new ArrayList<Event>();
	}
	
	public void setSuggestions(ArrayList<Event> suggestions) {
		this.suggestions = suggestions;
	}

	public int getAmount(){
		return this.amount;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public TypeOfScheduler getScheduler(){
		return this.scheduler;
	}

	public int getLimitOfPersons(){
		return this.limitOfPersons;
	}
}