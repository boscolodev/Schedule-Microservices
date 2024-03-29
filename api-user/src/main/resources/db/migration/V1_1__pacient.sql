CREATE SCHEMA IF NOT EXISTS db_user;

CREATE TABLE db_user.tb_pacient (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   name VARCHAR(255),
   email VARCHAR(255),
   birthday date,
   address BYTEA,
   status VARCHAR(255),
   CONSTRAINT pk_tb_pacient PRIMARY KEY (id)
);