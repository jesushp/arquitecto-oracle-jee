package org.apz.curso.servlet.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apz.curso.service.VentasService;
import org.apz.curso.servlet.api.bean.ApiResponse;


/**
 * Servlet implementation class VentasAction
 */
@WebServlet("/ask")
public class AskServlet extends HttpServlet {
	
	private static final long serialVersionUID = -8740183102362327967L;
	
	private static final Logger logger = Logger.getLogger("org.apz.curso.servlet.VentasServlet");
	
	@EJB
	VentasService ventasService;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/plain");
		ApiResponse feedback;
		try {
			
			//int id = Optional.ofNullable(request.getParameter("id")).map(i-> Integer.valueOf(i)).orElse(0);
			
			String isbn = Optional.ofNullable(request.getParameter("isbn")).orElse("");
			int idCliente = Optional.ofNullable(request.getParameter("idCliente")).map(i-> Integer.valueOf(i)).orElse(0);
			
			if (ventasService.procesarPedido(isbn, idCliente)) {
				
				feedback= new ApiResponse(true, "Se ha procesado el pedido correctamente");
				
			} else {
				feedback= new ApiResponse(false, "Ha habido un error al procesar pedido");
			}
			
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error {0}", e.getMessage());
			feedback= new ApiResponse(false, "Ha habido un error al procesar pedido",  e.getMessage());
		}
		
		out.println(parseJSON(feedback));
		
	}


	private String parseJSON(ApiResponse feedback) throws IOException {
		
			JsonObjectBuilder objectBuilder = Json.createObjectBuilder()
					  .add("success", feedback.isSucces())
					  .add("message", feedback.getMessage());
			
			JsonObject jsonObject = objectBuilder.build();
			
			String jsonString;
			try(Writer writer = new StringWriter()) {
			    Json.createWriter(writer).write(jsonObject);
			    jsonString = writer.toString();
			}
			return jsonString;
		
	}
	
	
	

}
