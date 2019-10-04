package org.apz.curso.dao;

import java.util.List;

import javax.ejb.Local;

import org.apz.curso.model.Contacto;

@Local
public interface ContactoDao {
	
	//void altaContacto();
	void altaContacto(Contacto contacto);
	List<Contacto> recuperarContactos();
	void eliminarContacto(int id);
	
}
