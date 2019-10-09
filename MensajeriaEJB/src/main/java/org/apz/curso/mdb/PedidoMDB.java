package org.apz.curso.mdb;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apz.curso.bean.Pedido;

/**
 * MDB Message Driven Bean
 */
@MessageDriven(activationConfig = { 
					@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
					@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/TestQueue"),
			})
public class PedidoMDB implements MessageListener {

    public PedidoMDB() {
    }
	
    private static final Logger logger = Logger.getLogger("org.apz.curso.mdb.PedidoMDB");
    
    
	/**
     * Metodo que recibe los mensajes de la cola
     */
    public void onMessage(Message message) {
    	try {
    		ObjectMessage om = (ObjectMessage) message;
            Pedido pedido = (Pedido)om.getObject();
            logger.log(Level.INFO, "Pedido recibido en el MDB: {0}", pedido.toString());
        	
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error {0}", e.getMessage());
			System.err.println(e.getMessage());
		}
        
    }

}
