select sales_date, product_id, user_id, sales_amount
from (
    select * from online_sale 
    where sales_date like '2022-03%'
    
    union all
    
    select offline_sale_id, null as user_id, product_id,sales_amount, sales_date
    from offline_sale
    where sales_date like '2022-03%'
) total
order by sales_date, product_id, user_id;