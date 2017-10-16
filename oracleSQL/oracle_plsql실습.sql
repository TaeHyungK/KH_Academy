PL/SQL이란?
PL/SQL은 Procedure Language extension to Structured Query Language(SQL)의 약자
         SQL을 확장한 순차적 처리 언어
         
PL/SQL의 기본 구조
PL/SQL의 기본 단위는 블록(block)
1) 선언부 : 사용할 변수나 상수를 선언(선언부에만 변수와 상수 선언이 가능)
2) 실행부 : 실제 처리할 로직을 담당하는 부분
3) 예외처리부 : 실행부에서 로직을 처리하던 중 발생할 수 있는 각종 오류들에 대해 처리하는 부분

기본 구조
BEGIN 
 dbms_output.put_line('Hello Wolrd');
END;

변수의 사용
declare
 --변수를 선언할 수 있는 선언부
 message VARCHAR2(100);
BEGIN
 --실행부에 사용할 변수는 선언부에서 미리 선언되어야 함
 message := 'Hello Wolrd!';
 dbms_output.put_line(message);
END;

declare
  -- 변수 선언하고 초기화
  message VARCHAR2(100) := 'Hello Oracle!!';
BEGIN
  dbms_output.put_line(message);
END;

DECLARE
    counter integer;
BEGIN
    --변수 초기화를 한 후에 출력하거나 연산 작업 수행
--    counter := 0;
    counter := counter +1;
    if counter is null then
       dbms_output.put_line(counter);
    end if; 
END;

익명 블록(Anonymous BLOCK)
DECLARE
    counter INTEGER;
    i INTEGER;
BEGIN
    FOR i IN 1..9 LOOP
        counter := (2*i);
        dbms_output.put_line('2 * ' || i || ' = ' || counter);
    END LOOP;
    
END;

예외 처리부
DECLARE
    counter INTEGER;
    
BEGIN
    counter := 10;
    -- 숫자를 0으로 나누어 예외 발생
    counter := counter/0;
    dbms_output.put_line(counter);
    EXCEPTION WHEN others THEN
        -- 예외처리부
        -- 실행부에서 예외가 발생하면 예외처리부로 실행흐름이 이동
        dbms_output.put_line('error');
END;

-변수와 상수
-변수
emp_num1 number(9);
grade char(2);
emp_num2 integer :=1;

-상수
nYear constant integer := 30;

-콜렉션 : varray, 중첩 테이블, Associative array(index-by table)
            고정길이, 가변길이, 키-값 데이터 쌍
(1)varray : variable array의 약자로 고정길이(fixed number)를 가진 배열 
DECLARE
    type varray_test is varray(3) of integer; --varray 선언
    --varray_test 타입 변수 선언
    varray1 varray_test;
BEGIN
    --varray에 데이터 저장   1  2  3
    varray1 := varray_test(10,20,30);
    dbms_output.put_line(varray1(1));
END;

-중첩 테이블 : 선언시에 전체 크기를 명시할 필요가 없음.
DECLARE
    type nested_test is table of varchar2(10);
    --위에서 선언한 nseted_test 타입 변수 선언
    nested1 nested_test;
BEGIN
    --중첩 테이블에 데이터 저장
                    --      1   2   3   4
    nested1 := nested_test('A','B','C','D');
    dbms_output.put_line(nested1(2));
END;

-Associative array(index-by table)
연관배열은 key와 value 쌍으로 이루어진 콜렉션

DECLARE                     --  value의 타입 <┐               ┌> key의 타입
    type assoc_array_num_type is table of number index by pls_integer;
    --key는 pls_integer형이며 값은 number형인 요소들로 구성
    assoc1 assoc_array_num_type;
BEGIN
    assoc1(3):= 33; --assoc_array_num_type의 키는 3, 값은 33
    dbms_output.put_line(assoc1(3));
END;

DECLARE
    type assoc_array_str_type2 is table of varchar2(32) index by varchar2(32);
    assoc2 assoc_array_str_type2;
BEGIN
    assoc2('K') := 'KOREA'; 
    dbms_output.put_line(assoc2('K'));
END;

-콜렉션을 데이터베이스 객체로 생성(껐다 켜도 메모리에 저장되어 있음)
CREATE TYPE alphabet_type AS VARRAY(26) OF VARCHAR2(2);

DECLARE
    test_alph alphabet_type;
BEGIN
                        --     1   2   3   4
    test_alph := alphabet_type('A','B','C','D');
    dbms_output.put_line(test_alph(1));
END;

-레코드
테이블의 컬럼들이 서로 다른 유형의 데이터 타입으로 구성되드싱 레코드 역시 해당 필드들이
각기 다른 데이터 타입을 가질 수 있음

DECLARE
    type record1 is record(deptno number NOT NULL := 50,
                          dname varchar2(14),
                          loc varchar2(13));
    --위에서 선언한 record1을 받는 변수 선언
    rec1 record1;
BEGIN
    --record1 레코드 변수 rec1의 dname필드에 값 할당
    rec1.dname := 'RECORD';
    --record1 레코드 변수 rec1의 loc필드에 값 할당
    rec1.loc := 'SEOUL';
    
    --rec1 레코드 값을 dept 테이블에 Insert
    INSERT INTO dept 
    VALUES rec1;
    COMMIT;
    exception when others then ROLLBACK;
END;

- IF 문
DECLARE
    --변수 선언
    grade char(1);
BEGIN
    --변수 초기화
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

- CASE문
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

- Loop문
DECLARE
    test_number integer;
    result_num integer;
BEGIN
    test_number := 1;
    
    loop
        result_num := 2 * test_number;
        if result_num > 20 then
            exit; -- 블록 종료
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

- FOR ~ LOOP문

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