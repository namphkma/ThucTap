create database thuc_tap;
use thuc_tap;
create table users(
	id int primary key auto_increment,
    username varchar(100) not null,
    password varchar(200) not null
);
create table product(
	id int primary key auto_increment,
    name varchar(200) ,
    price float ,
    user_id int,
    foreign key (user_id) references users(id)
)