CREATE TABLE IF NOT EXISTS MEMBER (
    member_id int(10) primary key auto_increment,
    username varchar(50) not null,
    email varchar(50) not null,
    name varchar(50) not null,
    phone_number varchar(15) not null,
    password varchar(255) not null,
    gender ENUM('male','female','other'),
    birthdate DATE,
    student_id varchar(20),
    image_id int,
    enrollment_status ENUM ('enrolled','supended','graudated'),
    membership_level ENUM ('admin','normal','guest'),
    is_active BOOL
);