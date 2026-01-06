select ugu.user_id , ugu.nickname, sum(ugb.PRICE) as price
from USED_GOODS_BOARD ugb join USED_GOODS_USER ugu on ugb.WRITER_ID = ugu.user_id
where ugb.status = "DONE"
group by ugu.user_id
having sum(ugb.PRICE) >= 700000
order by price;

