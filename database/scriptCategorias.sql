create table categorias(
	id serial not null,
	denominacion character varying(60) not null,
	descripcion character varying(80),
	primary key(id)
)