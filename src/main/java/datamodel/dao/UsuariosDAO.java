package datamodel.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import datamodel.entities.Usuarios;
import servlet.Login;

public class UsuariosDAO {
	
	private static Logger logger = LogManager.getLogger(Login.class);
	
	public static void insertUsuario(Session session, Usuarios usuario) {
		session.save(usuario);
	}
	
	/**Metodo que devuelve una lista con todos los usuarios*/
	public static List<Usuarios> getAllUsuarios(Session session){
		String hQuery = "FROM Usuarios";
		
		logger.info("Recupero todos los usuarios");
		
		List<Usuarios> usuarios = session.createQuery(hQuery, Usuarios.class)
											.list();
		
		return usuarios;
	}
	
	/**Metodo que devuelve un usuario a través de su id pasado por parametro*/
	public static Usuarios getUsuario(Session session, int idUsuario) {
		String hQuery = " from Usuarios u " +
                " where u.id = :idUsuario";
		
		Usuarios usuario = session.createQuery(hQuery, Usuarios.class)
									.setParameter("idUsuario", idUsuario)
									.setMaxResults(1)
									.uniqueResult();
		
		try {
			logger.info("Recupero el usuario por su email: " + usuario.toString());	
		}
		catch(NullPointerException ex) {
			logger.error("Usuario no encontrado");
		}
		return usuario;
	}
	
	/**Metodo que devuelve un usuario a través de su email pasado por parametro*/
	public static Usuarios getUsuario(Session session, String email) {
		String hQuery = " from Usuarios u " +
                " where u.email = :email";
		
		Usuarios usuario = session.createQuery(hQuery, Usuarios.class)
									.setParameter("email", email)
									.setMaxResults(1)
									.uniqueResult();
		try {
			logger.info("Recupero el usuario por su email: " + usuario.toString());	
		}
		catch(NullPointerException ex) {
			logger.error("Usuario no encontrado");
		}
		
		return usuario;
	}
}
