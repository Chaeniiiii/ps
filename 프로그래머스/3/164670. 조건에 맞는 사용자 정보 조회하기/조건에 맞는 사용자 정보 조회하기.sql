select 
    ub.writer_id,
    uu.nickname,
    concat(uu.city," ",uu.STREET_ADDRESS1," ",uu.STREET_ADDRESS2) as "전체주소",
    insert(insert(TLNO,4,0,"-"),9,0,"-") as "전화번호"
from USED_GOODS_BOARD ub join USED_GOODS_USER uu on ub.writer_id = uu.user_id
group by ub.writer_id
having count(ub.writer_id) >= 3
order by ub.writer_id desc;
