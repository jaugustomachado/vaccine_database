DROP DATABASE IF EXISTS vaccine_database;
CREATE DATABASE IF NOT EXISTS vaccine_database;

DROP TABLE IF EXISTS vaccine_database.vaccine_pessoa;
CREATE TABLE IF NOT EXISTS vaccine_database.vaccine_pessoa (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    data_nascimento DATE NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    CONSTRAINT pk_pessoa PRIMARY KEY (id),
    CONSTRAINT uk_cpf UNIQUE KEY (cpf),
    CONSTRAINT only_numbers_cpf CHECK (cpf REGEXP '^[0-9]{11}$')
);

DROP TABLE IF EXISTS vaccine_database.vaccine_tipo;
CREATE TABLE vaccine_database.vaccine_tipo (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    tipo VARCHAR(100) NOT NULL,
    quantidade_dose INT(1) NOT NULL,
    intervalo_dose INT(2) NOT NULL,
    CONSTRAINT pk_vaccine_tipo PRIMARY KEY (id),
    CONSTRAINT uk_vaccine_tipo UNIQUE KEY (tipo)
);

INSERT INTO vaccine_database.vaccine_tipo(tipo) VALUES ('CoronaVac');
INSERT INTO vaccine_database.vaccine_tipo(tipo) VALUES ('Pfizer');
INSERT INTO vaccine_database.vaccine_tipo(tipo) VALUES ('AstraZeneca');
INSERT INTO vaccine_database.vaccine_tipo(tipo) VALUES ('Janssen');

DROP TABLE IF EXISTS vaccine_database.vaccine_dose;
CREATE TABLE vaccine_database.vaccine_dose (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    numero INT(1) NOT NULL,
    data_vacinacao DATE NOT NULL,
    CONSTRAINT pk_vaccine_dose PRIMARY KEY (id)
);

DROP TABLE IF EXISTS vaccine_database.vaccine_local;
CREATE TABLE vaccine_database.vaccine_local (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome_posto VARCHAR(100) NOT NULL,
    bairro_vacinacao VARCHAR(100) NOT NULL,
    CONSTRAINT pk_vaccine_local PRIMARY KEY (id)
);

DROP TABLE IF EXISTS vaccine_database.vaccine_enfermeiro;
CREATE TABLE vaccine_database.vaccine_enfermeiro (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    coren VARCHAR(6) NOT NULL,
    estado_coren VARCHAR(2) NOT NULL,
    CONSTRAINT pk_vaccine_enfermeiro PRIMARY KEY (id),
	CONSTRAINT only_numbers_coren CHECK (coren REGEXP '^[0-9]{6}$'),
	CONSTRAINT begin_zero_coren CHECK (coren LIKE '0%')
);






