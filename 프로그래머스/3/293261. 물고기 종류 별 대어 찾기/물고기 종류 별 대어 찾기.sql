with fish_full_info as (
    select fi.id, 
        fi.fish_type, 
        fni.fish_name, 
        max(length) over(partition by fish_type) max_size
    from fish_info fi left join fish_name_info fni on fi.fish_type = fni.fish_type
)

select ffi.id, ffi.fish_name ,ffi.max_size length
from fish_full_info ffi join fish_info on ffi.id = fish_info.id
where ffi.max_size = fish_info.length;
