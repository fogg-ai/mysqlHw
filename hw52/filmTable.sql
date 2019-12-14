-- 1
select * FROM movies
ORDER BY title;
-- 2
select * FROM movies
ORDER BY realeseYear;
-- 3
select * FROM movies
ORDER BY rating;
-- 4
select * FROM movies
WHERE realeseYear IN(2018);
-- 5
select * FROM moviegenres
join movies on movies.movieId = moviegenres.movieId
join genres on genres.genreId = moviegenres.genreId
where genres.genreName = 'dram';

-- 6
select * FROM movieactor
join movies on movies.movieId = movieactor.movieId
join actors on actors.actorId = movieactor.actorId
where actors.firstName = 'Jeson' AND actors.lastName = 'Mamoa';

-- 7
select movies.movieId,movies.directorId,movies.title,movies.realeseYear,movies.rating,movies.plot,movies.movieLength,directors.firstName,directors.lastName,directors.nationality,directors.birth
FROM movies
join directors on movies.directorId = directors.directorId
where directors.firstName = 'Chad' AND directors.lastName = 'Stahelskiy';



create database filmLife default charset utf8;

use filmLife;

create table genres(
	genreId int primary key auto_increment,
    genreName varchar(100) unique
);

create table movieGenres(
	movieId int,
    genreId int
);
create table movies(
	movieId int primary key auto_increment,
    directorId int,
    title varchar(30) not null check(title != ''),
    realeseYear int check(realeseYear <= 2019),
    rating int,
    plot varchar(8000) not null,
    movieLength varchar(30)
);

create table movieActor(
	movieId int,
    actorId int
);


create table actors(
	actorId int primary key auto_increment,
    firstName varchar(30) not null,
    lastName varchar(30) not null,
    nationality varchar(30) not null,
	birth date not null
);

create table directors(
	directorId int primary key auto_increment,
    firstName varchar(30) not null check(firstName != ''),
    lastName varchar(30) not null check(lastName != ''),
    nationality varchar(30) not null check(nationality != ''),
	birth date not null
);

Alter table movieGenres add constraint fk_gender foreign key (genreId) references genres (genreId) on update cascade on delete cascade;
Alter table movieGenres add constraint fk_movie	foreign key (movieId) references movies (movieId) on update cascade on delete cascade;
Alter table movies add constraint fk_directors foreign key (directorId) references directors (directorId) on update cascade on delete cascade;
Alter table movieActor add constraint fk_movieActor foreign key (movieId) references directors (directorId) on update cascade on delete cascade;
Alter table movieActor add constraint fk_actor foreign key (actorId) references actors (actorId) on update cascade on delete cascade;

use filmLife;

insert genres (genreId,genreName)
       values(1,'dram'),
       (2,'action'),
       (3,'crime'),
       (4,'fantaci'),
       (5,'comedy');
       
insert directors(directorId,firstName,lastName,nationality,birth)
	values  (1,'James','Cameron','canada','1954-07-16'),
			(2,'James','Van','malaysia','1977-01-26'),
			(3,'Chad','Stahelskiy','usa','1951-09-20'),
            (4,'Rayan','Kygler','usa','1986-05-23'),
            (5,'Aleksandr','Igudin','russia','1972-05-13');

insert actors(actorId,firstName,lastName,nationality,birth)
		values(1,'Кate','Vislet','englang','1975-10-05'),
        (2,'Leo','Di Caprio','usa','1974-11-11'),
        (3,'Jeson','Mamoa','usa','1979-04-01'),
        (4,'Kianu','Rivz','livan','1964-04-01'),
        (5,'Heili','Berry','usa','1966-07-15');


insert movies(movieId,directorId,title,realeseYear,rating,plot,movieLength)
values (1,1,'titanic',1997,97,'not swim titanik','3hourse'),
       (2,2,'aquaman',2018,92,'swim man','2h 22m'),
       (3,3,'john wick 2',2017,92,'kimoviesller','2h 2m'),
       (4,4,'black panther',2018,91,'Vacanda','2h 15m'),
       (5,4,'krid',2015,94,'box','2h 13m'),
       (6,3,'john wick',2014,93,'kills','2h 14m'),
       (7,3,'john wick 3',2019,92,'kills','2h 10m'),
       (8,5,'One Day of Summer',2018,82,'summer','1h 40m'),
       (9,3,'Vendetta',2005,93,'kills','2h 13m'),
       (10,1,'Avatar',2009,87,'Planets','2h 42m');


insert moviegenres (movieId,genreId)
       values(1,1),
       (2,2),
       (3,3),
       (4,4),
       (5,1),
       (6,3),
       (7,3),
       (8,5),
       (9,1),
       (10,4);
       

       
insert movieactor(movieId,actorId)
	values (1,1),
		(1,2),
        (2,3),
        (3,4),
        (3,5);
       