package domain.repositories;

import org.hibernate.Query;

import domain.Event;


public class EventRepository extends HibernateGenericDao<Event> implements GenericRepository<Event> {

	private static final long serialVersionUID = 4077798780803361296L;

	@Override
	protected Class<Event> getDomainClass() {
		return Event.class;
	}

	public Event getEventByAdress(String address) {
		String hql = "SELECT e FROM " + Event.class.getName() + " e "
				+ "WHERE e.address = :address";
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameter("address", address);
		Event event = (Event) query.uniqueResult();
		return event;
	}
	
}
