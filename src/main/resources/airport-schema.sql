drop table if exists airport CASCADE;
create table airport(
id integer AUTO_INCREMENT,
type varchar(255),
price float not null,
capacity integer not null,
primary key (id));