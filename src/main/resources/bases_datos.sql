-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema agenda
--

CREATE DATABASE IF NOT EXISTS agenda;
USE agenda;

--
-- Definition of table `contactos`
--

DROP TABLE IF EXISTS `contactos`;
CREATE TABLE `contactos` (
  `idContacto` int(10) unsigned NOT NULL auto_increment,
  `nombre` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`idContacto`)
) ENGINE=InnoDB AUTO_INCREMENT=496 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contactos`
--

/*!40000 ALTER TABLE `contactos` DISABLE KEYS */;
INSERT INTO `contactos` (`idContacto`,`nombre`,`email`,`telefono`) VALUES 
 (31,'contacto de prueba','prueba@Contacto.com',999999),
 (476,'Antonio Martín Sierra','aaaaaaa',333),
 (477,'con hibernate','chiber@gmail.com',9999),
 (483,'spring','spring@gmail.com',7777),
 (487,'hiber','hiber',33),
 (494,'contracto ejemplo','ejemplo@gmail.com',4444),
 (495,'mvc','dd',22);
/*!40000 ALTER TABLE `contactos` ENABLE KEYS */;

--
-- Create schema agenda2
--

CREATE DATABASE IF NOT EXISTS agenda2;
USE agenda2;

--
-- Definition of table `contactos`
--

DROP TABLE IF EXISTS `contactos`;
CREATE TABLE `contactos` (
  `idContacto` int(10) unsigned NOT NULL auto_increment,
  `nombre` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `edad` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`idContacto`)
) ENGINE=InnoDB AUTO_INCREMENT=502 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contactos`
--

/*!40000 ALTER TABLE `contactos` DISABLE KEYS */;
INSERT INTO `contactos` (`idContacto`,`nombre`,`email`,`edad`) VALUES 
 (31,'contacto de prueba','prueba@Contacto.com',999999),
 (476,'Antonio Martín Sierra','aaaaaaa',333),
 (477,'con hibernate','chiber@gmail.com',9999),
 (483,'spring','spring@gmail.com',7777),
 (487,'hiber','hiber',33),
 (488,'contact A','aa@gmail.com',3333),
 (489,'post cliente jersey','jersey@gmail.com',66),
 (490,'post cliente jersey','jersey@gmail.com',66),
 (493,'cliente easy','easy@gmail.com',99),
 (494,'RestFly','restfly@gmail.com',200),
 (495,'android','aaa@gmail.com',10),
 (496,'android','aaa@gmail.com',10),
 (498,'android33','aaa@gmail.com',10),
 (499,'android33','aaa@gmail.com',10),
 (500,'android33','aaa@gmail.com',10),
 (501,'curso android neoris','curso@gmail.com',55);
/*!40000 ALTER TABLE `contactos` ENABLE KEYS */;

--
-- Create schema almacen
--

CREATE DATABASE IF NOT EXISTS almacen;
USE almacen;

