오라클 SQL

-SELECT문
데이터베이스로부터 저장되어 있는 데이터를 검색하는데 사용

테이블의 이름을 기록한 테이블 명세를 조회
SELECT * FROM tab;

emp 테이블의 데이터 읽기
SELECT * FROM emp;
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno FROM emp;

특정 열을 선택
SELECT ename, sal FROM emp;

주석
SELECT * /*주석*/ FROM emp;

daul : 함수 및 계산의 결과를 볼 때 사용할 수 있는 공용(public) 테이블
함수 사용
SELECT ascii(0) FROM dual;
날짜
SELECT SYSDATE FROM dual;
연산
SELECT 7+10 FROM dual;

산술식 : 산술 연산자(+,-,*,/)를 사용하여 숫자 및 날짜 데이터로 표현식을 작성
SELECT ename, sal, sal+300 FROM emp;

연산자 우선순위
SELECT ename, sal, 12*(sal+300) FROM emp;

SELECT empno, ename, comm FROM emp;

산술식의 NULL값 : NULL값을 포함하는 산술식은 NULL로 계산
SELECT ename, 12*sal*comm FROM emp;

열 alias 정의
열 이름을 바꿈
열 이름 바로 뒤에 나옴. 열 이름과 alias 사이에 선택 사항인 as 키워드가 올 수도 있음
알리아스에 큰 따옴표를 사용하는 경우
- 대소문자 구별을 원할 때
- 공백을 포함하고 싶을 때
- _,#등 특수문자 사용할 때
- 숫자로 시작할 때

SELECT sal*12 ASal FROM emp;
SELECT sal*12 as ASal FROM emp;
SELECT sal*12 "Annual Salary" FROM emp;
SELECT ename AS name, comm commission FROM emp;
SELECT ename "Name", sal*12 "Annual Salary" FROM emp;

연결 연산자
열이나 문자열을 다른 열에 연결
두 개의 세로선(||)으로 나타냄
결과 열로 문자식을 생성
문자열 처리시 작은 따옴표('') 사용!!

SELECT ename || ' has $ ' || sal FROM emp;

연결 연산자와 NULL값 : 문자열에 NULL값을 결합할 경우 결과는 문자열
SELECT ename || comm FROM emp

distinct : 중복행 제거
SELECT DISTINCT deptno FROM emp;

테이블 구조 표시 : describe 명령을 사용하여 테이블의 구조 표시
DESC[RIBE] tablename

DESCRIBE emp;
DESC emp

[실습문제]
1. emp 테이블에서 사원번호, 사원이름, 월급을 출력하시오.
2. emp 테이블에서 사원이름과 월급을 출력하는데 컬럼명은 "이 름", "월 급"으로 바꿔서 출력하시오.
3. emp 테이블에서 사원번호, 사원이름, 월급, 연봉을 구하고 각각 컬럼명은 "사원번호", "사원이름",
   "월급", "연봉"으로 출력하시오.
4. emp 테이블의 업무(직업)를 중복되지 않게 출력하시오.
5. emp 테이블의 사원명과 업무로 연결해서 표시하고 컬럼명을 Employee and Job으로 표시하시오.

1.
SELECT empno, ename, sal FROM emp;
2.
SELECT ename "이 름", sal "월 급" FROM emp;
3.
SELECT empno 사원번호, ename 사원이름, sal 월급, sal*12 연봉 FROM emp;
4.
SELECT DISTINCT job FROM emp;
5.
SELECT ename || ', ' || job "Employee and Job" FROM emp;

선택을 사용하여 행 제한
SELECT 컬럼명... FROM 테이블명 WHERE 조건

SELECT * FROM emp
WHERE deptno =10;

SELECT ename, job, deptno FROM emp
WHERE ename = 'SMITH';

비교연산자의 사용
SELECT * FROM emp WHERE hiredate <> '82-01-23';
SELECT * FROM emp WHERE hiredate ^= '82-01-23';
SELECT * FROM emp WHERE hiredate != '82-01-23';

SELECT * FROM emp WHERE sal >= 2000 and sal <=5000;

between and .. : 두 값 사이(지정한 값 포함)
SELECT * FROM emp WHERE sal BETWEEN 1000 AND 1500;
SELECT * FROM emp WHERE sal NOT BETWEEN 1000 AND 1500;
SELECT * FROM emp WHERE ename NOT BETWEEN 'KING' AND 'SMITH';

in : 값 목록중의 값과 일치
SELECT * FROM emp WHERE sal IN (1300,2450,3000);
SELECT * FROM emp WHERE sal NOT IN (1300,2450,3000);
SELECT * FROM emp WHERE ename IN ('ALLEN','FORD');

like : like 연산자를 사용하여 패턴 일치
% : 0개 이상의 문자를 의미
_ : 한 문자를 나타냄
                                S가 처음,중간,끝에 오는 이름 검색
SELECT * FROM emp WHERE ename LIKE '%S%';
SELECT * FROM emp WHERE hiredate LIKE '%22';
                                (FOR 다음에 꼭 한글자)
SELECT * FROM emp WHERE ename LIKE 'FOR_';
                                (한 글자 다음의 M, M다음에 없거나 여러개)
SELECT * FROM emp WHERE ename LIKE '_M%';

검색하고자 하는 문자열에 _가 포함되어있을 경우 _앞에 \를 붙이고
escape '\'을 명시해서 검색
SELECT * FROM emp WHERE ename LIKE 'sc\_' ESCAPE '\';

검색하고자 하는 문자열에 %가 포함되어있을 경우
SELECT * FROM emp WHERE ename LIKE '%\%' ESCAPE '\';

NULL 조건 사용             (comm = null 불가)
SELECT * FROM emp WHERE comm is NULL;
                          (comm != null 불가)
SELECT * FROM emp WHERE comm is NOT NULL;

논리연산(and, or, not)를 사용하여 조건 정의
AND 연산자의 사용 : 구성 요소 조건이 모두 TRUE이면 TRUE를 반환
SELECT empno, ename, job, sal FROM emp
WHERE sal >= 2000 AND job LIKE '%MAN%';

OR 연산자의 사용 : 조건 중 하나가 TRUE이면 TRUE를 반환
SELECT empno, ename, job, sal FROM emp
WHERE sal > = 2000 OR job LIKE '%MAN%';

NOT 연산자의 사용
SELECT ename, job FROM emp
WHERE job NOT IN ('CLERK','SALESMAN');

WHERE절에는 alias를 사용할 수 없음
SELECT ename, sal*12 annsal FROM emp
WHERE sal*12 >= 35000;


[실습문제]
1. emp 테이블에서 사원번호가 7698인 사원의 이름, 업무, 급여를 출력
2. emp 테이블에서 사원이름이 SMITH인 사람의 이름, 월급, 부서번호 출력
3. emp 테이블에서 월급이 2500이상 3500미만인 사원의 이름, 입사일,월급 출력
4. emp 테이블에서 급여가 2000에서 3000사이에 포함되지 않는 사원의 이름, 업무, 급여를 출력

1.
SELECT ename, job, sal FROM emp
WHERE empno = 7698;
2. 
SELECT ename, sal, deptno FROM emp
WHERE ename = 'SMITH';
3.
SELECT ename, hiredate, sal FROM emp
WHERE sal >= 2500 AND sal <3500;
4.
SELECT ename, job, sal FROM emp
WHERE sal NOT BETWEEN 2000 AND 3000;

5. emp 테이블에서 81년05월01일과 81년 12월03일 사이에 입사한 사원의 이름, 급여, 입사일을 출력
6. emp 테이블에서 사원번호가 7566,7782,7932인 사원을 제외한 사람들의 사원번호, 이름, 월급 출력
7. emp테이블에서 부서번호(deptno) 30에서 근무하며 월 2,000달러 이하를 받는 81년 05월 01일 
   이전에 입사한 사원의 이름, 급여, 부서번호, 입사일을 출력
8. emp테이블에서 급여가 $2,000와 $5,000사이고 부서번호가 10 또는 30인 사원의 이름, 급여,부서번호를 출력

