CREATE SEQUENCE IF NOT EXISTS tb_order_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS tb_order
(
    id         BIGINT NOT NULL,
    product    TEXT,
    version    BIGINT,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    update_at  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_tb_order PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS tb_payment_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS tb_payment
(
    id           BIGINT NOT NULL,
    payment_enum INTEGER,
    order_id     BIGINT NOT NULL,
    version      BIGINT,
    created_at   TIMESTAMP WITHOUT TIME ZONE,
    update_at    TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_tb_payment PRIMARY KEY (id)
);

ALTER TABLE tb_payment
    ADD CONSTRAINT FK_TB_PAYMENT_ON_ORDER FOREIGN KEY (order_id) REFERENCES tb_order (id);

CREATE SEQUENCE IF NOT EXISTS tb_shipping_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS tb_shipping
(
    id            BIGINT NOT NULL,
    shipping_enum INTEGER,
    order_id      BIGINT NOT NULL,
    version       BIGINT,
    created_at    TIMESTAMP WITHOUT TIME ZONE,
    update_at     TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_tb_shipping PRIMARY KEY (id)
);

ALTER TABLE tb_shipping
    ADD CONSTRAINT FK_TB_SHIPPING_ON_ORDER FOREIGN KEY (order_id) REFERENCES tb_order (id);