-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 24-05-2020 a las 22:59:33
-- Versión del servidor: 5.7.29-log
-- Versión de PHP: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proplayit`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `amigos`
--

CREATE TABLE `amigos` (
  `id_user1` int(4) NOT NULL DEFAULT '0',
  `id_user2` int(4) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `amigos`
--

INSERT INTO `amigos` (`id_user1`, `id_user2`) VALUES
(4556, 1679);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juegos`
--

CREATE TABLE `juegos` (
  `Id` int(5) NOT NULL DEFAULT '0',
  `Titulo` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Descripcion` text COLLATE utf8_spanish_ci,
  `Precio` double(5,2) NOT NULL,
  `Stock` int(2) DEFAULT '1',
  `Imagen` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `juegos`
--

INSERT INTO `juegos` (`Id`, `Titulo`, `Descripcion`, `Precio`, `Stock`, `Imagen`) VALUES
(1, 'Brawhalla', 'Juego de Pelea.', 1.00, 5, '/ProPlay/RecursoMultimedia/Juego1.jpg'),
(2, 'GTA V', 'Juegos de mundo libre.', 15.50, 11, '/ProPlay/RecursoMultimedia/Juego2.jpg'),
(3, 'Mario Kart', 'Juego de carreras.', 5.50, 10, '/ProPlay/RecursoMultimedia/Juego3.jpg'),
(4, 'Tetris', 'Juegos de piezas.', 3.78, 13, '/ProPlay/RecursoMultimedia/Juego4.jpg'),
(5, 'Far Cry 4', 'Juegos de violencia.', 80.00, 17, '/ProPlay/RecursoMultimedia/Juego5.jpg'),
(6, 'Fornite', 'BattleRoyale', 10.52, 5, '/ProPlay/RecursoMultimedia/Juego6.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `listas_juegos`
--

CREATE TABLE `listas_juegos` (
  `id_juegos` int(5) NOT NULL DEFAULT '0',
  `id_usuarios` int(4) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `listas_juegos`
--

INSERT INTO `listas_juegos` (`id_juegos`, `id_usuarios`) VALUES
(1, 4556),
(3, 4556),
(4, 4556),
(6, 4556);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `Id` int(4) NOT NULL DEFAULT '0',
  `User` varchar(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Passwd` varchar(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Credito` double(6,2) UNSIGNED ZEROFILL NOT NULL,
  `Email` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Id`, `User`, `Passwd`, `Credito`, `Email`) VALUES
(4556, 'Rafael', '123', 006.00, 'rafael@gmail.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `amigos`
--
ALTER TABLE `amigos`
  ADD PRIMARY KEY (`id_user1`,`id_user2`),
  ADD KEY `id_user2` (`id_user2`);

--
-- Indices de la tabla `juegos`
--
ALTER TABLE `juegos`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `listas_juegos`
--
ALTER TABLE `listas_juegos`
  ADD PRIMARY KEY (`id_juegos`,`id_usuarios`),
  ADD KEY `id_usuarios` (`id_usuarios`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
