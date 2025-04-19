CREATE TABLE IF NOT EXISTS customer(
    id BIGINT PRIMARY KEY,
    name VARCHAR(200),
    customer_type VARCHAR(10),
    cpfCnpj VARCHAR(14),
    email VARCHAR(254),
    phone VARCHAR(25),
    address VARCHAR(200)

)
