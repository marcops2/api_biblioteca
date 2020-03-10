create database `biblioteca`;

CREATE TABLE `biblioteca`.`livros` (
  `id` INT NOT NULL,
  `nome` VARCHAR(256) NOT NULL,
  `autor` VARCHAR(256) NOT NULL,
  `codigo` VARCHAR(15) NOT NULL,
  `criado_em` DATETIME NOT NULL DEFAULT current_timestamp,
  `alterado_em` DATETIME NOT NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`),
  INDEX `livros_codigo_idx` (`codigo` ASC) VISIBLE
);