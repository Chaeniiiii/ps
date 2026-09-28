with fish_len as (
    select fish_type, id, ifnull(length,10) as 'length'
    from fish_info
)

select count(*) as 'fish_count',max(length) as 'max_length', fish_type
from fish_len 
group by fish_type
having avg(length) >= 33
order by fish_type;