package org.apz.curso.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apz.curso.model.Cliente;
import org.apz.curso.model.Venta;


/**
 * Session Bean implementation class DaoVentasImpl
 */
@Stateless
public class VentasDaoImpl implements VentasDao {
	
	@PersistenceContext(unitName = "LibroPU")
	EntityManager em; 
	
	@Override
	public List<Venta> listByCliente(int idCliente) {
		Cliente cliente = em.find(Cliente.class, idCliente);
		return cliente.getVentas();
	}

	@Override
	public List<Venta> listAll() {
		return em.createNamedQuery("Venta.findAll", Venta.class).getResultList();
	}


}
