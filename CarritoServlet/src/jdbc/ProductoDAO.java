package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Producto;

public class ProductoDAO extends ConnectionSingleton{
	
	{
		System.out.println("esto es un bloque inicial se tiene que llamar siempre que se instacia ProductoDAO");
	}
	
	
	
	public ProductoDAO() {
		super();
	}
	
	public void insertProducto(Producto producto) throws Exception {
		
		if (producto!=null) {
			
			try (Statement sentencia = conn.createStatement()) {
				String query = "insert into producto (nombre, unidades, precio) values ('"+producto.getNombre()+"',"+producto.getUnidades()+","+producto.getPrecio()+")";
				System.out.println(query);
				sentencia.execute(query);
			}
		}
	}


	public List<Producto> getProductos() throws Exception {
		
		//Nos conectamos a la BD local
		try (Statement sentencia=conn.createStatement();
			 ResultSet rs = sentencia.executeQuery("SELECT * FROM producto")){

			Stream<Producto> productos = getStream(rs);
				 
			return productos.collect(Collectors.toList());
				 
		}
		
	}


	private Stream<Producto> getStream(ResultSet rs) throws SQLException {
		Stream.Builder<Producto> productos = Stream.builder();
	    while (rs.next()) {
	    	Producto producto = new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getInt("unidades"), rs.getInt("precio"));
	    	productos.add(producto);
	    }
	    return productos.build();
	}	
	
	
	
}
