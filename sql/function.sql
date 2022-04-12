## 함수

### 1.단일행함수
#### 문자열함수
-- 대문자
select upper('SEoul'), ucase('seOUL') from emp;
-- 소문자
select lower(ename), lcase(ename) from emp;
-- 자르기
select substring('AaBbCc', 3, 2);
select substr('AaBbCc', 3, 2);
-- 더하기
select concat('java', 'world');
select concat('java', 'world','aaa','bbb');
select 'java'+'world';
select '12'+'34';
select '12'+'34aa';
select 'aaa12'+'34';
select lpad('msg', '10', '#');
select lpad('ABCDE', '10', '#');
select rpad('msg', '10', '#');
select rpad('ABCDE', '10', '#');
select concat('시작', '    aa bb cc     ', '끝');
select concat('시작', trim('    aa bb cc    '), '끝');
select concat('시작', rtrim('     aa bb cc     '), '끝');
select concat('시작', ltrim('    aa bb cc    '), '끝');
select concat('시작', trim('#' from '####aa bb cc####'), '끝');

#### 숫자함수
-- 절대값
select abs(1111), abs(-1111);
select 4+2, 4-2, 4*2, 4/2;
select 5+2, 5-2, 5*2, 5/2, floor(5/2) as '몫', mod(5,2);
select ceiling(3.14), round(3.14), round(3.56), round(3.14, 1), round(3.56, 1);

#### 날짜함수
-- 날짜
select curdate(), current_date();
-- 시간
select curtime(), current_time();
-- 날짜, 시간
select now(), sysdate(), current_timestamp();
select date_format(curdate(), '%Y.%m.%d');

select period_diff(date_format(curdate(), '%Y%m'), date_format(hiredate, '%Y%m')) from emp;
select hiredate
		,adddate(hiredate, interval 1 day)
        ,adddate(hiredate, interval 1 month)
        ,adddate(hiredate, interval 1 year)
        from emp;

### 2.형변환
select now(), cast(now() as date);
select cast(-1 as unsigned);
select cast('18446744073709551615' as signed);
select cast('1234' as binary)+1;

### 3.그룹함수
select count(comm), count(*) from emp;
select sum(sal), max(sal), min(sal), avg(sal) from emp;
select ename, max(sal) from emp;
select avg(sal) from emp where deptno=10;
select avg(sal) from emp where deptno=20;
select avg(sal) from emp where deptno=30;
-- 그룹의 조건
select deptno, avg(sal) from emp where deptno>10 group by deptno;
select deptno, avg(sal) from emp where avg(sal)>1000 group by deptno;
select deptno, avg(sal) from emp group by deptno having avg(sal)>2000;
