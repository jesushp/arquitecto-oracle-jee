package org.apz.curso.dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Usuario.login", query="SELECT u FROM Usuario u where u.email = :email and u.password = :password"),
	@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int edad;

	private String email;

	private String nombre;

	private String password;

	public Usuario() {
	}

	public Usuario(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public Usuario(int id, int edad, String email, String nombre, String password) {
		super();
		this.id = id;
		this.edad = edad;
		this.email = email;
		this.nombre = nombre;
		this.password = password;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", edad=" + edad + ", email=" + email + ", nombre=" + nombre + "]";
	}
	
	
	
}