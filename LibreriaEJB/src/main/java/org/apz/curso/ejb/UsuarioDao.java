package org.apz.curso.ejb;

import javax.ejb.Local;

import org.apz.curso.model.Usuario;

@Local
public interface UsuarioDao {
	
	Usuario getUsuario(String email, String password) throws Exception;

}
