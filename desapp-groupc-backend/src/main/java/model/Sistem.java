package model;

import java.util.ArrayList;
import java.util.Date;

public class Sistem {
	
	public ArrayList<User> users;
	public ArrayList<Event> events;
	
	public Sistem(){
		this.users = new ArrayList<User>();
		this.events = new ArrayList<Event>();
	}

	public Tour newTour(TypeOfTour typeOfTour, TypeOfTransport typeOfTransport, ArrayList<User> friends, int amount, Date date){
		//Este amount es el que quiere gastar el usuario
		Tour tour = new Tour(typeOfTour, typeOfTransport, friends, date);
		typeOfTour.generate(this, tour);
		return tour;
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
	

	//AGREGARLE AL TOUR LOS EVENTOS CORRESPONDIENTES DEPENDIENDO DE LOS DATOS DEL PERFIL Y DE LOS PARAMETROS
	//tour.addEvent(event)
	
	public void generateGASOLERA(Tour tour){
		//Prioriza salidas gratis y lugares economicos para comer, 
		//teniendo como límite de gasto el monto ingresado por el usuario en su perfil.
	}

	public void generateWITH_FRIENDS(Tour tour){
		
	}

	public void generateSATURDAY_NIGHT_FEVER(Tour tour){
		
	}

	public void generateHALF_ORANGE(Tour tour){
		
	}

	public void generateSURPRISE(Tour tour){
		
	}
}