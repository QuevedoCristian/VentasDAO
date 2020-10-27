ALTER TABLE productos
ADD COLUMN categorias_id integer

ALTER TABLE productos
ADD CONSTRAINT fk_categoria
FOREIGN KEY (categorias_id)
REFERENCES categorias(id)