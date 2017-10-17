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
    --변수 초기화를 한 후에 출력하거나 연산 작업 수행, 초기화하지 않으면 null
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

-상수(Constant)
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
테이블의 컬럼들이 서로 다른 유형의 데이터 타입으로 구성되듯이 레코드 역시 해당 필드들이
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

DECLARE 
    test_number integer;
    result_num integer;
BEGIN
    --변수의 초기화
    test_number := 1;
    result_num := 0;
    
    for test_number in reverse 1..10 loop
        result_num := 2 * test_number;
        dbms_output.put_line(result_num);
    end loop;
END;

-GOTO문

DECLARE 
    test_number integer;
    result_num integer;
BEGIN
    --변수의 초기화
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

- 커서(Cursor)
SELECT 문장을 실행하면 조건에 따른 결과가 추출, 추출되는 결과는 한 건이 될 수도 있고
여러 건이 될수도 있으므로 이를 결과 셋(result set)혹은 결과 집합이라고 부름. 쿼리에 의해
반환되는 결과는 메모리 상에 위치. PL/SQL에서는 커서를 사용하여 결과 집합에 접근.

DECLARE
    cursor emp_csr is
        SELECT empno FROM emp
        WHERE deptno = 10;
    
    --emp테이블에있는 empno의 자료형을 읽어서 emp_no의 자료형으로 사용    
    emp_no emp.empno%type;
BEGIN
    --Cursor 오픈
    open emp_csr;
    --Cursor 페치
    loop
        fetch emp_csr into emp_no;
        --%notfound : 커서에서만 사용 가능한 속성,
        --            더이상 페치(할당)할 로우(row,행)이 없음을 의미
        exit when emp_csr%notfound;
        dbms_output.put_line(emp_no);
    end loop;
    --Cursor closse
    close emp_csr;
END;

- 함수
입력받은 값으로부터 10%의 세율을 얻는 함수
CREATE OR REPLACE function tax(p_value in number)
    return number
is
BEGIN
    return p_value*0.1;
END;

SELECT TAX(100) FROM dual;
SELECT sal, TAX(sal) tax, sal-TAX(sal) "실지급 급여" FROM emp;

급여와 커미션을 합쳐서 세금 계산
CREATE OR REPLACE function tax2(p_sal in emp.sal%type, p_bonus emp.comm%type)
    return number
is
BEGIN
    return (p_sal + NVL(p_bonus,0))*0.1; 
END;
/*
NVL(value1, value2) : value1이 null이면 value2를 사용
*/

SELECT empno, ename, sal, comm, TAX2(sal,comm) "tax" 
FROM emp;

급여(보너스 포함)에 대한 세율을 다음과 같이 정의함.
급여가 월 $1,000보다 적으면 세율을 5% 적용하며, $1,000이상 $2,000이하면 10%,
$2,000을 초과하면 20%를 적용

CREATE OR REPLACE function tax3(p_sal in emp.sal%type, p_bonus emp.comm%type)
    return number
IS
    l_sum number;
    l_tax number;
BEGIN
    l_sum := p_sal + NVL(p_bonus,0);
    --세율 적용 조건 명시
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

사원번호를 통해서 급여를 알려주는 함수
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

부서번호를 전달하면 부서명을 구할 수 있는 함수
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

-생성된 함수 확인하기
데이터 사전(Data Dictionary)을 통해 검색, 데이터 사전에 저장된 모든 값은 대문자로
저장되기 때문에 대문자로 검색

SELECT object_name, object_type
FROM user_objects
WHERE object_type = 'FUNCTION';

- 작성된 함수의 소스 코드 확인
SELECT text
FROM user_source
WHERE type='FUNCTION' 
AND name = 'TAX';

[실습문제]
1. 두 숫자를 제공하면 덧셈을 해서 결과를 반환하는 함수를 정의
CREATE OR REPLACE function add_num(num1 integer, num2 integer)
    return integer is
BEGIN
    return num1+num2;
END;

SELECT add_num(10,20) FROM dual;
SELECT ename, ADD_NUM(sal, NVL(comm,0)) "실급여" FROM emp;

2. 부서번호를 입력하면 해당 부서에서 근무하는 사원 수를 반환하는 함수
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

SELECT deptno, dname, GET_EMP_COUNT(deptno) 사원수
FROM dept;

SELECT COUNT(*) FROM emp
WHERE deptno = 30;

3. emp테이블의 입사일을 입력하면 근무연차를 구하는 함수를 정의(소수점 자리 절삭)
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

SELECT ename, GET_INFO_HIREDATE(hiredate) 근무연차 FROM emp;

4. emp테이블을 이용해서 사원번호를 입력하면 해당 사원의 관리자 이름을 구하는 함수 정의
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

