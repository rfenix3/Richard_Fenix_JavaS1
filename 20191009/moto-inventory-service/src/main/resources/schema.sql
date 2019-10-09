create schema if not exists moto_inventory;
use moto_inventory;

create table if not exists motorcycle (
	id int not null auto_increment primary key,
    vin varchar(20) not null,
    make varchar(20) not null,
    model varchar(20) not null,
    year varchar(4) not null,
    color varchar(20) not null
);


create table if not exists users(
	username varchar(50) not null primary key,
	password varchar(100) not null,
	enabled boolean not null
);

create table if not exists authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username));
	create unique index ix_auth_username on authorities (username,authority
);

insert into users (username, password, enabled) values ('staff', '$2a$10$dY7gLBF332Zu3WpCAc/Csu6z4yceAakYg4drmVzpMZDVOP0Xs2zwa', true);
insert into users (username, password, enabled) values ('salesPerson', '$2a$10$J0dizAqMTpO.cM8MlRmgFeSYujDGLbhVPKfU2JLxMWgwy1XWv0ieW', true);
insert into users (username, password, enabled) values ('salesManager', '$2a$10$aNMS12bF3QeWT8yPub4Noen4ssDeQhaAahJ.1WX2GgN4Ur8W9FLQS', true);

insert into authorities (username, authority) values ('staff', 'ROLE_STAFF');
insert into authorities (username, authority) values ('salesPerson', 'ROLE_SALES_PERSON');
insert into authorities (username, authority) values ('salesPerson', 'ROLE_STAFF');
insert into authorities (username, authority) values ('salesManager', 'ROLE_SALES_MANAGER');
insert into authorities (username, authority) values ('salesManager', 'ROLE_SALES_PERSON');
insert into authorities (username, authority) values ('salesManager', 'ROLE_STAFF');

