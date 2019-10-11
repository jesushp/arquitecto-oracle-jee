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
import org.apz.curso.model.Tema;

@WebServlet("/temas")
public class TemasServlet extends HttpServlet {
	
	private static final long serialVersionUID = 876149051938421126L;
	
	@Inject
	TemaDao temaDao;
	
	@Inject
	LibroDao libroDao;
	
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
		List<Tema> temas = temaDao.findAll();
		request.setAttribute("temas", temas);
		request.setAttribute("title", "Listado de temas");
		request.getRequestDispatcher("temas/temas.jsp").forward(request, response);
	}


	private void detailAction(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Tema tema = temaDao.findById(id);
		tema.setLibros(libroDao.findByTema(id));
		request.setAttribute("tema", tema);
		request.setAttribute("title", "Detalle del tema \"" + tema.getTema()+"\"");
		request.getRequestDispatcher("temas/detail.jsp").forward(request, response);
		
	}


}
