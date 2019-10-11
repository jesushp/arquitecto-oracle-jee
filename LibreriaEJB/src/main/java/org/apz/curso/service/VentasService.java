package org.apz.curso.service;

import java.util.List;

import javax.ejb.Local;

import org.apz.curso.model.Venta;

@Local
public interface VentasService {
	
	/** insercion en venta por mensajeria */
	boolean procesarPedido(String isbn, int idCliente);
	
	/** acceso a BBDD **/
	List<Venta> listByCliente(int idCliente);
	List<Venta> listAll();
	Venta findById(int id);
	
}

