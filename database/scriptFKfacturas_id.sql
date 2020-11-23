ALTER TABLE detalle_factura
ADD COLUMN facturas_id integer;

ALTER TABLE detalle_factura
ADD CONSTRAINT fk_facturas
FOREIGN KEY (facturas_id)
REFERENCES facturas(id)