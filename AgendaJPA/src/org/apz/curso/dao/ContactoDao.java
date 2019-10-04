package org.apz.curso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apz.curso.model.Contacto;

/**
 * 
 */

public class ContactoDao {
	
	static EntityManager em;
	static {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("AgendaPU");
		em=factory.createEntityManager();
	}
	
	
	public void guardarContacto(Contacto con) {	
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(con);
		tx.commit();
	}
	public void eliminarContacto(String nombre) {	
		
		String jpql ="Select c From Contacto c where c.nombre='"+nombre+"'";
		TypedQuery<Contacto> tq=em.createQuery(jpql,Contacto.class);
		Contacto con=tq.getSingleResult();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.remove(con);
		tx.commit();
	}
	public void eliminarContactoPorId(int id) {			
		Contacto con=em.find(Contacto.class, id);
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		if(con!=null) {
			em.remove(con);
		}
		tx.commit();
	}
	public List<Contacto>  recuperarContactos() {
		
		
		String jpql="Select c From Contacto c";
		TypedQuery<Contacto> tq=em.createQuery(jpql,Contacto.class);
		return tq.getResultList();
	}


}
