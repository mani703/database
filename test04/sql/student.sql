use scott;

create table stu01(
	num int,
	name varchar(5) not null,
	kor int check (kor>=0 and kor<=100),
	eng int check (eng>=0 and eng<=100),
	math int check (math>=0 and math<=100),
	primary key(num)
);

insert into stu01 values (1, 'user1', 90, 80, 70);
insert into stu01 values (2, 'user2', 91, 81, 71);
insert into stu01 values (3, 'user3', 92, 82, 72);
insert into stu01 values (4, 'user4', 92, 82, 71);
commit;
select num, name, kor, eng, math, (kor+eng+math)/3 from stu01;