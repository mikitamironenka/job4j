create table if not exists itemsTest (
    id serial primary key,
    name varchar(200),
    description varchar(500),
    create_time timestamp
);