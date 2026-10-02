with avg_info as (
    select he.emp_no, he.EMP_NAME, he.sal, avg(hg.score) avg_score
    from hr_grade hg join hr_employees he on hg.emp_no = he.emp_no 
    group by he.emp_no 
)

select emp_no, emp_name,
    case when avg_score >= 96 then 'S'
        when avg_score >= 90 then 'A'
        when avg_score >= 80 then 'B'
        else 'C' end as 'GRADE',
    case when avg_score >= 96 then sal * 0.2
        when avg_score >= 90 then sal * 0.15
        when avg_score >= 80 then sal * 0.1
        else 0 end as 'BONUS'
from avg_info 
order by emp_no;
    
    
    