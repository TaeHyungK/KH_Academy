create table rboard(
  num number not null,
  title varchar2(150) not null,
  content clob not null,
  hit number(5) default 0 not null,
  regdate date not null,
  ip varchar2(40) not null,
  id varchar2(12) not null,
  constraint rboard_pk primary key (num),
  constraint rboard_fk1 foreign key (id) references ymember (id)
);

create sequence rboard_seq;

create table rboard_reply(
  re_num number not null,
  re_content varchar2(900) not null,
  re_date date not null,
  re_ip varchar2(40) not null,
  num number not null,
  id varchar2(12) not null,
  constraint reply_pk primary key (re_num),
  constraint reply_fk1 foreign key (num) 
                   references rboard (num),
  constraint reply_fk2 foreign key (id)
                   references ymember (id)
);

create sequence reply_seq;

create table ymember(
  id varchar2(12) not null,
  passwd varchar2(12) not null,
  user_level number(1) not null,
  constraint ymember_pk primary key (id) /*0:Ż��ȸ��, 1:����ȸ��, 2:������*/
);

create table ymember_detail(
	id varchar2(12) not null,
  	name varchar2(30) not null,
  	passwd varchar2(12) not null,
 	phone varchar2(15) not null,
 	email varchar2(50) not null,
 	zipcode varchar2(5) not null,
  	address1 varchar2(60) not null,
 	address2 varchar2(60),
	reg_date date not null,
	constraint detail_fk1 foreign key(id) references ymember (id)
);









