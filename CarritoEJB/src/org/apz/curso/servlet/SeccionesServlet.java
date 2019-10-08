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

import org.apz.curso.ejb.SeccionDao;
import org.apz.curso.model.Seccion;

@WebServlet("/secciones")
public class SeccionesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 876149051938421126L;
	
	@Inject
	SeccionDao seccionDao;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = Optional.ofNullable(request.getParameter("action")).orElse("");
			int id = Optional.ofNullable(request.getParameter("id")).map(i-> Integer.valueOf(i)).orElse(0);
			
			switch (action) {
			case "detail":
				detailAction(id, request, response);
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
	
	private void listAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Seccion> productos = seccionDao.findAll();
		request.setAttribute("productos", productos);
		request.setAttribute("title", "Listado de productos");
		request.getRequestDispatcher("secciones/secciones.jsp").forward(request, response);
	}


	private void detailAction(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Seccion seccion = seccionDao.findById(id);
		request.setAttribute("seccion", seccion);
		request.setAttribute("title", "Detalle de " + seccion);
		request.getRequestDispatcher("secciones/detail.jsp").forward(request, response);
		
	}


}
