package org.service;

import org.hibernate.Session;
import org.model.Storage;
import org.util.HBUtil;

public class StorageService {
	public static void insert(String str){
		Session session = HBUtil.get().openSession();
		session.beginTransaction();
		Storage storage = new Storage();
		storage.setId(0);
		storage.setData(str);		
		session.update(storage);
		session.getTransaction().commit();
		session.close();
	}
}