/**********************************/
/* Table Name: 회원가입 */
/**********************************/
CREATE TABLE muser(
		id                            		VARCHAR2(10)		 NULL ,
		passwd                        		VARCHAR2(10)		 NOT NULL,
		email                         		VARCHAR2(20)		 NOT NULL,
		name                          		VARCHAR2(20)		 NOT NULL,
		reg_date                      		DATE		 NOT NULL
);

COMMENT ON TABLE muser is '회원가입';
COMMENT ON COLUMN muser.id is 'id';
COMMENT ON COLUMN muser.passwd is 'passwd';
COMMENT ON COLUMN muser.email is 'email';
COMMENT ON COLUMN muser.name is 'name';
COMMENT ON COLUMN muser.reg_date is 'reg_date';


/**********************************/
/* Table Name: 게시판 */
/**********************************/
CREATE TABLE mboard(
		num                           		NUMBER(20)		 NULL ,
		title                         		VARCHAR2(100)		 NOT NULL,
		content                       		CLOB		 NOT NULL,
		reg_date                      		DATE		 NOT NULL,
		id                            		VARCHAR2(10)		 NULL 
);

COMMENT ON TABLE mboard is '게시판';
COMMENT ON COLUMN mboard.num is 'num';
COMMENT ON COLUMN mboard.title is 'title';
COMMENT ON COLUMN mboard.content is 'content';
COMMENT ON COLUMN mboard.reg_date is 'reg_date';
COMMENT ON COLUMN mboard.id is 'id';



ALTER TABLE muser ADD CONSTRAINT IDX_muser_PK PRIMARY KEY (id);

ALTER TABLE mboard ADD CONSTRAINT IDX_mboard_PK PRIMARY KEY (num);
ALTER TABLE mboard ADD CONSTRAINT IDX_mboard_FK0 FOREIGN KEY (id) REFERENCES muser (id);

