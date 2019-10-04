package org.apz.curso.ejb;

import java.util.List;

import javax.ejb.Local;

import org.apz.curso.model.Seccion;

@Local
public interface SeccionDao {
	
	void add(Seccion seccion);
	void delete(int id);
	List<Seccion> findAll();
	Seccion findById(int id);
	

}
