����Ŭ SQL

-SELECT��
�����ͺ��̽��κ��� ����Ǿ� �ִ� �����͸� �˻��ϴµ� ���

���̺��� �̸��� ����� ���̺� ���� ��ȸ
SELECT * FROM tab;

emp ���̺��� ������ �б�
SELECT * FROM emp;
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno FROM emp;

Ư�� ���� ����
SELECT ename, sal FROM emp;

�ּ�
SELECT * /*�ּ�*/ FROM emp;

daul : �Լ� �� ����� ����� �� �� ����� �� �ִ� ����(public) ���̺�
�Լ� ���
SELECT ascii(0) FROM dual;
��¥
SELECT SYSDATE FROM dual;
����
SELECT 7+10 FROM dual;

����� : ��� ������(+,-,*,/)�� ����Ͽ� ���� �� ��¥ �����ͷ� ǥ������ �ۼ�
SELECT ename, sal, sal+300 FROM emp;

������ �켱����
SELECT ename, sal, 12*(sal+300) FROM emp;

SELECT empno, ename, comm FROM emp;

������� NULL�� : NULL���� �����ϴ� ������� NULL�� ���
SELECT ename, 12*sal*comm FROM emp;

�� alias ����
�� �̸��� �ٲ�
�� �̸� �ٷ� �ڿ� ����. �� �̸��� alias ���̿� ���� ������ as Ű���尡 �� ���� ����
�˸��ƽ��� ū ����ǥ�� ����ϴ� ���
- ��ҹ��� ������ ���� ��
- ������ �����ϰ� ���� ��
- _,#�� Ư������ ����� ��
- ���ڷ� ������ ��

SELECT sal*12 ASal FROM emp;
SELECT sal*12 as ASal FROM emp;
SELECT sal*12 "Annual Salary" FROM emp;
SELECT ename AS name, comm commission FROM emp;
SELECT ename "Name", sal*12 "Annual Salary" FROM emp;

���� ������
���̳� ���ڿ��� �ٸ� ���� ����
�� ���� ���μ�(||)���� ��Ÿ��
��� ���� ���ڽ��� ����
���ڿ� ó���� ���� ����ǥ('') ���!!

SELECT ename || ' has $ ' || sal FROM emp;

���� �����ڿ� NULL�� : ���ڿ��� NULL���� ������ ��� ����� ���ڿ�
SELECT ename || comm FROM emp

distinct : �ߺ��� ����
SELECT DISTINCT deptno FROM emp;

���̺� ���� ǥ�� : describe ����� ����Ͽ� ���̺��� ���� ǥ��
DESC[RIBE] tablename

DESCRIBE emp;
DESC emp

[�ǽ�����]
1. emp ���̺��� �����ȣ, ����̸�, ������ ����Ͻÿ�.
2. emp ���̺��� ����̸��� ������ ����ϴµ� �÷����� "�� ��", "�� ��"���� �ٲ㼭 ����Ͻÿ�.
3. emp ���̺��� �����ȣ, ����̸�, ����, ������ ���ϰ� ���� �÷����� "�����ȣ", "����̸�",
   "����", "����"���� ����Ͻÿ�.
4. emp ���̺��� ����(����)�� �ߺ����� �ʰ� ����Ͻÿ�.
5. emp ���̺��� ������ ������ �����ؼ� ǥ���ϰ� �÷����� Employee and Job���� ǥ���Ͻÿ�.

1.
SELECT empno, ename, sal FROM emp;
2.
SELECT ename "�� ��", sal "�� ��" FROM emp;
3.
SELECT empno �����ȣ, ename ����̸�, sal ����, sal*12 ���� FROM emp;
4.
SELECT DISTINCT job FROM emp;
5.
SELECT ename || ', ' || job "Employee and Job" FROM emp;

������ ����Ͽ� �� ����
SELECT �÷���... FROM ���̺�� WHERE ����

SELECT * FROM emp
WHERE deptno =10;

SELECT ename, job, deptno FROM emp
WHERE ename = 'SMITH';

�񱳿������� ���
SELECT * FROM emp WHERE hiredate <> '82-01-23';
SELECT * FROM emp WHERE hiredate ^= '82-01-23';
SELECT * FROM emp WHERE hiredate != '82-01-23';

SELECT * FROM emp WHERE sal >= 2000 and sal <=5000;

between and .. : �� �� ����(������ �� ����)
SELECT * FROM emp WHERE sal BETWEEN 1000 AND 1500;
SELECT * FROM emp WHERE sal NOT BETWEEN 1000 AND 1500;
SELECT * FROM emp WHERE ename NOT BETWEEN 'KING' AND 'SMITH';

in : �� ������� ���� ��ġ
SELECT * FROM emp WHERE sal IN (1300,2450,3000);
SELECT * FROM emp WHERE sal NOT IN (1300,2450,3000);
SELECT * FROM emp WHERE ename IN ('ALLEN','FORD');

like : like �����ڸ� ����Ͽ� ���� ��ġ
% : 0�� �̻��� ���ڸ� �ǹ�
_ : �� ���ڸ� ��Ÿ��
                                S�� ó��,�߰�,���� ���� �̸� �˻�
SELECT * FROM emp WHERE ename LIKE '%S%';
SELECT * FROM emp WHERE hiredate LIKE '%22';
                                (FOR ������ �� �ѱ���)
SELECT * FROM emp WHERE ename LIKE 'FOR_';
                                (�� ���� ������ M, M������ ���ų� ������)
SELECT * FROM emp WHERE ename LIKE '_M%';

�˻��ϰ��� �ϴ� ���ڿ��� _�� ���ԵǾ����� ��� _�տ� \�� ���̰�
escape '\'�� ����ؼ� �˻�
SELECT * FROM emp WHERE ename LIKE 'sc\_' ESCAPE '\';

�˻��ϰ��� �ϴ� ���ڿ��� %�� ���ԵǾ����� ���
SELECT * FROM emp WHERE ename LIKE '%\%' ESCAPE '\';

NULL ���� ���             (comm = null �Ұ�)
SELECT * FROM emp WHERE comm is NULL;
                          (comm != null �Ұ�)
SELECT * FROM emp WHERE comm is NOT NULL;

������(and, or, not)�� ����Ͽ� ���� ����
AND �������� ��� : ���� ��� ������ ��� TRUE�̸� TRUE�� ��ȯ
SELECT empno, ename, job, sal FROM emp
WHERE sal >= 2000 AND job LIKE '%MAN%';

OR �������� ��� : ���� �� �ϳ��� TRUE�̸� TRUE�� ��ȯ
SELECT empno, ename, job, sal FROM emp
WHERE sal > = 2000 OR job LIKE '%MAN%';

NOT �������� ���
SELECT ename, job FROM emp
WHERE job NOT IN ('CLERK','SALESMAN');

WHERE������ alias�� ����� �� ����
SELECT ename, sal*12 annsal FROM emp
WHERE sal*12 >= 35000;


[�ǽ�����]
1. emp ���̺��� �����ȣ�� 7698�� ����� �̸�, ����, �޿��� ���
2. emp ���̺��� ����̸��� SMITH�� ����� �̸�, ����, �μ���ȣ ���
3. emp ���̺��� ������ 2500�̻� 3500�̸��� ����� �̸�, �Ի���,���� ���
4. emp ���̺��� �޿��� 2000���� 3000���̿� ���Ե��� �ʴ� ����� �̸�, ����, �޿��� ���

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

