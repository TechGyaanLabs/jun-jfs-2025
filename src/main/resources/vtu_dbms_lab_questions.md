# VTU DBMS Lab Questions

## Lab 1: Database Creation and Basic SQL Commands

### 1.1 Create Database and Tables
```sql
-- Create a database named 'college_db'
CREATE DATABASE college_db;
USE college_db;

-- Create tables for Student, Course, and Faculty
CREATE TABLE student (
    student_id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT,
    gender CHAR(1),
    course_id INT,
    admission_date DATE
);

CREATE TABLE course (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    duration INT,
    fee DECIMAL(10,2)
);

CREATE TABLE faculty (
    faculty_id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    department VARCHAR(50),
    salary DECIMAL(10,2)
);
```

### 1.2 Insert Data
```sql
-- Insert sample data into tables
INSERT INTO course VALUES 
(1, 'Computer Science', 4, 50000.00),
(2, 'Information Science', 4, 45000.00),
(3, 'Electronics', 4, 48000.00);

INSERT INTO student VALUES 
(101, 'Rahul Kumar', 20, 'M', 1, '2023-06-15'),
(102, 'Priya Sharma', 19, 'F', 2, '2023-06-16'),
(103, 'Amit Patel', 21, 'M', 1, '2023-06-17');

INSERT INTO faculty VALUES 
(201, 'Dr. Rajesh Kumar', 'Computer Science', 75000.00),
(202, 'Prof. Sunita Devi', 'Information Science', 70000.00);
```

### 1.3 Basic SELECT Queries
```sql
-- 1. Display all students
SELECT * FROM student;

-- 2. Display student names and their course names
SELECT s.name, c.course_name 
FROM student s 
JOIN course c ON s.course_id = c.course_id;

-- 3. Count total number of students
SELECT COUNT(*) as total_students FROM student;

-- 4. Display students older than 20
SELECT * FROM student WHERE age > 20;
```

## Lab 2: Advanced SQL Queries

### 2.1 Aggregation Functions
```sql
-- 1. Find average age of students
SELECT AVG(age) as avg_age FROM student;

-- 2. Find maximum and minimum fees
SELECT MAX(fee) as max_fee, MIN(fee) as min_fee FROM course;

-- 3. Count students by gender
SELECT gender, COUNT(*) as count 
FROM student 
GROUP BY gender;

-- 4. Find total fee collected from all courses
SELECT SUM(fee) as total_fee FROM course;
```

### 2.2 JOIN Operations
```sql
-- 1. Inner Join - Students with their course details
SELECT s.student_id, s.name, c.course_name, c.fee
FROM student s
INNER JOIN course c ON s.course_id = c.course_id;

-- 2. Left Join - All courses with student count
SELECT c.course_name, COUNT(s.student_id) as student_count
FROM course c
LEFT JOIN student s ON c.course_id = s.course_id
GROUP BY c.course_id, c.course_name;

-- 3. Right Join - All students with faculty information
SELECT s.name, f.department
FROM student s
RIGHT JOIN faculty f ON s.course_id = f.faculty_id;
```

### 2.3 Subqueries
```sql
-- 1. Find students enrolled in courses with fee > 45000
SELECT * FROM student 
WHERE course_id IN (SELECT course_id FROM course WHERE fee > 45000);

-- 2. Find courses with more than average fee
SELECT * FROM course 
WHERE fee > (SELECT AVG(fee) FROM course);

-- 3. Find students older than average age
SELECT * FROM student 
WHERE age > (SELECT AVG(age) FROM student);
```

## Lab 3: Database Constraints and Indexes

### 3.1 Adding Constraints
```sql
-- Add foreign key constraint
ALTER TABLE student 
ADD CONSTRAINT fk_student_course 
FOREIGN KEY (course_id) REFERENCES course(course_id);

-- Add check constraint for age
ALTER TABLE student 
ADD CONSTRAINT chk_age CHECK (age >= 16 AND age <= 25);

-- Add unique constraint for student name
ALTER TABLE student 
ADD CONSTRAINT uk_student_name UNIQUE (name);

-- Add default value for admission date
ALTER TABLE student 
ALTER COLUMN admission_date SET DEFAULT CURRENT_DATE;
```

### 3.2 Creating Indexes
```sql
-- Create index on student name for faster searches
CREATE INDEX idx_student_name ON student(name);

-- Create composite index on course_id and admission_date
CREATE INDEX idx_student_course_date ON student(course_id, admission_date);

-- Create unique index on faculty email (assuming email column exists)
-- CREATE UNIQUE INDEX idx_faculty_email ON faculty(email);
```

## Lab 4: Views and Stored Procedures

