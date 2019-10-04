package org.apz.curso.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contactos database table.
 * 
 */
@Entity
@Table(name="contactos")
public class Contacto implements Serializable {
	
	private static final long serialVersionUID = -3522702665529102052L;
	
	public Contacto(int idContacto,  String nombre, String email, int edad ) {
		super();
		this.idContacto = idContacto;
		this.edad = edad;
		this.email = email;
		this.nombre = nombre;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idContacto;

	private int edad;

	private String email;

	private String nombre;

	public Contacto() {
	}

	public int getIdContacto() {
		return this.idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}