5. emp ���̺��� 81��05��01�ϰ� 81�� 12��03�� ���̿� �Ի��� ����� �̸�, �޿�, �Ի����� ���
6. emp ���̺��� �����ȣ�� 7566,7782,7932�� ����� ������ ������� �����ȣ, �̸�, ���� ���
7. emp���̺��� �μ���ȣ(deptno) 30���� �ٹ��ϸ� �� 2,000�޷� ���ϸ� �޴� 81�� 05�� 01�� 
   ������ �Ի��� ����� �̸�, �޿�, �μ���ȣ, �Ի����� ���
8. emp���̺��� �޿��� $2,000�� $5,000���̰� �μ���ȣ�� 10 �Ǵ� 30�� ����� �̸�, �޿�,�μ���ȣ�� ���

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

9. ������ SALESMAN �Ǵ� MANAGER �̸鼭 �޿��� $1600, $2975,$2850�� �ƴ� ��� �����
   �̸�, ����, �޿��� ���
10. emp ���̺��� ����̸� �� s�� ���Ե��� ���� ����� �� �μ���ȣ�� 20�� �������
    �̸�, �μ���ȣ�� ���
11. emp ���̺��� �̸��� A�� E�� �ִ� ��� ����� �̸��� ���
12. emp ���̺��� �����ڰ� ���� ��� ����� �̸��� ������ ���
13. emp ���̺��� Ŀ�̼� �׸��� �Էµ� ������� �̸�, �޿�, Ŀ�̼��� ���

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

order by�� : ����
�������� : ���� ���� -> ū ����, A -> Z, �� -> ��
SELECT * FROM emp ORDER BY sal;
SELECT * FROM emp ORDER BY sal ASC;
SELECT * FROM emp ORDER BY ename;
SELECT * FROM emp
WHERE deptno=10
ORDER BY sal ASC;

�������� : ū ���� -> ���� ����, Z -> A, �� -> ��
SELECT * FROM emp 
WHERE deptno=10
ORDER BY sal DESC;

�� alias�� �������� ����
SELECT empno, ename, sal*12 annsal FROM emp
ORDER BY annsal;

���� ���� ��ġ�� ����Ͽ� ����
���Ǽ���  1     2     3        4 
SELECT ename, job, deptno, hiredate FROM emp
ORDER BY 3;

���� ���� �������� ����
1�� ������ ���ؿ��� �ߺ����� ������ 2�� ������ ����
SELECT ename, deptno, sal FROM emp
ORDER BY deptno ASC , ename DESC;

NULLS FIRST, NULLS LAST : NULL���� �� �� Ȥ�� �� �ڷ� ������ �� ����
SELECT * FROM emp ORDER BY comm NULLS FIRST;
SELECT *FROM emp ORDER BY comm NULLS LAST;

[�ǽ�����]
1. emp���̺��� �����ȣ, ����̸�, �Ի����� ����ϴµ� �Ի����� ���� ��� ������ ����
2. emp���̺��� ����̸�, �޿�, ������ ���ϰ� ������ ���� ������ ����
3. emp���̺��� 10�� �μ��� 20�� �μ����� �ٹ��ϴ� ����� �̸��� �μ���ȣ�� ����ϴµ�
   �̸��� �����ڼ�(��������)���� ǥ��
4. Ŀ�̼��� �޴� ��� ����� �̸�, �޿�, Ŀ�̼��� �������� ������������ �����Ͽ� ���

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

�Լ�
�����Լ�
��ҹ��� ���� �Լ� - LOWER, UPPER, INITCAP

LOWER: ������ ���ڿ��� �ҹ��ڷ� ��ȯ
SELECT LOWER('HELLO') FROM dual;
UPPER: ������ ���ڿ��� �빮�ڷ� ��ȯ
SELECT UPPER('hello') FROM dual;
INITCAP: ������ ���ڿ��� ù�ڴ� �빮�� �ܴ� �ҹ��ڷ� ��ȯ
SELECT INITCAP('hello world') FROM dual;
SELECT INITCAP(ename) FROM emp;
SELECT INITCAP(job) FROM emp;

���� �����Լ� - CONCAT, SUBSTR, LENGTH, INSTR, LPAD, RPAD, TRIM, REPLACE
CONCAT: ���ڿ�1�� ���ڿ�2�� �����Ͽ� �ϳ��� ���ڿ��� ��ȯ
SELECT CONCAT('Hello','World') from dual;
SELECT CONCAT(ename,job) from emp;

SUBSTR: ��� ���ڿ����� ���� �ε������� ���ڿ� ����
[����]�ε��� 1���� ����!!
               1234567891011
SELECT SUBSTR('Hello World',3) from dual;
���ڿ� ����° ���� 3���� ���ڿ� ����
SELECT SUBSTR('Hello World',3,3) from dual;
-�� �ڿ������� ī����, �ڿ��� 3��°���� ������ ���
SELECT SUBSTR('Hello World',-3) from dual;
�ڿ��� 3��°���� 2���� ���ڿ� ����
SELECT SUBSTR('Hello World',-3,2) from dual;

LENGHTH: ������ ������ ��ȯ
SELECT LENGTH('Hello World') FROM dual;
SELECT LENGTH(ename), LENGTH(job) FROM emp;

INSTR(����ڿ�, �˻�����): �˻������� ��ġ��(�ε���) ��ȯ
SELECT INSTR('Hello World', 'e') FROM dual;
�˻� ���ڰ� ���� ��� 0�� ��ȯ
SELECT INSTR('Hello World', 'u') FROM dual;
���� �˻����ڰ� ������ ó���� ��ȯ
SELECT INSTR('Hello World', 'o') FROM dual;
INSTR(����ڿ�, �˻�����, �˻��ε���): �˻��ε������� �˻�
              1234567891011
SELECT INSTR('Hello World', 'o',6) FROM dual;
INSTR(����ڿ�, �˻�����, �˻��ε���, �ݺ�Ƚ��) : �ݺ�Ƚ����ŭ �˻�
SELECT INSTR('Hello World', 'o',1,2) FROM dual;

LPAD(����ڿ�, �ѱ���, ����): ��� ���ڿ��� ǥ���� �� �� ���� ���������� ǥ��. ��� ���ڿ���
                             ǥ���ϰ� ���� ������ ���ʿ� ��������� �� ������ ������ ���ڷ� ǥ��
SELECT LPAD('Hello', 10, '*') FROM dual;  

RPAD(����ڿ�, �ѱ���, ����): ��� ���ڿ��� ǥ���� �� �� ���� ���������� ǥ��. ��� ���ڿ���
                             ǥ���ϰ� ���� ������ �����ʿ� ��������� �� ������ ������ ���ڷ� ǥ��
SELECT RPAD('Hello', 10, '*') FROM dual;

TRIM: ���ڿ����� �����̳� Ư�� ���ڸ� ������ ���� ���� ��ȯ
����: leading(����), trailing(������), both <-default
���Ź��� from ����� ����
SELECT TRIM(both 'h' from 'habchh') FROM dual;
SELECT TRIM(leading 'h' from 'hahbchh') FROM dual;

REPLACE(����ڿ�,old,new): ����ڿ����� old���ڸ� new���ڷ� ��ü
SELECT REPLACE('010.1234.5678', '.', '-') FROM dual;

�Լ� ��ø
SELECt ename, LOWER(SUBSTR(ename, 1, 3)) FROM emp;

���� �Լ�
CEIL(): �ø� ó���� �������� ��ȯ
SELECT CEIL(1.4) FROM dual;

