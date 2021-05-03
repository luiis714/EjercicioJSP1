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

import datamodel.dao.UsuariosDAO;
import datamodel.entities.Usuarios;
import datamodel.util.HibernateUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Logger logger = LogManager.getLogger(Login.class);
	
	private Session session;
	
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
		//Abro la session con la BBDD a través hibernate
		session = HibernateUtil.getSessionFactory().openSession();
		logger.info("Creo la sesión. Conexión con la BBDD. Desde MostrarDatos");
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

		//Recupero los parametros de usuario y contraseña
		String p_user = request.getParameter("user");
		String p_pass = request.getParameter("password");
		
		logger.info("Voy a comprobar login con usuario: " + p_user + " clave: " + p_pass);
		compruebaLogin(p_user, p_pass, request, response);
	}
	
	private void compruebaLogin(String p_user, String p_pass, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuarios usuario = UsuariosDAO.getUsuario(session, p_user);
		
		if((usuario != null) && usuario.getClave().equals(p_pass)) {
			/*//Muestro HTML de login correcto
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Login correcto</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>BIENVENIDO " + usuario.getNombre() + "</h1>");
			out.println("<h3>Se ha iniciado sesión de forma correcta</h3>");
			out.println("</body>");
			out.println("</html>");
			*/
			
			request.getRequestDispatcher("Menu.jsp").forward(request, response);
			
			logger.info("Se ha logueado CORRECTAMENTE");
			logger.info(usuario.toString());
		}
		else {
			/*//Muestro HTML de login incorrecto
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Login incorrecto</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>El usuario o la contraseña son incorrectos</h1>");
			out.println("</body>");
			out.println("</html>");
			*/
			
			
			logger.info("No se ha encontrado usuario o la contraseña es incorrecta");
		}
		
	}

}
