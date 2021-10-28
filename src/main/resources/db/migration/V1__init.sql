CREATE TABLE IF NOT EXISTS student (
    id SERIAL PRIMARY KEY,
    first_name varchar(120) not null,
    last_name varchar(120) not null,
    birth_date DATE,
    address varchar(50),
    telephone varchar(10)
);

insert into student (first_name, last_name, birth_date, address, telephone)
VALUES
('Andrei', 'Charnushei', {d '1994-10-26'}, 'Ilicha 295', '340309'),
('Sah', 'Bor', {d '2003-01-23'}, 'Prospect Nezavisimosti 168/2', '350309');