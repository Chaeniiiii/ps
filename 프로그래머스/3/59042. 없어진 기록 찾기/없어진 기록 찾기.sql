select ANIMAL_ID, name
from ANIMAL_OUTS
where animal_id not in ( 
    select ANIMAL_ID
    from ANIMAL_INS
)
order by ANIMAL_ID;
