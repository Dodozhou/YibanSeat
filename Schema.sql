
DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seat` (
  `seat_num` varchar(45) NOT NULL,
  `owner` int(11) NOT NULL,
  `speach` int(11) NOT NULL,
  `signed` boolean DEFAULT false,
  PRIMARY KEY (`speach`,`seat_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `speach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `speach` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `speaker` varchar(45) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `place` varchar(45) DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL,
  `state` int DEFAULT 0 NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `speach` WRITE;
/*!40000 ALTER TABLE `speach` DISABLE KEYS */;
INSERT INTO `speach` VALUES (1,'\"心怀感恩，励志奋进\"大学生励志成长事迹报告会','周成','\"心怀感恩，励志奋进\"大学生励志成长事迹报告会','图书馆报告厅','10-20 14:30');
/*!40000 ALTER TABLE `speach` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `yiban_id` varchar(45) unique DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


