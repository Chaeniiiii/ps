select distinct(cr.car_id)
from CAR_RENTAL_COMPANY_CAR cr join CAR_RENTAL_COMPANY_RENTAL_HISTORY crh on cr.CAR_ID = crh.CAR_ID
where cr.car_type = "세단" and month(start_date) = 10
order by cr.car_id desc;