--
-- Definition of table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
CREATE TABLE `pedidos` (
  `idPedido` int(10) unsigned NOT NULL auto_increment,
  `producto` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `categoria` varchar(45) NOT NULL,
  PRIMARY KEY  (`idPedido`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pedidos`
--

/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` (`idPedido`,`producto`,`precio`,`categoria`) VALUES 
 (2,'bicicleta',200,'deporte'),
 (4,'libro java',20,'programación'),
 (5,'libro java 11',25,'programación'),
 (6,'libro aaaaaa',34,'programación');
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;


--
-- Definition of table `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE `productos` (
  `idProducto` int(10) unsigned NOT NULL auto_increment,
  `nombre` varchar(45) NOT NULL,
  `idSeccion` int(10) unsigned NOT NULL,
  `precio` double NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY  (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productos`
--

/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` (`idProducto`,`nombre`,`idSeccion`,`precio`,`descripcion`) VALUES 
 (1,'Alicates 25m',1,10.4,'Disponibles en 10 dias'),
 (2,'Bombilla led 30w',3,5.7,'duración 10 años'),
 (3,'cable cobre 10mm',3,2,'flexible y resistente'),
 (4,'Tubo de cobre',2,3.6,'precio por metro'),
 (5,'Grifo gres',2,27.5,'Alta resistencia'),
 (6,'Taladradora 1000w',3,40.6,'Sistema silencioso'),
 (7,'Bote pintura blanca 10 l',4,25.8,'Doble capa'),
 (8,'Cerradura verja 30 mm',1,37.9,'Universal para exterior'),
 (9,'Candado 25 mm amarillo',1,13.5,'Llave incluida'),
 (10,'Interruptor doble',3,22.4,'Solo color blanco'),
 (11,'Rodillo pintura 25 cm',4,14.9,'se lava facilmente'),
 (12,'Bombilla led 10w luz blanca',3,4.8,'Gran potencia');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;


--
-- Definition of table `secciones`
--

DROP TABLE IF EXISTS `secciones`;
CREATE TABLE `secciones` (
  `idSeccion` int(10) unsigned NOT NULL auto_increment,
  `seccion` varchar(45) NOT NULL,
  `responsable` varchar(45) NOT NULL,
  PRIMARY KEY  (`idSeccion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `secciones`
--

/*!40000 ALTER TABLE `secciones` DISABLE KEYS */;
INSERT INTO `secciones` (`idSeccion`,`seccion`,`responsable`) VALUES 
 (1,'ferreteria','Juan López'),
 (2,'fontaneria','Ana Marcos'),
 (3,'electricidad','Ruth Esteban'),
 (4,'pintura','Pedro Ramos');
/*!40000 ALTER TABLE `secciones` ENABLE KEYS */;


--
-- Definition of table `sucursales`
--

DROP TABLE IF EXISTS `sucursales`;
CREATE TABLE `sucursales` (
  `nombre` varchar(45) NOT NULL,
  `calle` varchar(45) NOT NULL,
  `presupuesto` double NOT NULL,
  `innauguracion` int(11) NOT NULL,
  PRIMARY KEY  (`nombre`,`calle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sucursales`
--

/*!40000 ALTER TABLE `sucursales` DISABLE KEYS */;
INSERT INTO `sucursales` (`nombre`,`calle`,`presupuesto`,`innauguracion`) VALUES 
 ('bazar em','c/los altos',450000,2012),
 ('nueva era','c/povedilla',50000,2010),
 ('venta chin','c/povedilla',3000000,2009);
/*!40000 ALTER TABLE `sucursales` ENABLE KEYS */;


--
-- Definition of table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
CREATE TABLE `ventas` (
  `idVenta` int(10) unsigned NOT NULL auto_increment,
  `idProducto` int(10) unsigned NOT NULL,
  `unidades` int(10) unsigned NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  PRIMARY KEY  (`idVenta`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ventas`
--

/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` (`idVenta`,`idProducto`,`unidades`,`ciudad`) VALUES 
 (1,1,3,'Madrid'),
 (2,3,2,'Madrid'),
 (3,1,5,'Sevilla'),
 (4,10,4,'Avila'),
 (5,3,2,'Jaen'),
 (6,5,7,'Madrid'),
 (7,4,2,'Sevilla'),
 (8,10,3,'Salamanca'),
 (9,7,8,'Albacete'),
 (10,4,3,'Soria');
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;

--
-- Create schema bancabd
--

CREATE DATABASE IF NOT EXISTS bancabd;
USE bancabd;

--
-- Definition of table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `dni` int(10) unsigned NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clientes`
--

/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`dni`,`nombre`,`direccion`,`telefono`) VALUES 
 (1111,'Pepito','c/marte',1111),
 (2222,'Alicia','c/ jupiter',2222),
 (3333,'Marta','c/venus',3333),
 (7777,'aaaaa','bbbb',1111),
 (9898,'aaaaa','aaaa',1111),
 (11117777,'aaaaa','bbbb',1111);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;


--
-- Definition of table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
CREATE TABLE `cuentas` (
  `numeroCuenta` int(10) unsigned NOT NULL,
  `saldo` double NOT NULL,
  `tipocuenta` varchar(45) NOT NULL,
  PRIMARY KEY  (`numeroCuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cuentas`
--

/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
INSERT INTO `cuentas` (`numeroCuenta`,`saldo`,`tipocuenta`) VALUES 
 (1000,44111,'ahorro'),
 (1234,70,'prueba2'),
 (2000,9000,'ahorro'),
 (3000,670,'recibos'),
 (4000,880,'ahorro'),
 (5000,6700,'recibos');
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;


--
-- Definition of table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
CREATE TABLE `movimientos` (
  `idMovimiento` int(10) unsigned NOT NULL auto_increment,
  `idCuenta` int(10) unsigned NOT NULL,
  `fecha` datetime default NULL,
  `cantidad` double NOT NULL,
  `operacion` varchar(45) NOT NULL,
  PRIMARY KEY  (`idMovimiento`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movimientos`
--

/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
INSERT INTO `movimientos` (`idMovimiento`,`idCuenta`,`fecha`,`cantidad`,`operacion`) VALUES 
 (25,1000,'2019-03-31 11:41:08',200,'extracción'),
 (26,1000,'2019-03-31 12:44:17',500,'ingreso'),
 (27,2000,'2019-03-31 12:44:57',300,'extracción'),
 (28,1000,'2019-03-31 12:44:57',300,'ingreso'),
 (29,2000,'2019-03-31 12:45:10',2000,'ingreso'),
 (30,1000,'2019-03-31 18:56:59',35,'ingreso'),
 (31,1000,'2019-03-31 19:06:41',200,'extracción'),
 (32,1000,'2019-03-31 19:07:01',1000,'ingreso'),
 (33,1000,'2019-03-31 19:08:17',500,'extracción'),
 (34,1000,'2019-03-31 19:13:46',5,'ingreso'),
 (35,1000,'2019-04-04 22:28:56',23,'ingreso'),
 (36,1000,'2019-04-04 22:29:06',34,'extracción'),
 (37,1000,'2019-04-04 22:30:43',11,'extracción'),
 (38,1000,'2019-04-04 22:31:39',11,'extracción'),
 (39,1000,'2019-06-26 20:17:31',300,'extracción'),
 (40,1000,'2019-06-27 15:58:59',50000,'extracción'),
 (41,2000,'2019-06-27 15:58:59',50000,'ingreso'),
 (42,1000,'2019-06-27 16:02:56',3000,'extracción'),
 (43,2000,'2019-06-27 16:02:56',3000,'ingreso'),
 (44,1000,'2019-06-27 16:05:05',2000,'extracción'),
 (45,2000,'2019-06-27 16:05:05',2000,'ingreso'),
 (46,1000,'2019-06-27 16:08:29',2000,'extracción'),
 (47,2000,'2019-06-27 16:08:29',2000,'ingreso'),
 (48,1000,'2019-06-27 16:37:48',1111,'extracción');
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;


--
-- Definition of table `titulares`
--

DROP TABLE IF EXISTS `titulares`;
CREATE TABLE `titulares` (
  `idCuenta` int(10) unsigned NOT NULL,
  `idCliente` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`idCuenta`,`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `titulares`
--

/*!40000 ALTER TABLE `titulares` DISABLE KEYS */;
INSERT INTO `titulares` (`idCuenta`,`idCliente`) VALUES 
 (1000,3333),
 (1000,7777),
 (1000,11117777),
 (2000,1111),
 (2000,3333),
 (3000,1111),
 (4000,2222),
 (5000,9898);
/*!40000 ALTER TABLE `titulares` ENABLE KEYS */;

--
-- Create schema bolsa
--

CREATE DATABASE IF NOT EXISTS bolsa;
USE bolsa;

--
-- Definition of table `acciones`
--

DROP TABLE IF EXISTS `acciones`;
CREATE TABLE `acciones` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `company` varchar(45) NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `acciones`
--

/*!40000 ALTER TABLE `acciones` DISABLE KEYS */;
INSERT INTO `acciones` (`id`,`company`,`valor`) VALUES 
 (1,'Oracle',9),
 (2,'Ibm',7),
 (3,'Apple',1.8);
/*!40000 ALTER TABLE `acciones` ENABLE KEYS */;

--
-- Create schema comercial
--

CREATE DATABASE IF NOT EXISTS comercial;
USE comercial;

--
-- Definition of table `tiendas`
--

DROP TABLE IF EXISTS `tiendas`;
CREATE TABLE `tiendas` (
  `idTienda` int(10) unsigned NOT NULL auto_increment,
  `nombre` varchar(45) NOT NULL,
  `latitud` int(10) unsigned NOT NULL,
  `longitud` int(10) unsigned NOT NULL,
  `telefono` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`idTienda`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tiendas`
--

/*!40000 ALTER TABLE `tiendas` DISABLE KEYS */;
INSERT INTO `tiendas` (`idTienda`,`nombre`,`latitud`,`longitud`,`telefono`) VALUES 
 (1,'iluminación zz',42,0,939494),
 (2,'repuestos lópez',40,3,11221),
 (3,'papeleria expreso',37,5,45677),
 (4,'libros arca',39,2,77272);
/*!40000 ALTER TABLE `tiendas` ENABLE KEYS */;

--
-- Create schema escuela
--

CREATE DATABASE IF NOT EXISTS escuela;
USE escuela;

--
-- Definition of table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
CREATE TABLE `alumnos` (
  `dni` int(10) unsigned NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `email` varchar(80) NOT NULL,
  `edad` int(10) unsigned NOT NULL,
  `idCurso` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alumnos`
--

/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` (`dni`,`nombre`,`email`,`edad`,`idCurso`) VALUES 
 (100000,'Marcos','marcos@gmail.com',25,1),
 (200000,'Ana','ana@gmail.com',23,3),
 (300000,'Maria','maria@gmail.com',29,1),
 (400000,'Gema','gema@hotmail.com',40,2),
 (500000,'Marta','marta@gmail.com',26,2),
 (600000,'Angel','angel@hotmail.com',39,1),
 (700000,'Luis','luis@gmail.com',45,4),
 (800000,'Miguel','miguel@gmail.com',47,4),
 (900000,'Sergio','sergio@gmail.com',42,4),
 (1000000,'Lucas','lucas@gmail.com',28,1);
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;


--
-- Definition of table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
CREATE TABLE `cursos` (
  `idCurso` int(10) unsigned NOT NULL auto_increment,
  `denominacion` varchar(100) NOT NULL,
  `duracion` int(10) unsigned NOT NULL,
  `fechaInicio` datetime NOT NULL,
  PRIMARY KEY  (`idCurso`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cursos`
--

/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` (`idCurso`,`denominacion`,`duracion`,`fechaInicio`) VALUES 
 (1,'java',50,'2019-01-17 00:00:00'),
 (2,'php',30,'2019-01-27 00:00:00'),
 (3,'angular',30,'2019-02-11 00:00:00'),
 (4,'python',40,'2019-02-04 00:00:00'),
 (5,'boot',70,'2019-08-27 14:52:07'),
 (6,'boot',70,'2019-08-27 15:02:30'),
 (7,'boot',70,'2019-08-27 15:04:05'),
 (8,'boot',70,'2019-09-06 17:01:39'),
 (9,'boot',70,'2019-09-06 17:03:23'),
 (10,'boot 22',70,'2019-09-11 18:22:16'),
 (11,'boot 22',70,'2019-09-11 18:22:44'),
 (12,'boot 22',70,'2019-09-13 10:47:02'),
 (13,'curso seguro',200,'2019-09-13 10:48:26'),
 (14,'curso seguro',200,'2019-09-17 16:03:47');
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;

--
-- Create schema formacion
--

CREATE DATABASE IF NOT EXISTS formacion;
USE formacion;

--
-- Definition of table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
CREATE TABLE `alumnos` (
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `edad` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alumnos`
--

/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` (`usuario`,`password`,`nombre`,`email`,`edad`) VALUES 
 ('dd','m37MbuuDq/mt4Q/jiGXfRJm+NWjcxQeuLsO0SYnLAJM=','fdsf','dsfds@gg.es',11),
 ('java','OKCWOmNksJrYZ6qaZsbQCWc8IeGCAVRh2iNuw2GHf3c=','java','java@dd.com',33),
 ('javato','T6GEvvueoevbXxbeTLMz6fk5FLZHd1RtUBcKFUes8U0=','aaa','asas@fff.es',33),
 ('uno','vw7DaU4SLgZ9mWSjjsfYQVeB30sk9EKtdntGIfuY+MU=','profe','profe@gmail.com',22);
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;


--
-- Definition of table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
CREATE TABLE `cursos` (
  `idCurso` int(10) unsigned NOT NULL auto_increment,
  `nombre` varchar(45) NOT NULL,
  `duracion` int(10) unsigned NOT NULL,
  `documento` varchar(45) NOT NULL,
  PRIMARY KEY  (`idCurso`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cursos`
--

/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` (`idCurso`,`nombre`,`duracion`,`documento`) VALUES 
 (1,'Java 10',100,'ddd'),
 (2,'python',50,'ss'),
 (3,'php',25,'qqq'),
 (4,'jsf',30,'rrrr');
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;


--
-- Definition of table `matriculas`
--

DROP TABLE IF EXISTS `matriculas`;
CREATE TABLE `matriculas` (
  `usuario` varchar(45) NOT NULL,
  `idCurso` int(10) unsigned NOT NULL,
  `nota` double NOT NULL default '0',
  PRIMARY KEY  (`usuario`,`idCurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matriculas`
--

/*!40000 ALTER TABLE `matriculas` DISABLE KEYS */;
INSERT INTO `matriculas` (`usuario`,`idCurso`,`nota`) VALUES 
 ('dd',1,0),
 ('java',1,0),
 ('java',3,0),
 ('uno',1,0);
/*!40000 ALTER TABLE `matriculas` ENABLE KEYS */;


--
-- Definition of table `preguntas`
--

DROP TABLE IF EXISTS `preguntas`;
CREATE TABLE `preguntas` (
  `idPregunta` int(10) unsigned NOT NULL auto_increment,
  `idCurso` int(10) unsigned NOT NULL,
  `enunciado` varchar(200) NOT NULL,
  PRIMARY KEY  (`idPregunta`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `preguntas`
--

/*!40000 ALTER TABLE `preguntas` DISABLE KEYS */;
INSERT INTO `preguntas` (`idPregunta`,`idCurso`,`enunciado`) VALUES 
 (1,1,'¿Cuantos bytes ocupa el tipo int?'),
 (2,1,'¿Cual es una palabra reservada de Java?');
/*!40000 ALTER TABLE `preguntas` ENABLE KEYS */;


--
-- Definition of table `respuestas`
--

DROP TABLE IF EXISTS `respuestas`;
CREATE TABLE `respuestas` (
  `idRespuesta` int(10) unsigned NOT NULL auto_increment,
  `idPregunta` int(10) unsigned NOT NULL,
  `texto` varchar(150) NOT NULL,
  `correcta` tinyint(1) NOT NULL,
  PRIMARY KEY  (`idRespuesta`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `respuestas`
--

/*!40000 ALTER TABLE `respuestas` DISABLE KEYS */;
INSERT INTO `respuestas` (`idRespuesta`,`idPregunta`,`texto`,`correcta`) VALUES 
 (1,1,'2',0),
 (2,1,'4',1),
 (3,1,'3',0),
 (4,1,'8',0),
 (5,2,'red',0),
 (6,2,'main',0),
 (7,2,'scanner',0),
 (8,2,'import',1);
/*!40000 ALTER TABLE `respuestas` ENABLE KEYS */;

--
-- Create schema libros
--

CREATE DATABASE IF NOT EXISTS libros;
USE libros;

--
-- Definition of table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `idCliente` int(10) unsigned NOT NULL auto_increment,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clientes`
--

/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`idCliente`,`usuario`,`password`,`email`,`telefono`) VALUES 
 (1,'test1','test1','test1@gmail.com',22222),
 (2,'test2','test2','test2@gmail.com',3333),
 (3,'test3','test3','afas',444),
 (4,'profe','profe','sadasd',234),
 (5,'ere','ff','aseea',23),
 (6,'fulano','mipassword','dfsfs@.es',343434),
 (7,'fulano','mipassword','dfsfs@.es',343434),
 (8,'usuario_ejemplo','password_ejemplo','email@email.com',33333),
 (9,'miuser','mipass1','faddfs',3434),
 (10,'','','SADASD',0),
 (11,'DSF','DSF','SDFDF',0),
 (12,'','','ghhgf@',0),
 (13,'pepito','grillo','jajajaj',777777),
 (14,'persiste','persiste','ddd',34),
 (15,'pepito','grillo','jajajaj',777777),
 (16,'pepito','grillo','jajajaj',777777),
 (17,'mvc1','mvc1','sadas',1111),
 (18,'p1','p1','wwww',1111),
 (19,'jsfxx','jsfxx','eeeeee',44444),
 (20,'ewr','fdgdfgdf','ewrwe',666666),
 (21,'usuariotest','passwordtest','emailtest',111111),
 (22,'user_rest','pwd_rest','rest@gmail.com',2222),
 (23,'sa','sa','sa',22),
 (24,'usuario rest','pwdrest','email@rest.com',22222),
 (25,'usuario rest','pwdrest','email@rest.com',22222),
 (27,'ivan','ivan','iv',7678),
 (28,'lucas','grijander','pato',1234),
 (29,'cjava','cjava','eeee',4444),
 (30,'as1','as1','sss',2222),
 (31,'','','',0),
 (32,'fg','ss','gggg.jj@',7),
 (33,'js2','jsf2','ddd',4444),
 (34,'ciclo','ciclo','ciclo',333),
 (35,'spjpa','spjpa','spjpa',2),
 (36,'spjpa','spjpa','spjpa',56),
 (37,'spjpa2','spjpa2','spjpa2',6),
 (38,'springfly','springfly','springfly',111);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;


--
-- Definition of table `libros`
--

DROP TABLE IF EXISTS `libros`;
CREATE TABLE `libros` (
  `isbn` int(10) unsigned NOT NULL,
  `titulo` varchar(200) NOT NULL,
  `autor` varchar(45) default NULL,
  `precio` double NOT NULL,
  `paginas` int(10) unsigned default NULL,
  `idTema` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `libros`
--

/*!40000 ALTER TABLE `libros` DISABLE KEYS */;
INSERT INTO `libros` (`isbn`,`titulo`,`autor`,`precio`,`paginas`,`idTema`) VALUES 
 (888,'Java 8','Gomez',22,300,1),
 (900,'Java 11','hilton',34,300,1),
 (6723,'Windows 20103','pears',19,170,2),
 (8767,'word','roberts',14,123,4),
 (9999,'administración linux','angel lopez',30,370,2),
 (11123,'java2','antonio martin',30,400,1),
 (13667,'Machine Learning','Nelson',31,370,3),
 (27883,'Hadoop','Bryan',30,260,3),
 (43944,'programación python','engels',28,240,1),
 (232323244,'java','yo',10,0,1);
/*!40000 ALTER TABLE `libros` ENABLE KEYS */;


--
-- Definition of table `ofertas`
--

DROP TABLE IF EXISTS `ofertas`;
CREATE TABLE `ofertas` (
  `idOferta` int(10) unsigned NOT NULL auto_increment,
  `texto` varchar(45) NOT NULL,
  PRIMARY KEY  (`idOferta`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ofertas`
--

/*!40000 ALTER TABLE `ofertas` DISABLE KEYS */;
INSERT INTO `ofertas` (`idOferta`,`texto`) VALUES 
 (1,'5% en todos los libros de informática'),
 (2,'Gastos de envío gratis a partir de 50 eur.'),
 (3,'Los lunes dos libros al precio de uno');
/*!40000 ALTER TABLE `ofertas` ENABLE KEYS */;


--
-- Definition of table `temas`
--

DROP TABLE IF EXISTS `temas`;
CREATE TABLE `temas` (
  `idTema` int(10) unsigned NOT NULL auto_increment,
  `tema` varchar(45) NOT NULL,
  PRIMARY KEY  (`idTema`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `temas`
--

/*!40000 ALTER TABLE `temas` DISABLE KEYS */;
INSERT INTO `temas` (`idTema`,`tema`) VALUES 
 (1,'programación'),
 (2,'sistemas operativos'),
 (3,'big data'),
 (4,'ofimatica');
/*!40000 ALTER TABLE `temas` ENABLE KEYS */;


--
-- Definition of table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
CREATE TABLE `ventas` (
  `idVEnta` int(10) unsigned NOT NULL auto_increment,
  `idCliente` int(10) unsigned NOT NULL,
  `idLibro` int(10) unsigned NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY  (`idVEnta`),
  KEY `FK_ventas_1` (`idLibro`),
  KEY `FK_ventas_2` (`idCliente`),
  CONSTRAINT `FK_ventas_1` FOREIGN KEY (`idLibro`) REFERENCES `libros` (`isbn`),
  CONSTRAINT `FK_ventas_2` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ventas`
--

/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` (`idVEnta`,`idCliente`,`idLibro`,`fecha`) VALUES 
 (1,1,9999,'2010-09-01 11:49:21'),
 (2,1,11123,'2011-09-01 11:49:21'),
 (3,1,11123,'2012-09-01 11:49:21'),
 (4,1,11123,'2012-09-02 12:38:23'),
 (5,1,9999,'2012-09-02 12:38:23'),
 (6,1,8767,'2013-02-16 00:00:00'),
 (7,1,11123,'2015-02-16 00:00:00'),
 (8,1,9999,'2015-02-16 00:00:00'),
 (10,1,9999,'2016-06-05 00:00:00'),
 (11,1,900,'2018-08-13 11:29:10'),
 (12,1,43944,'2018-08-13 11:29:10');
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;

--
-- Create schema rentacar
--

CREATE DATABASE IF NOT EXISTS rentacar;
USE rentacar;

--
-- Definition of table `alquileres`
--

DROP TABLE IF EXISTS `alquileres`;
CREATE TABLE `alquileres` (
  `idalquiler` int(10) unsigned NOT NULL auto_increment,
  `matricula` varchar(20) NOT NULL,
  `kilometros` varchar(45) NOT NULL,
  `fechaalquiler` datetime NOT NULL,
  `dias` int(10) unsigned NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY  (`idalquiler`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alquileres`
--

/*!40000 ALTER TABLE `alquileres` DISABLE KEYS */;
INSERT INTO `alquileres` (`idalquiler`,`matricula`,`kilometros`,`fechaalquiler`,`dias`,`precio`) VALUES 
 (1,'m1','1222','2019-11-02 00:00:00',2,3333);
/*!40000 ALTER TABLE `alquileres` ENABLE KEYS */;


--
-- Definition of table `coches`
--

DROP TABLE IF EXISTS `coches`;
CREATE TABLE `coches` (
  `matricula` varchar(20) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  PRIMARY KEY  (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `coches`
--

/*!40000 ALTER TABLE `coches` DISABLE KEYS */;
/*!40000 ALTER TABLE `coches` ENABLE KEYS */;

--
-- Create schema viajes
--

CREATE DATABASE IF NOT EXISTS viajes;
USE viajes;

--
-- Definition of table `hoteles`
--

DROP TABLE IF EXISTS `hoteles`;
CREATE TABLE `hoteles` (
  `idHotel` int(10) unsigned NOT NULL default '0',
  `nombre` varchar(45) NOT NULL,
  `categoria` int(10) unsigned NOT NULL,
  `precio` double NOT NULL,
  `disponible` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY  (`idHotel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hoteles`
--

/*!40000 ALTER TABLE `hoteles` DISABLE KEYS */;
INSERT INTO `hoteles` (`idHotel`,`nombre`,`categoria`,`precio`,`disponible`) VALUES 
 (1,'Norte',3,120,1),
 (2,'Ritz',5,400,1),
 (3,'Estrella sur',4,190,0),
 (4,'Meridian',4,210,1);
/*!40000 ALTER TABLE `hoteles` ENABLE KEYS */;


--
-- Definition of table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
CREATE TABLE `reservas` (
  `idreserva` int(10) unsigned NOT NULL auto_increment,
  `nombre` varchar(45) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `hotel` int(10) unsigned NOT NULL,
  `vuelo` int(10) unsigned NOT NULL,
  PRIMARY KEY  USING BTREE (`idreserva`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservas`
--

/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;


--
-- Definition of table `vuelos`
--

DROP TABLE IF EXISTS `vuelos`;
CREATE TABLE `vuelos` (
  `idvuelo` int(10) unsigned NOT NULL default '0',
  `company` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `plazas` int(10) unsigned NOT NULL,
  PRIMARY KEY  USING BTREE (`idvuelo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vuelos`
--

/*!40000 ALTER TABLE `vuelos` DISABLE KEYS */;
INSERT INTO `vuelos` (`idvuelo`,`company`,`fecha`,`precio`,`plazas`) VALUES 
 (1,'Iberia','10-12-2017',200,10),
 (2,'Air Europa','11-12-2027',170,6);
/*!40000 ALTER TABLE `vuelos` ENABLE KEYS */;

--
-- Create schema agenda
--

CREATE DATABASE IF NOT EXISTS agenda;
USE agenda;

--
-- Definition of procedure `totalContactos`
--

DROP PROCEDURE IF EXISTS `totalContactos`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `totalContactos`(texto varchar(50), out res varchar(50))
BEGIN

   Declare valor integer;
   select count(nombre) From contactos into valor;
   set res=concat(texto,valor);
   
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;
--
-- Create schema agenda2
--

CREATE DATABASE IF NOT EXISTS agenda2;
USE agenda2;

--
-- Definition of procedure `totalContactos`
--

DROP PROCEDURE IF EXISTS `totalContactos`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `totalContactos`(texto varchar(50), out res varchar(50))
BEGIN

   Declare valor integer;
   select count(nombre) From contactos into valor;
   set res=concat(texto,valor);
   
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;
--
-- Create schema libros
--

CREATE DATABASE IF NOT EXISTS libros;
USE libros;

--
-- Definition of procedure `librostema`
--

DROP PROCEDURE IF EXISTS `librostema`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `librostema`(IN t integer)
BEGIN
    select titulo from libros where idTema=t;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
