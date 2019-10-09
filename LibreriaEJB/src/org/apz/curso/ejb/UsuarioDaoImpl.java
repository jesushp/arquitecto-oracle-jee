package org.apz.curso.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.login", Usuario.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		return query.getSingleResult();
	}
}