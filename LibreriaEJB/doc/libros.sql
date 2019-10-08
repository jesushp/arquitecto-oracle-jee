

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `idCliente` int(10) UNSIGNED NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono` int(10) UNSIGNED NOT NULL,
  `dni` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idCliente`, `usuario`, `password`, `email`, `telefono`, `dni`) VALUES
(1, 'test1', 'test1', 'test1@gmail.com', 22222, '00000001'),
(2, 'test2', 'test2', 'test2@gmail.com', 3333, '00000002'),
(3, 'test3', 'test3', 'afas', 444, '00000003'),
(4, 'profe', 'profe', 'sadasd', 234, '00000004'),
(5, 'ere', 'ff', 'aseea', 23, '00000005'),
(6, 'fulano', 'mipassword', 'dfsfs@.es', 343434, '00000006'),
(7, 'fulano', 'mipassword', 'dfsfs@.es', 343434, '00000007'),
(8, 'usuario_ejemplo', 'password_ejemplo', 'email@email.com', 33333, '00000008'),
(9, 'miuser', 'mipass1', 'faddfs', 3434, '00000009'),
(10, '', '', 'SADASD', 0, '000000010'),
(11, 'DSF', 'DSF', 'SDFDF', 0, '000000011'),
(12, '', '', 'ghhgf@', 0, '000000012'),
(13, 'pepito', 'grillo', 'jajajaj', 777777, '000000013'),
(14, 'persiste', 'persiste', 'ddd', 34, '000000014'),
(15, 'pepito', 'grillo', 'jajajaj', 777777, '000000015'),
(16, 'pepito', 'grillo', 'jajajaj', 777777, '000000016'),
(17, 'mvc1', 'mvc1', 'sadas', 1111, '000000017'),
(18, 'p1', 'p1', 'wwww', 1111, '000000018'),
(19, 'jsfxx', 'jsfxx', 'eeeeee', 44444, '000000019'),
(20, 'ewr', 'fdgdfgdf', 'ewrwe', 666666, '000000020'),
(21, 'usuariotest', 'passwordtest', 'emailtest', 111111, '000000021'),
(22, 'user_rest', 'pwd_rest', 'rest@gmail.com', 2222, '000000022'),
(23, 'sa', 'sa', 'sa', 22, '000000023'),
(24, 'usuario rest', 'pwdrest', 'email@rest.com', 22222, '000000024'),
(25, 'usuario rest', 'pwdrest', 'email@rest.com', 22222, '000000025'),
(27, 'ivan', 'ivan', 'iv', 7678, '000000027'),
(28, 'lucas', 'grijander', 'pato', 1234, '000000028'),
(29, 'cjava', 'cjava', 'eeee', 4444, '000000029'),
(30, 'as1', 'as1', 'sss', 2222, '000000030'),
(31, '', '', '', 0, '000000031'),
(32, 'fg', 'ss', 'gggg.jj@', 7, '000000032'),
(33, 'js2', 'jsf2', 'ddd', 4444, '000000033'),
(34, 'ciclo', 'ciclo', 'ciclo', 333, '000000034'),
(35, 'spjpa', 'spjpa', 'spjpa', 2, '000000035'),
(36, 'spjpa', 'spjpa', 'spjpa', 56, '000000036'),
(37, 'spjpa2', 'spjpa2', 'spjpa2', 6, '000000037'),
(38, 'springfly', 'springfly', 'springfly', 111, '000000038');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas`
--

CREATE TABLE `cuentas` (
  `numeroCuenta` int(10) UNSIGNED NOT NULL,
  `saldo` double NOT NULL,
  `tipocuenta` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cuentas`
--

INSERT INTO `cuentas` (`numeroCuenta`, `saldo`, `tipocuenta`) VALUES
(1000, 44111, 'ahorro'),
(1234, 70, 'prueba2'),
(2000, 9000, 'ahorro'),
(3000, 670, 'recibos'),
(4000, 880, 'ahorro'),
(5000, 6700, 'recibos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `titulo` varchar(200) NOT NULL,
  `autor` varchar(45) DEFAULT NULL,
  `precio` double NOT NULL,
  `paginas` int(10) UNSIGNED DEFAULT NULL,
  `idTema` int(10) UNSIGNED NOT NULL,
  `isbn` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`titulo`, `autor`, `precio`, `paginas`, `idTema`, `isbn`) VALUES
('Machine Learning', 'Nelson', 31, 370, 3, '978-3-16-118410-0'),
('programación python', 'engels', 28, 240, 1, '978-3-16-118411-0'),
('java', 'yo', 10, 0, 1, '978-3-16-132310-0'),
('java2', 'antonio martin', 30, 400, 1, '978-3-16-148210-0'),
('Hadoop', 'Bryan', 30, 260, 3, '978-3-16-148220-0'),
('Java 8', 'Gomez', 22, 300, 1, '978-3-16-148410-0'),
('Java 11', 'hilton', 34, 300, 1, '978-3-16-148410-1'),
('Windows 20103', 'pears', 19, 170, 2, '978-3-16-148410-2'),
('word', 'roberts', 14, 123, 4, '978-3-16-148410-4'),
('administración linux', 'angel lopez', 30, 370, 2, '978-3-16-148410-7');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos`
--

CREATE TABLE `movimientos` (
  `idMovimiento` int(10) UNSIGNED NOT NULL,
  `idCuenta` int(10) UNSIGNED NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `cantidad` double NOT NULL,
  `operacion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `movimientos`
--

