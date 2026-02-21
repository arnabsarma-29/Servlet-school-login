<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.school.model.Student" %>

<%
    Student student = (Student) request.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.2);
            width: 350px;
            text-align: center;
        }
        h2 { margin-bottom: 20px; }
        input[type="text"], input[type="number"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #198754;
            color: white;
            border: none;
            padding: 12px 20px;
            cursor: pointer;
            border-radius: 5px;
            width: 100%;
            margin-top: 15px;
        }
        input[type="submit"]:hover { background-color: #146c43; }
        .cancel {
            display: inline-block;
            margin-top: 10px;
            text-decoration: none;
            color: white;
            background-color: #6c757d;
            padding: 10px 20px;
            border-radius: 5px;
        }
        .cancel:hover { background-color: #5a6268; }
    </style>
</head>
<body>
<div class="container">
    <h2>Edit Student</h2>
    <form method="post" action="<%= request.getContextPath() %>/views/student_edit">
        <input type="hidden" name="id" value="<%= student.getId() %>">

        <input type="text" name="username" value="<%= student.getUsername() %>" placeholder="Username" required>
        <input type="number" name="age" value="<%= student.getAge() %>" placeholder="Age" required>
        <input type="password" name="password" placeholder="New Password" required>

        <input type="submit" value="Update">
    </form>

    <a class="cancel" href="<%= request.getContextPath() %>/views/student_details">Cancel</a>
</div>
</body>
</html>