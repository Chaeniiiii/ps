select user_id,nickname,sum(price) as 'total_sales'
from USED_GOODS_BOARD gb join USED_GOODS_USER gu on gb.WRITER_ID = gu.user_id
where status = 'DONE'
group by gb.WRITER_ID
having sum(price) >= 700000
order by total_sales;