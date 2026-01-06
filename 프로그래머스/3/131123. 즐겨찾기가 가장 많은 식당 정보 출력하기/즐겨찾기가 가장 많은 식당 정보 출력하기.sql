select ri.food_type, ri.rest_id, ri.rest_name, newRi.fav
from rest_info ri join 
(
    select food_type, max(favorites) as fav
    from rest_info
    group by food_type
    order by food_type desc
) newRi on ri.food_type = newRi.food_type and ri.favorites = newRi.fav
order by ri.food_type desc;