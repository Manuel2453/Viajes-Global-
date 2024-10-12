create database ViajesGlobal;
Use ViajesGlobal;

CREATE TABLE Usuario (
    ID_Usuario INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100),
    Correo_Electronico VARCHAR(255),
    Usuario VARCHAR(255),
    Contrasena VARCHAR(100),
    Preferencias_Notificacion VARCHAR(255)
);

CREATE TABLE PaqueteTuristico (
    ID_Paquete INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100),
    Descripcion TEXT,
    Precio DECIMAL(10, 2),
    Destino VARCHAR(100),
    Fechas VARCHAR(255),
    Servicios_Incluidos TEXT
);

CREATE TABLE Reserva (
    ID_Reserva INT PRIMARY KEY AUTO_INCREMENT,
    Fecha_Reserva DATE,
    Estado VARCHAR(50),
    Cantidad_Personas INT,
    Precio_Total DECIMAL(10, 2),
    ID_Usuario INT,
    ID_Paquete INT,
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario),
    FOREIGN KEY (ID_Paquete) REFERENCES PaqueteTuristico(ID_Paquete)
);

CREATE TABLE Notificacion (
    ID_Notificacion INT PRIMARY KEY AUTO_INCREMENT,
    Fecha_Envio DATE,
    Tipo VARCHAR(50),
    Contenido TEXT,
    ID_Usuario INT,
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario)
);

CREATE TABLE Pago (
    ID_Pago INT PRIMARY KEY AUTO_INCREMENT,
    Fecha_Pago DATE,
    Monto DECIMAL(10, 2),
    Estado VARCHAR(50),
    Metodo_Pago VARCHAR(50),
    ID_Reserva INT,
    FOREIGN KEY (ID_Reserva) REFERENCES Reserva(ID_Reserva)
);

CREATE TABLE Vuelo (
    ID_Vuelo INT PRIMARY KEY AUTO_INCREMENT,
    Aerolinea VARCHAR(100),
    Origen VARCHAR(100),
    Destino VARCHAR(100),
    Fecha_Salida DATE,
    Fecha_Llegada DATE,
    ID_Paquete INT,
    FOREIGN KEY (ID_Paquete) REFERENCES PaqueteTuristico(ID_Paquete)
);

CREATE TABLE Hotel (
    ID_Hotel INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100),
    Direccion VARCHAR(255),
    Ciudad VARCHAR(100),
    Categoria VARCHAR(50),
    ID_Paquete INT,
    FOREIGN KEY (ID_Paquete) REFERENCES PaqueteTuristico(ID_Paquete)
);

CREATE TABLE Actividad (
    ID_Actividad INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100),
    Descripcion TEXT,
    Destino VARCHAR(100),
    Fecha DATE,
    Hora TIME,
    Precio DECIMAL(10, 2),
    ID_Paquete INT,
    FOREIGN KEY (ID_Paquete) REFERENCES PaqueteTuristico(ID_Paquete)
);

CREATE TABLE Transporte (
    ID_Transporte INT PRIMARY KEY AUTO_INCREMENT,
    Tipo VARCHAR(100),
    Empresa VARCHAR(100),
    Origen VARCHAR(100),
    Destino VARCHAR(100),
    Fecha DATE,
    Precio te DECIMAL(10, 2),
    ID_Paquete INT,
    FOREIGN KEY (ID_Paquete) REFERENCES PaqueteTuristico(ID_Paquete)
);


-- Paquetes Turísticos
INSERT INTO PaqueteTuristico (Nombre, Descripcion, Precio, Destino, Fechas, Servicios_Incluidos) VALUES
('Aventura en los Andes', 'Paquete de 5 días en la montaña', 2500.000, 'Andes', '2024-11-01 al 2024-11-05', 'Alojamiento, Transporte, Actividades'),
('Sol y Playa', 'Paquete de 7 días en la playa', 6000.000, 'Caribe', '2024-12-01 al 2024-12-07', 'Alojamiento, Transporte, Comidas'),
('Tour por Europa', 'Paquete de 10 días por las principales capitales europeas', 18000.000, 'Europa', '2025-01-10 al 2025-01-20', 'Vuelo, Alojamiento, Guía'),
('Safari en África', 'Paquete de 7 días de safari en África', 25000.000, 'África', '2025-02-15 al 2025-02-22', 'Transporte, Alojamiento, Actividades'),
('Escapada a la Selva', 'Paquete de 3 días en la selva', 5000.000, 'Amazonas', '2024-10-20 al 2024-10-23', 'Transporte, Alojamiento, Comidas');

