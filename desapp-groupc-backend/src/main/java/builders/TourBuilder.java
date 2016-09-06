package builders;

import java.util.ArrayList;
import java.util.Date;

import model.Event;
import model.Tour;
import model.Type;
import model.TypeOfScheduler;
import model.TypeOfTour;
import model.TypeOfTransport;
import model.User;

public class TourBuilder {
	
	private TypeOfTour type;
	private Event event1;
	private Event event2;
	private int amount;
	private TypeOfTransport transport;
	private ArrayList<User> friends;
	private Date date;
	private int radio;
	private TypeOfScheduler scheduler;
	private ArrayList<Event> eventOptions1;
	private ArrayList<Event> eventOptions2;
	private int limitAmount;
	
	
	public TourBuilder(){
		this.type = TypeOfTour.GASOLERA;
		this.event1 = new Event(new ArrayList<Type>(), new Date(), "no-address", 100, 2);
		this.event2 = new Event(new ArrayList<Type>(), new Date(), "no-address", 200, 4);
		this.amount = 1000;
		this.transport = TypeOfTransport.NO_TRANSPORT;
		this.friends = new ArrayList<User>();
		this.date = new Date();
		this.radio = 10;
		this.scheduler = TypeOfScheduler.MORNING;
		this.eventOptions1 = new ArrayList<Event>();
		this.eventOptions2 = new ArrayList<Event>();
		this.limitAmount = 500;
    }
    
	public static TourBuilder aTour(){
        return new TourBuilder();
    }
	
	 public Tour build(){
		 Tour tour =  new Tour(type, transport,friends, date, radio, scheduler, limitAmount);
		 tour.setEvent1(event1);
		 tour.setEvent2(event2);
		 tour.setAmount(amount);
		 tour.setEventOptions1(eventOptions1);
		 tour.setEventOptions1(eventOptions2);
	     return tour;
	 }
	 
	 public TourBuilder withType(TypeOfTour type){
		 this.type = type;
	     return this;
	 }
	 
	 public TourBuilder withEvent01(Event event){
		 this.event1 = event;
	     return this;
	 }
	 
	 public TourBuilder withEvent02(Event event){
		 this.event2 = event;
	     return this;
	 }
	 
	 public TourBuilder withAmount(int amount){
		 this.amount = amount;
	     return this;
	 }
	 
	 public TourBuilder withTransport(TypeOfTransport transport){
		 this.transport = transport;
	     return this;
	 }
	 
	 public TourBuilder withFriends(ArrayList<User> friends){
		 this.friends = friends;
	     return this;
	 }
	 
	 public TourBuilder withDate(Date date){
		 this.date = date;
	     return this;
	 }
	 
	 public TourBuilder withRadio(int radio){
		 this.radio = radio;
	     return this;
	 }
	 
	 public TourBuilder withScheduler(TypeOfScheduler scheduler){
		 this.scheduler = scheduler;
	     return this;
	 }
	 
	 public TourBuilder withEventOptions1(ArrayList<Event> eventOptions){
		 this.eventOptions1 = eventOptions;
	     return this;
	 }
	 
	 public TourBuilder withEventOptions2(ArrayList<Event> eventOptions){
		 this.eventOptions2 = eventOptions;
	     return this;
	 }
	 
	 public TourBuilder withLimitAmount(int limitAmount){
		 this.limitAmount = limitAmount;
	     return this;
	 }

}
