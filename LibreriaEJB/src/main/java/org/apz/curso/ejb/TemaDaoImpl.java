package org.apz.curso.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apz.curso.model.Tema;

/**
 * Session Bean implementation class TemaDaoImpl
 */
@Stateless
public class TemaDaoImpl implements TemaDao {
	
	@PersistenceContext(name="CarritoPU")
	EntityManager em;
	
	@Override
	public void add(Tema tema) {
		em.persist(tema);
	}

	@Override
	public void delete(int id) {
		Tema tema = em.find(Tema.class, id);
		em.remove(tema);
	}

	@Override
	public List<Tema> findAll() {
		return em.createNamedQuery("Tema.findAll", Tema.class).getResultList();
	}

	@Override
	public Tema findById(int id) {
		return  em.find(Tema.class, id);
	}

	@Override
	public Tema findByLibro(String titulo) {
		return null;
	}


}
