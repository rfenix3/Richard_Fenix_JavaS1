create schema if not exists auth_server;
use auth_server;

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
-- plainUser password is set as 'plain';
insert into users (username, password, enabled) values ('plainUser', '$2a$10$YtHfmStH61vl6l.jQVtXruHjV9VkdMfBu0KzN1k5W5MlCN6bcIFmi', true);
-- managerUser password is set as 'manager';
insert into users (username, password, enabled) values ('managerUser', '$2a$10$/NxnW5Bqhoii7oeaSHS9eeQ4M24muRumJB8gmKizAO85qKJck7kpu', true);
-- adminUser password is set as 'admin';
insert into users (username, password, enabled) values ('adminUser', '$2a$10$YEPk3TLdma1oPDIsXkU.VOKFfZjA5oEZQlXPnl.rQmaqTBD3PHkre', true);

insert into authorities (username, authority) values ('plainUser', 'ROLE_USER');
insert into authorities (username, authority) values ('managerUser', 'ROLE_USER');
insert into authorities (username, authority) values ('managerUser', 'ROLE_MANAGER');
insert into authorities (username, authority) values ('adminUser', 'ROLE_USER');
insert into authorities (username, authority) values ('adminUser', 'ROLE_MANAGER');
insert into authorities (username, authority) values ('adminUser', 'ROLE_ADMIN');
