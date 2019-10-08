package org.apz.curso.ejb;

import java.util.List;

import javax.ejb.Local;

import org.apz.curso.model.Libro;

@Local
public interface LibroDao {
	
	void add(Libro libro);
	void delete(String isbn);
	void update(Libro libro);
	List<Libro> findAll();
	Libro findById(String isbn);
	List<Libro> findByTema(int idTema);
	

}
