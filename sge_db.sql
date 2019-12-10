-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 10-Dez-2019 às 03:11
-- Versão do servidor: 5.7.19
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sge_db`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

DROP TABLE IF EXISTS `aluno`;
CREATE TABLE IF NOT EXISTS `aluno` (
  `codaluno` int(11) NOT NULL AUTO_INCREMENT,
  `nomealuno` varchar(45) DEFAULT NULL,
  `data_nascimento` varchar(45) DEFAULT NULL,
  `cpf` varchar(15) DEFAULT NULL,
  `telefone` varchar(15) NOT NULL,
  `email` varchar(150) NOT NULL,
  `data_matricula` varchar(12) NOT NULL,
  `curso_codigo` bigint(20) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`codaluno`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`codaluno`, `nomealuno`, `data_nascimento`, `cpf`, `telefone`, `email`, `data_matricula`, `curso_codigo`, `created_at`, `update_at`) VALUES
(1, 'Taffarel Xavier', '22/08/1990', '03630413110', '6399480630', 'taffarelxavier7@gmail.com', 'aaaa', 0, '2019-12-10 01:25:41', '2019-12-10 01:26:04'),
(2, 'Janderson', '22081454', '546466', '54546', 'sadfasdfa@mgail.com', '', 0, '2019-12-10 01:28:46', '2019-12-10 01:28:46');

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno_disciplina`
--

