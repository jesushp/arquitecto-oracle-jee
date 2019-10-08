package org.apz.curso.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ofertas database table.
 * 
 */
@Entity
@Table(name="ofertas")
@NamedQuery(name="Oferta.findAll", query="SELECT o FROM Oferta o")
public class Oferta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idOferta;

	private String texto;

	public Oferta() {
	}

	public int getIdOferta() {
		return this.idOferta;
	}

	public void setIdOferta(int idOferta) {
		this.idOferta = idOferta;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}