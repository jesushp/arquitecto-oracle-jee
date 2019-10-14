package org.apz.curso.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apz.curso.dao.UsuarioDao;
import org.apz.curso.dao.model.Usuario;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {
	
	@Inject
	UsuarioDao usuarioDao;
	
	@Override
	public Usuario getUsuario(String email, String password) throws Exception {
		return usuarioDao.getUsuario(email, password);
	}
}