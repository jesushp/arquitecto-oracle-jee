package org.apz.curso.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("error")
public class ErrorServlet extends HttpServlet {

	private static final long serialVersionUID = 7551060845948761445L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)  {
		try {
			request.getRequestDispatcher("error.jsp").forward(request, response);
	
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	

}
