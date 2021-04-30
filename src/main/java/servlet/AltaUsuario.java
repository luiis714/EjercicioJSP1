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
import datamodel.dao.UsuariosDAO;
import datamodel.entities.Roles;
import datamodel.entities.Usuarios;
import datamodel.util.HibernateUtil;

/**
 * Servlet implementation class AltaUsuario
 */
@WebServlet("/AltaUsuario")
public class AltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Logger logger = LogManager.getLogger(Login.class);
	
	private Session session;
	private Transaction tx;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		//Abro la session con la BBDD a través hibernate
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
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
			
		String p_id_rol = request.getParameter("id_rol");
		String p_email = request.getParameter("email");
		String p_clave = request.getParameter("clave");
		String p_nombre = request.getParameter("nombre");
		String p_apellido1 = request.getParameter("apellido1");
		String p_apellido2 = request.getParameter("apellido2");
		String p_direccion = request.getParameter("direccion");
		String p_localidad = request.getParameter("localidad");
		String p_provincia = request.getParameter("provincia");
		String p_telefono = request.getParameter("telefono");
		String p_dni = request.getParameter("dni");
		
		logger.info("Se recogen los datos pasados por el html");
		
		insertarUsuario(p_id_rol, p_email, p_clave, p_nombre, p_apellido1, p_apellido2, 
				p_direccion, p_localidad, p_provincia, p_telefono, p_dni, out);
		
	}
	
	private void insertarUsuario(String p_id_rol, String p_email, String p_clave, String p_nombre, String p_apellido1,
			String p_apellido2, String p_direccion, String p_localidad, String p_provincia, String p_telefono,
			String p_dni, PrintWriter out) {

		Usuarios usuario = null;
		
		try {
			usuario = new Usuarios(Integer.parseInt(p_id_rol), p_email, p_clave, p_nombre, p_apellido1, p_apellido2, p_direccion, p_localidad, p_provincia, p_telefono, p_dni);
			
			UsuariosDAO.insertUsuario(session, usuario);
			
			tx.commit();//Hago un commit en la BBDD
			logger.info("Usuario insertado correctamente " + usuario.toString());
			
			muestraInfo(usuario, out);
		}catch(Exception ex) {
			logger.error("Ocurrio un error al insertar el usuario");
			muestraError(out);
		}

	}
	
	/**Muestra una pantalla de error al usuario*/
	private void muestraError(PrintWriter out) {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Error inserción</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>ERROR. No se ha podido insertar el usuario por un error inserperado</h1>");
		out.println("</br>Es mi primerito día");
		out.println("</body>");
		out.println("</html>");
		
		logger.info("Se muestra que ha saltado un error de que el Rol no existe");
		
	}
	
	/**Muestra una página de información sobre la inserción correcta*/
	private void muestraInfo(Usuarios usuario, PrintWriter out) {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Inserción correcta</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>USUARIO INSERTADO CORRECTAMENTE</h1>");
		out.println("<h3>ID: " + usuario.getId() + "</h3>");
		out.println("</br><h3>EMAIL: " + usuario.getEmail() + "</h3>");
		out.println("</br><h3>CLAVE: " + usuario.getClave() + "</h3>");
		out.println("</br><h3>NOMBRE: " + usuario.getNombre() + "</h3>");
		out.println("</body>");
		out.println("</html>");
		
		logger.info("Se ha mostrado información de una inserción correcta al usuario");
	}

}
