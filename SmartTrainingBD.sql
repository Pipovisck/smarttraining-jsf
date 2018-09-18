-- Table Aluno

CREATE TABLE "Aluno"(
 "cod_cpf" Character varying(11) NOT NULL
)
;

-- Add keys for table Aluno

ALTER TABLE "Aluno" ADD CONSTRAINT "Key2" PRIMARY KEY ("cod_cpf")
;

-- Table Instrutor

CREATE TABLE "Instrutor"(
 "cod_cpf" Character varying(11) NOT NULL,
 "nro_cref" Character varying(11) NOT NULL
)
;

-- Add keys for table Instrutor

ALTER TABLE "Instrutor" ADD CONSTRAINT "Key3" PRIMARY KEY ("cod_cpf")
;

-- Table Usuario

CREATE TABLE "Usuario"(
 "cod_cpf" Character varying(11) NOT NULL,
 "nom_usuario" Character varying(50) NOT NULL,
 "idt_tipo_usuario" Character varying(1) NOT NULL,
 "txt_senha" Character varying(20) NOT NULL,
 "des_email" Character varying(30) NOT NULL,
 "dat_nascimento" Date NOT NULL
)
;

-- Add keys for table Usuario

ALTER TABLE "Usuario" ADD CONSTRAINT "Key5" PRIMARY KEY ("cod_cpf")
;

-- Table Exercicio

CREATE TABLE "Exercicio"(
 "cod_exercicio" Serial NOT NULL,
 "nom_exercicio" Character varying(20) NOT NULL,
 "des_exercicio" Character varying(50) NOT NULL
)
;

-- Add keys for table Exercicio

ALTER TABLE "Exercicio" ADD CONSTRAINT "Key6" PRIMARY KEY ("cod_exercicio")
;

-- Table Ficha

CREATE TABLE "Ficha"(
 "cod_cpf" Character varying(11) NOT NULL,
 "nro_ficha" Integer NOT NULL,
 "cod_cpf_instrutor" Character varying(11) NOT NULL,
 "dat_ficha" Date NOT NULL,
 "dat_prevista_troca" Date NOT NULL,
 "idt_treino" Character varying(1) NOT NULL
)
;

-- Create indexes for table Ficha

CREATE INDEX "IX_Relationship11" ON "Ficha" ("cod_cpf_instrutor")
;

-- Add keys for table Ficha

ALTER TABLE "Ficha" ADD CONSTRAINT "Key7" PRIMARY KEY ("cod_cpf","nro_ficha")
;

-- Table Avaliacao

CREATE TABLE "Avaliacao"(
 "cod_cpf" Character varying(11) NOT NULL,
 "dat_avaliacao" Date NOT NULL,
 "cod_cpf_instrutor" Character varying(11) NOT NULL,
 "idt_recencia" Boolean NOT NULL,
 "qtd_peso" Numeric(5,2) NOT NULL,
 "qtd_massaGorda" Numeric(5,2) NOT NULL,
 "qtd_percGordura" Numeric(5,2) NOT NULL,
 "tam_pescoco" Numeric(6,2) NOT NULL,
 "tam_ombro" Numeric(6,2) NOT NULL,
 "tam_torax" Numeric(6,2) NOT NULL,
 "tam_abdomen" Numeric(6,2) NOT NULL,
 "tam_cintura" Numeric(6,2) NOT NULL,
 "tam_quadril" Numeric(6,2) NOT NULL,
 "tam_bracoEsq" Numeric(6,2) NOT NULL,
 "tam_bracoDir" Numeric(6,2) NOT NULL,
 "tam_antebracoEsq" Numeric(6,2) NOT NULL,
 "tam_antebracoDir" Numeric(6,2) NOT NULL,
 "tam_coxaEsq" Numeric(6,2) NOT NULL,
 "tam_coxaDir" Numeric(6,2) NOT NULL,
 "tam_panturrilhaEsq" Numeric(6,2) NOT NULL,
 "tam_panturrilhaDir" Numeric(6,2) NOT NULL
)
;

-- Create indexes for table Avaliacao

CREATE INDEX "IX_Relationship13" ON "Avaliacao" ("cod_cpf_instrutor")
;

-- Add keys for table Avaliacao

ALTER TABLE "Avaliacao" ADD CONSTRAINT "Key8" PRIMARY KEY ("cod_cpf","dat_avaliacao")
;

