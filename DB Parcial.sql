SET GLOBAL time_zone = '-3:00';
drop database parcialLab;
create database parcialLab;
use parcialLab;


create table countries(
id int auto_increment primary key,
name varchar(50) unique
);

create table provinces(
id int auto_increment primary key,
name varchar(50),
id_country int,
constraint fk_country foreign key (id_country) references countries(id)
);

create table cities(
id int auto_increment primary key,
name varchar(50),
prefix_number int,
id_province int,
constraint fk_province foreign key (id_province) references provinces(id)
);

create table users(
id int auto_increment primary key,
firstname varchar(50),
lastname varchar(50),
dni int unique,
username varchar(50) unique,
password varchar(50),
id_city int,
user_type enum('ADMIN', 'EMPLOYEE', 'CUSTOMER'),
is_active boolean,
constraint fk_city_user foreign key (id_city) references cities(id)
);

create table fees(
id int auto_increment primary key,
source_city_id int,
destination_city_id int,
price_per_minute float,
cost_per_minute float,
constraint fk_source_city_fee foreign key (source_city_id) references cities(id),
constraint fk_destination_city_fee foreign key (destination_city_id) references cities(id)
);

create table telephone_lines(
id int auto_increment primary key,
line_number varchar(50) unique,
line_type enum('MOBILE', 'RESIDENTIAL'),
id_user int,
status enum('SUSPENDED', 'ACTIVE', 'DELETED'),
constraint fk_user_telephone_line foreign key (id_user) references users(id)
);

create table invoices(
id int auto_increment primary key,
calls int,
total_cost float,
total_price float,
date_creation date,
date_expiration date,
id_telephone_line int,
id_user int,
paid boolean,
constraint fk_telephone_line foreign key (id_telephone_line) references telephone_lines(id),
constraint fk_user_invoice foreign key (id_user) references users(id)
);

create table calls(
id int auto_increment primary key,
source_number varchar(50),
destination_number varchar(50),
price_per_minute float,
duration_secs int,
total_cost float,
total_price float,
id_invoice int,
source_city_id int,
destination_city_id int,
constraint fk_invoice foreign key (id_invoice) references invoices(id),
constraint fk_source_city_call foreign key (source_city_id) references cities(id),
constraint fk_destination_city_call foreign key (destination_city_id) references cities(id)
);