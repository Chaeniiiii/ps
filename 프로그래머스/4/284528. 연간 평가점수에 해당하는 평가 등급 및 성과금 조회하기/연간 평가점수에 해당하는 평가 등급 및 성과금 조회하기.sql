with grade_info as (
    select he.emp_no, 
            he.emp_name, 
            avg(hg.score) score,
            case when avg(hg.score) >= 96 then 'S' 
                when avg(hg.score) >= 90 then 'A'
                when avg(hg.score) >= 80 then 'B'
                else 'C' end as 'GRADE',
            he.sal
    from hr_grade hg join hr_employees he on hg.emp_no = he.emp_no 
    group by he.emp_no 
)

select emp_no, emp_name, grade,
    case when GRADE = 'S' then sal * 0.2 
    when GRADE = 'A' then sal * 0.15
    when GRADE = 'B' then sal * 0.1
    else 0 end as 'BONUS'
from grade_info
order by emp_no;
    