with fv_t as (
    select 
        food_type,
        max(favorites) over(partition by food_type) as "favorites"
    from rest_info
)

select ri.food_type, ri.rest_id, ri.rest_name, ri.favorites
from rest_info ri join fv_t on ri.food_type = fv_t.food_type
where ri.food_type = fv_t.food_type and ri.favorites = fv_t.favorites
group by ri.food_type
order by ri.food_type desc;