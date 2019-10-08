package org.apz.curso.servlet;


import java.io.IOException;
import java.util.Optional;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apz.curso.ejb.ClienteDao;
import org.apz.curso.ejb.VentasDao;
import org.apz.curso.model.Cliente;


/**
 * Servlet implementation class VentasAction
 */
@WebServlet("/ventas")
public class VentasServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8740183102362327967L;
	
	@EJB
	VentasDao ventasDao;
	
	@EJB
	ClienteDao clienteDao;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = Optional.ofNullable(request.getParameter("action")).orElse("");
		int id = Optional.ofNullable(request.getParameter("id")).map(i-> Integer.valueOf(i)).orElse(0);
		
		switch (action) {
			default:
				listAction(id, request, response);
				break;
		}
		
	}
	
	private void listAction(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (id > 0) {
			Cliente cliente = clienteDao.findById(id);
			request.setAttribute("ventas", ventasDao.listByCliente(cliente.getIdCliente()));
			request.setAttribute("title", "Ventas del cliente "+ cliente.getEmail());
			
		} else {
			request.setAttribute("ventas", ventasDao.listAll());
			request.setAttribute("title", "Ventas de los clientes");
			
		}
		request.getRequestDispatcher("ventas/ventas.jsp").forward(request, response);
		
	}
	
	

}
