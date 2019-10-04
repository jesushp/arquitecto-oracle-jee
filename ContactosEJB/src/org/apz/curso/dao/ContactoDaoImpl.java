package org.apz.curso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import org.apz.curso.model.Contacto;

/**
 * Session Bean implementation class ContactoDaoImpl
 * Previamente se ha añadido el dataSource en el wilfly. Patron Service Locator
 * https://www.oracle.com/technetwork/java/servicelocator-137181.html 
 */
@Stateless
public class ContactoDaoImpl implements ContactoDao {

		@Resource(lookup = "java:comp/env/refagenda")
	    private DataSource dataSource;
		
		@Override
		public void altaContacto(Contacto contacto) {
		
			String sql="insert into contactos(nombre,email,edad) values(?,?,?)";
			try(Connection con = dataSource.getConnection();
				PreparedStatement prep=con.prepareStatement(sql)){	
				//asignamos valores a los parametros
				prep.setString(1,contacto.getNombre());
				prep.setString(2,contacto.getEmail());
				prep.setInt(3,contacto.getEdad());
				//ejecutamos
				prep.execute();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			
			
		}
		@Override
		public List<Contacto> recuperarContactos(){
			List<Contacto> contactos=new ArrayList<>();
			String sql="select * from contactos";
			try(Connection con = dataSource.getConnection();
					PreparedStatement prep=con.prepareStatement(sql);
					ResultSet rs=prep.executeQuery();){
				while(rs.next()) {
					contactos.add(new Contacto(rs.getInt("idContacto"),
							rs.getString("nombre"),
							rs.getString("email"),
							rs.getInt("edad")));
				}
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			return contactos;
		}
		
		@Override
		public void eliminarContacto(int id) {
			String sql="delete from contactos where idContacto=?";
			try(Connection con = dataSource.getConnection();
				PreparedStatement prep=con.prepareStatement(sql);){
					prep.setInt(1,id);
					prep.execute();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	

}
