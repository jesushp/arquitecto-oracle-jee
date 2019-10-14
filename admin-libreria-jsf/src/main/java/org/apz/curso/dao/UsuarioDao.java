package org.apz.curso.dao;

import javax.ejb.Local;

import org.apz.curso.dao.model.Usuario;

@Local
public interface UsuarioDao {
	
	Usuario getUsuario(String email, String password) throws Exception;

}
