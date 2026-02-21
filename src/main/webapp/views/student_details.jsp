<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.school.model.Student"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            background: #fff;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.2);
            width: 750px;
        }

        h2 {
            text-align: center;
            margin-bottom: 25px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: center;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .btn {
            padding: 6px 10px;
            border-radius: 4px;
            text-decoration: none;
            color: white;
            font-size: 14px;
        }

        .delete {
            background-color: #dc3545;
        }

        .edit {
            background-color: #198754;
        }

        .logout-btn {
            float: right;
            background: #dc3545;
            color: white;
            border: none;
            padding: 8px 15px;
            border-radius: 5px;
            cursor: pointer;
            margin-bottom: 15px;
        }

        .clearfix::after {
            content: "";
            clear: both;
            display: table;
        }
    </style>
</head>

<body>
<div class="container">

    <div class="clearfix">
        <form action="<%= request.getContextPath() %>/views/logout" method="get">
            <input type="submit" value="Logout" class="logout-btn">
        </form>
    </div>

    <h2>Student Details</h2>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Actions</th>
        </tr>

        <%
            List<Student> students = (List<Student>) request.getAttribute("students");
            if (students != null && !students.isEmpty()) {
                for (Student s : students) {
        %>
        <tr>
            <td><%= s.getId () %></td>
            <td><%= s.getUsername( ) %></td>
            <td><%= s.getAge () %></td>
            <td>
                <a class="btn edit"
                   href="<%= request.getContextPath() %>/views/student_edit?id=<%= s.getId() %>">
                    Edit
                </a>
                <a class="btn delete"
                   href="<%= request.getContextPath() %>/views/student_delete?id=<%= s.getId() %>">
                    Delete
                </a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="4">No students found</td>
        </tr>
        <%
            }
        %>
    </table>

</div>
</body>
</html>