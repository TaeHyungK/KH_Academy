PL/SQL�̶�?
PL/SQL�� Procedure Language extension to Structured Query Language(SQL)�� ����
         SQL�� Ȯ���� ������ ó�� ���
         
PL/SQL�� �⺻ ����
PL/SQL�� �⺻ ������ ���(block)
1) ����� : ����� ������ ����� ����(����ο��� ������ ��� ������ ����)
2) ����� : ���� ó���� ������ ����ϴ� �κ�
3) ����ó���� : ����ο��� ������ ó���ϴ� �� �߻��� �� �ִ� ���� �����鿡 ���� ó���ϴ� �κ�

�⺻ ����
BEGIN 
 dbms_output.put_line('Hello Wolrd');
END;

������ ���
declare
 --������ ������ �� �ִ� �����
 message VARCHAR2(100);
BEGIN
 --����ο� ����� ������ ����ο��� �̸� ����Ǿ�� ��
 message := 'Hello Wolrd!';
 dbms_output.put_line(message);
END;

declare
  -- ���� �����ϰ� �ʱ�ȭ
  message VARCHAR2(100) := 'Hello Oracle!!';
BEGIN
  dbms_output.put_line(message);
END;

DECLARE
    counter integer;
BEGIN
    --���� �ʱ�ȭ�� �� �Ŀ� ����ϰų� ���� �۾� ����, �ʱ�ȭ���� ������ null
--    counter := 0;
    counter := counter +1;
    if counter is null then
       dbms_output.put_line(counter);
    end if; 
END;

�͸� ���(Anonymous BLOCK)
DECLARE
    counter INTEGER;
    i INTEGER;
BEGIN
    FOR i IN 1..9 LOOP
        counter := (2*i);
        dbms_output.put_line('2 * ' || i || ' = ' || counter);
    END LOOP;
    
END;

���� ó����
DECLARE
    counter INTEGER;
    
BEGIN
    counter := 10;
    -- ���ڸ� 0���� ������ ���� �߻�
    counter := counter/0;
    dbms_output.put_line(counter);
    EXCEPTION WHEN others THEN
        -- ����ó����
        -- ����ο��� ���ܰ� �߻��ϸ� ����ó���η� �����帧�� �̵�
        dbms_output.put_line('error');
END;

-������ ���
-����
emp_num1 number(9);
grade char(2);
emp_num2 integer :=1;

-���(Constant)
nYear constant integer := 30;

-�ݷ��� : varray, ��ø ���̺�, Associative array(index-by table)
            ��������, ��������, Ű-�� ������ ��
(1)varray : variable array�� ���ڷ� ��������(fixed number)�� ���� �迭 
DECLARE
    type varray_test is varray(3) of integer; --varray ����
    --varray_test Ÿ�� ���� ����
    varray1 varray_test;
BEGIN
    --varray�� ������ ����   1  2  3
    varray1 := varray_test(10,20,30);
    dbms_output.put_line(varray1(1));
END;

-��ø ���̺� : ����ÿ� ��ü ũ�⸦ ����� �ʿ䰡 ����.
DECLARE
    type nested_test is table of varchar2(10);
    --������ ������ nseted_test Ÿ�� ���� ����
    nested1 nested_test;
BEGIN
    --��ø ���̺� ������ ����
                    --      1   2   3   4
    nested1 := nested_test('A','B','C','D');
    dbms_output.put_line(nested1(2));
END;

-Associative array(index-by table)
�����迭�� key�� value ������ �̷���� �ݷ���

DECLARE                     --  value�� Ÿ�� <��               ��> key�� Ÿ��
    type assoc_array_num_type is table of number index by pls_integer;
    --key�� pls_integer���̸� ���� number���� ��ҵ�� ����
    assoc1 assoc_array_num_type;
BEGIN
    assoc1(3):= 33; --assoc_array_num_type�� Ű�� 3, ���� 33
    dbms_output.put_line(assoc1(3));
END;

DECLARE
    type assoc_array_str_type2 is table of varchar2(32) index by varchar2(32);
    assoc2 assoc_array_str_type2;
BEGIN
    assoc2('K') := 'KOREA'; 
    dbms_output.put_line(assoc2('K'));
END;

