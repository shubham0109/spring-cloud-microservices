DROP TABLE IF EXISTS "student";

CREATE TABLE "student"(
    id int NOT NULL AUTO_INCREMENT,
    'first_name' varchar(50) NOT NULL,
    'last_name' varchar(50) DEFAULT NULL,
    'email' varchar(30) DEFAULT NULL,
    'address_id' int DEFAULT NULL,
    PRIMARY KEY ('id')

);

CREATE TABLE student (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) DEFAULT NULL,
  email VARCHAR(30) DEFAULT NULL,
  address_id INTEGER DEFAULT NULL,
  CONSTRAINT fk_address_id FOREIGN KEY (address_id) REFERENCES address(id)
);


INSERT into student VALUES(1, 'Raj', 'Dave', 'raj_dv@gmail.com', 1),(2, 'John', 'Smith', 'js@gmail.com', 2);






DROP TABLE IF EXISTS "address";


CREATE TABLE "address"(
    id int NOT NULL AUTO_INCREMENT,
    'street' varchar(50) NOT NULL,
    'city' varchar(50) NOT NULL,
    PRIMARY KEY ('id')

);

CREATE TABLE address (
  id SERIAL PRIMARY KEY,
  street VARCHAR(50) NOT NULL,
  city VARCHAR(50) NOT NULL
);

INSERT into address VALUES(1, 'Happy Street', 'Delhi'),(2, 'Town Street', 'NY');