ROUND(): �ݿø�
ROUND(������,�����ڸ���): ���� �ڸ������� �ݿø�
SELECT ROUND(45.926,2) FROM dual;
�����ڸ����� �������� ������ �Ҽ��� �ڸ� ����. ��, ������ ����
SELECT ROUND(45.926) FROM dual;
SELECT empno, sal, ROUND(sal*1.15) "New Sallary", ROUND((sal*1.15)-sal) "Increase" FROM emp;

TRUNC(������, �����ڸ���): ���� ����
SELECT TRUNC(45.926,2) FROM dual;
�ڸ����� �������� ������ �Ҽ��� ����
SELECT TRUNC(45.926) FROM dual;

MOD(������, ��������): ������ ���� ��ȯ
SELECT MOD(17,2) FROM dual;

��¥�Լ�
����Ŭ �����ͺ��̽��� ���� ���� ����(����,��,��,��,��,��,��)���� ��¥�� ����

SYSDATE: ORACLE ������ ���� ��¥�� �ð��� ��ȯ
SELECT SYSDATE FROM dual;

��¥�� ��� ������ ���
              �Ի��� �� ���� ����ߴ���
SELECT ename, ROUND((SYSDATE - hiredate)/7) AS WEEKS FROM emp
WHERE deptno=10;

MONTHS_BETWEEN(ū ��¥,���� ��¥): �� ��¥ ���� �� ��
SELECT MONTHS_BETWEEN('2012-03-23','2009-01-23') FROM dual;

ADD_MONTHS: Ư�� ��¥�� ���� ������ ���� ���� �ش� ��¥�� ��ȯ
SELECT ADD_MONTHS('2010-01-01', 8) FROM dual;

NEXT_DAY: ������ ������ ���� ��¥�� ��ȯ
SELECT NEXT_DAY('2017-09-25','������') FROM dual;
���� ��� ����1(�Ͽ���)~7(�����)�� ��ü ����
SELECT NEXT_DAY('2017-09-25',3) FROM dual;

LAST_DAY: ���� ������ ��¥�� ��ȯ
SELECT LAST_DAY('2017-09-29') FROM dual;

ROUND: �ι�° �Ķ���ͷ� ������ ���� �������� ù��° �Ķ���� ��¥�� �ݿø�
����: �ð��� 12�ø� �Ѿ�� 1�� ������Ŵ
SELECT ROUND(SYSDATE) FROM dual; 
SELECT ROUND(SYSDATE, 'DD') FROM dual; /*'DD' => ��*/
���� 16�� �̻��� ��� �ø��� �� ���� ��¥�� ��� �߷�����
SELECT ROUND(SYSDATE, 'MONTH') FROM dual;
�⵵�� 7�� 1�� �̻��� ��� �ø��� �� ���� ��¥�� ��� �߷�����
SELECT ROUND(SYSDATE, 'YEAR ') FROM dual;
�б�� 3���� �����̹Ƿ�, �ι�° ���� 16�� �̻��� ��� �ø��� �� ���� ��¥�� ��� �߷�����
SELECT ROUND(SYSDATE, 'Q') FROM dual;
�� �ְ� ���۵Ǵ� ��¥�� �ݿø�
SELECT ROUND(SYSDATE, 'DAY') FROM dual;

TRUNC: ����
SELECT TRUNC(SYSDATE) FROM dual;
SELECT TRUNC(SYSDATE, 'MONTH') FROM dual;
SELECT TRUNC(SYSDATE, 'YEAR') FROM dual;

EXTRACT: ��¥ �������� Ư���� ����, ��, ��, ��, ��, �� ���� ����
SELECT EXTRACT(YEAR FROM SYSDATE) FROM dual;
SELECT EXTRACT(MONTH FROM SYSDATE) FROM dual;
SELECT EXTRACT(DAY FROM SYSDATE) FROM dual;

[�ǽ�����]
1. emp���̺��� ����(job)�� ù���ڴ� �빮�� �������� �ҹ��ڷ� ���
2. emp���̺��� ����̸� �� A�� ���Ե� ����̸��� ���ϰ� �� �̸� �� �տ��� 3�ڸ� �����Ͽ�
   ���
3. �̸��� ����° ���ڰ� A�� ��� ����� �̸��� ǥ��
4. �̸��� J,A�Ǵ� M���� �����ϴ� ��� ����� �̸�(ù ���ڴ� �빮��, �������� �ҹ���) �� 
   �̸� ���� ���(�� �̸��� name�� length)

1.
SELECT INITCAP(job) FROM emp;
2.
SELECT SUBSTR(ename,3) FROM emp
WHERE ename LIKE ('%A%');
3.
SELECT ename FROM emp
WHERE ename LIKE ('__A%');
�Ǵ�
SELECT ename FROM emp
WHERE SUBSTR(ename,3,1)='A';

4.
SELECT INITCAP(ename) name, LENGTH(ename) length FROM emp
WHERE ename LIKE ('J%') OR ename LIKE ('A%') OR ename LIKE ('M%');
�Ǵ�
SELECT INITCAP(ename) name, LENGTH(ename) length FROM emp
WHERE SUBSTR(ename,1,1) IN ('J','A','M');

5. �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �ҹ��ڷ� �̸��� ���
6. �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� ���
7. ��� ����� �̸��� �޿��� ǥ���ϴµ� �޿��� 15�� ���̷� ���ʿ� $��ȣ�� ä���� �������� 
   ǥ���ϰ� �� ���̺��� SALARY�� ����
8. ���ú��� �̹����� �������������� ���� �� ���� ���Ͻÿ�
9. �� ����� ���� �����ȣ, �̸�, �޿�, 5%�λ�� �޿��� ����(�ݿø�)�� ǥ���Ͻÿ�. �λ��
   �޿����� ���̺��� New Salary�� ����

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
�Ǵ�
SELECT empno, ename, sal, TO_CHAR(sal*1.05, '9999') "New Salary" FROM emp;

��ȯ�Լ�
TO_NUMBER : ���� -> ����
TO_CHAR : ���� -> ����, ��¥ -> ����
TO_DATE : ���� -> ��¥

��¥ ������
AD, A.D. : AD(�����) ǥ��
AM,PM,A.M.,P.M. : ���� ���� ǥ��
BC, B.C. : BC(�����) ǥ��
CC,SCC : ���� ǥ��(1999�� 20����, 2001�� 21����)
Y,YY,YYY,YYYY : ������ ���ڰ�(���� 1,2,3,4 �ڸ��� ǥ��)
RR : �� �ڸ� ���� ���� �� ���� ���ڸ��� ����Ͽ� ���� �� �ڸ� ���ڸ� ��ȯ.
     ���� ���ڸ��� 50���� ���� ���� ���� ���Ⱑ �״�� �������� 50�̻��̸� 1�� �ٿ� ���
MM : ���� ���ڽ� ǥ��(1~12)
DD : �� ���� ���� ���ڽ����� ǥ��(1~31)
HH, HH12 : �ð�(1~12) ǥ��
HH24 : �ð�(0~23) ǥ��
MI : ��(0~59) ǥ��
SS : ��(0~59) ǥ��
Q : �б�(1,2,3,4) 1�� 1��~3��, 2�� 4~6��, 3�� 7~9��, 4�� 10~12��

���� ������
9 : ���ڸ� �־��� �ڸ������ ��ȯ(ex, TO_CHAR(111,999) -> 111���)
0 : ���ڸ��� 0�� ǥ�õǵ��� ���� ����
9,999 : ������ ��ġ�� �޸��� �־���(ex, TO_CHAR(1234, '9,999') -> 1,234���)
999.00 : ������ ��ġ�� �Ҽ����� �־���(ex. TO_CHAR(123, '999.99') -> 123.00)
$9999 : ���� �տ� �޷� ��ȣ�� �־���


