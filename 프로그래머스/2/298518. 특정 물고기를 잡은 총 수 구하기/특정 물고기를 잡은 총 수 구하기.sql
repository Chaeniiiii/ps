select sum(parent.FISH_COUNT) as FISH_COUNT
from (
    select count(*) as FISH_COUNT
    from FISH_INFO fi join FISH_NAME_INFO fni on fi.FISH_TYPE = fni.FISH_TYPE
    where fni.FISH_NAME in ("BASS","SNAPPER")
    group by fni.FISH_NAME
) as parent;
