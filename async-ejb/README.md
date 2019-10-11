### Concurrencia JavaEE: EJB Asincronos

Los EJB permiten realizar peticiones de forma asíncrona con la notación @Asynchronous. Estos EJB que se ejecutan en otro **thread** de la llamada, y asi el thread principal puede ejecutar otras tareas, se suele utilizar con ejecuciones que tardan mucho.

Hay dos formas de invocar metodos asincronos dependiendo de cómo esperemos la resupuesta:

 * **Fire-and-forget** sin respuesta

 * **Retrieve-result-later** utilizando como respuesta la clase java.util.concurrent.**Future<V>**


La clase Thread que nos permite ejecutar tareas **concurrentes**

Más info

 * [Java Concurrency](https://docs.oracle.com/javase/7/docs/technotes/guides/concurrency/index.html)
 * [Concurrency Utilities for Java EE JSR 236](http://jcp.org/en/jsr/detail?id=236)
 * [Java EE 7 Tutorial - Concurrency](https://docs.oracle.com/javaee/7/tutorial/doc/concurrency-utilities.htm#GKJIQ8)