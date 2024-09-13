CREATE TABLE IF NOT EXISTS `users` (
	`username` varchar(50) NOT NULL,
	`password` varchar(50) NOT NULL,
	`enabled` tinyint NOT NULL,
	
	PRIMARY KEY (`username`)
);

CREATE TABLE IF NOT EXISTS `authorities` (
	`username` varchar(50) NOT NULL,
	`authority` varchar(50) NOT NULL,
	
	UNIQUE (`username`, `authority`),
	
	CONSTRAINT `authorities_ibfk_1`
	FOREIGN KEY (`username`)
	REFERENCES users (`username`)
);