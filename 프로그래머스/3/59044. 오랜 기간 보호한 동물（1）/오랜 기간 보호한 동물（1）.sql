-- 코드를 입력하세요
SELECT i.name as NAME, i.datetime as DATETIME
from animal_ins i
left outer join animal_outs o
on i.animal_id = o.animal_id
order by i.datetime
limit 3