package org.apz.curso.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apz.curso.model.Contacto;

/**
 * 
 */
@Stateless
public class ContactoDaoImpl implements ContactoDao {
	
	/** Hace referencia a la entrada de persitence.xml" */
	@PersistenceContext(name="agendaPU")
	EntityManager em;
	
    @Override
	public void altaContacto(Contacto contacto) {
		em.persist(contacto);
		
	}

	@Override
	public List<Contacto> recuperarContactos() {
		String jpql = "Select c From Contacto c";
		Query qr=em.createQuery(jpql);
		return (List<Contacto>)qr.getResultList();
	}

	@Override
	public void eliminarContacto(int id) {
		Contacto contacto = em.find(Contacto.class, id);
		em.remove(contacto);
		
	}

	@Override
	public Contacto recuperarByName(String name) {
		//String jpql = "Select c From Contacto c where c.nombre like '%"+name+"%'";
		String jpql = "Select c From Contacto c where c.nombre like '%?name%'";
		Query qr = em.createQuery(jpql);
		qr.setParameter("name", name);
		return (Contacto)qr.getSingleResult();
	}

	@Override
	public Contacto recuperarByEmail(String email) {
		//String jpql = "Select c From Contacto c where c.email='"+email+"'";
		String jpql = "Select c From Contacto c where c.email=?1";
		Query qr = em.createQuery(jpql);
		qr.setParameter(1, email);
		return (Contacto)qr.getSingleResult();
	}

}
