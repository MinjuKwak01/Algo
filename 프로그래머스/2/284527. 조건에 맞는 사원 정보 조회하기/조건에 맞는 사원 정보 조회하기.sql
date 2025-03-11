-- 코드를 작성해주세요
select sum(score) as score, g.emp_no, e.emp_name, e.position, e.email
from hr_grade g 
join hr_employees e
on g.emp_no = e.emp_no
join hr_department d
on e.dept_id = d.dept_id
where year = 2022
group by g.emp_no
order by sum(score) desc
limit 1