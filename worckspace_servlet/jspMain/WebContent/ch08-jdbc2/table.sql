CREATE TABLE product(
	id varchar2(10) PRIMARY KEY,
	name varchar2(60) NOT NULL,
	price number(9) NOT NULL,
	stock number(6) NOT NULL,
	place varchar2(30) NOT NULL,
	reg_date date NOT NULL
);
