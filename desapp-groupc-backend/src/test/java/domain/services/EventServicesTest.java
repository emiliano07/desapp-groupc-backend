package domain.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import domain.Event;
import domain.builders.EventBuilder;
import domain.repositories.EventRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring-all-contexts.xml")
public class EventServicesTest {
	
	@Autowired
	public EventRepository eventRepository = new EventRepository();
	
	@Autowired
	public EventService eventService = new EventService(eventRepository);

	@Test
    public void testGetEvent() {
		Event event = EventBuilder.aEvent().withAddress("Quilmes").build();
		eventService.save(event);
        Assert.assertEquals(2,eventService.obtenerEvent(event.getId()).limitOfPersons);
	}
}
