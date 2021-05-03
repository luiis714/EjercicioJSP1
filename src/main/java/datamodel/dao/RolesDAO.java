package datamodel.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import datamodel.entities.Roles;
import datamodel.entities.Usuarios;
import datamodel.util.HibernateUtil;
import servlet.Login;


public class RolesDAO {
	
	private static Logger logger = LogManager.getLogger(Login.class);
	
	private static Session session;
	
	public static List<Roles> getAllRoles() {
		session = HibernateUtil.getSessionFactory().openSession();
		
		String hQuery = "FROM Roles";
		
		logger.info("Recupero todos los roles");
		
		List<Roles> roles = session.createQuery(hQuery, Roles.class)
											.list();
		
		return roles;
	}
	
	/***/
	public static Roles getRol(String idRol) {
		session = HibernateUtil.getSessionFactory().openSession();
		
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
	
	/***/
	public static void insertRol(Roles rol) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.save(rol);
	}
	
}
