with may as (
    select product_id, amount
    from food_order
    where produce_date between '2022-05-01' and '2022-05-31'
)

select fp.product_id, fp.product_name, sum(fp.price * may.amount) 'total_sales'
from food_product fp join may on fp.product_id = may.product_id
group by fp.product_cd
order by total_sales desc , product_id ;