TO_CHAR : ���� -> ����, ��¥ -> ����
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM dual;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') FROM dual;
SELECT TO_CHAR(SYSDATE, 'DD-MON-RR HH:MI:SS') FROM dual;
SELECT TO_CHAR(hiredate, 'YY-MM-DD HH24:MI:SS') FROM emp;

SELECT TO_CHAR(1234, 9999) FROM dual;
SELECT TO_CHAR(1234, '9999') FROM dual;
�Ǵ�
SELECT TO_CHAR(1234, '0000') FROM dual;

�ڸ����� ���ڶ� ��� -> #### ���
SELECT TO_CHAR(1234, 999) FROM dual;
SELECT TO_CHAR(1234, '999') FROM dual;
SELECT TO_CHAR(1234, '000') FROM dual;

���� �ڸ������� ���� �ڸ����� ������ ���
SELECT TO_CHAR(1234, 999999) FROM dual;
SELECT TO_CHAR(1234, '999999') FROM dual;
SELECT TO_CHAR(1234, '000000') FROM dual;

�Ҽ��� �ڸ�
SELECT TO_CHAR(1234, '0000.00') FROM dual;
SELECT TO_CHAR(1234, '9999.99') FROM dual;
�ݿø��ؼ� �Ҽ��� ��°�ڸ����� ǥ��
SELECT TO_CHAR(25.897, '99.99') FROM dual;
SELECT TO_CHAR(sal*1.15, '9,999.9') FROM emp;

��ȭ ǥ��
SELECT TO_CHAR(1234,'$0000') FROM dual;
������ȭ ǥ��
SELECT TO_CHAR(1234,'L0000') FROM dual;

[�ǽ�����]
1. emp ���̺��� ������ 4�� ����� ����� �̸��� ������ ����Ͻÿ�. (���ڸ� ���� ��ǥ ǥ��)
2. �� ����� �̸��� ǥ���ϰ� �ٹ� �� ��(�Ի��Ϸκ��� ��������� �� ��)�� ����Ͽ�
   �� ���̺��� MONTHS_WORKED�� �����Ͻÿ�. ����� ������ �ݿø��Ͽ� ǥ���ϰ� �ٹ� �� ����
   �������� ������������ �����Ͻÿ�.
3. emp ���̺��� �̸�(�ҹ��ڷ� ǥ��), ����, �ٹ������� ���

1.
SELECT ename, TO_CHAR(sal,'9,999') FROM emp
WHERE MOD(sal,4)=0;
2.
SELECT ename, ROUND(MONTHS_BETWEEN(SYSDATE, hiredate)) "MONTHS_WORKED" FROM emp
ORDER BY MONTHS_WORKED ASC;
�Ǵ�
SELECT ename, TO_CHAR(MONTHS_BETWEEN(SYSDATE, hiredate), 999) "MONTHS_WORKED" FROM emp
ORDER BY MONTHS_WORKED ASC;
3.
SELECT LOWER(ename), job, ROUND(MONTHS_BETWEEN(SYSDATE, hiredate)/12) "YEAR" FROM emp;

-TO_DATE: ���� -> ����
SELECT TO_DATE('2017-10-10','YYYY-MM-DD') FROM dual;
SELECT TO_DATE('17-10-10','DD-MM-RR') FROM dual;

-TO_NUMBER : ���� -> ����
SELECT TO_NUMBER('100','999') FROM dual;
SELECT TO_NUMBER('100','000') FROM dual;
�������� ���� ����
SELECT TO_NUMBER('100') FROM dual;

�Ϲ��Լ�
NVL(value1,value2) : value1�� null�̸� value2�� ���.
                     value1�� value2�� �ڷ����� ��ġ.
                     
SELECT ename, sal, NVL(comm,0), NVL(comm,0)*12 FROM emp;

value1�� value2�� �ڷ����� ��ġ��Ű��
SELECT ename, NVL(TO_CHAR(comm),'NO Commision') FROM emp;
SELECT ename, sal+NVL(comm,0) �Ǳ޿� FROM emp;

NVL2(value1, value2, value3) : value1�� null���� ��. null�̸� value3,
                               null�� �ƴϸ� value2 ���
                               �ڷ����� ��ġ���� �ʾƵ� ��
SELECT ename, NVL2(comm, 'commision', 'no commision') FROM emp;
[����]
SELECT NVL2(comm, sal, comm) FROM emp;
SELECT ename, NVL2(comm, 'commision', 'no commision') FROM emp;
�� value1�� value2�� ������Ÿ���� ���ƾ���
SELECT NVL2(comm, comm, 'no commision') FROM emp;
SELECT NVL2(comm, TO_CHAR(comm), 'no commision') FROM emp;
SELECT NVL2(comm, 'commision', 0) FROM emp;

NULLIF(value1, value2) : �ΰ��� ���� ��ġ�ϸ� NULL. 
                         �ΰ��� ���� ��ġ���� ������ value1 ���
SELECT NULLIF(LENGTH(ename), LENGTH(job)) "NULLIF" FROM emp;

COALESCE(value1, value2, value3, ...) : null���� �ƴ� ���� ���(�ڷ��� ��ġ)
SELECT comm, sal, COALESCE(comm, sal, 0) FROM emp;
SELECT comm, mgr, sal, COALESCE(comm, mgr, sal) FROM emp;

- ANSI ǥ��(�ڹ��� if���� ���)
CASE �÷� WHEN �񱳰� THEN �����
          WHEN       THEN
          WHEN       THEN
          (ELSE �����)
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

- ����Ŭ ����
DECODE : = �񱳸� ����(�ڹ��� switch���� ���)
DECODE(�÷���,�񱳰�,��ȯ��,
             �񱳰�,��ȯ��,
             �񱳰�,��ȯ��,
             ��ȯ��)
             
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

[�ǽ�����]
1. emp���̺��� ����̸�, ����, ���ް� Ŀ�̼��� ���� ���� �÷��� �Ǳ޿���� �ؼ� ����Ͻÿ�.
 ��, null���� ��Ÿ���� �ʰ� �ۼ��Ͻÿ�.
2. ���ް� Ŀ�̼��� ��ģ �ݾ��� 2,000�̻��� �޿��� �޴� ����� �̸�, ����, ����, Ŀ�̼�, ��볯¥�� ���
 ��, ��볯¥�� 1980-12-17�������� ���
3. job ���� ���� �������� ��� ����� ����� ǥ���Ͻÿ�.(DECODE, CASE �� �� �ѹ��� ���)
 ����         ���
 PRESIDENT     A
 ANALYST       B
 MANAGER       C
 SALESMAN      D
 CLERK         E
 ��Ÿ           0

1.
SELECT ename, sal, sal+NVL(comm,0) �Ǳ޿� FROM emp;
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

�׷��Լ� : �� ���� ������ �����Ͽ� �׷캰�� �ϳ��� ����� ����
AVG() : null�� ������ ��� ������ ����� ��ȯ. null���� ��հ�꿡�� ���õ�

SELECT ROUND(AVG(sal)) FROM emp;

COUNT() : null�� ������ ���� ���� ��� ���ڵ��� ���� ��ȯ
          COUNT(*)������ ����ϸ� null�� ��꿡 ����.
emp���̺��� �� ���ڵ� ��
SELECT COUNT(*) FROM emp;
Ŀ�̼� ����� �� ����� ��
SELECT COUNT(comm) FROM emp;

