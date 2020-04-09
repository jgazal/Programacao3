--autenticacao 
create table usuarios(
	usuario varchar(20) not null,
	senha varchar(20) not null,
	primary key(usuario)
	);
insert into usuarios values('usuario','senha');
	