-�ݷ����� �����ͺ��̽� ��ü�� ����(���� �ѵ� �޸𸮿� ����Ǿ� ����)
CREATE TYPE alphabet_type AS VARRAY(26) OF VARCHAR2(2);

DECLARE
    test_alph alphabet_type;
BEGIN
                        --     1   2   3   4
    test_alph := alphabet_type('A','B','C','D');
    dbms_output.put_line(test_alph(1));
END;

-���ڵ�
���̺��� �÷����� ���� �ٸ� ������ ������ Ÿ������ �����ǵ��� ���ڵ� ���� �ش� �ʵ����
���� �ٸ� ������ Ÿ���� ���� �� ����

DECLARE
    type record1 is record(deptno number NOT NULL := 50,
                          dname varchar2(14),
                          loc varchar2(13));
    --������ ������ record1�� �޴� ���� ����
    rec1 record1;
BEGIN
    --record1 ���ڵ� ���� rec1�� dname�ʵ忡 �� �Ҵ�
    rec1.dname := 'RECORD';
    --record1 ���ڵ� ���� rec1�� loc�ʵ忡 �� �Ҵ�
    rec1.loc := 'SEOUL';
    
    --rec1 ���ڵ� ���� dept ���̺� Insert
    INSERT INTO dept 
    VALUES rec1;
    COMMIT;
    exception when others then ROLLBACK;
END;

- IF ��
DECLARE
    --���� ����
    grade char(1);
BEGIN
    --���� �ʱ�ȭ
    grade := 'B';
    
    if grade = 'A' then
       dbms_output.put_line('Excellent');
    elsif grade = 'B' then
       dbms_output.put_line('Good');
    elsif grade = 'C' then
       dbms_output.put_line('Fair');
    elsif grade = 'D' then
       dbms_output.put_line('Poor');
    end if;
END;

- CASE��
DECLARE
    grade char(1);
BEGIN
    grade := 'C';
    
    case grade
        when 'A' then
        dbms_output.put_line('Excellent');
        when 'B' then
        dbms_output.put_line('Good');
        when 'C' then
        dbms_output.put_line('Fair');
        when 'D' then
        dbms_output.put_line('Poor');
        else 
        dbms_output.put_line('Not Found');
    end case;
END;

- Loop��
DECLARE
    test_number integer;
    result_num integer;
BEGIN
    test_number := 1;
    
    loop
        result_num := 2 * test_number;
        if result_num > 20 then
            exit; -- ��� ����
        else
            dbms_output.put_line(result_num);  
        end if;
        test_number := test_number + 1;
    end loop;
END;


DECLARE 
    test_number integer;
    result_num integer;
BEGIN
    test_number := 1;
    
    loop
        result_num := 2 * test_number;
        
        exit when result_num > 20;
        
        dbms_output.put_line(result_num);
        test_number := test_number+1;
    end loop;
END;


DECLARE
    test_number integer;
    result_num integer;
BEGIN
    test_number := 1;
    result_num := 0;
    
    while result_num < 20 
    loop
        result_num := 2 * test_number;
        dbms_output.put_line(result_num);
        test_number := test_number+1;
    end loop;
END;

- FOR ~ LOOP��

DECLARE
    test_num integer;
    result_num integer;
BEGIN
    test_number := 1;
    result_num := 0;
    
    for test_number in 1..10 
    loop
        result_num := 2 * test_number;
        dbms_output.put_line(result_num);
        test_number := test_number+1;
    end loop;
END;

DECLARE 
    test_number integer;
    result_num integer;
BEGIN
    --������ �ʱ�ȭ
    test_number := 1;
    result_num := 0;
    
    for test_number in reverse 1..10 loop
        result_num := 2 * test_number;
        dbms_output.put_line(result_num);
    end loop;
END;

-GOTO��

DECLARE 
    test_number integer;
    result_num integer;
BEGIN
    --������ �ʱ�ȭ
    test_number := 1;
    result_num := 0;
    
    goto second;
    dbms_output.put_line('<<first>>');
    
    <<first>>
    for test_number in 1..10 loop
        result_num := 2 * test_number;
        dbms_output.put_line(result_num);
    end loop;
    
    dbms_output.put_line('<<second>>');
    
    result_num:=0;
    <<second>>
    for test_number in reverse 1..10 loop
        result_num := 3 * test_number;
        dbms_output.put_line(result_num);
    end loop;