5. 
SELECT ename, sal, hiredate FROM emp
WHERE hiredate BETWEEN '81-05-01' AND '81-12-03';
6. 
SELECT empno, ename, sal FROM emp
WHERE empno NOT IN (7566,7782,7932);
7.
SELECT ename, sal, deptno, hiredate FROM emp
WHERE deptno = 30 AND sal <= 2000 AND hiredate <= '81-05-01';
8.
SELECT ename, sal, deptno FROM emp
WHERE (sal BETWEEN 2000 AND 5000) AND deptno IN(30,10);
                                      (deptno = 10 OR deptno = 30);

9. 업무가 SALESMAN 또는 MANAGER 이면서 급여가 $1600, $2975,$2850이 아닌 모든 사원의
   이름, 업무, 급여를 출력
10. emp 테이블에서 사원이름 중 s가 포함되지 않은 사람들 중 부서번호가 20인 사원들의
    이름, 부서번호를 출력
11. emp 테이블에서 이름에 A와 E가 있는 모든 사원의 이름을 출력
12. emp 테이블에서 관리자가 없는 모든 사원의 이름과 업무를 출력
13. emp 테이블에서 커미션 항목이 입력된 사원들의 이름, 급여, 커미션을 출력

9.
SELECT ename, job, sal FROM emp
WHERE job IN ('SALESMAN','MANAGER') AND sal NOT IN(1600,2975,2850);
10.
SELECT ename, deptno FROM emp
WHERE ename NOT LIKE '%S%' AND deptno=20;
11.
SELECT ename FROM emp
WHERE ename LIKE '%A%' OR ename LIKE '%E%';
12.
SELECT ename, job FROM emp
WHERE MGR iS NULL;
13.
SELECT ename, sal, comm FROM emp
WHERE comm is NOT NULL;

order by절 : 정렬
오름차순 : 작은 숫자 -> 큰 숫자, A -> Z, 가 -> 하
SELECT * FROM emp ORDER BY sal;
SELECT * FROM emp ORDER BY sal ASC;
SELECT * FROM emp ORDER BY ename;
SELECT * FROM emp
WHERE deptno=10
ORDER BY sal ASC;

내림차순 : 큰 숫자 -> 작은 숫자, Z -> A, 하 -> 가
SELECT * FROM emp 
WHERE deptno=10
ORDER BY sal DESC;

열 alias를 기준으로 정렬
SELECT empno, ename, sal*12 annsal FROM emp
ORDER BY annsal;

열의 숫자 위치를 사용하여 정렬
열의숫자  1     2     3        4 
SELECT ename, job, deptno, hiredate FROM emp
ORDER BY 3;

여러 열을 기준으로 정렬
1차 정렬의 기준열에 중복값이 있으면 2차 정렬이 가능
SELECT ename, deptno, sal FROM emp
ORDER BY deptno ASC , ename DESC;

NULLS FIRST, NULLS LAST : NULL값을 맨 앞 혹은 맨 뒤로 정렬할 수 있음
SELECT * FROM emp ORDER BY comm NULLS FIRST;
SELECT *FROM emp ORDER BY comm NULLS LAST;

[실습문제]
1. emp테이블에서 사원번호, 사원이름, 입사일을 출력하는데 입사일이 빠른 사람 순으로 정렬
2. emp테이블에서 사원이름, 급여, 연봉을 구하고 연봉이 많은 순으로 정렬
3. emp테이블에서 10번 부서와 20번 부서에서 근무하는 사원의 이름과 부서번호를 출력하는데
   이름을 영문자순(오름차순)으로 표시
4. 커미션을 받는 모든 사원의 이름, 급여, 커미션을 기준으로 내림차순으로 정렬하여 출력

1.
SELECT empno, ename, hiredate FROM emp
ORDER BY hiredate ASC;
2.
SELECT ename, sal, sal*12 annsal FROM emp
ORDER BY annsal DESC;
3.
SELECT ename, deptno FROM emp
WHERE deptno IN (10,20)
ORDER BY ename ASC;
4.
SELECT ename, sal, comm FROM emp
WHERE comm is NOT NULL
ORDER BY comm DESC;

함수
문자함수
대소문자 조작 함수 - LOWER, UPPER, INITCAP

LOWER: 지정한 문자열을 소문자로 변환
SELECT LOWER('HELLO') FROM dual;
UPPER: 지정한 문자열을 대문자로 변환
SELECT UPPER('hello') FROM dual;
INITCAP: 지정한 문자열의 첫자는 대문자 외는 소문자로 변환
SELECT INITCAP('hello world') FROM dual;
SELECT INITCAP(ename) FROM emp;
SELECT INITCAP(job) FROM emp;

문자 조작함수 - CONCAT, SUBSTR, LENGTH, INSTR, LPAD, RPAD, TRIM, REPLACE
CONCAT: 문자열1과 문자열2를 연결하여 하나의 문자열로 반환
SELECT CONCAT('Hello','World') from dual;
SELECT CONCAT(ename,job) from emp;

SUBSTR: 대상 문자열부터 지정 인덱스부터 문자열 추출
[주의]인덱스 1부터 시작!!
               1234567891011
SELECT SUBSTR('Hello World',3) from dual;
문자열 세번째 부터 3개의 문자열 추출
SELECT SUBSTR('Hello World',3,3) from dual;
-는 뒤에서부터 카운팅, 뒤에서 3번째부터 끝까지 출력
SELECT SUBSTR('Hello World',-3) from dual;
뒤에서 3번째부터 2개의 문자열 추출
SELECT SUBSTR('Hello World',-3,2) from dual;

LENGHTH: 문자의 갯수를 반환
SELECT LENGTH('Hello World') FROM dual;
SELECT LENGTH(ename), LENGTH(job) FROM emp;

INSTR(대상문자열, 검색문자): 검색문자의 위치값(인덱스) 반환
SELECT INSTR('Hello World', 'e') FROM dual;
검색 문자가 없을 경우 0을 반환
SELECT INSTR('Hello World', 'u') FROM dual;
같은 검색문자가 있으면 처음껄 반환
SELECT INSTR('Hello World', 'o') FROM dual;
INSTR(대상문자열, 검색문자, 검색인덱스): 검색인덱스부터 검색
              1234567891011
SELECT INSTR('Hello World', 'o',6) FROM dual;
INSTR(대상문자열, 검색문자, 검색인덱스, 반복횟수) : 반복횟수만큼 검색
SELECT INSTR('Hello World', 'o',1,2) FROM dual;

LPAD(대상문자열, 총길이, 문자): 대상 문자열을 표시할 때 총 길이 범위내에서 표시. 대상 문자열을
                             표시하고 남은 공간이 왼쪽에 만들어지고 그 공간을 지정한 문자로 표시
SELECT LPAD('Hello', 10, '*') FROM dual;  

RPAD(대상문자열, 총길이, 문자): 대상 문자열을 표시할 때 총 길이 범위내에서 표시. 대상 문자열을
                             표시하고 남은 공간이 오른쪽에 만들어지고 그 공간을 지정한 문자로 표시
SELECT RPAD('Hello', 10, '*') FROM dual;

TRIM: 문자열에서 공백이나 특정 문자를 제거한 다음 값을 반환
방향: leading(왼쪽), trailing(오른쪽), both <-default
제거문자 from 대상문자 형식
SELECT TRIM(both 'h' from 'habchh') FROM dual;
SELECT TRIM(leading 'h' from 'hahbchh') FROM dual;

REPLACE(대상문자열,old,new): 대상문자열에서 old문자를 new문자로 대체
SELECT REPLACE('010.1234.5678', '.', '-') FROM dual;

함수 중첩
SELECt ename, LOWER(SUBSTR(ename, 1, 3)) FROM emp;

숫자 함수
CEIL(): 올림 처리한 정수값을 반환
SELECT CEIL(1.4) FROM dual;

ROUND(): 반올림
ROUND(대상숫자,지정자릿수): 지정 자릿수에서 반올림
SELECT ROUND(45.926,2) FROM dual;
지정자릿수를 지정하지 않으면 소수점 자리 없음. 즉, 정수로 만듦
SELECT ROUND(45.926) FROM dual;
SELECT empno, sal, ROUND(sal*1.15) "New Sallary", ROUND((sal*1.15)-sal) "Increase" FROM emp;

