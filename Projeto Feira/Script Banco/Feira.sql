create database feira2;

create table tipo(
	codtipo serial primary key,
	nometipo varchar(80) not null unique
);

create table produto(
	codproduto serial primary key,
	nomeproduto varchar(80) not null,
	valor numeric(10,2) not null,
	quantidade numeric(10,2) not null,
	codtipo integer references tipo(codtipo) 
	  match simple on delete cascade on update cascade
);

