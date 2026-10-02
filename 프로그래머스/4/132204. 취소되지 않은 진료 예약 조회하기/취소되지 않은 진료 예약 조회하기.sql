with aplir as (
    select ap.apnt_no, pt.pt_name, ap.pt_no, ap.MCDP_CD, ap.MDDR_ID, ap.APNT_YMD
    from appointment ap join patient pt on ap.pt_no = pt.pt_no
    where ap.apnt_ymd >= '2022-04-13' and apnt_ymd < '2022-04-14' and ap.apnt_cncl_yn = 'N' and ap.mcdp_cd = 'CS'
)

select aplir.apnt_no, aplir.pt_name, aplir.pt_no, aplir.mcdp_cd, doctor.dr_name, aplir.apnt_ymd
from aplir join doctor on aplir.mddr_id = doctor.dr_id
order by aplir.apnt_ymd;