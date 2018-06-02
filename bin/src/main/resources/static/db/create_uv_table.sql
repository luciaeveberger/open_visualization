DROP TABLE IF EXISTS `uv_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uv_data` (
  `uv_data_id` int(11) NOT NULL,
  PRIMARY KEY (`uv_data_id`,`uv_data_id`),
  `date` datetime NOT NULL,
  `RE1_UVB` INT (255) NOT NULL,
  `RE1_T_UVB` INT(255) NOT NULL,
  `RE1_UVA`  INT(255) NOT NULL,
  `RE1_T_UVA` INT(255) NOT NULL,
  `LS1_UVB` INT(255) NOT NULL,
  `LS1_T_UVB` INT(255) NOT NULL,
  `LS1_UVA` INT(255) NOT NULL,
  `LS1_T_UVA` INT(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;