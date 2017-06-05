SET FOREIGN_KEY_CHECKS = 0;

/* Drop table if there are */
/* Drop table if there are */
DROP TABLE IF EXISTS HMS_Patient;
DROP TABLE IF EXISTS HMS_Employee;
DROP TABLE IF EXISTS HMS_Doctor;
DROP TABLE IF EXISTS HMS_Ward;
DROP TABLE IF EXISTS HMS_Consult;
DROP TABLE IF EXISTS HMS_Treatment;
DROP TABLE IF EXISTS HMS_Confirm;
DROP TABLE IF EXISTS HMS_Test;
DROP TABLE IF EXISTS HMS_Payment;
DROP TABLE IF EXISTS HMS_Externalp;
DROP TABLE IF EXISTS HMS_Testresult;
DROP TABLE IF EXISTS HMS_Salary;
DROP TABLE IF EXISTS HMS_Nurse;
DROP TABLE IF EXISTS HMS_UserLogin;
DROP TABLE IF EXISTS HMS_Bill;
DROP TABLE IF EXISTS HMS_Attendance;

CREATE TABLE hms_attendance
(
  employeeId INT(8)             NOT NULL,
  type       INT(1)             NOT NULL,
  date       VARCHAR(15)        NOT NULL,
  time       VARCHAR(10)        NOT NULL,
  primaryKey INT(8) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  latest     SMALLINT(6)
);
CREATE TABLE hms_bill
(
  billId           INT(8) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  date             VARCHAR(50)        NOT NULL,
  patientId        INT(8)             NOT NULL,
  payment          FLOAT              NOT NULL,
  payer            VARCHAR(50)        NOT NULL,
  receiverStaff    INT(8)             NOT NULL,
  lastModifiedDate DATETIME,
  latest           INT(1)             NOT NULL
);
CREATE TABLE hms_confirm
(
  patientId        INT(8) NOT NULL,
  doctorId         INT(8) NOT NULL,
  lastModifiedDate DATETIME,
  latest           INT(1) NOT NULL
);
CREATE TABLE hms_consult
(
  patienId         INT(8) NOT NULL,
  doctorId         INT(8) NOT NULL,
  lastModifiedDate DATETIME,
  latest           INT(1) NOT NULL
);
CREATE TABLE hms_doctor
(
  primaryKey       INT(8) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  doctorId         INT(8)             NOT NULL,
  designation      VARCHAR(50)        NOT NULL,
  lastModifiedDate DATETIME,
  latest           INT(1)             NOT NULL,
  employeeId       VARCHAR(20)        NOT NULL
);
CREATE TABLE hms_employee
(
  primaryKey       INT(8) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  employeeId       VARCHAR(20)        NOT NULL,
  firstName        VARCHAR(50)        NOT NULL,
  middleName       VARCHAR(50),
  lastName         VARCHAR(50)        NOT NULL,
  birthDate        DATE,
  address1         VARCHAR(50)        NOT NULL,
  address2         VARCHAR(50),
  address3         VARCHAR(50),
  mobileNumber     VARCHAR(20),
  homePhone        VARCHAR(12),
  email            VARCHAR(50),
  gender           CHAR(1)            NOT NULL,
  lastModifiedDate DATETIME,
  latest           INT(1)             NOT NULL,
  title            VARCHAR(8)         NOT NULL,
  nationality      VARCHAR(10)        NOT NULL
);
CREATE TABLE hms_externalp
(
  primaryKey       INT(8) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  epId             INT(8)             NOT NULL,
  firstName        VARCHAR(50)        NOT NULL,
  middleName       VARCHAR(50),
  lastName         VARCHAR(50)        NOT NULL,
  description      VARCHAR(250)       NOT NULL,
  lastModifiedDate DATETIME,
  latest           INT(1)             NOT NULL
);
CREATE TABLE hms_patient
(
  primaryKey       INT(8) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  patientId        INT(8)             NOT NULL,
  firstName        VARCHAR(50)        NOT NULL,
  middleName       VARCHAR(50),
  lastName         VARCHAR(50)        NOT NULL,
  title            VARCHAR(50)        NOT NULL,
  birthDate        DATE,
  bloodgroup       VARCHAR(50),
  address          VARCHAR(100)       NOT NULL,
  contactNumber    VARCHAR(20)        NOT NULL,
  gender           CHAR(1)            NOT NULL,
  lastModifiedDate DATETIME,
  latest           INT(1)             NOT NULL
);
CREATE TABLE hms_payment
(
  primaryKey       INT(8) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  paymentId        INT(8)             NOT NULL,
  date             DATETIME           NOT NULL,
  doctorcharge     FLOAT              NOT NULL,
  roomcharge       FLOAT              NOT NULL,
  total            FLOAT              NOT NULL,
  lastModifiedDate DATETIME,
  latest           INT(1)             NOT NULL
);
CREATE TABLE hms_salary
(
  primaryKey       INT(8) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  employeeId       INT(8)             NOT NULL,
  amount           FLOAT              NOT NULL,
  lastModifiedDate DATETIME,
  latest           INT(1)             NOT NULL
);
CREATE TABLE hms_test
(
  primaryKey       INT(8) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  testId           INT(8)             NOT NULL,
  type             VARCHAR(50)        NOT NULL,
  description      VARCHAR(200)       NOT NULL,
  unitPrice        FLOAT              NOT NULL,
  lastModifiedDate DATETIME,
  latest           INT(1)             NOT NULL
);
CREATE TABLE hms_testresult
(
  No               INT(8)       NOT NULL,
  date             DATE         NOT NULL,
  result           VARCHAR(250) NOT NULL,
  lastModifiedDate DATETIME,
  latest           INT(1)       NOT NULL
);
CREATE TABLE hms_treatment
(
  patientId        INT(8) NOT NULL,
  doctorId         INT(8) NOT NULL,
  lastModifiedDate DATETIME,
  latest           INT(1) NOT NULL
);
CREATE TABLE hms_userlogin
(
  primaryKey       INT(8) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  userId           VARCHAR(20)        NOT NULL,
  employeeId       INT(8)             NOT NULL,
  password         VARCHAR(50)        NOT NULL,
  lastLoginTime    DATETIME,
  lastLogoutTime   DATETIME,
  lastModifiedDate DATETIME,
  latest           INT(1)             NOT NULL
);
CREATE TABLE hms_ward
(
  primaryKey       INT(8) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  wardId           INT(8)             NOT NULL,
  type             VARCHAR(50)        NOT NULL,
  number_of_beds   INT(8)             NOT NULL,
  status           INT(8)             NOT NULL,
  lastModifiedDate DATETIME,
  latest           INT(1)             NOT NULL
);