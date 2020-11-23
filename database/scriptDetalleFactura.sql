create table detalle_factura(
	id serial not null,
	cantidad integer not null,
	monto float not null,
	productos_id integer,
	primary key(id)
)