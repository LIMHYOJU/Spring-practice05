create user hyoju with password '1234';
--계정생성

CREATE USER hyoju  PASSWORD '1234' SUPERUSER;
--슈퍼계정
--
--DB 생성
create database spring5Test;

GRANT ALL PRIVILEGES ON DATABASE spring5Test TO hyoju;
--DB spring5Test 권한을 hyoju에게 줌

--테이블 제작2가지 방법

CREATE SEQUENCE Member_id_seq;

create table MEMBER(
    ID integer NOT NULL DEFAULT nextval ('Member_id_seq') PRIMARY KEY,
    EMAIL varchar(255),
    PASSWORD varchar(100),
    NAME varchar(100),
    REGDATE date,
    UNIQUE (EMAIL)
)
ALTER SEQUENCE Member_id_seq OWNED BY MEMBER.id;

--시리얼
create table MEMBER(
    ID SERIAL,
    EMAIL varchar(255),
    PASSWORD varchar(100),
    NAME varchar(100),
    REGDATE date,
    UNIQUE (EMAIL)
)

--같은 소스니까 그냥 시리얼 쓰는걸로하자

--테스트용  데이터 추가
INSERT INTO member ("email", "password", "name", "regdate") VALUES
('dlagywn1', '1111', '임효주 ', '2022-08-09');
