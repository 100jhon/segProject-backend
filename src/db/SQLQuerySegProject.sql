create database segProject;

use segProject;

-- Tabla de roles
CREATE TABLE rol (
    id_rol INT PRIMARY KEY IDENTITY(1,1),
    nombre VARCHAR(30) NOT NULL UNIQUE  -- Ej: 'Administrador', 'Empleado'
);

-- Tabla de empresas
CREATE TABLE empresa (
    id_empresa INT PRIMARY KEY IDENTITY(1,1),
    nombre VARCHAR(100) NOT NULL,
    nit VARCHAR(20) NOT NULL UNIQUE,
    correo_contacto VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    direccion VARCHAR(150)
);

-- Tabla de proyectos
CREATE TABLE proyecto (
    id_proyecto INT PRIMARY KEY IDENTITY(1,1),
    codigo_proyecto VARCHAR(20) NOT NULL UNIQUE,  -- identificador lógico
    nombre VARCHAR(40) NOT NULL,
    descripcion VARCHAR(100),
    id_empresa INT,
    id_estado INT,
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado),
    FOREIGN KEY (id_empresa) REFERENCES empresa(id_empresa)
);

-- Tabla intermedia para relación muchos a muchos entre usuario y proyecto
CREATE TABLE usuario_proyecto (
    id_usuario_proyecto INT PRIMARY KEY IDENTITY(1,1),
    id_usuario INT NOT NULL,
    id_proyecto INT NOT NULL,
    fecha_asignacion DATE DEFAULT CAST(GETDATE() AS DATE),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_proyecto) REFERENCES proyecto(id_proyecto),
    UNIQUE (id_usuario, id_proyecto)  -- Para evitar duplicidad
);

-- Tabla de usuarios
CREATE TABLE usuario (
    id_usuario INT PRIMARY KEY IDENTITY(1,1),
    primer_nombre VARCHAR(25),
    segundo_nombre VARCHAR(25),
    primer_apellido VARCHAR(25),
    segundo_apellido VARCHAR(25),
    correo VARCHAR(40) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    direccion VARCHAR(35),
    id_empresa INT,
    id_rol INT,
    FOREIGN KEY (id_empresa) REFERENCES empresa(id_empresa),
    FOREIGN KEY (id_rol) REFERENCES rol(id_rol)
);

-- Tabla de actividades
CREATE TABLE actividad (
    id_actividad INT PRIMARY KEY IDENTITY(1,1),
    nombre VARCHAR(30),
    historia_epica VARCHAR(20),
    historia_usuario VARCHAR(20),
    hora_estimada INT,
    codigo_proyecto VARCHAR(20),
	id_estado INT,
	FOREIGN KEY (id_estado) REFERENCES estado(id_estado),
    FOREIGN KEY (codigo_proyecto) REFERENCES proyecto(codigo_proyecto)
);


-- Tabla de tareas
CREATE TABLE tarea (
    id_tarea INT PRIMARY KEY IDENTITY(1,1),
    nombre VARCHAR(100),
    descripcion VARCHAR(255),
	hora_estimada INT NOT NULL,
	historia_epica VARCHAR(20),
	historia_usuario VARCHAR(20),
    id_estado INT,  -- ← Relación a estado_tarea
    id_actividad INT,
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado),
    FOREIGN KEY (id_actividad) REFERENCES actividad(id_actividad)
);


CREATE TABLE estado(
    id_estado INT PRIMARY KEY IDENTITY(1,1),
    estado VARCHAR(20) NOT NULL UNIQUE
);


-- Tabla de stopper
CREATE TABLE stopper (
    id_stopper INT PRIMARY KEY IDENTITY(1,1),
    motivo VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
	tiempo_stopper INT NOT NULL,
    id_tarea INT,
	 id_usuario INT
	FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_tarea) REFERENCES tarea(id_tarea)
);

-- Tabla de detalle diario de tareas
CREATE TABLE detalle_tarea (
    id_detalle_tarea INT PRIMARY KEY IDENTITY(1,1),
    fecha DATE DEFAULT CAST(GETDATE() AS DATE),
    horas_trabajadas INT,
    observaciones VARCHAR(255),
    id_tarea INT,
    id_usuario INT
	FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_tarea) REFERENCES tarea(id_tarea)
);
