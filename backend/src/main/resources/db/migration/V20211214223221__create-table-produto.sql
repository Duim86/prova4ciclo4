create table produto
(
    id              bigint         not null auto_increment,
    nome            varchar(150)   not null,
    preco_venda     decimal(10, 2) not null,
    preco_compra    decimal(10, 2) not null,

    quantidade      integer        not null default 0,

    fornecedor_id   bigint         not null,
    tipo_produto_id bigint         not null,

    constraint fk_produto_fornecedor foreign key (fornecedor_id) references fornecedor (id),
    constraint fk_produto_tipo_produto foreign key (tipo_produto_id) references tipo_produto (id),

    primary key (id)
);