-- Table Treino

CREATE TABLE "Treino"(
 "cod_cpf" Character varying(11) NOT NULL,
 "nro_ficha" Integer NOT NULL,
 "nro_treino" Smallint NOT NULL,
 "des_treino" Character varying NOT NULL
)
;

-- Add keys for table Treino

ALTER TABLE "Treino" ADD CONSTRAINT "Key14" PRIMARY KEY ("cod_cpf","nro_treino","nro_ficha")
;

-- Table Musculo

CREATE TABLE "Musculo"(
 "cod_musculo" Bigint NOT NULL,
 "cod_regCorp" Bigint,
 "nom_musculo" Character varying NOT NULL,
 "img_musculo" Bigint NOT NULL
)
;

-- Create indexes for table Musculo

CREATE INDEX "IX_Relationship20" ON "Musculo" ("cod_regCorp")
;

-- Add keys for table Musculo

ALTER TABLE "Musculo" ADD CONSTRAINT "Key16" PRIMARY KEY ("cod_musculo")
;

-- Table RegiaoCorporal

CREATE TABLE "RegiaoCorporal"(
 "cod_regCorp" Bigint NOT NULL,
 "nom_regCorp" Character varying NOT NULL
)
;

-- Add keys for table RegiaoCorporal

ALTER TABLE "RegiaoCorporal" ADD CONSTRAINT "Key17" PRIMARY KEY ("cod_regCorp")
;

-- Table MusculoExercicio

CREATE TABLE "MusculoExercicio"(
 "cod_exercicio" Integer NOT NULL,
 "cod_musculo" Bigint NOT NULL
)
;

-- Add keys for table MusculoExercicio

ALTER TABLE "MusculoExercicio" ADD CONSTRAINT "Key18" PRIMARY KEY ("cod_exercicio","cod_musculo")
;

-- Table Aparelho

CREATE TABLE "Aparelho"(
 "nro_aparelho" Smallint NOT NULL,
 "nom_aparelho" Character varying NOT NULL
)
;

-- Add keys for table Aparelho

ALTER TABLE "Aparelho" ADD CONSTRAINT "Key19" PRIMARY KEY ("nro_aparelho")
;

-- Table AparelhoExercicio

CREATE TABLE "AparelhoExercicio"(
 "cod_exercicio" Integer NOT NULL,
 "nro_aparelho" Smallint NOT NULL,
 "img_execucao" Bigint NOT NULL
)
;

-- Add keys for table AparelhoExercicio

ALTER TABLE "AparelhoExercicio" ADD CONSTRAINT "Key20" PRIMARY KEY ("cod_exercicio","nro_aparelho")
;

-- Table TreinoExercicio

CREATE TABLE "TreinoExercicio"(
 "cod_cpf" Character varying(11) NOT NULL,
 "nro_treino" Smallint NOT NULL,
 "cod_exercicio" Integer NOT NULL,
 "nro_aparelho" Smallint NOT NULL,
 "nro_ficha" Integer NOT NULL,
 "nro_series" Smallint NOT NULL,
 "nro_repeticoes" Character varying(6) NOT NULL,
 "qtd_peso" Integer NOT NULL
)
;

-- Add keys for table TreinoExercicio

ALTER TABLE "TreinoExercicio" ADD CONSTRAINT "Key21" PRIMARY KEY ("cod_exercicio","nro_aparelho","cod_cpf","nro_treino","nro_ficha")
;

-- Table Objetivo

CREATE TABLE "Objetivo"(
 "cod_objetivo" Bigint NOT NULL,
 "nom_objetivo" Character varying NOT NULL,
 "des_objetivo" Character varying NOT NULL
)
;

-- Add keys for table Objetivo

ALTER TABLE "Objetivo" ADD CONSTRAINT "Key22" PRIMARY KEY ("cod_objetivo")
;

-- Table ObjetivoAvaliacao

CREATE TABLE "ObjetivoAvaliacao"(
 "dat_avaliacao" Date NOT NULL,
 "cod_cpf" Character varying(11) NOT NULL,
 "cod_objetivo" Bigint NOT NULL
)
;

-- Add keys for table ObjetivoAvaliacao

ALTER TABLE "ObjetivoAvaliacao" ADD CONSTRAINT "Key23" PRIMARY KEY ("cod_objetivo","cod_cpf","dat_avaliacao")
;

