select ii.ITEM_ID,ITEM_NAME
from ITEM_INFO ii
join ITEM_TREE it on ii.ITEM_ID = it.ITEM_ID
where PARENT_ITEM_ID is null
order by ii.ITEM_ID;