TRUNC(대상숫자, 지정자릿수): 숫자 절삭
SELECT TRUNC(45.926,2) FROM dual;
자릿수를 지정하지 않으면 소수점 없음
SELECT TRUNC(45.926) FROM dual;

MOD(대상숫자, 나눌숫자): 나머지 값을 반환
SELECT MOD(17,2) FROM dual;

날짜함수
오라클 데이터베이스는 내부 숫자 형식(세기,년,월,일,시,분,초)으로 날짜를 저장

SYSDATE: ORACLE 서버의 현재 날짜와 시간을 반환
SELECT SYSDATE FROM dual;

날짜에 산술 연산자 사용
              입사한 후 몇주 경과했는지
SELECT ename, ROUND((SYSDATE - hiredate)/7) AS WEEKS FROM emp
WHERE deptno=10;

MONTHS_BETWEEN(큰 날짜,작은 날짜): 두 날짜 간의 월 수
SELECT MONTHS_BETWEEN('2012-03-23','2009-01-23') FROM dual;

ADD_MONTHS: 특정 날짜의 월에 정수를 더한 다음 해당 날짜를 반환
SELECT ADD_MONTHS('2010-01-01', 8) FROM dual;

NEXT_DAY: 지정된 요일의 다음 날짜를 반환
SELECT NEXT_DAY('2017-09-25','월요일') FROM dual;
요일 대신 숫자1(일요일)~7(토요일)로 대체 가능
SELECT NEXT_DAY('2017-09-25',3) FROM dual;

LAST_DAY: 월의 마지막 날짜를 반환
SELECT LAST_DAY('2017-09-29') FROM dual;

ROUND: 두번째 파라미터로 지정된 값을 기준으로 첫번째 파라미터 날짜를 반올림
기준: 시간이 12시를 넘어서면 1을 증가시킴
SELECT ROUND(SYSDATE) FROM dual; 
SELECT ROUND(SYSDATE, 'DD') FROM dual; /*'DD' => 일*/
월은 16일 이상일 경우 올리고 그 이전 날짜의 경우 잘려나감
SELECT ROUND(SYSDATE, 'MONTH') FROM dual;
년도는 7월 1일 이상일 경우 올리고 그 이전 날짜의 경우 잘려나감
SELECT ROUND(SYSDATE, 'YEAR ') FROM dual;
분기는 3개월 단위이므로, 두번째 월의 16일 이상일 경우 올리고 그 이전 날짜의 경우 잘려나감
SELECT ROUND(SYSDATE, 'Q') FROM dual;
한 주가 시작되는 날짜로 반올림
SELECT ROUND(SYSDATE, 'DAY') FROM dual;

TRUNC: 절삭
SELECT TRUNC(SYSDATE) FROM dual;
SELECT TRUNC(SYSDATE, 'MONTH') FROM dual;
SELECT TRUNC(SYSDATE, 'YEAR') FROM dual;

EXTRACT: 날짜 정보에서 특정한 연도, 월, 일, 시, 분, 초 등을 추출
SELECT EXTRACT(YEAR FROM SYSDATE) FROM dual;
SELECT EXTRACT(MONTH FROM SYSDATE) FROM dual;
SELECT EXTRACT(DAY FROM SYSDATE) FROM dual;

[실습문제]
1. emp테이블의 업무(job)을 첫글자는 대문자 나머지는 소문자로 출력
2. emp테이블에서 사원이름 중 A가 포함된 사원이름을 구하고 그 이름 중 앞에서 3자만 추출하여
   출력
3. 이름의 세번째 문자가 A인 모든 사원의 이름을 표시
4. 이름이 J,A또는 M으로 시작하는 모든 사원의 이름(첫 글자는 대문자, 나머지는 소문자) 및 
   이름 길이 출력(열 이름은 name과 length)

1.
SELECT INITCAP(job) FROM emp;
2.
SELECT SUBSTR(ename,3) FROM emp
WHERE ename LIKE ('%A%');
3.
SELECT ename FROM emp
WHERE ename LIKE ('__A%');
또는
SELECT ename FROM emp
WHERE SUBSTR(ename,3,1)='A';

4.
SELECT INITCAP(ename) name, LENGTH(ename) length FROM emp
WHERE ename LIKE ('J%') OR ename LIKE ('A%') OR ename LIKE ('M%');
또는
SELECT INITCAP(ename) name, LENGTH(ename) length FROM emp
WHERE SUBSTR(ename,1,1) IN ('J','A','M');

5. 이름의 글자수가 6자 이상인 사원의 이름을 소문자로 이름만 출력
6. 이름의 글자수가 6자 이상인 사원의 이름을 앞에서 3자만 구하여 소문자로 출력
7. 모든 사원의 이름과 급여를 표시하는데 급여는 15자 길이로 왼쪽에 $기호가 채워진 형식으로 
   표기하고 열 레이블을 SALARY로 지정
8. 오늘부터 이번달의 마지막날까지의 남은 날 수를 구하시오
9. 각 사원에 대해 사원번호, 이름, 급여, 5%인상된 급여를 정수(반올림)로 표시하시오. 인상된
   급여열의 레이블을 New Salary로 지정

5.
SELECT LOWER(ename) FROM emp
WHERE LENGTH(ename) >= 6;
6.
SELECT LOWER(SUBSTR(ename,1,3)) FROM emp
WHERE LENGTH(ename) >= 6;
7.
SELECT ename, LPAD(sal,15,'$') SALARY FROM emp;
8.
SELECT LAST_DAY(SYSDATE)-SYSDATE from dual;
9.
SELECT empno, ename, sal, ROUND(sal*1.05) "New Salary" FROM emp;
또는
SELECT empno, ename, sal, TO_CHAR(sal*1.05, '9999') "New Salary" FROM emp;

변환함수
TO_NUMBER : 문자 -> 숫자
TO_CHAR : 숫자 -> 문자, 날짜 -> 문자
TO_DATE : 문자 -> 날짜

날짜 포맷팅
AD, A.D. : AD(기원후) 표시
AM,PM,A.M.,P.M. : 오전 오후 표시
BC, B.C. : BC(기원전) 표시
CC,SCC : 세기 표시(1999는 20세기, 2001은 21세기)
Y,YY,YYY,YYYY : 연도의 숫자값(각각 1,2,3,4 자리로 표현)
RR : 네 자리 연도 숫자 중 뒤의 두자리를 사용하여 앞의 두 자리 숫자를 반환.
     뒤의 두자리가 50보다 작을 때는 현재 세기가 그대로 사용되지만 50이상이면 1을 줄여 사용
MM : 월의 숫자식 표현(1~12)
DD : 월 내의 일을 숫자식으로 표현(1~31)
HH, HH12 : 시간(1~12) 표현
HH24 : 시간(0~23) 표현
MI : 분(0~59) 표현
SS : 초(0~59) 표현
Q : 분기(1,2,3,4) 1은 1월~3월, 2는 4~6월, 3은 7~9월, 4는 10~12월

숫자 포매팅
9 : 숫자를 주어진 자리수대로 반환(ex, TO_CHAR(111,999) -> 111출력)
0 : 빈자리에 0이 표시되도록 강제 적용
9,999 : 정해진 위치에 콤마를 넣어줌(ex, TO_CHAR(1234, '9,999') -> 1,234출력)
999.00 : 정해진 위치에 소수점을 넣어줌(ex. TO_CHAR(123, '999.99') -> 123.00)
$9999 : 숫자 앞에 달러 기호를 넣어줌


TO_CHAR : 숫자 -> 문자, 날짜 -> 문자
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM dual;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') FROM dual;
SELECT TO_CHAR(SYSDATE, 'DD-MON-RR HH:MI:SS') FROM dual;
SELECT TO_CHAR(hiredate, 'YY-MM-DD HH24:MI:SS') FROM emp;

SELECT TO_CHAR(1234, 9999) FROM dual;
SELECT TO_CHAR(1234, '9999') FROM dual;
또는
SELECT TO_CHAR(1234, '0000') FROM dual;

자리수가 모자랄 경우 -> #### 출력
SELECT TO_CHAR(1234, 999) FROM dual;
SELECT TO_CHAR(1234, '999') FROM dual;
SELECT TO_CHAR(1234, '000') FROM dual;

