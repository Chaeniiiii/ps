select id,
    case when ntile(4) over(order by SIZE_OF_COLONY) = 4 then 'CRITICAL'
        when ntile(4) over(order by SIZE_OF_COLONY) = 3 then 'HIGH'
        when ntile(4) over(order by SIZE_OF_COLONY) = 2 then 'MEDIUM'
        else 'LOW' end 'COLONY_NAME'
from ecoli_data
order by id;