5. emp 테이블을 이용해서 사원번호를 입력하면 급여 등급을 구하는 함수
(1000 미만 F, 1000~2000미만 D, 2000~3000미만 C, 3000~4000미만 B
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

- 작성된 Stored Procedure 확인
SELECT object_name,object_type
FROM user_objects
WHERE object_type = 'PROCEDURE';

- Stored Procedure 의 Source를 데이터 사전을 이용해서 얻음
SELECT text
FROM user_source
WHERE name = 'HELLO_WORLD';

부서테이블에 부서 정보를 입력하는 프로시저를 생성
CREATE OR REPLACE procedure add_department(p_deptno dept.deptno%type, 
                                           p_dname dept.dname%type,
                                           p_loc dept.loc%type)
IS
BEGIN
    --parameter 변수에 입력받은 값으로 부서(dept) 테이블의 각 컬럼에 데이터를 추가
    --그리고 정상적으로 Transaction을 종료
    INSERT INTO dept
    VALUES (p_deptno, p_dname, p_loc);
    
    --오류가 없으면 커밋
    COMMIT;
    exception when others then
        dbms_output.put_line(p_dname || ' register is failed');
        ROLLBACK;
END;

exec add_department(60, 'CINEMA', 'BUSAN');

사원테이블에 사원정보를 저장
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
    --변수 선언
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

--하나의 행이 반환되어 에러가 발생하지 않는 경우
exec info_hiredate(1980);
-- 하나 이상의 행이 반환되어 에러가 발생하는 경우
exec info_hiredate(1981);

-커서 이용하기
명백하게 하나의 행일 경우 컬럼과 매칭된 데이터를 INTO를 이용해서 변수에 담을 수 있지만
여러개의 행일 경우는 CURSOR를 이용해야함

위에 명시한 info_hiredate 프로시저를 cursor를 사용해서 변경

CREATE OR REPLACE procedure info_hiredate(p_year varchar2)
IS
    l_emp emp%rowtype;
    --커서 선언
    CURSOR emp_cur is
        SELECT empno, ename, sal
        FROM emp
        WHERE TO_CHAR(hiredate, 'YYYY') = p_year;
BEGIN
    --커서 열기
    OPEN emp_cur;
    
    --커서로부터 데이터 읽기
    loop
        fetch emp_cur into l_emp.empno, l_emp.ename, l_emp.sal;
        exit when emp_cur%notfound;
        
        dbms_output.put_line(l_emp.empno || ' ,' || l_emp.ename || ' ,' || l_emp.sal); 
    end loop;
    
    --커서 닫기
    CLOSE emp_cur;
END;

exec info_hiredate(1980);
exec info_hiredate('1981');

[실습문제]
1. 'SALES'부서에 속한 사원의 정보보기 (empno, ename)
CREATE OR REPLACE procedure emp_info(p_dept dept.dname%type)
IS
    l_emp_no emp.empno%type;
    l_emp_name emp.ename%type;
    
    --커서 선언(emp_cur)
    CURSOR emp_cur IS
        SELECT empno, ename
        FROM emp
        WHERE deptno = (SELECT deptno FROM dept
                        WHERE dname = p_dept);
BEGIN
    --커서 오픈
    OPEN emp_cur;
    
    --커서 읽어오기
    loop
        fetch emp_cur into l_emp_no, l_emp_name;
        exit when emp_cur%notfound;
        
        dbms_output.put_line(l_emp_no || ', ' || l_emp_name);
    end loop;
    
    --커서 닫기
    CLOSE emp_cur;
END;

exec emp_info('SALES');

2. 특정 숫자를 입력하면 부서에 소속한 사원의 수가 입력된 숫자 이상일 때 해당 부서 정보 제공(부서명, 사원수)

CREATE OR REPLACE procedure count_Dept(p_num number)
IS
    --커서 선언
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

- 패키지(Package)
패키지는 선언부와 본문으로 구분. 선언부는 선언부는 패키지에 포함될 Stored Procedure 
또는 Stored Function을 포함.

-선언부 생성
CREATE OR REPLACE
package employee_pkg as
    procedure print_ename(p_empno number);
    procedure print_sal(p_empno number);
end employee_pkg;

-본문 생성

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

- 트리거(Trigger)
지정한 조건을 만족하면 어떤 이벤트를 발생시키는 데이터베이스 객체

CREATE OR REPLACE trigger print_message
AFTER INSERT ON dept
BEGIN
    dbms_output.put_line('정상적으로 추가되었습니다.');
END;

insert into dept values (80, 'ART', 'BUSAN');
COMMIT;

급여를 ㅇ비력할 때 최소 $500 ~ $6000을 벗어나면 사원 추가 또는 수정이 발생하지 않도록
하는 TRIGGER를 작성

CREATE OR REPLACE trigger range_salary
BEFORE INSERT OR UPDATE ON emp
--FOR EACH ROW 는 매번 추가되는 행의 수만큼 trigger가 발생함
for each row
DECLARE
    --변수 선언
    l_min_sal number := 500; --최소 급여
    l_max_sal number := 6000;   --최대 급여 
BEGIN
    -- :new. 컬럽이름의 형식으로 추가, 수정할 때 해당 컬럼의 새로운 값을 저장함
    if :new.sal NOT BETWEEN l_min_sal AND l_max_sal then
    --개발자가 정의한 에러, 에러번호는 20000~21000사이의 값을 임의로 지정
        raise_application_error(-20001, '해당 직무의 급여 범위를 확인하세요.');
    end if;
END;

INSERT INTO emp
VALUES (9003, 'NORA', 'MANAGER', 7698, SYSDATE, 7000, 100, 30);
트리거에 의해서 INSERT하기 전에 급여 범위를 체크해서 500~6000사이만 인정하고
나머지는 INSERT전에 예외를 발생시킴
ORA-20001: 해당 직무의 급여 범위를 확인하세요.


COMMIT;

