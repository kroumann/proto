-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: protodb
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `cat_id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(50) NOT NULL,
  `cat_desc` text NOT NULL,
  `cat_image` varchar(100) NOT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Téléphones','Téléphones portables haut de gamme','https://gdurl.com/Rv11'),(2,'Tablettes','Tablettes les plus recherchées sur le marché, appareils hauts de gamme','https://gdurl.com/nRRN'),(3,'Services et Reparations','Services proposés par notre centre agrée par les plus grands fabricants du monde.','https://gdurl.com/PwJM'),(4,'Imprimantes et Consommables','Imprimantes multifonctions et consommables associés','https://gdurl.com/pgWP'),(5,'Composants','Composants matériels pour mise à niveau et amélioration de performances de vos ordinateurs.','https://gdurl.com/krU5'),(6,'Écrans ou moniteurs d\'ordinateurs','Écrans de PC bureautiques pour tous les goûts (jeux, développement, design...)','https://gdurl.com/OHfy'),(7,'Les mini ordinateurs','PC avec un budget sur mesure et entièrement adapter à vos besoins','https://gdurl.com/NedR'),(8,'Logiciels et Outils','Logiciels et outils pour faciliter vos travaux de développement et études','https://gdurl.com/hlB9'),(9,'Ordinateurs Portables','Ordinateurs portables pré-configurer pour toutes sortes d\'utilisation','https://gdurl.com/jwbQ'),(10,'Ordinateurs Bureautiques','Catégories des Ordinateurs bureautiques pour les entreprises et utilisateurs en quête de puissance','https://gdurl.com/dnOg'),(11,'Télévisions','TV et Smart TV dernière génération de toutes les tailles et de resolutions','https://gdurl.com/qivw');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-31 15:54:41
