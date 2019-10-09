package org.apz.curso.ejb;

import java.util.List;

import javax.ejb.Local;

import org.apz.curso.model.Venta;

@Local
public interface VentasDao {
	
	List<Venta> listByCliente(int idCliente);
	List<Venta> listAll();
	
	void add(Venta venta);
	
}