### 4.1 Creating Views
```sql
-- Create view for student details with course information
CREATE VIEW student_course_view AS
SELECT s.student_id, s.name, s.age, c.course_name, c.fee
FROM student s
JOIN course c ON s.course_id = c.course_id;

-- Create view for course statistics
CREATE VIEW course_stats_view AS
SELECT c.course_name, 
       COUNT(s.student_id) as student_count,
       AVG(s.age) as avg_student_age,
       SUM(c.fee) as total_fee_collected
FROM course c
LEFT JOIN student s ON c.course_id = s.course_id
GROUP BY c.course_id, c.course_name;

-- Query the views
SELECT * FROM student_course_view;
SELECT * FROM course_stats_view;
```

### 4.2 Stored Procedures
```sql
-- Procedure to add new student
DELIMITER //
CREATE PROCEDURE AddStudent(
    IN p_student_id INT,
    IN p_name VARCHAR(50),
    IN p_age INT,
    IN p_gender CHAR(1),
    IN p_course_id INT
)
BEGIN
    INSERT INTO student(student_id, name, age, gender, course_id, admission_date)
    VALUES (p_student_id, p_name, p_age, p_gender, p_course_id, CURRENT_DATE);
    SELECT 'Student added successfully' as message;
END //
DELIMITER ;

-- Call the procedure
CALL AddStudent(104, 'Neha Singh', 20, 'F', 2);

-- Procedure to get students by course
DELIMITER //
CREATE PROCEDURE GetStudentsByCourse(IN p_course_id INT)
BEGIN
    SELECT s.*, c.course_name
    FROM student s
    JOIN course c ON s.course_id = c.course_id
    WHERE s.course_id = p_course_id;
END //
DELIMITER ;

-- Call the procedure
CALL GetStudentsByCourse(1);
```

## Lab 5: Triggers and Transactions

### 5.1 Creating Triggers
```sql
-- Create trigger to log student insertions
CREATE TABLE student_audit (
    audit_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    action VARCHAR(20),
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DELIMITER //
CREATE TRIGGER after_student_insert
AFTER INSERT ON student
FOR EACH ROW
BEGIN
    INSERT INTO student_audit(student_id, action)
    VALUES (NEW.student_id, 'INSERT');
END //
DELIMITER ;

-- Test the trigger
INSERT INTO student VALUES (105, 'Vikram Singh', 22, 'M', 3, '2023-06-18');
SELECT * FROM student_audit;
```

### 5.2 Transaction Management
```sql
-- Start transaction
START TRANSACTION;

-- Perform multiple operations
INSERT INTO course VALUES (4, 'Mechanical Engineering', 4, 52000.00);
INSERT INTO student VALUES (106, 'Anjali Verma', 20, 'F', 4, '2023-06-19');

-- Check if everything is correct
SELECT * FROM course WHERE course_id = 4;
SELECT * FROM student WHERE student_id = 106;

-- Commit the transaction
COMMIT;

-- Example of rollback
START TRANSACTION;
INSERT INTO course VALUES (5, 'Civil Engineering', 4, 50000.00);
-- If something goes wrong, rollback
ROLLBACK;
```

## Lab 6: Advanced SQL Features

### 6.1 Window Functions
```sql
-- Rank students by age within each course
SELECT s.name, s.age, c.course_name,
       RANK() OVER (PARTITION BY c.course_id ORDER BY s.age) as age_rank
FROM student s
JOIN course c ON s.course_id = c.course_id;

-- Calculate running total of fees
SELECT course_name, fee,
       SUM(fee) OVER (ORDER BY course_id) as running_total
FROM course;

-- Find students with age above average in their course
SELECT s.name, s.age, c.course_name,
       AVG(s.age) OVER (PARTITION BY c.course_id) as avg_course_age
FROM student s
JOIN course c ON s.course_id = c.course_id
WHERE s.age > (SELECT AVG(age) FROM student);
```

### 6.2 Common Table Expressions (CTEs)
```sql
-- CTE to find expensive courses
WITH expensive_courses AS (
    SELECT course_id, course_name, fee
    FROM course
    WHERE fee > (SELECT AVG(fee) FROM course)
)
SELECT s.name, ec.course_name, ec.fee
FROM student s
JOIN expensive_courses ec ON s.course_id = ec.course_id;

-- Recursive CTE for course hierarchy (if applicable)
WITH RECURSIVE course_hierarchy AS (
    SELECT course_id, course_name, 1 as level
    FROM course
    WHERE course_id = 1
    UNION ALL
    SELECT c.course_id, c.course_name, ch.level + 1
    FROM course c
    JOIN course_hierarchy ch ON c.course_id = ch.course_id + 1
    WHERE ch.level < 3
)
SELECT * FROM course_hierarchy;
```

