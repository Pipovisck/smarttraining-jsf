--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.11
-- Dumped by pg_dump version 9.3.11
-- Started on 2018-09-04 11:54:04

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2072 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 171 (class 1259 OID 27003)
-- Name: Aluno; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Aluno" (
    cod_cpf character varying(11) NOT NULL
);


ALTER TABLE public."Aluno" OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 27068)
-- Name: Aparelho; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Aparelho" (
    nro_aparelho smallint NOT NULL,
    nom_aparelho character varying NOT NULL
);


ALTER TABLE public."Aparelho" OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 27076)
-- Name: AparelhoExercicio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "AparelhoExercicio" (
    cod_exercicio integer NOT NULL,
    nro_aparelho smallint NOT NULL,
    img_execucao bigint NOT NULL
);


ALTER TABLE public."AparelhoExercicio" OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 27032)
-- Name: Avaliacao; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Avaliacao" (
    cod_cpf character varying(11) NOT NULL,
    dat_avaliacao date NOT NULL,
    cod_cpf_instrutor character varying(11) NOT NULL,
    idt_recencia boolean NOT NULL,
    qtd_peso numeric(5,2) NOT NULL,
    "qtd_massaGorda" numeric(5,2) NOT NULL,
    "qtd_percGordura" numeric(5,2) NOT NULL,
    tam_pescoco numeric(6,2) NOT NULL,
    tam_ombro numeric(6,2) NOT NULL,
    tam_torax numeric(6,2) NOT NULL,
    tam_abdomen numeric(6,2) NOT NULL,
    tam_cintura numeric(6,2) NOT NULL,
    tam_quadril numeric(6,2) NOT NULL,
    "tam_bracoEsq" numeric(6,2) NOT NULL,
    "tam_bracoDir" numeric(6,2) NOT NULL,
    "tam_antebracoEsq" numeric(6,2) NOT NULL,
    "tam_antebracoDir" numeric(6,2) NOT NULL,
    "tam_coxaEsq" numeric(6,2) NOT NULL,
    "tam_coxaDir" numeric(6,2) NOT NULL,
    "tam_panturrilhaEsq" numeric(6,2) NOT NULL,
    "tam_panturrilhaDir" numeric(6,2) NOT NULL
);


ALTER TABLE public."Avaliacao" OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 27099)
-- Name: DiaTreino; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "DiaTreino" (
    cod_exercicio integer NOT NULL,
    nro_aparelho smallint NOT NULL,
    cod_cpf character varying(11) NOT NULL,
    nro_treino smallint NOT NULL,
    nro_ficha integer NOT NULL,
    dat_treino date NOT NULL
);


ALTER TABLE public."DiaTreino" OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 27020)
-- Name: Exercicio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Exercicio" (
    cod_exercicio integer NOT NULL,
    nom_exercicio character varying(20) NOT NULL,
    des_exercicio character varying(50) NOT NULL
);


ALTER TABLE public."Exercicio" OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 27018)
-- Name: Exercicio_cod_exercicio_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Exercicio_cod_exercicio_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Exercicio_cod_exercicio_seq" OWNER TO postgres;

--
-- TOC entry 2073 (class 0 OID 0)
-- Dependencies: 174
-- Name: Exercicio_cod_exercicio_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Exercicio_cod_exercicio_seq" OWNED BY "Exercicio".cod_exercicio;


--
-- TOC entry 176 (class 1259 OID 27026)
-- Name: Ficha; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Ficha" (
    cod_cpf character varying(11) NOT NULL,
    nro_ficha integer NOT NULL,
    cod_cpf_instrutor character varying(11) NOT NULL,
    dat_ficha date NOT NULL,
    dat_prevista_troca date NOT NULL,
    idt_treino character varying(1) NOT NULL
);


ALTER TABLE public."Ficha" OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 27008)
-- Name: Instrutor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Instrutor" (
    cod_cpf character varying(11) NOT NULL,
    nro_cref character varying(11) NOT NULL
);


ALTER TABLE public."Instrutor" OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 27046)
-- Name: Musculo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Musculo" (
    cod_musculo bigint NOT NULL,
    "cod_regCorp" bigint,
    nom_musculo character varying NOT NULL,
    img_musculo bigint NOT NULL
);


ALTER TABLE public."Musculo" OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 27063)
-- Name: MusculoExercicio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "MusculoExercicio" (
    cod_exercicio integer NOT NULL,
    cod_musculo bigint NOT NULL
);


ALTER TABLE public."MusculoExercicio" OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 27086)
-- Name: Objetivo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Objetivo" (
    cod_objetivo bigint NOT NULL,
    nom_objetivo character varying NOT NULL,
    des_objetivo character varying NOT NULL
);


