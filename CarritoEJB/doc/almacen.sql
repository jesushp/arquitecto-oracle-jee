-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `idPedido` int(10) UNSIGNED NOT NULL,
  `producto` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `categoria` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`idPedido`, `producto`, `precio`, `categoria`) VALUES
(2, 'bicicleta', 200, 'deporte'),
(4, 'libro java', 20, 'programación'),
(8, 'productos', 12.11, 'categorias');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProducto` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `idSeccion` int(10) UNSIGNED NOT NULL,
  `precio` double NOT NULL,
  `descripcion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProducto`, `nombre`, `idSeccion`, `precio`, `descripcion`) VALUES
(1, 'Alicates 25m', 1, 10.4, 'Disponibles en 10 dias'),
(2, 'Bombilla led 30w', 3, 5.7, 'duración 10 años'),
(3, 'cable cobre 10mm', 3, 2, 'flexible y resistente'),
(4, 'Tubo de cobre', 2, 3.6, 'precio por metro'),
(5, 'Grifo gres', 2, 27.5, 'Alta resistencia'),
(6, 'Taladradora 1000w', 3, 40.6, 'Sistema silencioso'),
(7, 'Bote pintura blanca 10 l', 4, 25.8, 'Doble capa'),
(8, 'Cerradura verja 30 mm', 1, 37.9, 'Universal para exterior'),
(9, 'Candado 25 mm amarillo', 1, 13.5, 'Llave incluida'),
(10, 'Interruptor doble', 3, 22.4, 'Solo color blanco'),
(11, 'Rodillo pintura 25 cm', 4, 14.9, 'se lava facilmente'),
(14, 'Rodillo pintura 25 cm', 4, 15.9, 'se lava facilmente'),
(15, 'Electricidad día a día', 3, 12.01, 'Descripción dia a dia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `secciones`
--

CREATE TABLE `secciones` (
  `idSeccion` int(10) UNSIGNED NOT NULL,
  `seccion` varchar(45) NOT NULL,
  `responsable` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `secciones`
--

INSERT INTO `secciones` (`idSeccion`, `seccion`, `responsable`) VALUES
(1, 'ferreteria', 'Juan López'),
(2, 'fontaneria', 'Ana Marcos'),
(3, 'electricidad', 'Ruth Esteban'),
(4, 'pintura', 'Pedro Ramos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursales`
--

CREATE TABLE `sucursales` (
  `nombre` varchar(45) NOT NULL,
  `calle` varchar(45) NOT NULL,
  `presupuesto` double NOT NULL,
  `innauguracion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sucursales`
--

INSERT INTO `sucursales` (`nombre`, `calle`, `presupuesto`, `innauguracion`) VALUES
('bazar em', 'c/los altos', 450000, 2012),
('nueva era', 'c/povedilla', 50000, 2010),
('venta chin', 'c/povedilla', 3000000, 2009);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `idVenta` int(10) UNSIGNED NOT NULL,
  `idProducto` int(10) UNSIGNED NOT NULL,
  `unidades` int(10) UNSIGNED NOT NULL,
  `ciudad` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`idVenta`, `idProducto`, `unidades`, `ciudad`) VALUES
(1, 1, 3, 'Madrid'),
(2, 3, 2, 'Madrid'),
(3, 1, 5, 'Sevilla'),
(4, 10, 4, 'Avila'),
(5, 3, 2, 'Jaen'),
(6, 5, 7, 'Madrid'),
(7, 4, 2, 'Sevilla'),
(8, 10, 3, 'Salamanca'),
(9, 7, 8, 'Albacete'),
(10, 4, 3, 'Soria');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`idPedido`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `secciones`
--
ALTER TABLE `secciones`
  ADD PRIMARY KEY (`idSeccion`);

--
-- Indices de la tabla `sucursales`
--
ALTER TABLE `sucursales`
  ADD PRIMARY KEY (`nombre`,`calle`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`idVenta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `idPedido` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `idProducto` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `secciones`
--
ALTER TABLE `secciones`
  MODIFY `idSeccion` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `idVenta` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

