create table members(
   memNo int primary key auto_increment,
    memID char(20) unique not null,
    memPW varchar(20),
    memName varchar(30),
   memPhone varchar(13),
   memTime smallint
);

select * from members;

create table currentPc(
   pcNo int primary key auto_increment,
   cPlay boolean
);

select * from currentPc;
insert into currentPc values (null, false); // 50대 넣고 테스트 했습니다.

create table PCrecord(
    recordNo int primary key auto_increment,
    memNo int,
    sTime datetime,
    eTime datetime,
    pcNo int,
    foreign key (memNo) references members(memNo),
    foreign key (pcNo) references currentPc(pcNo)
);

create table priceTable(
    pNo int primary key,
    price int,
    hours tinyint unsigned
);

create table dayRecord(
   dNo int primary key auto_increment,
    dDate datetime,
    dayIncome int
);