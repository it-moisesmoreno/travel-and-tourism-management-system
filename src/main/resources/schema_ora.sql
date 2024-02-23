-- User: Moises
CREATE USER itmoisesmoreno IDENTIFIED BY 123456;

-- Table: users
CREATE SEQUENCE user_seq START WITH 1;

CREATE TABLE users (
    user_id NUMBER(6) DEFAULT user_seq.nextval NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    role VARCHAR(50) 
        DEFAULT 'user'
        NOT NULL
        CHECK(role IN ('admin','user')),
    is_active number(1),
    PRIMARY KEY(user_id)
);