select 
    ed1.id, 
    case 
        when ed2.per <= 0.25 then 'CRITICAL'
        when ed2.per <= 0.5 then 'HIGH'
        when ed2.per <= 0.75 then 'MEDIUM'
        else 'LOW'
    end as 'COLONY_NAME'
from ECOLI_DATA ed1 join
(
    select id, percent_rank() over (
        order by size_of_colony desc
    ) as per
    from ECOLI_DATA
) ed2 on ed1.id = ed2.id
order by ed1.id;