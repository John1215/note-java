create database note default charset "utf8";
use note;

create table notelist
(
	id int unsigned auto_increment,
        username varchar(50) not null comment '用户名',
	note_uuid varchar(50) unique not null comment '编号',
	title varchar(50) not null comment '标题',
	content varchar(500) not null comment '正文',

	primary key (id)
);

create table usr
(
        id int unsigned auto_increment,
        username varchar(50) not null comment '用户名',
	passwd varchar(50) not null comment '密码',

        primary key (id)
);