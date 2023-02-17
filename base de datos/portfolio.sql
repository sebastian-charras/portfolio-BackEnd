CREATE DATABASE  IF NOT EXISTS `portfolio` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `portfolio`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: portfolio
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `education`
--

DROP TABLE IF EXISTS `education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `education` (
  `id` int NOT NULL AUTO_INCREMENT,
  `institution` int DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `period` varchar(100) NOT NULL,
  `completed` tinyint DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `institution` (`institution`),
  CONSTRAINT `education_fk_1` FOREIGN KEY (`institution`) REFERENCES `institution` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education`
--

LOCK TABLES `education` WRITE;
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
INSERT INTO `education` VALUES (2,NULL,'Bachiller en Ciencias Sociales','2015 - 2020',1,NULL),(4,NULL,'Técnico Superior en Informática Aplicada','Feb. 2021 - Mar. 2024 (estimado)',0,NULL),(5,NULL,'Curso de Desarrollo Web Front-end','2022',1,NULL),(6,NULL,'Curso de Javascript Desarrollador Avanzado','2021',1,NULL),(7,NULL,'Curso de Python para no programadores','2021',1,NULL),(8,NULL,'Curso de Python programming','2021',1,NULL),(9,NULL,'Primera etapa del Plan Argentina Programa - #SéProgramar','2022',1,NULL),(10,NULL,'Segunda etapa del Plan Argentina Programa - #YoProgramo','2022 - 2023',0,NULL);
/*!40000 ALTER TABLE `education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institution`
--

DROP TABLE IF EXISTS `institution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `institution` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `logo_url` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institution`
--

LOCK TABLES `institution` WRITE;
/*!40000 ALTER TABLE `institution` DISABLE KEYS */;
INSERT INTO `institution` VALUES (1,'UTN-INSPT','https://sp-ao.shortpixel.ai/client/to_webp,q_glossy,ret_img/https://inspt.utn.edu.ar/wp-content/uploads/2021/08/utn_inspt_logo_iso_.png'),(2,'Escuela de Educación Media N° 8 Dr. Antonio Sagarna (anteriormente Colegio Nacional de San Isidro)',NULL),(3,'Centro Universitario Vicente López','https://www.vicentelopez.gov.ar/centrouniversitariovl/assets/images/logo-navbar-200.png'),(4,'Educación IT','https://static.educacionit.com/educacionit/assets/imagotype-it-fill-v2-color.svg'),(5,'Argentina Programa','https://argentinaprograma.inti.gob.ar/pluginfile.php/1/theme_moove/logo/1676134779/Dise%C3%B1o%20sin%20t%C3%ADtulo%20(17).png');
/*!40000 ALTER TABLE `institution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `surname` varchar(100) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL,
  `email` varchar(500) DEFAULT NULL,
  `github_url` varchar(500) DEFAULT NULL,
  `linkedin_url` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (2,'Sebastian','Charras','Full Stack Developer Jr','Desarrollo aplicaciones web, desde el diseño y la implementación de la interfaz gráfica hasta la base de datos, api y el servidor.','sebastiancharras@outlook.com','https://github.com/sebastian-charras','https://www.linkedin.com/in/sebastian-charras-991239208/');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `period` varchar(100) NOT NULL,
  `completed` tinyint DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (2,'Portfolio Web','2022',1,'Portfolio Web con algunos proyectos front end','https://dashing-mousse-4065dd.netlify.app/'),(3,'Portfolio Web','2023',0,'Portfolio con proyectos personales, habilidades, educación y experiencias laborales',''),(4,'Sistema de Gestión para Guardería de Vehículos','2023',1,'Sistema para visualizar y gestionar datos de una hipotética guardería de vehículos, incluídos sus administradores, empleados, garages, socios, vehículos y zonas',NULL),(5,'Weather Channel','2022',1,'Permite ver datos meteorológicos de la ubicación seleccionada','https://incandescent-crostata-2ea2ef.netlify.app/'),(6,'To Do List','2022',1,'Lista de pendientes, proyecto frontend','https://teal-beijinho-232898.netlify.app/'),(7,'The Great Guessing Game','2022',1,'Juego para adivinar qué color es el representado por el valor rgb dado','https://resilient-sunburst-78181f.netlify.app/');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `percentage` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (1,'HTML',85),(2,'CSS',90),(3,'Javascript',85),(4,'Java',95),(5,'SQL',70),(6,'Español',100),(7,'Inglés',85);
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_experience`
--

DROP TABLE IF EXISTS `work_experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_experience` (
  `id` int NOT NULL AUTO_INCREMENT,
  `institution` int DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `period` varchar(100) NOT NULL,
  `completed` tinyint DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `institution` (`institution`),
  CONSTRAINT `work_experience_fk_1` FOREIGN KEY (`institution`) REFERENCES `institution` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_experience`
--

LOCK TABLES `work_experience` WRITE;
/*!40000 ALTER TABLE `work_experience` DISABLE KEYS */;
INSERT INTO `work_experience` VALUES (1,NULL,'Pasante Administrativo','Jul. 2022 - Feb. 2023',1,'Realicé tareas en su mayor parte administrativas. También desarrollé un prototipo de sistema para visualizar certificados digitales usando html, css, javascript, java, spring y mysql');
/*!40000 ALTER TABLE `work_experience` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-17 17:31:40
