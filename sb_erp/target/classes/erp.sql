-- MySQL dump 10.11
--
-- Host: 127.0.0.1    Database: erp
-- ------------------------------------------------------
-- Server version	5.0.67-community-nt

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
-- Table structure for table `apply`
--

DROP TABLE IF EXISTS `apply`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `apply` (
  `apply_id` int(11) NOT NULL auto_increment,
  `apply_type` varchar(255) collate utf8_bin default NULL,
  `apply_status` varchar(255) collate utf8_bin default NULL,
  `property_name` varchar(255) collate utf8_bin default NULL,
  `property_type` varchar(255) collate utf8_bin default NULL,
  `property_model` varchar(255) collate utf8_bin default NULL,
  `property_num` int(11) default NULL,
  `unit_price` double default NULL,
  `total_price` double default NULL,
  `apply_user_id` int(11) default NULL,
  `approve_user_id` int(11) default NULL,
  `apply_date` datetime default NULL,
  `approve_date` datetime default NULL,
  `approve_desc` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`apply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `apply`
--

LOCK TABLES `apply` WRITE;
/*!40000 ALTER TABLE `apply` DISABLE KEYS */;
INSERT INTO `apply` VALUES (1,'采购','批准','电脑','固定资产','dell',10,3333,33330,3,2,'2019-11-11 09:38:55','2019-11-11 09:45:28','从打出大臣'),(2,'采购','批准','笔记本','固定资产','dell',10,4444,44440,3,2,'2019-11-11 09:39:34','2019-11-11 09:45:13','曹大师吃撒擦'),(3,'领用','拒绝','电脑','固定资产','dell',22,3333,73326,3,2,'2019-11-11 09:39:53','2019-11-11 09:46:31','敖德萨CAD'),(4,'领用','批准','电脑','固定资产','dell',1,3333,3333,3,2,'2019-11-11 09:40:12','2019-11-11 09:47:05','成大事才'),(5,'领用','批准','笔记本','固定资产','dell',1,4444,4444,3,2,'2019-11-11 09:40:49','2019-11-11 09:46:53','吃大餐大扫除'),(6,'报废','拒绝','电脑','固定资产','dell',5,3333,16665,3,2,'2019-11-11 09:41:27','2019-11-11 09:48:08','大大是发达'),(7,'报废','批准','电脑','固定资产','dell',1,3333,3333,3,2,'2019-11-11 09:41:49','2019-11-11 09:50:06','成都撒曹大师');
/*!40000 ALTER TABLE `apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `department` (
  `depart_id` int(11) NOT NULL auto_increment,
  `depart_name` varchar(255) collate utf8_bin default NULL,
  `depart_desc` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`depart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'江湖','江湖'),(2,'逍遥派','逍遥派'),(3,'日月神教','日月神教'),(4,'恒山派','恒山派');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grant_property`
--

DROP TABLE IF EXISTS `grant_property`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `grant_property` (
  `grant_property_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `property_name` varchar(255) collate utf8_bin default NULL,
  `property_type` varchar(255) collate utf8_bin default NULL,
  `property_model` varchar(255) collate utf8_bin default NULL,
  `property_num` int(11) default NULL,
  `unit_price` double default NULL,
  `total_price` double default NULL,
  PRIMARY KEY  (`grant_property_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `grant_property`
--

LOCK TABLES `grant_property` WRITE;
/*!40000 ALTER TABLE `grant_property` DISABLE KEYS */;
INSERT INTO `grant_property` VALUES (1,3,'笔记本','固定资产','dell',1,4444,4444);
/*!40000 ALTER TABLE `grant_property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `position` (
  `position_id` int(11) NOT NULL auto_increment,
  `position_name` varchar(255) collate utf8_bin default NULL,
  `position_description` varchar(255) collate utf8_bin default NULL,
  `depart_id` int(11) default NULL,
  PRIMARY KEY  (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'江湖传说','江湖传说',1),(2,'恒山派掌门','恒山派掌门',4),(3,'恒山派弟子','恒山派弟子',4),(4,'日月神教教主','日月神教教主',3),(5,'日月神教圣姑','日月神教圣姑',3);
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `property` (
  `property_id` int(11) NOT NULL auto_increment,
  `property_name` varchar(255) collate utf8_bin default NULL,
  `property_type` varchar(255) collate utf8_bin default NULL,
  `property_model` varchar(255) collate utf8_bin default NULL,
  `property_num` int(11) default NULL,
  `unit_price` double default NULL,
  `total_price` double default NULL,
  PRIMARY KEY  (`property_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES (1,'笔记本','固定资产','dell',9,4444,39996),(2,'电脑','固定资产','dell',9,3333,29997);
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property_flow_record`
--

DROP TABLE IF EXISTS `property_flow_record`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `property_flow_record` (
  `property_flow_record_id` int(11) NOT NULL auto_increment,
  `property_name` varchar(255) collate utf8_bin default NULL,
  `property_type` varchar(255) collate utf8_bin default NULL,
  `property_model` varchar(255) collate utf8_bin default NULL,
  `property_num` int(11) default NULL,
  `apply_id` int(11) default NULL,
  `approve_id` int(11) default NULL,
  `apply_date` date default NULL,
  `approve_date` date default NULL,
  PRIMARY KEY  (`property_flow_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `property_flow_record`
--

LOCK TABLES `property_flow_record` WRITE;
/*!40000 ALTER TABLE `property_flow_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `property_flow_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `resource` (
  `resource_id` int(11) NOT NULL auto_increment,
  `resource_name` varchar(255) collate utf8_bin default NULL,
  `resource_url` varchar(255) collate utf8_bin default NULL,
  `resource_description` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
INSERT INTO `resource` VALUES (1,'deleteUser','/account/deleteUser','删除用户');
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL auto_increment,
  `role_name` varchar(255) collate utf8_bin default NULL,
  `role_desc` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin','超级管理员'),(2,'manager','管理员'),(3,'staff','小虾米');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_resource`
--

DROP TABLE IF EXISTS `role_resource`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `role_resource` (
  `role_resource_id` int(11) NOT NULL auto_increment,
  `role_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  PRIMARY KEY  (`role_resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `role_resource`
--

LOCK TABLES `role_resource` WRITE;
/*!40000 ALTER TABLE `role_resource` DISABLE KEYS */;
INSERT INTO `role_resource` VALUES (1,1,1);
/*!40000 ALTER TABLE `role_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scrap_property`
--

DROP TABLE IF EXISTS `scrap_property`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `scrap_property` (
  `scrap_property_id` int(11) NOT NULL auto_increment,
  `property_name` varchar(255) collate utf8_bin default NULL,
  `property_type` varchar(255) collate utf8_bin default NULL,
  `property_model` varchar(255) collate utf8_bin default NULL,
  `property_num` int(11) default NULL,
  PRIMARY KEY  (`scrap_property_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `scrap_property`
--

LOCK TABLES `scrap_property` WRITE;
/*!40000 ALTER TABLE `scrap_property` DISABLE KEYS */;
INSERT INTO `scrap_property` VALUES (1,'电脑','固定资产','dell',1);
/*!40000 ALTER TABLE `scrap_property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL auto_increment,
  `account` varchar(255) collate utf8_bin default NULL,
  `password` varchar(255) collate utf8_bin default NULL,
  `user_name` varchar(255) collate utf8_bin default NULL,
  `user_sex` varchar(255) collate utf8_bin default NULL,
  `user_telephone` varchar(255) collate utf8_bin default NULL,
  `user_email` varchar(255) collate utf8_bin default NULL,
  `user_address` varchar(255) collate utf8_bin default NULL,
  `user_diploma` varchar(255) collate utf8_bin default NULL,
  `user_birthday` datetime default NULL,
  `user_entrytime` datetime default NULL,
  `position_id` int(11) default NULL,
  `depart_id` int(11) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','51c017d79ab2eea8548f22543409cd05','独孤求败','男','11111111111','duguqiubai@163.com','无处不在','博士','2019-11-01 00:00:00','2019-11-01 00:00:00',1,1),(2,'manager','51c017d79ab2eea8548f22543409cd05','令狐冲','男','11111111111','linghuchong@163.com','恒山见性峰悬空寺','博士','2019-11-01 00:00:00','2019-11-01 00:00:00',2,4),(3,'staff','51c017d79ab2eea8548f22543409cd05','仪琳','女','11111111111','yilin@163.com','恒山派见性峰','硕士','2019-11-01 00:00:00','2019-11-01 00:00:00',3,4),(4,'hymanHu','51c017d79ab2eea8548f22543409cd05','怡和','女','11111111111','yihe@163.com','恒山见性峰','本科','2019-11-01 00:00:00','2019-11-01 00:00:00',2,4),(5,'renyingying','51c017d79ab2eea8548f22543409cd05','任盈盈','女','11111111111','renyingying@163.com','黑木崖','硕士','2019-11-01 00:00:00','2019-11-01 00:00:00',5,3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `user_role` (
  `user_role_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY  (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1),(2,2,2),(4,4,3),(5,5,2),(6,3,3);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-11  7:34:52
