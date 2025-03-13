-- 코드를 입력하세요
SELECT i.food_type, i.rest_id, i.rest_name, i.favorites
from rest_info i
WHERE (FOOD_TYPE, FAVORITES) IN (
                                SELECT FOOD_TYPE, MAX(FAVORITES)
                                FROM REST_INFO
                                GROUP BY FOOD_TYPE)
order by i.food_type desc