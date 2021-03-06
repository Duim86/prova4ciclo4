drop table if exists fornecedor CASCADE;

drop table if exists tipo_produto CASCADE;

drop table if exists selection_process_student CASCADE;


create table fornecedor (
                                  id bigint generated by default as identity,
                                  nome varchar(255) not null,
                                  primary key (id)
);

create table tipo_produto (
                                   id bigint generated by default as identity,
                                   nome varchar(255) not null,
                                   primary key (id)
);

create table produto (
                         id bigint generated by default as identity,
                         nome varchar(255) not null,
                         preco_venda decimal(10,2) not null,
                         preco_compra decimal(10,2) not null,
                         quantidade integer not null,
                         fornecedor_id bigint not null,
                         tipo_produto_id bigint not null,
                         primary key (id)
);


alter table produto
    add constraint FK3yx21o9d50avlmf3n7m9kav37
        foreign key (fornecedor_id)
            references fornecedor;

alter table produto
    add constraint FK49dn2exjjyoqv86b1renpna71
        foreign key (tipo_produto_id)
            references tipo_produto;
