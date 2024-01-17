
-- Inserção para ItemDeEstoque 1
INSERT INTO itemdeestoque (item_id, qtd_atual, estoque_min, estoque_max) VALUES (1, 100, 10, 200);

-- Inserção para ItemDeEstoque 2
INSERT INTO itemdeestoque (item_id,qtd_atual, estoque_min, estoque_max) VALUES (2,150, 20, 250);

-- Inserção para ItemDeEstoque 3
INSERT INTO itemdeestoque (item_id,qtd_atual, estoque_min, estoque_max) VALUES (3,200, 15, 300);

-- Inserção para ItemDeEstoque 4
INSERT INTO itemdeestoque (item_id,qtd_atual, estoque_min, estoque_max) VALUES (4,80, 8, 150);

-- Inserção para ItemDeEstoque 5
INSERT INTO itemdeestoque (item_id,qtd_atual, estoque_min, estoque_max) VALUES (5,120, 10, 180);

-- Inserção para ItemDeEstoque 6
INSERT INTO itemdeestoque (item_id,qtd_atual, estoque_min, estoque_max) VALUES (6,90, 12, 160);

-- Inserção para ItemDeEstoque 7
INSERT INTO itemdeestoque (item_id,qtd_atual, estoque_min, estoque_max) VALUES (7,180, 25, 300);

-- Inserção para ItemDeEstoque 8
INSERT INTO itemdeestoque (item_id,qtd_atual, estoque_min, estoque_max) VALUES (8,60, 5, 100);

-- Inserção para ItemDeEstoque 9
INSERT INTO itemdeestoque (item_id,qtd_atual, estoque_min, estoque_max) VALUES (9,130, 18, 200);

-- Inserção para ItemDeEstoque 10
INSERT INTO itemdeestoque (item_id,qtd_atual, estoque_min, estoque_max) VALUES (10,100, 15, 180);



-- Inserção para Produto 1
INSERT INTO produto (codigo,descricao, preco, itemdeestoque_id) VALUES (1,'Laptop', 1499.99, 1);

-- Inserção para Produto 2
INSERT INTO produto (codigo,descricao, preco, itemdeestoque_id) VALUES (2,'Smartphone', 699.99, 2);

-- Inserção para Produto 3
INSERT INTO produto (codigo,descricao, preco, itemdeestoque_id) VALUES (3,'Tablet', 299.99, 3);

-- Inserção para Produto 4
INSERT INTO produto (codigo,descricao, preco, itemdeestoque_id) VALUES (4,'Câmera Digital', 399.99, 4);

-- Inserção para Produto 5
INSERT INTO produto (codigo,descricao, preco, itemdeestoque_id) VALUES (5,'Fone de Ouvido', 79.99, 5);

-- Inserção para Produto 6
INSERT INTO produto (codigo,descricao, preco, itemdeestoque_id) VALUES (6,'Impressora', 249.99, 6);

-- Inserção para Produto 7
INSERT INTO produto (codigo,descricao, preco, itemdeestoque_id) VALUES (7,'Teclado Sem Fio', 49.99, 7);

-- Inserção para Produto 8
INSERT INTO produto (codigo,descricao, preco, itemdeestoque_id) VALUES (8,'Mouse Óptico', 19.99, 8);

-- Inserção para Produto 9
INSERT INTO produto (codigo,descricao, preco, itemdeestoque_id) VALUES (9,'Monitor LED', 299.99, 9);

-- Inserção para Produto 10
INSERT INTO produto (codigo,descricao, preco, itemdeestoque_id) VALUES (10,'Roteador Wi-Fi', 89.99, 10);





-- Inserção para Orcamento 1
INSERT INTO orcamento (id_orc,data, nome_cliente, custo_pedido, imposto, desconto, total_pagar, efetivado) VALUES (91,'2023-11-15', 'ClienteA', 1500, 75, 100, 1475, true);

-- Inserção para Orcamento 2
INSERT INTO orcamento (id_orc,data, nome_cliente, custo_pedido, imposto, desconto, total_pagar, efetivado) VALUES (92,'2023-11-16', 'ClienteB', 1200, 60, 80, 1180, true);

-- Inserção para Orcamento 3
INSERT INTO orcamento (id_orc,data, nome_cliente, custo_pedido, imposto, desconto, total_pagar, efetivado) VALUES (93,'2023-11-17', 'ClienteC', 1800, 90, 120, 1770, false);

-- Inserção para Orcamento 4
INSERT INTO orcamento (id_orc,data, nome_cliente, custo_pedido, imposto, desconto, total_pagar, efetivado) VALUES (94,'2023-11-18', 'ClienteD', 2000, 100, 150, 1950, true);

