package org.apz.curso.dao.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the cuentas database table.
 * 
 */
@Entity
@Table(name="cuentas")
@NamedQueries({
	@NamedQuery(name="Cuenta.findAll", query="SELECT c FROM Cuenta c"),
	@NamedQuery(name="Cuenta.listByCliente", query="SELECT c FROM Cuenta c join c.clientes cs where cs.dni = :dni"),
})
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int numeroCuenta;

	private double saldo;

	private String tipocuenta;

	//bi-directional many-to-one association to Movimiento
	@OneToMany(mappedBy="cuenta")
	private List<Movimiento> movimientos;

	//bi-directional many-to-many association to Cliente
	@ManyToMany(mappedBy="cuentas")
	private List<Cliente> clientes;

	public Cuenta() {
	}

	public int getNumeroCuenta() {
		return this.numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getTipocuenta() {
		return this.tipocuenta;
	}

	public void setTipocuenta(String tipocuenta) {
		this.tipocuenta = tipocuenta;
	}

	public List<Movimiento> getMovimientos() {
		return this.movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public Movimiento addMovimiento(Movimiento movimiento) {
		getMovimientos().add(movimiento);
		movimiento.setCuenta(this);

		return movimiento;
	}

	public Movimiento removeMovimiento(Movimiento movimiento) {
		getMovimientos().remove(movimiento);
		movimiento.setCuenta(null);

		return movimiento;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}