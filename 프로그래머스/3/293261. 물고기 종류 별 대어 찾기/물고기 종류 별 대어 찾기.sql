with fish_full_info as (
    select fi.id, 
        fi.fish_type, 
        fni.fish_name, 
        fi.length,
        max(length) over(partition by fish_type) max_size
    from fish_info fi left join fish_name_info fni on fi.fish_type = fni.fish_type
)

select id, fish_name ,max_size length
from fish_full_info
where length = max_size
order by id;
