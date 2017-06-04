SET FOREIGN_KEY_CHECKS = 0;

/* Drop table if there are */
DROP TABLE IF EXISTS `HMS_Patient`;
DROP TABLE IF EXISTS `HMS_Employee`;
DROP TABLE IF EXISTS `HMS_Doctor`;
DROP TABLE IF EXISTS `HMS_Ward`;
DROP TABLE IF EXISTS `HMS_Consult`;
DROP TABLE IF EXISTS `HMS_Treatment`;
DROP TABLE IF EXISTS `HMS_Confirm`;
DROP TABLE IF EXISTS `HMS_Test`;
DROP TABLE IF EXISTS `HMS_Payment`;
DROP TABLE IF EXISTS `HMS_Externalp`;
DROP TABLE IF EXISTS `HMS_Testresult`;
DROP TABLE IF EXISTS `HMS_Salary`;
DROP TABLE IF EXISTS `HMS_Nurse`;
DROP TABLE IF EXISTS `HMS_UserLogin`;
DROP TABLE IF EXISTS `HMS_Bill`;
DROP TABLE IF EXISTS `HMS_Attendance`;

SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `HMS_UserLogin` (
  `primaryKey`       INTEGER(8)  NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `userId`           VARCHAR(20) NOT NULL,
  `employeeId`       INTEGER(8)  NOT NULL,
  `password`         VARCHAR(50) NOT NULL,
  `lastLoginTime`    DATETIME    NULL,
  `lastLogoutTime`   DATETIME    NULL,
  `lastModifiedDate` DATETIME    NULL,
  `latest`           INTEGER(1)  NOT NULL
);
CREATE TABLE `HMS_Patient` (
  `primaryKey`       INTEGER(8) PRIMARY KEY AUTO_INCREMENT,
  `patientId`        INTEGER(8)   NOT NULL,
  `firstName`        VARCHAR(50)  NOT NULL,
  `middleName`       VARCHAR(50),
  `lastName`         VARCHAR(50)  NOT NULL,
  `title`            VARCHAR(50)  NOT NULL,
  `birthDate`        DATE         NULL,
  `bloodgroup`       VARCHAR(50),
  `address`          VARCHAR(100) NOT NULL,
  `contactNumber`    VARCHAR(20)  NOT NULL,
  `gender`           CHAR(1)      NOT NULL,
  `lastModifiedDate` DATETIME     NULL,
  `latest`           INTEGER(1)   NOT NULL
);

CREATE TABLE `HMS_Employee` (
  `primaryKey`       INTEGER(8) PRIMARY KEY AUTO_INCREMENT,
  `employeeId`       INTEGER(8)  NOT NULL,
  `firstName`        VARCHAR(50) NOT NULL,
  `middleName`       VARCHAR(50),
  `lastName`         VARCHAR(50) NOT NULL,
  `birthDate`        DATE        NULL,
  `address1`         VARCHAR(50) NOT NULL,
  `address2`         VARCHAR(50),
  `address3`         VARCHAR(50),
  `mobileNumber`     VARCHAR(20),
  `homePhone`        VARCHAR(12),
  `email`            VARCHAR(50),
  `gender`           SMALLINT(1) NOT NULL,
  `NIC`              VARCHAR(10) NOT NULL,
  `lastModifiedDate` DATETIME    NULL,
  `latest`           INTEGER(1)  NOT NULL
);

CREATE TABLE `HMS_Doctor` (
  `primaryKey`       INTEGER(8) PRIMARY KEY AUTO_INCREMENT,
  `doctorId`         INTEGER(8)  NOT NULL,
  `designation`      VARCHAR(50) NOT NULL,
  `lastModifiedDate` DATETIME    NULL,
  `latest`           INTEGER(1)  NOT NULL
);

CREATE TABLE `HMS_Ward` (
  `primaryKey`       INTEGER(8) PRIMARY KEY AUTO_INCREMENT,
  `wardId`           INTEGER(8)  NOT NULL,
  `type`             VARCHAR(50) NOT NULL,
  `number_of_beds`   INTEGER(8)  NOT NULL,
  `status`           INTEGER(8)  NOT NULL,
  `lastModifiedDate` DATETIME    NULL,
  `latest`           INTEGER(1)  NOT NULL
);

