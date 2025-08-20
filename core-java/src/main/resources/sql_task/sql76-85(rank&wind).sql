--RANK & WINDOW FUNCTIONS (Questions 76-85)
-----------------------------------------

76. Rank employees by salary within each department.

select empno, ename,deptno,sal, RANK() over (partition by deptno order by sal desc) as salary_rank from emp;




77. Get the top 3 highest paid employees in each department.

select empno, ename, deptno, sal from (select empno, ename, deptno,sal, dense_rank() over(partition by deptno order by sal desc) as rnk from emp)t where rnk<=3;



78. Find the salary rank of each employee within their job category.

select empno,ename,job,sal,rank() over (partition by job order by sal desc) as job_salary_rank from emp;+



79. Get employees with their salary percentile within their department.

select empno, ename, deptno, sal,percent_rank() OVER (partition by deptno order by sal desc) as salary_percentile from emp;


80. List employees with their cumulative salary within each department.

select empno, ename,deptno,sal, SUM(sal) over
(partition by deptno order by sal desc rows between UNBOUNDED preceding and current row)
as cummulative_salary from emp;


81. Rank employees by hire date within each department.

select empno, ename, deptno, hiredate, Rank() over (partition by deptno order by hiredate)
as hire_rank from emp;



82. Get the top 2 employees by salary in each job.



83. Find the commission rank of each employee within their department.

select empno, ename, deptno, comm, rank() over (partition by deptno order by comm desc)
as comm_rank from emp;


84. List employees with their running total salary within each job.


85. Get employees with their salary rank across all departments.

select empno, ename, deptno, sal, rank() over (order by sal desc)
as overall_salary_rank from emp;
