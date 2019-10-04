package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * TODO: cuando se cierra
 *
 */
public class ConnectionSingleton {
	
	protected static Connection conn = null;
	
	public ConnectionSingleton() {
	}
	
	static {
		
	    String url = "jdbc:mysql://localhost:3306/curso1";
	    String driver = "com.mysql.cj.jdbc.Driver";
	    String usuario = "arturo";
	    String password = "popeye00";
	 
	    try {Class.forName(driver);
	    	 conn = DriverManager.getConnection(url, usuario, password);
	    	 System.out.println("inicializacion de la conexion");
	    }
	    catch(ClassNotFoundException | SQLException e){
	    	System.err.println(e.getMessage());
	    }
	}
	
	
	
}
