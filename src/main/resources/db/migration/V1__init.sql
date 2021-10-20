CREATE TABLE IF NOT EXISTS student (
    id SERIAL PRIMARY KEY,
    first_name varchar(120) not null,
    last_name varchar(120) not null,
    birth_date DATE,
    address varchar(50),
    telephone varchar(10)
);