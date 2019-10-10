package org.apz.curso.bean;

import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 * Con la llamada a Thread.sleep se simula un ejecucion pesada*
 */
@Stateless
public class CalculoImpl implements Calculo {

	@Asynchronous
  	@Override
	public Future<Integer> suma(int n) throws InterruptedException {
		int res = 0;
		for (int i = 0; i <=n ; i++) {
			res += i;
			Thread.sleep(100);
			
		}
		return new AsyncResult<>(res);
	}

}
