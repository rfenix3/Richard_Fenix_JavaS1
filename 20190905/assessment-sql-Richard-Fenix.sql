{\rtf1\ansi\ansicpg1252\cocoartf1671\cocoasubrtf600
{\fonttbl\f0\fnil\fcharset0 HelveticaNeue;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\deftab560
\pard\pardeftab560\slleading20\partightenfactor0

\f0\fs24 \cf0 -- =================\
--      northwind section\
\pard\pardeftab560\slleading20\pardirnatural\partightenfactor0
\cf0 -- =================\
\
use northwind;\
\
-- 1. What are the categories of products in the database?\
select distinct category from products;\
\
-- 2. What products are made by Dell?\
select * from products where product_name like 'Dell%';\
\
-- 3. List all the orders shipped to Pennsylvania.\
select * from orders where ship_state = 'Pennsylvania';\
\
-- 4. List the first name and last name of all employees with last names that start with w\
select * from employees where last_name like 'W%';\
\
-- 5. List all customers from zipcodes that start with 55\
select * from customers where postal_code like '55%';\
\
-- 6. List all customers from zipcodes that end with 0\
select * from customers where postal_code like '%0';\
\
-- 7. List the first name, last name, and email for all customers with a .org email address\
select first_name, last_name, email from customers where email like '%.org';\
\
-- 8. List the first name, last name, and phone number for all customers from the 202 area code\
select * from customers where phone like '%(202)%';\
\
-- 9. List the order id for each order placed by George Wilson\
SELECT \
    customers.id,\
    customers.first_name,\
    customers.last_name,\
    orders.id ORDER_ID,\
    orders.customer_id\
FROM\
    customers,\
    orders\
WHERE\
    customers.id = orders.customer_id\
        AND customers.first_name = 'George'\
        AND customers.last_name = 'Wilson';\
\
-- 10. List all the products and quantities associated with order 4003\
SELECT \
    products.product_name, products.quantity_per_unit, order_details.*\
FROM\
    products,\
    order_details\
WHERE\
    products.id = order_details.product_id and order_details.order_id = 4003;\
\
-- =================\
--       car_lot section\
-- =================\
\
-- 1. Add the following cars to inventory:\
-- 2012 Red Honda Accord\
-- 2017 Black Chevy Impala\
-- 2019 Siver Ford F-150\
-- 2020 White Subaru Outback\
-- 2015 Silver Ford Mustang\
-- 2018 Blue Honda Ridgeline\
-- 2017 Gray Chevy Silverado\
\
use car_lot;\
\
INSERT INTO car(id, model,make, model_year, color)\
VALUES (1, 'Accord', 'Honda', 2012, 'Red'), \
(2, 'Impala', 'Chevy', 2017, 'Black'),\
(3, 'F-150', 'Ford', 2019, 'Silver'), \
(4, 'Outback', 'Subaru', 2020, 'White'),\
(5, 'Mustang', 'Ford', 2015, 'Silver'), \
(6, 'Ridgeline', 'Honda', 2018, 'Blue'), \
(7, 'Silverado', 'Chevy', 2017, 'Gray');\
\
-- 2. Make the following updates to the database:\
-- Change all Hondas to Black\
-- Change 'Chevy' to 'Chevrolet'\
-- Change all 2020 model years to 2019\
\
select * from car;\
Update car set color = 'Black' where make = 'Honda';\
Update car set make = 'Chevrolet' where make = 'Chevy';\
Update car set year = 2020 where year = 2019;\
\
-- 3. Delete the following:\
-- Delete all blue inventory\
-- Delete all Fords\
-- Delete all cars from 2012 and 2017\
\
Delete from car where color='Blue';\
Delete from car where make='Ford';\
Delete from car where model_year between 2012 and 2017;\
}