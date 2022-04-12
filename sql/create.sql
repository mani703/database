create table ex01(
	num1 int,
    num2 float,
    msg1 char(6),
    msg2 varchar(6),
    msg3 text,
    nalja1 date,
    nalja2 datetime,
    nalja3 timestamp
);

drop table if exists ex02;

create table ex02(
	num int,
    name varchar(3)
);

describe ex02;
insert into ex02 values (1, 'test1');
insert into ex02 values (2, 'test2');
insert into ex02 values (3, 'test3');
insert into ex02 values (4, 'test4', now()); 
select * from ex02;

alter table ex02 add nalja date;
alter table ex02 drop nalja;
alter table ex02 modify column name varchar(5);

create table if not exists ex02(
	num int
);