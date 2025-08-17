--GROUP BY & AGGREGATE FUNCTIONS (Questions 26-45)
------------------------------------------------

26. Count the number of employees in each department.

select deptno, count(*) as emp_count from emp group by deptno;



27. Calculate the average salary for each job.

select job,AVG(sal) as avg_salary from emp group by job;



28. Find the total salary paid by each department.

select deptno, SUM(sal) as total_salary from emp group by deptno;



29. Get the maximum salary in each department.

select deptno, MAX(sal) as maximum_sal from emp group by deptno;



30. Count employees by job title.

select job, Count(*) as emp_count from emp group by job;



31. Calculate the sum of commission for each department.

select deptno, SUM(comm) as total_commission from emp group by deptno;



32. Find the minimum salary for each job.

select job, MIN(sal) as minimum_salary from emp group by job;



33. Get the average salary for each location.

select d.loc, AVG(e.sal) as average_salary from emp e join dept d on e.deptno = d.deptno  group by d.loc;



34. Count employees hired in each year.

select extract(year from hiredate) as hire_year, Count(*) as emp_count 
from emp group by extract(year from hiredate);



35. Calculate the total salary and commission for eachdepartment.

select deptno, SUM(sal + comm) as total_compensation from emp group by deptno; 



36. Find the highest paid employee in each department.

select e.ename, e.deptno, e.sal from emp e where e.sal = (select MAX(sal) from emp where deptno = e. deptno);



37. Get the average commission for each job.

select job,AVG(comm) as average_commission from emp group by job;



38. Count employees by salary grade.

select g.grade, Count(*) as emp_count from emp e join salgrade g on e.sal between g.losal and g.hisal group by g.grade;




39. Calculate the total salary for each location.


select d.loc, SUM(e.sal) as total_salary from emp e join dept d on e.deptno = d.deptno  group by d.loc;



40. Find the minimum commission for each department.

select deptno, MIN(comm) as minimum_commission from emp group by deptno;



41. Get the average salary for each manager.

select mgr, AVG(sal) as average_salary from emp  group by mgr;



42. Count employees by hire month.

select extract(month from hiredate) as  hire_month, Count(*) as emp_count
from emp group by extract(month from hiredate) order by hire_month;




43. Calculate the sum of salary for each job.

select job, SUM(sal) as total_salary from emp group by job;



44. Find the maximum commission for each department.

select deptno,MAX(comm) as maximum_commission from emp group by deptno;



45. Get the average salary for each location.

select d.loc, AVG(e.sal) as average_salary from emp e join dept d on e.deptno = d.deptno  group by d.loc;