MAX() : ���ڵ� ���� �ִ� ���� �� �� ���� ū ���� ��ȯ
SELECT MAX(sal) FROM emp;
SELECT MAX(ename) FROM emp;

SUM() : ���ڵ���� �����ϰ� �ִ� ��� ���� ���Ͽ� ��ȯ
SELECT SUM(sal) FROM emp;

SELECT MAX(sal), MIN(sal), ROUND(AVG(sal)), SUM(sal) FROM emp;

SELECT MAX(sal), MIN(sal), ROUND(AVG(sal)), SUM(sal) FROM emp
WHERE deptno=10;

20�� �μ����� �ٹ��ϴ� ����� ��
SELECT COUNT(*) FROM emp
WHERE deptno=20;
SELECT COUNT(NVL(comm,0)) FROM emp
WHERE deptno=20;
��> PRIMARAY KEY �̿� 
SELECT COUNT(empno) FROM emp
WHERE deptno=20;

20�� �μ����� Ŀ�̼� ����� �� ����� ��(null���� ����)
SELECT COUNT(comm) FROM emp
WHERE deptno = 30;

GROUP BY : SELECT���� �����Լ� ����� ���� �÷��� ������ �� ����.
           ���� �÷��� ������ ��쿡�� �ݵ�� GROUP BY���� ������ �÷��� ����.
�μ��� �ְ� �޿�
SELECT deptno, MAX(sal) FROM emp
GROUP BY deptno;
�μ��� �޿� �հ�� ��� �޿�
SELECT deptno, ROUND(AVG(sal)) ���, SUM(sal) �հ� FROM emp
GROUP BY deptno;

�μ���, ������ �޿� �հ�
SELECT deptno, job, SUM(sal) FROM emp
GROUP BY deptno, job;   

�μ���, ������ �޿� �հ�, �޿� ���

SELECT deptno, job, SUM(sal) �հ�, ROUND(AVG(sal)) ��� FROM emp
GROUP BY deptno, job;   

[����]
SELECT deptno, COUNT(ename) FROM emp;
[����]
SELECT deptno, COUNT(ename) FROM emp
GROUP BY deptno;

[����] WHERE������ �׷��Լ� ��� �Ұ� -> HAVING ���� ����ؾ� ��
SELECT deptno, ROUND(AVG(sal)) FROM emp
WHERE ROUND(AVG(sal)) >= 2000 
GROUP BY deptno;
[����]
�μ��� ��� �޿��� ���ϴ� �� ��� �޿��� 2000�̻��� �����͸� ����
SELECT deptno, ROUND(AVG(sal)) FROM emp
GROUP BY deptno
HAVING ROUND(AVG(sal)) >= 2000;

HAVING : �׷� ó�� ����� �����ϰ��� �� �� HAVING�� ���
         WHERE������ �׷��Լ��� ����� �� ���� ���� �ؼ�
         
�μ��� �ְ� �޿��� ���ϴµ� �ְ� �޿��� 2000�� �ʰ��� �����͸� ����
SELECT deptno, MAX(sal) FROM emp
GROUP BY deptno
HAVING MAX(sal) > 2000;

�׷��Լ� ��ø
[����]            �� �׷��Լ� ��ø��  
SELECT deptno, MAX(AVG(sal)) FROM emp
GROUP BY deptno;
[����]
SELECT MAX(AVG(sal)) FROM emp
GROUP BY deptno;

[�ǽ�����]
1. ��� ����� �޿� �ְ��, ������, �Ѿ� �� ����� ǥ���Ͻÿ�.
    �� ���̺��� ���� maximum, minimum, sum average�� �����ϰ� ����� ������
    �ݿø��ϰ� ���ڸ� ������ ��ǥ(,)�� ����Ͻÿ�.
2. ����(job)�� ������ ��� ���� ǥ���Ͻÿ�.
3. emp ���̺��� 30�� �μ��� ������� ���Ͻÿ�.
4. emp ���̺��� ������ �ְ� ������ ���ϰ� ����, �ְ������ ����Ͻÿ�.

1.
SELECT TO_CHAR(MAX(sal),'9,999') �ְ��, 
       TO_CHAR(MIN(sal),'9,999') ������, 
       TO_CHAR(SUM(sal),'99,999') �Ѿ�, 
       TO_CHAR(ROUND(AVG(sal)), '9,999') ��� 
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

5. emp ���̺��� 20�� �μ��� �޿� �հ踦 ���ϰ� �޿� �հ� �ݾ��� ���
6. emp ���̺��� �μ����� ���޵Ǵ� �� ���޿��� �ݾ��� 7,000 �̻��� �μ���ȣ, �� ������ ���
7. emp ���̺��� �������� ����� ���� ���� ����� ���ϰ� �� ��� ������ ��� 79�� �����ϴ�
   ����� ���
8. emp ���̺��� �������� �� ������ ����ϴµ� ������ 'MANAGER'�� ����� �����ϰ� �� ������
   5,000 ���� ū ������ �� ���޸� ���

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

JOIN : �� �̻��� ���̺��� �����Ͽ� �����͸� �˻��ϴ� ���
       ����, �� �̻��� ����� ����� �� Primary Key �� Foreign Key ���� ����Ͽ� ����
       �� ���� ���̺��� SELECT�� �ȿ��� �����Ϸ��� ��� �ϳ��� �÷��� �� �� ���̺� ���̿��� ���� �Ǿ�� ��.

Cartesian Product(īƼ�� ��): �˻��ϰ��� �ߴ� ������ �Ӹ� �ƴ϶� ���ο� ���� ���̺���� ��� �����Ͱ�
                             ��ȯ�Ǵ� ����     
SELECT * FROM emp, dept;

JOIN ���
[ORACLE ����]
-���� ����(Equi Join) : ������ Equality Condition(=)�� ���Ͽ� ����
SELECT e.ename, d.deptno
FROM emp e, dept d
WHERE e.deptno = d.deptno;

�߰����� ������ ����ϴ� ���
SELECT e.ename, d.deptno
FROM emp e, dept d
WHERE e.deptno = d.deptno /*���� ����*/
AND e.ename = 'ALLEN'; /*�ΰ� ����*/

SELECT e.ename, e.sal, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno /*���� ����*/
AND e.sal BETWEEN 3000 AND 4000; /*�ΰ� ����*/

-�񵿵� ����(non equi join)
���̺��� � column�� join�� ���̺��� column�� ��ġ���� ���� �� ����ϰ�
���� ������ ����(=)�̿��� �����ڸ� �����(between and, is null, in not null, in, not in) ��

����̸�, �޿�, �޿���� ���ϱ�(emp, salgrade ���̺��� �̿�)
SELECT e.ename, e.sal, s.grade
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal;

-Self Join : �����ϴ� �� ���� ���̺��� ������ ���̺��� ���

��� �̸��� �ش� ����� ������ �̸� ���ϱ�(�����ڰ� ���� ��� ����)
SELECT a.ename ����̸�, m.ename �������̸�
FROM emp a, emp m
WHERE a.mgr = m.empno;

-Outer Join
equi join ������� �� ���� �������� �װ͵��� ������ �����Ϸ� �ϴ� �� ���� ���̺���
�� �� �÷����� ����� ���� ���ٸ� ���̺�κ��� �����͸� ��ȯ���� �ʴ´ٴ� ��.
���������� ���� ������ �������� �� �ϴ� ����� ���� ���� outer join ���

������ ���� �ݴ� ���̺� (+)��ȣ ǥ��
SELECT DISTINCT(e.deptno), d.deptno
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;

