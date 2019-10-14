package org.apz.curso.service;

import javax.ejb.Local;

import org.apz.curso.dao.model.Usuario;

@Local
public interface UsuarioService {
	
	Usuario getUsuario(String email, String password) throws Exception;

}