ALTER TABLE public."Objetivo" OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 27094)
-- Name: ObjetivoAvaliacao; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "ObjetivoAvaliacao" (
    dat_avaliacao date NOT NULL,
    cod_cpf character varying(11) NOT NULL,
    cod_objetivo bigint NOT NULL
);


ALTER TABLE public."ObjetivoAvaliacao" OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 27055)
-- Name: RegiaoCorporal; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "RegiaoCorporal" (
    "cod_regCorp" bigint NOT NULL,
    "nom_regCorp" character varying NOT NULL
);


ALTER TABLE public."RegiaoCorporal" OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 27038)
-- Name: Treino; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Treino" (
    cod_cpf character varying(11) NOT NULL,
    nro_ficha integer NOT NULL,
    nro_treino smallint NOT NULL,
    des_treino character varying NOT NULL
);


ALTER TABLE public."Treino" OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 27081)
-- Name: TreinoExercicio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "TreinoExercicio" (
    cod_cpf character varying(11) NOT NULL,
    nro_treino smallint NOT NULL,
    cod_exercicio integer NOT NULL,
    nro_aparelho smallint NOT NULL,
    nro_ficha integer NOT NULL,
    nro_series smallint NOT NULL,
    nro_repeticoes character varying(6) NOT NULL,
    qtd_peso integer NOT NULL
);


ALTER TABLE public."TreinoExercicio" OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 27013)
-- Name: Usuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Usuario" (
    cod_cpf character varying(11) NOT NULL,
    nom_usuario character varying(50) NOT NULL,
    idt_tipo_usuario character varying(1) NOT NULL,
    txt_senha character varying(20) NOT NULL,
    des_email character varying(30) NOT NULL,
    dat_nascimento date NOT NULL
);


ALTER TABLE public."Usuario" OWNER TO postgres;

--
-- TOC entry 1888 (class 2604 OID 27023)
-- Name: cod_exercicio; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Exercicio" ALTER COLUMN cod_exercicio SET DEFAULT nextval('"Exercicio_cod_exercicio_seq"'::regclass);


--
-- TOC entry 2048 (class 0 OID 27003)
-- Dependencies: 171
-- Data for Name: Aluno; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "Aluno" VALUES ('00000000000');


--
-- TOC entry 2059 (class 0 OID 27068)
-- Dependencies: 182
-- Data for Name: Aparelho; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "Aparelho" VALUES (1, 'Banco Flexor');


--
-- TOC entry 2060 (class 0 OID 27076)
-- Dependencies: 183
-- Data for Name: AparelhoExercicio; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2054 (class 0 OID 27032)
-- Dependencies: 177
-- Data for Name: Avaliacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "Avaliacao" VALUES ('00000000000', '2018-09-04', '11111111111', true, 24.00, 11.00, 21.00, 9.00, 12.00, 8.00, 20.00, 17.00, 26.00, 18.00, 19.00, 24.00, 17.00, 25.00, 18.00, 24.00, 15.00);


--
-- TOC entry 2064 (class 0 OID 27099)
-- Dependencies: 187
-- Data for Name: DiaTreino; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2052 (class 0 OID 27020)
-- Dependencies: 175
-- Data for Name: Exercicio; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "Exercicio" VALUES (2, 'Agaxamento', 'AGAXAAAAAAAAAAAAAAAA');
INSERT INTO "Exercicio" VALUES (1, 'Flexion des Jambes', 'Flexiona AAAAAAAAA');


--
-- TOC entry 2074 (class 0 OID 0)
-- Dependencies: 174
-- Name: Exercicio_cod_exercicio_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Exercicio_cod_exercicio_seq"', 2, true);


--
-- TOC entry 2053 (class 0 OID 27026)
-- Dependencies: 176
-- Data for Name: Ficha; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2049 (class 0 OID 27008)
-- Dependencies: 172
-- Data for Name: Instrutor; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "Instrutor" VALUES ('11111111111', '12312312323');


--
-- TOC entry 2056 (class 0 OID 27046)
-- Dependencies: 179
-- Data for Name: Musculo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "Musculo" VALUES (1, 1, 'Quadríceps', 1);


--
-- TOC entry 2058 (class 0 OID 27063)
-- Dependencies: 181
-- Data for Name: MusculoExercicio; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "MusculoExercicio" VALUES (1, 1);
INSERT INTO "MusculoExercicio" VALUES (2, 1);


--
-- TOC entry 2062 (class 0 OID 27086)
-- Dependencies: 185
-- Data for Name: Objetivo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "Objetivo" VALUES (1, 'Fika maromba', 'Deixar de ser felipe');


--
-- TOC entry 2063 (class 0 OID 27094)
-- Dependencies: 186
-- Data for Name: ObjetivoAvaliacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "ObjetivoAvaliacao" VALUES ('2018-09-04', '00000000000', 1);


