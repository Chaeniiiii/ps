select p1.id, p1.name, p1.host_id
from places p1 join (
    select host_id, count(*) as 'cnt'
    from places
    group by host_id
) p2 on p1.host_id = p2.host_id
where p2.cnt >= 2
order by p1.id;