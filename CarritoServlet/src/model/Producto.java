package model;

public class Producto {
	
	
	public Producto(String nombre, int unidades, int precio) {
		super();
		this.nombre = nombre;
		this.unidades = unidades;
		this.precio = precio;
	}
	
	public Producto(int id, String nombre, int unidades, int precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.unidades = unidades;
		this.precio = precio;
	}
	
	private int id;
	private String nombre;
	private int unidades;
	private int precio;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
