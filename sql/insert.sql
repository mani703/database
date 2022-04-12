SELECT * FROM scott.ex01;

insert into ex01 values (1, 1.0, 'aaaaaa', 'bbbbbb', 'text', now(), now(), now());
insert into ex01 values (2.0, 3.14, 'aaaaaa', 'bbbbbb', 'text', now(), now(), now());
insert into ex01 values (3.3, 3.14, 'aaaaaa', 'bbbbbb', 'text', now(), now(), now());
insert into ex01 values (floor(4.4), 4.14, 'aaaaaa', 'bbbbbb', 'text', now(), now(), now());
insert into ex01 values (5, 5, '한글로작성', '한글로작성', 'text', now(), now(), now());
insert into ex01 values (6, 6, '한글로작성6', '한글로작성6', 'text', now(), now(), now());
insert into ex01 values (7, 7, '한글로작성6', '한글로작성6', 'text', '2022-04-12', now(), now());
insert into ex01 values (8, 8, '한글로작성6', '한글로작성6', 'text', cast('2022-04-12' as date), now(), now());