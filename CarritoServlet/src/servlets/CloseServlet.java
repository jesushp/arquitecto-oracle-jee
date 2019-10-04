package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cerrar")
public class CloseServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie ck=new Cookie("usuario","");
		ck.setMaxAge(0);
		response.addCookie(ck);
		
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		request.getRequestDispatcher("login").forward(request, response);
		
	}

}
