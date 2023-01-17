CREATE DATABASE  IF NOT EXISTS `hibernate-tutorial-2-one-to-one-mapping` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hibernate-tutorial-2-one-to-one-mapping`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hibernate-tutorial-2-one-to-one-mapping
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` text,
  `last_name` text,
  `email` text,
  `instructor_detail_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `key_idx` (`instructor_detail_id`),
  CONSTRAINT `instructor_detail_id` FOREIGN KEY (`instructor_detail_id`) REFERENCES `instructor_detail` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES (3,'Madhu','Patel','madhu@luv2code.com',4),(4,'Madhu','Patel','madhu@luv2code.com',5),(6,'Bb','Bcd','b@marvelmail.com',0),(7,'Hue','Jackman','huejack@marvelmail.com',8),(8,'Bb','Bcd','b@marvelmail.com',9),(9,'Hue','Jackman','huejack@marvelmail.com',10),(10,'Hue','Jackman','huejack@marvelmail.com',11),(11,'Hue','Jackman','huejack@marvelmail.com',12),(12,'Billy','Newman','bnew@loremmail.com',15),(13,'Billy','Newman','bnew@loremmail.com',17),(14,'Bb','Bcd','b@marvelmail.com',18),(15,'Hue','Jackman','huejack@marvelmail.com',19),(16,'Billy','Newman','bnew@loremmail.com',21);
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor_detail`
--

DROP TABLE IF EXISTS `instructor_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `youtube_channel` text,
  `hobby` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor_detail`
--

LOCK TABLES `instructor_detail` WRITE;
/*!40000 ALTER TABLE `instructor_detail` DISABLE KEYS */;
INSERT INTO `instructor_detail` VALUES (4,'http://www.youtube.com','Guitar'),(5,'http://www.youtube.com','Guitar'),(7,'Bchannel','Bhobby'),(8,'CrazyGoodChannel','sky-diving'),(9,'Bchannel','Bhobby'),(10,'CrazyGoodChannel','sky-diving'),(11,'CrazyGoodChannel','sky-diving'),(12,'CrazyGoodChannel','sky-diving'),(15,'BillyTeachYouDriving','dancing'),(17,'BillyTeachYouDriving','dancing'),(18,'Bchannel','Bhobby'),(19,'CrazyGoodChannel','sky-diving'),(21,'BillyTeachYouDriving','dancing');
/*!40000 ALTER TABLE `instructor_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-17 23:40:41
