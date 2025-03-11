-- 코드를 작성해주세요
select route, 
concat(round(sum(D_BETWEEN_DIST),1), 'km') as TOTAL_DISTANCE, 
concat(round(avg(D_BETWEEN_DIST),2),'km') as AVERAGE_DISTANCE
from subway_distance
group by route
order by round(sum(D_BETWEEN_DIST),1) desc


# SELECT ROUTE
#      , CONCAT(ROUND(SUM(D_BETWEEN_DIST), 1), 'km') AS TOTAL_DISTANCE
#      , CONCAT(ROUND(AVG(D_BETWEEN_DIST), 2), 'km') AS AVERAGE_DISTANCE
#     FROM SUBWAY_DISTANCE
#     GROUP BY ROUTE
#     ORDER BY ROUND(SUM(D_BETWEEN_DIST), 1) DESC