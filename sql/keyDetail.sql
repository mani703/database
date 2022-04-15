create table ex20(
	num1 int,
    num2 int,
    name1 varchar(3),
    primary key (num1)
);
insert into ex20 values (1111, 1000, 'aaa');
insert into ex20 values (2222, 2000, 'aaa');
insert into ex20 values (3333, 3000, 'aaa');

create table ex21(
	num3 int,
	num4 int,
    name2 varchar(4),
    constraint pk_ex21_num3 primary key (num3),
    constraint fk_ex21_num4 
		foreign key (num4) references ex20(num1)
);
insert into ex21 values (1100, 1111, 'aaaa');
insert into ex21 values (2200, 2222, 'bbbb');

create table ex22(
	num3 int,
	num4 int,
    name2 varchar(4),
    constraint pk_ex21_num3 primary key (num3)
);
alter table ex22 add foreign key(num4) references ex20 (num1);
insert into ex22 values (1100, 1111, 'aaaa');
insert into ex21 values (2200, 4444, 'bbbb');

create table ex23(
	num3 int,
	num4 int,
    name2 varchar(4),
    constraint pk_ex23_num3 primary key (num3)
);
alter table ex23 add 
	constraint fk_ex23_num4
	foreign key (num4)
    references ex20 (num1);
insert into ex23 values (1100, 1111, 'aaaa');
insert into ex23 values (2200, 4444, 'bbbb');
alter table ex23 drop constraint fk_ex23_num4;

drop table ex22;
drop table ex21;
drop table ex20;

drop table ex24;
create table ex24(
	num1 int primary key,
    num2 int default 1111,
    num3 varchar(4) default '이름없음',
    num4 int not null default 2222,
    num5 datetime default now(),
    num6 int not null
);
insert into ex24 values (1, 1000, 'aaaa', 1000, now(), 1);
insert into ex24 values (2, null, null, null, null);
insert into ex24 (num1, num6) values (4, 4);
select * from ex24;

create table ex25(
	num1 int primary key,
    num2 int,
    constraint ch_ex25_num2 check (num2 < 10)
);
insert into ex25 values (1, 1);
insert into ex25 values (2, 2);
insert into ex25 values (3, 10);

drop table ex26;
create table ex26(
	num1 int primary key,
    num2 char(1),
    constraint ch_ex26_num2 check (num2 in ('남', '여')) 
);
insert into ex26 values (1, '남');
insert into ex26 values (2, '여');
insert into ex26 values (3, '?');

create table ex27(
	num1 int primary key auto_increment,
    num2 int
);
insert into ex27 values (1111,1);
insert into ex27 values (null, 2);
insert into ex27 (num2) values (3);
select * from ex27;