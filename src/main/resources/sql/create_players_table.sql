-- Create players table for IPL statistics
CREATE TABLE IF NOT EXISTS players (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL,
    team VARCHAR(10) NOT NULL,
    price DECIMAL(8,2) NOT NULL
);
