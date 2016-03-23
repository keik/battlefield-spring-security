create table users (
  id varchar(256),
  password varchar(256),
  enabled boolean
);

create table authorities (
  user_id varchar(256),
  authority varchar(256)
);
