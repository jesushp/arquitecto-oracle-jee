package org.apz.curso.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apz.curso.model.Libro;
import org.apz.curso.model.Tema;

/**
 * Session Bean implementation class LibroDaoImpl
 */
@Stateless
public class LibroDaoImpl implements LibroDao {
	
	@PersistenceContext(name="LibroPU" )
	EntityManager em;
	
	@Override
	public void add(Libro libro) {
		em.persist(libro);
	}

	@Override
	public void delete(String isbn) {
		Libro pedido = em.find(Libro.class, isbn);
		em.remove(pedido);
	}

	@Override
	public List<Libro> findAll() {
		return em.createNamedQuery("Libro.findAll", Libro.class).getResultList();
	}

	@Override
	public Libro findById(String isbn) {
		return  em.find(Libro.class, isbn);
	}

	@Override
	public void update(Libro pedido) {
		em.merge(pedido);
	}

	@Override
	public List<Libro> findByTema(int idTema) {
		Tema tema = em.find(Tema.class, idTema);
		return tema.getLibros();
	}
	/*
	 * @SuppressWarnings("unchecked")
	@Override
	public List<Libro> findByTema(int idTema) {
		Query q = em.createNamedQuery("Libro.findByTema", Libro.class);
		q.setParameter("idTema", idTema);			
		return q.getResultList();
	}
	 */

}