실제 자리수보다 많은 자리수를 지정할 경우
SELECT TO_CHAR(1234, 999999) FROM dual;
SELECT TO_CHAR(1234, '999999') FROM dual;
SELECT TO_CHAR(1234, '000000') FROM dual;

소수점 자리
SELECT TO_CHAR(1234, '0000.00') FROM dual;
SELECT TO_CHAR(1234, '9999.99') FROM dual;
반올림해서 소수점 둘째자리까지 표시
SELECT TO_CHAR(25.897, '99.99') FROM dual;
SELECT TO_CHAR(sal*1.15, '9,999.9') FROM emp;

통화 표시
SELECT TO_CHAR(1234,'$0000') FROM dual;
지역통화 표시
SELECT TO_CHAR(1234,'L0000') FROM dual;

[실습문제]
1. emp 테이블에서 월급이 4의 배수인 사원의 이름과 월급을 출력하시오. (세자리 단위 쉼표 표시)
2. 각 사원의 이름을 표시하고 근무 달 수(입사일로부터 현재까지의 달 수)를 계산하여
   열 레이블을 MONTHS_WORKED로 지정하시오. 결과는 정수로 반올림하여 표시하고 근무 달 수를
   기준으로 오름차순으로 정렬하시오.
3. emp 테이블에서 이름(소문자로 표시), 업무, 근무연차를 출력

1.
SELECT ename, TO_CHAR(sal,'9,999') FROM emp
WHERE MOD(sal,4)=0;
2.
SELECT ename, ROUND(MONTHS_BETWEEN(SYSDATE, hiredate)) "MONTHS_WORKED" FROM emp
ORDER BY MONTHS_WORKED ASC;
또는
SELECT ename, TO_CHAR(MONTHS_BETWEEN(SYSDATE, hiredate), 999) "MONTHS_WORKED" FROM emp
ORDER BY MONTHS_WORKED ASC;
3.
SELECT LOWER(ename), job, ROUND(MONTHS_BETWEEN(SYSDATE, hiredate)/12) "YEAR" FROM emp;

-TO_DATE: 숫자 -> 문자
SELECT TO_DATE('2017-10-10','YYYY-MM-DD') FROM dual;
SELECT TO_DATE('17-10-10','DD-MM-RR') FROM dual;

-TO_NUMBER : 문자 -> 숫자
SELECT TO_NUMBER('100','999') FROM dual;
SELECT TO_NUMBER('100','000') FROM dual;
포맷형식 생략 가능
SELECT TO_NUMBER('100') FROM dual;

일반함수
NVL(value1,value2) : value1이 null이면 value2를 사용.
                     value1과 value2의 자료형이 일치.
                     
SELECT ename, sal, NVL(comm,0), NVL(comm,0)*12 FROM emp;

value1과 value2의 자료형을 일치시키기
SELECT ename, NVL(TO_CHAR(comm),'NO Commision') FROM emp;
SELECT ename, sal+NVL(comm,0) 실급여 FROM emp;

NVL2(value1, value2, value3) : value1이 null인지 평가. null이면 value3,
                               null이 아니면 value2 사용
                               자료형이 일치하지 않아도 됨
SELECT ename, NVL2(comm, 'commision', 'no commision') FROM emp;
[주의]
SELECT NVL2(comm, sal, comm) FROM emp;
SELECT ename, NVL2(comm, 'commision', 'no commision') FROM emp;
★ value1과 value2의 데이터타입은 같아야함
SELECT NVL2(comm, comm, 'no commision') FROM emp;
SELECT NVL2(comm, TO_CHAR(comm), 'no commision') FROM emp;
SELECT NVL2(comm, 'commision', 0) FROM emp;

NULLIF(value1, value2) : 두개의 값이 일치하면 NULL. 
                         두개의 값이 일치하지 않으면 value1 사용
SELECT NULLIF(LENGTH(ename), LENGTH(job)) "NULLIF" FROM emp;

COALESCE(value1, value2, value3, ...) : null값이 아닌 것을 사용(자료형 일치)
SELECT comm, sal, COALESCE(comm, sal, 0) FROM emp;
SELECT comm, mgr, sal, COALESCE(comm, mgr, sal) FROM emp;

- ANSI 표준(자바의 if문과 비슷)
CASE 컬럼 WHEN 비교값 THEN 결과값
          WHEN       THEN
          WHEN       THEN
          (ELSE 결과값)
END

SELECT ename, sal, job,
    CASE job WHEN 'SALESMAN' THEN sal*0.1
             WHEN 'MANAGER' THEN sal*0.2
             WHEN 'ANALYST' THEN sal*0.3
             ELSE sal*0.4
    END "bonus"
FROM emp;

SELECT ename, sal, job,
        CASE WHEN sal>=4000 AND sal<=5000 THEN 'A'
             WHEN sal>=3000 AND sal<4000 THEN 'B'
             WHEN sal>=2000 AND sal<3000 THEN 'C'
             WHEN sal>=1000 AND sal<2000 THEN 'D'
             ELSE 'F'
        END "Grade"
FROM emp ORDER BY "Grade", sal DESC;

- 오라클 전용
DECODE : = 비교만 가능(자바의 switch문과 비슷)
DECODE(컬럼명,비교값,반환값,
             비교값,반환값,
             비교값,반환값,
             반환값)
             
SELECT ename, sal, job,
        DECODE(job, 'SALESMAN', sal*0.1,
                    'MANAGER', sal*0.2,
                    'ANALYST', sal*0.3,
                    sal*0.4) "Bonus"
FROM emp;

SELECT ename, sal, job,
        DECODE(TRUNC(sal/1000), 5, 'A',
                                4, 'A',
                                3, 'B',
                                2, 'C',
                                1, 'D',
                                'F') "Grade"
FROM emp ORDER BY "Grade", sal DESC;

[실습문제]
1. emp테이블에서 사원이름, 월급, 월급과 커미션을 더한 값을 컬럼명 실급여라고 해서 출력하시오.
 단, null값은 나타나지 않게 작성하시오.
2. 월급과 커미션을 합친 금액이 2,000이상인 급여를 받는 사원의 이름, 업무, 월급, 커미션, 고용날짜를 출력
 단, 고용날짜는 1980-12-17형식으로 출력
3. job 열의 값을 기준으로 모든 사원의 등급을 표시하시오.(DECODE, CASE 둘 다 한번씩 사용)
 업무         등급
 PRESIDENT     A
 ANALYST       B
 MANAGER       C
 SALESMAN      D
 CLERK         E
 기타           0

1.
SELECT ename, sal, sal+NVL(comm,0) 실급여 FROM emp;
2.
SELECT ename, job, sal, comm, TO_CHAR(hiredate, 'YYYY-MM-DD') FROM emp
WHERE sal+NVL(comm,0) >= 2000;
3.
SELECT ename, job,
        DECODE(job, 'PRESIDENT', 'A',
                    'ANALYST', 'B',
                    'MANAGER', 'C',
                    'SALESMAN', 'D',
                    'CLERK', 'E',
                    0) "Grade"
FROM emp;

SELECT ename, job,
        CASE job WHEN 'PRESIDENT' THEN 'A'
                 WHEN 'ANALYST' THEN 'B'
                 WHEN 'MANAGER' THEN 'C'
                 WHEN 'SALESMAN' THEN 'D'
                 WHEN 'CLERK' THEN 'E'
                 ELSE TO_CHAR(0)
        END "Grade"
FROM emp;

그룹함수 : 행 집합 연산을 수행하여 그룹별로 하나의 결과를 산출
AVG() : null을 제외한 모든 값들의 평균을 반환. null값은 평균계산에서 무시됨

SELECT ROUND(AVG(sal)) FROM emp;

COUNT() : null을 제외한 값을 가진 모든 레코드의 수를 반환
          COUNT(*)형식을 사용하면 null도 계산에 포함.
emp테이블의 총 레코드 수
SELECT COUNT(*) FROM emp;
커미션 계약을 한 사원의 수
SELECT COUNT(comm) FROM emp;

MAX() : 레코드 내에 있는 여러 값 중 가장 큰 값을 반환
SELECT MAX(sal) FROM emp;
SELECT MAX(ename) FROM emp;

SUM() : 레코드들이 포함하고 있는 모든 값을 더하여 반환
SELECT SUM(sal) FROM emp;

