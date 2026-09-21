select distinct cc.car_id
from CAR_RENTAL_COMPANY_CAR cc join CAR_RENTAL_COMPANY_RENTAL_HISTORY ch on cc.car_id = ch.car_id
where cc.car_type = "세단"  and ch.start_date between "2022-10-01" and "2022-10-31"
order by cc.car_id desc;