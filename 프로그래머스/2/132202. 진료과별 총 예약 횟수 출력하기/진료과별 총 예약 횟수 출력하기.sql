-- 코드를 입력하세요
SELECT mcdp_cd as `진료과코드` , count(mddr_id) as `5월예약건수`
from appointment
where apnt_ymd >= '2022-05-01' and apnt_ymd <= '2022-05-31'
group by mcdp_cd
order by count(mddr_id), mcdp_cd

# select *
# from appointment