-- Reservas
INSERT INTO Reserva (Fecha_Reserva, Estado, Cantidad_Personas, Precio_Total, ID_Usuario, ID_Paquete) VALUES
('2024-09-15', 'Confirmada', 2, 3000.00, 1, 1),
('2024-09-16', 'Pendiente', 1, 2000.00, 2, 2),
('2024-09-17', 'Cancelada', 3, 6000.00, 3, 3),
('2024-09-18', 'Confirmada', 2, 5000.00, 4, 4),
('2024-09-19', 'Pendiente', 1, 1000.00, 5, 5);

-- Notificaciones
INSERT INTO Notificacion (Fecha_Envio, Tipo, Contenido, ID_Usuario) VALUES
('2024-09-15', 'Correo', 'Tu reserva ha sido confirmada', 1),
('2024-09-16', 'SMS', 'Tu reserva está pendiente', 2),
('2024-09-17', 'Push', 'Tu reserva ha sido cancelada', 3),
('2024-09-18', 'Correo', 'Tu reserva ha sido confirmada', 4),
('2024-09-19', 'Push', 'Tu reserva está pendiente', 5);

-- Pagos
INSERT INTO Pago (Fecha_Pago, Monto, Estado, Metodo_Pago, ID_Reserva) VALUES
('2024-09-15', 3000.000, 'Completado', 'Tarjeta de Crédito', 1),
('2024-09-16', 2000.000, 'Pendiente', 'PayPal', 2),
('2024-09-17', 6000.000, 'Reembolsado', 'Tarjeta de Crédito', 3),
('2024-09-18', 5000.000, 'Completado', 'Transferencia Bancaria', 4),
('2024-09-19', 10000.000, 'Pendiente', 'Tarjeta de Crédito', 5);

-- Vuelos
INSERT INTO Vuelo (Aerolinea, Origen, Destino, Fecha_Salida, Fecha_Llegada, ID_Paquete) VALUES
('LATAM', 'Bogotá', 'Lima', '2024-11-01', '2024-11-01', 1),
('Avianca', 'Bogotá', 'Cartagena', '2024-12-01', '2024-12-01', 2),
('Air France', 'París', 'Roma', '2025-01-10', '2025-01-10', 3),
('Emirates', 'Dubái', 'Nairobi', '2025-02-15', '2025-02-15', 4),
('LATAM', 'Bogotá', 'Leticia', '2024-10-20', '2024-10-20', 5);

-- Hoteles
INSERT INTO Hotel (Nombre, Direccion, Ciudad, Categoria, ID_Paquete) VALUES
('Hotel Andes', 'Calle 123, Andes', 'Andes', '4 Estrellas', 1),
('Hotel Caribe', 'Avenida Playa, Caribe', 'Caribe', '5 Estrellas', 2),
('Hotel Europa', 'Boulevard, París', 'París', '3 Estrellas', 3),
('Safari Lodge', 'Ruta 56, Nairobi', 'Nairobi', '5 Estrellas', 4),
('Selva Lodge', 'Calle Jungla, Amazonas', 'Amazonas', '4 Estrellas', 5);

-- Actividades
INSERT INTO Actividad (Nombre, Descripcion, Destino, Fecha, Hora, Precio, ID_Paquete) VALUES
('Caminata por la Montaña', 'Recorrido guiado por la montaña', 'Andes', '2024-11-02', '09:00:00', 100.000, 1),
('Buceo en el Caribe', 'Buceo guiado en el arrecife', 'Caribe', '2024-12-03', '10:00:00', 400.000, 2),
('Tour por el Louvre', 'Visita guiada al museo', 'París', '2025-01-12', '14:00:00', 300.000, 3),
('Safari en Nairobi', 'Recorrido guiado por la sabana', 'Nairobi', '2025-02-16', '07:00:00', 600.000, 4),
('Paseo en Canoa', 'Paseo en canoa por el río Amazonas', 'Amazonas', '2024-10-21', '11:00:00', 80.000, 5);

-- Transporte
INSERT INTO Transporte (Tipo, Empresa, Origen, Destino, Fecha, Precio, ID_Paquete) VALUES
('Bus', 'AndesBus', 'Bogotá', 'Andes', '2024-11-01', 50.00, 1),
('Transporte Privado', 'CaribeTransport', 'Cartagena', 'Playa', '2024-12-01', 80.00, 2),
('Tren', 'EuroRail', 'París', 'Roma', '2025-01-10', 120.00, 3),
('Jeep Safari', 'SafariJeep', 'Nairobi', 'Sabana', '2025-02-15', 100.00, 4),
('Lancha', 'SelvaTransport', 'Leticia', 'Selva', '2024-10-20', 70.00, 5);
