CREATE TABLE IF NOT EXISTS product (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(250),
    price VARCHAR(50) NOT NULL,
    current_stock INT NOT NULL
);
