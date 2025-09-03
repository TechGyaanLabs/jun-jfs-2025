CREATE TABLE player (
       id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
       name VARCHAR(255),
       team VARCHAR(255),
       role VARCHAR(255),
       country VARCHAR(255),
       amount DOUBLE PRECISION
);