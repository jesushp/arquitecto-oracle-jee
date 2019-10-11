package org.apz.curso.ejb;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apz.curso.model.Cliente;
import org.apz.curso.model.Venta;


/**
 * Session Bean implementation class DaoVentasImpl
 */
@Stateless
public class VentasDaoImpl implements VentasDao {
	
	//private static final Logger logger = Logger.getLogger("org.apz.curso.ejb.VentasDaoImpl");
	
	
	@PersistenceContext(unitName = "LibroPU")
	EntityManager em; 
	
	/** IoD del productor JMS implementa javax.jms.ConnectionFactory  */
	@Resource(type=ConnectionFactory.class, lookup = "java:/jms/TestFactory")
	ConnectionFactory factory;
	
	/** IoD del consumidor JMS implementa javax.jms.Queue  */
	@Resource(type=Queue.class, lookup = "java:/jms/TestQueue")
	Queue queue;
	
	@Override
	public List<Venta> listByCliente(int idCliente) {
		Cliente cliente = em.find(Cliente.class, idCliente);
		return cliente.getVentas();
	}

	@Override
	public List<Venta> listAll() {
		return em.createNamedQuery("Venta.findAll", Venta.class).getResultList();
	}

	@Override
	public void add(Venta venta) {
		em.persist(venta);
	}

	@Override
	public Venta findById(int id) {
		return em.find(Venta.class, id);
	}

}