SELECT MAX(sal), MIN(sal), ROUND(AVG(sal)), SUM(sal) FROM emp;

SELECT MAX(sal), MIN(sal), ROUND(AVG(sal)), SUM(sal) FROM emp
WHERE deptno=10;

20번 부서에서 근무하는 사원의 수
SELECT COUNT(*) FROM emp
WHERE deptno=20;
SELECT COUNT(NVL(comm,0)) FROM emp
WHERE deptno=20;
┌> PRIMARAY KEY 이용 
SELECT COUNT(empno) FROM emp
WHERE deptno=20;

20번 부서에서 커미션 계약이 된 사원의 수(null값은 제외)
SELECT COUNT(comm) FROM emp
WHERE deptno = 30;

GROUP BY : SELECT절에 집합함수 적용시 개별 컬럼을 지정할 수 없음.
           개별 컬럼을 지정할 경우에는 반드시 GROUP BY절에 지정된 컬럼만 가능.
부서별 최고 급여
SELECT deptno, MAX(sal) FROM emp
GROUP BY deptno;
부서별 급여 합계와 평균 급여
SELECT deptno, ROUND(AVG(sal)) 평균, SUM(sal) 합계 FROM emp
GROUP BY deptno;

부서별, 직업별 급여 합계
SELECT deptno, job, SUM(sal) FROM emp
GROUP BY deptno, job;   

부섭별, 직업별 급여 합계, 급여 평균

SELECT deptno, job, SUM(sal) 합계, ROUND(AVG(sal)) 평균 FROM emp
GROUP BY deptno, job;   

[오류]
SELECT deptno, COUNT(ename) FROM emp;
[수정]
SELECT deptno, COUNT(ename) FROM emp
GROUP BY deptno;

[오류] WHERE절에는 그룹함수 사용 불가 -> HAVING 절에 사용해야 됨
SELECT deptno, ROUND(AVG(sal)) FROM emp
WHERE ROUND(AVG(sal)) >= 2000 
GROUP BY deptno;
[수정]
부서별 평균 급여를 구하는 데 평균 급여가 2000이상인 데이터를 구함
SELECT deptno, ROUND(AVG(sal)) FROM emp
GROUP BY deptno
HAVING ROUND(AVG(sal)) >= 2000;

HAVING : 그룹 처리 결과를 제한하고자 할 때 HAVING절 사용
         WHERE절에는 그룹함수를 사용할 수 없는 것을 해소
         
부서별 최고 급여를 구하는데 최고 급여가 2000을 초과한 데이터를 구함
SELECT deptno, MAX(sal) FROM emp
GROUP BY deptno
HAVING MAX(sal) > 2000;

그룹함수 중첩
[오류]            ↓ 그룹함수 중첩됨  
SELECT deptno, MAX(AVG(sal)) FROM emp
GROUP BY deptno;
[수정]
SELECT MAX(AVG(sal)) FROM emp
GROUP BY deptno;

[실습문제]
1. 모든 사원의 급여 최고액, 최저액, 총액 및 평균을 표시하시오.
    열 레이블을 각각 maximum, minimum, sum average로 지정하고 결과를 정수로
    반올림하고 세자리 단위로 쉼표(,)를 명시하시오.
2. 업무(job)가 동일한 사원 수를 표시하시오.
3. emp 테이블에서 30번 부서의 사원수를 구하시오.
4. emp 테이블에서 업무별 최고 월급을 구하고 업무, 최고월급을 출력하시오.

1.
SELECT TO_CHAR(MAX(sal),'9,999') 최고액, 
       TO_CHAR(MIN(sal),'9,999') 최저액, 
       TO_CHAR(SUM(sal),'99,999') 총액, 
       TO_CHAR(ROUND(AVG(sal)), '9,999') 평균 
FROM emp;
2.
SELECT job, COUNT(*) FROM emp
GROUP BY job;
3.
SELECT COUNT(*) FROM emp
WHERE deptno = 30;
4.
SELECT job, MAX(sal) FROM emp
GROUP BY job;

5. emp 테이블에서 20번 부서의 급여 합계를 구하고 급여 합계 금액을 출력
6. emp 테이블에서 부서별로 지급되는 총 월급에서 금액이 7,000 이상인 부서번호, 총 월급을 출력
7. emp 테이블에서 업무별로 사번이 제일 늦은 사람을 구하고 그 결과 내에서 사번 79로 시작하는
   결과만 출력
8. emp 테이블에서 업무별로 총 월급을 출력하는데 업무가 'MANAGER'인 사원은 제외하고 총 월급이
   5,000 보다 큰 업무와 총 월급만 출력

5.
SELECT SUM(sal) FROM emp
WHERE deptno = 20;
6.
SELECT deptno, SUM(sal) FROM emp
GROUP BY deptno
HAVING SUM(sal) >= 7000;
7.
SELECT job, MAX(empno) FROM emp
WHERE empno LIKE '79%'
GROUP BY job;
8.
SELECT job, SUM(sal) FROM emp
WHERE job NOT IN ('MANAGER')
GROUP BY job
HAVING SUM(sal) >5000;

JOIN : 둘 이상의 테이블을 연결하여 데이터를 검색하는 방법
       보통, 둘 이상의 행들의 공통된 값 Primary Key 및 Foreign Key 값을 사용하여 조인
       두 개의 테이블의 SELECT절 안에서 조인하려면 적어도 하나의 컬럼이 그 두 테이블 사이에서 공유 되어야 함.

Cartesian Product(카티션 곱): 검색하고자 했던 데이터 뿐만 아니라 조인에 사용된 테이블들의 모든 데이터가
                             반환되는 현상     
SELECT * FROM emp, dept;

JOIN 방법
[ORACLE 전용]
-동등 조인(Equi Join) : 조건절 Equality Condition(=)에 의하여 조인
SELECT e.ename, d.deptno
FROM emp e, dept d
WHERE e.deptno = d.deptno;

추가적인 조건을 명시하는 경우
SELECT e.ename, d.deptno
FROM emp e, dept d
WHERE e.deptno = d.deptno /*조인 조건*/
AND e.ename = 'ALLEN'; /*부가 조건*/

SELECT e.ename, e.sal, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno /*조인 조건*/
AND e.sal BETWEEN 3000 AND 4000; /*부가 조건*/

-비동등 조인(non equi join)
테이블의 어떤 column도 join할 테이블의 column에 일치하지 않을 때 사용하고
조인 조건은 동등(=)이외의 연산자를 사용함(between and, is null, in not null, in, not in) 등

사원이름, 급여, 급여등급 구하기(emp, salgrade 테이블을 이용)
SELECT e.ename, e.sal, s.grade
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal;

-Self Join : 조인하는 두 개의 테이블이 동일한 테이블인 경우

사원 이름과 해당 사원의 관리자 이름 구하기(관리자가 없는 사원 제외)
SELECT a.ename 사원이름, m.ename 관리자이름
FROM emp a, emp m
WHERE a.mgr = m.empno;

-Outer Join
equi join 문장들의 한 가지 제약점은 그것들이 조인을 생성하려 하는 두 개의 테이블의
두 개 컬럼에서 공통된 값이 없다면 테이블로부터 데이터를 반환하지 않는다는 것.
정상적으로 조인 조건을 만족하지 못 하는 행들을 보기 위해 outer join 사용

누락된 행의 반대 테이블에 (+)기호 표시
SELECT DISTINCT(e.deptno), d.deptno
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;

사원이름과 해당 사원의 관리자 이름 구하기(관리자가 없는 사원도 표시)
SELECT a.ename 사원이름, m.ename 관리자이름
FROM emp a, emp m
WHERE a.mgr = m.empno(+);

[실습문제]
1. 모든 사원의 이름, 부서번호, 부서이름을 표시하시오.(emp, dept)
2. 업무가 'MANAGER'인 사원의 정보를 이름, 업무, 부서명, 근무지 순으로 출력(emp, dept)
3. 커미션을 받고 급여가 1,600이상인 사원의 사원이름, 부서명, 근무지를 출력
4. 근무지가 CHICAGO인 모든 사원의 이름, 업무, 부서번호 및 부서이름을 표시

