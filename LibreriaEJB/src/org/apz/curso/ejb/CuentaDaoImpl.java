package org.apz.curso.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apz.curso.model.Cuenta;

/**
 * Session Bean implementation class CuentaDaoImpl
 */
@Stateless
public class CuentaDaoImpl implements CuentaDao {
	
	@PersistenceContext(name="LibroPU")
	EntityManager em;
	
	@Override
	public void add(Cuenta cliente) {
		em.persist(cliente);
	}

	@Override
	public void delete(int id) {
		Cuenta producto = em.find(Cuenta.class, id);
		em.remove(producto);
	}

	@Override
	public List<Cuenta> findAll() {
		return em.createNamedQuery("Cuenta.findAll", Cuenta.class).getResultList();
	}

	@Override
	public Cuenta findById(int id) {
		return em.find(Cuenta.class, id);
	}
	
	@Override
	public void update(Cuenta cliente) {
		em.merge(cliente);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cuenta> findByCliente(String dni) {
		Query query = em.createNamedQuery("Cuenta.listByCliente", Cuenta.class); //.getResultList();
		query.setParameter("dni", dni);
		return query.getResultList();
	}

	
	
}