## Lab 7: Database Design and Normalization

### 7.1 Create Normalized Tables
```sql
-- First Normal Form (1NF) - Atomic values
CREATE TABLE student_normalized (
    student_id INT PRIMARY KEY,
    first_name VARCHAR(25),
    last_name VARCHAR(25),
    age INT,
    gender CHAR(1),
    course_id INT,
    admission_date DATE
);

-- Second Normal Form (2NF) - Remove partial dependencies
CREATE TABLE student_course (
    student_id INT,
    course_id INT,
    enrollment_date DATE,
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES student_normalized(student_id),
    FOREIGN KEY (course_id) REFERENCES course(course_id)
);

-- Third Normal Form (3NF) - Remove transitive dependencies
CREATE TABLE department (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50),
    location VARCHAR(100)
);

ALTER TABLE faculty ADD COLUMN dept_id INT;
ALTER TABLE faculty ADD CONSTRAINT fk_faculty_dept 
FOREIGN KEY (dept_id) REFERENCES department(dept_id);
```

## Lab 8: Performance Tuning and Optimization

### 8.1 Query Optimization
```sql
-- Use EXPLAIN to analyze query execution
EXPLAIN SELECT s.name, c.course_name, f.name as faculty_name
FROM student s
JOIN course c ON s.course_id = c.course_id
JOIN faculty f ON c.course_id = f.faculty_id
WHERE s.age > 20;

-- Optimize with proper indexing
CREATE INDEX idx_student_age ON student(age);
CREATE INDEX idx_faculty_course ON faculty(course_id);

-- Use LIMIT for large result sets
SELECT * FROM student ORDER BY admission_date DESC LIMIT 10;

-- Avoid SELECT * in production
SELECT student_id, name, course_id FROM student WHERE age > 20;
```

### 8.2 Database Maintenance
```sql
-- Analyze table statistics
ANALYZE TABLE student, course, faculty;

-- Check table status
SHOW TABLE STATUS;

-- Optimize tables
OPTIMIZE TABLE student, course, faculty;

-- Check for unused indexes
SELECT 
    TABLE_NAME,
    INDEX_NAME,
    CARDINALITY
FROM information_schema.STATISTICS
WHERE TABLE_SCHEMA = 'college_db';
```

## Lab 9: Backup and Recovery

### 9.1 Database Backup
```sql
-- Create backup of database structure
-- mysqldump -u username -p --no-data college_db > college_db_structure.sql

-- Create backup of database with data
-- mysqldump -u username -p college_db > college_db_backup.sql

-- Create backup of specific tables
-- mysqldump -u username -p college_db student course > tables_backup.sql
```

### 9.2 Data Recovery
```sql
-- Restore database from backup
-- mysql -u username -p college_db < college_db_backup.sql

-- Restore specific tables
-- mysql -u username -p college_db < tables_backup.sql
```

## Lab 10: Final Project

### 10.1 Library Management System
```sql
-- Create comprehensive library database
CREATE DATABASE library_db;
USE library_db;

CREATE TABLE books (
    book_id INT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(100),
    isbn VARCHAR(13) UNIQUE,
    category VARCHAR(50),
    price DECIMAL(10,2),
    copies_available INT DEFAULT 1
);

CREATE TABLE members (
    member_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15),
    membership_date DATE,
    status ENUM('active', 'inactive') DEFAULT 'active'
);

CREATE TABLE borrowings (
    borrowing_id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT,
    member_id INT,
    borrow_date DATE,
    due_date DATE,
    return_date DATE NULL,
    fine_amount DECIMAL(10,2) DEFAULT 0.00,
    FOREIGN KEY (book_id) REFERENCES books(book_id),
    FOREIGN KEY (member_id) REFERENCES members(member_id)
);

-- Insert sample data and create comprehensive queries
-- This will test all the concepts learned in previous labs
```

## Additional Practice Questions

### SQL Interview Questions
1. What is the difference between DELETE and TRUNCATE?
2. Explain the difference between INNER JOIN and LEFT JOIN
3. What are the ACID properties in database transactions?
4. How do you handle NULL values in SQL?
5. What is the difference between WHERE and HAVING clause?

### Performance Questions
1. How would you optimize a slow-running query?
2. When would you use an index?
3. What is query execution plan?
4. How do you identify performance bottlenecks?

### Design Questions
1. Design a database for an e-commerce website
2. Design a database for a hospital management system
3. How would you handle database scaling?
4. Design considerations for high-traffic applications

## Notes for Students
- Always test your queries with sample data before running on production
- Use proper naming conventions for tables and columns
- Document your database design decisions
- Practice writing efficient queries
- Understand the business requirements before designing the database
- Learn to use database tools and IDEs effectively
