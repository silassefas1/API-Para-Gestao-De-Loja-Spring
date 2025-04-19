CREATE TABLE IF NOT EXISTS product(
    id BIGINT PRIMARY KEY,
    name VARCHAR(150),
    description VARCHAR(250),
    price NUMERIC(10,2),
    category VARCHAR(20),
    created_at TIMESTAMP,
    updated_at TIMESTAMP

)
