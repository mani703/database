## 클러스트형 인덱스
## 보조 인덱스

create table ex10(
	num1 int primary key,
    num2 int,
    num3 int
);

show index from ex10;
alter table ex10 modify column num2 int unique;
create index idx_ex10_num3 on ex10(num3);
drop index idx_ex10_num3 on ex10;

create table ex11(
	num1 int unique,
    num2 int,
    num3 int
);
create table ex12(
	num1 int not null unique,
    num2 int,
    num3 int
);
create table ex13(
	num1 int not null unique,
    num2 int,
    num3 int primary key
);

alter table ex13 drop primary key;
alter table ex13 add primary key (num3);

show index from ex13;
insert into ex13 values (1,1,1);
insert into ex13 values (2,2,3);
insert into ex13 values (4,4,4);
insert into ex13 values (3,3,2);
select * from ex13;
select * from ex13 where num3>0.01;
select * from emp where empno>1;

delete from ex13 where num1>0;

create table ex14(
	num int primary key,
    content varchar(1000)
);
delete from ex14 where num>0;
insert into ex14 values (1, '인덱스가 없더라도 데이터베이스를 작동하는데는 문제가 없습니다. 하지만 인덱스는 데이터베이스의 성능(속도)를 크게 좌우하는 요소입니다. 데이터베이스가 크면 클 수록, 인덱스가 반드시 필요해질 것입니다. (책이 두꺼울 수록 원하는 내용을 찾기 힘들고, 정렬이나 <찾아보기>, <목차> 등이 필요해지는 원리)');
insert into ex14 values (2, '인덱스를 사용하는 SQL을 만들어 효율적으로 사용한다면 매우 빠른 응답 속도를 얻을 수 있고, 쿼리의 부하가 줄어들기 때문에 시스템 전체 성능이 향상됩니다. 하지만 인덱스는 데이터베이스에 추가적인 공간을 할당해줘야 하고, 잘못 사용할 경우 성능이 오히려 크게 떨어질 수 있습니다. (ex. 변경 작업이 자주 일어나는 경우, 인덱스가 적절하지 않은 경우)');
insert into ex14 values (3, 'MySQL에서 인덱스의 종류는 두 가지가 있습니다.');
insert into ex14 values (4, '클러스터형 인덱스(Clustered Index)는 사전에서 가나다 순으로 찾기 좋게 정렬되어 있고, 책의 모서리에 ㄱ, ㄴ, ㄷ 이런 표시를 이용해서 찾을 수 있는 방식과 유사합니다.');
insert into ex14 values (5, '보조 인덱스는 책의 <목차>나 <찾아보기> 페이지를 펴서 원하는 내용의 페이지를 확인할 수 있는 방식과 유사합니다.');

use scott;
select * from ex14 where content like '%클러스터형%';
create fulltext index idx_ex14_content on ex14(content);
select * from ex14 where match (content) against ('%클러스터형%' in boolean mode);