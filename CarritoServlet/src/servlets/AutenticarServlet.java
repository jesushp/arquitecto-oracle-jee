package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.UsuarioDAO;
import model.Usuario;

/**
 * Servlet implementation class Autenticar
 */
@WebServlet("/autenticar")
public class AutenticarServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		RequestDispatcher rd;
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuarioPost = new Usuario(user, pwd);
			Usuario usuario = usuarioDAO.getUsuario(usuarioPost);
			//request.setAttribute("persona", usuario);
			
			addCookie(response, usuario.getNombre());
			
			HttpSession sesion=request.getSession();
			sesion.setAttribute("persona", usuario);
			
			//rd=request.getRequestDispatcher("carrito");
			//rd.forward(request, response);
			
			response.sendRedirect("carrito");
		
		} catch (Exception e) {
			System.err.println(e.getMessage());
			rd = request.getRequestDispatcher("Error");
			response.sendRedirect("error.jsp?user="+user+"&pwd="+pwd);
		}
		
	}

	private void addCookie(HttpServletResponse response, String nombre) {
		Cookie cookie =new Cookie("usuario", nombre);
		response.addCookie(cookie);
	}
	
}
