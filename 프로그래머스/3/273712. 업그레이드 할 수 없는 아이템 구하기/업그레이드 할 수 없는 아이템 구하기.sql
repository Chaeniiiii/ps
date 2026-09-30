
select distinct(ii.item_id), ii.item_name, ii.rarity
from ITEM_INFO ii left join ITEM_TREE it on ii.item_id = it.parent_item_id
where it.item_id is null
order by ii.item_id desc;