CREATE TABLE IF NOT EXISTS orders (
    id INT NOT NULL,
    product_id INT NOT NULL,
    PRIMARY KEY (id, product_id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);