package org.apz.curso.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apz.curso.model.Producto;

/**
 * Session Bean implementation class ProductoDaoImpl
 */
@Stateless
public class ProductoDaoImpl implements ProductoDao {
	
	@PersistenceContext(name="CarritoPU")
	EntityManager em;
	
	@Override
	public void add(Producto producto) {
		em.persist(producto);
	}

	@Override
	public void delete(int id) {
		Producto producto = em.find(Producto.class, id);
		em.remove(producto);
	}

	@Override
	public List<Producto> findAll() {
		return em.createNamedQuery("Producto.findAll", Producto.class).getResultList();
	}

	@Override
	public Producto findById(int id) {
		return em.find(Producto.class, id);
	}
	
	@Override
	public void update(Producto pedido) {
		em.merge(pedido);
	}
}