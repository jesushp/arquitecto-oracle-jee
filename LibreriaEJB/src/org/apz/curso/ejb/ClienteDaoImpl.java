package org.apz.curso.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apz.curso.model.Cliente;

/**
 * Session Bean implementation class ClienteDaoImpl
 */
@Stateless
public class ClienteDaoImpl implements ClienteDao {
	
	@PersistenceContext(name="LibroPU")
	EntityManager em;
	
	@Override
	public void add(Cliente cliente) {
		em.persist(cliente);
	}

	@Override
	public void delete(int id) {
		Cliente producto = em.find(Cliente.class, id);
		em.remove(producto);
	}

	@Override
	public List<Cliente> findAll() {
		return em.createNamedQuery("Cliente.findAll", Cliente.class).getResultList();
	}

	@Override
	public Cliente findById(int id) {
		return em.find(Cliente.class, id);
	}
	
	@Override
	public void update(Cliente cliente) {
		em.merge(cliente);
	}

	@Override
	public List<Cliente> listByCuenta(int numeroCuenta) {
		//Cuenta cuenta = em.find(Cuenta.class, numeroCuenta);
		//return cuenta.getClientes();
		TypedQuery<Cliente> query = em.createNamedQuery("Cliente.listByCuenta", Cliente.class); //.getResultList();
		query.setParameter("numeroCuenta", numeroCuenta);
		return query.getResultList();
	}

	@Override
	public List<Cliente> listByFechaMovimiento(Date fechaMovimiento) {
		TypedQuery<Cliente> query = em.createNamedQuery("Cliente.listByFechaMovimiento", Cliente.class); //.getResultList();
		query.setParameter("fecha", fechaMovimiento);
		return query.getResultList();
	}

	
}