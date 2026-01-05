select 
    e.id, 
    case 
        when newed.cc is null then 0 
        else newed.cc
    end as child_count
from ecoli_data e
left outer join (
    select ed.parent_id, count(*) as cc
    from ecoli_data ed
    where ed.parent_id is not null
    group by ed.parent_id
) newed on e.id = newed.parent_id; 
