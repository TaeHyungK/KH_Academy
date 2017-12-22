CREATE TABLE reservation(
	rsv_num varchar2(20) not null,
	start_lo varchar2(10) not null,
	end_lo varchar2(10) not null,
	go_date varchar2(10) not null,
	return_date varchar2(10) not null,
	go_time varchar2(15) not null,
	return_time varchar2(15) not null,
	take_time varchar2(15) not null,
	ap_num varchar2(20) not null,
	id varchar2(20) not null,
	a_ticket number default 0,
	as_ticket number default 0,
	c_ticket number default 0,
	regdate date default SYSDATE,
	snum number,
	CONSTRAINT fk_ap_num_num FOREIGN KEY (ap_num) REFERENCES airplane (ap_num),
    CONSTRAINT fk_fkid_id FOREIGN KEY (id) REFERENCES register_1 (id)
);

CREATE TABLE schedule(
    snum number not null,
    start_lo varchar2(20) not null,
    end_lo varchar2(20) not null,
    go_date varchar2(20) not null,
    return_date varchar2(20) not null,
    go_time varchar2(15) not null,
    return_time varchar2(15) not null,
    take_time varchar2(15) not null,
    ap_num varchar2(20) not null,
    seats number,
    CONSTRAINT fk_ap_num FOREIGN KEY (ap_num) REFERENCES airplane (ap_num)
);

CREATE TABLE airplane(
    ap_num varchar2(20) not null PRIMARY KEY,
    seats number not null
);

CREATE TABLE register_1(
    id varchar2(20) not null PRIMARY KEY,
    passwd varchar2(30) not null,
    name varchar2(20) not null,
    phone number(12,0) not null,
    sex varchar2(10) not null,
    card_num number(16,0) not null   
);

CREATE TABLE qna(
    q_num number(10,0) not null PRIMARY KEY,
    q_title varchar2(40) not null,
    q_content clob not null,
    q_id varchar2(40) not null,
    regdate date not null,
    q_solve varchar2(20) not null
);

CREATE TABLE qna_reply(
    re_qnum number not null PRIMARY KEY,
    re_content varchar2(900) not null,
    re_date date not null,
    q_id varchar2(12) not null,
    q_num number not null,
    CONSTRAINT qna_reply_fk1 FOREIGN KEY (q_num) REFERENCES qna (q_num)
);

CREATE SEQUENCE qreply_seq;
CREATE SEQUENCE a_num_seq;
CREATE SEQUENCE c_num_seq;
CREATE SEQUENCE q_num_seq;


