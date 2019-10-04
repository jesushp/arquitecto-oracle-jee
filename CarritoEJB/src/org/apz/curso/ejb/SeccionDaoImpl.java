package org.apz.curso.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apz.curso.model.Seccion;

/**
 * Session Bean implementation class SeccionDaoImpl
 */
@Stateless
public class SeccionDaoImpl implements SeccionDao {
	
	@PersistenceContext(name="CarritoPU")
	EntityManager em;
	
	@Override
	public void add(Seccion seccion) {
		em.persist(seccion);
	}

	@Override
	public void delete(int id) {
		Seccion seccion = em.find(Seccion.class, id);
		em.remove(seccion);
	}

	@Override
	public List<Seccion> findAll() {
		return em.createNamedQuery("Seccion.findAll", Seccion.class).getResultList();
	}

	@Override
	public Seccion findById(int id) {
		return  em.find(Seccion.class, id);
	}


}
