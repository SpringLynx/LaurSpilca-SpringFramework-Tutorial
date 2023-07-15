### Database Connectivity

In this project we have discovered two ways to connect to our 
Database. 

We are using the Postgres to define our schema and to store the data.
   ## Schema

    -- Create the database
    --CREATE DATABASE schooldb;

    -- Create the 'students' table
    /*CREATE TABLE students (
    student_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE,
    gender VARCHAR(10),
    address VARCHAR(100),
    phone_number VARCHAR(15),
    email VARCHAR(50)
    );*/

    -- Create the 'teachers' table
    /*CREATE TABLE teachers (
    teacher_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE,
    gender VARCHAR(10),
    address VARCHAR(100),
    phone_number VARCHAR(15),
    email VARCHAR(50)
    );*/

    -- Create the 'courses' table
    /*CREATE TABLE courses (
    course_id SERIAL PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    teacher_id INT,
    CONSTRAINT fk_teacher_id FOREIGN KEY (teacher_id) REFERENCES teachers (teacher_id)
    );*/

    -- Create the 'enrollments' table
    /*CREATE TABLE enrollments (
    enrollment_id SERIAL PRIMARY KEY,
    student_id INT,
    course_id INT,
    enrollment_date DATE,
    CONSTRAINT fk_student_id FOREIGN KEY (student_id) REFERENCES students (student_id),
    CONSTRAINT fk_course_id FOREIGN KEY (course_id) REFERENCES courses (course_id)
    );*/

    -- Create the 'grades' table
    /*CREATE TABLE grades (
    grade_id SERIAL PRIMARY KEY,
    enrollment_id INT,
    grade DECIMAL(3, 2),
    CONSTRAINT fk_enrollment_id FOREIGN KEY (enrollment_id) REFERENCES enrollments (enrollment_id)
    );*/


    ALTER TABLE grades
    ALTER COLUMN grade TYPE DECIMAL(4, 2);
                                       
## DML

To add in some sample data in our database.

    -- Insert records into the 'students' table
    INSERT INTO students (first_name, last_name, date_of_birth, gender, address, phone_number, email)
    VALUES
        ('John', 'Doe', '2000-05-15', 'Male', '123 Main St', '555-1234', 'john.doe@example.com'),
        ('Jane', 'Smith', '2001-08-22', 'Female', '456 Oak Ave', '555-5678', 'jane.smith@example.com'),
        ('David', 'Johnson', '2002-03-10', 'Male', '789 Elm Rd', '555-9012', 'david.johnson@example.com');

    -- Insert records into the 'teachers' table
    INSERT INTO teachers (first_name, last_name, date_of_birth, gender, address, phone_number, email)
    VALUES
        ('Emily', 'Brown', '1985-09-03', 'Female', '321 Pine St', '555-1111', 'emily.brown@example.com'),
        ('Michael', 'Wilson', '1978-12-17', 'Male', '654 Cedar Ave', '555-2222', 'michael.wilson@example.com');

    -- Insert records into the 'courses' table
    INSERT INTO courses (course_name, description, teacher_id)
    VALUES
        ('Mathematics', 'Advanced mathematics course', 1),
        ('English Literature', 'Introduction to classic literature', 2);

    -- Insert records into the 'enrollments' table
    INSERT INTO enrollments (student_id, course_id, enrollment_date)
    VALUES
        (1, 1, '2022-09-01'),
        (2, 2, '2022-09-01'),
        (3, 1, '2022-09-01'),
        (3, 2, '2022-09-01');

    -- Insert records into the 'grades' table
    INSERT INTO grades (enrollment_id, grade)
    VALUES
        (1, 85.5),
        (2, 92.0),
        (3, 78.9),
        (4, 88.2);
                                  

I learned to connect the database using the @Bean annotation. 
But with the database credentials as part of the code.

And the other one is by using the database.properties file. 
The rest is all same, using @Bean annotation. But the connection
info is available in an external properties file. 

It gives us the ease of deployment or in case of any change to 
the credentials. Without touching the code we can easily manage
it in the properties file.