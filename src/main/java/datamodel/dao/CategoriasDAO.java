package datamodel.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import datamodel.entities.Categorias;
import datamodel.entities.Productos;
import datamodel.util.HibernateUtil;
import servlet.Login;

public class CategoriasDAO {
	private static Logger logger = LogManager.getLogger(Login.class);
	
	private static Session session;
	
	/**Método que devuelve una lista con todos las categorias*/
	public static List<Categorias> getAllCategorias(){
		session = HibernateUtil.getSessionFactory().openSession();
		
		String hQuery = "FROM Categorias";
		
		logger.info("Recupero todos los categorias");
		
		List<Categorias> categorias = session.createQuery(hQuery, Categorias.class)
											.list();
		
		return categorias;
	}
}
