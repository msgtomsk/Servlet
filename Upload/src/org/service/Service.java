package org.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.model.Main;


public class Service {
	public static void insert(String filename,String location,String mimetype){
		SessionFactory  sf= new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Main main = new Main();		
		main.setFilename(filename);
		main.setLocation(location);
		main.setMimetype(mimetype);
		session.save(main);
		session.getTransaction().commit();
		session.close();
	}
}
