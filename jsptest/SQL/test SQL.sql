create database jsptest;
use jsptest;
create table board(
bno int auto_increment primary key,
btitle varchar(50),
bcontent varchar(500),
bwriter varchar(50),
bpassword varchar(50),
bdate datetime default now(),
bview int

);