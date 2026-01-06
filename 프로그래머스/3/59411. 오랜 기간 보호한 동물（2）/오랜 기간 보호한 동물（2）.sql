# select ao.animal_id, ao.name
# from ANIMAL_OUTS ao
# where animal_id in (
    
# )
# limit 2;

select ai.animal_id, ao.name
from animal_ins ai join ANIMAL_OUTS ao on ai.animal_id = ao.animal_id
order by (ao.datetime - ai.datetime) desc
limit 2;