����̸��� �ش� ����� ������ �̸� ���ϱ�(�����ڰ� ���� ����� ǥ��)
SELECT a.ename ����̸�, m.ename �������̸�
FROM emp a, emp m
WHERE a.mgr = m.empno(+);

[�ǽ�����]
1. ��� ����� �̸�, �μ���ȣ, �μ��̸��� ǥ���Ͻÿ�.(emp, dept)
2. ������ 'MANAGER'�� ����� ������ �̸�, ����, �μ���, �ٹ��� ������ ���(emp, dept)
3. Ŀ�̼��� �ް� �޿��� 1,600�̻��� ����� ����̸�, �μ���, �ٹ����� ���
4. �ٹ����� CHICAGO�� ��� ����� �̸�, ����, �μ���ȣ �� �μ��̸��� ǥ��

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

5. �ٹ���(loc)���� �ٹ��ϴ� ����� ���� 5�� ������ ���, �ο��� ���� ���� ������ �����Ͻÿ�
    (�ٹ� �ο��� 0���� ���� ǥ��)
6. ����� �̸� �� ��� ��ȣ�� �������� �̸��� ������ ��ȣ�� �Բ� ǥ���ϰ� ������ �����̺��� employ, 
   emp#, manager, mgr#�� �����Ͻÿ�.(�����ڰ� ���� ����� ����)
7. �����ں��� ���� �Ի��� ��� ����� �̸� �� �Ի����� �������� �̸� �� �Ի��ϰ� �Բ� ǥ���ϰ�
   �����̺��� employee, emp hired, manager, mgr hired�� �����Ͻÿ�.

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

[ǥ�� SQL]
-���� ����(inner join)
inner join�̶�� ����ص� �ǰ� join�� ����ص� ��

SELECT emp.ename, dept.deptno
FROM emp INNER JOIN dept /*������ ���̺� ���*/
ON emp.deptno = dept.deptno; /*���� ����*/

�ΰ����� ������ ������ WHERE�� ���
SELECT emp.ename, dept.deptno
FROM emp INNER JOIN dept
ON emp.deptno = dept.deptno
WHERE emp.ename = 'ALLEN';

���̺� �˸��ƽ� ���
SELECT e.ename, d.deptno
FROM emp e INNER JOIN dept d
ON e.deptno = d.deptno
WHERE e.ename = 'ALLEN';

���� ���� ���ǿ� ���� �÷��� �̸��� ���ٸ� ������ ���� using���� ����Ͽ� 
���� ������ ������ �� ����
[����]USING�� ���� �÷��� ���̺�� �Ǵ� ���̺� �˸��ƽ��� ������ ����
�Ʒ� SQL���忡�� d.deptno�� ����ϸ� ���� �߻�
SELECT e.ename, d.dname, deptno
FROM emp e JOIN dept d
USING(deptno)
WHERE e.ename = 'ALLEN';

SELECT ename, dname, deptno
FROM emp e JOIN dept d
USING(deptno)
WHERE e.ename = 'ALLEN';

-Self Join
����̸��� �ش� ����� ������ �̸� ���ϱ�(������ ���� ����� ����)
SELECT e.ename name, m.ename manager_name
FROM emp e JOIN emp m
ON e.mgr = m.empno;

����̸��� �ش� ����� ������ �̸� ���ϱ�(������ ���� ����� ����)
SELECT e.ename name, m.ename manager_name
FROM emp e LEFT JOIN emp m
ON e.mgr = m.empno;

[�ǽ�����]
1. ��� ����� �̸�, �μ���ȣ, �μ��̸��� ǥ���Ͻÿ�(emp, dept)
2. ������ 'MANAGER'�� ����� ������ �̸�, ����, �μ���, �ٹ��� ������ ���(emp,dept)
3. �ٹ����� 'CHICAGO'�� ��� ����� �̸�, ����, �μ���ȣ �� �μ��̸��� ǥ��
4. �ٹ���(loc)���� �ٹ��ϴ� ����� ���� 5�� ������ ���, �ο��� ���� ���� ������ �����Ͽ� ���
    (�ٹ� �ο��� 0�� �ΰ͵� ǥ��);
    
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

5. 10�� �μ����� �ٹ��ϴ� ������� �μ���ȣ, �μ��̸�, ����̸�, ����, �޿������ ���(emp, dept, salgrade)
[����Ŭ ����]
SELECT e.deptno, d.dname, e.ename, e.sal, s.grade
FROM emp e, dept d, salgrade s /*�� ���� ���̺� ����*/
WHERE e.deptno = d.deptno /*emp�� dept�� ���� ����*/
AND e.sal BETWEEN s.losal AND s.hisal /*emp�� salgrade ���� ����*/
AND e.deptno = 10;

[ǥ�� SQL]
SELECT e.deptno, d.dname, e.ename, e.sal, s.grade
FROM emp e INNER JOIN dept d /*�ΰ��� ���̺� ����*/
ON e.deptno=d.deptno /*emp�� dept�� ��������*/
INNER JOIN salgrade s /*����° ���̺� ����*/
ON e.sal BETWEEN s.losal AND s.hisal /*emp�� salgrade�� ��������*/
WHERE e.deptno=10;

���տ�����
- UNION : ������, �ߺ��� ����
SELECT ename, deptno FROM emp
UNION
SELECT dname, deptno FROM dept;

- UNION ALL : ������, �ߺ��� ������ ��ȯ
SELECT deptno FROM emp
UNION ALL
SELECT deptno FROM dept;

- INTERSECT : ������, �� ���� ���� �� ����� ���� ��ȯ
SELECT deptno FROM emp
INTERSECT
SELECT deptno FROM dept;

- MINUS : ������, ù��° SELECT���� ���� ��ȯ�Ǵ� �� �߿��� �� ��° SELECT���� ����
          ��ȯ�Ǵ� �࿡ �������� �ʴ� ����� ������
SELECT deptno FROM dept
MINUS
SELECT deptno FROM emp;

Subquery : �ٸ� ���� SQL������ ���� nested�� SELECT ����
-������ �������� : ���� �Ѱ��� ��(��)�� ��ȯ
SELECT empno, ename, job FROM emp 
WHERE job = (SELECT job FROM emp
                WHERE empno=7369);

SELECT ename, sal FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'BLAKE');

-������ �������� : �ϳ� �̻��� ���� ��ȯ�ϴ� ��������
IN �������� ���
SELECT empno, ename, sal FROM emp
WHERE sal IN (SELECT MIN(sal) FROM emp GROUP BY deptno);

ANY �������� ���
ANY ������ : ���������� ����� �� ��� �ϳ��� ���̶� ������ �Ǹ� ������� ��ȯ
SELECT ename, sal FROM emp
WHERE sal > ANY(SELECT sal FROM emp WHERE job = 'SALESMAN');

[�ǽ�����]
1. 'BLAKE'�� ���� �μ��� �ִ� ������� �̸��� �Ի����� ���ϴµ� 'BLAKE'�� �����ϰ� ���
    (BLAKE�� �������� �� ���� -> �������̶�� ����);
SELECT ename, hiredate FROM emp
WHERE deptno IN (SELECT deptno FROM emp 
                 WHERE ename = 'BLAKE');

2. ��ձ޿����� ���� �޿��� �޴� ������� �����ȣ, �̸�, ������ ����ϴµ� ������ ���� ��� ������ ���
SELECT empno, ename, sal FROM emp
WHERE sal > (SELECT AVG(sal) FROM emp)
ORDER BY sal DESC;