1.
SELECT e.ename, e.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;
2.
SELECT e.ename, e.job, d.dname, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno;
3.
SELECT e.ename, e.deptno, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND e.comm IS NOT NULL
AND e.sal >= 1600;
4.
SELECT e.ename, e.job, e.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND d.loc = 'CHICAGO';

5. 근무지(loc)별로 근무하는 사원의 수가 5명 이하인 경우, 인원이 적은 도시 순으로 정렬하시오
    (근무 인원이 0명인 곳도 표시)
6. 사원의 이름 및 사원 번호를 관리자의 이름과 관리자 번호와 함께 표시하고 각각의 열레이블은 employ, 
   emp#, manager, mgr#로 지정하시오.(관리자가 없는 사원은 제외)
7. 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자의 이름 및 입사일과 함께 표시하고
   열레이블을 employee, emp hired, manager, mgr hired로 지정하시오.

5.
SELECT d.loc, COUNT(e.empno) emp_member
FROM emp e,dept d
WHERE e.deptno(+) = d.deptno
GROUP BY d.loc
HAVING COUNT(d.loc) <= 5
ORDER BY COUNT(d.loc) ASC;
6.
SELECT a.ename "employee", a.empno "emp#", m.ename "manager", m.empno "mgr#"
FROM emp a, emp m
WHERE a.mgr = m.empno;
7. 
SELECT a.ename "employee", a.hiredate "emp hired", m.ename "manager", m.hiredate "mgr hired"
FROM emp a, emp m
WHERE a.mgr = m.empno
AND a.hiredate < m.hiredate;

[표준 SQL]
-내부 조인(inner join)
inner join이라고 명시해도 되고 join만 명시해도 됨

SELECT emp.ename, dept.deptno
FROM emp INNER JOIN dept /*조인할 테이블 명시*/
ON emp.deptno = dept.deptno; /*조인 조건*/

부가적인 조건이 있으면 WHERE절 사용
SELECT emp.ename, dept.deptno
FROM emp INNER JOIN dept
ON emp.deptno = dept.deptno
WHERE emp.ename = 'ALLEN';

테이블 알리아스 사용
SELECT e.ename, d.deptno
FROM emp e INNER JOIN dept d
ON e.deptno = d.deptno
WHERE e.ename = 'ALLEN';

만약 조인 조건에 사용된 컬럼의 이름이 같다면 다음과 같이 using절을 사용하여 
조인 조건을 정의할 수 있음
[주의]USING에 사용된 컬럼은 테이블명 또는 테이블 알리아스를 붙이지 않음
아래 SQL문장에서 d.deptno로 명시하면 오류 발생
SELECT e.ename, d.dname, deptno
FROM emp e JOIN dept d
USING(deptno)
WHERE e.ename = 'ALLEN';

SELECT ename, dname, deptno
FROM emp e JOIN dept d
USING(deptno)
WHERE e.ename = 'ALLEN';

-Self Join
사원이름과 해당 사원의 관리자 이름 구하기(관리자 없는 사원은 제외)
SELECT e.ename name, m.ename manager_name
FROM emp e JOIN emp m
ON e.mgr = m.empno;

사원이름과 해당 사원의 관리자 이름 구하기(관리자 없는 사원도 포함)
SELECT e.ename name, m.ename manager_name
FROM emp e LEFT JOIN emp m
ON e.mgr = m.empno;

[실습문제]
1. 모든 사원의 이름, 부서번호, 부서이름을 표시하시오(emp, dept)
2. 업무가 'MANAGER'인 사원의 정보를 이름, 업무, 부서명, 근무지 순으로 출력(emp,dept)
3. 근무지가 'CHICAGO'인 모든 사원의 이름, 업무, 부서번호 및 부서이름을 표시
4. 근무지(loc)별로 근무하는 사원의 수가 5명 이하인 경우, 인원이 적은 도시 순으로 정렬하여 출력
    (근무 인원이 0명 인것도 표시);
    
1.
SELECT e.ename, e.deptno, d.dname
FROM emp e JOIN dept d
ON e.deptno = d.deptno;
2.
SELECT e.ename, e.job, d.dname, d.loc
FROM emp e JOIN dept d
ON e.deptno = d.deptno
WHERE e.job = 'MANAGER';
3.
SELECT e.ename, e.job, e.deptno, d.dname
FROM emp e JOIN dept d
ON e.deptno = d.deptno
WHERE d.loc = 'CHICAGO';
4.
SELECT loc, COUNT(ename)
FROM emp e RIGHT JOIN dept d
USING(deptno)
GROUP BY loc
HAVING COUNT(loc) <=5
ORDER BY loc ASC;

5. 10번 부서에서 근무하는 사원들의 부서번호, 부서이름, 사원이름, 월급, 급여등급을 출력(emp, dept, salgrade)
[오라클 전용]
SELECT e.deptno, d.dname, e.ename, e.sal, s.grade
FROM emp e, dept d, salgrade s /*세 개의 테이블 조인*/
WHERE e.deptno = d.deptno /*emp와 dept의 조인 조건*/
AND e.sal BETWEEN s.losal AND s.hisal /*emp와 salgrade 조인 조건*/
AND e.deptno = 10;

[표준 SQL]
SELECT e.deptno, d.dname, e.ename, e.sal, s.grade
FROM emp e INNER JOIN dept d /*두개의 테이블 조인*/
ON e.deptno=d.deptno /*emp와 dept의 조인조건*/
INNER JOIN salgrade s /*세번째 테이블 조인*/
ON e.sal BETWEEN s.losal AND s.hisal /*emp와 salgrade의 조인조건*/
WHERE e.deptno=10;

집합연산자
- UNION : 합집합, 중복값 제거
SELECT ename, deptno FROM emp
UNION
SELECT dname, deptno FROM dept;

- UNION ALL : 합집합, 중복된 값까지 반환
SELECT deptno FROM emp
UNION ALL
SELECT deptno FROM dept;

- INTERSECT : 교집합, 두 행의 집합 중 공통된 행을 반환
SELECT deptno FROM emp
INTERSECT
SELECT deptno FROM dept;

- MINUS : 차집합, 첫번째 SELECT문에 의해 반환되는 행 중에서 두 번째 SELECT문에 의해
          반환되는 행에 존재하지 않는 행들을 보여줌
SELECT deptno FROM dept
MINUS
SELECT deptno FROM emp;

Subquery : 다른 한의 SQL문장의 절에 nested된 SELECT 문장
-단일행 서브쿼리 : 오직 한개의 행(값)을 반환
SELECT empno, ename, job FROM emp 
WHERE job = (SELECT job FROM emp
                WHERE empno=7369);

SELECT ename, sal FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'BLAKE');

-다중행 서브쿼리 : 하나 이상의 행을 반환하는 서브쿼리
IN 연산자의 사용
SELECT empno, ename, sal FROM emp
WHERE sal IN (SELECT MIN(sal) FROM emp GROUP BY deptno);

ANY 연산자의 사용
ANY 연산자 : 서브쿼리의 결과값 중 어느 하나의 값이라도 만족이 되면 결과값을 반환
SELECT ename, sal FROM emp
WHERE sal > ANY(SELECT sal FROM emp WHERE job = 'SALESMAN');

[실습문제]
1. 'BLAKE'와 같은 부서에 있는 사원들의 이름과 입사일을 구하는데 'BLAKE'는 제외하고 출력
    (BLAKE가 여러명일 수 있음 -> 다중행이라는 뜻임);
SELECT ename, hiredate FROM emp
WHERE deptno IN (SELECT deptno FROM emp 
                 WHERE ename = 'BLAKE');

2. 평균급여보다 많은 급여를 받는 사원들의 사원번호, 이름, 월급을 출력하는데 월급이 높은 사람 순으로 출력
SELECT empno, ename, sal FROM emp
WHERE sal > (SELECT AVG(sal) FROM emp)
ORDER BY sal DESC;

3. 10번 부서에서 급여를 가장 적게 받는 사원과 동일한 급여를 받는 사원의 이름을 출력
SELECT ename FROM emp
WHERE sal = (SELECT MIN(sal) FROM emp
             WHERE deptno =10);

4. 사원수가 3명이 넘는 부서의 부서명과 사원수를 출력
SELECT d.dname, COUNT(e.deptno) cnt
FROM emp e, dept d
WHERE e.deptno = d.deptno
GROUP BY d.dname
HAVING COUNT(e.deptno) > 3;

