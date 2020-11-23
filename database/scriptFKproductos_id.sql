ALTER TABLE detalle_factura
ADD CONSTRAINT fk_productos
FOREIGN KEY (productos_id)
REFERENCES productos(id)