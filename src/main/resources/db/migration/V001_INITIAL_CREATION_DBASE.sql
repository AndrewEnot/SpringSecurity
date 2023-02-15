-- Создание схемы
CREATE SCHEMA IF NOT EXISTS my_user;

-- Создание таблицы Product
CREATE TABLE IF NOT EXISTS my_user.product
(
    id   serial,
    name text             NOT NULL,
    cost double precision NOT NULL,
    primary key (id)
);

-- Создание таблицы User
CREATE TABLE IF NOT EXISTS my_user.user
(
    id       serial,
    name     text NOT NULL,
    password text NOT NULL,
    role     text NOT NULL,
    primary key (id)
);




