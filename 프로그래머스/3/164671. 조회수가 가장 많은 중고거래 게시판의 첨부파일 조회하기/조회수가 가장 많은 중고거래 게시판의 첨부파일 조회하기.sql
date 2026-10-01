with vw as (
    select board_id, 
        rank() over (order by VIEWS desc) rnk
    from USED_GOODS_BOARD
)

select concat('/home/grep/src/',board_id,'/',file_id,file_name,file_ext) 'file_path'
from USED_GOODS_FILE
where board_id in (
    select board_id
    from vw
    where rnk = 1
)
order by file_id desc;