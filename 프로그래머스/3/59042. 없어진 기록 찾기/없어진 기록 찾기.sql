select ao.animal_id, ao.name
from animal_outs ao
where ao.animal_id not in (
    select animal_id
    from animal_ins
)
order by ao.animal_id;