package org.apz.curso.mdb;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apz.curso.ejb.VentasDao;
import org.apz.curso.model.Venta;

/**
* MDB Message Driven Bean
*/
@MessageDriven(activationConfig = { 
					@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
					@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/LibrosQueue"),
			})
public class VentaMDB implements MessageListener {
	
	@EJB
	VentasDao ventasDao;	
 	
   public VentaMDB() {
   }
   
   private static final Logger logger = Logger.getLogger("org.apz.curso.mdb.LibroMDB");
   
   
	/**
    * Metodo que recibe los mensajes de la cola
    */
   public void onMessage(Message message) {
   	try {
   		
   		   ObjectMessage om = (ObjectMessage) message;
           Venta venta = (Venta)om.getObject();
           ventasDao.add(venta);
           logger.log(Level.INFO, "Pedido recibido en el MDB: {0}", venta.toString());
       	
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error {0}", e.getMessage());
			System.err.println(e.getMessage());
		}
       
   }

}

