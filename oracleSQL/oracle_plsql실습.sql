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
    --���� �ʱ�ȭ�� �� �Ŀ� ����ϰų� ���� �۾� ����
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

-���
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
���̺��� �÷����� ���� �ٸ� ������ ������ Ÿ������ �����ǵ�� ���ڵ� ���� �ش� �ʵ����
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