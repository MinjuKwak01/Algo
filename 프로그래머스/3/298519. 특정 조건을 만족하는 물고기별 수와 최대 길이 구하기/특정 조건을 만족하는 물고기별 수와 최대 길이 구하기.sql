-- 코드를 작성해주세요
select count(*) as fish_count, MAX(f.length) as max_length, f.fish_type
from fish_info as f
group by f.fish_type
having avg(coalesce(f.length,10)) >= 33
order by fish_type asc