-- Table DiaTreino

CREATE TABLE "DiaTreino"(
 "cod_exercicio" Integer NOT NULL,
 "nro_aparelho" Smallint NOT NULL,
 "cod_cpf" Character varying(11) NOT NULL,
 "nro_treino" Smallint NOT NULL,
 "nro_ficha" Integer NOT NULL,
 "dat_treino" Date NOT NULL
)
;

-- Add keys for table DiaTreino

ALTER TABLE "DiaTreino" ADD CONSTRAINT "Key24" PRIMARY KEY ("cod_exercicio","nro_aparelho","cod_cpf","nro_treino","dat_treino","nro_ficha")
;
-- Create foreign keys (relationships) section -------------------------------------------------

ALTER TABLE "Aluno" ADD CONSTRAINT "Relationship6" FOREIGN KEY ("cod_cpf") REFERENCES "Usuario" ("cod_cpf") ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE "Instrutor" ADD CONSTRAINT "Relationship7" FOREIGN KEY ("cod_cpf") REFERENCES "Usuario" ("cod_cpf") ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE "Ficha" ADD CONSTRAINT "Relationship9" FOREIGN KEY ("cod_cpf") REFERENCES "Aluno" ("cod_cpf") ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE "Ficha" ADD CONSTRAINT "Relationship11" FOREIGN KEY ("cod_cpf_instrutor") REFERENCES "Instrutor" ("cod_cpf") ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE "Avaliacao" ADD CONSTRAINT "Relationship12" FOREIGN KEY ("cod_cpf") REFERENCES "Aluno" ("cod_cpf") ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE "Avaliacao" ADD CONSTRAINT "Relationship13" FOREIGN KEY ("cod_cpf_instrutor") REFERENCES "Instrutor" ("cod_cpf") ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE "Treino" ADD CONSTRAINT "Relationship17" FOREIGN KEY ("cod_cpf", "nro_ficha") REFERENCES "Ficha" ("cod_cpf", "nro_ficha") ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE "Musculo" ADD CONSTRAINT "Relationship20" FOREIGN KEY ("cod_regCorp") REFERENCES "RegiaoCorporal" ("cod_regCorp") ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE "MusculoExercicio" ADD CONSTRAINT "Relationship21" FOREIGN KEY ("cod_exercicio") REFERENCES "Exercicio" ("cod_exercicio") ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE "MusculoExercicio" ADD CONSTRAINT "Relationship22" FOREIGN KEY ("cod_musculo") REFERENCES "Musculo" ("cod_musculo") ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE "AparelhoExercicio" ADD CONSTRAINT "Relationship23" FOREIGN KEY ("cod_exercicio") REFERENCES "Exercicio" ("cod_exercicio") ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE "AparelhoExercicio" ADD CONSTRAINT "Relationship24" FOREIGN KEY ("nro_aparelho") REFERENCES "Aparelho" ("nro_aparelho") ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE "TreinoExercicio" ADD CONSTRAINT "Relationship25" FOREIGN KEY ("cod_exercicio", "nro_aparelho") REFERENCES "AparelhoExercicio" ("cod_exercicio", "nro_aparelho") ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE "TreinoExercicio" ADD CONSTRAINT "Relationship26" FOREIGN KEY ("cod_cpf", "nro_treino", "nro_ficha") REFERENCES "Treino" ("cod_cpf", "nro_treino", "nro_ficha") ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE "ObjetivoAvaliacao" ADD CONSTRAINT "Relationship27" FOREIGN KEY ("cod_objetivo") REFERENCES "Objetivo" ("cod_objetivo") ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE "ObjetivoAvaliacao" ADD CONSTRAINT "Relationship28" FOREIGN KEY ("cod_cpf", "dat_avaliacao") REFERENCES "Avaliacao" ("cod_cpf", "dat_avaliacao") ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE "DiaTreino" ADD CONSTRAINT "Relationship29" FOREIGN KEY ("cod_exercicio", "nro_aparelho", "cod_cpf", "nro_treino", "nro_ficha") REFERENCES "TreinoExercicio" ("cod_exercicio", "nro_aparelho", "cod_cpf", "nro_treino", "nro_ficha") ON DELETE CASCADE ON UPDATE CASCADE
;
