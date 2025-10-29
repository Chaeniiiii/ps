select distinct(cr.car_id)
from CAR_RENTAL_COMPANY_CAR cr join CAR_RENTAL_COMPANY_RENTAL_HISTORY crh on cr.CAR_ID = crh.CAR_ID
where cr.car_type = "세단" and crh.start_date >= "2022-10-01" and crh.start_date < "2022-11-01"
order by cr.car_id desc;