--
-- TOC entry 2057 (class 0 OID 27055)
-- Dependencies: 180
-- Data for Name: RegiaoCorporal; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "RegiaoCorporal" VALUES (1, 'Perna');


--
-- TOC entry 2055 (class 0 OID 27038)
-- Dependencies: 178
-- Data for Name: Treino; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2061 (class 0 OID 27081)
-- Dependencies: 184
-- Data for Name: TreinoExercicio; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2050 (class 0 OID 27013)
-- Dependencies: 173
-- Data for Name: Usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "Usuario" VALUES ('11111111111', 'Instrutor', 'I', '123', 'teste@teste.com', '2001-04-25');
INSERT INTO "Usuario" VALUES ('00000000000', 'Aluno', 'A', '123', 'a@a.com', '2001-04-25');


--
-- TOC entry 1904 (class 2606 OID 27045)
-- Name: Key14; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Treino"
    ADD CONSTRAINT "Key14" PRIMARY KEY (cod_cpf, nro_treino, nro_ficha);


--
-- TOC entry 1907 (class 2606 OID 27054)
-- Name: Key16; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Musculo"
    ADD CONSTRAINT "Key16" PRIMARY KEY (cod_musculo);


--
-- TOC entry 1909 (class 2606 OID 27062)
-- Name: Key17; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "RegiaoCorporal"
    ADD CONSTRAINT "Key17" PRIMARY KEY ("cod_regCorp");


--
-- TOC entry 1911 (class 2606 OID 27067)
-- Name: Key18; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "MusculoExercicio"
    ADD CONSTRAINT "Key18" PRIMARY KEY (cod_exercicio, cod_musculo);


--
-- TOC entry 1913 (class 2606 OID 27075)
-- Name: Key19; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Aparelho"
    ADD CONSTRAINT "Key19" PRIMARY KEY (nro_aparelho);


--
-- TOC entry 1890 (class 2606 OID 27007)
-- Name: Key2; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Aluno"
    ADD CONSTRAINT "Key2" PRIMARY KEY (cod_cpf);


--
-- TOC entry 1915 (class 2606 OID 27080)
-- Name: Key20; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "AparelhoExercicio"
    ADD CONSTRAINT "Key20" PRIMARY KEY (cod_exercicio, nro_aparelho);


--
-- TOC entry 1917 (class 2606 OID 27085)
-- Name: Key21; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "TreinoExercicio"
    ADD CONSTRAINT "Key21" PRIMARY KEY (cod_exercicio, nro_aparelho, cod_cpf, nro_treino, nro_ficha);


--
-- TOC entry 1919 (class 2606 OID 27093)
-- Name: Key22; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Objetivo"
    ADD CONSTRAINT "Key22" PRIMARY KEY (cod_objetivo);


--
-- TOC entry 1921 (class 2606 OID 27098)
-- Name: Key23; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "ObjetivoAvaliacao"
    ADD CONSTRAINT "Key23" PRIMARY KEY (cod_objetivo, cod_cpf, dat_avaliacao);


--
-- TOC entry 1923 (class 2606 OID 27103)
-- Name: Key24; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "DiaTreino"
    ADD CONSTRAINT "Key24" PRIMARY KEY (cod_exercicio, nro_aparelho, cod_cpf, nro_treino, dat_treino, nro_ficha);


--
-- TOC entry 1892 (class 2606 OID 27012)
-- Name: Key3; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Instrutor"
    ADD CONSTRAINT "Key3" PRIMARY KEY (cod_cpf);


--
-- TOC entry 1894 (class 2606 OID 27017)
-- Name: Key5; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Usuario"
    ADD CONSTRAINT "Key5" PRIMARY KEY (cod_cpf);


--
-- TOC entry 1896 (class 2606 OID 27025)
-- Name: Key6; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Exercicio"
    ADD CONSTRAINT "Key6" PRIMARY KEY (cod_exercicio);


--
-- TOC entry 1899 (class 2606 OID 27031)
-- Name: Key7; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Ficha"
    ADD CONSTRAINT "Key7" PRIMARY KEY (cod_cpf, nro_ficha);


--
-- TOC entry 1902 (class 2606 OID 27037)
-- Name: Key8; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Avaliacao"
    ADD CONSTRAINT "Key8" PRIMARY KEY (cod_cpf, dat_avaliacao);


--
-- TOC entry 1897 (class 1259 OID 27029)
-- Name: IX_Relationship11; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX "IX_Relationship11" ON "Ficha" USING btree (cod_cpf_instrutor);


--
-- TOC entry 1900 (class 1259 OID 27035)
-- Name: IX_Relationship13; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX "IX_Relationship13" ON "Avaliacao" USING btree (cod_cpf_instrutor);