SELECT d.dname, b.cnt
FROM dept d, (SELECT deptno, COUNT(empno) cnt FROM emp GROUP BY deptno) b
WHERE d.deptno = b.deptno
AND b.cnt > 3;


5. 사원번호가 7844인 사원보다 빨리 입사한 사원의 이름과 입사일을 출력
SELECT ename, hiredate FROM emp
WHERE hiredate < (SELECT hiredate FROM emp
                WHERE empno = 7844);

6. 관리자(mgr)가 KING인 모든 사원의 이름과 급여를 출력
SELECT ename, sal FROM emp
WHERE mgr = (SELECT empno FROM emp
            WHERE ename = 'KING');
            
7. 20번부서에서 가장 급여를 많이 받는 사원과 동일한 급여를 받는 사원의 이름, 부서명, 급여, 급여등급을 출력
SELECT e.ename, e.sal, d.dname, s.grade 
FROM emp e, dept d, salgrade s
WHERE e.deptno = d.deptno
AND e.sal BETWEEN s.losal AND s.hisal
AND sal = (SELECT MAX(sal) FROM emp
            WHERE deptno=20);

[표준SQL]
SELECT e.ename, d.dname, e.sal, s.grade
FROM emp e JOIN dept d
ON e.deptno = d.deptno
JOIN salgrade s
ON e.sal BETWEEN s.losal AND s.hisal
WHERE sal = (SELECT MAX(sal) FROM emp
             WHERE deptno=20);



INSERT문 : 테이블에 행을 삽입
형식: INSERT INTO 테이블명 (컬럼명, ...) VALUES (값, ...)

전체 데이터 삽입
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno)
VALUES (8000,'DENNIS', 'SALESMAN', 7693, '99/01/21', 1700, 200, 30);

전체 데이터를 명시할 때는 컬럼명 생략 가능
INSERT INTO emp
VALUES (8003,'SUNNY','SALESMAN',7698,'99/03/01',1000,300,30);

[null 삽입 방법]
-입력하지 않는 컬럼은 제외하고 Insert하는 경우
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,deptno)
VALUES (8001,'PETER', 'CLERK', 7698, '99/01/22', 1800,10);

-값이 입력되지 않는 컬럼을 제외하지 않았을 경우
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno)
VALUES (8002,'ANNIE','CLERK',7698,'99/02/21',1600,null,20);

[날짜 삽입]
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno)
VALUES (8004,'MICHAEL','SALESMAN',7698,TO_DATE('2017/10/11','YYYY/MM/DD'),1800,100,30);

UPDATE문 : 행단위로 데이터 갱신
형식 : UPDATE 테이블명 SET 컬럼명 = 데이터, ... WHERE 조건

UPDATE emp SET mgr = 7698 WHERE empno=8000;
UPDATE emp SET ename='MARIA', sal=2500, comm=500 WHERE empno=8000;

UPDATE emp 
SET job = (SELECT job FROM emp WHERE empno=7902),
    sal = (SELECT sal FROM emp WHERE empno=7782)
WHERE empno=8001;

[주의]UPDATE문에서 WHERE절을 명시하지 않으면 전체행의 데이터를 변경함
UPDATE emp SET ename='DENNIS';

ROLLBACK;

DELETE문: 행을 삭제
형식: DELETE FROM 테이블명 WHERE 조건

DELETE FROM emp WHERE empno=7369;
[주의]WHERE절을 명시하지 않으면 전체행이 삭제됨
DELETE FROM emp;
ROLLBACK;

-MERGE문 : 데이터베이스 테이블에서 조건에 따라 데이터를 갱신하거나 삽입하는 기능을 제공
           해당 행이 존재하는 경우 UPDATE를 수행하고, 새로운 행일 경우 INSERT를 수행
[형식]
MERGE INTO table_name <-저장될 테이블
USING (table|view|sub_query) <- 제공하는 데이터
ON (join condition) <- join조건문
WHEN MATCHED THEN
 UPDATE SET
  column1 = column1_value,
  column2 = column1_value
WHEN NOT MATCHED THEN
 INSERT (column_list)
 VALUES (column_values)
 
행 병합
copy_emp 테이블에서 행을 삽입 또는 갱신하여 emp 테이블과 일치시키는 작업
 [copy_emp] 테이블 생성
 CREATE TABLE copy_emp(
  empno NUMBER(4),
  ename VARCHAR2(10),
  job VARCHAR2(9),
  mgr NUMBER(4),
  hiredate DATE,
  sal NUMBER(7,2),
  comm NUMBER(7,2),
  deptno NUMBER(2),
  constraint copy_pk_empno PRIMARY KEY(empno),
  constraint copy_fk_deptno FOREIGN KEY(deptno) REFERENCES dept(deptno)
  );

MERGE문을 이용해서 emp테이블의 데이터를 copy_emp에 저장
MERGE INTO copy_emp c
USING emp e
ON (c.empno = e.empno)
WHEN MATCHED THEN
 UPDATE SET
  c.ename = e.ename,
  c.job = e.job,
  c.mgr = e.mgr,
  c.hiredate = e.hiredate,
  c.sal = e.sal,
  c.comm = e.comm,
  c.deptno = e.deptno
WHEN NOT MATCHED THEN
 INSERT
 VALUES (e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno);

MERGE문의 활용
 - 데이터를 삽입하려할 때 기존에 존재하는 데이터가 있으면 UPDATE하도록 응용
MERGE INTO emp c /*데이터가 저장되는 테이블*/
USING (SELECT 8000 empno, 'DENNIS' ename, 'SALESMAN' job, 7698 mgr, 
              '99/01/23' hiredate, 1700 sal, 200 comm, 30 deptno 
       FROM dual) e /*테이블에 저장될 데이터를 컬럼과 매칭하여 dual을 이용해 명시함*/
ON (c.empno = e.empno) /*UPDATE, INSERT할 조건*/
WHEN MATCHED THEN /*empno가 존재하지 않으면 INSERT*/
 UPDATE SET
  c.ename = e.ename,
  c.job = e.job,
  c.mgr = e.mgr,
  c.hiredate = e.hiredate,
  c.sal = e.sal,
  c.comm = e.comm,
  c.deptno = e.deptno
WHEN NOT MATCHED THEN
 INSERT
 VALUES (e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno);
 
 - 중복되는 데이터가 있을 때 delete하는 기능은 10g부터 지원



SELECT * FROM emp;

[트랜잭션]
트랜잭션은 데이터 처리의 한 단위
오라클 서버에서 발생하는 SQL문들을 하나의 논리적인 작업단위로 구성
DML문장으로 구성됨

1) 트랜잭션의 시작 : SQL문장이 제일 처음 실행도리 때
2) 트랜잭션의 끝 : COMMIT이나 ROLLBACK
                 DDL, DCL문장을 실행(자동 COMMIT)
                 기계장애 또는 시스템 충돌, deadlock발생시
                 사용자가 정상 종료시
3) 자동 COMMIT은 다음의 경우에 발생
 - DDL, DCL문장이 완료될 때
 - 명시적으로 COMMIT이나 ROLLBACK 없이 SQL*PLUS를 정상 종료했을 경우
4) 자동 ROLLBACK은 다음의 경우에 발생
 - SQL*PLUS를 비정상 종료했을 경우
 - 비정상적인 종료시
 - System failure시

COMMIT과 ROLLBACK의 장점
 - 데이터의 일관성을 제공
 - 데이터를 영구적으로 변경하기 전에 데이터 변경을 확인하게 함

데이터베이스 객체
 - 테이블, 뷰, 시퀀스, 인덱스, 동의어
 
테이블의 생성, 수정 및 삭제
테이블 : 기본적으로 데이터 저장 단위, 레코드와 컬럼으로 구성

오라클 데이터베이스의 테이블
 1) 데이터 딕셔너리: 오라클 서버가 생성 및 유지 관리하는 테이블의 collection(집합)
                데이터베이스 정보를 포함하고 있음
  - 사용자가 소유한 테이블의 이름
SELECT table_name FROM user_tables;
  - 사용자가 소유한 개별 객체 유형
