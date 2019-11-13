create table users (
	id serial primary key,
	name character varying (50)
	
);

create table roles (
	id serial primary key,
	user_id integer references users(id),
	role character varying (50)
	
);

create table rules (
	id serial primary key,
	role character varying (50),
	rules_of_role character varying (50)

);

create table items (
	id serial primary key,
	user_id integer references users(id),
	order_of_user character varying (200)
);

create table comments (
	id serial primary key,
	item_id integer references items(id),
	comment text
);

create table attachs (
	id serial primary key,
	item_id integer references items(id),
	filename character varying(50),
	filedata bytea
);

create table category (
	id serial primary key,
	item_id integer references items(id),
	category character varying(100)
);

create table state (
	id serial primary key,
	item_id integer references items(id),
	state character varying(100)
);




insert into users(name) values ('Jack');
insert into users(name) values ('Miroslav');
insert into users(name) values ('Iosif');

insert into roles(user_id, role) values ('1', 'Admin');
insert into roles(user_id, role) values ('2', 'User');
insert into roles(user_id, role) values ('3', 'Programmer');

insert into rules(role, rules_of_role) values ('Admin', 'Get rights, get access, change relationship');
insert into rules(role, rules_of_role) values ('User', 'Create items');
insert into rules(role, rules_of_role) values ('Programmer', 'Create orders, add changes');

insert into items(user_id, order_of_user) values ('2', 'Do something one');
insert into items(user_id, order_of_user) values ('2', 'Do something two');
insert into items(user_id, order_of_user) values ('3', 'Do something strange');

insert into comments(item_id, comment) values ('1', 'comment one to do smth one');
insert into comments(item_id, comment) values ('1', 'comment two to do smth one');
insert into comments(item_id, comment) values ('2', 'comment one to do smth two');

insert into state(item_id, state) values ('1', 'in process');
insert into state(item_id, state) values ('2', 'in process');
insert into state(item_id, state) values ('3', 'complete');

insert into category(item_id, category) values ('1', '1');
insert into category(item_id, category) values ('2', '1');
insert into category(item_id, category) values ('3', '2');