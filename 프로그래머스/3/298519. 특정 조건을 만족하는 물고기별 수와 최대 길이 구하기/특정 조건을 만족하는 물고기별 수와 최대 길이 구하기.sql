select count(*) 'fish_count', max(length) 'max_length', fish_type
from fish_info
group by fish_type
having avg(ifnull(length,10)) >= 33
order by fish_type;