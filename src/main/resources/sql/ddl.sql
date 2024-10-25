create table member(
	seq INT not null auto_increment,
	id varchar(20) not null,
	name varchar(50) not null,
	gender char(1),
	phone_number varchar(11),
	grade int,
	constraint member_pk primary key(seq)

);