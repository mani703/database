select * from emp;
select * from dept;
select loc, dname from dept;

-- 별칭
select deptno as "부서 번호", dname as "부서명", loc as "지역" from dept;
select deptno as 부서번호, dname as 부서명, loc as 지역 from dept;
select deptno 부서번호, dname 부서명, loc 지역 from dept;

-- 테이블명의 별칭은 as 불가 (mysql 제외)
select 부서정보.deptno, dname, loc from dept as 부서정보;


select empno, ename, sal from emp where sal<>800;
select empno, ename, sal from emp where sal!=800;

select empno, ename from emp where ENAME='SMITH';
select empno, ename, hiredate from emp;
select empno, ename, hiredate from emp where hiredate>'1985/01/01';
select deptno, dname from dept where deptno=10 or deptno=20;
select deptno, dname from dept where deptno>10 and deptno<40;
select deptno, dname from dept where not deptno=10;
select deptno, dname from dept where deptno!=10;

select deptno, dname from dept where deptno>=10 and deptno<=30;
select deptno, dname from dept where deptno between 20 and 30;

select deptno, dname from dept where deptno in (10, 20, 30);
select deptno, dname from dept where DNAME in ('accounting', 'research', 'sales');

-- like 패턴
-- % (0이상 아무것)
-- _ (1개가 아무것)
select empno, ename from emp where ename like 's%';
select empno, ename from emp where ename like '%s';
select empno, ename from emp where ename like '%a%';
select empno, ename from emp where ename like '_a%';
select empno, ename from emp where ename like '____';

select empno, ename, sal, comm from emp;
select empno, ename, sal, comm from emp where comm is null;
select empno, ename, sal, comm from emp where comm is not null;

select empno, ename, HIREDATE from emp order by HIREDATE;
select empno, ename, HIREDATE from emp order by HIREDATE desc;

-- select [all, distinct] 컬럼명 from 테이블명 where 조건 order by 순서
select empno, ename from emp where empno<7777 order by empno desc;

-- 두가지 컬럼이 중복이 되는것을 제외
select distinct deptno, ename from emp; 