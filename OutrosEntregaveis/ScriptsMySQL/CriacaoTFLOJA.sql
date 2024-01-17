CREATE TABLE orcamento (
    id_orc INT AUTO_INCREMENT PRIMARY KEY,
    data DATE,
    nome_cliente VARCHAR(255),
    custo_pedido DOUBLE,
    imposto DOUBLE,
    desconto DOUBLE,
    total_pagar DOUBLE,
    efetivado BOOLEAN
);

CREATE TABLE pedido (
    ped_id INT AUTO_INCREMENT PRIMARY KEY,
    nome_cliente VARCHAR(255),
    id_orc INT
);

CREATE TABLE itempedido (
    item_pedido_id INT AUTO_INCREMENT PRIMARY KEY,
    cod_produto INT,
    pedido_id INT,
    qtd INT
);

CREATE TABLE produto (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    itemdeestoque_id INT,
    descricao VARCHAR(255),
    preco DOUBLE
);

CREATE TABLE itemdeestoque (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    codigo INT,
    qtd_atual INT,
    estoque_min INT,
    estoque_max INT
);


ALTER TABLE pedido
ADD FOREIGN KEY (id_orc) REFERENCES orcamento(id_orc) ON DELETE CASCADE;

ALTER TABLE itempedido
ADD FOREIGN KEY (pedido_id) REFERENCES pedido(ped_id) ON DELETE CASCADE;

-- ALTER TABLE produto
-- ADD FOREIGN KEY (itemdeestoque_id) REFERENCES itemdeestoque(item_id) ON DELETE CASCADE;

ALTER TABLE itemdeestoque
ADD FOREIGN KEY (codigo) REFERENCES produto(codigo) ON DELETE CASCADE;

-- ALTER TABLE orcamento
-- ADD FOREIGN KEY (ped_id) REFERENCES pedido(ped_id) ON DELETE CASCADE;



select * from itemdeestoque;
select * from produto;
select * from pedido;
select * from itempedido;
select * from orcamento;
select count(*) from orcamento;
select count(*) from itempedido;
select count(*) from pedido;
select count(*) from produto;
select count(*) from itemdeestoque;


-- drop table itempedido cascade;
-- drop table pedido cascade;
-- drop table orcamento cascade;
-- drop table itemdeestoque cascade;
-- drop table produto cascade;

delete from orcamento where id_orc > 1000;
delete from pedido where ped_id > 1000;
delete from itempedido where item_pedido_id > 1000;