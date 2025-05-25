CREATE TABLE products (
    id SERIAL PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR (100) NOT NULL,
    price NUMERIC (10, 2) NOT NULL,
    description TEXT
);