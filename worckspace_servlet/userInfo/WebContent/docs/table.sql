create table member(
    id varchar2(12) not null,
    name varchar2(30) not null,
    passwd varchar2(12) not null,
    phone varchar2(15) not null,
    email varchar2(50) not null,
    zipcode varchar2(5) not null,
    addrss1 varchar2(60) not null,
    address2 varchar2(60),
    reg_date date not null,
    constraint member_pk primary key(id)
);