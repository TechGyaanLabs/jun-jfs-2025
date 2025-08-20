--SUBQUERIES (Questions 86-100)
-----------------------------

86. Find employees who earn more than the average salary.

select empno, ename, sal from emp where sal > (select avg(sal) from emp);



87. Get employees who work in departments with more than 3 employees.

select empno, ename, deptno from emp where deptno in (select deptno from emp group by deptno having count(*) > 3);



88. List employees who earn more than their departments average salary.

select empno, ename, sal, deptno from emp e where sal > (select avg(sal) from emp where deptno = e.deptno);



89. Find employees who have the same job as someone in department 20.

select empno, ename, job, deptno from emp where job in (select distinct job from emp where deptno = 20);



90. Get departments where all employees earn more than 1000.

select distinct deptno from emp e where not exists (select 1 from emp where deptno = e.deptno and sal <= 1000);



91. Find employees who earn more than their manager.

select e.empno, e.ename, e.sal, m.ename as manager, m.sal as manager_sal from emp e join emp m on e.mgr = m.empno where e.sal > m.sal;



92. List employees who work in the same department as the highest paid employee.

select empno, ename, deptno from emp where deptno = (select deptno from emp where sal = (select max(sal) from emp));


93. Get departments where the average salary is greater than 2000.

select deptno from emp group by deptno having avg(sal) > 2000;



94. Find employees who have the same salary as someone in a different department.

select empno, ename, sal, deptno from emp e1 where exists (select 1 from emp e2 where e1.sal = e2.sal and e1.deptno <> e2.deptno);



95. List employees who work in departments with no clerks.

select empno, ename, deptno from emp e where deptno in (select deptno from emp group by deptno having sum(case when job = 'CLERK' then 1 else 0 end) = 0);



96. Get employees who earn more than the average salary of their job category.

select empno, ename, job, sal from emp e where sal > (select avg(sal) from emp where job = e.job);



97. Find departments where all employees have the same job.

select deptno from emp group by deptno having count(distinct job) = 1;



98. List employees who work in the same location as employees in department 10.

select empno, ename, deptno from emp where deptno in (select deptno from dept  where loc = (select loc from dept where deptno = 10));



99. Get employees who have a higher salary than at least 3 other employees.

select empno, ename, sal from emp e1 where 3 <= (select count(*) from emp e2 where e2.sal < e1.sal);



100. Find employees who work in departments where the total salary is greater than 10000.

select empno, ename, deptno from emp where deptno in (select deptno from emp group by deptno having sum(sal) > 10000);

