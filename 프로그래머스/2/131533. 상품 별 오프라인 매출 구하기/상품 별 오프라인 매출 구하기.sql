select product.PRODUCT_CODE,sum(OFFLINE_SALE.SALES_AMOUNT*product.PRICE) as SALES
from product join offline_sale on product.product_id = offline_sale.product_id
group by product.product_id
order by sales desc, PRODUCT_CODE ;