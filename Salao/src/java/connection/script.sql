drop database if exists dbtccteste;

create database dbtccteste;

use dbtccteste;
create table produto (
 idproduto INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  fornecedor varchar(255),
  quantidade int,
  dtcompra Date,
  valorcompra double,
  valorvenda double,
  PRIMARY KEY (idproduto))


