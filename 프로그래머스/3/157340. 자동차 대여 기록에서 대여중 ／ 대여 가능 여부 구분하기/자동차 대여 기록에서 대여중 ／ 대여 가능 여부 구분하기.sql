-- 코드를 입력하세요

select 
    ch.car_id,
    case 
        when sum(start_date <= "2022-10-16" and end_date >= "2022-10-16") >= 1 then "대여중"
        else "대여 가능"
        end "AVAILABILITY"
from CAR_RENTAL_COMPANY_RENTAL_HISTORY ch
group by ch.car_id 
order by ch.car_id desc;

