package fr.ippon.dropwizard.db;

import java.util.List;

import org.hibernate.SessionFactory;

import com.yammer.dropwizard.hibernate.AbstractDAO;

import fr.ippon.dropwizard.core.User;

public class UserDao extends AbstractDAO<User> {

	public UserDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public List<User> findAll() {
		return list(namedQuery(User.QUERY_FIND_ALL));
	}

	public User findById(Long id) {
		return get(id);
	}

	@Override
	public User persist(User user) {
		return super.persist(user);
	}

}
