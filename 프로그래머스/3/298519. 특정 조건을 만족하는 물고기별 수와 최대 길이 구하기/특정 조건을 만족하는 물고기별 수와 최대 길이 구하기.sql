select count(*) as 'fish_count', max(len) as 'max_length' , m.fish_type
from (
    select fish_type , IFNULL(length, 10) as len
    from fish_info
) m 
group by m.fish_type
having avg(m.len) >= 33
order by m.fish_type;
