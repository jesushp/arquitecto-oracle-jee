package org.apz.curso.ejb;

import javax.ejb.Stateless;

/**
 * Ejemplo de EJB de sesion sin estado
 */
@Stateless
public class HolaEJBImpl implements HolaEJB {

  	@Override
	public String mensaje(String nombre) {
		return "hola desde un ejb de session: " + nombre;
	}

}
