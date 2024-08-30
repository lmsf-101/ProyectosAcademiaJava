create database if not exists hotelDB;

use hotelDB;

drop table if exists guests;

CREATE TABLE `guests` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `room_number` int DEFAULT NULL UNIQUE,
  `arrival` varchar(30) DEFAULT NULL,
  `departure` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO guests (name, email, room_number, arrival, departure) VALUES
  ('John Doe', 'john.doe@example.com', 1, '2024-10-26', '2024-10-29'),
  ('Jane Smith', 'jane.smith@example.com', 2, '2024-10-27', '2024-10-30'),
  ('Peter Jones', 'peter.jones@hotmail.com', 17, '2024-11-28', '2024-11-31'),
  ('Alice Johnson', 'alicee42@gmail.com', 54, '2024-10-05', '2024-10-10'),
  ('Bob Williams', 'bobbywill_2@outlook.com', 90, '2024-09-24', '2024-09-26'),
  ('Carol Brown', 'cbrownprof@hotmail.com', 45, '2024-12-21', '2024-12-26');