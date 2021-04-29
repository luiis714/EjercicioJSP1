package datamodel.dao;

import org.hibernate.Session;

import datamodel.entities.Roles;


public class RolesDAO {
	
	public static void insertRol(Session session, Roles rol) {
		session.save(rol);
	}
	
}
