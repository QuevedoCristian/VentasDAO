create table facturas(
	id serial not null,
	numero_factura integer not null,
	monto_total float not null,
	fecha_facturacion date,
	observaciones character varying(200),
	clientes_id integer,
	forma_pago_id integer,
	detalle_factura_id integer,
	primary key(id)
)