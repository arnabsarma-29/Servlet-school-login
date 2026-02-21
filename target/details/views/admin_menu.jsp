<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Menu</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .menu-container {
            background: white;
            padding: 40px;
            border-radius: 10px;
            width: 420px;
            text-align: center;
            box-shadow: 0 8px 20px rgba(0,0,0,0.2);
        }

        h2 {
            margin-bottom: 25px;
        }

        a {
            display: block;
            margin: 12px 0;
            padding: 12px;
            background: #007BFF;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
            transition: 0.3s;
        }

        a:hover {
            background: #0056b3;
        }

        .danger {
            background: #dc3545;
        }

        .danger:hover {
            background: #b02a37;
        }

        .secondary {
            background: #6c757d;
        }

        .secondary:hover {
            background: #5a6268;
        }
    </style>
</head>

<body>
<div class="menu-container">

    <h2>Admin Menu</h2>

    <a href="<%= request.getContextPath() %>/views/admin_register">
        Register New Admin
    </a>

    <a href="<%= request.getContextPath() %>/views/admin_details">
        View All Admins
    </a>

    <a href="<%= request.getContextPath() %>/views/student_register">
        Register New Student
    </a>

    <a href="<%= request.getContextPath() %>/views/student_details">
        View All Students
    </a>

    <a href="<%= request.getContextPath() %>/views/logout" class="secondary">
        Logout
    </a>

</div>
</body>
</html>