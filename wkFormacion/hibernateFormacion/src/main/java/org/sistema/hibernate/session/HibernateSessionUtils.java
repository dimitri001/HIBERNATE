package org.sistema.hibernate.session;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateSessionUtils {
	
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static Session session;

	// clase del tipo songleton, solo vamos a tener un objeto de est tipo durante toda la sesión
	private static SessionFactory buildSessionFactory() {
		
		Configuration configuration = new Configuration();
		configuration.configure();// lee todas las propiedades de configuracion y las lee en hibernate
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		return sessionFactory;
	}

	public static SessionFactory getSessionfactory() {		
		
		return sessionFactory;
	}

	public static Session getSession() {
		if (null == session || !session.isOpen() ){
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	

}
