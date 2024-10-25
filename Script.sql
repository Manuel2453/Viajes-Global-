-- 1. Microservicio de Usuarios
CREATE DATABASE Usuarios_ViajesGlobal;
USE Usuarios_ViajesGlobal;

CREATE TABLE Usuario (
    ID_Usuario INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100),
    Apellido VARCHAR(100),
    Telefono VARCHAR(20),
    Correo_Electronico VARCHAR(100) UNIQUE,
    Usuario VARCHAR(50) UNIQUE,
    Contrasena VARCHAR(255),  -- Encriptada
    Preferencias_Notificacion ENUM('SMS', 'Correo', 'Push'),
    Fecha_Registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. Microservicio de Promociones y Descuentos
CREATE DATABASE Promociones_ViajesGlobal;
USE Promociones_ViajesGlobal;

CREATE TABLE Promocion (
    ID_Promocion INT PRIMARY KEY AUTO_INCREMENT,
    Origen VARCHAR(100),
    Destino VARCHAR(100),
    Precio DECIMAL(10,2),
    Dias INT,
    Noches INT,
    Vuelo_Directo_Escala ENUM('Directo', 'Escala'),
    Hotel VARCHAR(100),
    Fecha_Inicio DATE,
    Fecha_Fin DATE
);

CREATE TABLE Descuento (
    ID_Descuento INT PRIMARY KEY AUTO_INCREMENT,
    Cupon VARCHAR(100) UNIQUE,
    Porcentaje_Descuento DECIMAL(5,2),
    Fecha_Vencimiento DATE,
    Activo BOOLEAN DEFAULT TRUE
);

-- 3. Microservicio de Pagos
CREATE DATABASE Pagos_ViajesGlobal;
USE Pagos_ViajesGlobal;

CREATE TABLE Pago (
    ID_Pago INT PRIMARY KEY AUTO_INCREMENT,
    Fecha_Pago TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Monto DECIMAL(10,2),
    Estado ENUM('Completado', 'Pendiente', 'Fallido'),
    Metodo_Pago ENUM('Tarjeta de Crédito', 'Tarjeta de debito', 'Transferencia Bancaria'),
    ID_Reserva INT
);

CREATE TABLE Datos_Tarjeta (
    ID_Tarjeta INT PRIMARY KEY AUTO_INCREMENT,
    Nombre_Titular VARCHAR(100),
    Numero_Tarjeta VARCHAR(16),
    CVV VARCHAR(4),
    Fecha_Vencimiento DATE,
    ID_Pago INT UNIQUE
);

-- 4. Microservicio de Reservas

-- Vuelos
CREATE DATABASE Reservas_ViajesGlobal;
USE Reservas_ViajesGlobal;

CREATE TABLE Vuelo (
    ID_Vuelo INT PRIMARY KEY AUTO_INCREMENT,
    Tipo_Vuelo ENUM('Ida', 'Ida y Vuelta'),
    Cantidad_Personas INT CHECK (Cantidad_Personas BETWEEN 1 AND 6),
    Clase ENUM('Turista', 'Business'),
    Origen VARCHAR(100),
    Destino VARCHAR(100),
    Fecha_Salida DATE,
    Fecha_Llegada DATE,
    CHECK (Fecha_Llegada >= Fecha_Salida)
);

-- Alojamientos
CREATE TABLE Alojamiento (
    ID_Alojamiento INT PRIMARY KEY AUTO_INCREMENT,
    Ciudad VARCHAR(100),
    Nombre_Hotel VARCHAR(100),
    Estrellas INT CHECK (Estrellas BETWEEN 1 AND 5),
    Direccion VARCHAR(255),
    Cantidad_Habitaciones INT,
    Cantidad_Personas INT,
    Fecha_Entrada DATE,
    Fecha_Salida DATE,
    Fotos TEXT,
    Servicios TEXT
);

-- Traslados
CREATE TABLE Traslado (
    ID_Traslado INT PRIMARY KEY AUTO_INCREMENT,
    Origen VARCHAR(100),
    Destino VARCHAR(100),
    Tipo_Transporte ENUM('Carro', 'Van', 'Bus'),
    Maximo_Personas INT,
    Fecha DATE,
    Hora TIME,
    Aerolinea VARCHAR(100),
    Numero_Vuelo VARCHAR(20)
);

-- Actividades
CREATE TABLE Actividad (
    ID_Actividad INT PRIMARY KEY AUTO_INCREMENT,
    Destino VARCHAR(100),
    Titulo VARCHAR(100),
    Descripcion TEXT,
    Incluye_Traslado BOOLEAN,
    Estrellas INT CHECK (Estrellas BETWEEN 1 AND 5),
    Comentarios TEXT,
    Precio DECIMAL(10,2),
    Duracion_Horas INT,
    Fecha_Inicio DATE,
    Fecha_Fin DATE
);

-- 5. Microservicio Carrito de compra 

CREATE DATABASE Carrito_ViajesGlobal;
USE Carrito_ViajesGlobal;

-- Tabla principal del carrito
CREATE TABLE Carrito (
    ID_Carrito INT PRIMARY KEY AUTO_INCREMENT,
    ID_Usuario INT NOT NULL,  -- Relación con el microservicio de usuarios
    Estado ENUM('Activo', 'Pagado', 'Cancelado') DEFAULT 'Activo',
    Fecha_Creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Total DECIMAL(10, 2) DEFAULT 0.00,
    Cupon_Aplicado VARCHAR(100)  -- Cupon validado por el microservicio de promociones
--    FOREIGN KEY (Cupon_Aplicado) REFERENCES Descuento(Cupon)
);

-- Items dentro del carrito
CREATE TABLE Item_Carrito (
    ID_Item INT PRIMARY KEY AUTO_INCREMENT,
    ID_Carrito INT NOT NULL,
    Tipo_Item ENUM('Vuelo', 'Alojamiento', 'Actividad', 'Traslado'),
    ID_Referencia INT NOT NULL,  -- Relación con la reserva específica (ID del vuelo, hotel, etc.)
    Precio DECIMAL(10, 2),
    Cantidad INT DEFAULT 1
  -- FOREIGN KEY (ID_Carrito) REFERENCES Carrito(ID_Carrito)
);

