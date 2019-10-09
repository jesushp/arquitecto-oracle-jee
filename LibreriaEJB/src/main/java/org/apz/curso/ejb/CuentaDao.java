package org.apz.curso.ejb;

import java.util.List;

import javax.ejb.Local;

import org.apz.curso.model.Cuenta;

@Local
public interface CuentaDao {
	
	void add(Cuenta cliente);
	void delete(int id);
	void update(Cuenta cliente);
	List<Cuenta> findAll();
	Cuenta findById(int id);
	List<Cuenta> findByCliente(String dni);
	
}