-- Inserção para Orcamento 5
INSERT INTO orcamento (id_orc,data, nome_cliente, custo_pedido, imposto, desconto, total_pagar, efetivado) VALUES (95,'2023-11-19', 'ClienteE', 1300, 65, 80, 1285, false);

-- Inserção para Orcamento 6
INSERT INTO orcamento (id_orc,data, nome_cliente, custo_pedido, imposto, desconto, total_pagar, efetivado) VALUES (96,'2023-11-20', 'ClienteF', 1600, 80, 100, 1580, true);

-- Inserção para Orcamento 7
INSERT INTO orcamento (id_orc,data, nome_cliente, custo_pedido, imposto, desconto, total_pagar, efetivado) VALUES (97,'2023-11-21', 'ClienteG', 1400, 70, 90, 1380, true);

-- Inserção para Orcamento 8
INSERT INTO orcamento (id_orc,data, nome_cliente, custo_pedido, imposto, desconto, total_pagar, efetivado) VALUES (98,'2023-11-22', 'ClienteH', 1100, 55, 70, 1085, false);

-- Inserção para Orcamento 9
INSERT INTO orcamento (id_orc,data, nome_cliente, custo_pedido, imposto, desconto, total_pagar, efetivado) VALUES (99,'2023-11-23', 'ClienteI', 1900, 95, 130, 1865, true);

-- Inserção para Orcamento 10
INSERT INTO orcamento (id_orc,data, nome_cliente, custo_pedido, imposto, desconto, total_pagar, efetivado) VALUES (100,'2023-11-24', 'ClienteJ', 1700, 85, 110, 1695, true);





-- Inserção para Pedido 1
INSERT INTO pedido (ped_id,nome_cliente, id_orc) VALUES (10,'ClienteA',91);

-- Inserção para Pedido 2
INSERT INTO pedido (ped_id,nome_cliente, id_orc) VALUES (2,'ClienteB',92);

-- Inserção para Pedido 3
INSERT INTO pedido (ped_id,nome_cliente, id_orc) VALUES (3,'ClienteC',93);

-- Inserção para Pedido 4
INSERT INTO pedido (ped_id,nome_cliente, id_orc) VALUES (4,'ClienteD',94);

-- Inserção para Pedido 5
INSERT INTO pedido (ped_id,nome_cliente, id_orc) VALUES (5,'ClienteE',95);

-- Inserção para Pedido 6
INSERT INTO pedido (ped_id,nome_cliente, id_orc) VALUES (6,'ClienteF',96);

-- Inserção para Pedido 7
INSERT INTO pedido (ped_id,nome_cliente, id_orc) VALUES (7,'ClienteG',97);

-- Inserção para Pedido 8
INSERT INTO pedido (ped_id,nome_cliente, id_orc) VALUES (8,'ClienteH',98);

-- Inserção para Pedido 9
INSERT INTO pedido (ped_id,nome_cliente, id_orc) VALUES (9,'ClienteI',99);

-- Inserção para Pedido 10
INSERT INTO pedido (ped_id,nome_cliente, id_orc) VALUES (11,'ClienteJ',100);



-- Inserção para ItemPedido 1
INSERT INTO itempedido (item_pedido_id, cod_produto,qtd, pedido_id) VALUES (10, 1, 2, 10);

-- Inserção para ItemPedido 2
INSERT INTO itempedido (item_pedido_id, cod_produto,qtd, pedido_id) VALUES (2, 2, 3, 10);

-- Inserção para ItemPedido 3
INSERT INTO itempedido (item_pedido_id, cod_produto, qtd, pedido_id) VALUES (3, 3, 1, 3);

-- Inserção para ItemPedido 4
INSERT INTO itempedido (item_pedido_id, cod_produto,qtd, pedido_id) VALUES (4, 4, 4, 4);

-- Inserção para ItemPedido 5
INSERT INTO itempedido (item_pedido_id, cod_produto,qtd, pedido_id) VALUES (5, 5,2, 5);

-- Inserção para ItemPedido 6
INSERT INTO itempedido (item_pedido_id, cod_produto,qtd, pedido_id) VALUES (6, 6,3, 6);

-- Inserção para ItemPedido 7
INSERT INTO itempedido (item_pedido_id, cod_produto,qtd, pedido_id) VALUES (7, 7,2, 7);

-- Inserção para ItemPedido 8
INSERT INTO itempedido (item_pedido_id, cod_produto,qtd, pedido_id) VALUES (8, 8,1, 8);

-- Inserção para ItemPedido 9
INSERT INTO itempedido (item_pedido_id, cod_produto,qtd, pedido_id) VALUES (9, 9,3, 9);

-- Inserção para ItemPedido 10
INSERT INTO itempedido (item_pedido_id, cod_produto,qtd, pedido_id) VALUES (100, 10,2, 11);

