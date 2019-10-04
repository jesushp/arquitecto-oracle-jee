package org.apz.curso.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Producto(int idProducto, String descripcion, Seccion seccion, String nombre, double precio) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.seccion = seccion;
		this.nombre = nombre;
		this.precio = precio;
	}

	@Id
	private int idProducto;

	private String descripcion;

	@ManyToOne
    @JoinColumn(name="idSeccion", nullable=false)
	private Seccion seccion;

	private String nombre;

	private double precio;

	public Producto() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}