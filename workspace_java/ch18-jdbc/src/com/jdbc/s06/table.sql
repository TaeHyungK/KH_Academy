CREATE TABLE muser(
	mid varchar2(10) NOT NULL PRIMARY KEY,
	name varchar2(30) NOT NULL,
	mpasswd varchar2(10) NOT NULL,
	mphone varchar2(15) NOT NULL,
	register date NOT NULL
);