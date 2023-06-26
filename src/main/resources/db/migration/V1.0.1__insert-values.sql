begin;

INSERT INTO tbl_car(car_brand_id, model, license_plate, year_of_manufacture, client_id)
            VALUES(1,'F10 535d','CA9213BX', '2014-03-10',1),
            (2,'S-AMG','A1023AA', '2023-05-05',1),
            (2,'E-Class','B1023AA', '2023-05-05',2),
            (3,'A5','PK0129BP', '2010-12-12',1),
            (1,'E60 M5','TX3591CH', '2010-01-02',3);

INSERT INTO tbl_car_brand(name)
            VALUES('BMW'), ('MERCEDES'), ('AUDI');

INSERT INTO tbl_car_service(name)
            VALUES('Ivanov Service'), ('Bavaria Auto');

INSERT INTO tbl_car_service_brand(car_service_id, car_brand_id)
            VALUES(1, 1), (1, 2), (1, 3), (2, 1);

INSERT INTO tbl_car_service_servicing_type(car_service_id, service_type_id)
            VALUES(1, 1), (1, 3), (2, 1), (2, 2), (2, 3), (2, 4);

INSERT INTO tbl_car_servicing(car_service_id, car_id, service_type_id, price, repaired)
            VALUES(1, 2, 1, 299.99, 1), (1, 2, 3, 149.99, 1),
            (2, 1, 3, 549.99, 1),
            (2, 5, 3, 449.99, 1),
            (2, 1, 2, 509.99, 1),
            (2, 1, 1, 329.99, 1),
            (2, 5, 3, 919.99, 1),
            (2, 5, 3, 409.99, 1),
            (2, 1, 4, 0, 0),
            (2, 5, 2, 0, 0);

INSERT INTO tbl_client(name)
            VALUES('Nikolay'), ('Ivan'), ('Dragan');

INSERT INTO tbl_user(username, password, type, user_id)
            VALUES('niki', 'YW14bW9kWDY1MSE=', 'CLIENT', 1), ('pepi', 'YW14bW9kWDY1MSE=','EMPLOYEE',1),
            ('alex', 'YW14bW9kWDY1MSE=','EMPLOYEE',2), ('teo', 'YW14bW9kWDY1MSE=','EMPLOYEE',3);

INSERT INTO tbl_employee(name)
            VALUES('Petar'), ('Alexander'), ('Teodor');

INSERT INTO tbl_service_employee(car_service_id, employee_id)
            VALUES(1, 1), (1, 2), (2, 2), (2, 3);

INSERT INTO tbl_service_type(name)
            VALUES ('UNDERCARRIAGE'), ('ENGINE'), ('BRAKE_SYSTEM'), ('CONSUMABLES_REPLACEMENT');

commit;