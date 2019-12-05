 
mysql -u root;
create database academy default charset utf8;
use academy;

create table if not exists groups(
	Id int primary key auto_increment not null,
	name varchar(10) unique not null CHECK(name != ''),
	rating int not null CHECK(rating >= 0 AND rating <= 5),
	year int not null CHECK(rating >= 1 AND rating <= 5)
);

create table if not exists departments(
	Id int primary key auto_increment not null ,
	financing decimal(5,2) default 0 not null CHECK(financing > 0),
	name varchar(10) unique not null CHECK(name != '')
);

create table if not exists faculties(
	Id int primary key auto_increment not null ,
	name varchar(100) unique not null CHECK(name != '')
);

create table if not exists teachers(
	Id int primary key auto_increment not null,
	employmentDate date not null CHECK(employmentDate > '01-01-1990'),
	name varchar(8000) not null CHECK(name != ''),
	premium decimal(5,2) default 0 not null CHECK(premium > 0),
	salary decimal(5,2) not null CHECK(salary > 0 OR salary = 0),
	surname varchar(8000) not null CHECK(surname != '')
);