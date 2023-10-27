-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-10-2023 a las 23:26:00
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `_vacunar23`
--
CREATE DATABASE IF NOT EXISTS `_vacunar23` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `_vacunar23`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citavacunacion`
--

CREATE TABLE `citavacunacion` (
  `codCita` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `codRefuerzo` int(11) NOT NULL,
  `fechaHoraCita` datetime NOT NULL,
  `centroVacunacion` int(11) NOT NULL,
  `fechaHoraColoca` datetime DEFAULT NULL,
  `nroSerieDosis` int(11) NOT NULL,
  `citaEstado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadano`
--

CREATE TABLE `ciudadano` (
  `dni` int(11) NOT NULL,
  `nombreCompleto` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `celular` varchar(30) NOT NULL,
  `patologia` varchar(30) DEFAULT NULL,
  `ambitoTrabajo` varchar(30) NOT NULL,
  `dosis` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ciudadano`
--

INSERT INTO `ciudadano` (`dni`, `nombreCompleto`, `email`, `celular`, `patologia`, `ambitoTrabajo`, `dosis`, `estado`) VALUES
(3458965, 'mara  solana', 'fulano@email', '124582456', 'diabetes', 'recepcionista', 2, 1),
(32458965, 'Juan  ignacio Perez', 'fulano@email', 'celular', 'patologia', 'salud', 2, 0),
(33458965, 'lisa  rodriguez', 'fulano@email', '123456789', 'cardiaca', 'operario', 2, 0),
(35458965, 'mara  solana', 'fulano@email', '124582456', 'diabetes', 'recepcionista', 2, 1),
(45826945, 'Roxana  montero', 'fulano@email', '124582456', 'diabetes', 'recepcionista', 2, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `laboratorio`
--

CREATE TABLE `laboratorio` (
  `cuit` varchar(20) NOT NULL,
  `nomLaboratorio` varchar(50) NOT NULL,
  `pais` varchar(30) NOT NULL,
  `domComercial` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacuna`
--

CREATE TABLE `vacuna` (
  `nroSerieDosis` int(11) NOT NULL,
  `cuit` varchar(20) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `medida` double NOT NULL,
  `fechaCaduca` date NOT NULL,
  `colocada` tinyint(1) NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `citavacunacion`
--
ALTER TABLE `citavacunacion`
  ADD PRIMARY KEY (`codCita`),
  ADD KEY `dni` (`dni`),
  ADD KEY `nroSerieDosis` (`nroSerieDosis`);

--
-- Indices de la tabla `ciudadano`
--
ALTER TABLE `ciudadano`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `laboratorio`
--
ALTER TABLE `laboratorio`
  ADD PRIMARY KEY (`cuit`);

--
-- Indices de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD PRIMARY KEY (`nroSerieDosis`),
  ADD KEY `cuit` (`cuit`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citavacunacion`
--
ALTER TABLE `citavacunacion`
  MODIFY `codCita` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citavacunacion`
--
ALTER TABLE `citavacunacion`
  ADD CONSTRAINT `citavacunacion_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `ciudadano` (`dni`),
  ADD CONSTRAINT `citavacunacion_ibfk_2` FOREIGN KEY (`nroSerieDosis`) REFERENCES `vacuna` (`nroSerieDosis`);

--
-- Filtros para la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD CONSTRAINT `vacuna_ibfk_1` FOREIGN KEY (`cuit`) REFERENCES `laboratorio` (`cuit`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
