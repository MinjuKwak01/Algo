-- 코드를 입력하세요
SELECT year(o.sales_date) as year, month(o.sales_date) as month, 
count(distinct u.user_id) as purchased_users, 
round((count(distinct u.user_id) / (select count(*) from user_info s where year(s.joined) = 2021)),1) as purchased_ratio
from user_info u
join online_sale o
on u.user_id = o.user_id
where year(u.joined) = 2021
group by year(o.sales_date), month(o.sales_date)
order by year(o.sales_date), month(o.sales_date)
