select hour(DATETIME) as HOUR, COUNT(*) as COUNT
from ANIMAL_OUTS
group by HOUR
having HOUR between 9 and 20
order by hour;