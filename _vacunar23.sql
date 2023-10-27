-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-10-2023 a las 01:35:10
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
  `nroSerieDosis` int(11) DEFAULT NULL,
  `citaEstado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `citavacunacion`
--

INSERT INTO `citavacunacion` (`codCita`, `dni`, `codRefuerzo`, `fechaHoraCita`, `centroVacunacion`, `fechaHoraColoca`, `nroSerieDosis`, `citaEstado`) VALUES
(10, 222, 0, '2023-10-29 08:00:00', 3, '2023-10-29 08:00:00', 2, 1),
(11, 456, 0, '2023-10-31 09:15:00', 3, NULL, 3, 1),
(12, 123456789, 0, '2023-11-15 14:45:00', 4, NULL, 4, 1),
(13, 987654321, 0, '2023-11-24 09:30:00', 4, NULL, 5, 0),
(14, 123, 0, '2023-11-16 09:45:00', 4, NULL, NULL, 1);

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
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ciudadano`
--

INSERT INTO `ciudadano` (`dni`, `nombreCompleto`, `email`, `celular`, `patologia`, `ambitoTrabajo`, `dosis`, `estado`) VALUES
(123, 'Ariel Gimenez', 'ariel@gmail.com', '11645987321', '', 'Salud', 0, 1),
(222, 'Pedro Picapiedra', 'pedro@gmail.com', '123456', '', 'Amo de casa', 0, 0),
(456, 'Juan Gonzalez', 'juan@gmail.com', '119876546', 'Asma', 'Industria', 0, 1),
(123456789, 'Juan Perez', 'juanperez@gmail.com', '1122334455', 'Diabetes', 'Salud', 0, 1),
(987654321, 'Cosme Fulanito', 'cosmefulanito@gmail.com', '1133445566', 'Asma', 'Industria', 0, 1);

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

--
-- Volcado de datos para la tabla `laboratorio`
--

INSERT INTO `laboratorio` (`cuit`, `nomLaboratorio`, `pais`, `domComercial`) VALUES
('30-23325612-7', 'AstraZeneca', 'Estados Unidos', '1800 Concord Pike - 19803 Wilmington'),
('30-36325982-4', 'Pfizer', 'Estados Unidos', '235 East 42nd Street'),
('30-40025552-4', 'Sputnik V', 'Rusia', 'Ulitsa Gamalei 18 Moscu'),
('30-48325982-1', 'Moderna', 'Estados Unidos', 'Technology Square, Cambridge, MA 02139'),
('30-69752652-7', 'Sinopharm', 'China', 'JinAn, Jiangning Rd 293, Shanghai');

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
-- Volcado de datos para la tabla `vacuna`
--

INSERT INTO `vacuna` (`nroSerieDosis`, `cuit`, `marca`, `medida`, `fechaCaduca`, `colocada`, `stock`) VALUES
(1, '30-23325612-7', 'AstraZeneca', 0.3, '2023-11-30', 0, 1),
(2, '30-36325982-4', 'Pfizer', 0.5, '2023-11-28', 1, 1),
(3, '30-40025552-4', 'Sputnik V', 0.9, '2023-11-25', 0, 1),
(4, '30-48325982-1', 'Moderna', 0.3, '2023-10-29', 0, 1),
(5, '30-69752652-7', 'Sinopharm', 0.5, '2023-12-31', 0, 0);

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
  MODIFY `codCita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

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
