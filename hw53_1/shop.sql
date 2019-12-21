CREATE DATABASE shop default charset utf8;

use shop;


INSERT goods (name,cost,quantity) values ('Tomatoes',4.50,100),
                                         ('Cucumbers',3.30,100),
                                         ('Milk 1L',10.80,30),
                                         ('Tea 1L',2.50,80),
                                         ('Water 1L',7.50,130),
                                         ('Corn 1 bank',20.30,120);

create table buyers
    (
    id int auto_increment
    primary key,
    first_name varchar (50) not null,
    last_name varchar (50) not null,
    login varchar (15) unique ,
    password varchar  (20) ,
    age varchar (30)
    );

create table goods
(
    id       int auto_increment
        primary key,
    name     varchar(50) not null,
    cost     decimal(7, 2) not null,
    quantity int,
    constraint quantity
        check (`quantity` <> 0)
);

create table orders
(
    id       int auto_increment
        primary key,
    name     varchar(50) not null,
    cost     decimal(7, 2) not null,
    quantity int,
    constraint quantity
        check (`quantity` <> 0)
);

create table sellers
(
    id         int auto_increment
        primary key,
    first_name varchar(50) not null,
    last_name  varchar(50) not null,
    login      varchar(15) unique,
    password   varchar(20),
    age        int
);
