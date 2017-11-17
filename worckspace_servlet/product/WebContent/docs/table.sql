CREATE TABLE xmember(
	id varchar2(12) NOT NULL,
	name varchar2(30) NOT NULL,
	passwd varchar2(12) NOT NULL,
	email varchar2(50) NOT NULL,
	phone varchar2(15) NOT NULL,
	zipcode varchar2(5) NOT NULL,
	address varchar2(300) NOT NULL,
	reg_date date NOT NULL,
	CONSTRAINT xmember_pk primary key(id)
);

CREATE TABLE xproduct(
	num number NOT NULL,
	name varchar2(30) NOT NULL,
	price number(10) NOT NULL,
	stock number(6) NOT NULL,
	content varchar2(4000) NOT NULL,
	reg_date date NOT NULL,
	CONSTRAINT xproduct_pk primary key(num)
);

CREATE SEQUENCE product_seq;