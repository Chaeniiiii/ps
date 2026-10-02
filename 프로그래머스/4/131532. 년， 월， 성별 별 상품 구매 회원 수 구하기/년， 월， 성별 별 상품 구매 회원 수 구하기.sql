select year(os.sales_date) year,month(os.sales_date) month ,ui.gender, count(DISTINCT ui.user_id) users
from USER_INFO ui join ONLINE_SALE os on ui.user_id = os.user_id
where ui.gender is not null
group by year(os.sales_date),month(os.sales_date),ui.gender
order by year(os.sales_date),month(os.sales_date),ui.gender;