select 
    ugu.user_ID, 
    nickname, 
    concat(ugu.city," ",ugu.street_address1," ",ugu.street_address2) as '전체주소',
    insert(insert(ugu.tlno,4,0,'-'),9,0,'-') as '전화번호'
from USED_GOODS_BOARD ugb join 
USED_GOODS_USER ugu on ugb.writer_id = ugu.user_id
group by ugu.user_id 
having count(ugu.user_id) >= 3
order by ugu.user_id desc;