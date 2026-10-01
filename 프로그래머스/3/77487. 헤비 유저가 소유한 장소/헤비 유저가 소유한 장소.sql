with havy as (
    select host_id
    from places
    group by host_id
    having count(*) >= 2
)

select *
from places
where host_id in (
    select host_id
    from havy
)
order by id;