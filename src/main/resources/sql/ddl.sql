
-- EDIT BY LSH 24/10/22
-- enrollment_status 오타 수정
-- pk auto_increment 누락 발견
CREATE TABLE IF NOT EXISTS member (
    member_id int(10) primary key auto_increment,
    username varchar(50) not null,
    email varchar(50) not null,
    name varchar(50) not null,
    phone_number varchar(15),
    password varchar(255),
    gender ENUM('male','female','other'),
    birthdate DATE,
    student_id varchar(20),
    enrollment_status ENUM ('enrolled','suspended','graduated'),
    membership_level ENUM ('admin','normal','guest'),
    is_active BOOL,
    provider varchar(20),
    provider_id varchar(255),
    picture varchar(255)
    );

CREATE TABLE IF NOT EXISTS subject (
    subject_code int PRIMARY KEY auto_increment,
    subject_name VARCHAR(100) not null,
    grade TINYINT ,
    semester TINYINT ,
    professor VARCHAR(50) ,
    study_opened BOOLEAN not null
    );

-- EDIT BY CSH 25/01/23
-- 스터디목표(goal) 추가
CREATE TABLE IF NOT EXISTS study (
    study_id int PRIMARY KEY auto_increment,
    subject_code int,
    title VARCHAR(100),
    status ENUM('active', 'completed', 'pending'),
    schedule VARCHAR(50),
    goal VARCHAR(200),
    start_date DATE,
    end_date DATE,
    established_by int,
    foreign key (subject_code) references subject (subject_code)
    );

-- EDIT BY LSH 24/10/22
-- study_id auto_increment 수정
-- 컬렴명 week -> round로 수정 (session을 쓰고싶었으나 예약어)
CREATE TABLE IF NOT EXISTS study_history (
    study_id int not null,
    round int not null ,
    study_date date not null ,
    title VARCHAR(100) not null ,
    presenter VARCHAR(50) ,
    notes VARCHAR(1000),
    PRIMARY KEY (study_id, round),
    CONSTRAINT fk_study_id foreign key (study_id) references study(study_id) on DELETE CASCADE
    );

-- EDIT BY LSH 24/10/22
-- STUDY_PARTICIPANT 테이블 DDL 추가
-- 컬렴명 week -> round로 수정
CREATE TABLE IF NOT EXISTS study_participant (
    study_id INT,
    round INT,
    member_id INT,
    PRIMARY KEY (study_id, round, member_id),
    CONSTRAINT fk_study_participant_week FOREIGN KEY (study_id, round) REFERENCES study_history(study_id, round)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    CONSTRAINT fk_study_participant_member_id FOREIGN KEY (member_id) REFERENCES member(member_id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
    );

-- EDIT BY LSH 24/10/22
-- Image 테이블 DDL 추가
CREATE TABLE IF NOT EXISTS image (
    image_id INT PRIMARY KEY auto_increment,
    image_type  ENUM('member', 'study', 'board'),
    object_id   INT NOT NULL,
    file_path VARCHAR(255) NOT NULL,
    original_file_name VARCHAR(100) NOT NULL,
    store_file_name VARCHAR(50) NOT NULL,
    src     VARCHAR(100) NULL
    );


-- EDIT BY LSH 24/10/22
-- 게시판 카테고리 테이블 추가
-- EDIT BY JJY 25/01/15
-- 게시판 카테고리 ENUM 으로 대체
-- board image fk 삭제

-- EDIT BY LSH 24/10/22
-- 게시판 테이블 DDL
CREATE TABLE IF NOT EXISTS board (
    board_id INT PRIMARY KEY auto_increment,
    title VARCHAR(100),
    member_id INT,
    category_id INT,
    content TEXT,
    created_date DATETIME,
    updated_date DATETIME,
    is_complete BOOL,
    is_public BOOL,
    CONSTRAINT fk_board_member_id FOREIGN KEY (member_id) REFERENCES member (member_id)
    ON UPDATE CASCADE
    );