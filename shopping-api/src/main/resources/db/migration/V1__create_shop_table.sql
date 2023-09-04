CREATE schema IF NOT EXISTS shopping;

CREATE TABLE shopping.shop (
  id BIGSERIAL PRIMARY KEY,
  user_identifier VARCHAR(100) NOT NULL,
  DATE TIMESTAMP NOT NULL,
  total FLOAT NOT NULL
);

CREATE TABLE shopping.item (
  shop_id BIGSERIAL REFERENCES shopping.shop(id),
  product_identifier VARCHAR(100) NOT NULL,
  price FLOAT NOT NULL
);