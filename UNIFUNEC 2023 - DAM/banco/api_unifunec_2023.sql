CREATE DATABASE API_UNIFUNEC_2023;

drop table if exists aluno;

CREATE TABLE ALUNO(
	codaluno serial primary key,
	nomealuno varchar(80) not null,
	curso varchar(80)
);

insert into aluno(nomealuno, curso) values ('MARCOS ANTONIO ESTREMOTE', 'TEC. EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS');

insert into aluno(nomealuno, curso) values ('CARLOS EDUARDO', 'MEDICINA');

insert into aluno(nomealuno, curso) values ('PÂMELA DO ADS', 'ADS');


