select ename, (select ename from emp B where A.mgr = B.empno) 
from emp A;

select * from (select * from dept) A;

select * from dept where deptno=(select deptno from dept where deptno = 10);

select dname, (select loc from dept where deptno=10) from dept; -- 컬럼명에 오는 서브쿼리는 단일 레코드에 단일 컬럼
select * from (select loc, dname from dept) A;	-- 서브쿼리를 하나의 테이블로 인식을 한다
select * from dept where deptno=(select deptno from dept where deptno=10);
select * from dept where deptno in (select deptno from dept);

create table dept2(
	deptno int,
    dname varchar(45),
    loc varchar(45)
);

insert into dept2 (select * from dept);
select * from dept2;

create table dept3 as (select * from dept);
select * from dept3;

create table dept4 as (select * from dept where 0=1);
select * from dept4;