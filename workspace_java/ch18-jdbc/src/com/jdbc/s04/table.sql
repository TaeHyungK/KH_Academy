CREATE TABLE salary(
	name varchar2(10) NOT NULL PRIMARY KEY,
	pay number
);

INSERT INTO salary VALUES ('John', 1000);
INSERT INTO salary VALUES ('Peter', 2000);
INSERT INTO salary VALUES ('Annie', 3000);
COMMIT;

CREATE OR REPLACE procedure adjust(n varchar2, rate float)
IS 
newpay float;
BEGIN
	SELECT pay 
	INTO newpay
	FROM salary
	WHERE name = n;
	
	--새로운 급여 연산
	newpay := newpay + (newpay*rate);
	
	--새로운 급여로 변경
	UPDATE salary SET pay = newpay
	WHERE name = n;
	
	COMMIT;
	
	exception when others then
	dbms_output.put_line('error occurred!');
	ROLLBACK;
END ;