

CREATE USER IF NOT EXISTS 'fp'@'%' IDENTIFIED BY 'finalproject';

GRANT ALL PRIVILEGES ON * . * TO 'fp'@'%';

-- Database for MVC example
CREATE DATABASE IF NOT EXISTS `mvc_db`;

-- Database for REST example
CREATE DATABASE IF NOT EXISTS `rest_db`;