DROP TABLE IF EXISTS `aluno_disciplina`;
CREATE TABLE IF NOT EXISTS `aluno_disciplina` (
  `alu_disc_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `aluno_fk_id` bigint(20) NOT NULL,
  `disciplina_fk_id` bigint(20) NOT NULL,
  PRIMARY KEY (`alu_disc_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

DROP TABLE IF EXISTS `curso`;
CREATE TABLE IF NOT EXISTS `curso` (
  `codcurso` int(11) NOT NULL AUTO_INCREMENT,
  `nomecurso` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codcurso`),
  UNIQUE KEY `nomecurso` (`nomecurso`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `curso`
--

INSERT INTO `curso` (`codcurso`, `nomecurso`) VALUES
(9, 'Bacharelado Ciência da Computação'),
(3, 'Engenharia Agrônima'),
(2, 'Licenciatura em Ciências Biológicas'),
(1, 'Licenciatura em Computação'),
(7, 'Novo Curso 45');

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
CREATE TABLE IF NOT EXISTS `disciplina` (
  `coddisc` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) DEFAULT NULL,
  `creditos` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`coddisc`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `disciplina`
--

INSERT INTO `disciplina` (`coddisc`, `titulo`, `creditos`) VALUES
(1, 'ADMINISTRAÇÃO DE REDES', ''),
(2, 'ADMINISTRAÇÃO DE SISTEMAS OPERACIONAIS', ''),
(3, 'ADMINISTRAÇÃO E ECONOMIA RURAL/ PROJETOS', ''),
(4, 'AGROSSILVICULTURA', ''),
(5, 'ALGORITMOS', ''),
(6, 'APICULTURA', ''),
(7, 'ARQUITETURA E PROTOCOLO DE REDES', ''),
(8, 'ARTES', ''),
(9, 'AVES DE CORTE / POSTURA', ''),
(10, 'BIOLOGIA', ''),
(11, 'BOVINOCULTURA', ''),
(12, 'CABEAMENTO ESTRUTURADO', ''),
(13, 'CONSTRUÇÕES E INSTALAÇÕES RURAIS', ''),
(14, 'CULTURAS ANUAIS', ''),
(15, 'EDUCAÇÃO FÍSICA', ''),
(16, 'ELETRICIDADE BÁSICA', ''),
(17, 'EQUINOCULTURA', ''),
(18, 'ESPANHOL', ''),
(19, 'EXTENSÃO RURAL / COOPERATIVISMO', ''),
(20, 'FILOSOFIA', ''),
(21, 'FÍSICA', ''),
(22, 'FRUTICULTURA', ''),
(23, 'FUNDAMENTOS DE INFORM?ICA', ''),
(24, 'GEOGRAFIA', ''),
(25, 'HISTÓRIA', ''),
(26, 'INDÚSTRIAS RURAIS', ''),
(27, 'INFORMÁTICA', ''),
(28, 'INFORMÁTICA APLICADA A AGROPECUÁRIA', ''),
(29, 'INGLÊS', ''),
(30, 'INTRODUÇÃO A BANCO DE DADOS', ''),
(31, 'INTRODUÇÃO A REDES', ''),
(32, 'IRRIGAÇÃO E DRENAGEM', ''),
(33, 'LÍGUA PORTUGUESA', ''),
(34, 'LITERATURA E REDAÇÃO', ''),
(35, 'MATEMÁTICA', ''),
(36, 'MECANIZAÇÃO', ''),
(37, 'OLERICULTURA / JARDINOCULTURA', ''),
(38, 'ORGANIZAÇÃO E MANUTENÇÃO DE COMPUTADORES', ''),
(39, 'OVINOCULTURA', ''),
(40, 'PISCICULTURA', ''),
(41, 'PROGRAMAÇÃO ORIENTADA A OBJETOS', ''),
(42, 'PROGRAMAÇÃO WEB', ''),
(43, 'PROJETO DE REDES', ''),
(44, 'PROJETO DE SISTEMAS', ''),
(45, 'QUÍMICA', ''),
(46, 'SEGURANÇA DE REDES', ''),
(47, 'SISTEMAS OPERACIONAIS I', ''),
(48, 'SOCIOLOGIA', ''),
(49, 'SUINOCULTURA', ''),
(50, 'TOPOGRAFIA', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `matricula`
--

DROP TABLE IF EXISTS `matricula`;
CREATE TABLE IF NOT EXISTS `matricula` (
  `matricula_id` int(11) NOT NULL AUTO_INCREMENT,
  `codaluno` int(11) DEFAULT NULL,
  `codturma` int(11) DEFAULT NULL,
  `media` varchar(45) DEFAULT NULL,
  `resultado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`matricula_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `professores`
--

DROP TABLE IF EXISTS `professores`;
CREATE TABLE IF NOT EXISTS `professores` (
  `prof_id` int(11) NOT NULL AUTO_INCREMENT,
  `prof_cpf` varchar(25) NOT NULL,
  `prof_nome` varchar(255) NOT NULL,
  `prof_senha` varchar(255) NOT NULL,
  `prof_status` enum('ATIVO','INATIVO') NOT NULL,
  `prof_nivel` enum('ADMINISTRADOR','PROFESSOR') NOT NULL,
  `somente_leitura` enum('sim','nao') NOT NULL DEFAULT 'nao',
  PRIMARY KEY (`prof_id`),
  UNIQUE KEY `prof_cpf` (`prof_cpf`)
) ENGINE=MyISAM AUTO_INCREMENT=166 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `professores`
--

INSERT INTO `professores` (`prof_id`, `prof_cpf`, `prof_nome`, `prof_senha`, `prof_status`, `prof_nivel`, `somente_leitura`) VALUES
(78, '1899549', 'ANCELMO FRANK COELHO CASTRO', '$2y$10$VtUsAvPMAP29zkk4Wotf/efthnkw2lbWkK6HM7bDF60tr2rlMgoVG', 'ATIVO', 'PROFESSOR', 'nao'),
(77, '1102960', 'ALFONSO SIQUEIRA DIMPERIO', '$2y$10$rv.CsjWw/KxMRcOiUJ5DJOF9YhTAQ8mh5lrBPK/yr83m..EdpwMxW', 'ATIVO', 'PROFESSOR', 'nao'),
(76, '2261084', 'ALESSANDRO OLIVEIRA SILVA', '$2y$10$.eRmMj5lEB0xaRZSEb/W2.n3UfU3J2V6ItwaYXuJ3lFjEmvmFfJjy', 'ATIVO', 'PROFESSOR', 'nao'),
(75, '1536894', 'ALESSANDRO NASCIMENTO SOUSA', '$2y$10$dDLWcBVZslbpgCr1o2ChBe0ltJvoAyWdvANC8YCK8/IyHnY0sOLR6', 'ATIVO', 'PROFESSOR', 'nao'),
(74, '2727716', 'ADEILSON MARQUES DA SILVA CARDOSO', '$2y$10$tnvFKeq66e9m.BsUXJ5C2.YCqS6GLU5TBsCqi/fpUrE6dQwKJR8xe', 'ATIVO', 'PROFESSOR', 'nao'),
(79, '1367013', 'ANDERSON BRASIL SILVA CAVALCANTE', '$2y$10$cK6sWrUgb/qri/g3iNvtGOkEQC879O9eegU7iM71fR4w/kr8Al3FK', 'ATIVO', 'PROFESSOR', 'nao'),
(80, '1324835', 'ANESIO MENDES DE SOUSA', '$2y$10$BOGeMsrlJpDNt3x6d5LjXunD7i5BMog5zyjcGD3RHeqs8RZsvBNrW', 'ATIVO', 'PROFESSOR', 'nao'),
(81, '1944463', 'ANGELICA CAMPOS DOS SANTOS', '$2y$10$ZdR6Hx2P82A/62B2t0kL9OUqlHRj0AM0xUwJToGZKRWXm4UtzA/06', 'ATIVO', 'PROFESSOR', 'nao'),
(82, '1794718', 'ANTONIO SILVANO GONCALVES SANTOS', '$2y$10$.8bOACY.WxxxpuGnPg4Vy.7VRBOTVZNMtE.rGwFYUXuWnqm1agqEG', 'ATIVO', 'PROFESSOR', 'nao'),
(83, '1979242', 'BRENNDA MUNIQUI CAVALCANTE PASSOS SOARES', '$2y$10$IlAVgUHgq2qDYeFam92DGuWX4Fm8Fi61gZLzemtSfPwcUHV5j9dl6', 'ATIVO', 'PROFESSOR', 'nao'),
(84, '2384420', 'CARLA CRISTINA DA SILVA', '$2y$10$qFFd0lOnKgLuZpY4gA79hOGPDnxxlCGlzO/pNZUfQrlJb17nllG2K', 'ATIVO', 'PROFESSOR', 'nao'),
(85, '3121846', 'CARLOS ALBERTO ANDRADE SERRA DOS SANTOS', '$2y$10$uZwsu1IGWps4mOQQ0jVmwOI/YHtyAB/xvOkNwfMR6GDR.cRC/Rd.i', 'INATIVO', 'PROFESSOR', 'nao'),
(86, '2145287', 'CASSIA MARIA DE SOUSA PEREIRA', '$2y$10$hBuY9qocfQwB019Tw17U0ugu5Bt3j0NskwLQeZvlA7eki.6feaHTa', 'ATIVO', 'PROFESSOR', 'nao'),
(87, '1820031', 'CHARLES MIRANDA SANTOS', '$2y$10$BeK3OkPJFkhS6zSAApZRi.jXEwgEozjRq/JlvaF83vRbhnmJiQ5Fa', 'ATIVO', 'PROFESSOR', 'nao'),
(88, '1786007', 'CIRLENE CUSTODIO CARVALHO', '$2y$10$xCP0h5PS56IJFJI/jW9vD.UnuRSCXX1S7HvQ81c987GZbWxZ2vVOO', 'ATIVO', 'PROFESSOR', 'nao'),
(89, '1621502', 'CLAUDIO DE SOUSA GALVAO', '$2y$14$7Bpkltsh5qBHE0Uxt.02VO.u5tIbPipWb9GDhJ7CYAi9sa7VIig4G', 'ATIVO', 'ADMINISTRADOR', 'nao'),
(90, '2868016', 'CRISTINA DE SOUSA FONSECA ALMEIDA', '$2y$10$roAAM7k9i.2PAZQqoolhR.h6i5sM2PI7kiDaE69cbWQ7xxW593C9W', 'ATIVO', 'PROFESSOR', 'nao'),
(91, '2384130', 'DANIEL DE FREITAS NUNES', '$2y$10$RN3RxSGgNfZlXAgcLNAfTO.sgXu31G8Bi5Ia0uJAm7VIQ.oiebI7e', 'INATIVO', 'PROFESSOR', 'nao'),
(92, '1545565', 'DARCY ALVES DO BOMFIM', '$2y$10$/JsHp0vwizRFxR2ediX1guZFzOSgrGtfx4vakentr6RZAD35rXoLS', 'ATIVO', 'PROFESSOR', 'nao'),
(93, '1097882', 'DECIO DIAS DOS REIS', '$2y$10$5xqwMPQUtwp.K3bj0/Lrz.WtjITarg2OQokTILoDg35uBj7PdUfW.', 'ATIVO', 'PROFESSOR', 'nao'),
(94, '3070077', 'DIANES GOMES MARCELINO', '$2y$10$U.GKq22S1AsTcSWSeTwPiObM2An0y21d3D9D3JB2r8wovtONOStx6', 'INATIVO', 'PROFESSOR', 'nao'),
(95, '3524013', 'DIEGO RENE SENS', '$2y$10$p5P57IdWm6V4LH85bJG0Z.PeaIITuWmwvUUV5IM840r9N7BFuHKby', 'ATIVO', 'PROFESSOR', 'nao'),
(96, '2257729', 'ELZILENE DE SALES DIAS NOGUEIRA', '$2y$10$635kmTNlVb9nI76u12wd2eqp9dXVnfk4k2ORBeb7qR/WTHH5zYJxG', 'ATIVO', 'PROFESSOR', 'nao'),
(97, '3124628', 'ENNE GOMES ALVES', '$2y$10$J6HwCXALPdggNqAYBQmtmOGld0KPDKh2slq7nkIhFz72EEYTOmlqy', 'ATIVO', 'PROFESSOR', 'nao'),
(98, '2323563', 'ENNIO WILLIAN LIMA SILVA', '$2y$10$giIO1tZnHkZyKjEZzqt8nOEQyzi00kedYbRNQcjHCjKoVMw5I.UOS', 'ATIVO', 'PROFESSOR', 'nao'),
(99, '1387805', 'FABIANO COUTO MILAGRES', '$2y$10$1k0hzsQjAaeIOt3QDOeWb.xUCcayOMipo7nCC9xePdn99j7db.D7S', 'INATIVO', 'PROFESSOR', 'nao'),
(100, '1727098', 'FLAVIO ROONY EVANGELISTA BARBOSA', '$2y$10$lp5gdaEeqgdGULxY.kT.quZUgbaxaENjIjCBSdko.91Xg6kiKoQrW', 'ATIVO', 'PROFESSOR', 'nao'),
(101, '2717454', 'FRANCINETE COSTA SOARES BARROSO', '$2y$10$LayVUBqGcRHZqsbZgvAJ1eCB2OmOGYGdsHowICIQ.8.to.bXGjpqi', 'ATIVO', 'PROFESSOR', 'nao'),
(102, '53815', 'FRANCISCO DE ASSIS BALBINO UCHOA', '$2y$10$yz3KgouEPzTFPkAJfJh3tuE4eTgm/U8Zb3D3e8zaKaOU7gM7zfEAi', 'ATIVO', 'PROFESSOR', 'nao'),
(103, '1131510', 'GESLANNY OLIVEIRA SOUSA', '$2y$10$Ehax/USZ.VmPx6mrPbm6T.95/mk8FK.aCMbpTfc4/7fSlKwmqil5m', 'ATIVO', 'PROFESSOR', 'nao'),
(104, '1785997', 'HENRIQUE ALMEIDA LIMA', '$2y$10$LIEAhxcjCpaCayf43wYyFepqfG9UoeRBO2sHGtBSi6qT/LK3I.g5e', 'ATIVO', 'PROFESSOR', 'nao'),
(105, '1163527', 'IDELFONSO COLARES DE FREITAS', '$2y$10$EqT4Bgxy0OASI8WNoYG3w.t21RkpN2npxdJm65dZ1IhnbrOUGW6M2', 'ATIVO', 'PROFESSOR', 'nao'),
(106, '3510634', 'IVONE NUNES DA CRUZ', '$2y$10$rADMXZV.SF3sdj9trNJ3N.k3goy0YwV6D5krczlBsQynTTglNMwtS', 'ATIVO', 'PROFESSOR', 'nao'),
(107, '2058624', 'JADER LUIZ GAMA DAS NEVES', '$2y$10$9FvTDHNu2rUqYsIlinW4Y.7e7vdgKFiHB/B30a8ClRq.XLSxUQiQ6', 'ATIVO', 'PROFESSOR', 'nao'),
(108, '3562068', 'JANAINA COSTA E SILVA', '$2y$10$ETq2nAou7inOMBd3DowjLemwrtwJyR9aF5s0ky2U5pdLHz2NFV3dq', 'ATIVO', 'PROFESSOR', 'nao'),
(109, '2103033', 'JOSAFA CARVALHO AGUIAR', '$2y$10$VqH/Ayqx3vQryKKWUHuw3eXo8D3SadYGX8c.PIBMJPV5n8RfqWQ6K', 'ATIVO', 'PROFESSOR', 'nao'),
(110, '1789869', 'JOSE CARLOS SILVA', '$2y$10$2Zv0d4sL8gfMk8oNe9K5j.taeYLXrqYq4LchI2wfUittl7EMq5MAa', 'ATIVO', 'PROFESSOR', 'nao'),
(111, '1221514', 'JOSE ELIEZI ALVES VIEIRA', '$2y$10$SQj2mY6/4I4pWwDquHFEDOF5ciLdAfjPqAJdOfjQq88shlTY5QhpW', 'ATIVO', 'PROFESSOR', 'nao'),
(112, '1691967', 'JULIANA BARROS CARVALHO', '$2y$10$bGwyW2dLr8WfsxphY2ObsecHHKR05GBQ2Zf6F5we9foTOehCvT6jy', 'ATIVO', 'PROFESSOR', 'nao'),
(113, '3069475', 'KALINDY MARESSA SOARES MONTEIRO', '$2y$10$WwuhDh6YcSxBjoOVhiw3nuRqQ8ps0MayPNhpOcMXMrKeq0kyMGPXu', 'ATIVO', 'PROFESSOR', 'nao'),
(114, '2034811', 'KERLLY KARINE PEREIRA HERENIO', '$2y$10$A2i1zwUDOkObpb/v/x/jjOiCHny4XxMmXDVqBvi3CtJ4qzXVC2YY2', 'ATIVO', 'PROFESSOR', 'nao'),
(115, '3001636', 'LEONARDO CORREA DA SILVA', '$2y$10$qfXblLwn7mmK4o6N0tUj5uAq9lLcETafNxxArDmmloxBesSOv/ki6', 'ATIVO', 'PROFESSOR', 'nao'),
(116, '1808243', 'LUCINALVA FERREIRA', '$2y$10$0hiaa9wKLXoXA.dwQ7mhE.M1azUefyYjIiLnL7lB3Jdrr3FzWoRwi', 'ATIVO', 'PROFESSOR', 'nao'),
(117, '1870765', 'MARCIO ROGERIO PEREIRA LEITE', '$2y$10$khZzKu/JbifI32XvVA4JBusq3XEKoeUyjCZ9aFwyDIEK3ov.i3z1K', 'ATIVO', 'PROFESSOR', 'nao'),
(118, '1318657', 'MARCO AURELIO GOMES DE OLIVEIRA', '$2y$10$lnfspQVtAaJJz/6QlW55ou54b5IZPdpWypBUvMMj5PRVON5IWwZIm', 'ATIVO', 'PROFESSOR', 'nao'),
(119, '2975015', 'MARCOS AURELIO QUEIROZ', '$2y$10$dF0zuiykZ65HV/yfXPEY3OcRD/f/JeR/LqEFY2u8DAK3Jl7cvuZMG', 'ATIVO', 'PROFESSOR', 'nao'),
(120, '2994430', 'MARCOS JAERCIO DO NASCIMENTO SILVA', '$2y$10$hgo3Ub6gD3mqGAIfWHmB4uVXu0mMfWJuoTBqH6F8yubsvTltmyyZS', 'ATIVO', 'PROFESSOR', 'nao'),
(121, '1104886', 'MARIA JOSINETE ARAUJO COSTA', '$2y$10$.Lm1.Kx24urceSHD/o157Ofi47QXR74gRaARLX1rP0alWUp0M.toW', 'ATIVO', 'PROFESSOR', 'nao'),
(122, '3053690', 'MATEUS DE SOUSA PAULA', '$2y$10$1AAf..8aJwNnuEvDwNYLY./DancAcDS1NZoHkCN3/DREhSz2ilzCS', 'ATIVO', 'PROFESSOR', 'nao'),
(123, '53757', 'MIGUEL CAMARGO DA SILVA', '$2y$10$TRB6JaLhg10FCduaD4/LYuBDlh7rcF3gq0J84KVbTuNR017he9zb.', 'ATIVO', 'PROFESSOR', 'nao'),
(124, '1300276', 'MILTON PROCOPIO DE BORBA', '$2y$14$ywHnz1/naTgIOsbQeL9MbO8tIWSvxHQ44SQOxTfdLUIw704m5gFC6', 'ATIVO', 'PROFESSOR', 'nao'),
(125, '2144871', 'MOISES LAURENCE DE FREITAS LIMA JUNIOR', '$2y$10$KCfqQjID/MIaKCNUxxP8jOU1/kLdoIVN3Nj9noaHt2t7CQnIVyBcq', 'ATIVO', 'PROFESSOR', 'nao'),
(126, '53165', 'NELSON RAFAEL DA SILVA', '$2y$10$IR56Evkewm.VRClmqCznb.No6GH3qXXovtqcO/3gT6B.Nd4.d1hHu', 'ATIVO', 'PROFESSOR', 'nao'),
(127, '2671931', 'POLIANA MENDES AVELINO DE CARVALHO', '$2y$10$HemdFJuD5ijCuNs6ixu/QuzCiSLesg4.RoFLA4r64poDqoQmA1aUy', 'ATIVO', 'PROFESSOR', 'nao'),
(128, '1786031', 'QUITERIA COSTA DE ALCANTARA OLIVEIRA', '$2y$10$b60rxacmwAb1m15WxG3LyecL/oxjNFlL7B7CPEm5Znijds5ZmFHYm', 'ATIVO', 'PROFESSOR', 'nao'),
(129, '1033441', 'RAIMUNDO FRANCISCO DOS SANTOS FILHO', '$2y$10$sN0m2G5y9vQb0k1rMRNnC./It3/LoC9ey6v70pdXPyTWlZFhXIBMi', 'ATIVO', 'PROFESSOR', 'nao'),
(130, '1796962', 'ROBERTA DE FREITAS SOUZA LOBO', '$2y$10$iFzi655bAGhV91S8ToiFKu0VnIokOULBGF8FW9.cybpXJHqXbJm7e', 'ATIVO', 'PROFESSOR', 'nao'),
(131, '2489616', 'ROGERIO PEREIRA DE SOUSA', '$2y$10$OQ31eG2mn3dGsyGB8JpOwuz0UrJsEYGxTD3fA.by90i5VDmx8KFnG', 'ATIVO', 'PROFESSOR', 'nao'),
(132, '3370320', 'RUY BORGES DA SILVA', '$2y$10$HGbe9FOtk1m0KRU0M13X3.mMlgcF526I6qtAZl.ELMo3UPoseDKjm', 'ATIVO', 'PROFESSOR', 'nao'),
(133, '1016569', 'SAMUEL DE DEUS DA SILVA', '$2y$10$lPHnt4MRnkjA4rz476ClRuRmOMfz300.oz/oF7hXVVDt/0U4aJYK2', 'ATIVO', 'PROFESSOR', 'nao'),
(134, '2385200', 'SILVIA FERNANDES NUNES RAMALHO', '$2y$10$ZPfFP8Ci6opuMBYP/whDsumUo.I5cJLJ/CDIB9YBV0eE6VNlwYkPm', 'ATIVO', 'PROFESSOR', 'nao'),
(135, '1045926', 'SORAYA FREITAS SILVA', '$2y$10$TcI37I23XsvDyX2B7dOBh.VpDriw2xOSbFnD.R4DtK04I7dIwkvTS', 'ATIVO', 'PROFESSOR', 'nao'),
(136, '1726819', 'TARCISIO DA SILVA VIEIRA', '$2y$10$DK7YGS/hNygQ5yzSIYuoruS.QjmRXt.hxl9Tt6iAgLcVcCNCP8Ql6', 'ATIVO', 'PROFESSOR', 'nao'),
(137, '1796239', 'THIAGO DE LOIOLA ARAUJO E SILVA', '$2y$10$wULNeuEEJ5bHCS.PBP.MIuxjkPmNz7Et.MpAFAaWbYw15.YpPco5W', 'ATIVO', 'PROFESSOR', 'nao'),
(138, '3607821', 'WISLAYNE AIRES MOREIRA', '$2y$10$SXokpRSA1gVDuWq15LPHLemlSCYsTvT0QRetyiiAfT/GgF/tCT12S', 'ATIVO', 'PROFESSOR', 'nao'),
(139, '1811833', 'WYRATAN DA SILVA SANTOS', '$2y$10$dunTAwMfXDm4srHzDD.wMe89LYTPSQbgYTGaVnThlfobjt4jk7ZU.', 'ATIVO', 'PROFESSOR', 'nao'),
(140, '65536797387', 'KELLY CRISTINA FIGUEIREDO GUIMARÃES', '$2y$14$qeXzR1RQlm3DWozvMgvTU.BaCl9vQLjUZIhIq3avx0kh9OkTB1Hua', 'ATIVO', 'PROFESSOR', 'nao'),
(141, '97069876149', 'CLEUDIANE CHAVES DA SILVA', '$2y$14$xwsiRmI8PABtTwQowK7Vmu4LqfQcuA1NQ69wTRfOgX92B0Mf4DUm2', 'ATIVO', 'ADMINISTRADOR', 'nao'),
(145, '58074856704', ' Priscila Isabela das Neves', '$2y$14$6RdMoM0Yu3YvqgIbS6X4U.IEoHwhbsbtSm4jMtD7BT6nVAqXSwcRe', 'ATIVO', 'PROFESSOR', 'nao'),
(144, '43355524590', ' Juliana Isabelly Oliveira', '$2y$14$PDj6oG/Ko1qMylgYnYojieMXUGSwYViMvzDwigHr0SMVU3drWVzhG', 'INATIVO', 'PROFESSOR', 'nao'),
(146, '79703739172', 'SIDNEY TEIXEIRA', '$2y$14$M6qOEoD2gXBq.8HBkRnBkePfQu6XlNZAA1MA.sS0ZVttFtgaBF.iC', 'ATIVO', 'PROFESSOR', 'nao'),
(147, '00991610105', 'Edvar de Sousa da Silva', '$2y$14$5fkqIeD0X0ib3DkLVhNOmuIWIkStvRzWHUgeJgze6Nn4.qD9gQaXC', 'ATIVO', 'PROFESSOR', 'nao'),
(148, '02754005307', 'Alexandre da Silva Sousa', '$2y$14$ezyPtM2OSCDvCUDR51JyA.vrKJbv7Ka.qerXtC5M28porOW9gWW/2', 'ATIVO', 'PROFESSOR', 'nao'),
(149, '39744213191', 'Edivaldo Monteiro de Sousa', '$2y$14$INKVhzOgB/n/F5KbWGa0YOP0iSQOu3.q2XDmKv00U5eXQKjXUgGUi', 'ATIVO', 'PROFESSOR', 'nao'),
(150, '03163177131', 'Cristiely Maria de Sousa Alves de Oliveira', '$2y$14$JsEvVR59EFcv3.kr.C4gaeW7dpcEu4CsMfy.VmAafRoX04ig.kC4y', 'ATIVO', 'PROFESSOR', 'nao'),
(151, '11852401796', 'Isabela Duarte Fernandes', '$2y$14$ZuORUfAzFN6Wc9vC1.Mm9.PSqBXeflpuAQnz84bn.kijAC9PCI8bm', 'ATIVO', 'PROFESSOR', 'nao'),
(152, '07196400674', 'Alexandre Aparecido de Almeida', '$2y$14$SuNIPIELlFSZVhYvRFiQ..kxfNWvSzVgq7R7BHzM0.dn2a0ddcbMK', 'ATIVO', 'PROFESSOR', 'nao'),
(153, '04628700141', 'Alex Pereira de Sousa', '$2y$14$MphREcJIRjMxR0Tr4fCYQe5x7AFHZ4NyQJBRTfoyQDZT6qusWjdVW', 'ATIVO', 'PROFESSOR', 'nao'),
(154, '88346501153', 'Pedro Pereira Cortes Filho', '$2y$14$mbx51Gt.hYVM48ZdrLoWw.AhSufIBbCIBOTs3cUfstON5DIT8zhB.', 'ATIVO', 'PROFESSOR', 'nao'),
(155, '11717725643', 'Matheus Batista Barboza Coimbra', '$2y$14$186m/df0GqjYhJurP2WwxOTnzvC7LJhAhpICUTKHlP6U0lOTMXGBq', 'ATIVO', 'PROFESSOR', 'nao'),
(156, '80579531015', 'Pedro Saldanha Frantz', '$2y$14$z/DSbElEmzttR3XhRiRQ7e04n8rWV.Ri8gGO4C.k.2iHrG3FVRGD6', 'ATIVO', 'PROFESSOR', 'nao'),
(157, '00615230113', 'André Inácio de Assunção Neto', '$2y$14$tCLOw6dVT49NcZjmTemeDe9F8JD89Yd.ibdBlzfF8WSRptj4woaLC', 'ATIVO', 'PROFESSOR', 'nao'),
(158, '73874990397', 'Maukers Alem Lima Dias', '$2y$14$ReknYLojA7hXZ899O73rauvv.CcZcN55.dTb/nd9sWUPWSS2BUGPu', 'ATIVO', 'PROFESSOR', 'nao'),
(159, '00888157142', 'Cristiane do Prado Marques Marinho ', '$2y$14$JG/B3nMXqXmLoWVsTZRr9.QGcLvQjr5FOxVYEHZFhf.cLBIv5ETni', 'ATIVO', 'PROFESSOR', 'nao'),
(160, '60222080337', 'Gessica Xavier Torres', '$2y$14$86LDH.8bLlg5u.n1hVa/MO498a8NwQXqgc53KDK9LfBSCXuFfyL/6', 'ATIVO', 'PROFESSOR', 'nao'),
(161, '00104490357', 'Rafael Pereira Soares da Rocha', '$2y$14$2bH/kvVFThnLIq/4Zp4YLe8YOTPMufYx2conLgTiP6vX.fg1XPdC2', 'ATIVO', 'PROFESSOR', 'nao'),
(162, '00440579384', 'ANTONIO GUANACUY ALMEIDA MOURA', '$2y$14$9LqXcl5RJY/7Q038rceHKO4FTIqA0fFPy3nETZDIGFdILCyoHAY12', 'ATIVO', 'PROFESSOR', 'nao'),
(163, '90015274187', 'ILSAMAR MENDES SOARES', '$2y$14$BbtpmeYvsbmE2Zevzl9uK.rNJUB6q4wvN1Ub15oZG3uH.PhxX66xW', 'ATIVO', 'PROFESSOR', 'nao'),
(164, '33417750300', 'Deuzineia de Araújo Costa', '$2y$14$6u1Hk.JoH.BCkhsi0BzXoOwg5bbU42OXcVMuQe73LvJgVY515Or82', 'ATIVO', 'PROFESSOR', 'nao');

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor_disciplina`
--

DROP TABLE IF EXISTS `professor_disciplina`;
CREATE TABLE IF NOT EXISTS `professor_disciplina` (
  `discpro_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `discpro_professor_id` bigint(20) NOT NULL,
  `discpro_disciplina_id` bigint(20) NOT NULL,
  PRIMARY KEY (`discpro_id`),
  KEY `index_fk` (`discpro_professor_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `professor_disciplina`
--

INSERT INTO `professor_disciplina` (`discpro_id`, `discpro_professor_id`, `discpro_disciplina_id`) VALUES
(2, 78, 1),
(3, 78, 2),
(4, 77, 1),
(5, 77, 2),
(6, 77, 6);

-- --------------------------------------------------------

--
-- Estrutura da tabela `turma`
--

DROP TABLE IF EXISTS `turma`;
CREATE TABLE IF NOT EXISTS `turma` (
  `codturma` int(11) NOT NULL AUTO_INCREMENT,
  `periodoletivo` varchar(45) DEFAULT NULL,
  `sala` varchar(45) DEFAULT NULL,
  `codprof` int(11) DEFAULT NULL,
  `coddisc` int(11) DEFAULT NULL,
  PRIMARY KEY (`codturma`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `turma`
--

INSERT INTO `turma` (`codturma`, `periodoletivo`, `sala`, `codprof`, `coddisc`) VALUES
(1, '2019', '1', 1, 1),
(2, '2019', '2', 1, 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
