package domain.servicesRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import domain.Event;
import domain.builders.EventBuilder;
import domain.exceptions.SingUpException;
import domain.services.EventService;
import domain.services.UserService;


public class SetupExampleData {
    
	@Autowired
	EventService eventService;
	UserService userService;
   
    public SetupExampleData() {}

    public SetupExampleData(EventService eventService,UserService userService){
        this.eventService = eventService;
        this.userService = userService;
    }

    public EventService getEventService() {
        return eventService;
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
    
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Transactional
    public void init() throws SingUpException {
    	userService.signUp("franciolucio","unqui","franciolucio@gmail.com");
    	Event event01 = EventBuilder.aEvent().withAddress("Pilar").build();
    	Event event02 = EventBuilder.aEvent().withAddress("Castelar").build();
    	Event event03 = EventBuilder.aEvent().withAddress("Villa Crespo").build();
    	this.eventService.save(event01);
    	this.eventService.save(event02);
    	this.eventService.save(event03);
    	
    }
}
