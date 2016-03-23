create table users (
  id varchar(256) not null primary key,
  password varchar(256) not null,
  enabled boolean not null
);

create table authorities (
  user_id varchar(256) not null,
  authority varchar(256) not null,
  constraint fk_authorities_users foreign key(user_id) references users(id)
);
