DROP TABLE IF EXISTS `visualization_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visualization_data` (
  `visualization_id` int(11) NOT NULL,
  PRIMARY KEY (`visualization_id`,`visualization_id`),
  `name` varchar(255) NOT NULL,
  `data` varchar(255) NOT NULL,
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;