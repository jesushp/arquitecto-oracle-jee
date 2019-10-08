package org.apz.curso.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apz.curso.ejb.UsuarioDao;
import org.apz.curso.model.Usuario;

@WebServlet("login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 876149051938421126L;
	
	@Inject
	UsuarioDao usuarioDao;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			String email = Optional.ofNullable(request.getParameter("email")).orElse("");
			String password = Optional.ofNullable(request.getParameter("password")).orElse("");
			HttpSession sesion = request.getSession();
			
			if (email.isEmpty() || password.isEmpty()) {
				if (sesion.getAttribute("usuario")!=null) {
					response.sendRedirect("libros");
				}
				
				request.setAttribute("error", "");
			} else {
				
				Usuario usuario = usuarioDao.getUsuario(email, password);
				sesion.setAttribute("usuario", usuario);
				response.sendRedirect("libros");
			
			}
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			request.setAttribute("error", e.getClass() + " : " +  e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		
	}

}