END;

- Ŀ��(Cursor)
SELECT ������ �����ϸ� ���ǿ� ���� ����� ����, ����Ǵ� ����� �� ���� �� ���� �ְ�
���� ���� �ɼ��� �����Ƿ� �̸� ��� ��(result set)Ȥ�� ��� �����̶�� �θ�. ������ ����
��ȯ�Ǵ� ����� �޸� �� ��ġ. PL/SQL������ Ŀ���� ����Ͽ� ��� ���տ� ����.

DECLARE
    cursor emp_csr is
        SELECT empno FROM emp
        WHERE deptno = 10;
    
    --emp���̺��ִ� empno�� �ڷ����� �о emp_no�� �ڷ������� ���    
    emp_no emp.empno%type;
BEGIN
    --Cursor ����
    open emp_csr;
    --Cursor ��ġ
    loop
        fetch emp_csr into emp_no;
        --%notfound : Ŀ�������� ��� ������ �Ӽ�,
        --            ���̻� ��ġ(�Ҵ�)�� �ο�(row,��)�� ������ �ǹ�
        exit when emp_csr%notfound;
        dbms_output.put_line(emp_no);
    end loop;
    --Cursor closse
    close emp_csr;
END;

- �Լ�
�Է¹��� �����κ��� 10%�� ������ ��� �Լ�
CREATE OR REPLACE function tax(p_value in number)
    return number
is
BEGIN
    return p_value*0.1;
END;

SELECT TAX(100) FROM dual;
SELECT sal, TAX(sal) tax, sal-TAX(sal) "������ �޿�" FROM emp;

�޿��� Ŀ�̼��� ���ļ� ���� ���
CREATE OR REPLACE function tax2(p_sal in emp.sal%type, p_bonus emp.comm%type)
    return number
is
BEGIN
    return (p_sal + NVL(p_bonus,0))*0.1; 
END;
/*
NVL(value1, value2) : value1�� null�̸� value2�� ���
*/

SELECT empno, ename, sal, comm, TAX2(sal,comm) "tax" 
FROM emp;

�޿�(���ʽ� ����)�� ���� ������ ������ ���� ������.
�޿��� �� $1,000���� ������ ������ 5% �����ϸ�, $1,000�̻� $2,000���ϸ� 10%,
$2,000�� �ʰ��ϸ� 20%�� ����

CREATE OR REPLACE function tax3(p_sal in emp.sal%type, p_bonus emp.comm%type)
    return number
IS
    l_sum number;
    l_tax number;
BEGIN
    l_sum := p_sal + NVL(p_bonus,0);
    --���� ���� ���� ���
    if l_sum < 1000 then
        l_tax := l_sum * 0.05;
    elsif l_sum <=2000 then
        l_tax := l_sum * 0.1;
    else
        l_tax := l_sum * 0.2;
    end if;
    
    return l_tax;
END;

SELECT empno, ename, sal, comm, TAX3(sal, comm) tax
FROM emp;

�����ȣ�� ���ؼ� �޿��� �˷��ִ� �Լ�
CREATE OR REPLACE function emp_salaries(emp_no in emp.empno%type)
    return number
IS
    nSalaries number(9);
BEGIN
    nSalaries := 0;
    
    SELECT sal
    INTO nSalaries
    FROM emp
    WHERE empno = emp_no;
    
    return nSalaries;
END;

SELECT EMP_SALARIES(7839) FROM dual;
SELECT empno, ename, EMP_SALARIES(empno) 
FROM emp
WHERE deptno=10;

�μ���ȣ�� �����ϸ� �μ����� ���� �� �ִ� �Լ�
create or replace function get_dname(dept_no number)
    return varchar2 is
    sDeptName varchar2(30);
begin
    SELECT dname
    INTO sDeptName
    FROM dept
    WHERE deptno=dept_no;
  
    return sDeptName;
end;

SELECT get_dname(10) FROM dual;
SELECT deptno, GET_DNAME(deptno) "Department Name" FROM dept;
SELECT empno, ename, sal, GET_DNAME(deptno) "Department Name"
FROM emp;

-������ �Լ� Ȯ���ϱ�
������ ����(Data Dictionary)�� ���� �˻�, ������ ������ ����� ��� ���� �빮�ڷ�
����Ǳ� ������ �빮�ڷ� �˻�

