## MEMBER

CREATE TABLE IF NOT EXISTS MEMBER (

                                      member_id int(10) not null primary key,

                                      username varchar(50) not null,

                                      email varchar(50) not null,

                                      name varchar(50) not null,

                                      phone_Number varchar(15) not null,

                                      password varchar(255) not null,

                                      gender ENUM('male','female','other'),

                                      birthdate DATE,

                                      student_id varchar(20),

                                      image_id int,

                                      enrollment_status ENUM ('enroalled','supended','graudated'),        membership_level ENUM ('admin','full','associate','guest'),        is_active bool

);

## SUBJECT

CREATE TABLE IF NOT EXISTS SUBJECT (

                                       subject_code int PRIMARY KEY auto_increment,

                                       subject_name VARCHAR(100) not null,

                                       grade TINYINT ,

                                       semester TINYINT ,

                                       professor VARCHAR(50) ,

                                       study_opened BOOLEAN not null

);

## STUDY

CREATE TABLE IF NOT EXISTS STUDY (

                                     study_id int PRIMARY KEY auto_increment,

                                     subject_code int,

                                     title VARCHAR(100),

                                     status ENUM('active', 'completed', 'pending'),

                                     schedule VARCHAR(50),

                                     start_date DATE,

                                     end_date DATE,

                                     Established_by VARCHAR(10),

                                     foreign key (subject_code) references SUBJECT (subject_code)

);

## **MembershipFeePayment**

create table if not exists MembershipFeePayment
(
    member_id int not null ,
    payment_date date not null,
    amount int not null,
    expiration_date date not null,
    CONSTRAINT fk_member_id foreign key (member_id) references member(member_id)
        on update cascade
);

## **STUDY_HISTORY**

CREATE TABLE IF NOT EXISTS STUDY_HISTORY(

                                            study_id int not null auto_increment ,

                                            week int not null ,

                                            study_date date not null ,

                                            title VARCHAR(100) not null ,

                                            presenter VARCHAR(50) ,

                                            notes VARCHAR(1000),

                                            PRIMARY KEY (study_id, week),

                                            CONSTRAINT fk_study_id foreign key (study_id) references STUDY(study_id) on DELETE CASCADE

);