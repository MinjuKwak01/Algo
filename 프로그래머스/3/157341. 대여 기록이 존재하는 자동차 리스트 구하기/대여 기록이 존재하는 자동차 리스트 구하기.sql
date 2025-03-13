-- 코드를 입력하세요
SELECT distinct a.car_id
from CAR_RENTAL_COMPANY_CAR a join CAR_RENTAL_COMPANY_RENTAL_HISTORY b
on a.car_id = b.car_id
where month(start_date) = 10 and car_type = '세단'
order by a.car_id desc