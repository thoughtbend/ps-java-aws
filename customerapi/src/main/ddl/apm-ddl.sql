use apmdb;

drop table if exists application;
drop table if exists business_unit;

create table business_unit
(
	business_unit_code char(2) not null primary key,
    business_unit_label varchar(50) not null,
    update_user varchar(50) not null,
    update_dt datetime not null
);

insert business_unit 
values ('EC', 'eCommerce', current_user(), current_time());

insert business_unit
values ('FN', 'Finance', current_user(), current_time());

select * from business_unit;

create table application
(
	app_id integer not null auto_increment primary key,
    app_code varchar(6) not null unique,
    app_name varchar(100) not null unique,
    business_code char(2),
    create_user varchar(50) not null,
    create_dt datetime not null,
    update_user varchar(50) not null,
    update_dt datetime not null
)
auto_increment=100;