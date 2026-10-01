with ntile_info as (
    select *, ntile(4) over(order by SIZE_OF_COLONY) pc
    from ecoli_data
)

select id,
    case when pc = 4 then 'CRITICAL'
         when pc = 3 then 'HIGH'
         when pc = 2 then 'MEDIUM'
         else 'LOW' end 'COLONY_NAME'
from ntile_info
order by id;