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

import org.apz.curso.ejb.ProductoDao;
import org.apz.curso.ejb.SeccionDao;
import org.apz.curso.model.Producto;
import org.apz.curso.model.Seccion;

@WebServlet("/productos")
public class ProductosServlet extends HttpServlet {
	
	private static final long serialVersionUID = 876149051938421126L;
	
	@Inject
	ProductoDao productoDao;
	
	@Inject
	SeccionDao seccionDao;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = Optional.ofNullable(request.getParameter("action")).orElse("");
			int id = Optional.ofNullable(request.getParameter("id")).map(i-> Integer.valueOf(i)).orElse(0);
			
			
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
		productoDao.delete(id);
		listAction(request, response);
	}

	private void listAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Producto> productos = productoDao.findAll();
		request.setAttribute("productos", productos);
		request.getRequestDispatcher("productos/productos.jsp").forward(request, response);
	}


	private void editAction(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (id > 0) {
			Producto producto = productoDao.findById(id);
			request.setAttribute("producto", producto);
		}
		List<Seccion> secciones = seccionDao.findAll();
		request.setAttribute("secciones", secciones);
		request.getRequestDispatcher("productos/form.jsp").forward(request, response);
		
	}
	
	private void saveAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Seccion seccion = seccionDao.findById(Integer.parseInt(request.getParameter("idSeccion")));
		
		int id = Optional.ofNullable(request.getParameter("idProducto")).filter(i -> !i.isEmpty()).map(i-> Integer.valueOf(i)).orElse(0);
		
		Producto producto = new Producto(id, request.getParameter("descripcion"), seccion, request.getParameter("nombre"), Integer.parseInt(request.getParameter("precio")));
		
		productoDao.add(producto);
		listAction(request, response);
	}
	
	
	
}
