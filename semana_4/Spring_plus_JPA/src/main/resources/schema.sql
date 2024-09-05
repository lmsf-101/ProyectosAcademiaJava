/*CREATE DATABASE  IF NOT EXISTS `school_example`;
USE `school_example`;*/

DROP TABLE IF EXISTS `students`;

CREATE TABLE students (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  date_of_birth VARCHAR(50) NOT NULL,
  email VARCHAR(255) UNIQUE,
  gender VARCHAR(20),
  phone_number VARCHAR(20)
);