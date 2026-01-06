select he.dept_id, hd.dept_name_en, he.avg_sal
from HR_DEPARTMENT hd join 
(
    select dept_id, round(avg(SAL)) as avg_sal
    from HR_EMPLOYEES 
    group by dept_id
) he on hd.dept_id = he.dept_id
order by avg_sal desc;