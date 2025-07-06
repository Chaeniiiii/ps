select b.category, sum(bs.sales) as total_sales
from book b join book_sales bs on b.book_id = bs.book_id
where SALES_DATE like '%2022-01%'
group by b.category
order by b.category;