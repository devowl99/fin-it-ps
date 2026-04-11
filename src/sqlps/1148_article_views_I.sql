SELECT DISTINCT
    author_id AS id
FROM Views
WHERE author_id = viewer_id
ORDER BY id ASC -- ASC 생략 가능, ORDER BY는 SELECT 다음에 실행되므로 ALIAS 적용 가능