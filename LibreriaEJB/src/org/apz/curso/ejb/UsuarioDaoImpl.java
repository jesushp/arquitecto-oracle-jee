package org.apz.curso.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apz.curso.model.Usuario;

/**
 * Session Bean implementation class ClienteDaoImpl
 */
@Stateless
public class UsuarioDaoImpl implements UsuarioDao {
	
	@PersistenceContext(name="LibroPU")
	EntityManager em;
	
	@Override
	public Usuario getUsuario(String email, String password) throws Exception {
		Query q= em.createNamedQuery("Usuario.login", Usuario.class);
		q.setParameter("email", email);
		q.setParameter("password", password);
		return (Usuario)q.getSingleResult();
	}
}