/* Write your PL/SQL query statement below */
select max(salary) as SecondHighestSalary from Employee where salary < (select max(salary) from Employee);
