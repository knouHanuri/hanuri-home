## STUDY_HISTORY

CREATE TABLE IF NOT EXISTS STUDY_HISTORY(

                                            study_id int not null auto_increment ,

                                            week int not null ,

                                            study_date date not null ,

                                            title VARCHAR(100) not null ,

                                            presenter VARCHAR(50) ,

                                            notes VARCHAR(1000),

                                            PRIMARY KEY (study_id, week)

);