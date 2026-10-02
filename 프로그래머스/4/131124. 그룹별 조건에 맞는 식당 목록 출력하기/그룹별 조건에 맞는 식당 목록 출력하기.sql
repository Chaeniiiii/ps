with rank_info as (
    select member_id, 
        rank() over (order by count(review_id) desc) rnk
    from REST_REVIEW
    group by member_id
)

select m.member_name, r.review_text, date_format(r.review_date,"%Y-%m-%d") 'review_date'
from REST_REVIEW r join member_profile m on r.member_id = m.member_id
where m.member_id in (
    select member_id
    from rank_info
    where rnk = 1
)
order by REVIEW_DATE, r.review_text;