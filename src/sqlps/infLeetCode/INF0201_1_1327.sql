SELECT
    p.product_name,
    SUM(o.unit) AS unit
FROM Products AS p
JOIN Orders AS o
    ON p.product_id = o.product_id
WHERE o.order_date >= '2020-02-01'
    AND o.order_date < '2020-03-01'
GROUP BY o.product_id
HAVING SUM(o.unit) >= 100;


--인프런 코드
SELECT
    p.product_name,
    o.unit
FROM Products AS p
JOIN (
    SELECT
        product_id,
        SUM(unit) AS unit
    FROM Orders
    WHERE DATE_FORMAT(order_date, '%Y-%m') = '2020-02'
    GROUP BY product_id
    HAVING SUM(unit) >= 100
) AS o
ON p.product_id = o.product_id;