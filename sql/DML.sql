SELECT * FROM test01.bbs01;

/* msql 다중주석 */
-- 한줄주석

-- 입력(insert)
-- insert into 테이블명 (컬럼명, 컬럼명, ....) values (값, 값, ...);
-- insert into 테이블명 values (값, 값, ...);
insert into bbs01 values (1,'test1','tester','test');
-- 숫자는 그냥 작성
-- 문자열 '문자열'
-- 문법상 쿼리 구문은 대소문자 구분이 없으나 값은 구분 있음
insert into BBS01 values (2,'TEST2','TESTER','TEST');
INSERT INTO bbs01(num,name,sub,content) values (3,'tester','test3','test');
insert into bbs01 (num, sub, name)	values (4, 'test3', 'tester');
insert into bbs01 values ('5', 'test5', 'tester', 'tset');
insert into bbs01 values (6, 'test6', 'tester', '');

-- 수정(update)
-- update 테이블명 set 컬럼명=바꿀내용, 컬럼명= 바꿀네용, ... where 조건;
update bbs01 set content='bbb', name='테스터' where num=4;

-- 삭제(delete)
-- delete from 테이블명 where 조건;
delete from bbs01 where num<4;

-- 보기(select)
-- select 컬럼명, 컬럼명, ... from 테이블명 [ where 조건 ];
select * from bbs01;
select num, sub, name, content from bbs01;
select num, sub, name, content from bbs01 where num=5;

-- DML ( Data Manipulation Language )