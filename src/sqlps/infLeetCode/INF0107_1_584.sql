--SELECT name
--FROM Customer
--WHERE referee_id NOT IN (2)
--    OR referee_id IS NULL;

SELECT
    name
FROM Customer
WHERE id NOT IN (
    SELECT
        id
    FROM Customer
    WHERE referee_id = 2
);