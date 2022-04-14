create table ex04(
	num int,
    name varchar(3)
);
insert into ex04 (num) values (1111);
insert into ex04 (name) values ('tes');
insert into ex04 values (1100, 'add');
select * from ex04;

create table ex05(
	num int not null,
    name varchar(3) not null
);
insert into ex05 values(1111, 'aaa');
insert into ex05 (num) values (222);
insert into ex05 values (3333, null);
insert into ex05 values (4444, '');
insert into ex05 values ('', 'bbb');
select * from ex05;

create table ex06(
	num int unique,
    name varchar(4) unique
);
insert into ex06 values (1111, 'aaaa');
insert into ex06 values (2222, 'bbbb');
insert into ex06 values (3333, 'cccc');
insert into ex06 values (4444, 'bbbb');
insert into ex06 values (1111, 'dddd');
insert into ex06 values (null, 'eeee');
insert into ex06 values (null, 'ffff');

create table ex07(
	num1 int primary key,
    num2 int not null unique,
    num3 int
);
insert into ex07 values (1111, 1111, 1111);
insert into ex07 values (2222, 2222, 2222);
insert into ex07 values (3333, 3333, 3333);
insert into ex07 values (4444, 2222, 4444);
insert into ex07 values (2200, 5555, 4444);
select * from ex07;

create table ex08(
	num int primary key,
    idx int,
    name varchar(3)
);
insert into ex08 values (1111, 1000, 'aaa');
insert into ex08 values (2222, 2000, 'bbb');
insert into ex08 values (3333, 3000, 'ccc');

select * from ex08;

create table ex09(
	num2 int primary key,
    idx int references ex08(idx),
    name2 varchar(2)
);
insert into ex09 values (1100, 1000, 'ok');
insert into ex09 values (2200, 3000, 'ok');
insert into ex09 values (3300, 4000, 'ok');
select * from ex09;

create table ex10(
	num2 int primary key,
    idx int,
    name2 varchar(2) references ex08(name)
);
insert into ex10 values (1100, 1000, 'aaa');

create table ex12 (
	num3 int not null,
    idx int null,
    name varchar(45) null,
    constraint `pk_ex12_num3` primary key (num3),
    constraint `fk_ex12_idx`
    foreign key (idx) references ex08 (num)
);
insert into ex12 values (1000, '1111', 'a');
insert into ex12 values (2000, '2222', 'a');
insert into ex12 values (1000, '8888', 'a');
