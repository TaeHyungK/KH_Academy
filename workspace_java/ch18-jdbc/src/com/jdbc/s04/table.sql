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
	
	--���ο� �޿� ����
	newpay := newpay + (newpay*rate);
	
	--���ο� �޿��� ����
	UPDATE salary SET pay = newpay
	WHERE name = n;
	
	COMMIT;
	
	exception when others then
	dbms_output.put_line('error occurred!');
	ROLLBACK;
END ;