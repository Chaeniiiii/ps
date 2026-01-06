select concat('/home/grep/src/',
              ugb.BOARD_ID,
              '/',
              ugf.FILE_ID,
              ugf.FILE_NAME,
              ugf.FILE_EXT) as 'file_path'
from USED_GOODS_BOARD ugb 
    join USED_GOODS_FILE ugf 
    on ugb.BOARD_ID = ugf.BOARD_ID
WHERE ugb.VIEWS = (
    SELECT MAX(VIEWS)
    FROM USED_GOODS_BOARD
)
order by file_id desc;