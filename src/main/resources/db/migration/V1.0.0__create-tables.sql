begin;

CREATE TABLE tbl_client(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	`name` TEXT
);

CREATE TABLE tbl_car_service(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	`name` TEXT
);

CREATE TABLE tbl_car_service_servicing_type(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	car_service_id BIGINT,
	service_type_id BIGINT
);

CREATE TABLE tbl_car_service_brand(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	car_service_id BIGINT,
	car_brand_id BIGINT
);

CREATE TABLE tbl_car(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	car_brand_id BIGINT,
	model TEXT,
	license_plate TEXT,
	year_of_manufacture DATE,
	client_id BIGINT
);

CREATE TABLE tbl_car_brand(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	`name` TEXT
);

CREATE TABLE tbl_car_servicing(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	car_service_id BIGINT,
    car_id BIGINT,
	service_type_id BIGINT,
	price DOUBLE,
    repaired BOOLEAN
);

CREATE TABLE tbl_service_type(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	`name` TEXT
);

CREATE TABLE tbl_employee(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	 `name` TEXT
);

CREATE TABLE tbl_service_employee(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
 	car_service_id BIGINT,
 	employee_id BIGINT
);

CREATE TABLE tbl_user(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
 	username VARCHAR(20),
 	password VARCHAR(20),
 	type ENUM('CLIENT','EMPLOYEE'),
 	user_id BIGINT
);

commit;
