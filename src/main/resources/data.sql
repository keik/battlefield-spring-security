insert into users (id, password, enabled) values ('user', '$2a$10$mY2wz5EHa3FY0M.I6q/jPOVAyWIWFWZTjp/2En/kVoq7wcI7TTsLm' /* bcrypt('user') */, true);
insert into authorities (user_id, authority) values ('user', 'ROLE_ADMIN');
