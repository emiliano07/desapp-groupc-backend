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
		return this.users.get(this.users.indexOf(users));
	}
	
	public void existsUser(User user) throws Exception{
		if(! this.users.contains(user)){
			new NoFriendException();
		}
	}
	
	/*
	public ArrayList<Type> typeOfFilms(){
	//Ver si hay una forma de hacerlo mas general para que cuando agregue nuevos tipos sea mas simple
		ArrayList<Type> typeOfFilms = new ArrayList<Type>();
		typeOfFilms.add(Type.HORROR);
		typeOfFilms.add(Type.ADVENTURE);
		typeOfFilms.add(Type.FANTASY);
		typeOfFilms.add(Type.COMEDY);
		typeOfFilms.add(Type.ACTION);
		return typeOfFilms;
	}
	
	public ArrayList<Type> typeOfMusic(){
		//Ver si hay una forma de hacerlo mas general para que cuando agregue nuevos tipos sea mas simple
		ArrayList<Type> typeOfMusic = new ArrayList<Type>();
		typeOfMusic.add(Type.ELECTRONIC);
		typeOfMusic.add(Type.POP);
		typeOfMusic.add(Type.CLASSIC);
		typeOfMusic.add(Type.ROCK);
		typeOfMusic.add(Type.REGGAETON);
		return typeOfMusic;
	}
	
	public ArrayList<Type> typeOfFood(){
		//Ver si hay una forma de hacerlo mas general para que cuando agregue nuevos tipos sea mas simple
		ArrayList<Type> typeOfFood = new ArrayList<Type>();
		typeOfFood.add(Type.PASTA);
		typeOfFood.add(Type.FAST_FOOD);
		typeOfFood.add(Type.PIZZA);
		typeOfFood.add(Type.SUSHI);
		typeOfFood.add(Type.GRILL);
		return typeOfFood;
	}
	*/
	
	public Tour newTour(TypeOfTour typeOfTour, TypeOfTransport typeOfTransport, ArrayList<User> friends, int limitAmount, Date date, int range, TypeOfScheduler scheduler){
		Tour tour = new Tour(typeOfTour, typeOfTransport, friends, date, range, scheduler, limitAmount);
		this.generateTourOptions(tour);
		return tour;
	}

	public void generateTourOptions(Tour tour){
		ArrayList<Event> events = this.allEvents; //En realidad aca lo que habria que hacer es una query que me traiga los eventos para una fecha, horario, limite de personas y monto indicados
		tour.setEventOptions1(events);
		tour.setEventOptions2(events);
	}
	
	public void selectEvent1ForATour(Event event, Tour tour){
		tour.addEvent1(1, event);
		this.refreshEvents2(tour);
	}

	public void selectEvent2ForATour(Event event, Tour tour){
		tour.addEvent1(2, event);
	}
	
	private void refreshEvents2(Tour tour) {
	//ACA DEBO FILTRAR LOS EVENTOS DE LA LISTA DE EVENTOS DOS POR EL MONTO QUE LE QUEDA PARA GASTAR, TRANSPORTE Y RADIO
		ArrayList<Event> result = new ArrayList<Event>();
		for(Event event: tour.getEventOptions2()){
			if(this.condition1(event, tour) && this.condition2(event, tour)){
				result.add(event);
			}
		}
		tour.setEventOptions2(result);
	}
	
	private Boolean condition1(Event event, Tour tour){
		return event.getAmount() <= (tour.getLimitAmount() - tour.getEvent1().getAmount());
	}
	
	private Boolean condition2(Event event, Tour tour){
		//Ver como hago la distancia con el transporte y el radio
		return true;
	}
}