package datamodel.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import datamodel.entities.Productos;
import datamodel.entities.Roles;
import datamodel.util.HibernateUtil;
import servlet.Login;

public class ProductosDAO {

	private static Logger logger = LogManager.getLogger(Login.class);
	
	private static Session session;
	
	/**Método que devuelve una lista con todos los productos*/
	public static List<Productos> getAllProductos(){
		session = HibernateUtil.getSessionFactory().openSession();
		
		String hQuery = "FROM Productos";
		
		logger.info("Recupero todos los productos");
		
		List<Productos> productos = session.createQuery(hQuery, Productos.class)
											.list();
		
		return productos;
	}
}
