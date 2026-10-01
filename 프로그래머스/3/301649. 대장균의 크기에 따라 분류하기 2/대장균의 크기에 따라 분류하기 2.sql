with percent as(
    select id, ntile(4) over(order by size_of_colony desc) pc
    from ECOLI_DATA
)

select id, 
    case when pc = 1 then 'CRITICAL'
        when pc = 2 then 'HIGH'
        when pc = 3 then 'MEDIUM'
        else 'LOW' end as 'COLONY_NAME'
from percent
order by id;