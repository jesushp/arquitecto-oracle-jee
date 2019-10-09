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

import org.apz.curso.ejb.ClienteDao;
import org.apz.curso.model.Cliente;

@WebServlet("/clientes")
public class ClienteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 876149051938421126L;
	
	@Inject
	ClienteDao clienteDao;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = Optional.ofNullable(request.getParameter("action")).orElse("");
			int id = Optional.ofNullable(request.getParameter("id")).map(i-> Integer.valueOf(i)).orElse(0);
			
			List<Cliente> test = clienteDao.listByCuenta(1000);
			
			System.out.println(test);
			
			switch (action) {
			case "edit":
				editAction(id, request, response);
				break;
			case "delete":
				deleteAction(id, request, response);
				break;	
			case "save":
				saveAction(request, response);
				break;	
			default:
				listAction(request, response);
				break;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("error").forward(request, response);
		}
		
	}
	
	private void deleteAction(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clienteDao.delete(id);
		listAction(request, response);
	}

	private void listAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cliente> clientes = clienteDao.findAll();
		request.setAttribute("clientes", clientes);
		request.setAttribute("title", "Listado de clientes");
		request.getRequestDispatcher("clientes/clientes.jsp").forward(request, response);
	}


	private void editAction(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (id > 0) {
			Cliente cliente = clienteDao.findById(id);
			request.setAttribute("cliente", cliente);
			request.setAttribute("title", "Edición de "+ cliente.getEmail());
		} else {
			request.setAttribute("title", "Alta de clientes");
		}
		request.getRequestDispatcher("clientes/form.jsp").forward(request, response);
		
	}
	
	private void saveAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Optional.ofNullable(request.getParameter("idCliente"))
				.filter(i -> !i.isEmpty())
				.map(i-> Integer.valueOf(i)).orElse(0);
		
		Cliente cliente = new Cliente(id, request.getParameter("email"), request.getParameter("password"), Integer.parseInt(request.getParameter("telefono")), request.getParameter("dni"));
		
		if (id > 0) {
			clienteDao.update(cliente);
		} else {
			clienteDao.add(cliente);
		}
		
		listAction(request, response);
	}
	
	
	
}
