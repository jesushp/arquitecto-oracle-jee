package org.apz.curso.service;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import org.apz.curso.ejb.ClienteDao;
import org.apz.curso.ejb.LibroDao;
import org.apz.curso.ejb.VentasDao;
import org.apz.curso.model.Cliente;
import org.apz.curso.model.Libro;
import org.apz.curso.model.Venta;


/**
 * Session Bean implementation class DaoVentasImpl
 */
@Stateless
public class VentasServiceImpl implements VentasService {
	
	private static final Logger logger = Logger.getLogger("org.apz.curso.service.VentasServiceImpl");
	
	@EJB
	VentasDao ventasDao;
	
	@EJB
	ClienteDao clienteDao;
	
	@EJB
	LibroDao libroDao;
	
	/** IoD del productor JMS implementa javax.jms.ConnectionFactory  */
	@Resource(type=ConnectionFactory.class, lookup = "java:/jms/LibrosFactory")
	ConnectionFactory factory;
	
	/** IoD del consumidor JMS implementa javax.jms.Queue  */
	@Resource(type=Queue.class, lookup = "java:/jms/LibrosQueue")
	Queue queue;
	
	
	@Override
	public boolean procesarPedido(String isbn, int idCliente) {
		
		try {
			
			Libro libro = libroDao.findById(isbn);
			Cliente cliente = clienteDao.findById(idCliente);
			Venta venta = new Venta(new Date(), cliente, libro);
			
			//conexion JMS
			try(Connection con = factory.createConnection();
				Session session = con.createSession()) {
				
				//Se genera el productor de mensajes
				MessageProducer producer = session.createProducer(queue);
				
				//se genera el mensaje
				ObjectMessage ventaMessage = session.createObjectMessage(venta);
				
				logger.info("Envio del mensaje");
				producer.send(ventaMessage);
				
			}
			return true;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error {0}", e.getMessage());
			return false;
		}
	}


	@Override
	public List<Venta> listByCliente(int idCliente) {
		return ventasDao.listByCliente(idCliente);
	}


	@Override
	public List<Venta> listAll() {
		return ventasDao.listAll();
	}


	@Override
	public Venta findById(int id) {
		return ventasDao.findById(id);
	}
}
