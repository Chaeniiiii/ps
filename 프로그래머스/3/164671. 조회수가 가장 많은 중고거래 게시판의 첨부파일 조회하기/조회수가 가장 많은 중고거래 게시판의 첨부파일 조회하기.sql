with view_cnt as (
    select bgb.board_id
    from USED_GOODS_BOARD bgb
    order by bgb.views desc
    limit 1
)

select concat('/home/grep/src/',ugf.board_id,'/',ugf.file_id,ugf.file_name,ugf.file_ext) as 'FILE_PATH'
from USED_GOODS_FILE ugf 
where ugf.board_id in (
    select board_id
    from view_cnt
)
order by ugf.file_id desc;