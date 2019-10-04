package org.apz.curso.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apz.curso.ejb.PedidoDao;
import org.apz.curso.model.Pedido;

@WebServlet("/pedidos")
public class PedidosServlet extends HttpServlet {
	
	private static final long serialVersionUID = 876149051938421126L;
	
	@Inject
	PedidoDao pedidoDao;
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = Optional.ofNullable(request.getParameter("action")).orElse("");
			int id = Optional.ofNullable(request.getParameter("id")).map(i-> Integer.valueOf(i)).orElse(0);
			
			switch (action) {
			case "edit":
				editAction(id, request, response);
				break;
			case "save":
				saveAction(request, response);
				break;
			case "delete":
				deleteAction(id, request, response);
				break;		
			default:
				listAction(request, response);
				break;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			request.setAttribute("error", e.getClass() + " : " +  e.getMessage());
			request.getRequestDispatcher("error").forward(request, response);
			//response.sendRedirect("error");
		}
		
	}


	private void deleteAction(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pedidoDao.delete(id);
		listAction(request, response);
		
	}

	private void listAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pedido> pedidos = pedidoDao.findAll();
		request.setAttribute("pedidos", pedidos);
		request.getRequestDispatcher("pedidos/pedidos.jsp").forward(request, response);
	}


	private void editAction(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ( id > 0) {
			Pedido pedido = pedidoDao.findById(id);
			request.setAttribute("pedido", pedido);
		}	
		request.getRequestDispatcher("pedidos/form.jsp").forward(request, response);
		
	}
	
	private void saveAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Optional.ofNullable(request.getParameter("idPedido")).filter(i -> !i.isEmpty()).map(i-> Integer.valueOf(i)).orElse(0);
		
		
		Pedido pedido = new Pedido(id, request.getParameter("categoria"), Integer.parseInt(request.getParameter("precio")), request.getParameter("producto"));
		pedidoDao.add(pedido);
		listAction(request, response);
	}

}
