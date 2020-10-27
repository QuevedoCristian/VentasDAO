ALTER TABLE clientes
ADD COLUMN tipo_cliente_id integer;

ALTER TABLE clientes
ADD CONSTRAINT fk_tipo_cliente
FOREIGN KEY(tipo_cliente_id)
REFERENCES tipo_cliente(id)