INSERT INTO `movimientos` (`idMovimiento`, `idCuenta`, `fecha`, `cantidad`, `operacion`) VALUES
(25, 1000, '2019-03-31 11:41:08', 200, 'extracción'),
(26, 1000, '2019-03-31 12:44:17', 500, 'ingreso'),
(27, 2000, '2019-03-31 12:44:57', 300, 'extracción'),
(28, 1000, '2019-03-31 12:44:57', 300, 'ingreso'),
(29, 2000, '2019-03-31 12:45:10', 2000, 'ingreso'),
(30, 1000, '2019-03-31 18:56:59', 35, 'ingreso'),
(31, 1000, '2019-03-31 19:06:41', 200, 'extracción'),
(32, 1000, '2019-03-31 19:07:01', 1000, 'ingreso'),
(33, 1000, '2019-03-31 19:08:17', 500, 'extracción'),
(34, 1000, '2019-03-31 19:13:46', 5, 'ingreso'),
(35, 1000, '2019-04-04 22:28:56', 23, 'ingreso'),
(36, 1000, '2019-04-04 22:29:06', 34, 'extracción'),
(37, 1000, '2019-04-04 22:30:43', 11, 'extracción'),
(38, 1000, '2019-04-04 22:31:39', 11, 'extracción'),
(39, 1000, '2019-06-26 20:17:31', 300, 'extracción'),
(40, 1000, '2019-06-27 15:58:59', 50000, 'extracción'),
(41, 2000, '2019-06-27 15:58:59', 50000, 'ingreso'),
(42, 1000, '2019-06-27 16:02:56', 3000, 'extracción'),
(43, 2000, '2019-06-27 16:02:56', 3000, 'ingreso'),
(44, 1000, '2019-06-27 16:05:05', 2000, 'extracción'),
(45, 2000, '2019-06-27 16:05:05', 2000, 'ingreso'),
(46, 1000, '2019-06-27 16:08:29', 2000, 'extracción'),
(47, 2000, '2019-06-27 16:08:29', 2000, 'ingreso'),
(48, 1000, '2019-06-27 16:37:48', 1111, 'extracción');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ofertas`
--

CREATE TABLE `ofertas` (
  `idOferta` int(10) UNSIGNED NOT NULL,
  `texto` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ofertas`
--

INSERT INTO `ofertas` (`idOferta`, `texto`) VALUES
(1, '5% en todos los libros de informática'),
(2, 'Gastos de envío gratis a partir de 50 eur.'),
(3, 'Los lunes dos libros al precio de uno');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `temas`
--

CREATE TABLE `temas` (
  `idTema` int(10) UNSIGNED NOT NULL,
  `tema` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `temas`
--

INSERT INTO `temas` (`idTema`, `tema`) VALUES
(1, 'programación'),
(2, 'sistemas operativos'),
(3, 'big data'),
(4, 'ofimatica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `titulares`
--

CREATE TABLE `titulares` (
  `idCuenta` int(10) UNSIGNED NOT NULL,
  `dni` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `titulares`
--

INSERT INTO `titulares` (`idCuenta`, `dni`) VALUES
(1000, '00000001'),
(1000, '000000013'),
(1234, '000000014'),
(1234, '00000002'),
(2000, '000000015'),
(2000, '00000003'),
(3000, '000000013'),
(3000, '00000004'),
(3000, '00000005'),
(5000, '000000013'),
(5000, '00000006');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `edad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `password`, `email`, `edad`) VALUES
(0, 'admin', 'admin', 'admin@admin.es', 23);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `idVEnta` int(10) UNSIGNED NOT NULL,
  `idCliente` int(10) UNSIGNED NOT NULL,
  `fecha` datetime NOT NULL,
  `isbn` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`idVEnta`, `idCliente`, `fecha`, `isbn`) VALUES
(1, 1, '2010-09-01 11:49:21', '978-3-16-148410-7'),
(2, 1, '2011-09-01 11:49:21', '978-3-16-148210-0'),
(3, 1, '2012-09-01 11:49:21', '978-3-16-148210-0'),
(4, 1, '2012-09-02 12:38:23', '978-3-16-148210-0'),
(5, 1, '2012-09-02 12:38:23', '978-3-16-148410-7'),
(6, 1, '2013-02-16 00:00:00', '978-3-16-148410-4'),
(7, 1, '2015-02-16 00:00:00', '978-3-16-148210-0'),
(8, 1, '2015-02-16 00:00:00', '978-3-16-148410-7'),
(10, 1, '2016-06-05 00:00:00', '978-3-16-148410-7'),
(11, 1, '2018-08-13 11:29:10', '978-3-16-148410-1'),
(12, 1, '2018-08-13 11:29:10', '978-3-16-118411-0');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idCliente`),
  ADD UNIQUE KEY `dni_UNIQUE` (`dni`);

--
-- Indices de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD PRIMARY KEY (`numeroCuenta`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`isbn`);

--
-- Indices de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD PRIMARY KEY (`idMovimiento`);

--
-- Indices de la tabla `ofertas`
--
ALTER TABLE `ofertas`
  ADD PRIMARY KEY (`idOferta`);

--
-- Indices de la tabla `temas`
--
ALTER TABLE `temas`
  ADD PRIMARY KEY (`idTema`);

--
-- Indices de la tabla `titulares`
--
ALTER TABLE `titulares`
  ADD PRIMARY KEY (`idCuenta`,`dni`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`idVEnta`),
  ADD KEY `FK_ventas_2` (`idCliente`),
  ADD KEY `FK_libros_1` (`isbn`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `idCliente` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  MODIFY `idMovimiento` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT de la tabla `ofertas`
--
ALTER TABLE `ofertas`
  MODIFY `idOferta` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `temas`
--
ALTER TABLE `temas`
  MODIFY `idTema` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `idVEnta` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `FK_libros_1` FOREIGN KEY (`isbn`) REFERENCES `libros` (`isbn`),
  ADD CONSTRAINT `FK_ventas_2` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`);
COMMIT;

