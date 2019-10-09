package org.apz.curso.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apz.curso.bean.Pedido;

/**
 * Productor de mensajes
 *
 */
@WebServlet("/pedido-producer")
public class PedidoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 6980138688858791951L;

	private static final Logger logger = Logger.getLogger("org.apz.curso.servlet.PedidoServlet");
	
	/** IoD del productor JMS implementa javax.jms.ConnectionFactory  */
	@Resource(type=ConnectionFactory.class, lookup = "java:/jms/TestFactory")
	ConnectionFactory factory;
	
	/** IoD del consumidor JMS implementa javax.jms.Queue  */
	@Resource(type=Queue.class, lookup = "java:/jms/TestQueue")
	Queue queue;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Pedido pedido = new Pedido(1, "Alimentacioón", 98.97, "Jamón Serrano");
		try {
			
			//conexion JMS
			try(Connection con = factory.createConnection();
				//sesion JMS
				Session session = con.createSession()) {
				
				//Se genera el productor de mensajes
				MessageProducer producer = session.createProducer(queue);
				
				//se genera el mensaje
				ObjectMessage pedidoMessage = session.createObjectMessage(pedido);
				
				logger.info("Envio del mensaje");
				producer.send(pedidoMessage);
				
			}
			
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error {0}", e.getMessage());
		}
		
		
	}

}
