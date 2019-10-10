package org.apz.curso.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apz.curso.bean.Calculo;

/**
 * Future es util para llamadas asincronas. Representa un resultado futuro de una ejecucion asincrona
 *
 */
@WebServlet("/test-async-suma")
public class CalculoAsyncTestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 5646365464097054711L;
	
	private static final Logger logger = Logger.getLogger("org.apz.curso.servlet.CalculoAsyncTestServlet");
	
	@EJB
	Calculo calculo;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
			
			Future<Integer> future = calculo.suma(60);
			while(!future.isDone()) {
				logger.info("..... esperando .....");
			}
			
			out.println("<html><body>");
			int res= future.get();
			out.println("<h1>La suma es "+res+"</h1>");
			out.println("</body></html>");
		
		} catch(Exception e) {
			logger.log(Level.SEVERE, "Error {0}", e.getMessage());
		}
	} 

}
