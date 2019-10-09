package org.apz.curso.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
@NamedQueries({
		@NamedQuery(name="Cliente.login", query="SELECT u FROM Cliente u where u.email = :email and u.password = :password"),
		@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c"),
		@NamedQuery(name="Cliente.listByCuenta", query="SELECT c FROM Cliente c join c.cuentas t where t.numeroCuenta = :numeroCuenta"),
		@NamedQuery(name="Cliente.listByFechaMovimiento", query="SELECT c FROM Cliente c join c.cuentas t join t.movimientos m  where m.fecha = :fechaMovimiento")
})
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCliente;

	private String email;

	private String password;

	private int telefono;
	
	private String dni;
	
	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="cliente", fetch = FetchType.EAGER)
	private List<Venta> ventas;
	
	@ManyToMany
	@JoinTable(name = "titulares",
				joinColumns = @JoinColumn(name="dni",referencedColumnName = "dni"),
				inverseJoinColumns =@JoinColumn(name="idCuenta",referencedColumnName = "numeroCuenta"))
	private List<Cuenta> cuentas;
	
	public Cliente() {
	}
	
	
	
	public Cliente(int idCliente) {
		super();
		this.idCliente = idCliente;
	}
	
	
	
	public Cliente(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}



	public Cliente(int idCliente, String email, String password, int telefono, String dni) {
		super();
		this.idCliente = idCliente;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.dni = dni;
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}



	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", email=" + email + ", password=" + password + ", telefono="
				+ telefono + ", dni=" + dni + "]";
	}
	
	

}