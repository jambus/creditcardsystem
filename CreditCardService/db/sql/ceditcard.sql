use master
if exists(select * from sysdatabases where name='creditcard')
	drop database stuDB
go
create database creditcard
ON  PRIMARY  --默认就属于PRIMARY主文件组，可省略
(
 /*----数据文件的具体描述--*/
 NAME='creditcard_data',  --主数据文件的逻辑名
 FILENAME='D:\creditcard_data.mdf',  --主数据文件的物理名
 SIZE=5mb,  --主数据文件初始大小
 MAXSIZE=100mb,  --主数据文件增长的最大值
 FILEGROWTH=15%   --主数据文件的增长率
)
LOG ON
(
  /*----日志文件的具体描述，各参数含义同上--*/
  NAME='creditcard_log',
  FILENAME='D:\creditcard_log.ldf',
  SIZE=2mb,
  FILEGROWTH=1 mb
)
go
use creditcard
go
if exists(select * from sysobjects where name='userpass')
	drop table userpass
create table userpass(
	userName varchar(20) references userinfo(userName),
	password varchar(255) not null
)
if exists(select * from sysobjects where name='userinfo')
	drop table userinfo
create table userinfo(
	userName varchar(20) primary key,
	birthday smalldatetime,
	address varchar(50) not null,
	salary smallmoney,
	tel varchar(20),
	mail varchar(20)
)
go 
if exists(select * from sysobjects where name='cardinfo')
	drop table cardinfo
create table cardinfo(
	userName varchar(20) references userinfo(userName),
	cardNumber varchar(20) references business(cardNumber),
	amount smallmoney,
	balance smallmoney,
	status varchar(20),
)
go
if exists(select * from sysobjects where name='business')
	drop table business
create table business(
	cardNumber varchar(20) primary key,
	pay smallmoney,
	earn smallmoney,
	date smalldatetime,
	note varchar(50),
)

select * from userpass
select * from userinfo
select * from cardinfo
select * from business

delete from userpass
delete from cardinfo
delete from userinfo
delete from business
