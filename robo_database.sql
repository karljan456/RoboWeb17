CREATE DATABASE  IF NOT EXISTS `robot_project` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `robot_project`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: robot_project
-- ------------------------------------------------------
-- Server version	5.7.41-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `controlsettings`
--

DROP TABLE IF EXISTS `controlsettings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `controlsettings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `command` int(11) DEFAULT NULL,
  `command_string` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `controlsettings`
--

LOCK TABLES `controlsettings` WRITE;
/*!40000 ALTER TABLE `controlsettings` DISABLE KEYS */;
INSERT INTO `controlsettings` VALUES (1,0,'Program stop'),(2,1,'Follow line'),(3,2,'Turning left'),(4,3,'Go forward'),(5,4,'Go right'),(6,5,'Go backwards'),(7,6,'Stop(pause)'),(8,7,'Play music'),(9,8,'Dance'),(10,9,'Flash lights');
/*!40000 ALTER TABLE `controlsettings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `robodata`
--

DROP TABLE IF EXISTS `robodata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `robodata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `end_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `obstacle_detection` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `robodata`
--

LOCK TABLES `robodata` WRITE;
/*!40000 ALTER TABLE `robodata` DISABLE KEYS */;
INSERT INTO `robodata` VALUES (1,'2023-05-03 08:29:18',1);
/*!40000 ALTER TABLE `robodata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-03 13:44:50
