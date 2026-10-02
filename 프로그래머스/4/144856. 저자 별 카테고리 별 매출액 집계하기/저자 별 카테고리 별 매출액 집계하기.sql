with jan as (
    select bs.book_id, book.author_id, book.category, book.price, bs.sales, bs.sales_date
    from book_sales bs join book on bs.book_id = book.book_id
    where bs.sales_date >= '2022-01-01' and bs.sales_date < '2022-02-01'
)

select author.AUTHOR_ID, author.AUTHOR_NAME, jan.category, sum(jan.price * jan.sales) 'TOTAL_SALES'
from jan join author on jan.AUTHOR_ID = author.AUTHOR_ID
group by AUTHOR.AUTHOR_ID, jan.category
order by author.AUTHOR_ID, jan.category desc;