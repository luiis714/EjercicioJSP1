package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datamodel.dao.RolesDAO;
import datamodel.entities.Roles;
import datamodel.util.HibernateUtil;

/**
 * Servlet implementation class AltaRol
 */
@WebServlet("/AltaRol")
public class AltaRol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Logger logger = LogManager.getLogger(Login.class);
	
	private Session session;
	private Transaction tx = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaRol() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		//Abro la session con la BBDD a trav�s hibernate
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		logger.info("Creo la sesin. Conexión con la BBDD. Desde MostrarDatos");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String p_rol = request.getParameter("rol");
		logger.info("Se va a insertar un rol con el nombre: " + p_rol);
		//Inserto un rol a trav�s de su nombre
		insertaRol(p_rol, out);
	}
	
	private void insertaRol(String p_rol, PrintWriter out) {
		Roles rol = new Roles(p_rol);
		
		RolesDAO.insertRol(rol);
		
		tx.commit();//Hago un commit de la BBDD
		logger.info("Rol insertado correctamente " + rol.toString());
		
		//Muestro un HTML con la informaci�n
		muestraInfo(rol, out);
	}

	private void muestraInfo(Roles rol, PrintWriter out) {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Inserci�n correcta</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>ROL INSERTADO CORRECTAMENTE</h1>");
		out.println("<h3>ID: " + rol.getId() + " NOMBRE: " + rol.getRol() + "</h3>");
		out.println("</body>");
		out.println("</html>");
		
		logger.info("Se ha mostrado informaci�n de una inserci�n correcta al usuario");
	}
}
