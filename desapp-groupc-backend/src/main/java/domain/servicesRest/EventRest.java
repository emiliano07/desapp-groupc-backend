package domain.servicesRest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import domain.Event;
import domain.servicesRest.daos.EventDAO;

@Path("/event")
public class EventRest {

	private EventDAO eventDAO = new EventDAO();

	@GET
	@Path("/allEvents")
	@Produces("application/json")
	public List<Event> allEvents() {
		return eventDAO.getEvents();
	}

	@GET
	@Path("/getEvent/{eventId}")
	@Produces("application/json")
	public Event findPostsPublishedByAuthorId(@PathParam("eventId") final int id) {
		return eventDAO.getEvents().get(id);
	}
}
