<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            text-align: center;
            background: #fff;
            padding: 50px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
        }
        h1 {
            margin-bottom: 40px;
            color: #333;
        }
        .btn {
            display: inline-block;
            margin: 20px;
            padding: 15px 40px;
            font-size: 18px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            color: #fff;
            text-decoration: none;
            transition: background 0.3s;
        }
        .btn-admin {
            background: #007bff;
        }
        .btn-admin:hover {
            background: #0056b3;
        }
        .btn-student {
            background: #28a745;
        }
        .btn-student:hover {
            background: #1e7e34;
        }
    </style>
</head>
<body>
    <div class = "container">
        <h1>Welcome To School Info Web App</h1>
        <a href = "views/admin_login" class = "btn btn-admin">Admin</a>
        <a href = "views/student_login" class = "btn btn-student">Student</a>
    </div>
</body>
</html>