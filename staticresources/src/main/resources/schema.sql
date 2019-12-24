
create table users
(
    id       int auto_increment
        primary key,
    login    varchar(50) not null unique,
    password varchar(50) not null
);
