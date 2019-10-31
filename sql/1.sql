create table skwyverns (
id int not null auto_increment,
title varchar(255),
name varchar(50),
memo varchar(255),
primary key (id)
);

select * from skwyverns;

insert into skwyverns values(1,'asdf','asdf','asdf');

drop table skwyverns;

create table qa (
id int not null auto_increment,
title varchar(255),
name varchar(50),
memo varchar(255),
primary key (id)
);

select * from qa;

insert into qa values(1,'asdf','asdf','asdf');

drop table qa;

