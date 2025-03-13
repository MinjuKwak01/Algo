-- 코드를 입력하세요
SELECT o.animal_id, o.name
from animal_ins l
right outer join animal_outs o
on l.animal_id = o.animal_id
where l.animal_id is null
order by l.animal_id