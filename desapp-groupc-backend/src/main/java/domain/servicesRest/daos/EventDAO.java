package domain.servicesRest.daos;

import java.util.ArrayList;
import java.util.List;

import domain.Event;
import domain.servicesRest.Fixture;

public class EventDAO{
	
	private List<Event> events;

	public EventDAO() {
		this.events = Fixture.createEvents();
	}

	public List<Event> getEvents() {
		return events;
	}
	
	public List<Event> getEvents(final int amount) {
		List<Event> eventsDependsTypeOfScheduler = new ArrayList<Event>();
		for (Event e : this.events){
			if(e.amount > amount)
				eventsDependsTypeOfScheduler.add(e);
		}
		
		return eventsDependsTypeOfScheduler;
	}
}
