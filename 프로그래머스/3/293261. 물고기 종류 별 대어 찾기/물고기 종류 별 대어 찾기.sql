SELECT 
    fi.id,
    fni.fish_name,
    fi.length
FROM fish_info fi
JOIN (
    SELECT fish_type, MAX(length) AS max_length
    FROM fish_info
    GROUP BY fish_type
) m
ON fi.fish_type = m.fish_type
AND fi.length = m.max_length
JOIN fish_name_info fni
ON fi.fish_type = fni.fish_type
ORDER BY fi.id;
