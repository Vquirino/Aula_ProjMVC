drop database if exists aula;
create database aula;
use aula;

create table produto(
    codigo      integer         auto_increment      primary key,
    nome        varchar(35)     not null,
    preco       double          not null,
    quantidade  integer         not null
);

desc produto;