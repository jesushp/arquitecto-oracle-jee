package org.apz.curso.bean;

import java.util.concurrent.Future;

import javax.ejb.Local;

@Local
public interface Calculo {
	
	Future<Integer> suma(int n) throws InterruptedException;
	
}
