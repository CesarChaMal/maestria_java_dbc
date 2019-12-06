DROP DATABASE IF EXISTS my_transport_assistant;
-- SET ANSI_WARNINGS OFF
CREATE DATABASE my_transport_assistant;
USE my_transport_assistant;
-- SET ANSI_WARNINGS OFF

DROP TABLE IF EXISTS users;
CREATE TABLE users (
	id INTEGER NOT NULL,
	userName VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL,
	firstName VARCHAR(30) NOT NULL,
	lastName VARCHAR(30) NOT NULL,
    enabled binary(1) NOT NULL default 1,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS roles;
CREATE TABLE roles (
	id INTEGER NOT NULL,
	name VARCHAR(20) NOT NULL,
	description VARCHAR(20) NOT NULL,
	CONSTRAINT roles_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS modules;
CREATE TABLE modules (
	id INTEGER NOT NULL,
    idrol INTEGER NOT NULL,
 	name VARCHAR(20) NOT NULL,
	description VARCHAR(40) NOT NULL,
	CONSTRAINT modules_pkey PRIMARY KEY (id)
);

-- DROP TABLE detalles_personas CASCADE;
ALTER TABLE modules
	ADD CONSTRAINT modules_roles FOREIGN KEY (idrol) REFERENCES roles(id) ON UPDATE CASCADE ON DELETE CASCADE;
