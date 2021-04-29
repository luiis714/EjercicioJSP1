package datamodel.dao;

import java.util.List;

import org.hibernate.Session;

import datamodel.entities.Usuarios;

public class UsuariosDAO {
	
	/**Metodo que devuelve una lista con todos los usuarios*/
	public static List<Usuarios> getAllUsuarios(Session session){
		String hQuery = "FROM Usuarios";
		
		List<Usuarios> usuarios = session.createQuery(hQuery, Usuarios.class)
											.list();
		
		return usuarios;
	}
	
	public static Usuarios getUsuario(Session session, int idUsuario) {
		String hQuery = " from Usuarios u " +
                " where u.id = :idUsuario";
		
		Usuarios usuario = session.createQuery(hQuery, Usuarios.class)
									.setParameter("idUsuario", idUsuario)
									.setMaxResults(1)
									.uniqueResult();
		return usuario;
	}
	
	public static Usuarios getUsuario(Session session, String email) {
		String hQuery = " from Usuarios u " +
                " where u.email = :email";
		
		Usuarios usuario = session.createQuery(hQuery, Usuarios.class)
									.setParameter("email", email)
									.setMaxResults(1)
									.uniqueResult();
		return usuario;
	}
}