SELECT object_name, object_type
FROM user_objects
WHERE object_type = 'FUNCTION';

- �ۼ��� �Լ��� �ҽ� �ڵ� Ȯ��
SELECT text
FROM user_source
WHERE type='FUNCTION' 
AND name = 'TAX';

[�ǽ�����]
1. �� ���ڸ� �����ϸ� ������ �ؼ� ����� ��ȯ�ϴ� �Լ��� ����
CREATE OR REPLACE function add_num(num1 integer, num2 integer)
    return integer is
BEGIN
    return num1+num2;
END;

SELECT add_num(10,20) FROM dual;
SELECT ename, ADD_NUM(sal, NVL(comm,0)) "�Ǳ޿�" FROM emp;

2. �μ���ȣ�� �Է��ϸ� �ش� �μ����� �ٹ��ϴ� ��� ���� ��ȯ�ϴ� �Լ�
CREATE OR REPLACE function get_emp_count(dept_no emp.deptno%type)
    return integer is
    emp_count integer;
BEGIN
    SELECT COUNT(*)
    INTO emp_count
    FROM emp
    WHERE deptno = dept_no;

    return emp_count;
END;

SELECT deptno, dname, GET_EMP_COUNT(deptno) �����
FROM dept;

SELECT COUNT(*) FROM emp
WHERE deptno = 30;

3. emp���̺��� �Ի����� �Է��ϸ� �ٹ������� ���ϴ� �Լ��� ����(�Ҽ��� �ڸ� ����)
CREATE OR REPLACE function get_info_hiredate(hire_date emp.hiredate%type)
    return integer is
    result integer;
BEGIN
    SELECT TRUNC(MONTHS_BETWEEN(SYSDATE, hiredate)/12) 
    INTO result
    FROM emp
    WHERE hiredate = hire_date;
    
    return result;
END;

SELECT ename, GET_INFO_HIREDATE(hiredate) �ٹ����� FROM emp;

4. emp���̺��� �̿��ؼ� �����ȣ�� �Է��ϸ� �ش� ����� ������ �̸��� ���ϴ� �Լ� ����
CREATE OR REPLACE function get_mgr_name(emp_no emp.empno%type)
    return varchar2 is
    m_name varchar2(10);       
BEGIN
    SELECT ename
    INTO m_name
    FROM emp
    WHERE empno = (SELECT mgr FROM emp
                 WHERE empno = emp_no); 
    
    return m_name;
END;

SELECT ename, GET_MGR_NAME(empno) FROM emp;

