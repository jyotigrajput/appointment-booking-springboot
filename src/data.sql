CREATE DATABASE IF NOT EXISTS appointment_app;

use appointment_app;

CREATE TABLE IF NOT EXISTS customer (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS appointment (
    id BIGINT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    appointment_time TIMESTAMP NOT NULL,
    notes VARCHAR(500),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

INSERT INTO customer (id, name, email) VALUES (1, 'Alice', 'alice@example.com');
INSERT INTO customer (id, name, email) VALUES (2, 'Bob', 'bob@example.com');


INSERT INTO  appointment (id, customer_id, appointment_time, notes) VALUES (1, 1, '2026-09-01 10:00:00', 'Initial consult');
INSERT INTO  appointment (id, customer_id, appointment_time, notes) VALUES (2, 2, '2026-09-02 14:30:00', 'Follow-up');
