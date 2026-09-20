select ugu.user_id, ugu.nickname, sum(ugb.price) as total_sales
from USED_GOODS_BOARD ugb join USED_GOODS_USER ugu on ugb.writer_id = ugu.user_id
where status = "DONE" 
group by ugb.writer_id
having total_sales >= 700000
order by total_sales;