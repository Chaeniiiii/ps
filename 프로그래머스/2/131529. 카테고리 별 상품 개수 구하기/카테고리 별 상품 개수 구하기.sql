select substring(PRODUCT_CODE,1,2) as CATEGORY , COUNT(*) as PRODUCTS
from product 
group by CATEGORY 
order by CATEGORY ;