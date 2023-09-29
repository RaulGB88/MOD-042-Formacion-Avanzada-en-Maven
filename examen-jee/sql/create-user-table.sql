CREATE DATABASE examen;
USE examen;

create table usuario (
	id  INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL,
	fechaNacimiento DATE NOT NULL
);

INSERT INTO people(nombre,email,birth_date)
VALUES('Juan Perez','juan@gmail.com','1920-01-01');

INSERT INTO people(nombre,email,birth_date)
VALUES('Paco Coyote','paco@gmail.com','1974-09-01');

INSERT INTO people(nombre,email,birth_date)
VALUES('Raul De La Torre','raul@gmail.com','1935-06-01');

INSERT INTO people(nombre,email,birth_date)
VALUES('John Lennon','john@gmail.com','1969-08-01');


