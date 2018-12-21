use customer;
drop table if exists address;
drop table if exists customer;
drop table if exists address_type;

create table if not exists address_type 
(
    addr_type_cd varchar(2) not null unique primary key,
    addr_type_label varchar(30) not null unique
);

create table if not exists customer
(
	cust_id integer not null auto_increment primary key,
    first_name varchar(30) not null,
    last_name varchar(50) not null
)
auto_increment=30000;

create table if not exists address
(
	addr_id integer not null auto_increment primary key,
    addr_type_cd varchar(2) not null,
    cust_id integer not null,
    street1 varchar(50) not null,
    street2 varchar(50) null,
    city varchar(50) not null,
    state varchar(2) not null,
    zip varchar(9) not null,
    foreign key (cust_id)
		references customer(cust_id)
)
auto_increment=50000;

insert into address_type 
values ('HM', 'Home');

insert into customer (first_name, last_name)
values ('Mike', 'Nolan');
-- commit;
-- select @customer1=id as id from customer.class where id=last_insert_id();
select @customer1 := last_insert_id() as id;

insert into customer (first_name, last_name)
values ('Mary', 'Nolan');

insert into address(addr_type_cd, cust_id, street1, city, state, zip)
values ('HM', @customer1, '1001 Cormar Dr', 'Lake Zurich', 'IL', '600461200');

select * from customer;
select * from address;