select name, datetime
from animal_ins ai
where ai.animal_id not in ( select animal_id
    from animal_outs)
order by datetime
limit 3;