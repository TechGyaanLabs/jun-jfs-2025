--ORDER BY (Questions 46-55)
--------------------------

46. List all employees ordered by salary in descending order.

select empno,ename,sal from emp order by sal desc;



47. Get employees ordered by hire date (oldest first).

select empno,ename,hiredate from emp order by hiredate asc;



48. List employees by department, then by salary (highest first).

select empno,ename,deptno,sal from emp order by deptno asc, sal desc;



49. Get employees ordered by name alphabetically.

select empno, ename from emp order by ename  asc;



50. List employees by job, then by salary in descending order.

select empno, ename, job, sal from emp order by job desc, sal desc;



51. Order employees by department, then by name.

select empno, deptno, ename from emp  order by deptno asc, ename asc;



52. List employees by salary in ascending order.

select empno, ename, sal from emp order by sal asc;



53. Get employees ordered by hire date (newest first).

select empno, ename, hiredate from emp order by hiredate desc;



54. List employees by job, then by name alphabetically.

select empno, job, ename from emp order by job asc,ename asc;



55. Order employees by department, then by hire date.

select empno, ename, deptno, hiredate from emp order by deptno asc,hiredate asc;