--
-- TOC entry 1905 (class 1259 OID 27052)
-- Name: IX_Relationship20; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX "IX_Relationship20" ON "Musculo" USING btree ("cod_regCorp");


--
-- TOC entry 1927 (class 2606 OID 27119)
-- Name: Relationship11; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Ficha"
    ADD CONSTRAINT "Relationship11" FOREIGN KEY (cod_cpf_instrutor) REFERENCES "Instrutor"(cod_cpf) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1928 (class 2606 OID 27124)
-- Name: Relationship12; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Avaliacao"
    ADD CONSTRAINT "Relationship12" FOREIGN KEY (cod_cpf) REFERENCES "Aluno"(cod_cpf) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1929 (class 2606 OID 27129)
-- Name: Relationship13; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Avaliacao"
    ADD CONSTRAINT "Relationship13" FOREIGN KEY (cod_cpf_instrutor) REFERENCES "Instrutor"(cod_cpf) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1930 (class 2606 OID 27134)
-- Name: Relationship17; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Treino"
    ADD CONSTRAINT "Relationship17" FOREIGN KEY (cod_cpf, nro_ficha) REFERENCES "Ficha"(cod_cpf, nro_ficha) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1931 (class 2606 OID 27139)
-- Name: Relationship20; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Musculo"
    ADD CONSTRAINT "Relationship20" FOREIGN KEY ("cod_regCorp") REFERENCES "RegiaoCorporal"("cod_regCorp") ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1932 (class 2606 OID 27144)
-- Name: Relationship21; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "MusculoExercicio"
    ADD CONSTRAINT "Relationship21" FOREIGN KEY (cod_exercicio) REFERENCES "Exercicio"(cod_exercicio) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1933 (class 2606 OID 27149)
-- Name: Relationship22; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "MusculoExercicio"
    ADD CONSTRAINT "Relationship22" FOREIGN KEY (cod_musculo) REFERENCES "Musculo"(cod_musculo) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1934 (class 2606 OID 27154)
-- Name: Relationship23; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "AparelhoExercicio"
    ADD CONSTRAINT "Relationship23" FOREIGN KEY (cod_exercicio) REFERENCES "Exercicio"(cod_exercicio) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1935 (class 2606 OID 27159)
-- Name: Relationship24; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "AparelhoExercicio"
    ADD CONSTRAINT "Relationship24" FOREIGN KEY (nro_aparelho) REFERENCES "Aparelho"(nro_aparelho) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1936 (class 2606 OID 27164)
-- Name: Relationship25; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "TreinoExercicio"
    ADD CONSTRAINT "Relationship25" FOREIGN KEY (cod_exercicio, nro_aparelho) REFERENCES "AparelhoExercicio"(cod_exercicio, nro_aparelho) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1937 (class 2606 OID 27169)
-- Name: Relationship26; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "TreinoExercicio"
    ADD CONSTRAINT "Relationship26" FOREIGN KEY (cod_cpf, nro_treino, nro_ficha) REFERENCES "Treino"(cod_cpf, nro_treino, nro_ficha) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1938 (class 2606 OID 27174)
-- Name: Relationship27; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "ObjetivoAvaliacao"
    ADD CONSTRAINT "Relationship27" FOREIGN KEY (cod_objetivo) REFERENCES "Objetivo"(cod_objetivo) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1939 (class 2606 OID 27179)
-- Name: Relationship28; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "ObjetivoAvaliacao"
    ADD CONSTRAINT "Relationship28" FOREIGN KEY (cod_cpf, dat_avaliacao) REFERENCES "Avaliacao"(cod_cpf, dat_avaliacao) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1940 (class 2606 OID 27184)
-- Name: Relationship29; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "DiaTreino"
    ADD CONSTRAINT "Relationship29" FOREIGN KEY (cod_exercicio, nro_aparelho, cod_cpf, nro_treino, nro_ficha) REFERENCES "TreinoExercicio"(cod_exercicio, nro_aparelho, cod_cpf, nro_treino, nro_ficha) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1924 (class 2606 OID 27104)
-- Name: Relationship6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Aluno"
    ADD CONSTRAINT "Relationship6" FOREIGN KEY (cod_cpf) REFERENCES "Usuario"(cod_cpf) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1925 (class 2606 OID 27109)
-- Name: Relationship7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Instrutor"
    ADD CONSTRAINT "Relationship7" FOREIGN KEY (cod_cpf) REFERENCES "Usuario"(cod_cpf) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1926 (class 2606 OID 27114)
-- Name: Relationship9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Ficha"
    ADD CONSTRAINT "Relationship9" FOREIGN KEY (cod_cpf) REFERENCES "Aluno"(cod_cpf) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2071 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2018-09-04 11:54:04

--
-- PostgreSQL database dump complete
--

