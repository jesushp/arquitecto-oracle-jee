package org.apz.curso.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Ejemplo de EJB de sesion sin estado
 */
@Stateless
@LocalBean
public class Hola implements HolaLocal {

  	@Override
	public String mensaje(String nombre) {
		return "hola desde un ejb de session: " + nombre;
	}

}
