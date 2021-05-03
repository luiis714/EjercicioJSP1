package datamodel.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import datamodel.dao.UsuariosDAO;
import datamodel.entities.Usuarios;
import servlet.Login;

public class LoginService {
	
	private static Logger logger = LogManager.getLogger(Login.class);
	
	public static boolean compruebaLogin(String user, String password) {
		boolean correcto = false;
		
		Usuarios usuario = UsuariosDAO.getUsuario(user);
		logger.info("Recupero el usuario " + usuario.getEmail() + " " + usuario.getClave());
		
		//Si el usuario se ha encontrado y coincide con la contraseña pasada entonces el logueo es correcto
		if((usuario != null) && usuario.getClave().equals(password)) {
			correcto = true;
			logger.info("El inicio de sesión es correcto");
			
		}
		else {
			correcto = false;
			logger.info("El usuario o la contraseña son incorrectos");
		}

		return correcto;
	}
}
