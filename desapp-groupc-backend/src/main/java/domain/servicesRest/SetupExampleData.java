package domain.servicesRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import domain.Event;
import domain.builders.EventBuilder;
import domain.services.EventService;


public class SetupExampleData {
    
	@Autowired
	EventService eventService;
   
    public SetupExampleData() {}

    public SetupExampleData(EventService eventService){
        this.eventService = eventService;
    }

    public EventService getEventService() {
        return eventService;
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @Transactional
    public void init() {
    	Event event01 = EventBuilder.aEvent().withAddress("Pilar").build();
    	Event event02 = EventBuilder.aEvent().withAddress("Castelar").build();
    	Event event03 = EventBuilder.aEvent().withAddress("Villa Crespo").build();
    	this.eventService.save(event01);
    	this.eventService.save(event02);
    	this.eventService.save(event03);
    }
}
