package org.apz.curso.ejb;

import javax.ejb.Local;

@Local
public interface HolaLocal {
	
	String mensaje(String nombre);
	
}