CREATE TABLE `HMS_Test` (
  `primaryKey`       INTEGER(8) PRIMARY KEY AUTO_INCREMENT,
  `testId`           INTEGER(8)   NOT NULL,
  `type`             VARCHAR(50)  NOT NULL,
  `description`      VARCHAR(200) NOT NULL,
  `unitPrice`        FLOAT(4)     NOT NULL,
  `lastModifiedDate` DATETIME     NULL,
  `latest`           INTEGER(1)   NOT NULL
);

CREATE TABLE `HMS_Bill` (
  `billId`           INTEGER(8) PRIMARY KEY AUTO_INCREMENT,
  `date`             VARCHAR(50) NOT NULL,
  `patientId`        INTEGER(8)  NOT NULL,
  `payment`          FLOAT(4)    NOT NULL,
  `payer`            VARCHAR(50) NOT NULL,
  `receiverStaff`    INTEGER(8)  NOT NULL,
  `lastModifiedDate` DATETIME    NULL,
  `latest`           INTEGER(1)  NOT NULL
);

CREATE TABLE `HMS_Payment` (
  `primaryKey`       INTEGER(8) PRIMARY KEY AUTO_INCREMENT,
  `paymentId`        INTEGER(8) NOT NULL,
  `date`             DATETIME   NOT NULL,
  `doctorcharge`     FLOAT(4)   NOT NULL,
  `roomcharge`       FLOAT(4)   NOT NULL,
  `total`            FLOAT(4)   NOT NULL,
  `lastModifiedDate` DATETIME   NULL,
  `latest`           INTEGER(1) NOT NULL
);

CREATE TABLE `HMS_Externalp` (
  `primaryKey`       INTEGER(8) PRIMARY KEY AUTO_INCREMENT,
  `epId`             INTEGER(8)   NOT NULL,
  `firstName`        VARCHAR(50)  NOT NULL,
  `middleName`       VARCHAR(50),
  `lastName`         VARCHAR(50)  NOT NULL,
  `description`      VARCHAR(250) NOT NULL,
  `lastModifiedDate` DATETIME     NULL,
  `latest`           INTEGER(1)   NOT NULL
);

CREATE TABLE `HMS_Testresult` (
  `No`               INTEGER(8)   NOT NULL,
  `date`             DATE         NOT NULL,
  `result`           VARCHAR(250) NOT NULL,
  `lastModifiedDate` DATETIME     NULL,
  `latest`           INTEGER(1)   NOT NULL
);

CREATE TABLE `HMS_Salary` (
  `primaryKey`       INTEGER(8) PRIMARY KEY AUTO_INCREMENT,
  `employeeId`       INTEGER(8) NOT NULL,
  `amount`           FLOAT(4)   NOT NULL,
  `lastModifiedDate` DATETIME   NULL,
  `latest`           INTEGER(1) NOT NULL
);

CREATE TABLE `HMS_Consult` (
  `patienId`         INTEGER(8) NOT NULL,
  `doctorId`         INTEGER(8) NOT NULL,
  `lastModifiedDate` DATETIME   NULL,
  `latest`           INTEGER(1) NOT NULL
);

CREATE TABLE `HMS_confirm` (
  `patientId`        INTEGER(8) NOT NULL,
  `doctorId`         INTEGER(8) NOT NULL,
  `lastModifiedDate` DATETIME   NULL,
  `latest`           INTEGER(1) NOT NULL
);

CREATE TABLE `HMS_Treatment` (
  `patientId`        INTEGER(8) NOT NULL,
  `doctorId`         INTEGER(8) NOT NULL,
  `lastModifiedDate` DATETIME   NULL,
  `latest`           INTEGER(1) NOT NULL
);

CREATE TABLE `HMS_Attendance` (
  `attendanceId` INTEGER(8) PRIMARY KEY AUTO_INCREMENT,
  `employeeId`   INTEGER(8) NOT NULL,
  `type`         INTEGER(1) NOT NULL,
  `date`         DATE       NOT NULL,
  `time`         TIME       NOT NULL
);