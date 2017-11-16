CREATE TABLE guestbook(
	num number not null primary key,
	name varchar2(30) not null,
	passwd varchar2(10) not null,
	email varchar2(50) not null,
	content varchar2(4000) not null,
	register date not null
);

CREATE SEQUENCE guestbook_seq;