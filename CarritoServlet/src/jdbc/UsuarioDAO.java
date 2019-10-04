package jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Usuario;

public class UsuarioDAO extends ConnectionSingleton {
	
	public UsuarioDAO() {
		super();
	}
	
	private static String FIND_BY_ID ="SELECT * FROM usuario where nombre= ?";
	private static String FIND_ALL ="SELECT * FROM usuario";
	private static String INSERT = "insert into usuario (nombre, password, email, edad) values (?,?,?)";
	
	
	/**
	 * Utilizando Statement
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public Usuario getUsuarioRS(Usuario usuario) throws Exception {
		
		try(Statement sentencia = conn.createStatement();
			ResultSet resultados=sentencia.executeQuery("SELECT * FROM usuario where nombre='"+usuario.getNombre()+"'")) {
		
			Stream<Usuario> usuarios = getStream(resultados);
		
			return usuarios.filter(u -> u.getPassword().equals(usuario.getPassword()))
						.findFirst().orElseThrow(() -> new Exception("Este usuario no es valido"));
		}
		
	}
	
	/**
	 * Utilizando PreparedStatement
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public Usuario getUsuario(Usuario usuario) throws Exception {
		
		try (PreparedStatement ps = conn.prepareStatement(FIND_BY_ID)){
			ps.setString(1, usuario.getNombre());
			
			try (ResultSet resultados = ps.executeQuery()) {
			
				Stream<Usuario> usuarios = getStream(resultados);
			
				return usuarios.filter(u -> u.getPassword().equals(usuario.getPassword()))
							.findFirst().orElseThrow(() -> new Exception("Este usuario no es valido"));
			}
		}
		
	}
	
	
	
	public void insertUSuario(Usuario usuario) throws Exception {
		
		try (PreparedStatement ps = conn.prepareStatement(INSERT)) {
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getPassword());
			ps.setString(3, usuario.getEmail());
			ps.setInt(4, usuario.getEdad());
			
			ps.executeQuery();
		}
		
	}
	
	public List<Usuario> getUsuarios() throws Exception {
		
		//Nos conectamos a la BD local
		try (Statement sentencia=conn.createStatement();
			 ResultSet rs = sentencia.executeQuery(FIND_ALL)){

			Stream<Usuario> usuarios = getStream(rs);
				 
			return usuarios.collect(Collectors.toList());
				 
		}
		
	}


	
	
    private static Stream<Usuario> getStream(ResultSet rs) throws SQLException {
        Stream.Builder<Usuario> usuarios = Stream.builder();
	    while (rs.next()) {
	      Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("password"), rs.getString("email"), rs.getInt("edad"));
	      usuarios.add(usuario);
	    }
	    return usuarios.build();
    }
	
}
