select ao.animal_id, ao.name
from ANIMAL_INS ai right join ANIMAL_OUTS ao on ai.animal_id = ao.animal_id
where ai.datetime is null
order by ai.animal_id;