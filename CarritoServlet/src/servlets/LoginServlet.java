package servlets;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet  extends HttpServlet {
	
	private static final long serialVersionUID = -7328195810388905719L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Arrays.asList(request.getCookies()).stream().filter(c-> ("usuario".equals(c.getName()) && !c.getValue().isEmpty())).findFirst().get();
			request.getRequestDispatcher("carrito").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("form-login.html").forward(request, response);
		}
		
	}
	
}
