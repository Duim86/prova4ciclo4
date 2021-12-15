create table tipo_produto
(
    id   bigserial      not null,
    nome varchar(150) not null unique,
    primary key (id)
);