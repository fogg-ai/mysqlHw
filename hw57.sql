-- task1

delimiter $$
CREATE PROCEDURE sp_print(
    init int,
    ult int
) begin
    SELECT directors.firstName, directors.lastName, title, rating, a.firstName as firstNameActor, a.lastName as lastNameActor from movies
                                                                                   join directors on directors.directorId = movies.directorId
                                                                                   join movieactor m on movies.movieId = m.movieId
                                                                                   join actors a on a.actorId = m.actorId where m.movieId >= init and m.movieId <= ult ;
end $$
delimiter ;
-- test
call sp_print(1,10);

-- task2
use filmlife;
delimiter $$
CREATE PROCEDURE sp_update(
    old_name_ganr varchar(30),
    new_name_ganr varchar(30)
) begin
    UPDATE
        genres set genreName = new_name_ganr where old_name_ganr = genreName;
end $$
delimiter ;

-- test
call sp_update ('crime','dom');

-- task3
delimiter $$
CREATE PROCEDURE sp_delete()
begin
     delete from directors where directors.directorId in (select directors.directorId from directors left join movies m on directors.directorId = m.directorId where m.movieId = null);

end $$
delimiter ;

-- test
call sp_delete();
