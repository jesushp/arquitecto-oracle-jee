package org.apz.curso.ejb;

import java.util.List;

import javax.ejb.Local;

import org.apz.curso.model.Tema;

@Local
public interface TemaDao {
	
	void add(Tema seccion);
	void delete(int id);
	List<Tema> findAll();
	Tema findById(int id);
	Tema findByLibro(String titulo);
	

}
