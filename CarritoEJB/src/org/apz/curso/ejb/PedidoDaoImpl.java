package org.apz.curso.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apz.curso.model.Pedido;

/**
 * Session Bean implementation class PedidoDaoImpl
 */
@Stateless
public class PedidoDaoImpl implements PedidoDao {
	
	@PersistenceContext(name="CarritoPU")
	EntityManager em;
	
	@Override
	public void add(Pedido pedido) {
		em.persist(pedido);
	}

	@Override
	public void delete(int id) {
		Pedido pedido = em.find(Pedido.class, id);
		em.remove(pedido);
	}

	@Override
	public List<Pedido> findAll() {
		return em.createNamedQuery("Pedido.findAll", Pedido.class).getResultList();
		/*
		String jpql = "Select p From Pedido p";
		Query qr=em.createQuery(jpql);
		return (List<Pedido>)qr.getResultList();*/
	}

	@Override
	public Pedido findById(int id) {
		return  em.find(Pedido.class, id);
	}


}
