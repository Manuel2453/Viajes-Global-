CREATE DATABASE  IF NOT EXISTS `carrito_viajesglobal` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `carrito_viajesglobal`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: carrito_viajesglobal
-- ------------------------------------------------------
-- Server version	5.7.44-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `carrito`
--

DROP TABLE IF EXISTS carrito;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE carrito (
  ID_Carrito int(11) NOT NULL AUTO_INCREMENT,
  ID_Usuario int(11) NOT NULL,
  Estado enum('Activo','Pagado','Cancelado') DEFAULT 'Activo',
  Fecha_Creacion timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  Total decimal(10,2) DEFAULT '0.00',
  Cupon_Aplicado varchar(100) DEFAULT NULL,
  PRIMARY KEY (ID_Carrito)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito`
--


--
-- Table structure for table `item_carrito`
--

DROP TABLE IF EXISTS item_carrito;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE item_carrito (
  ID_Item int(11) NOT NULL AUTO_INCREMENT,
  ID_Carrito int(11) NOT NULL,
  Tipo_Item enum('Vuelo','Alojamiento','Actividad','Traslado') DEFAULT NULL,
  ID_Referencia int(11) NOT NULL,
  Precio decimal(10,2) DEFAULT NULL,
  Cantidad int(11) DEFAULT '1',
  PRIMARY KEY (ID_Item)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_carrito`
--


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
CREATE DATABASE  IF NOT EXISTS `promociones_viajesglobal` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `promociones_viajesglobal`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: promociones_viajesglobal
-- ------------------------------------------------------
-- Server version	5.7.44-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `descuento`
--

DROP TABLE IF EXISTS descuento;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE descuento (
  ID_Descuento int(11) NOT NULL AUTO_INCREMENT,
  Cupon varchar(100) DEFAULT NULL,
  Porcentaje_Descuento decimal(5,2) DEFAULT NULL,
  Fecha_Vencimiento date DEFAULT NULL,
  Activo tinyint(1) DEFAULT '1',
  descripcion varchar(250) DEFAULT NULL,
  PRIMARY KEY (ID_Descuento),
  UNIQUE KEY Cupon (Cupon)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descuento`
--

INSERT INTO descuento VALUES (1,'HOTCARTAGENA10',10.00,'2024-12-31',1,'Vuela con el 10%  a Cartagena');
INSERT INTO descuento VALUES (2,'PACKSHOT8',8.00,'2024-12-31',1,'Paquetes en el caribe con 8% de descuento');
INSERT INTO descuento VALUES (3,'MEXHOT',15.00,'2024-12-31',1,'Vuela a Mexico con 15% de descuento');
INSERT INTO descuento VALUES (4,'COTRAVEL5',5.00,'2024-12-31',1,'Reserva actividades en toda Colombia con 5% de descuento');

--
-- Table structure for table `promocion`
--

DROP TABLE IF EXISTS promocion;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE promocion (
  ID_Promocion int(11) NOT NULL AUTO_INCREMENT,
  Origen varchar(100) DEFAULT NULL,
  Destino varchar(100) DEFAULT NULL,
  Precio decimal(10,2) DEFAULT NULL,
  Dias int(11) DEFAULT NULL,
  Noches int(11) DEFAULT NULL,
  Vuelo_Directo_Escala enum('Directo','Escala') DEFAULT NULL,
  Hotel varchar(100) DEFAULT NULL,
  Fecha_Inicio date DEFAULT NULL,
  Fecha_Fin date DEFAULT NULL,
  Imagen_url varchar(255) DEFAULT NULL,
  PRIMARY KEY (ID_Promocion)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promocion`
--

INSERT INTO promocion VALUES (1,'Bogotá','Cartagena',500000.00,3,2,'Directo','Hotel Caribe','2024-12-01','2024-12-03','https://www.viajes.cl/hubfs/Torre%20del%20Reloj%20en%20Cartagena%20de%20Indias,%20Colombia.jpg');
INSERT INTO promocion VALUES (2,'Bogotá','Santa Marta',700000.00,4,3,'Directo','Hotel Viajero','2024-12-05','2024-12-08','https://viajaconrichy.com/wp-content/uploads/2022/12/Santa-Marta-rodadero-1024x683.jpg');
INSERT INTO promocion VALUES (3,'Medellín','Bogotá',800000.00,6,5,'Directo','Hotel Hilton','2024-12-08','2024-12-13','https://blog.urbansa.co/hs-fs/hubfs/Centro%20de%20la%20ciudad%20-%20El%20centro%20de%20Bogot%C3%A1-Bogot%C3%A1%20de%20noche.jpg?width=553&name=Centro%20de%20la%20ciudad%20-%20El%20centro%20de%20Bogot%C3%A1-Bogot%C3%A1%20de%20noche.jpg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
CREATE DATABASE  IF NOT EXISTS `usuarios_viajesglobal` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `usuarios_viajesglobal`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: usuarios_viajesglobal
-- ------------------------------------------------------
-- Server version	5.7.44-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS usuario;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE usuario (
  ID_Usuario int(11) NOT NULL AUTO_INCREMENT,
  Nombre varchar(100) DEFAULT NULL,
  Apellido varchar(100) DEFAULT NULL,
  Telefono varchar(20) DEFAULT NULL,
  Correo_Electronico varchar(100) DEFAULT NULL,
  Usuario varchar(50) DEFAULT NULL,
  Contrasena varchar(255) DEFAULT NULL,
  Preferencias_Notificacion enum('SMS','Correo','Push') DEFAULT NULL,
  Fecha_Registro timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (ID_Usuario),
  UNIQUE KEY Correo_Electronico (Correo_Electronico),
  UNIQUE KEY Usuario (Usuario)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

INSERT INTO usuario VALUES (1,'Valentina Becerra Sastoque',NULL,'3015389783','valeb22@gmail.com','valeb22','123456','Correo','2024-10-24 23:07:01');
INSERT INTO usuario VALUES (2,'Tatiana Sastoque',NULL,'3202356292','tatysastoque@gmail.com','taty083','123456','Correo','2024-10-27 17:23:51');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
CREATE DATABASE  IF NOT EXISTS `reservas_viajesglobal` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `reservas_viajesglobal`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: reservas_viajesglobal
-- ------------------------------------------------------
-- Server version	5.7.44-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS actividad;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE actividad (
  ID_Actividad int(11) NOT NULL AUTO_INCREMENT,
  Destino varchar(100) DEFAULT NULL,
  Titulo varchar(100) DEFAULT NULL,
  Descripcion text,
  Incluye_Traslado tinyint(1) DEFAULT NULL,
  Estrellas int(11) DEFAULT NULL,
  Comentarios text,
  Precio decimal(10,2) DEFAULT NULL,
  Duracion_Horas int(11) DEFAULT NULL,
  Fecha_Inicio date DEFAULT NULL,
  Fecha_Fin date DEFAULT NULL,
  PRIMARY KEY (ID_Actividad)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--


--
-- Table structure for table `alojamiento`
--

DROP TABLE IF EXISTS alojamiento;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE alojamiento (
  ID_Alojamiento int(11) NOT NULL AUTO_INCREMENT,
  Ciudad varchar(100) DEFAULT NULL,
  Nombre_Hotel varchar(100) DEFAULT NULL,
  Estrellas int(11) DEFAULT NULL,
  Direccion varchar(255) DEFAULT NULL,
  Cantidad_Habitaciones int(11) DEFAULT NULL,
  Cantidad_Personas int(11) DEFAULT NULL,
  Fecha_Entrada date DEFAULT NULL,
  Fecha_Salida date DEFAULT NULL,
  Fotos text,
  Servicios text,
  PRIMARY KEY (ID_Alojamiento)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alojamiento`
--


--
-- Table structure for table `traslado`
--

DROP TABLE IF EXISTS traslado;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE traslado (
  ID_Traslado int(11) NOT NULL AUTO_INCREMENT,
  Origen varchar(100) DEFAULT NULL,
  Destino varchar(100) DEFAULT NULL,
  Tipo_Transporte enum('Carro','Van','Bus') DEFAULT NULL,
  Maximo_Personas int(11) DEFAULT NULL,
  Fecha date DEFAULT NULL,
  Hora time DEFAULT NULL,
  Aerolinea varchar(100) DEFAULT NULL,
  Numero_Vuelo varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID_Traslado)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traslado`
--


--
-- Table structure for table `vuelo`
--

DROP TABLE IF EXISTS vuelo;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE vuelo (
  ID_Vuelo int(11) NOT NULL AUTO_INCREMENT,
  Tipo_Vuelo enum('Ida','Ida y Vuelta') DEFAULT NULL,
  Cantidad_Personas int(11) DEFAULT NULL,
  Clase enum('Turista','Business') DEFAULT NULL,
  Origen varchar(100) DEFAULT NULL,
  Destino varchar(100) DEFAULT NULL,
  Fecha_Salida date DEFAULT NULL,
  Fecha_Llegada date DEFAULT NULL,
  PRIMARY KEY (ID_Vuelo)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vuelo`
--


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
CREATE DATABASE  IF NOT EXISTS `pagos_viajesglobal` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `pagos_viajesglobal`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pagos_viajesglobal
-- ------------------------------------------------------
-- Server version	5.7.44-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `datos_tarjeta`
--

DROP TABLE IF EXISTS datos_tarjeta;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE datos_tarjeta (
  Numero_Tarjeta varchar(16) DEFAULT NULL,
  Nombre_Titular varchar(100) DEFAULT NULL,
  CVV varchar(4) DEFAULT NULL,
  Fecha_Vencimiento date DEFAULT NULL,
  ID_Pago int(11) DEFAULT NULL,
  PRIMARY KEY (ID_Tarjeta),
  UNIQUE KEY Numero_Tarjeta (Numero_Tarjeta)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_tarjeta`
--


--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS pago;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE pago (
  ID_Pago varchar(40) NOT NULL,
  Fecha_Pago timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  Monto decimal(10,2) DEFAULT NULL,
  Estado enum('Completado','Pendiente','Fallido') DEFAULT NULL,
  ID_Reserva int(11) DEFAULT NULL,
  PRIMARY KEY (ID_Pago)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
