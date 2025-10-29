select 
    ug.user_id, 
    ug.NICKNAME, 
    concat(CITY," " ,concat(ug.STREET_ADDRESS1," ",ug.STREET_ADDRESS2)) as '전체주소',
    insert(insert(ug.TLNO,4,0,'-'),9,0,'-') as '전화번호'
from USED_GOODS_BOARD ub join USED_GOODS_USER ug on ub.WRITER_ID = ug.USER_ID
group by ub.WRITER_ID
having count(ub.WRITER_ID) >= 3
order by ug.user_id desc;