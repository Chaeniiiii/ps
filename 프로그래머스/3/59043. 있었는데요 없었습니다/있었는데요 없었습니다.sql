select ai.animal_id, ao.name
from ANIMAL_INS ai left outer join ANIMAL_OUTS ao on ai.animal_id = ao.animal_id
where ai.datetime > ao.datetime
order by ai.datetime;