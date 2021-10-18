DROP DATABASE IF EXISTS vaccine_database;
CREATE DATABASE IF NOT EXISTS vaccine_database;

DROP TABLE IF EXISTS vaccine_database.vaccine_pessoa;
CREATE TABLE IF NOT EXISTS vaccine_database.vaccine_pessoa (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    tipo_pessoa CHAR(1) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    data_nascimento DATETIME(6) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    numero_coren VARCHAR(6) NULL,
    estado_coren VARCHAR(2) NULL,
    CONSTRAINT PRIMARY KEY (id),
    CONSTRAINT UNIQUE_CPF UNIQUE KEY (cpf),
    CONSTRAINT only_numbers_cpf CHECK (cpf REGEXP '^[0-9]{11}$'),
    CONSTRAINT only_numbers_coren CHECK (numero_coren REGEXP '^[0-9]{6}$'),
    CONSTRAINT begin_zero_coren CHECK (numero_coren LIKE '0%')
);

DROP TABLE IF EXISTS vaccine_database.vaccine_tipo;
CREATE TABLE vaccine_database.vaccine_tipo (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    quantidade_doses INT NOT NULL,
    intervalo_doses INT NOT NULL,
    CONSTRAINT PRIMARY KEY (id),
    CONSTRAINT UNIQUE_NOME UNIQUE KEY (nome)
);

INSERT INTO vaccine_database.vaccine_tipo(nome, quantidade_doses, intervalo_doses) VALUES ('CoronaVac', 3, 21);
INSERT INTO vaccine_database.vaccine_tipo(nome, quantidade_doses, intervalo_doses) VALUES ('Pfizer', 2, 90);
INSERT INTO vaccine_database.vaccine_tipo(nome, quantidade_doses, intervalo_doses) VALUES ('AstraZeneca', 2, 90);
INSERT INTO vaccine_database.vaccine_tipo(nome, quantidade_doses, intervalo_doses) VALUES ('Janssen', 1, 0);


DROP TABLE IF EXISTS vaccine_database.vaccine_local;
CREATE TABLE vaccine_database.vaccine_local (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    CONSTRAINT PRIMARY KEY (id)
);


DROP TABLE IF EXISTS vaccine_database.vaccine_dose;
CREATE TABLE vaccine_database.vaccine_dose (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    data_vacinacao DATETIME(6) NOT NULL,
    ordem INT UNSIGNED NOT NULL,
	id_pessoa BIGINT UNSIGNED NOT NULL,
    id_enfermeiro BIGINT UNSIGNED NOT NULL,
    id_local_vacina BIGINT UNSIGNED NOT NULL,
    id_tipo_vacina BIGINT UNSIGNED NOT NULL,
    CONSTRAINT PRIMARY KEY (id),
    CONSTRAINT FOREIGN_PESSOA FOREIGN KEY (id_pessoa) REFERENCES vaccine_database.vaccine_pessoa(id),
    CONSTRAINT FOREIGN_ENFERMEIRO FOREIGN KEY (id_enfermeiro) REFERENCES vaccine_database.vaccine_pessoa(id),
    CONSTRAINT FOREIGN_LOCAL FOREIGN KEY (id_local_vacina) REFERENCES vaccine_database.vaccine_local(id),
    CONSTRAINT FOREIGN_TIPO FOREIGN KEY (id_tipo_vacina) REFERENCES vaccine_database.vaccine_tipo(id)
);