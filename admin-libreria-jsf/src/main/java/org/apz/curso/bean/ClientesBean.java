package org.apz.curso.bean;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.apz.curso.dao.model.Cliente;
import org.apz.curso.service.ClienteService;

@ManagedBean
@RequestScoped
public class ClientesBean extends PageBean {
	
	private static final long serialVersionUID = -6926915773702967003L;

	private static final Logger logger = Logger.getLogger("org.apz.curso.bean.ClientesBean");
	
	private Cliente cliente;
	
	public ClientesBean() {
		super();
		title = "Admin: Clientes";
	}
	
	@Inject
	ClienteService clienteService;

	public List<Cliente> getClientes() {
		return clienteService.findAll();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public void add() {
		logger.info(cliente.toString());
	}
	
	public String form() {
		cliente = new Cliente();
		return "clientes/form-clientes";
	}
	
	
	
	
	
	
}
