select ai.name, ai.datetime
from animal_ins ai left join animal_outs ao on ai.animal_id = ao.animal_id 
where SEX_UPON_OUTCOME is null
order by datetime
limit 3;