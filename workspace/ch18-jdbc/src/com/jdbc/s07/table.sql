CREATE TABLE score(
	num number NOT NULL PRIMARY KEY,
	name varchar2(30) NOT NULL,
	kor number(3) NOT NULL,
	eng number(3) NOT NULL,
	math number(3) NOT NULL,
	sum number(3) NOT NULL,
	avg number(3) NOT NULL,
	grade varchar2(2) NOT NULL,
	reg_date date NOT NULL
);

CREATE sequence score_seq;