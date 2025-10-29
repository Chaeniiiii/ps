select hd.dept_id, hd.DEPT_NAME_EN ,round(avg(he.SAL)) as AVG_SAL
from HR_DEPARTMENT hd join HR_EMPLOYEES he on hd.DEPT_ID = he.DEPT_ID
group by hd.DEPT_ID
order by avg_sal desc;