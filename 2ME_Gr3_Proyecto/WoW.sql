CREATE DATABASE IF NOT EXISTS WoW;
USE WoW;

CREATE TABLE IF NOT EXISTS personajes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    clase VARCHAR(20) NOT NULL,
    salud_actual INT NOT NULL,
    salud_maxima INT NOT NULL,
    experiencia INT NOT NULL,
    fuerza INT NULL,
    agilidad INT NULL,
    vinculo_espiritual INT NULL,
    estado_especial BOOLEAN NULL
);