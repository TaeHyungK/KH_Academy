create table register_1(
    id varchar2(20) not null,
    passwd varchar2(30) not null,
    name varchar2(20) not null,
    phone varchar2(20) not null,
    sex varchar2(10) not null,
    card_num varchar2(20) not null,
    constraint pk_id primary key(id)
);

create table airplane(
    ap_num varchar2(20) not null,
    seats number(10) not null,
    constraint pk_ap_num primary key(ap_num)
);

create table reservation(
    rsv_num varchar2(20) not null,
    start_lo varchar2(10) not null,
    end_lo varchar2(10) not null,
    go_date date not null,
    return_date date not null,
    go_time varchar2(15) not null,
    return_time varchar2(15) not null,
    take_time varchar2(15) not null,
    ap_num varchar2(20) not null,
    id varchar2(20) not null,
    a_ticket number default 0,
    as_ticket number default 0,
    c_ticket number default 0,
    constraint fk_ap_num_num foreign key(ap_num) references airplane(ap_num),
    constraint fk_fkid_id foreign key(id) references register_1(id)
);

create table csc(
    c_num number(10) not null,
    c_title varchar2(20) not null,
    c_content clob not null,
    c_id varchar2(20) not null,
    regdate date not null,
    c_type number(1) not null,
    constraint pk_c_num primary key(c_num)
);

create table QnA(
    q_num number(10) not null,
    q_title varchar2(20) not null,
    q_content clob not null,
    q_id varchar2(20) not null,
    regdate date not null,
    q_solve number(1) not null,
    constraint pk_q_num primary key(q_num)
);

create table schedule(
    snum number(1) not null,
    start_lo varchar2(20) not null,
    end_lo varchar2(20) not null,
    go_date date not null,
    return_date date not null,
    go_time varchar2(15) not null,
    return_time varchar2(15) not null,
    take_time varchar2(15) not null,
    ap_num varchar2(20) not null,
    seats number(1) default 0,
    constraint fk_ap_num foreign key(ap_num) references airplane(ap_num)
);

create sequence r_num_seq;
create sequence sc_num_seq;
create sequence a_num_seq;
create sequence c_num_seq;
create sequence q_num_seq;