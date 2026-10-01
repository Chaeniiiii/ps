with fav as (
    select food_type, max(favorites) favorites
    from rest_info
    group by food_type
)

select food_type,rest_id, rest_name, favorites
from rest_info
where (food_type, favorites) in (
    select *
    from fav
)
order by food_type desc;