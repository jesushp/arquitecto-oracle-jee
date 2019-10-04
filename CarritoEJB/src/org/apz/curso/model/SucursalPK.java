package org.apz.curso.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the sucursales database table.
 * 
 */
@Embeddable
public class SucursalPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String nombre;

	private String calle;

	public SucursalPK() {
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCalle() {
		return this.calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SucursalPK)) {
			return false;
		}
		SucursalPK castOther = (SucursalPK)other;
		return 
			this.nombre.equals(castOther.nombre)
			&& this.calle.equals(castOther.calle);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.nombre.hashCode();
		hash = hash * prime + this.calle.hashCode();
		
		return hash;
	}
}