3. 10�� �μ����� �޿��� ���� ���� �޴� ����� ������ �޿��� �޴� ����� �̸��� ���
SELECT ename FROM emp
WHERE sal = (SELECT MIN(sal) FROM emp
             WHERE deptno =10);

4. ������� 3���� �Ѵ� �μ��� �μ���� ������� ���
SELECT d.dname, COUNT(e.deptno) cnt
FROM emp e, dept d
WHERE e.deptno = d.deptno
GROUP BY d.dname
HAVING COUNT(e.deptno) > 3;

SELECT d.dname, b.cnt
FROM dept d, (SELECT deptno, COUNT(empno) cnt FROM emp GROUP BY deptno) b
WHERE d.deptno = b.deptno
AND b.cnt > 3;


5. �����ȣ�� 7844�� ������� ���� �Ի��� ����� �̸��� �Ի����� ���
SELECT ename, hiredate FROM emp
WHERE hiredate < (SELECT hiredate FROM emp
                WHERE empno = 7844);

6. ������(mgr)�� KING�� ��� ����� �̸��� �޿��� ���
SELECT ename, sal FROM emp
WHERE mgr = (SELECT empno FROM emp
            WHERE ename = 'KING');
            
7. 20���μ����� ���� �޿��� ���� �޴� ����� ������ �޿��� �޴� ����� �̸�, �μ���, �޿�, �޿������ ���
SELECT e.ename, e.sal, d.dname, s.grade 
FROM emp e, dept d, salgrade s
WHERE e.deptno = d.deptno
AND e.sal BETWEEN s.losal AND s.hisal
AND sal = (SELECT MAX(sal) FROM emp
            WHERE deptno=20);

[ǥ��SQL]
SELECT e.ename, d.dname, e.sal, s.grade
FROM emp e JOIN dept d
ON e.deptno = d.deptno
JOIN salgrade s
ON e.sal BETWEEN s.losal AND s.hisal
WHERE sal = (SELECT MAX(sal) FROM emp
             WHERE deptno=20);



INSERT�� : ���̺� ���� ����
����: INSERT INTO ���̺�� (�÷���, ...) VALUES (��, ...)

��ü ������ ����
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno)
VALUES (8000,'DENNIS', 'SALESMAN', 7693, '99/01/21', 1700, 200, 30);

��ü �����͸� ����� ���� �÷��� ���� ����
INSERT INTO emp
VALUES (8003,'SUNNY','SALESMAN',7698,'99/03/01',1000,300,30);

[null ���� ���]
-�Է����� �ʴ� �÷��� �����ϰ� Insert�ϴ� ���
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,deptno)
VALUES (8001,'PETER', 'CLERK', 7698, '99/01/22', 1800,10);

-���� �Էµ��� �ʴ� �÷��� �������� �ʾ��� ���
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno)
VALUES (8002,'ANNIE','CLERK',7698,'99/02/21',1600,null,20);

[��¥ ����]
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno)
VALUES (8004,'MICHAEL','SALESMAN',7698,TO_DATE('2017/10/11','YYYY/MM/DD'),1800,100,30);

UPDATE�� : ������� ������ ����
���� : UPDATE ���̺�� SET �÷��� = ������, ... WHERE ����

UPDATE emp SET mgr = 7698 WHERE empno=8000;
UPDATE emp SET ename='MARIA', sal=2500, comm=500 WHERE empno=8000;

UPDATE emp 
SET job = (SELECT job FROM emp WHERE empno=7902),
    sal = (SELECT sal FROM emp WHERE empno=7782)
WHERE empno=8001;

[����]UPDATE������ WHERE���� ������� ������ ��ü���� �����͸� ������
UPDATE emp SET ename='DENNIS';

ROLLBACK;

DELETE��: ���� ����
����: DELETE FROM ���̺�� WHERE ����

DELETE FROM emp WHERE empno=7369;
[����]WHERE���� ������� ������ ��ü���� ������
DELETE FROM emp;
ROLLBACK;

-MERGE�� : �����ͺ��̽� ���̺��� ���ǿ� ���� �����͸� �����ϰų� �����ϴ� ����� ����
           �ش� ���� �����ϴ� ��� UPDATE�� �����ϰ�, ���ο� ���� ��� INSERT�� ����
[����]
MERGE INTO table_name <-����� ���̺�
USING (table|view|sub_query) <- �����ϴ� ������
ON (join condition) <- join���ǹ�
WHEN MATCHED THEN
 UPDATE SET
  column1 = column1_value,
  column2 = column1_value
WHEN NOT MATCHED THEN
 INSERT (column_list)
 VALUES (column_values)
 
�� ����
copy_emp ���̺��� ���� ���� �Ǵ� �����Ͽ� emp ���̺�� ��ġ��Ű�� �۾�
 [copy_emp] ���̺� ����
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

MERGE���� �̿��ؼ� emp���̺��� �����͸� copy_emp�� ����
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

MERGE���� Ȱ��
 - �����͸� �����Ϸ��� �� ������ �����ϴ� �����Ͱ� ������ UPDATE�ϵ��� ����
MERGE INTO emp c /*�����Ͱ� ����Ǵ� ���̺�*/
USING (SELECT 8000 empno, 'DENNIS' ename, 'SALESMAN' job, 7698 mgr, 
              '99/01/23' hiredate, 1700 sal, 200 comm, 30 deptno 
       FROM dual) e /*���̺� ����� �����͸� �÷��� ��Ī�Ͽ� dual�� �̿��� �����*/
ON (c.empno = e.empno) /*UPDATE, INSERT�� ����*/
WHEN MATCHED THEN /*empno�� �������� ������ INSERT*/
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
 
 - �ߺ��Ǵ� �����Ͱ� ���� �� delete�ϴ� ����� 10g���� ����



SELECT * FROM emp;

[Ʈ�����]
Ʈ������� ������ ó���� �� ����
����Ŭ �������� �߻��ϴ� SQL������ �ϳ��� ������ �۾������� ����
DML�������� ������

1) Ʈ������� ���� : SQL������ ���� ó�� ���൵�� ��
2) Ʈ������� �� : COMMIT�̳� ROLLBACK
                 DDL, DCL������ ����(�ڵ� COMMIT)
                 ������ �Ǵ� �ý��� �浹, deadlock�߻���
                 ����ڰ� ���� �����
3) �ڵ� COMMIT�� ������ ��쿡 �߻�
 - DDL, DCL������ �Ϸ�� ��
 - ��������� COMMIT�̳� ROLLBACK ���� SQL*PLUS�� ���� �������� ���
4) �ڵ� ROLLBACK�� ������ ��쿡 �߻�
 - SQL*PLUS�� ������ �������� ���
 - ���������� �����
 - System failure��

COMMIT�� ROLLBACK�� ����
 - �������� �ϰ����� ����
 - �����͸� ���������� �����ϱ� ���� ������ ������ Ȯ���ϰ� ��

�����ͺ��̽� ��ü
 - ���̺�, ��, ������, �ε���, ���Ǿ�
 
���̺��� ����, ���� �� ����
���̺� : �⺻������ ������ ���� ����, ���ڵ�� �÷����� ����

����Ŭ �����ͺ��̽��� ���̺�
 1) ������ ��ųʸ�: ����Ŭ ������ ���� �� ���� �����ϴ� ���̺��� collection(����)
                �����ͺ��̽� ������ �����ϰ� ����
  - ����ڰ� ������ ���̺��� �̸�
SELECT table_name FROM user_tables;
  - ����ڰ� ������ ���� ��ü ����
SELECT DISTINCT object_type FROM user_objects;
  - ����ڰ� ������ ���̺�, ��, ���Ǿ� �� ������
SELECT * FROM user_catalog;

 2) ����� ���̺�
  ����ڰ� ���� �� ���� �����ϴ� ���̺��� collection
  ����� ������ ����
  
���̺� ����
CREATE TABLE employee(
 empno number(6),
 name varchar2(20) NOT NULL,
 salary number(8,2),
 hire_date date default sysdate,
 constraint employee_pk_empno PRIMARY KEY (empno)
);

�÷��� ������ ���� �������� ��ȸ
DESCRIBE(or DESC) ���̺��;
DESCRIBE employee;
DESC employee;

���̺� ������ ����
INSERT INTO employee (empno,name,salary)
VALUES (1000,'ȫ�浿',100.56);
Ʈ����� ������ �����͸� Ȯ��
COMMIT;


DELETE FROM dept WHERE deptno=10;
-> deptno�� foreignŰ���� �����Ұ���

- primary key & foreign key
 CREATE TABLE suser(
  id varchar2(20),
  name varchar2(20),
  CONSTRAINT susper_pk_id PRIMARY KEY (id)
 );

INSERT INTO suser (id, name)
VALUES ('dragon', 'ȫ�浿');

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
 -> foreign key ���� ���Ƕ����� suser���� id�� dragon�� ���� ������ �� ����

���̺��� ����
ADD ������ : ���̺� ���ο� �÷��� �߰�
ALTER TABLE employee ADD(addr varchar2(50));

MODIFY ������ : ���̺��� �÷��� �����ϰų� NOT NULL �÷����� ������ �� ����
ALTER TABLE employee MODIFY(salary number(10,2) NOT NULL);

DROP ������ : �÷��� ����
ALTER TABLE employee DROP column name;

���̺�� ����
RENAME employee TO employee2;

���̺� ����
DROP TABLE employee2;

SELECT * FROM employee;
SELECT * FROM sboard;
ROLLBACK;


��(View)
- ������ �׼����� �����ϱ� ����
- View�� Ȱ���ؼ� ������ ������ �ʴ� ������ ������ �� ����
- ������ ���Ǹ� ���� �ۼ��� �� ����
- �������� �������� �����ϱ� ���ؼ� ���

-������� ������ ������ ��� View�� �������� ���� ��� ���� �ο��ϱ�
>sqlplus system/��й�ȣ
SQL>conn /as sysdba
SQL>grant create view to SCOTT; <- ������� ����
 
-View ����
create[or replace] view ���̸� as ����;

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

- View�� ����
CREATE OR REPLACE VIEW emp10_view(id_number, name, sal, department_id) AS
SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno = 10;
[����] CREATE VIEW������ �� ��Ī�� �����ϴ� ��� ����͸��� ���� ������ ������ �����ؾ� ��

- View ����
DROP VIEW emp10_view;

������(Sequence)
������ ���� �������ִ� ����Ŭ ��ü
�������� �����ϸ� �⺻Ű�� ���� ���������� �����ϴ� �÷��� �ڵ�������
������ �� ����.
���� primary key���� �����ϱ� ���� ���

-������ ����
CREATE SEQUENCE test_seq
start with 1
increment by 1
maxvalue 100000;

currval : ���� ���� ��ȯ
nextval : ���� ���������� ���� ���� ��ȯ

SELECT test_seq.nextval FROM dual;
SELECT test_seq.currval FROM dual;

-������ ����
[����] start with�� ������ �� ����
ALTER SEQUENCE test_seq
increment by 2;

-������ ����
DROP SEQUENCE test_seq;

�ε���(Index)
���ϴ� ������ ��ġ�� ������, ��Ȯ�ϰ�, ���������� �˾Ƴ� �� �ִ� ����� ����.
���̺��� �÷��� ���������� ������ �� Primary key�� Unique�� �����ϸ� ����Ŭ�� �ڵ�����
�� �÷��� ���� Unique Index�� ����.

-�ε��� �����
Unique Index : ������ ���� ������ �÷��� �ε��� ����
CREATE UNIQUE INDEX dname_idx
ON dept(dname);

Non Unique Index : ������ ���� ������ �ʴ� �÷��� �ε��� ����
emp���̺��� ename���� ���� ���� �׼��� �ӵ� ���
CREATE INDEX emp_ename_idx
ON emp(ename);

���Ǿ�(Sysnonym)
���Ǿ�(��ü�� �ٸ� �̸�)�� �����Ͽ� ��ü �׼����� �ܼ�ȭ

-������� ���Ŀ� ������ ��� SYNONYM�� �������� ���� ���, ���Ѻο�
>sqlplus system/��й�ȣ
SQL>conn /as sysdba
SQL> grant create synonym to SCOTT; <- ������� ����

-���Ǿ� ����
CREATE SYNONYM emp_info
FOR emp_info_view;

SELECT * FROM emp_info;

-���Ǿ� ����
DROP SYNONYM emp_info;

<2017.10.12 ����>
1.WHERE��
  - emp ���̺��� ������ 25,000 �̻��� ����̸��� ������ ���.
    ��, ������ alias�� ann_salary�� �����Ͽ� ���
SELECT ename, sal*12 "ann_salary"
FROM emp
WHERE sal*12 > 25000;

  - emp ���̺��� ������ 2000~3000�� ����� �̸�,���� ���
SELECT ename,sal FROM emp
WHERE sal BETWEEN 2000 AND 3000;
  
2. ORDER BY��
  - ��� ����� �����ȣ, �̸�, ���� ���. 
    ��,���� �������� ������������ �����ؼ� ���
SELECT empno, ename, sal
FROM emp
ORDER BY sal;

3. GROUP BY��
  - emp ���̺��� �μ��� ��� �޿��� ���
    ��, �Ҽ����� �����ϰ� ���
SELECT deptno, ROUND(AVG(sal))
FROM emp
GROUP BY deptno;

  - emp ���̺��� �μ��� �޿� �Ѿװ� ��ձ޿� ���
SELECT deptno, SUM(sal) "�޿� �Ѿ�", ROUND(AVG(sal)) "�޿� ���"
FROM emp
GROUP BY deptno;

4. HAVING �Լ�
  - �μ��� ��� �޿��� 2000�̻��� �μ��� ��ȣ�� �μ��� ��� �޿� ���
SELECT deptno, ROUND(AVG(sal)) "��� �޿�"
FROM emp
GROUP BY deptno
HAVING AVG(sal) >= 2000;
  - �μ��� �ִ� ������ ���ϰ�, �ִ� �޿��� 3000�̻��� �μ��� ���
SELECT deptno, MAX(sal)
FROM emp
GROUP BY deptno
HAVING MAX(sal)>= 3000;

5. JOIN
  - �̸��� JAMES�� ����� �μ����� ���
SELECT e.ename, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND e.ename = 'JAMES';

SELECT e.ename, d.dname
FROM emp e JOIN dept d
ON e.deptno = d.deptno
AND e.ename = 'JAMES';

6. SUBQUERY
  - ������� ��� �޿����� �� ���� �޿��� �޴� ����� �̸�, ������ ���
SELECT ename, sal FROM emp
WHERE sal > (SELECT AVG(sal) FROM emp);

  - ���� 3000�̻� �޴� ����� �Ҽӵ� �μ��� ������ �μ��� �ٹ��ϴ� ������� �̸��� ���� ���
SELECT ename, sal FROM emp
WHERE deptno IN (SELECT deptno FROM emp
                 WHERE sal>=3000);
                 





