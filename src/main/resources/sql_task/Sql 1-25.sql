1. List all employees with salary greater than 2000.

select * from emp where sal>2000;



2. Find employees whose names start with 'S'.

select empno, ename from emp where ename like 'S%';



3. Get employees hired between 1981 and 1982.

select empno,ename,hiredate from emp where hiredate BETWEEN '1981-01-01' AND '1982-12-31';


4. List employees with NULL commission.

select empno,ename,comm  from emp where comm is null;


5. Find employees with salary between 1000 and 3000.

select * from emp where sal BETWEEN '1000' AND '3000';




6. Get employees whose names contain 'LL'.

select * from emp where ename like '%LL%';


7. List employees with salary not equal to 3000.

select empno,ename,sal from emp where sal <> 3000; 



8. Find employees hired after 1981-06-01.

select ename, hiredate from emp where hiredate > '1981-06-01';


9. Get employees with job 'MANAGER' or 'PRESIDENT'.

select empno, ename, job from emp where job in ('MANAGER', 'PRESIDENT');



10. List employees with salary greater than 2000 AND job is 'MANAGER'.

select empno, ename, job, sal from emp where  sal > 2000 and job='MANAGER';



11. Find employees whose names end with 'N'.

select empno, ename from emp  where ename like '%N';


12. Get employees with commission greater than 0.

select empno, ename, comm from emp where comm > '0';


13. List employees hired in the month of February.

select empno, ename, hiredate from emp where EXTRACT(month from hiredate) =2;



14. Find employees with salary less than 1500 OR greater than 3000.

select empno, ename, sal from emp where  sal < '1500' or sal > '3000';



15. Get employees whose names are exactly 4 characters long.

select empno, ename from emp where ename like '____';



16. List employees with salary greater than 2500 OR commission greater than 500.

select empno, ename, sal, comm from emp where sal > '2500' or comm > '500';



17. Find employees whose names dont start with 'S'.

select empno, ename from emp where ename NOT LIKE 'S%';



18. Get employees hired before 1981-06-01.

select empno, ename, hiredate from emp where hiredate < '1981-06-01';



19. List employees with salary equal to 3000.

select * from emp where sal = '3000';



20. Find employees with commission between 200 and 800.

select * from emp where comm between '200' and '800';



21. Get employees whose names contain exactly 2 'L' characters.

select * from emp where ename like '%LL%';



22. List employees with salary greater than 2000 AND less than 4000.

select * from emp where sal > '2000' and sal > '4000';



23. Find employees hired in the year 1981.

select empno, ename, hiredate from emp where extract (year from hiredate) = 1981;




24. Get employees with job 'CLERK' AND salary less than 1500.

select empno, ename, job, sal from emp where job = 'CLERK' and sal < '1500';



25. List employees with NULL manager.

select empno, ename, mgr from emp where mgr is null;

