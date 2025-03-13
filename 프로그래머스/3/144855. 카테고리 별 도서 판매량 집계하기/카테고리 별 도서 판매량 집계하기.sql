-- 코드를 입력하세요
SELECT b.category, sum(s.sales) as total_sales
from book b join book_sales s
on b.book_id = s.book_id
where sales_date >= '2022-01-01' and sales_date <= '2022-01-31'
group by b.category
order by b.category