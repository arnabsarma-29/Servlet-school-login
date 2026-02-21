<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.school.model.Admin" %>

<%
    List<Admin> admin = (List<Admin>) request.getAttribute("admin");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Details</title>
    <style>
        body { font-family: Arial; background: #f0f2f5; display: flex; justify-content: center; padding-top: 30px; }
        .container { background: #fff; padding: 30px 40px; border-radius: 10px; box-shadow: 0 8px 20px rgba(0,0,0,0.2); width: 700px; }
        h2 { text-align: center; margin-bottom: 25px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { padding: 10px; border: 1px solid #ccc; text-align: center; }
        th { background-color: #007BFF; color: white; }
        th a { color: white; text-decoration: none; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        a.action { padding: 5px 10px; border-radius: 5px; color: white; text-decoration: none; }
        a.edit { background-color: #198754; }
        a.edit:hover { background-color: #146c43; }
        a.delete { background-color: #dc3545; }
        a.delete:hover { background-color: #b02a37; }
    </style>
</head>
<body>
<div class="container">
    <h2>Admin Details</h2>
    <table>
        <tr>
            <th><a href="?sort=id">ID</a></th>
            <th><a href="?sort=username">Name</a></th>
            <th>Actions</th>
        </tr>
        <%
            if(admin != null){
                for(Admin a : admin){
        %>
        <tr>
            <td><%= a.getId() %></td>
            <td><%= a.getUsername() %></td>
            <td>
                <a href="<%= request.getContextPath() %>/views/admin_edit?id=<%= a.getId() %>" class="action edit">Edit</a>
                <a href="<%= request.getContextPath() %>/views/admin_delete?id=<%= a.getId() %>" class="action delete">Delete</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</div>
</body>
</html>