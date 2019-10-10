### EJB Asincronos

Los EJB permiten realizar peticiones de forma asíncrona con la notación @Asynchronous. Estos EJB que se ejecutan en otro **thread** de la llamada, y asi el thread principal puede ejecutar otras tareas, se suele utilizar con ejecuciones que tardan mucho.

La clase Thread que nos permite ejecutar tareas **concurrentes**