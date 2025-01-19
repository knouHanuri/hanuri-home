
-- EDIT BY LSH 24/10/22
-- enrollment_status 오타 수정
-- pk auto_increment 누락 발견
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
    enrollment_status ENUM ('enrolled','suspended','graduated'),
    membership_level ENUM ('admin','normal','guest'),
    is_active BOOL
    );

CREATE TABLE IF NOT EXISTS SUBJECT (
    subject_code int PRIMARY KEY auto_increment,
    subject_name VARCHAR(100) not null,
    grade TINYINT ,
    semester TINYINT ,
    professor VARCHAR(50) ,
    study_opened BOOLEAN not null
    );

CREATE TABLE IF NOT EXISTS STUDY (
    study_id int PRIMARY KEY auto_increment,
    subject_code int,
    title VARCHAR(100),
    status ENUM('active', 'completed', 'pending'),
    schedule VARCHAR(50),
    start_date DATE,
    end_date DATE,
    established_by int,
    foreign key (subject_code) references SUBJECT (subject_code)
    );

create table if not exists MembershipFeePayment (
    membership_id int PRIMARY KEY auto_increment,
    member_id int not null ,
    payment_date date not null,
    amount int not null,
    expiration_date date not null,
    CONSTRAINT fk_member_id foreign key (member_id) references member(member_id)
    on update cascade
    );

-- EDIT BY LSH 24/10/22
-- study_id auto_increment 수정
-- 컬렴명 week -> round로 수정 (session을 쓰고싶었으나 예약어)
CREATE TABLE IF NOT EXISTS STUDY_HISTORY (
    study_id int not null,
    round int not null ,
    study_date date not null ,
    title VARCHAR(100) not null ,
    presenter VARCHAR(50) ,
    notes VARCHAR(1000),
    PRIMARY KEY (study_id, round),
    CONSTRAINT fk_study_id foreign key (study_id) references STUDY(study_id) on DELETE CASCADE
    );

-- EDIT BY LSH 24/10/22
-- STUDY_PARTICIPANT 테이블 DDL 추가
-- 컬렴명 week -> round로 수정
CREATE TABLE IF NOT EXISTS STUDY_PARTICIPANT (
    STUDY_ID INT,
    ROUND INT,
    MEMBER_ID INT,
    PRIMARY KEY (STUDY_ID, ROUND, MEMBER_ID),
    CONSTRAINT fk_study_participant_week FOREIGN KEY (STUDY_ID, ROUND) REFERENCES STUDY_HISTORY(STUDY_ID, ROUND)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    CONSTRAINT fk_study_participant_member_id FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER(MEMBER_ID)
    ON UPDATE CASCADE
    ON DELETE CASCADE
    );

-- EDIT BY LSH 24/10/22
-- Image 테이블 DDL 추가
CREATE TABLE IF NOT EXISTS IMAGE (
    IMAGE_ID INT PRIMARY KEY auto_increment,
    FILE_PATH VARCHAR(255) NOT NULL,
    FILE_NAME VARCHAR(100) NOT NULL
    );


-- EDIT BY LSH 24/10/22
-- 게시판 카테고리 테이블 추가
CREATE TABLE IF NOT EXISTS CATEGORY (
    category_id INT PRIMARY KEY auto_increment,
    category_type VARCHAR(100)
    );

-- EDIT BY LSH 24/10/22
-- 게시판 테이블 DDL
CREATE TABLE IF NOT EXISTS BOARD (
    board_id INT PRIMARY KEY auto_increment,
    title VARCHAR(100),
    member_id INT,
    category_id INT,
    content TEXT,
    created_date DATETIME,
    updated_date DATETIME,
    is_complete BOOL,
    is_public BOOL,
    image_id INT,
    CONSTRAINT fk_board_member_id FOREIGN KEY (member_id) REFERENCES MEMBER (member_id)
    ON UPDATE CASCADE,
    CONSTRAINT fk_board_category_id FOREIGN KEY (category_id) REFERENCES CATEGORY (category_id)
    ON UPDATE CASCADE,
    CONSTRAINT fk_board_image_id FOREIGN KEY (image_id) REFERENCES IMAGE (image_id)
    ON UPDATE CASCADE
    );

-- EDIT BY LSH 24/10/22
-- member, image 테이블 제약조건 추가
-- 가장 마지막에 실행해주세요.
ALTER TABLE MEMBER ADD CONSTRAINT fk_member_image_id FOREIGN KEY (image_id) REFERENCES IMAGE (IMAGE_ID)
    ON UPDATE CASCADE
    ON DELETE CASCADE;