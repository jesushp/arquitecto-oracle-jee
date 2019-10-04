package org.apz.curso.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apz.curso.model.Contacto;
import org.apz.curso.dao.ContactoDao;

/**
 * Servlet implementation class Alta
 */
@WebServlet(urlPatterns= {"/alta"})
public class AltaAction extends HttpServlet {
	
	private static final long serialVersionUID = 728798932273588937L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Contacto contacto=new Contacto(0,
				request.getParameter("nombre"),
				request.getParameter("email"),
				Integer.parseInt(request.getParameter("edad")));
		
		ContactoDao contactoDao =new ContactoDao();
		contactoDao.guardarContacto(contacto);
		
	}

}
