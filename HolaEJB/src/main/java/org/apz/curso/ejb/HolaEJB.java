package org.apz.curso.ejb;

import javax.ejb.Local;

@Local
public interface HolaEJB {
	
	String mensaje(String nombre);
	
}
