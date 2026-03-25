# School Management System (Servlet + JDBC + Connection Pooling)

A Java web application built using Servlets and JDBC that manages Admin and Student data with secure login, CRUD operations, and connection pooling using HikariCP.

---

## Features

- Admin registration and login
- Student login and management
- CRUD operations for Admin and Student
- Secure session-based access control
- Connection pooling using HikariCP
- Sorting and filtering of records
- JSP-based UI with Servlets backend

---

## Tech Stack

- Language: Java
- Web Layer: Servlets (Jakarta EE)
- Frontend: JSP
- Database: PostgreSQL
- Connection Pooling: HikariCP
- Architecture: MVC (Servlet + DAO + Model)

---

## Project Structure

```
com.school/

    dao/
        Admin_Dao.java
        Student_Dao.java

    db/
        DB_Connection.java

    model/
        Admin.java
        Student.java

    servlet/
        AdminRegister.java
        (other servlets...)

webapp/
    views/
        *.jsp
```

---

## How It Works

- User interacts through JSP pages
- Servlets handle HTTP requests
- DAO layer communicates with the database using JDBC
- HikariCP manages connection pooling for performance
- Session is used for authentication and access control

---

## Admin Features

- Register admin
- Login admin
- View and manage admin records
- Update admin details
- Delete admin

---

## Student Features

- Login student
- View student details
- Update student information
- Delete student record
- Sort students by id, username, or age

---

## Key Functionalities

### Connection Pooling
- Implemented using HikariCP
- Efficient reuse of database connections
- Reduces the overhead of frequent DB connections

### Authentication
- Session-based login system
- Access restricted pages if not logged in

### Sorting
- Admin/Student lists can be sorted by:
  - ID
  - Username
  - Age

---

## Database Configuration

```
URL: jdbc:postgresql://localhost:5432/servlet_school
Username: postgres
Password: 123
```

---

## How to Run

1. Clone the repository
```
git clone https://github.com/your-username/servlet-school-system.git
```

2. Import project into Eclipse / IntelliJ

3. Configure PostgreSQL database:
   - Create database: servlet_school
   - Update DB credentials in DB_Connection.java

4. Deploy on Tomcat server

5. Run JSP pages via:
```
http://localhost:8080/project-name/views/admin_login
```

---

## Key Concepts Used

- Java Servlets (Jakarta EE)
- JSP (Java Server Pages)
- JDBC
- Connection Pooling (HikariCP)
- MVC Architecture
- Session Management
- DAO Pattern

---

## Learning Outcome

This project demonstrates:
- How Java web applications work internally
- How Servlets handle HTTP requests
- How connection pooling improves performance
- How MVC architecture separates concerns
- How JDBC integrates with web apps

---

## Author

https://github.com/arnabsarma-29
