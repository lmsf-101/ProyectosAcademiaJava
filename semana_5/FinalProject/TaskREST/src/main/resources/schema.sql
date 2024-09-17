DROP TABLE IF EXISTS `tasks`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
	`id` BIGINT AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL UNIQUE,
	`password` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tasks` (
	`task_id` INT NOT NULL,
	`user_id` BIGINT NOT NULL,
	`title` VARCHAR(255),
	`status` TINYINT CHECK (`status` BETWEEN 0 AND 1),
	PRIMARY KEY (`task_id`, `user_id`),
	
	CONSTRAINT `tasks_fk_1`
	FOREIGN KEY (`user_id`)
	REFERENCES `users` (`id`)
);



