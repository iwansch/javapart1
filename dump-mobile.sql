-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mobile
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `abonent`
--

DROP TABLE IF EXISTS `abonent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `abonent` (
  `abonent_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `gender` enum('m','f') NOT NULL,
  `age` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`abonent_id`),
  UNIQUE KEY `abonent_id_UNIQUE` (`abonent_id`),
  KEY `abonent_id_index` (`abonent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abonent`
--

LOCK TABLES `abonent` WRITE;
/*!40000 ALTER TABLE `abonent` DISABLE KEYS */;
/*!40000 ALTER TABLE `abonent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operator`
--

DROP TABLE IF EXISTS `operator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operator` (
  `operator_id` int(10) unsigned NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(100) NOT NULL,
  PRIMARY KEY (`operator_id`),
  UNIQUE KEY `operator_id_UNIQUE` (`operator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operator`
--

LOCK TABLES `operator` WRITE;
/*!40000 ALTER TABLE `operator` DISABLE KEYS */;
INSERT INTO `operator` VALUES (1,'Life','ул. Мироносицкая 12'),(2,'Vodafone','ул. Сумская  14'),(3,'Kievstar','ул. Петровского  17');
/*!40000 ALTER TABLE `operator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operator_number`
--

DROP TABLE IF EXISTS `operator_number`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operator_number` (
  `number` char(12) NOT NULL,
  `operator_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`number`),
  UNIQUE KEY `number_UNIQUE` (`number`),
  KEY `fk_operator_id_idx` (`operator_id`),
  KEY `fk_number_idx` (`number`),
  CONSTRAINT `fk_operator_id` FOREIGN KEY (`operator_id`) REFERENCES `operator` (`operator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operator_number`
--

LOCK TABLES `operator_number` WRITE;
/*!40000 ALTER TABLE `operator_number` DISABLE KEYS */;
INSERT INTO `operator_number` VALUES ('380730000001',1),('380730000002',1),('380500000001',2),('380500000002',2),('380500000003',2),('380500000004',2),('380970000001',3),('380970000002',3),('380970000003',3);
/*!40000 ALTER TABLE `operator_number` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_book`
--

DROP TABLE IF EXISTS `phone_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone_book` (
  `number` char(12) NOT NULL,
  `abonent_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`number`),
  UNIQUE KEY `number_UNIQUE` (`number`),
  KEY `abonent_id_index` (`abonent_id`),
  CONSTRAINT `fk_abonent_id` FOREIGN KEY (`abonent_id`) REFERENCES `abonent` (`abonent_id`),
  CONSTRAINT `fk_number` FOREIGN KEY (`number`) REFERENCES `operator_number` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_book`
--

LOCK TABLES `phone_book` WRITE;
/*!40000 ALTER TABLE `phone_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `phone_book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-23 15:52:03
