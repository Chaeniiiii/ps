with maxlen as (
    select id, fish_type , length, max(length) over (partition by fish_type) 'max'
    from fish_info
)

select maxlen.id, fni.fish_name, maxlen.length
from maxlen join fish_name_info fni on maxlen.fish_type = fni.fish_type
where maxlen.max = maxlen.length
group by maxlen.fish_type
order by maxlen.id;