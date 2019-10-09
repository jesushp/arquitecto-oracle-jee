### Mensajeria con EJB - MDB

En el servidor de aplicaciones hay que configurar dos elementos, **JMS Connection Factory** y el destination **Cola** o **Topic** 

Configuracion en el **standalone-full** de wildFly:

	<!-- configuracion del objeto destination (Cola de mensajeria) -->
	<jms-queue name="TestQueue" entries="java:/jms/TestQueue"/>
	<!-- configuracion de la connection factory (Productor mensajeria) -->
	<connection-factory name="TestFactory" entries="java:/jms/TestFactory" connectors="in-vm"/>

Recurso que hay que llamar vía JNDI (Service Locator) desde los EJB


+ INFO:

 * [Using JMS with EJBs and Servlets](https://docs.oracle.com/cd/E13222_01/wls/docs81/jms/j2ee_components.html)

 * [A Guide to Message Driven Beans in EJB](https://www.baeldung.com/ejb-message-driven-beans)

