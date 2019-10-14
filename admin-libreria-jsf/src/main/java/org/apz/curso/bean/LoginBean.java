package org.apz.curso.bean;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apz.curso.dao.model.Usuario;
import org.apz.curso.service.UsuarioService;

/**
 * EL ambito predefinido es requestScope
 */
@ManagedBean
@RequestScoped
public class LoginBean extends PageBean {
	
	private static final Logger logger = Logger.getLogger("org.apz.curso.bean.LoginBean");
	
	private static final long serialVersionUID = -8348842460825218388L;
	
	private String email;
	private String password;
	

	@Inject
	UsuarioService usuarioService;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LoginBean() {
		super();
		title = "Login admin";
	}
	
	/**
	 * Implementacion de la validacion
	 * @param email
	 * @param password
	 * @return
	 */
	public String login(String email, String password) {
		
		try {
			Usuario usuario = usuarioService.getUsuario(email, password);
			if (usuario != null) {
				
				//Añadir a la sesion el usuario logado
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ususario", usuario);
				
				
				logger.info(usuario.toString());
				return "clientes/clientes";
			}
			else {
				this.error = "El usuario o la contraseña no son correctos";
				return "login";
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error {0}", e.getMessage());
			this.error = e.getMessage();
			return "login";
		}
		
		
	}
	
}

