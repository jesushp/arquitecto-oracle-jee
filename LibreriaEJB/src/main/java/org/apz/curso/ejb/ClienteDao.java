package org.apz.curso.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import org.apz.curso.model.Cliente;

@Local
public interface ClienteDao {
	
	void add(Cliente cliente);
	void delete(int id);
	void update(Cliente cliente);
	List<Cliente> findAll();
	Cliente findById(int id);
	List<Cliente> listByCuenta(int numeroCuenta);
	
	Cliente loginCliente(String email, String password) throws Exception;
	
	/** clientes qye han hecho alguna operacion en el dia indicado */
	List<Cliente> listByFechaMovimiento(Date fechaMovimiento);
	
}