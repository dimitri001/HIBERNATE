package com.ejemplo1.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil{

	public void testConnection() throws Exception {
	
		//log.info("Trying to create a test connection with the database.");
   
	Configuration configuration = new Configuration();
    configuration.configure("hibernate.cfg.xml");
    ServiceRegistryBuilder  ssrb = new ServiceRegistryBuilder ().applySettings(configuration.getProperties());
  
    SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.buildServiceRegistry());
    
    @SuppressWarnings("unused")
	Session session = sessionFactory.openSession();
    
    //logger.info("Test connection with the database created successfuly.");
	
	}

   //http://www.mastertheboss.com/jboss-frameworks/maven-tutorials/maven-hibernate-jpa/maven-and-hibernate-4-tutorial
}


