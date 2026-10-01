with rental as (
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where start_date between '2022-08-01' and '2022-10-31'
    group by car_id
    having count(*) >= 5
)

select month(start_date) 'month', car_id, count(*) 'records'
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id in (
    select *
    from rental
)
and start_date between '2022-08-01' and '2022-10-31'
group by car_id, month(start_date)
order by month(start_date), car_id desc;