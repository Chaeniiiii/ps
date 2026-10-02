with 
    milk as (
        select cart_id
        from cart_products 
        where name = 'Milk'
    ),
    yogurt as (
        select cart_id
        from cart_products 
        where name = 'Yogurt'
    )

select distinct(cart_id)
from milk
where cart_id in (
    select *
    from yogurt
)
order by cart_id;