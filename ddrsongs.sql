create database if not exists ddrsongs;

use ddrsongs;

drop table if exists ddrsongs;

create table ddrsongs (
	id int(10) not null auto_increment,
	songname varchar(50) not null,
	primary key(id)
);