# JNDI Java Naming and Directory Interface

Libreria (*javax.naming*) para para servicios de directorio. Permite a los clientes descubrir y buscar objetos y datos a través de un nombre. JNDI organiza sus nombres en una jerarquía. Un nombre se asocia a un objeto en el directorio almacenando el objeto o una referencia JNDI al objeto en el servicio de directorio identificado por el nombre.

La API JNDI define un **contexto** que especifica donde buscar un objeto. El contexto inicial es análogo a la raíz de un árbol de directorios para un sistema de ficheros. 


	Context ctx = new InitialContext();
	
	HolaEJB holaLocal  =(HolaEJB)ctx.lookup("java:global/HolaMundoEJB/Hola!org.apz.curso.ejb.HolaLocal");
	

Existen 3 namespaces que todos los servidores JEE deben soportar.	

 * **java:global**  para acceder a los EJBs de forma remota:

	java:global[/nombreAplicacion]/nombreModulo/nombreEJB/nombreInterface

 * **java:module** : para acceder a los ejbs que se encuentren en el mismo módulo

	java:module/nombreEJB/nombreInterface

 * **java:app** : EJBs que se encuentran ubicados en la misma aplicación pero en distinto módulo

	java:app/nombreModulo/nombreEJB/nombreInterface 

# Enterprise Java Bean EJB

EJB 3.x la nueva especificación de EJB simplifica el proceso de creación de EJB y facilita la implementación de la persistencia de una nueva manera por medio de la API JPA. 

EJB clase de mas alto nivel, se ejecutan en un contenedor de EJB incluido en un servidor de aplicaciones.

 + Pool de instancias, parecido a un pool de conexiones de BBDD
 + Patron de factorias implicitamente
 + IoD 
 + GEstion de transacciones TX
 + varios tipos de EJB
 + Comunicación remota utilizando CORBA.
 + JMS
 + Capa de persistencia JPA

EJB 3x Es una respuesta de Oracle a Sprint que le ha comido el mercado. Wildfly con soporte de RedHat es un servidor de aplicaciones.  Constituye la capa de negocio.

EJB es un equivalente a Core sirve para encapsular la logica de negocio.

 Al pedir una instancia procede de un pool de instancias


##### Tipos de EJB

Un EJB consta de un interfaz de negocio y una clase

 + **Entity EJB**: su objetivo es encapsular los objetos del lado del servidor que almacena los datos. Los EJB de entidad presentan la característica fundamental de la persistencia. A partir de  Java para JEE 5.0, los entity beans desaparecen, porque son remplazados por JPA.
        
 + **EJB de Sesión**: gestionan el flujo de la información en el servidor. Generalmente sirven a los clientes como una fachada de los servicios proporcionados por otros componentes disponibles en el servidor. Puede haber dos tipos:
      
   * **stateful**: en un bean de sesión con estado, las variables de instancia del bean almacenan datos específicos obtenidos durante la conexión con el cliente. Cada bean de sesión con estado, por tanto, almacena el estado conversacional de un cliente que interactúa con el bean. Este estado conversacional se modifica conforme el cliente va realizando llamadas a los métodos de negocio del bean. El estado conversacional no se guarda cuando el cliente termina la sesión.
   
   * **stateless**: los beans de sesión sin estado son objetos distribuidos que carecen de estado asociado permitiendo por tanto que se los acceda concurrentemente. No se garantiza que los contenidos de las variables de instancia se conserven entre llamadas al método.
 
 + **Message-driven EJB** beans con funcionamiento asíncrono. Usando el Java Messaging System (JMS), se suscriben a un tema (**topic**) o a una cola (**queue**) y se activan al recibir un mensaje dirigido a dicho tema o cola. No requieren de su instanciación por parte del cliente.

 + **Singleton EJB** EJB que crea una unica instacia 

