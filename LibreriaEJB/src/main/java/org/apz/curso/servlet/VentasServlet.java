package org.apz.curso.servlet;


import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apz.curso.ejb.ClienteDao;
import org.apz.curso.model.Cliente;
import org.apz.curso.service.VentasService;


/**
 * Servlet implementation class VentasAction
 */
@WebServlet("/ventas")
public class VentasServlet extends HttpServlet {
	
	private static final long serialVersionUID = -8740183102362327967L;
	
	private static final Logger logger = Logger.getLogger("org.apz.curso.servlet.VentasServlet");
	
	@EJB
	VentasService ventasService;
	
	@EJB
	ClienteDao clienteDao;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String action = Optional.ofNullable(request.getParameter("action")).orElse("");
			int id = Optional.ofNullable(request.getParameter("id")).map(i-> Integer.valueOf(i)).orElse(0);
			String isbn = Optional.ofNullable(request.getParameter("isbn")).orElse("");
			int idCliente = Optional.ofNullable(request.getParameter("idCliente")).map(i-> Integer.valueOf(i)).orElse(0);
			
			switch (action) {
				case "ask":
					procesarPedido(isbn, idCliente, request, response);
					break;
				default:
					listAction(id, request, response);
					break;
			}
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error {0}", e.getMessage());
			request.setAttribute("error", e.getClass() + " : " +  e.getMessage());
			request.getRequestDispatcher("error").forward(request, response);
		}
		
		
	}
	
	/**
	 * Insercion en la tabla ventas por mensajeria
	 * @param isbn
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void procesarPedido(String isbn, int idCliente, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TODO login cliente
		if (ventasService.procesarPedido(isbn, idCliente)) {
			logger.info("Se ha procedado el pedido de "+ isbn);
			request.setAttribute("feedback", "Se ha procedado el pedido de"+ isbn);
			listAction(idCliente, request, response);
		}
		
	}

	private void listAction(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (id > 0) {
			Cliente cliente = clienteDao.findById(id);
			request.setAttribute("ventas", ventasService.listByCliente(cliente.getIdCliente()));
			request.setAttribute("title", "Ventas del cliente "+ cliente.getEmail());
			
		} else {
			request.setAttribute("ventas", ventasService.listAll());
			request.setAttribute("title", "Ventas de los clientes");
			
		}
		request.getRequestDispatcher("ventas/ventas.jsp").forward(request, response);
		
	}
	
	

}
