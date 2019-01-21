DROP TABLE IF EXISTS tmp1;
CREATE TEMPORARY TABLE tmp1
SELECT d.* FROM
(
	SELECT s.id, s.`name`, (@row_number:=@row_number + 1) AS num
	FROM students s, (SELECT @ROW_NUMBER := 0) r
	WHERE s.class_id = 7
	ORDER BY s.class_id, s.`name` ASC
) AS d;

UPDATE students AS s1
INNER JOIN tmp1 AS tmp ON s1.id = tmp.id
SET s1.`no` = tmp.num
WHERE s1.id = tmp.id;