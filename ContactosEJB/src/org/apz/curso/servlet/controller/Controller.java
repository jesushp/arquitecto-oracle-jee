package org.apz.curso.servlet.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 3538470559673224562L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlFinal = "contactos.jsp";
		
		String action = Optional.ofNullable(request.getParameter("action")).orElse("");
		
		switch(action) {
			case "alta":
				request.getRequestDispatcher("alta").include(request,response);
				request.getRequestDispatcher("contactos").include(request,response);
				break;
			case "eliminar":
				request.getRequestDispatcher("eliminar").include(request,response);
				request.getRequestDispatcher("contactos").include(request,response);
				break;
			case "datos":
				urlFinal="datos.html";
				break;
			default:
				request.getRequestDispatcher("contactos").include(request,response);
		}
		//transferimos la peticion a la vista
		request.getRequestDispatcher(urlFinal).forward(request,response);
	}
	
	
}
