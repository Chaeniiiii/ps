with seoul as (
    select *
    from REST_INFO
    where address like '서울%'
)

select seoul.rest_id, 
    seoul.rest_name, 
    seoul.food_type, 
    seoul.favorites, 
    seoul.address, 
    round(avg(rr.review_score),2) 'score'
from rest_review rr join seoul on rr.rest_id = seoul.rest_id
group by rr.rest_id
order by round(avg(rr.review_score),3) desc, seoul.favorites desc;