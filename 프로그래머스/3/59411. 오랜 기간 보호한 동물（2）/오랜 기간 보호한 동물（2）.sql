select animal.animal_id , animal.name
from (select (ao.datetime - ai.datetime) as "date", ai.animal_id , ai.name
      from ANIMAL_INS ai join ANIMAL_OUTS ao on ai.animal_id = ao.animal_id 
      where ao.DATETIME is not null
      order by date desc) as animal
limit 2;
