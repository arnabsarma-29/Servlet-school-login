<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Admin</title>
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
        input[type="submit"] {
            background-color: #dc3545;
            color: white;
            border: none;
            padding: 12px 20px;
            cursor: pointer;
            border-radius: 5px;
        }
        input[type="submit"]:hover { background-color: #b02a37; }
        .cancel {
            background-color: #6c757d;
            margin-left: 10px;
            padding: 12px 20px;
            border-radius: 5px;
            color: white;
            text-decoration: none;
        }
        .cancel:hover { background-color: #5a6268; }
    </style>
</head>
<body>
<div class="container">
    <h2>Delete Admin</h2>
    <p>Are you sure you want to delete this admin?</p>
    <form method="post" action="<%= request.getContextPath() %>/views/admin_delete">
        <input type="hidden" name="id" value="<%= request.getAttribute("adminId") %>">
        <input type="submit" value="Delete">
        <a href="<%= request.getContextPath() %>/views/admin_details" class="cancel">Cancel</a>
    </form>
</div>
</body>
</html>