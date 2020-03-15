CREATE DATABASE `flowerdecoration`;


DROP TABLE IF EXISTS `employeedetails`;
CREATE TABLE `employeedetails` (
  `EMPLOYEE_ID` INT(10) AUTO_INCREMENT,
  `EMPLOYEE_NAME` VARCHAR(90) NOT NULL DEFAULT '',
  `EMP_JOINDATE` DATE NULL,
  `QUALIFICATION` VARCHAR(45) NOT NULL DEFAULT '',
  `EMAIL_ID` VARCHAR(50) NOT NULL DEFAULT '',
  `CONTACTNO` VARCHAR(45) NOT NULL DEFAULT '',
  `FATHERNAME` VARCHAR(100) NOT NULL DEFAULT '',
  `MOTHERNAME` VARCHAR(100) NOT NULL DEFAULT '',
  `ADDRESS` VARCHAR(200) NOT NULL DEFAULT '',
  `DOB` VARCHAR(45) NOT NULL DEFAULT '',
  `USERNAME` VARCHAR(45) NOT NULL DEFAULT '',
  `PASSWORD` VARCHAR(45) NOT NULL DEFAULT '',
  `DESIGNATION` VARCHAR(45) NOT NULL DEFAULT '',
  `RELIVINGDATE` DATE NULL ,
  `LEVEL` INT(10) UNSIGNED NOT NULL DEFAULT 0,
  `ACTIVE` VARCHAR(45) NOT NULL DEFAULT '',
  `ASSIGNED` CHAR(0) NOT NULL DEFAULT '',
  UNIQUE(USERNAME,EMAIL_ID),
  PRIMARY KEY (`EMPLOYEE_ID`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `registration`;
CREATE TABLE `registration` (
  `NAME` VARCHAR(90) NOT NULL DEFAULT '',
  `EMAIL_ID` VARCHAR(50) NOT NULL DEFAULT '',
  `CONTACT_NO` VARCHAR(45) NOT NULL DEFAULT '',
  `ADDRESS` VARCHAR(200) NOT NULL DEFAULT '',
  `USERNAME` VARCHAR(45) NOT NULL DEFAULT '',
  `PASSWORD` VARCHAR(45) NOT NULL DEFAULT '',
  `EMPLOYEE_ID` INT(10) UNSIGNED NOT NULL DEFAULT 0,
  `DESCRIPTION` VARCHAR(45) NOT NULL DEFAULT '',
  `LEVEL` INT(10) UNSIGNED NOT NULL DEFAULT 0,
  `ACTIVE` VARCHAR(45) NOT NULL DEFAULT '',
  UNIQUE(USERNAME,EMAIL_ID)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

INSERT INTO registration( NAME, ADDRESS, CONTACT_NO, EMAIL_ID, USERNAME, PASSWORD, EMPLOYEE_ID, LEVEL, ACTIVE, DESCRIPTION)
VALUES ('admin', '', '','admin@admin.com', 'admin', 'admin', 0, 1, 'YES', '');

INSERT INTO employeedetails (EMPLOYEE_NAME, EMAIL_ID, USERNAME, PASSWORD, LEVEL, ACTIVE)
VALUES ('admin', 'admin@admin.com', 'admin', 'admin', '1', 'YES');


DROP TABLE IF EXISTS `shopdetails`;
CREATE TABLE `shopdetails` (
  `SHOP_ID` INT(10) AUTO_INCREMENT,
  `SHOP_NAME` VARCHAR(100) NOT NULL DEFAULT '',
  `ADDRESS` VARCHAR(80) NOT NULL DEFAULT '',
  `CITY` VARCHAR(45) NOT NULL DEFAULT '',
  `STATE` VARCHAR(45) NOT NULL DEFAULT '',
  `COUNTRY` VARCHAR(45) NOT NULL DEFAULT '',
  `PINCODE` VARCHAR(45) NOT NULL DEFAULT '',
  `STARTDATE` VARCHAR(45) NOT NULL DEFAULT '',
  UNIQUE(`SHOP_NAME`),
  PRIMARY KEY (`SHOP_ID`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `flowers`;
CREATE TABLE `flowers` (
  `flowerid` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `flowername` VARCHAR(45) NOT NULL,
  `flowercost` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `comment` VARCHAR(45) NOT NULL DEFAULT '',
  UNIQUE(flowername),
  PRIMARY KEY  (`flowerid`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `decorations`;
CREATE TABLE `decorations` (
  `decorationid` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `decorationname` VARCHAR(45) NOT NULL,
  `decorationcost` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `comment` VARCHAR(45) NOT NULL DEFAULT '',
  UNIQUE(decorationname),
  PRIMARY KEY  (`decorationid`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `flowerorders`;
CREATE TABLE `flowerorders` (
  `order_id` INT(10) AUTO_INCREMENT,
  `flowername` VARCHAR(45) NOT NULL DEFAULT '',
  `flowercost` VARCHAR(45) NOT NULL,
  `request_date` VARCHAR(45) NOT NULL DEFAULT '',
  `orderby` VARCHAR(45) NOT NULL DEFAULT '',
  `assignedto` VARCHAR(45) NOT NULL DEFAULT '',
  `delivered_date` VARCHAR(45) NOT NULL DEFAULT '',
  `status` VARCHAR(45) NOT NULL DEFAULT '',
  `bargaining` VARCHAR(45) NOT NULL DEFAULT '',
  `final_rate` VARCHAR(45) NOT NULL DEFAULT '',
  `comment` VARCHAR(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`order_id`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `decorationorders`;
CREATE TABLE `decorationorders` (
  `order_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `decorationname` VARCHAR(45) NOT NULL,
  `decorationcost` VARCHAR(45) NOT NULL,
  `request_date` VARCHAR(45) NOT NULL DEFAULT '',
  `orderby` VARCHAR(45) NOT NULL DEFAULT '',
  `assignedto` VARCHAR(45) NOT NULL DEFAULT '',
  `delivered_date` VARCHAR(45) NOT NULL DEFAULT '',
  `status` VARCHAR(45) NOT NULL DEFAULT '',
  `bargaining` VARCHAR(45) NOT NULL DEFAULT '',
  `final_rate` VARCHAR(45) NOT NULL DEFAULT '',
  `comment` VARCHAR(45) NOT NULL DEFAULT '',
  PRIMARY KEY  (`order_id`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;