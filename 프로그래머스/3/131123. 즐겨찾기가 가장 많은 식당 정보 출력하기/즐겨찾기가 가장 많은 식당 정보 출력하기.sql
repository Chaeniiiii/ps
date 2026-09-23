with fv_t as (
    select * , max(favorites) over (partition by food_type) as mf
    from rest_info
)

select food_type,rest_id, rest_name, favorites
from fv_t
where favorites = mf
order by food_type desc;