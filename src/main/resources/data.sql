insert into users (id, password, enabled) values ('user', 'user', true);
insert into authorities (user_id, authority) values ('user', 'ROLE_ADMIN');
