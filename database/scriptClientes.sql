create table clientes(
	id serial not null,
	documento character varying(10) not null,
	nombre character varying(60) not null,
	apellido character varying(60) not null,
	primary key(id)
)