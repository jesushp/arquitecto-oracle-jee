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

import org.apz.curso.ejb.CuentaDao;
import org.apz.curso.model.Cuenta;

@WebServlet("/cuentas")
public class CuentasServlet extends HttpServlet {
	
	private static final long serialVersionUID = 876149051938421126L;
	
	@Inject
	CuentaDao cuentaDao;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = Optional.ofNullable(request.getParameter("action")).orElse("");
			int id = Optional.ofNullable(request.getParameter("id")).map(i-> Integer.valueOf(i)).orElse(0);
			String dni = Optional.ofNullable(request.getParameter("dni")).orElse("");
			
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
				listAction(dni, request, response);
				break;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			request.setAttribute("error", e.getClass() + " : " +  e.getMessage());
			request.getRequestDispatcher("error").forward(request, response);
		}
		
	}


	private void deleteAction(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cuentaDao.delete(id);
		listAction("", request, response);
	}

	private void listAction(String dni, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Cuenta> cuentas;
		
		if (dni.isEmpty()) {
			cuentas = cuentaDao.findAll();
			request.setAttribute("title", "Listado de cuentas");
			
		} else {
			cuentas = cuentaDao.findByCliente(dni);
			request.setAttribute("title", "Listado de cuentas de " + dni);
		}
		
		request.setAttribute("cuentas", cuentas);
		request.getRequestDispatcher("cuentas/cuentas.jsp").forward(request, response);
	}


	private void editAction(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO
		
	}
	
	private void saveAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO
	}

}
