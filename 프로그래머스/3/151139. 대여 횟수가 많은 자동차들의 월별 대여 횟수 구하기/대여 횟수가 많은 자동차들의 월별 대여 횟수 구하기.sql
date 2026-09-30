with car_cnt as (
    select car_id, count(*) records
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where start_date >= '2022-08-01' and start_date < '2022-11-01'
    group by car_id
    having  count(*) >= 5
)

select month(start_date) as month ,car_id,count(*) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id in (
    select car_id
    from car_cnt
) and START_DATE >= '2022-08-01' AND START_DATE < '2022-11-01'
group by month(start_date), car_id
order by month(start_date), car_id desc;
