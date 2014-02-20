package fr.ippon.dropwizard;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.hibernate.HibernateBundle;

import fr.ippon.dropwizard.core.User;
import fr.ippon.dropwizard.db.UserDao;
import fr.ippon.dropwizard.resources.UserResource;

public class DemoService extends Service<DemoConfiguration> {

	private final HibernateBundle<DemoConfiguration> hibernateBundle = new HibernateBundle<DemoConfiguration>(
			User.class) {
		@Override
		public DatabaseConfiguration getDatabaseConfiguration(DemoConfiguration configuration) {
			return configuration.getDatabaseConfiguration();
		}
	};

	public static void main(String[] args) throws Exception {
		new DemoService().run(args);
	}

	@Override
	public void initialize(Bootstrap<DemoConfiguration> bootstrap) {
		bootstrap.addBundle(hibernateBundle);
	}

	@Override
	public void run(DemoConfiguration configuration, Environment environment) throws Exception {
		UserDao userDao = new UserDao(hibernateBundle.getSessionFactory());
		environment.addResource(new UserResource(userDao));
	}

}
