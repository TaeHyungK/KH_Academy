CREATE TABLE board(
	num number NOT NULL,
	title varchar2(150) NOT NULL,
	content clob NOT NULL,
	hit number(5) default 0 NOT NULL,
	regdate date NOT NULL,
	filename varchar2(150),
	ip varchar2(40) NOT NULL,
	id varchar2(12) NOT NULL,
	constraint board_pk primary key (num),
	constraint board_fk1 foreign key (id) REFERENCES member(id)
);

CREATE SEQUENCE board_seq;

create table member(
  id varchar2(12) not null,
  name varchar2(30) not null,
  passwd varchar2(12) not null,
  phone varchar2(15) not null,
  email varchar2(50) not null,
  zipcode varchar2(5) not null,
  address1 varchar2(60) not null,
  address2 varchar2(60),
  reg_date date not null,
  constraint member_pk primary key (id)
);









