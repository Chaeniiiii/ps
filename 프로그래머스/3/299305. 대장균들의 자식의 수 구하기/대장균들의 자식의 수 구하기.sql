with cnt as (
    select parent_id, count(*) child
    from ecoli_data
    group by parent_id
)

select ed.id, ifnull(cnt.child,0) 'child_count'
from ecoli_data ed left join cnt on ed.id = cnt.parent_id
order by ed.id;