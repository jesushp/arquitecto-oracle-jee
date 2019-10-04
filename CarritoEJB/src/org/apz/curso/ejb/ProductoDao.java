package org.apz.curso.ejb;

import java.util.List;

import javax.ejb.Local;

import org.apz.curso.model.Producto;

@Local
public interface ProductoDao {
	
	void add(Producto producto);
	void delete(int id);
	List<Producto> findAll();
	Producto findById(int id);
	

}
