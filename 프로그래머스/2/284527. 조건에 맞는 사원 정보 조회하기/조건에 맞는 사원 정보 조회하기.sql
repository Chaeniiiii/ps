select sum(SCORE) as SCORE, he.EMP_NO, EMP_NAME, POSITION, EMAIL
from HR_DEPARTMENT hd
join HR_EMPLOYEES he on hd.DEPT_ID = he.DEPT_ID
join HR_GRADE hg on he.EMP_NO = hg.EMP_NO
group by  he.EMP_NO
order by SCORE desc
limit 1;