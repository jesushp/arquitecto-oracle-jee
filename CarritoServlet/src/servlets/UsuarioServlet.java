package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.UsuarioDAO;
import model.Usuario;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {
	
	private static final long serialVersionUID = -5654107612329614225L;
	
	private String VIEW = "usuarios.jsp";
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		try {
			//HttpSession sesion = request.getSession();
			//List<Producto> productos = Optional.ofNullable((List)sesion.getAttribute("productos")).orElse(new ArrayList<>());
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			List<Usuario> usuarios = usuarioDAO.getUsuarios();
			request.setAttribute("usuarios",usuarios);
			
			rd = request.getRequestDispatcher(VIEW);
			
		
		} catch (Exception e) {
			System.err.println(e.getMessage());
			rd = request.getRequestDispatcher("Error");
			
		}
		
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			String nombre=request.getParameter("nombre");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			int edad= Integer.valueOf(request.getParameter("edad"));
			usuarioDAO.insertUSuario(new Usuario(nombre, password, email, edad));
			
			//rd = request.getRequestDispatcher(VIEW);
			doGet(request, response);
			
		} catch (Exception e) {
			rd = request.getRequestDispatcher("Error");
		}
		//rd.forward(request, response);
		
	}
	
	

}
