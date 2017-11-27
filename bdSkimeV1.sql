-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: SkimeV1
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Amigos`
--

DROP TABLE IF EXISTS `Amigos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Amigos` (
  `idAmigos` int(6) NOT NULL AUTO_INCREMENT,
  `idAmigo1` int(6) DEFAULT NULL,
  `idAmigo2` int(6) DEFAULT NULL,
  PRIMARY KEY (`idAmigos`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Amigos`
--

LOCK TABLES `Amigos` WRITE;
/*!40000 ALTER TABLE `Amigos` DISABLE KEYS */;
/*!40000 ALTER TABLE `Amigos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Avatar`
--

DROP TABLE IF EXISTS `Avatar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Avatar` (
  `idAvatar` int(6) NOT NULL AUTO_INCREMENT,
  `idTipoAnimal` int(6) DEFAULT NULL,
  `Monedas` int(10) DEFAULT NULL,
  PRIMARY KEY (`idAvatar`),
  KEY `idTipoAnimal` (`idTipoAnimal`),
  CONSTRAINT `avatar_ibfk_1` FOREIGN KEY (`idTipoAnimal`) REFERENCES `TipoAnimal` (`idTipoAnimal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Avatar`
--

LOCK TABLES `Avatar` WRITE;
/*!40000 ALTER TABLE `Avatar` DISABLE KEYS */;
/*!40000 ALTER TABLE `Avatar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AvatarItem`
--

DROP TABLE IF EXISTS `AvatarItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AvatarItem` (
  `idAvatarItem` int(6) NOT NULL AUTO_INCREMENT,
  `idItem` int(6) DEFAULT NULL,
  `idAvatar` int(6) DEFAULT NULL,
  PRIMARY KEY (`idAvatarItem`),
  KEY `idItem` (`idItem`),
  KEY `idAvatar` (`idAvatar`),
  CONSTRAINT `avataritem_ibfk_1` FOREIGN KEY (`idItem`) REFERENCES `Item` (`idItem`),
  CONSTRAINT `avataritem_ibfk_2` FOREIGN KEY (`idAvatar`) REFERENCES `Avatar` (`idAvatar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AvatarItem`
--

LOCK TABLES `AvatarItem` WRITE;
/*!40000 ALTER TABLE `AvatarItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `AvatarItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Elemento`
--

DROP TABLE IF EXISTS `Elemento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Elemento` (
  `idElemento` int(6) NOT NULL AUTO_INCREMENT,
  `idLista` int(6) DEFAULT NULL,
  `NombreElemento` varchar(65) DEFAULT NULL,
  `FechaInit` datetime DEFAULT NULL,
  `FechaEnd` datetime DEFAULT NULL,
  `CostoElemento` float DEFAULT NULL,
  `Monto` float DEFAULT NULL,
  `ProgresoElemento` float DEFAULT NULL,
  PRIMARY KEY (`idElemento`),
  KEY `idLista` (`idLista`),
  CONSTRAINT `elemento_ibfk_1` FOREIGN KEY (`idLista`) REFERENCES `Lista` (`idLista`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Elemento`
--

LOCK TABLES `Elemento` WRITE;
/*!40000 ALTER TABLE `Elemento` DISABLE KEYS */;
/*!40000 ALTER TABLE `Elemento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Item`
--

DROP TABLE IF EXISTS `Item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Item` (
  `idItem` int(6) NOT NULL AUTO_INCREMENT,
  `NombreItem` varchar(30) DEFAULT NULL,
  `URLImgItem` varchar(65) DEFAULT NULL,
  `Costo` float DEFAULT NULL,
  PRIMARY KEY (`idItem`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Item`
--

LOCK TABLES `Item` WRITE;
/*!40000 ALTER TABLE `Item` DISABLE KEYS */;
/*!40000 ALTER TABLE `Item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Lista`
--

DROP TABLE IF EXISTS `Lista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Lista` (
  `idLista` int(6) NOT NULL AUTO_INCREMENT,
  `NombreLista` varchar(65) DEFAULT NULL,
  `ProgresoLista` float DEFAULT NULL,
  PRIMARY KEY (`idLista`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Lista`
--

LOCK TABLES `Lista` WRITE;
/*!40000 ALTER TABLE `Lista` DISABLE KEYS */;
/*!40000 ALTER TABLE `Lista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MetaColectiva`
--

DROP TABLE IF EXISTS `MetaColectiva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MetaColectiva` (
  `idMetaColectiva` int(6) NOT NULL AUTO_INCREMENT,
  `NombreMeta` varchar(65) DEFAULT NULL,
  `DescripcionMeta` varchar(280) DEFAULT NULL,
  `CostoMeta` float DEFAULT NULL,
  `MontoMeta` float DEFAULT NULL,
  `ProgresoMeta` float DEFAULT NULL,
  PRIMARY KEY (`idMetaColectiva`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MetaColectiva`
--

LOCK TABLES `MetaColectiva` WRITE;
/*!40000 ALTER TABLE `MetaColectiva` DISABLE KEYS */;
/*!40000 ALTER TABLE `MetaColectiva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MetaUsuario`
--

DROP TABLE IF EXISTS `MetaUsuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MetaUsuario` (
  `idMetaUsuario` int(6) NOT NULL AUTO_INCREMENT,
  `idMetaColectiva` int(6) DEFAULT NULL,
  `idUsuario` int(6) DEFAULT NULL,
  `MontoMetaUsuario` float DEFAULT NULL,
  PRIMARY KEY (`idMetaUsuario`),
  KEY `idMetaColectiva` (`idMetaColectiva`),
  KEY `idUsuario` (`idUsuario`),
  CONSTRAINT `metausuario_ibfk_1` FOREIGN KEY (`idMetaColectiva`) REFERENCES `MetaColectiva` (`idMetaColectiva`),
  CONSTRAINT `metausuario_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MetaUsuario`
--

LOCK TABLES `MetaUsuario` WRITE;
/*!40000 ALTER TABLE `MetaUsuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `MetaUsuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoAnimal`
--

DROP TABLE IF EXISTS `TipoAnimal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TipoAnimal` (
  `idTipoAnimal` int(6) NOT NULL AUTO_INCREMENT,
  `NombreAnimal` varchar(30) DEFAULT NULL,
  `URLImgAnimal` varchar(65) DEFAULT NULL,
  PRIMARY KEY (`idTipoAnimal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoAnimal`
--

LOCK TABLES `TipoAnimal` WRITE;
/*!40000 ALTER TABLE `TipoAnimal` DISABLE KEYS */;
/*!40000 ALTER TABLE `TipoAnimal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `idUsuario` int(6) NOT NULL AUTO_INCREMENT,
  `idAvatar` int(6) DEFAULT NULL,
  `Nombre` varchar(65) DEFAULT NULL,
  `Nickname` varchar(20) DEFAULT NULL,
  `Email` varchar(40) DEFAULT NULL,
  `Contraseña` varchar(25) DEFAULT NULL,
  `Edad` int(3) DEFAULT NULL,
  `IngresoFijo` float DEFAULT NULL,
  `IngresoPeriodo` int(4) DEFAULT NULL,
  `ProgresoTotal` float DEFAULT NULL,
  `AhorroTotal` float DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `idAvatar` (`idAvatar`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`idAvatar`) REFERENCES `Avatar` (`idAvatar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-27 14:17:45
