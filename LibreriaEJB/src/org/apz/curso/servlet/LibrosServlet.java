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

import org.apz.curso.ejb.LibroDao;
import org.apz.curso.ejb.TemaDao;
import org.apz.curso.model.Libro;
import org.apz.curso.model.Tema;

@WebServlet("/libros")
public class LibrosServlet extends HttpServlet {
	
	private static final long serialVersionUID = 876149051938421126L;
	
	@Inject
	LibroDao libroDao;
	
	@Inject
	TemaDao temaDao;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = Optional.ofNullable(request.getParameter("action")).orElse("");
			String isbn = Optional.ofNullable(request.getParameter("isbn")).orElse("");
			
			switch (action) {
			case "edit":
				editAction(isbn, request, response);
				break;
			case "save":
				saveAction(request, response);
				break;
			case "delete":
				deleteAction(isbn, request, response);
				break;		
			default:
				listAction(request, response);
				break;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			request.setAttribute("error", e.getClass() + " : " +  e.getMessage());
			request.getRequestDispatcher("error").forward(request, response);
		}
		
	}


	private void deleteAction(String isbn, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		libroDao.delete(isbn);
		listAction(request, response);
		
	}

	private void listAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Libro> libros = libroDao.findAll();
		request.setAttribute("libros", libros);
		request.setAttribute("title", "Listado de libros");
		request.getRequestDispatcher("libros/libros.jsp").forward(request, response);
	}


	private void editAction(String isbn, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Tema> temas = temaDao.findAll();
		request.setAttribute("temas", temas);
		
		if ( isbn.isEmpty()) {
			request.setAttribute("title", "Alta de libros");
		} else {
			Libro libro = libroDao.findById(isbn);
			request.setAttribute("libro", libro);
			request.setAttribute("title", "Edición de "+libro.getTitulo());
			
		}
		
		request.getRequestDispatcher("libros/form.jsp").forward(request, response);
		
	}
	
	private void saveAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Tema tema = temaDao.findById(Integer.parseInt(request.getParameter("idTema")));
		
		Libro libro = new Libro(request.getParameter("isbn"), request.getParameter("autor"), Integer.valueOf(request.getParameter("paginas")), 
				Double.parseDouble(request.getParameter("precio")), request.getParameter("titulo"), tema);
		
		libroDao.add(libro);
		listAction(request, response);
	}

}
