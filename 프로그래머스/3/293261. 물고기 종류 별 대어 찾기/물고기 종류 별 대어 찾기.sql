select fi.id, fni.fish_name, fi.length
from FISH_INFO fi left join FISH_NAME_INFO fni on fi.fish_type = fni.fish_type
where fi.length = (
    select max(fi2.length)
    from fish_info fi2
    where fi2.fish_type = fi.fish_type
)
order by fi.id;
