package org.apz.curso.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sucursales database table.
 * 
 */
@Entity
@Table(name="sucursales")
@NamedQuery(name="Sucursal.findAll", query="SELECT s FROM Sucursal s")
public class Sucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SucursalPK id;

	private int innauguracion;

	private double presupuesto;

	public Sucursal() {
	}

	public SucursalPK getId() {
		return this.id;
	}

	public void setId(SucursalPK id) {
		this.id = id;
	}

	public int getInnauguracion() {
		return this.innauguracion;
	}

	public void setInnauguracion(int innauguracion) {
		this.innauguracion = innauguracion;
	}

	public double getPresupuesto() {
		return this.presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

}