5. emp ���̺��� �̿��ؼ� �����ȣ�� �Է��ϸ� �޿� ����� ���ϴ� �Լ�
(1000 �̸� F, 1000~2000�̸� D, 2000~3000�̸� C, 3000~4000�̸� B
4000~5000 A

CREATE OR REPLACE function get_sal_grade(emp_no emp.empno%type)
    return char is
    sgrade char(1);
BEGIN
    SELECT 
    CASE WHEN sal>=4000 AND sal<=5000 THEN 'A'
             WHEN sal>=3000 AND sal<4000 THEN 'B'
             WHEN sal>=2000 AND sal<3000 THEN 'C'
             WHEN sal>=1000 AND sal<2000 THEN 'D'
             ELSE 'F'
        END
    INTO sgrade
    FROM emp
    WHERE empno = emp_no;
    
    return sgrade;
END;

SELECT ename, sal, GET_SAL_GRADE(empno) FROM emp;

create or replace procedure hello_world
is
  message VARCHAR2(100) := 'HELLO WORLD';
begin
 	dbms_output.put_line(message);
end;

exec hello_world;


execute hello_world;
exec hello_world;

CREATE OR REPLACE procedure hello_world2(p_message varchar2) is
BEGIN
    dbms_output.put_line(p_message);
END;

exec hello_world2('Korea');

- �ۼ��� Stored Procedure Ȯ��
SELECT object_name,object_type
FROM user_objects
WHERE object_type = 'PROCEDURE';

- Stored Procedure �� Source�� ������ ������ �̿��ؼ� ����
SELECT text
FROM user_source
WHERE name = 'HELLO_WORLD';

�μ����̺� �μ� ������ �Է��ϴ� ���ν����� ����
CREATE OR REPLACE procedure add_department(p_deptno dept.deptno%type, 
                                           p_dname dept.dname%type,
                                           p_loc dept.loc%type)
IS
BEGIN
    --parameter ������ �Է¹��� ������ �μ�(dept) ���̺��� �� �÷��� �����͸� �߰�
    --�׸��� ���������� Transaction�� ����
    INSERT INTO dept
    VALUES (p_deptno, p_dname, p_loc);
    
    --������ ������ Ŀ��
    COMMIT;
    exception when others then
        dbms_output.put_line(p_dname || ' register is failed');
        ROLLBACK;
END;

exec add_department(60, 'CINEMA', 'BUSAN');

������̺� ��������� ����
CREATE OR REPLACE procedure register_emp(e_no number,
                                         e_name varchar2,
                                         j_work varchar2,
                                         j_mgr number,
                                         j_sal number,
                                         j_comm number,
                                         j_deptno number)
IS
BEGIN
    INSERT INTO emp
    VALUES (e_no, e_name, j_work, j_mgr, sysdate, j_sal, j_comm, j_deptno);
    
    COMMIT;
    
    exception when others then
    ROLLBACK;
END;

exec register_emp(9000, 'PETER', 'MANAGER', 7788, 6000, 200 , 30);

CREATE OR REPLACE procedure output_department(p_dept_no dept.deptno%type)
IS
    --���� ����
    l_dname dept.dname%type;
    l_loc dept.loc%type;
BEGIN
    SELECT dname, loc
    INTO l_dname, l_loc
    FROM dept
    WHERE deptno = p_dept_no;
    
    dbms_output.put_line(l_dname || ', ' || l_loc);
END;

exec output_department(10);

CREATE OR REPLACE procedure info_hiredate(p_year in varchar2)
IS
    l_emp emp%rowtype;
BEGIN
    SELECT empno, ename, sal
    INTO l_emp.empno, l_emp.ename, l_emp.sal
    FROM emp
    WHERE TO_CHAR(hiredate, 'YYYY') = p_year;
    
    dbms_output.put_line(l_emp.empno || ' ,' || l_emp.ename || ' ,' || l_emp.sal);
END;

--�ϳ��� ���� ��ȯ�Ǿ� ������ �߻����� �ʴ� ���
exec info_hiredate(1980);
-- �ϳ� �̻��� ���� ��ȯ�Ǿ� ������ �߻��ϴ� ���
exec info_hiredate(1981);

-Ŀ�� �̿��ϱ�
����ϰ� �ϳ��� ���� ��� �÷��� ��Ī�� �����͸� INTO�� �̿��ؼ� ������ ���� �� ������
�������� ���� ���� CURSOR�� �̿��ؾ���

���� ����� info_hiredate ���ν����� cursor�� ����ؼ� ����

CREATE OR REPLACE procedure info_hiredate(p_year varchar2)
IS
    l_emp emp%rowtype;
    --Ŀ�� ����
    CURSOR emp_cur is
        SELECT empno, ename, sal
        FROM emp
        WHERE TO_CHAR(hiredate, 'YYYY') = p_year;
BEGIN
    --Ŀ�� ����
    OPEN emp_cur;
    
    --Ŀ���κ��� ������ �б�
    loop
        fetch emp_cur into l_emp.empno, l_emp.ename, l_emp.sal;
        exit when emp_cur%notfound;
        
        dbms_output.put_line(l_emp.empno || ' ,' || l_emp.ename || ' ,' || l_emp.sal); 
    end loop;
    
    --Ŀ�� �ݱ�
    CLOSE emp_cur;
END;

exec info_hiredate(1980);
exec info_hiredate('1981');

[�ǽ�����]
1. 'SALES'�μ��� ���� ����� �������� (empno, ename)
CREATE OR REPLACE procedure emp_info(p_dept dept.dname%type)
IS
    l_emp_no emp.empno%type;
    l_emp_name emp.ename%type;
    
    --Ŀ�� ����(emp_cur)
    CURSOR emp_cur IS
        SELECT empno, ename
        FROM emp
        WHERE deptno = (SELECT deptno FROM dept
                        WHERE dname = p_dept);
BEGIN
    --Ŀ�� ����
    OPEN emp_cur;
    
    --Ŀ�� �о����
    loop
        fetch emp_cur into l_emp_no, l_emp_name;
        exit when emp_cur%notfound;
        
        dbms_output.put_line(l_emp_no || ', ' || l_emp_name);
    end loop;
    
    --Ŀ�� �ݱ�
    CLOSE emp_cur;
END;

exec emp_info('SALES');

2. Ư�� ���ڸ� �Է��ϸ� �μ��� �Ҽ��� ����� ���� �Էµ� ���� �̻��� �� �ش� �μ� ���� ����(�μ���, �����)

CREATE OR REPLACE procedure count_Dept(p_num number)
IS
    --Ŀ�� ����
    CURSOR c1 is
        SELECT dname, staff
        FROM dept t1, (select DEPTNO, count(*) as staff FROM emp GROUP BY deptno) t2
        WHERE t1.deptno = t2.deptno
        AND staff >= p_num;
        
        l_dname dept.dname%type;
        l_staff number;
BEGIN
    OPEN c1;
    
    loop
        fetch c1 into l_dname, l_staff;
        exit when c1%notfound;
        
        dbms_output.put_line(l_dname || ', ' || l_staff);
    end loop;
    CLOSE c1;
END;

exec count_dept(4);

- ��Ű��(Package)
��Ű���� ����ο� �������� ����. ����δ� ����δ� ��Ű���� ���Ե� Stored Procedure 
�Ǵ� Stored Function�� ����.

-����� ����
CREATE OR REPLACE
package employee_pkg as
    procedure print_ename(p_empno number);
    procedure print_sal(p_empno number);
end employee_pkg;

-���� ����

CREATE OR REPLACE
package body employee_pkg as
    procedure print_ename(p_empno number) is
        l_ename emp.ename%type;
    BEGIN
        SELECT ename
        INTO l_ename
        FROM emp
        WHERE empno = p_empno;
        dbms_output.put_line(l_ename);
    END print_ename;
    
    procedure print_sal(p_empno number) is
        l_sal emp.sal%type;
    BEGIN
        SELECT sal
        INTO l_sal
        FROM emp
        WHERE empno = p_empno;
        dbms_output.put_line(l_sal);
    END print_sal;
END employee_pkg;

exec employee_pkg.print_ename(7369);
exec employee_pkg.print_sal(7369);

- Ʈ����(Trigger)
������ ������ �����ϸ� � �̺�Ʈ�� �߻���Ű�� �����ͺ��̽� ��ü

CREATE OR REPLACE trigger print_message
AFTER INSERT ON dept
BEGIN
    dbms_output.put_line('���������� �߰��Ǿ����ϴ�.');
END;

insert into dept values (80, 'ART', 'BUSAN');
COMMIT;

�޿��� ������� �� �ּ� $500 ~ $6000�� ����� ��� �߰� �Ǵ� ������ �߻����� �ʵ���
�ϴ� TRIGGER�� �ۼ�

CREATE OR REPLACE trigger range_salary
BEFORE INSERT OR UPDATE ON emp
--FOR EACH ROW �� �Ź� �߰��Ǵ� ���� ����ŭ trigger�� �߻���
for each row
DECLARE
    --���� ����
    l_min_sal number := 500; --�ּ� �޿�
    l_max_sal number := 6000;   --�ִ� �޿� 
BEGIN
    -- :new. �÷��̸��� �������� �߰�, ������ �� �ش� �÷��� ���ο� ���� ������
    if :new.sal NOT BETWEEN l_min_sal AND l_max_sal then
    --�����ڰ� ������ ����, ������ȣ�� 20000~21000������ ���� ���Ƿ� ����
        raise_application_error(-20001, '�ش� ������ �޿� ������ Ȯ���ϼ���.');
    end if;
END;

INSERT INTO emp
VALUES (9003, 'NORA', 'MANAGER', 7698, SYSDATE, 7000, 100, 30);
Ʈ���ſ� ���ؼ� INSERT�ϱ� ���� �޿� ������ üũ�ؼ� 500~6000���̸� �����ϰ�
�������� INSERT���� ���ܸ� �߻���Ŵ
ORA-20001: �ش� ������ �޿� ������ Ȯ���ϼ���.


COMMIT;

