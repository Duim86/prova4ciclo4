delete from produto;

delete from fornecedor;

delete from tipo_produto;

insert into fornecedor
(id, nome)
values (1, 'Açougue do Duim'),
       (2, 'Disk Duim');


insert into tipo_produto (id, nome)
values (1, 'Comida'),
       (2, 'Bebida');


insert into produto (id, nome, preco_venda, preco_compra, quantidade, fornecedor_id, tipo_produto_id)
values (1, 'Cerveja', 7, 3, 3, 2, 2),
       (2, 'Carne', 30, 15, 4, 1, 1);