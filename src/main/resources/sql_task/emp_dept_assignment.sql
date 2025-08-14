-- Create salary grades table
CREATE TABLE salgrade (
    grade INTEGER PRIMARY KEY,
    losal DECIMAL(7,2),
    hisal DECIMAL(7,2)
);

-- Insert department data
INSERT INTO dept (deptno, dname, loc) VALUES
(10, 'ACCOUNTING', 'NEW YORK'),
(20, 'RESEARCH', 'DALLAS'),
(30, 'SALES', 'CHICAGO'),
(40, 'OPERATIONS', 'BOSTON');

-- Insert employee data
INSERT INTO emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES
(7369, 'SMITH', 'CLERK', 7902, '1980-12-17', 800.00, NULL, 20),
(7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600.00, 300.00, 30),
(7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', 1250.00, 500.00, 30),
(7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 2975.00, NULL, 20),
(7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 1250.00, 1400.00, 30),
(7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', 2850.00, NULL, 30),
(7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 2450.00, NULL, 10),
(7788, 'SCOTT', 'ANALYST', 7566, '1987-04-19', 3000.00, NULL, 20),
(7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 5000.00, NULL, 10),
(7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 1500.00, 0.00, 30),
(7876, 'ADAMS', 'CLERK', 7788, '1987-05-23', 1100.00, NULL, 20),
(7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 950.00, NULL, 30),
(7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3000.00, NULL, 20),
(7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300.00, NULL, 10);

-- Insert salary grade data
INSERT INTO salgrade (grade, losal, hisal) VALUES
(1, 700.00, 1200.00),
(2, 1201.00, 1400.00),
(3, 1401.00, 2000.00),
(4, 2001.00, 3000.00),
(5, 3001.00, 9999.00);

SCOTT DATABASE - 100 SQL PRACTICE QUESTIONS
===========================================

BASIC OPERATORS & FUNCTIONS (Questions 1-25)
--------------------------------------------

1. List all employees with salary greater than 2000.

2. Find employees whose names start with 'S'.

3. Get employees hired between 1981 and 1982.

4. List employees with NULL commission.

5. Find employees with salary between 1000 and 3000.

6. Get employees whose names contain 'LL'.

7. List employees with salary not equal to 3000.

8. Find employees hired after 1981-06-01.

9. Get employees with job 'MANAGER' or 'PRESIDENT'.

10. List employees with salary greater than 2000 AND job is 'MANAGER'.

11. Find employees whose names end with 'N'.

12. Get employees with commission greater than 0.

13. List employees hired in the month of February.

14. Find employees with salary less than 1500 OR greater than 3000.

15. Get employees whose names are exactly 4 characters long.

16. List employees with salary greater than 2500 OR commission greater than 500.

17. Find employees whose names don't start with 'S'.

18. Get employees hired before 1981-06-01.

19. List employees with salary equal to 3000.

20. Find employees with commission between 200 and 800.

21. Get employees whose names contain exactly 2 'L' characters.

22. List employees with salary greater than 2000 AND less than 4000.

23. Find employees hired in the year 1981.

24. Get employees with job 'CLERK' AND salary less than 1500.

25. List employees with NULL manager.

GROUP BY & AGGREGATE FUNCTIONS (Questions 26-45)
------------------------------------------------

26. Count the number of employees in each department.

27. Calculate the average salary for each job.

28. Find the total salary paid by each department.

29. Get the maximum salary in each department.

30. Count employees by job title.

31. Calculate the sum of commission for each department.

32. Find the minimum salary for each job.

33. Get the average salary for each location.

34. Count employees hired in each year.

35. Calculate the total salary and commission for each department.

36. Find the highest paid employee in each department.

37. Get the average commission for each job.

38. Count employees by salary grade.

39. Calculate the total salary for each location.

40. Find the minimum commission for each department.

41. Get the average salary for each manager.

42. Count employees by hire month.

43. Calculate the sum of salary for each job.

44. Find the maximum commission for each department.

45. Get the average salary for each location.

ORDER BY (Questions 46-55)
--------------------------

46. List all employees ordered by salary in descending order.

47. Get employees ordered by hire date (oldest first).

48. List employees by department, then by salary (highest first).

49. Get employees ordered by name alphabetically.

50. List employees by job, then by salary in descending order.

51. Order employees by department, then by name.

52. List employees by salary in ascending order.

53. Get employees ordered by hire date (newest first).

54. List employees by job, then by name alphabetically.

55. Order employees by department, then by hire date.

JOINS (Questions 56-75)
-----------------------

56. List all employees with their department names.

57. Get employees with their manager names.

58. Find all departments and their employee counts (including departments with no employees).

59. List employees with their department location.

60. Get employees with their salary grade information.

61. Find all managers and the employees they manage.

62. List employees with their department and manager information.

63. Get departments with their highest paid employee.

64. Find employees who work in the same location as their manager.

65. List all possible combinations of employees and departments.

66. Get employees with their department and salary grade.

67. Find departments with their average employee salary.

68. List employees with their manager's department.

69. Get employees with their department and location.

70. Find employees who work in the same department as their manager.

71. List departments with their employee count and total salary.

72. Get employees with their salary grade and department.

73. Find employees with their manager's job title.

74. List employees with their department and commission.

75. Get departments with their highest and lowest paid employees.

RANK & WINDOW FUNCTIONS (Questions 76-85)
-----------------------------------------

76. Rank employees by salary within each department.

77. Get the top 3 highest paid employees in each department.

78. Find the salary rank of each employee within their job category.

79. Get employees with their salary percentile within their department.

80. List employees with their cumulative salary within each department.

81. Rank employees by hire date within each department.

82. Get the top 2 employees by salary in each job.

83. Find the commission rank of each employee within their department.

84. List employees with their running total salary within each job.

85. Get employees with their salary rank across all departments.

SUBQUERIES (Questions 86-100)
-----------------------------

86. Find employees who earn more than the average salary.

87. Get employees who work in departments with more than 3 employees.

88. List employees who earn more than their department's average salary.

89. Find employees who have the same job as someone in department 20.

90. Get departments where all employees earn more than 1000.

91. Find employees who earn more than their manager.

92. List employees who work in the same department as the highest paid employee.

93. Get departments where the average salary is greater than 2000.

94. Find employees who have the same salary as someone in a different department.

95. List employees who work in departments with no clerks.

96. Get employees who earn more than the average salary of their job category.

97. Find departments where all employees have the same job.

98. List employees who work in the same location as employees in department 10.

99. Get employees who have a higher salary than at least 3 other employees.

100. Find employees who work in departments where the total salary is greater than 10000.
