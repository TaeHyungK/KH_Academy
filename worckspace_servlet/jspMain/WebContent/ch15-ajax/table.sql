CREATE TABLE item(
	code number PRIMARY KEY,
	name varchar2(30) NOT NULL,
	quantity number(5) NOT NULL,
	price number(10) NOT NULL
);