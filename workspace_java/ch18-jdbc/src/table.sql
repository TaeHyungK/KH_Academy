CREATE TABLE test2(
	num number NOT NULL PRIMARY KEY,
	title varchar2(30) NOT NULL,
	name varchar2(30) NOT NULL,
	memo varchar2(1500) NOT NULL,
	email varchar2(30),
	register date NOT NULL
);

CREATE sequence num_seq;