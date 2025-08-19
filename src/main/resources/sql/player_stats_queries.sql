-- 1. Team statistics: max, min, count, avg, total amount
SELECT team,
       MAX(price) AS max_price,
       MIN(price) AS min_price,
       COUNT(*)   AS count,
       ROUND(AVG(price),2) AS avg_price,
       SUM(price) AS total_amount
FROM players
GROUP BY team
ORDER BY team;

-- 2. Top 5 highest paid players overall
SELECT id, name, role, country, team, price
FROM players
ORDER BY price DESC
LIMIT 5;

-- 3. Top 2 highest paid players from each team
SELECT id, name, role, country, team, price
FROM (
    SELECT id, name, role, country, team, price,
           ROW_NUMBER() OVER (PARTITION BY team ORDER BY price DESC) as rnk
    FROM players
) t
WHERE rnk <= 2;

-- 4. Players whose price is above team average
SELECT p.id, p.name, p.role, p.country, p.team, p.price,
       t.avg_price AS team_average_price,
       (p.price - t.avg_price) AS difference_from_average
FROM players p
JOIN (
    SELECT team, AVG(price) AS avg_price
    FROM players
    GROUP BY team
) t ON p.team = t.team
WHERE p.price > t.avg_price
ORDER BY p.team, p.price DESC;

-- 5. Get players by country
SELECT id, name, role, country, team, price
FROM players
WHERE country = 'INDIA';
