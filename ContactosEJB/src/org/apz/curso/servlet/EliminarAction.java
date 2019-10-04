package org.apz.curso.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apz.curso.dao.ContactoDao;

/**
 * Servlet implementation class EliminarAction
 */
@WebServlet("/eliminar")
public class EliminarAction extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3462032302854514439L;
	@Inject
	ContactoDao contactoDAO;
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		contactoDAO.eliminarContacto(id);
	}

}
