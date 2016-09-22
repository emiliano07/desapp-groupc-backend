package domain.repositories;

import org.springframework.stereotype.Repository;

import domain.User;

@Repository
public class UserRepository extends HibernateGenericDao<User> implements
		GenericRepository<User> {

	private static final long serialVersionUID = 4077798780803361296L;

	@Override
	protected Class<User> getDomainClass() {
		return User.class;
	}
}
