EJB clase de mas alto nivel, se ejecutan en un contenedor de EJB incluido en un servidor de aplicaciones.

EJB 
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


 Tipos de EJB

 + Stateless EJB de sesion sin estado: - No guardan nada en memoria entre peticiones, reciben info y devuelven info sin guardar informacion. sirven a los clientes como una fachada de los servicios proporcionados
 + Statefull EJB de sesion con estado guarda datos para la siguiente llamada
 + Singleton EJB que crea una unica instacia 
 + MDB Message Driven Bean La llamada es asincrona utilizando JMS 
 
 + EJB de Entidad (Entity EJB): su objetivo es encapsular los objetos del lado del servidor que almacena los datos. Los EJB de entidad presentan la característica fundamental de la persistencia. A partir de  Java para JEE 5.0, los entity beans desaparecen, porque son remplazados por Java Persistence API o JPA)1​
        
 + EJB de Sesión (Session EJB): gestionan el flujo de la información en el servidor. Generalmente sirven a los clientes como una fachada de los servicios proporcionados por otros componentes disponibles en el servidor. Puede haber dos tipos:
        Con estado (stateful): en un bean de sesión con estado, las variables de instancia del bean almacenan datos específicos obtenidos durante la conexión con el cliente. Cada bean de sesión con estado, por tanto, almacena el estado conversacional de un cliente que interactúa con el bean. Este estado conversacional se modifica conforme el cliente va realizando llamadas a los métodos de negocio del bean. El estado conversacional no se guarda cuando el cliente termina la sesión.
        Sin estado (stateless): los beans de sesión sin estado son objetos distribuidos que carecen de estado asociado permitiendo por tanto que se los acceda concurrentemente. No se garantiza que los contenidos de las variables de instancia se conserven entre llamadas al método.
 + EJB Dirigidos por Mensajes (Message-driven EJB): son los únicos beans con funcionamiento asíncrono. Usando el Java Messaging System (JMS), se suscriben a un tema (topic) o a una cola (queue) y se activan al recibir un mensaje dirigido a dicho tema o cola. No requieren de su instanciación por parte del cliente.


Wildfly

server.xml > standalone.xml


Un EJB consta de un interfaz de negocio y una clase

Servlet -> EJB 
