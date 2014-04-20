use mysql;

drop database creditcard;
create database creditcard;

use creditcard;

drop table IF EXISTS userpass;
drop table IF EXISTS transactions;
drop table IF EXISTS cardRelationship;
drop table IF EXISTS cardinfo;
drop table IF EXISTS accountInfo;
drop table IF EXISTS userinfo;

create table userinfo(
	customerNumber INTEGER UNSIGNED not null AUTO_INCREMENT primary key,
	idNumber varchar(20) unique,
	firstName varchar(20),
	lastName varchar(20),
	birthday date,
	address varchar(50) not null,
	salary double,
	tel varchar(20),
	mail varchar(20)
);

create table accountInfo(
	accountNumber varchar(10) primary key,
	customerNumber INTEGER UNSIGNED,
	foreign key (customerNumber) references userinfo(customerNumber)
);

create table userpass( 
	userName varchar(20) primary key,
	customerNumber INTEGER UNSIGNED,
	password varchar(255) not null,
	failloginCount int,
	status varchar(1),
	foreign key (customerNumber) references userinfo(customerNumber)
);

create table cardinfo(
	cardNumber varchar(19) primary key,
	accountNumber varchar(10) references userinfo(accountNumber),
	productType varchar(3),
	cardLogo varchar(3),
	availableAmount double,
	currentAmount double,
	creditLimit double,
	cardIndicator varchar(1),
	cardEmbossName varchar(20),
	cardExpireDate date,
	cardBlockCode varchar(1),
	cardActiveCode varchar(1)
);

create table cardRelationship(
	accountNumber varchar(10),
	cardNumber varchar(19),
	foreign key (cardNumber) references cardinfo(cardNumber),
	foreign key (accountNumber) references accountInfo(accountNumber)
);

create table transactions(
	transactionReferenceNumber varchar(30) primary key,
	cardNumber varchar(19) references cardinfo(cardNumber),
	transactionCode varchar(3),
	transactionAmount double,
	transactionDate date,
	cycleFlag varchar(1),
	merchantName varchar(255),
	merchantCode varchar(10)
);

CREATE USER creditcarduser IDENTIFIED BY 'credit';
GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP ON creditcard.* TO creditcarduser;

