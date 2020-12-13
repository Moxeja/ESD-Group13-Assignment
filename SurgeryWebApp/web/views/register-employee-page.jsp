<%-- 
    Document   : login-page
    Created on : 24-Nov-2020, 15:07:44
    Author     : Jake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Employee</title>
    </head>
    <body>
        <h1>Register a new Doctor or Nurse</h1>
        <h2><a href="index.html">Homepage</a></h2>
        <h2><a href="Dashboard">Dashboard</a></h2>
        <% 
            if (request.getAttribute("msg") != null) {
                out.print("<h3>" + request.getAttribute("msg") + "</h3><br>");
            }
        %>
        <form action="AddStaff" method="post">
            Username: <input type="text" name="username"><br>
            Password: <input type="password" name="password"><br><br>
            Full Name: <input type="text" name="name"><br>
            Address: <input type="text" name="address"><br>
            User Type: Doctor<input type="radio" name="type" value="doctor" checked>
            Nurse<input type="radio" name="type" value="nurse"><br><br>
            <input type="submit" value="Register">
        </form>
    </body>
</html>
