package org.apz.curso.ejb;

import java.util.List;

import javax.ejb.Local;

import org.apz.curso.model.Pedido;

@Local
public interface PedidoDao {
	
	void add(Pedido pedido);
	void update(Pedido pedido);
	void delete(int id);
	List<Pedido> findAll();
	Pedido findById(int id);
	

}
