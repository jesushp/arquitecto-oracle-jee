package org.apz.curso.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apz.curso.dao.ClienteDao;
import org.apz.curso.dao.model.Cliente;

@Stateless
public class ClienteServiceImpl implements ClienteService {
	
	@Inject
	ClienteDao clienteDao;
	
	
	@Override
	public void add(Cliente cliente) {
		clienteDao.add(cliente);
	}

	@Override
	public void delete(int id) {
		clienteDao.delete(id);
	}

	@Override
	public List<Cliente> findAll() {
		return clienteDao.findAll();
	}

	@Override
	public Cliente findById(int id) {
		return clienteDao.findById(id);
	}
	
	@Override
	public void update(Cliente cliente) {
		clienteDao.update(cliente);
	}

	@Override
	public List<Cliente> listByCuenta(int numeroCuenta) {
		return clienteDao.listByCuenta(numeroCuenta);
	}

	@Override
	public List<Cliente> listByFechaMovimiento(Date fechaMovimiento) {
		return clienteDao.listByFechaMovimiento(fechaMovimiento);
	}

	@Override
	public Cliente loginCliente(String email, String password) throws Exception {
		return clienteDao.loginCliente(email, password);
	}
	
	
}
