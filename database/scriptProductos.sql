create table productos(
	id serial not null,
	nombre character varying(60),
	descripcion character varying(80),
	precio float, 
	primary key(id)
)