--JOINS (Questions 56-75)
-----------------------

56. List all employees with their department names.

select e.empno,e.ename,d.dname from emp e join dept d on e.deptno = d.deptno;



57. Get employees with their manager names.

select e.empno, e.ename, m.ename from emp e left join emp m on e.mgr = m.empno;



58. Find all departments and their employee counts (including departments with no employees).

select d.deptno, d.dname, Count(e.empno) as emp_count from dept d left join emp e on d.deptno = e.deptno 
group by d.deptno, d.dname;



59. List employees with their department location.

select e.empno, e.ename, d.loc from emp e join dept d on e.deptno = d.deptno;



60. Get employees with their salary grade information.

select e.empno, e.ename, e.sal, s.grade from emp e join salgrade s on e.sal between s.losal and s.hisal;



61. Find all managers and the employees they manage.

select m.ename as manager, e.ename as employee from emp e join emp m on e.mgr = m.empno;



62. List employees with their department and manager information.

select e.empno, e.ename, d.dname, m.ename as manager from emp e join dept d on e.deptno = d.deptno 
left join emp m on e.mgr = m.empno;



63. Get departments with their highest paid employee.

select d.deptno, d.dname, e.ename, e.sal from dept d join emp e on d.deptno = e.deptno where e.sal=(select MAX(sal) from emp where deptno = d.deptno);



64. Find employees who work in the same location as their manager.

select e.empno, e.ename, d.loc from emp e join emp m on e.mgr = m.empno join dept d on e.deptno = d.deptno and m.deptno = d.deptno;



65. List all possible combinations of employees and departments.

select e.empno, e.ename, d.deptno, d.dname from emp e cross join dept d;



66. Get employees with their department and salary grade.

select e.empno, e.ename, d.dname, s.grade from emp e join dept d on e.deptno = d.deptno join salgrade s on e.sal between s.losal and s.hisal;



67. Find departments with their average employee salary.

select d.deptno, d.dname, AVG(e.sal) as avg_salary from dept d left join emp e on d.deptno = e.deptno group by d.deptno, d.dname;



68. List employees with their managers department.

select e.empno, e.ename, d.dname as manager_dept from emp e join emp m on e.mgr = m.empno join dept d on m.deptno = d.deptno;


69. Get employees with their department and location.

select e.empno, e.ename,d.dname, d.loc from emp e join dept d on e.deptno = d.deptno;



70. Find employees who work in the same department as their manager.

select e.empno, e.ename, e.deptno from emp e join emp m on e.mgr = m.empno where e.deptno = m.deptno;



71. List departments with their employee count and total salary.

select d.deptno, d.dname, Count(e.empno) as emp_count, SUM(e.sal) as total_sal from dept d left join emp e on d.deptno = e.deptno group by d.deptno, d.dname;



72. Get employees with their salary grade and department.

select e.empno, e.ename, d.dname, s.grade from emp e join dept d on e.deptno = d.deptno join salgrade s on e.sal between s.losal and s.hisal;



73. Find employees with their managers job title.

select e.empno, e.ename, m.job as managers_job from emp e join emp m on e.mgr = m.empno;



74. List employees with their department and commission.

select e.empno, e.ename, d.dname, e.comm from emp e join dept d on e.deptno = d.deptno;



75. Get departments with their highest and lowest paid employees.

select d.deptno, d.dname, MAX(e.sal) as max_salary ,MIN(e.sal) as min_salary
from dept d join emp e on d.deptno = e.deptno group by d.deptno, d.dname;