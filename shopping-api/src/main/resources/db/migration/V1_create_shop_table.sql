
CREATE SCHEMA IF NOT EXISTS shopping;

CREATE TABLE shopping.shop(
    id BIGSERIAL PRIMARY KEY,
    user_identifier VARCHAR(100) NOT NULL,
    date TIMESTAMP NOT NULL,
    total FLOAT NOT NULL
    );
