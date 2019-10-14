package org.apz.curso.dao.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the libros database table.
 * 
 */
@Entity
@Table(name="libros")
@NamedQueries({
	@NamedQuery(name="Libro.findAll", query="SELECT l FROM Libro l"),
	@NamedQuery(name="Libro.findByTema", query="SELECT l FROM Libro l where l.tema.idTema = :idTema"),
})
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String isbn;

	private String autor;

	private int paginas;

	private double precio;

	private String titulo;
	
	@OneToMany(mappedBy="libro")
	private List<Venta> ventas;
	

	@ManyToOne
	@JoinColumn(name="idTema")
	private Tema tema;

	public Libro() {
	}
	
	
	
	public Libro(String isbn) {
		super();
		this.isbn = isbn;
	}



	public Libro(String isbn, String autor, int paginas, double precio, String titulo, Tema tema) {
		super();
		this.isbn = isbn;
		this.autor = autor;
		this.paginas = paginas;
		this.precio = precio;
		this.titulo = titulo;
		this.tema = tema;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPaginas() {
		return this.paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Tema getTema() {
		return this.tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}



	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", autor=" + autor + ", paginas=" + paginas + ", precio=" + precio + ", titulo="
				+ titulo + ", tema=" + tema.getTema() + "]";
	}
	
	
	
}