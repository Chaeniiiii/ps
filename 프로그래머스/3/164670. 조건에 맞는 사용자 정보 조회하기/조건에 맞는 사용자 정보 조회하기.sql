select ugu.user_id,
    ugu.nickname,
    concat(ugu.city,' ',ugu.STREET_ADDRESS1,' ',ugu.STREET_ADDRESS2) as '전체주소',
    concat(substring(ugu.tlno,1,3),'-',substring(ugu.tlno,4,4),'-',substring(ugu.tlno,8,4)) as '전화번호'
from USED_GOODS_BOARD ugb join USED_GOODS_USER ugu on ugb.writer_id = ugu.user_id
group by ugb.writer_id
having count(*) >= 3
order by ugu.user_id desc;