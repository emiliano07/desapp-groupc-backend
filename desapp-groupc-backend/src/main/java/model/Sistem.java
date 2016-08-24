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
		//AGREGARLE AL TOUR LOS EVENTOS CORRESPONDIENTES DEPENDIENDO DE LOS DATOS DEL PERFIL Y DE LOS PARAMETROS
		return tour;
	}
	
	public User searchFriend(User user) throws Exception{
		if(this.users.contains(user)){
			return this.users.get(this.users.indexOf(users));
		}
		throw new Exception();
	}
}
