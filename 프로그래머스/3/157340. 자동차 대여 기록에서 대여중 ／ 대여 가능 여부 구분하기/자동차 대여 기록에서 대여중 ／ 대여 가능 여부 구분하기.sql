with rent as (
    select ccrh.car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY ccrh
    where ccrh.start_date <= '2022-10-16' and ccrh.end_date >= '2022-10-16'
)

select distinct(ccrh.car_id),
    case when ccrh.car_id in (
        select car_id
        from rent
        ) then "대여중"
        else "대여 가능" end as "AVAILABILITY"
from CAR_RENTAL_COMPANY_RENTAL_HISTORY ccrh
order by ccrh.car_id desc;