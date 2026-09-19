select order_id, product_id, OUT_DATE, 
    case when OUT_DATE <= "2022_05-01" then "출고완료"
    when OUT_DATE > "2022_05-01" then "출고대기"
    else "출고미정" end as "출고여부"
from food_order
order by order_id;
