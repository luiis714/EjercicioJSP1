package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import datamodel.dao.RolesDAO;
import datamodel.dao.UsuariosDAO;
import datamodel.entities.Usuarios;
import datamodel.util.HibernateUtil;
import datamodel.controller.LoginService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Logger logger = LogManager.getLogger(Login.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		//Abro la session con la BBDD a trav�s hibernate
		//session = HibernateUtil.getSessionFactory().openSession();
		//logger.info("Creo la sesi�n. Conexi�n con la BBDD. Desde MostrarDatos");
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
		
		
		
		HttpSession session = request.getSession(true);
		
		//Recupero los parametros de usuario y contrase�a
		String p_user = request.getParameter("user");
		String p_pass = request.getParameter("password");
		
		logger.info("Voy a comprobar login con usuario: " + p_user + " clave: " + p_pass);
		
		if(LoginService.compruebaLogin(p_user, p_pass)) {
			Usuarios usuario = UsuariosDAO.getUsuario(p_user);
			
			session.setAttribute("fechaLog", new java.util.Date());
			session.setAttribute("usuario", usuario);
			session.setAttribute("rol", RolesDAO.getRol(usuario.getIdRol()));
			
			
			request.getRequestDispatcher("Menu.jsp").forward(request, response);
			
			logger.info("Se ha logueado CORRECTAMENTE y muestra el MENU");
		}
		else {
			
			logger.info("El usuario o la contrase�a son incorrectas");
		}
	}

}
