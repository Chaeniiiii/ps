with heavy as (
    select host_id
    from places
    group by host_id
    having count(*) >= 2
)

select id, name,host_id
from places 
where host_id in(
    select host_id
    from heavy
) 
order by id;