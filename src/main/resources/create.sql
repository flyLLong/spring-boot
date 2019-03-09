create table t_user (
	user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	user_name VARCHAR(25) NOT NULL UNIQUE,
	password VARCHAR(25) NOT NULL,
	phone VARCHAR(25) NOT NULL UNIQUE,
	create_time datetime DEFAULT NULL
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

INSERT INTO t_user (user_name, password, phone) VALUES ('zhaoyun', '123456', '13688886666');
