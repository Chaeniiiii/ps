select id, (
    select count(*)
    from ecoli_data
    where parent_id = ed.id
) as child_count
from ecoli_data ed;
