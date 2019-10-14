package org.apz.curso.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the ventas database table.
 * 
 */
@Entity
@Table(name="ventas")
@NamedQuery(name="Venta.findAll", query="SELECT v FROM Venta v ORDER BY v.fecha desc")
public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idVEnta;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	
	//bi-directional many-to-one association to Libro
	@ManyToOne 
	@JoinColumn(name="idCliente")
	private Cliente cliente;

	
	@ManyToOne
	@JoinColumn(name="isbn")
	private Libro libro;

	public Venta() {
	}
	
	public Venta(Date fecha, Cliente cliente, Libro libro) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.libro = libro;
	}

	
	public Venta(int idVEnta, Date fecha, Cliente cliente, Libro libro) {
		super();
		this.idVEnta = idVEnta;
		this.fecha = fecha;
		this.cliente = cliente;
		this.libro = libro;
	}



	public int getIdVEnta() {
		return this.idVEnta;
	}

	public void setIdVEnta(int idVEnta) {
		this.idVEnta = idVEnta;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "Venta [idVEnta=" + idVEnta + ", fecha=" + fecha + "]";
	}

	

}