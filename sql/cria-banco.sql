--
-- PostgreSQL database dump - NetCItacoes
--
-- Eduardo Cerqueira
-- Fernando Boaglio
--
-- MundoJ -
--

SET statement_timeout = 0;
SET client_encoding = 'SQL_ASCII';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

CREATE TABLE citacao (
    id bigint NOT NULL,
    autor character varying(255),
    citacao character varying(255),
    usuario_id bigint
);



CREATE TABLE comentario (
    id bigint NOT NULL,
    comentario character varying(255),
    nome character varying(255),
    citacao_id bigint
);


CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE usuario (
    id bigint NOT NULL,
    email character varying(255),
    isadmin boolean NOT NULL,
    nome character varying(255),
    senha character varying(255)
);


INSERT INTO citacao (id, autor, citacao, usuario_id) VALUES (6, 'AJ Carpio', 'Quando a vida te traz perguntas, o Goggle te traz respostas', 3);
INSERT INTO citacao (id, autor, citacao, usuario_id) VALUES (7, ' Isaac Asimov', 'Eu não temo os computadores, eu temo a ausência deles.', 2);
INSERT INTO citacao (id, autor, citacao, usuario_id) VALUES (8, 'Bill Gates', 'O computador nasceu para resolver problemas que não existiam antes', 4);
INSERT INTO citacao (id, autor, citacao, usuario_id) VALUES (9, 'Alan Bennett', 'Os padrões estão sempre defasados. É isso que os torna padrões.', 5);


INSERT INTO comentario (id, comentario, nome, citacao_id) VALUES (10, 'eu também!', 'Fernando Boaglio', 7);
INSERT INTO comentario (id, comentario, nome, citacao_id) VALUES (11, 'Com certeza!', 'Eduardo Cerqueira', 9);


SELECT pg_catalog.setval('hibernate_sequence', 11, true);

INSERT INTO usuario (id, email, isadmin, nome, senha) VALUES (1, 'admin@netcitacoes.com.br', true, 'admin', 'webstart');
INSERT INTO usuario (id, email, isadmin, nome, senha) VALUES (3, 'eduardo@webstart.com.br', false, 'Eduardo Cerqueira', 'webstart');
INSERT INTO usuario (id, email, isadmin, nome, senha) VALUES (4, 'eliana@webstart.com.br', false, 'Eliana Boaglio', 'webstart.');
INSERT INTO usuario (id, email, isadmin, nome, senha) VALUES (5, 'karina@webstart.com.br', false, 'Karina Baccili', 'webstart');
INSERT INTO usuario (id, email, isadmin, nome, senha) VALUES (2, 'fernando@webstart.com.br', false, 'Fernando Boaglio', 'webstart');


ALTER TABLE ONLY citacao
    ADD CONSTRAINT citacao_pkey PRIMARY KEY (id);


ALTER TABLE ONLY comentario
    ADD CONSTRAINT comentario_pkey PRIMARY KEY (id);


ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


ALTER TABLE ONLY comentario
    ADD CONSTRAINT fk_com_citacao FOREIGN KEY (citacao_id) REFERENCES citacao(id);


ALTER TABLE ONLY citacao
    ADD CONSTRAINT fk_cit_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id);

--
-- PostgreSQL database dump complete
--

