CREATE TABLE rboard_replay(
	re_num number NOT NULL,
	re_content varchar2(900) NOT NULL,
	re_date date NOT NULL,
	re_ip varchar2(4) NOT NULL,
	num number NOT NULL,
	id varchar2(12) NOT NULL,
	constraint reply_pk PRIMARY KEY (re_num),
	constraint reply_fk1 FOREIGN KEY (num) REFERENCES rboard (num),
	constraint reply_fk2 FOREIGN KEY (id) REFERENCES member (id)
);

CREATE SEQUENCE reply_seq;

CREATE TABLE rboard(
	num number NOT NULL,
	title varchar2(150) NOT NULL,
	content clob NOT NULL,
	hit number(5) default 0 NOT NULL,
	regdate date NOT NULL,
	ip varchar2(40) NOT NULL,
	id varchar2(12) NOT NULL,
	constraint rboard_pk PRIMARY KEY (num),
	constraint rboard_fk1 FOREIGN KEY (id) REFERENCES member (id)
);

CREATE SEQUENCE rboard_seq;

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









