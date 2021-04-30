package datamodel.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import datamodel.entities.Roles;
import datamodel.entities.Usuarios;
import servlet.Login;


public class RolesDAO {
	
	private static Logger logger = LogManager.getLogger(Login.class);
	
	public static Roles getRol(Session session, String idRol) {
		String hQuery = " from Roles r " +
                " where r.id = :idRol";
		
		Roles rol = session.createQuery(hQuery, Roles.class)
									.setParameter("idRol", idRol)
									.setMaxResults(1)
									.uniqueResult();
		
		try {
			logger.info("Recupero el rol por su ID: " + rol.toString());	
		}
		catch(NullPointerException ex) {
			logger.error("Rol no encontrado");
		}
		
		return rol;
	}
	
	public static void insertRol(Session session, Roles rol) {
		session.save(rol);
	}
	
}
