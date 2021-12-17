create table tipo_produto
(
    id   bigint       not null auto_increment,
    nome varchar(150) not null unique,
    primary key (id)
);