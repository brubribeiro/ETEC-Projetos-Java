-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 29-Maio-2019 às 22:15
-- Versão do servidor: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdestoque`
--
CREATE DATABASE IF NOT EXISTS `bdestoque` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bdestoque`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbfuncionario`
--

DROP TABLE IF EXISTS `tbfuncionario`;
CREATE TABLE IF NOT EXISTS `tbfuncionario` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cargo` varchar(30) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbfuncionario`
--

INSERT INTO `tbfuncionario` (`codigo`, `nome`, `cargo`, `telefone`) VALUES
(2, 'João Paulo Gomes', 'Aposentado', '4444-3333'),
(4, 'Ana Maria Cunha', 'Estudante', '2222-2222'),
(6, 'Erica Gomes', 'Professor', '3333-2222'),
(10, 'Ronaldo Antunes', 'professor', '2222-3323'),
(12, 'Bartolomeu Dias', 'Professor', '3333-2222');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblogin`
--

DROP TABLE IF EXISTS `tblogin`;
CREATE TABLE IF NOT EXISTS `tblogin` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(20) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `nivel` int(11) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  `codfun` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `codfun` (`codfun`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tblogin`
--

INSERT INTO `tblogin` (`codigo`, `usuario`, `senha`, `nivel`, `ativo`, `codfun`) VALUES
(6, 'aa', 'aa', 0, 1, 10),
(20, 'no', 'no', 1, 0, 12),
(21, 'ee', 'ee', 1, 1, 2),
(22, 'cc', 'cc', 2, 1, 6);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbproduto`
--

DROP TABLE IF EXISTS `tbproduto`;
CREATE TABLE IF NOT EXISTS `tbproduto` (
  `codigoproduto` int(11) NOT NULL AUTO_INCREMENT,
  `nomeproduto` varchar(30) NOT NULL,
  `quantidadeproduto` int(11) NOT NULL,
  `valorproduto` float NOT NULL,
  `localproduto` varchar(40) NOT NULL,
  PRIMARY KEY (`codigoproduto`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbproduto`
--

INSERT INTO `tbproduto` (`codigoproduto`, `nomeproduto`, `quantidadeproduto`, `valorproduto`, `localproduto`) VALUES
(1, 'Arroz', 20, 15, 'Dispensa'),
(2, 'Farinha', 100, 10, 'Dispensa'),
(3, 'Feijão Preto', 198, 30, 'Dispensa'),
(4, 'Carne Moida', 977, 20, 'Mercado');

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `tblogin`
--
ALTER TABLE `tblogin`
  ADD CONSTRAINT `tblogin_ibfk_1` FOREIGN KEY (`codfun`) REFERENCES `tbfuncionario` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
