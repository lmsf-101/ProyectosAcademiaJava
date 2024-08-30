CREATE USER 'hotelier'@'localhost' IDENTIFIED BY 'hotelier';

GRANT ALL PRIVILEGES ON * . * TO 'hotelier'@'localhost';

ALTER USER 'hotelier'@'localhost' IDENTIFIED WITH mysql_native_password BY 'hotelier';