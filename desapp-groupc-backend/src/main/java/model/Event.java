package model;

import java.util.ArrayList;
import java.util.Date;

public class Event {

	public ArrayList<Type> types;
	public Date date; //Fecha y hora
	public String address;
	public int amount;
	public ArrayList<Event> suggestions; //Ver como lo hacemos �quienes optaron por esta opci�n, tambi�n optaron por�
	
	public Event(ArrayList<Type> types, Date date, String address, int amount){
		this.types = types;
		this.date = date;
		this.address = address;
		this.amount = amount;
		this.suggestions = new ArrayList<Event>();
	}
	
	public int getAMount(){
		return this.amount;
	}
}