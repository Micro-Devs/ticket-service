
CREATE SCHEMA ticket;


CREATE TABLE ticket.ticket
(
    guid        VARCHAR(36)   NOT NULL PRIMARY KEY,
    billingNo   VARCHAR(60)  NOT NULL,
    price       NUMERIC      NOT NULL,
    status      VARCHAR(10)  NOT NULL,
);