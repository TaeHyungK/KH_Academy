create table smember(
 id varchar2(12) not null,
 name varchar2(30) not null,
 passwd varchar2(12) not null,
 email varchar2(50) not null,
 phone varchar2(15),
 reg_date date not null,
 constraint smember_pk primary key (id)
);