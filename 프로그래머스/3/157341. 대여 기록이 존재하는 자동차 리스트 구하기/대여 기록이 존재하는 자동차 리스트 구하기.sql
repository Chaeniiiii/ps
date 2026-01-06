select distinct cch.car_id
from CAR_RENTAL_COMPANY_CAR cch join CAR_RENTAL_COMPANY_RENTAL_HISTORY arcc on cch.car_id = arcc.car_id
where cch.car_type = '세단' and
    arcc.start_date like "2022-10%"
order by cch.car_id desc;