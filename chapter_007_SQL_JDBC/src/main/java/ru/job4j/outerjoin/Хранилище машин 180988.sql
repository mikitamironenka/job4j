--create table car_body (
--id serial primary key,
--name varchar(200)
--);

--create table engine (
--id serial primary key,
--name varchar(200)
--);

--create table transmission (
--id serial primary key,
--name varchar(200)
--);

--заполняем данными
--insert into car_body(name) values('седан');
--insert into car_body(name) values('минивэн');
--insert into car_body(name) values('хэтчбек');
--insert into car_body(name) values('универсал');
--insert into car_body(name) values('купе');
--insert into car_body(name) values('кабриолет');
--insert into car_body(name) values('родстер');

--insert into engine(name) values('1.2');
--insert into engine(name) values('1.3');
--insert into engine(name) values('1.6');
--insert into engine(name) values('2.0');
--insert into engine(name) values('2.5');
--insert into engine(name) values('3.0');
--insert into engine(name) values('3.2');

--insert into transmission(name) values('механическая');
--insert into transmission(name) values('гидромеханическая');
--insert into transmission(name) values('гидравлическая');
--insert into transmission(name) values('электромеханическая');
--insert into transmission(name) values('автоматическая');

--создаём таблицу машину со ссылками на другие таблицы

--create table car(
--id serial primary key,
--name varchar(200),
--carbody_id int references car_body(id),
--engine_id int references engine(id),
--transmission_id int references transmission(id)
--);

--создаём авто
--insert into car(name, carbody_id, engine_id, transmission_id) values('ваз', 1, 2, 1);
--insert into car(name, carbody_id, engine_id, transmission_id) values('киа', 3, 3, 5);
--insert into car(name, carbody_id, engine_id, transmission_id) values('хонда', 4, 4, 5);
--insert into car(name, carbody_id, engine_id, transmission_id) values('форд', 5, 3, 4);

--Создать SQL запросы:
--1. Вывести список всех машин и все привязанные к ним детали.

--select c.name, b.name, e.name, t.name 
--from car as c 
--left outer join car_body as b on c.carbody_id = b.id
--left outer join engine as e on c.engine_id = e.id
--left outer join transmission as t on c.transmission_id = t.id;


--2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.

--select b.name from car_body as b left outer join car as c on c.carbody_id = b.id where c.id is null;
--select e.name from engine as e left outer join car as c on c.engine_id = e.id where c.id is null;
--select t.name from transmission as t left outer join car as c on c.transmission_id = t.id where c.id is null;


