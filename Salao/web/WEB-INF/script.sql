CREATE SCHEMA IF NOT EXISTS `dbsalao` DEFAULT CHARACTER SET latin1 ;
USE `dbsalao` ;

CREATE TABLE IF NOT EXISTS `dbsalao`.`cliente` (
  `idcliente` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `telefone` VARCHAR(11) NULL DEFAULT NULL,
  `cpf` VARCHAR(11) NULL DEFAULT NULL,
  `endereco` VARCHAR(255) NULL DEFAULT NULL,
  `bairro` VARCHAR(255) NULL DEFAULT NULL,
  `numero` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idcliente`))