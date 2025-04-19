CREATE TABLE IF NOT EXISTS orders(
    id BIGINT PRIMARY KEY,
    customer_id BIGINT,
    status VARCHAR(10),
    quantity INTEGER,
    total_value NUMERIC(12,2)


    ADD CONTRAINT fk_orders_customer FOREIGN KEY (customer_id) REFERENCES customer(id);

)
