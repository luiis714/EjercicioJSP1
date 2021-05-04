package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datamodel.dao.RolesDAO;
import datamodel.dao.UsuariosDAO;
import datamodel.entities.Roles;
import datamodel.entities.Usuarios;

/**
 * Servlet implementation class ListadoRoles
 */
@WebServlet("/ListadoRoles")
public class ListadoRoles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoRoles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Roles> listaRoles = RolesDAO.getAllRoles();
		request.setAttribute("listaRoles", listaRoles);
		
		request.getRequestDispatcher("ListadoRoles.jsp").forward(request, response);
	}

}
