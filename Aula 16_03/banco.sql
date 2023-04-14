create database api_unifunec_2023;

create table aluno(
	codaluno serial primary key,
	nomealuno varchar(80) not null,
	curso varchar(80) not null
);

insert into aluno(nomealuno, curso) values 
('MARCOS ANTONIO ESTREMOTE','ADS' ),
('FÁBIO BORIS','ENFERMAGEM' ),
('JOSÉ PAULO CODINHOTO','MEDICINA' );