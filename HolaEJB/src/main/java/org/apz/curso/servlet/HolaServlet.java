package org.apz.curso.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apz.curso.ejb.HolaEJB;


/**
 * Ejemplos de IoD de EJB
 *
 */
@WebServlet("hola")
public class HolaServlet extends HttpServlet {

	private static final long serialVersionUID = -3678581590304595106L;
	
	/** Inyeccion del EJB Hola. IoD solo de EJB  */
	@EJB
	HolaEJB hola;
	
	/** Inyeccion del EJB Hola. Inject hace la IoD de cualquier objeto  */
	@Inject
	HolaEJB hola2;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String mensaje = hola.mensaje("arturo");
		String mensaje2 = hola.mensaje("pepe");
		
		PrintWriter writer = response.getWriter();
		writer.println("<h1>"+mensaje+"</h1>");
		writer.println("<h1>"+mensaje2+"</h1>");
		llamadaJNDI(writer);
	}
	
	/**
	 * Ejemplo de uso de JNDI para 
	 * @param writer
	 */
	private void llamadaJNDI(PrintWriter writer) {
		try {
				
				Context ct = new InitialContext();
				HolaEJB holaLocal  =(HolaEJB)ct.lookup("java:global/HolaMundoEJB/Hola!org.apz.curso.ejb.HolaLocal");
				
				writer.println("<h1>"+holaLocal.mensaje("profe")+"</h1>");
		} catch(NamingException ex) {
			ex.printStackTrace();
		}
	}
	
}