SELECT DISTINCT object_type FROM user_objects;
  - 사용자가 소유한 테이블, 뷰, 동의어 및 시퀀스
SELECT * FROM user_catalog;

 2) 사용자 테이블
  사용자가 생성 및 유지 관리하는 테이블의 collection
  사용자 정보를 포함
  
테이블 생성
CREATE TABLE employee(
 empno number(6),
 name varchar2(20) NOT NULL,
 salary number(8,2),
 hire_date date default sysdate,
 constraint employee_pk_empno PRIMARY KEY (empno)
);

컬럼의 구조에 대한 상세정보를 조회
DESCRIBE(or DESC) 테이블명;
DESCRIBE employee;
DESC employee;

테이블에 데이터 삽입
INSERT INTO employee (empno,name,salary)
VALUES (1000,'홍길동',100.56);
트랜잭션 끝에서 데이터를 확정
COMMIT;


DELETE FROM dept WHERE deptno=10;
-> deptno가 foreign키여서 삭제불가능

- primary key & foreign key
 CREATE TABLE suser(
  id varchar2(20),
  name varchar2(20),
  CONSTRAINT susper_pk_id PRIMARY KEY (id)
 );

INSERT INTO suser (id, name)
VALUES ('dragon', '홍길동');

CREATE TABLE sboard(
 num number,
 id varchar2(20) NOT NULL,
 content varchar2(4000) NOT NULL,
 CONSTRAINT sboard_pk_num PRIMARY KEY (num),
 CONSTRAINT sboard_suser_fk1 FOREIGN KEY(id) REFERENCES suser(id)
);
INSERT INTO sboard (num,id,content)
VALUES (1,'dragon','first content');

COMMIT;

DELETE FROM suer WHERE id='dragon';
 -> foreign key 제약 조건때문에 suser에서 id가 dragon인 행을 삭제할 수 없음

테이블의 관리
ADD 연산자 : 테이블에 새로운 컬럼을 추가
ALTER TABLE employee ADD(addr varchar2(50));

MODIFY 연산자 : 테이블의 컬럼을 수정하거나 NOT NULL 컬럼으로 변경할 수 있음
ALTER TABLE employee MODIFY(salary number(10,2) NOT NULL);

DROP 연산자 : 컬럼의 삭제
ALTER TABLE employee DROP column name;

테이블명 변경
RENAME employee TO employee2;

테이블 삭제
DROP TABLE employee2;

SELECT * FROM employee;
SELECT * FROM sboard;
ROLLBACK;


뷰(View)
- 데이터 액세스를 제한하기 위해
- View를 활용해서 공개를 원하지 않는 정보는 제외할 수 있음
- 복잡한 질의를 쉽게 작성할 수 있음
- 데이터의 독립성을 제공하기 위해서 사용

-사용중인 계정에 권한이 없어서 View가 생성되지 않을 경우 권한 부여하기
>sqlplus system/비밀번호
SQL>conn /as sysdba
SQL>grant create view to SCOTT; <- 사용중인 계정
 
-View 생성
create[or replace] view 뷰이름 as 쿼리;

CREATE OR REPLACE VIEW emp10_view
as SELECT empno id_number, ename name, sal*12 ann_salary
   FROM emp
   WHERE deptno=10;

SELECT * FROM emp10_view;

CREATE OR REPLACE VIEW emp_info_view AS
SELECT e.empno, e.ename, d.deptno, d.loc, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;

SELECT * FROM emp_info_view;

DESC emp10_view;
DESC emp_info_view;

- View의 수정
CREATE OR REPLACE VIEW emp10_view(id_number, name, sal, department_id) AS
SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno = 10;
[참고] CREATE VIEW절에서 열 별칭을 지정하는 경우 서브ㅝ리의 열가 동일한 순서로 나열해야 함

- View 삭제
DROP VIEW emp10_view;

시퀀스(Sequence)
유일한 값을 생성해주는 오라클 객체
시퀀스를 생성하면 기본키와 같이 순차적으로 증가하는 컬럼을 자동적으로
생성할 수 있음.
보통 primary key값을 생성하기 위해 사용

-시퀀스 생성
CREATE SEQUENCE test_seq
start with 1
increment by 1
maxvalue 100000;

currval : 현재 값을 반환
nextval : 현재 시퀀스값의 다음 값을 반환

SELECT test_seq.nextval FROM dual;
SELECT test_seq.currval FROM dual;

-시퀀스 수정
[참고] start with는 수정할 수 없음
ALTER SEQUENCE test_seq
increment by 2;

-시퀀스 삭제
DROP SEQUENCE test_seq;

인덱스(Index)
원하는 정보의 위치를 빠르고, 정확하고, 지능적으로 알아낼 수 있는 방법을 제공.
테이블의 컬럼에 제약조건을 설정할 때 Primary key나 Unique로 설정하면 오라클은 자동으로
이 컬럼에 대해 Unique Index를 설정.

-인덱스 만들기
Unique Index : 유일한 값을 가지는 컬럼에 인덱스 설정
CREATE UNIQUE INDEX dname_idx
ON dept(dname);

Non Unique Index : 유일한 값을 가지지 않는 컬럼에 인덱스 설정
emp테이블의 ename열에 대한 질의 액세스 속도 향상
CREATE INDEX emp_ename_idx
ON emp(ename);

동의어(Sysnonym)
동의어(객체의 다른 이름)를 생성하여 객체 액세스를 단순화

-사용중인 계쩡에 권한이 없어서 SYNONYM이 생성되지 않을 경우, 권한부여
>sqlplus system/비밀번호
SQL>conn /as sysdba
SQL> grant create synonym to SCOTT; <- 사용중인 계정

-동의어 생성
CREATE SYNONYM emp_info
FOR emp_info_view;

SELECT * FROM emp_info;

-동의어 삭제
DROP SYNONYM emp_info;

<2017.10.12 숙제>
1.WHERE절
  - emp 테이블에서 연봉이 25,000 이상인 사원이름과 연봉을 출력.
    단, 연봉의 alias는 ann_salary로 지정하여 출력
SELECT ename, sal*12 "ann_salary"
FROM emp
WHERE sal*12 > 25000;

  - emp 테이블에서 월급이 2000~3000인 사원의 이름,월급 출력
SELECT ename,sal FROM emp
WHERE sal BETWEEN 2000 AND 3000;
  
2. ORDER BY절
  - 모든 사원의 사원번호, 이름, 월급 출력. 
    단,월급 기준으로 오름차순으로 정렬해서 출력
SELECT empno, ename, sal
FROM emp
ORDER BY sal;

3. GROUP BY절
  - emp 테이블에서 부서별 평균 급여를 출력
    단, 소숫점은 제외하고 출력
SELECT deptno, ROUND(AVG(sal))
FROM emp
GROUP BY deptno;

  - emp 테이블에서 부서별 급여 총액과 평균급여 출력
SELECT deptno, SUM(sal) "급여 총액", ROUND(AVG(sal)) "급여 평균"
FROM emp
GROUP BY deptno;

4. HAVING 함수
  - 부서별 평균 급여가 2000이상인 부서의 번호와 부서별 평균 급여 출력
SELECT deptno, ROUND(AVG(sal)) "평균 급여"
FROM emp
GROUP BY deptno
HAVING AVG(sal) >= 2000;
  - 부서별 최대 월급을 구하고, 최대 급여가 3000이상인 부서만 출력
SELECT deptno, MAX(sal)
FROM emp
GROUP BY deptno
HAVING MAX(sal)>= 3000;

5. JOIN
  - 이름이 JAMES인 사람의 부서명을 출력
SELECT e.ename, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND e.ename = 'JAMES';

SELECT e.ename, d.dname
FROM emp e JOIN dept d
ON e.deptno = d.deptno
AND e.ename = 'JAMES';

6. SUBQUERY
  - 사원들의 평균 급여보다 더 많은 급여를 받는 사원의 이름, 월급을 출력
SELECT ename, sal FROM emp
WHERE sal > (SELECT AVG(sal) FROM emp);

  - 월급 3000이상 받는 사원이 소속된 부서와 동일한 부서에 근무하는 사원들의 이름과 월급 출력
SELECT ename, sal FROM emp
WHERE deptno IN (SELECT deptno FROM emp
                 WHERE sal>=3000);
                 





